package com.tab.af.web.pages.EBank;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.tab.af.web.pages.BasePage;

public class JournalAccess extends BasePage {

	@FindBy(xpath = "//span[text()='Accounting']")
	private WebElement lbl_Accounting; 
	@FindBy(xpath = "//span[text()='Journal Entry']")
	private WebElement lbl_JournalEntry;
	 
	@FindBy(xpath = "//span[text()='Add search condition']")
	private WebElement btn_AddSearchConditon;
	@FindBy(xpath = "//span[text()='Search']")
	private WebElement btn_Search;
	@FindBy(xpath = "//span[text()='Edit']")
	private WebElement btn_Edit; 
	@FindBy(xpath = "//span[text()='Remove']")
	private WebElement btn_Remove;
	@FindBy(xpath = "//span[text()='Create']")
	private WebElement btn_Create;
	@FindBy(xpath = "//span[text()='Excel']")
	private WebElement btn_Excel;
	@FindBy(xpath = "//div[text()='Journal Batch']")
	private WebElement btn_JournalBatch;
	public void verifyOptions() {
		try {
			webActions.waitUntilDisplayed(btn_Search, "Search button");
			Assert.assertEquals(true,  btn_Search.isDisplayed());
			Assert.assertEquals(true,  btn_Create.isDisplayed());
			Assert.assertEquals(true,  btn_Edit.isDisplayed());
			Assert.assertEquals(true,  btn_Remove.isDisplayed());
			Assert.assertEquals(true,  btn_AddSearchConditon.isDisplayed());
			Assert.assertEquals(true,  btn_Excel.isDisplayed());
			report.reportPass("All Options Displayed");

		} catch (Exception e) {
			report.reportHardFail("All Options Displayed");
		}
	}

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(btn_JournalBatch);
	}
}