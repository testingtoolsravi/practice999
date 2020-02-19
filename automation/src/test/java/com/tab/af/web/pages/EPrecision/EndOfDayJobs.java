package com.tab.af.web.pages.EPrecision;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.tab.af.web.pages.BasePage;

import junit.framework.Assert;

public class EndOfDayJobs extends BasePage {
	@FindBy(xpath = "//div[text()='End Of Day']")
	private WebElement lbl_EndOfDay; 
	@FindBy(xpath = "//span[text()='Balance Update' and contains(@class,'button')]")
	private WebElement btn_BalanceUpdate; 
	@FindBy(xpath = "//h1[text()='Update balance process started']")
	private WebElement lbl_BalanceUpdateMessage; 
	@FindBy(xpath = "//span[text()='Update Accounts' and contains(@class,'button')]")
	private WebElement btn_UpdateAccounts; 
	@FindBy(xpath = "//h1[text()='Update account process started']")
	private WebElement lbl_UpdateAccountsMessage; 
	@FindBy(xpath = "//div[text()='Card Number']//following::input[@type=\"text\"][1]")
	private WebElement txt_CardNumber; 
	@FindBy(xpath = "//span[text()='Add New Cards' and contains(@class,'button')]")
	private WebElement btn_AddNewCards; 
	@FindBy(xpath = "//h1[text()='New cards process started']")
	private WebElement lbl_AddNewCardsMessage; 
	@FindBy(xpath = "//span[text()='Update Cards']//following::div[text()='Start Date']//following::input[1]")
	private WebElement txt_UpdateCardsStartDate; 
	@FindBy(xpath = "//span[text()='Update Cards']//following::div[text()='End Date']//following::input[1]")
	private WebElement txt_UpdateCardsEndDate; 
	@FindBy(xpath = "//span[text()='Update Cards' and contains(@class,'button')]")
	private WebElement btn_UpdateCards; 
	@FindBy(xpath = "//h1[text()='Update card process started']")
	private WebElement lbl_UpdateCardsMessage; 
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(lbl_EndOfDay);
	}

	public void validateEndofDaysPageOptions() {
		try {
			Assert.assertEquals(true,btn_BalanceUpdate.isDisplayed());
			Assert.assertEquals(true,btn_UpdateAccounts.isDisplayed());
			Assert.assertEquals(true,txt_CardNumber.isDisplayed());
			Assert.assertEquals(true,btn_AddNewCards.isDisplayed());
			Assert.assertEquals(true,txt_UpdateCardsStartDate.isDisplayed());
			Assert.assertEquals(true,txt_UpdateCardsEndDate.isDisplayed());
			Assert.assertEquals(true,btn_UpdateCards.isDisplayed());
				 
			report.reportPass("All End of Days Options Displayed");

		} catch (Exception e) {
			report.reportHardFail("All End of Days Options Displayed");
		}
	}
	public void validateMessagesForAllOptions() {
		try {
			webActions.clickBYJS(btn_BalanceUpdate, "Balance Update");
			webActions.waitUntilDisplayed(lbl_BalanceUpdateMessage, "Balance Update Message");
			webActions.clickBYJS(btn_UpdateAccounts, "Update Accounts");
			webActions.waitUntilDisplayed(lbl_UpdateAccountsMessage, "Update Accounts Message");
			webActions.clickBYJS(btn_AddNewCards, "Add New Cards");
			webActions.waitUntilDisplayed(lbl_AddNewCardsMessage, "Add New Cards Message");
			webActions.clickBYJS(btn_UpdateCards, "Update Cards");
			webActions.waitUntilDisplayed(lbl_UpdateCardsMessage, "Update Cards Message");
				 
			report.reportPass("Validate Options Message ");

		} catch (Exception e) {
			report.reportHardFail("Validate Options Message ");
		}
	}
}

