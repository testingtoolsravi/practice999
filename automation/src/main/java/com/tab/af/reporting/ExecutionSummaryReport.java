package com.tab.af.reporting;

import com.rajatthareja.reportbuilder.ReportBuilder;
import com.tab.af.testbase.TestBase;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.presentation.PresentationMode;
import net.masterthought.cucumber.reducers.ReducingMethod;
import net.masterthought.cucumber.sorting.SortingMethod;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ExecutionSummaryReport {
	private static ExecutionSummaryReport executionSummaryReport;

	private ExecutionSummaryReport() {
	}

	public static ExecutionSummaryReport getExecutionSummaryReportObject() {
		if (executionSummaryReport == null) {
			executionSummaryReport = new ExecutionSummaryReport();
		}
		return executionSummaryReport;
	}

	public void generateMasterThoughtsSummary() { 
		List<String> list = new ArrayList();
		list.add("target/cucumber-reports/cucumber.json");
		String projectName = "Tab Bank";
		File reportOutputDirectory = new File("target");

		Configuration configuration = new Configuration(reportOutputDirectory, projectName);
		configuration.addPresentationModes(PresentationMode.EXPAND_ALL_STEPS);
		configuration.setBuildNumber((String) TestBase.props.get("build.version"));
		configuration.addClassifications("Execution Type", TestBase.props.getProperty("run.type"));
		configuration.addReducingMethod(ReducingMethod.HIDE_EMPTY_HOOKS);
		configuration.addPresentationModes(PresentationMode.EXPAND_ALL_STEPS);
		configuration.setSortingMethod(SortingMethod.NATURAL); 
		configuration.addClassifications("Environment", TestBase.props.getProperty("onboarding.env"));
		// List<String> confFiles = new ArrayList<String>();
		// confFiles.add(RootDir + "\\src\\main\\resources\\Config.properties");
		// configuration.addClassificationFiles(confFiles);

		net.masterthought.cucumber.ReportBuilder reportBuilder = new net.masterthought.cucumber.ReportBuilder(list,
				configuration);

		reportBuilder.generateReports();
	}

	public void generateReportBuilderSummary() {
		String path = System.getProperty("user.dir");
		ReportBuilder reportBuilder = new ReportBuilder();
		reportBuilder.setReportDirectory(path + "\\target\\SummaryReports\\");
//    Map<String, String> map = new HashMap<String, String>();
//    for (String key : TestBase.props.stringPropertyNames()) {
//      String value = TestBase.props.getProperty(key);
//      map.put(key, value.toString());
//    }
		// reportBuilder.setAdditionalInfo(map);
		reportBuilder.setReportFileName("Summary Report");
		reportBuilder.setReportTitle("Automation Execution Report");
		reportBuilder.disableVoiceControl();
		reportBuilder.setAdditionalInfo("Author", "Abhay");
		reportBuilder.setReportColor("#b0bec5 blue-grey lighten-5");

		 reportBuilder.setAdditionalInfo("Environment", TestBase.props.getProperty("onboarding.env"));
		List<Object> cucumberJsonReports = new ArrayList<>();
		// reportBuilder.enableVoiceControl();
		cucumberJsonReports.add(new File(path + "\\target\\cucumber-reports\\cucumber.json"));
		String newContent = "";
		reportBuilder.build(cucumberJsonReports);
		FileReader fr = null;
		try {
			File file = new File(path + "\\target\\SummaryReports\\Summary Report.html");
			fr = new FileReader(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}


        try (BufferedReader br = new BufferedReader(fr)) {

            StringBuilder content = new StringBuilder(1024);
			while ((newContent = br.readLine()) != null) {
				content.append(newContent);
			}
			// Removing Footer
			newContent = content.toString().replace(
					"<div class=\"container\">            Happy Reporting!            <a class=\"white-text text-lighten-4 right\" href=\"http://reportbuilderjava.rajatthareja.com\">Generated by Report Builder</a>        </div>",
                    "").replace("teal lighten-2", "teal lighten-5");
		} catch (IOException e) {

			e.printStackTrace();
		}

        try {
			FileWriter fw = new FileWriter(path + "\\target\\SummaryReports\\Summary Report.html");
			fw.write(newContent);
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new ExecutionSummaryReport().generateReportBuilderSummary();
	}

}