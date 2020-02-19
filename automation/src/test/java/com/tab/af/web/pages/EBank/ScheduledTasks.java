package com.tab.af.web.pages.EBank;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.tab.af.web.pages.BasePage;

public class ScheduledTasks extends BasePage {

	@FindBy(xpath = "//div[text()='Scheduled Tasks']")
	private WebElement lbl_ScheduledTasks;
	@FindBy(xpath = "//span[text()='Edit']")
	private WebElement btn_Edit; 
	@FindBy(xpath = "//span[text()='Add search condition']")
	private WebElement btn_AddSearchConditon;
	@FindBy(xpath = "//span[text()='Search']")
	private WebElement btn_Search;
	@FindBy(xpath = "//span[text()='Create']")
	private WebElement btn_Create;
	@FindBy(xpath = "//span[text()='Activate']")
	private WebElement btn_Activate;
	@FindBy(xpath = "//span[text()='Remove']")
	private WebElement btn_Remove;
	@FindBy(xpath = "//span[text()='Execution history']")
	private WebElement btn_ExecutionHistory;
	@FindBy(xpath = "//span[text()='=']//following::input[1]")
	private WebElement txt_SearchFilter; 
	 
	public void validateScheduledTaskPageOptions() {
		try {
			webActions.assertDisplayed(btn_Search, "Search Button");
			webActions.assertDisplayed(btn_AddSearchConditon, "Add Search Condtion Button");
			webActions.assertDisplayed(btn_Create, "Create Button");
			webActions.assertDisplayed(btn_Activate, "Activate Button");
			webActions.assertDisplayed(btn_Edit, "Edit Button");
			webActions.assertDisplayed(btn_Remove, "Remove Button");
			webActions.assertDisplayed(btn_ExecutionHistory, "Execution History Button");
			report.reportPass("Validate Scheduled Task Page Options");
		} catch (Exception e) {
			report.reportHardFail("Validate Scheduled Task Page Options");
		}
	}

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(lbl_ScheduledTasks);
	}
}