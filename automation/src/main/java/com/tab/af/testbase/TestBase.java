package com.tab.af.testbase;

import java.io.File;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.Capabilities;
import org.testng.IExecutionListener;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tab.af.cucumber.PickleEventWrapper;
import com.tab.af.cucumber.TestNGCucumberRunner;
import com.tab.af.engine.BrowserCapabilities;
import com.tab.af.engine.ConcurrentEngine;
import com.tab.af.reporting.ExecutionSummaryReport;
import com.tab.af.reporting.ExtentManager;
import com.tab.af.reporting.ExtentTestManager;
import com.tab.af.utilities.Grid;
import com.tab.af.utilities.JSONReader;

import cucumber.api.testng.CucumberFeatureWrapper;

@Listeners(TestBase.class)
public class TestBase implements IExecutionListener {

	public static Properties props;
	public static Properties apiProp;
	private String propertiesFile = "Config.properties";
	private String apiPropertiesFile = "api.properties";
	private boolean remoteExecution;
	private static String extentReport;
	private static String reportPath;
	private final String runType = "run.type";
	private String browser;
	private static String reportDirectoryName;
	private TestNGCucumberRunner testNGCukesRunner;
	private ExecutionSummaryReport executionSummaryReport = ExecutionSummaryReport.getExecutionSummaryReportObject();
	private static int totalSceanariosExecuted = 1;
	private static int numberOfIterationsCurrentSceanario = 1;
	private static String previousScenarioName = null;
	private BrowserCapabilities cap = new BrowserCapabilities();

	@Override
	public void onExecutionStart() {

		defaultOnExecutionStart();
	}

	public void defaultOnExecutionStart() {
		loadProperties();
		setUpExtent();
		if (props.getProperty(runType).equalsIgnoreCase("api")) {
			loadAPIProperties();
		}
	}

	public void loadProperties() {
		try {
			props = new Properties();
			InputStreamReader input = new InputStreamReader(
					getClass().getClassLoader().getResourceAsStream(propertiesFile));
			if (input != null)
				props.load(input);
		} catch (Exception e) {
			System.out.println("loadProperties There was a problem loading properties file.");
			e.printStackTrace();
		}
	}

	public void loadAPIProperties() {
		try {
			apiProp = new Properties();
			InputStreamReader input = new InputStreamReader(
					getClass().getClassLoader().getResourceAsStream(apiPropertiesFile));
			if (input != null)
				apiProp.load(input);
		} catch (Exception e) {
			System.out.println("loadProperties There was a problem loading properties file.");
			e.printStackTrace();
		}
	}

	public void setUpExtent() {
		if (props.getProperty("extent.report").equals("true")) {
			reportDirectoryName = props.getProperty("report.directory.windows");
			reportPath = new File(System.getProperty("user.dir")) + reportDirectoryName;
			String fullPath = reportPath;
			File screenshotDirectory = new File(fullPath);

			screenshotDirectory.mkdirs();

		}
	}

	@BeforeClass
	public void beforeClass(ITestContext context) throws Exception {
		if (!props.getProperty(runType).equalsIgnoreCase("api")) {
			setRemoteExecution();
		}
		testNGCukesRunner = new TestNGCucumberRunner(context, this.getClass());
	}

	public void setRemoteExecution() throws UnknownHostException {
		if (props.getProperty(runType).equalsIgnoreCase("grid"))
			remoteExecution = true;
		if (remoteExecution == true) {
			Grid initializeGrid = new Grid();
			props.setProperty("grid.url", initializeGrid.startGrid(props.getProperty("grid.port.number")));
		}
	}

	@BeforeMethod
	public void beforeMethod(ITestContext context, Method method) throws Exception {
		try {

			engineSetUp(context);
		} catch (Exception e) {
			throw e;
		}
	}

	protected void engineSetUp(ITestContext context) throws Exception {
		setTestParameters(context);
		if (!props.getProperty(runType).equalsIgnoreCase("api")) {
			Capabilities caps = cap.getCapabilities(browser);
			ConcurrentEngine.createEngine(caps, browser, remoteExecution);
		}
	}

	@Test(groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
	public void runScenario(PickleEventWrapper pickleWrapper, CucumberFeatureWrapper featurewrapper) throws Throwable {
		try {

			String featureFileTopTag = pickleWrapper.getPickleEvent().pickle.getTags().get(0).getName();
			String currentScenarioName = pickleWrapper.getPickleEvent().pickle.getName();

			if (totalSceanariosExecuted == 1) {
				previousScenarioName = currentScenarioName;
				reportSetup(currentScenarioName);
				assignReportTag(featureFileTopTag);
			} else if (!currentScenarioName.equals(previousScenarioName)) {
				previousScenarioName = currentScenarioName;
				numberOfIterationsCurrentSceanario = 1;
				reportSetup(currentScenarioName);
				assignReportTag(featureFileTopTag);
			}

			reportNodeSetup("Iteration: " + numberOfIterationsCurrentSceanario);

			numberOfIterationsCurrentSceanario = numberOfIterationsCurrentSceanario + 1;
			totalSceanariosExecuted = totalSceanariosExecuted + 1;

			testNGCukesRunner.runScenario(pickleWrapper.getPickleEvent());

		} catch (Exception e) {
			numberOfIterationsCurrentSceanario = numberOfIterationsCurrentSceanario + 1;
			ExtentTestManager.getTest().fail(e);
			e.printStackTrace();
			throw e;
		}
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestResult result) throws Throwable {

		driverTearDown();

		flushExtentManager();
		
	}

	public void driverTearDown() {
		ConcurrentEngine.destroyEngine();
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		testNGCukesRunner.finish();
		
	}

	@AfterSuite
	public final void afterSuite() throws Exception {
		
	}

	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return testNGCukesRunner.provideScenarios();
	}

	@Override
	public void onExecutionFinish() {

		executionSummaryReport.generateMasterThoughtsSummary();
		executionSummaryReport.generateReportBuilderSummary();
		if (!props.getProperty(runType).equalsIgnoreCase("api")) {
			 
			JSONReader.flushTestDataToJSON();
		}
		System.out.println("Finished at " + new SimpleDateFormat("yyy_MM-dd HH:mm:ss").format(new Date()));

	}

	private void setTestParameters(ITestContext context) {
		browser = System.getProperty("browser");
		Map<String, String> allParameters = context.getCurrentXmlTest().getAllParameters();
		for (Map.Entry<String, String> entry : allParameters.entrySet()) {
			if (entry.getKey().equals("browser")) {
				browser = entry.getValue();
			}
		}
	}

	public void flushExtentManager() {
		if (extentReport.equalsIgnoreCase("true")) {
			if (ExtentManager.getInstance() != null)
				ExtentManager.getInstance().flush();
		}
	}

	public void reportSetup(String currentScenarioName) {
		extentReport = props.getProperty("extent.report");
		if (extentReport.equalsIgnoreCase("true")) {
			ExtentManager.getInstance(reportDirectoryName);
			ExtentTestManager.createTest("Scenario: " + currentScenarioName + browser);
		}
	}

	public void reportNodeSetup(String nodeName) {
		if (extentReport.equalsIgnoreCase("true")) {
			ExtentTestManager.createNode(nodeName);
		}
	}

	public void assignReportTag(String featureFileTopTag) {
		ExtentTestManager.assignCategory(ExtentTestManager.getParentTest(), featureFileTopTag);
	}

}
