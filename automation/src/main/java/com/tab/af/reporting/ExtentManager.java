package com.tab.af.reporting;

import java.io.File;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

  private static ExtentHtmlReporter htmlReporter;
  private static ExtentReports extent; 
  public static String reportPath, reportDirectoryName, reportFileName, applicationName;

  public synchronized static ExtentReports getInstance(String directoryName) { 
	  int itr=0;
    reportDirectoryName = "\\reports";
    reportFileName = "execution-report";
    applicationName = "Tab Bank";
    reportPath = new File(System.getProperty("user.dir")) + reportDirectoryName;
    if (extent == null) {
    	String fullName=reportPath + "\\" + reportFileName + ".html";
    	File tmpDir = new File(fullName);
    	while(tmpDir.exists())
    	{
    		itr++;
    		fullName =reportPath + "\\" + reportFileName +"("+itr+")"+ ".html";
    		 tmpDir = new File(fullName);
    		if(!tmpDir.exists())
    		{
    			break;
    		}
    	}
      htmlReporter = new ExtentHtmlReporter(fullName);
      extent = new ExtentReports();
      extent.attachReporter(htmlReporter); 
      extent.setSystemInfo("Run Platform", "Winodws");
      extent.setSystemInfo("Environment", "QA"); 
      extent.setAnalysisStrategy(AnalysisStrategy.TEST);
      
      htmlReporter.config().setDocumentTitle(applicationName + " Execution Test Report");
      htmlReporter.config().setReportName(reportFileName);
      htmlReporter.config().setTheme(Theme.DARK); 
      
    }
    return extent;
  }

  public synchronized static ExtentReports getInstance() {
    return extent;
  }
}
