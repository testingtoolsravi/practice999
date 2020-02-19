package com.tab.af.api.runners;

import java.io.IOException;
import com.aventstack.extentreports.Status;
import com.tab.af.reporting.ExtentTestManager;
import com.tab.af.testbase.TestBase;
import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

@CucumberOptions(features = { "src/test/resources/features" }, glue = { "com.tab.af.api",
		"com.tab.af.testbase" }, monochrome = true,plugin =  {
"json:target/cucumber-reports/cucumber.json","rerun:target/APIRerun.txt"  }  

)
public class APITestRunner extends TestBase {

	@Before
	public void before(Scenario scenario) throws Exception {
    
	}

	@After
	public void after(Scenario scenario) throws IOException {
		if (scenario.isFailed()) {
		 
			ExtentTestManager.getTest().log(Status.FAIL, scenario.getName());

		} else {
			ExtentTestManager.getTest().log(Status.PASS, scenario.getName());
		}
	}

}
