package com.tab.af.web.runners;

import java.io.IOException;

import org.openqa.selenium.OutputType;

import com.aventstack.extentreports.Status;
import com.tab.af.engine.ConcurrentEngine;
import com.tab.af.reporting.ExtentTestManager;
import com.tab.af.testbase.TestBase;

import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

@CucumberOptions(features = { "src/test/resources/features" }, glue = { "com.tab.af.web",
		"com.tab.af.testbase" }, plugin =  {
				"pretty", "html:target/cucumber","json:target/cucumber-reports/cucumber.json", "rerun:target/WebRerun.txt" }  

)
public class WebTestRunner extends TestBase {

	@Before
	public void before(Scenario scenario) throws Exception {

	}

	@After
	public void after(Scenario scenario) throws IOException {
		if (scenario.isFailed()) {
			byte[] bytes = (ConcurrentEngine.getEngine().getWebDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.embed(bytes, "image/png");
			ExtentTestManager.getTest().log(Status.FAIL, scenario.getName());

		} else {
			ExtentTestManager.getTest().log(Status.PASS, scenario.getName());
		}
	}

}
