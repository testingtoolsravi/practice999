package com.tab.af.web.pages.EPrecision;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.tab.af.web.pages.BasePage;

import junit.framework.Assert;

public class Ping extends BasePage {
	@FindBy(xpath = "//div[text()='Connection Tests']")
	private WebElement lbl_ConnectionTests;
	@FindBy(xpath = "//span[text()='PING SONIC']")
	private WebElement btn_PingSonic;
	@FindBy(xpath = "//span[text()='Test Account Inquiry']")
	private WebElement btn_TestAccountInquiry;
	@FindBy(xpath = "//span[text()='Test Accrual Date']")
	private WebElement btn_TestAccrualDate; 
	@FindBy(xpath = "//span[text()='Direct Query Precision']")
	private WebElement btn_DirectQueryPrecision; 
	@FindBy(xpath = "//h1[contains(text(),'Sonic System is UP : ')]")
	private WebElement lbl_SonicPingSystemUpMessage; 
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(lbl_ConnectionTests);
	}

	public void validateOptions() {
		try {

			Assert.assertEquals(true, btn_PingSonic.isDisplayed());
			Assert.assertEquals(true, btn_TestAccountInquiry.isDisplayed());
			Assert.assertEquals(true, btn_TestAccrualDate.isDisplayed());
			Assert.assertEquals(true, btn_DirectQueryPrecision.isDisplayed());
			report.reportPass("Validate Ping Options");
		} catch (Exception e) {
			report.reportHardFail("Validate Ping Options");
		}
	}

	public void clickPingSonicButton() {
		try {

			webActions.waitAndCickBYJS(btn_PingSonic, "Ping Sonic"); 
			report.reportPass("Click Ping Sonic");
		} catch (Exception e) {
			report.reportHardFail("Click Ping Sonic");
		}
	}
	public void validateSonicPingSystemUpMessage()
	{
		try {

			webActions.waitUntilDisplayed(lbl_SonicPingSystemUpMessage, "Sonic Ping System Up Message") ;
			report.reportPass("Sonic Ping Test Success");
		} catch (Exception e) {
			report.reportHardFail("Sonic Ping Test Success");
		}
	}
}
