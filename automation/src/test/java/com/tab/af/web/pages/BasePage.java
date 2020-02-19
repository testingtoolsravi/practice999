package com.tab.af.web.pages;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tab.af.actions.ShadowActions;
import com.tab.af.actions.WebActions;
import com.tab.af.engine.ConcurrentEngine;
import com.tab.af.reporting.ReportLibrary;
import com.tab.af.testbase.TestBase;
import com.tab.af.utilities.JSONReader;

public abstract class BasePage<T> {

	private static ConcurrentHashMap<Long, Map<String, String>> testDataMap = new ConcurrentHashMap<Long, Map<String, String>>();

	/**
	 * Returns the Map Associated with the Current Thread and to Store the Data for
	 * the test Associated with Current Thread
	 * 
	 * @return dataMap<String,String>
	 */
	public Map<String, String> getTestDataMap() {
		return testDataMap.get(Thread.currentThread().getId());
	}

	public void setTestDataMap(Map<String, String> map) {
		testDataMap.put(Thread.currentThread().getId(), map);
	}

	private static ConcurrentHashMap<Long, Map<String, Map<String, String>>> applicant = new ConcurrentHashMap();

	/**
	 * Store Test Data For Multipel Applicants
	 * 
	 * @return
	 */
	public Map<String, String> getApplicant(String applicantNo) {
		if (applicant.containsKey(Thread.currentThread().getId())) {
			Map<String, Map<String, String>> map = applicant.get(Thread.currentThread().getId());
			return map.get(applicantNo);
		} else {
			return null;
		}

	}

	/**
	 * Set Test Data for Multiple Applicant
	 * 
	 * @param map
	 */
	public void setApplicant(String applicantNo, Map  map) {
		Map<String, Map<String, String>> hmap= new HashMap<String, Map<String,String>>();
		if (applicant.containsKey(Thread.currentThread().getId())) {
			  hmap =applicant.get(Thread.currentThread().getId()); 
			hmap.put(applicantNo, map);
		}
		else {
			hmap.put(applicantNo, map);
			applicant.put(Thread.currentThread().getId(),hmap);
		}
	}

	protected WebDriver driver;
	public WebActions webActions = ConcurrentEngine.getEngine().getWebActions();
	public ReportLibrary report = ConcurrentEngine.getEngine().getReportLibrary();
	private final long PAGE_LOAD_TIMEOUT = Long.parseLong(TestBase.props.getProperty("page.load.wait"));
	public JSONReader json = new JSONReader();
	public Globals global = new Globals();
	public ShadowActions shadow = ConcurrentEngine.getEngine().getShadowActions();

	public BasePage() {
		this.driver = ConcurrentEngine.getEngine().getWebDriver();
	}

	public T base(Class<T> objectClass) {
		T page = null;
		try {
			page = PageFactory.initElements(ConcurrentEngine.getEngine().getWebDriver(), objectClass);
			ExpectedCondition pageLoadCondition = ((BasePage) page).getPageLoadCondition();
			waitForPageToLoad(pageLoadCondition);
		} catch (TimeoutException e) {
			// To Shorten the Message in the Summary Report
			report.reportFail("Scenario Failed on Page : " + objectClass.getClass().getCanonicalName()
					+ shortenedStackTrace(e, 1));

		}
		return page;
	}

	private void waitForPageToLoad(ExpectedCondition<?> pageLoadCondition) {
		WebDriverWait wait = new WebDriverWait(driver, PAGE_LOAD_TIMEOUT);
		wait.until(pageLoadCondition);
	}

	protected abstract ExpectedCondition getPageLoadCondition();

	private String shortenedStackTrace(Exception e, int maxLines) {
		StringWriter writer = new StringWriter();
		e.printStackTrace(new PrintWriter(writer));
		String[] lines = writer.toString().split("\n");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < Math.min(lines.length, maxLines); i++) {
			sb.append(lines[i]).append("\n");
		}

		return sb.toString();
	}

	/**
	 * Common Elements Across UI
	 */
	public WebElement btn_Add() {
		return webActions.findWebElementByText("Add");
	}

	public WebElement btn_Select() {
		return webActions.findWebElementByText("Select");
	}

	public WebElement btn_View() {
		return webActions.findWebElementByText("View");
	}

	@FindBy(xpath = "//span[text()='Save']")
	private WebElement btn_Save;

	public void clickSaveButton() {
		webActions.clickBYJS(btn_Save, "Save button");
	}
}