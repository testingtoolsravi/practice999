package com.tab.af.web.pages.EPrecision;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.tab.af.web.pages.BasePage;

import junit.framework.Assert;

public class Precision extends BasePage {
	@FindBy(xpath = "//span[text()='Sonic']")
	private WebElement lbl_Sonic;
	@FindBy(xpath = "//span[text()='Ping']")
	private WebElement lbl_Ping;
	@FindBy(xpath = "//span[text()='Product Templates']")
	private WebElement lbl_ProductTemplates;
	@FindBy(xpath = "//span[text()='Object']")
	private WebElement lbl_Object;
	@FindBy(xpath = "//span[text()='Maintenance']")
	private WebElement lbl_Maintenance;

	 
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(lbl_Sonic);
	}

	public void validatePrecisionDropDownOptions() {
		try {
			Assert.assertEquals(true, lbl_Sonic.isDisplayed());
			Assert.assertEquals(true, lbl_Ping.isDisplayed());
			webActions.clickAction(lbl_Sonic, "Sonic");
			Assert.assertEquals(true, lbl_ProductTemplates.isDisplayed());
			Assert.assertEquals(true, lbl_Object.isDisplayed());
			Assert.assertEquals(true, lbl_Maintenance.isDisplayed()); 
			report.reportPass("Precision Dropdown Options Displayed");

		} catch (Exception e) {
			report.reportHardFail("Precision Dropdow Options Displayed");
		}
	}
}
