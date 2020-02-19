package com.tab.af.web.pages.EPrecision;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.tab.af.web.pages.BasePage;

import junit.framework.Assert;

public class CifEntity extends BasePage {
	@FindBy(xpath = "//div[text()='Cif Entity']")
	private WebElement lbl_CifEntity;
	@FindBy(xpath = "//div[@class=\"v-table-header\"]//div[contains(@class,\"v-table-caption-container\")and text()='Branch']")
	private WebElement lbl_TableHeaderBranch;
	@FindBy(xpath = "//div[@class=\"v-table-header\"]//div[contains(@class,\"v-table-caption-container\")and text()='Internet banking']")
	private WebElement lbl_TableHeaderInternetBanking;
	@FindBy(xpath = "//div[@class=\"v-table-header\"]//div[contains(@class,\"v-table-caption-container\")and text()='Internet banking2']")
	private WebElement lbl_TableHeaderInternetBanking2;
	@FindBy(xpath = "//span[text()='Create']")
	private WebElement btn_Create;
	@FindBy(xpath = "//span[text()='OK']")
	private WebElement btn_OK;
	@FindBy(xpath = "//span[text()='Edit']")
	private WebElement btn_Edit;
	@FindBy(xpath = "//span[text()='Remove']")
	private WebElement btn_Remove;
	@FindBy(xpath = "//span[text()='Search']")
	private WebElement btn_Search;
	@FindBy(xpath = "//span[text()='Add search condition']")
	private WebElement btn_AddSeachCondition;
	@FindBy(xpath = "//div[text()='Branch']//following::input[1]")
	private WebElement txt_Branch;
	@FindBy(xpath = "//div[text()='Internet Banking']//following::input[1]")
	private WebElement txt_InternetBanking;
	@FindBy(xpath = "//div[text()='Internet Banking2']//following::input[1]")
	private WebElement txt_InternetBanking2;
	@FindBy(xpath = "//td[2]//div[@class=\"v-table-cell-wrapper\"]")
	private WebElement lbl_TableColumnOne;
	@FindBy(xpath = "//tr[1]//td[@class=\"v-table-cell-content\"]//div")
	private List<WebElement> lbl_TableNewCreatedEntity;
	
	@FindBy(xpath = "//div[contains(@class,'paging')]//div[contains(text(),'row')]")
	private WebElement lbl_RowCount;
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(lbl_CifEntity);
	}

	public void validateCIfEntityOptionsTable() {
		try {
			Assert.assertEquals(true, lbl_TableHeaderBranch.isDisplayed());
			Assert.assertEquals(true, lbl_TableHeaderInternetBanking.isDisplayed());
			Assert.assertEquals(true, lbl_TableHeaderInternetBanking2.isDisplayed());
			report.reportPass("Table Headers Displayed");

		} catch (Exception e) {
			report.reportHardFail("Table Headers Displayed");
		}
	}

	public void createCIFEntity(String iBFlag,String iB2Flag,String branchName) {
		try {
			webActions.clickBYJS(btn_Create, "Create");
			webActions.waitAndSendKeysByCharAuto(txt_Branch,branchName, "Branch");
			webActions.waitAndSendKeysByChar(txt_InternetBanking, iBFlag, "Internet Banking");
			webActions.waitAndSendKeysByChar(txt_InternetBanking2, iB2Flag, "Internet Banking2");
			
			webActions.clickBYJS(btn_OK, "OK"); 
			webActions.waitForClickAbility(lbl_TableColumnOne, "Wait for Table to Load");
			Assert.assertEquals(lbl_TableNewCreatedEntity.get(0).getText(), branchName);
			Assert.assertEquals(lbl_TableNewCreatedEntity.get(1).getText(), iBFlag);
			Assert.assertEquals(lbl_TableNewCreatedEntity.get(2).getText(), iB2Flag);
			report.reportPass("Create CIF Entity");
		} catch (Exception e) {
			report.reportHardFail("Create CIF Entity");
		}
	}
	public void editCIFEntity(String iB2Flag) {
		try {
			webActions.waitAndCickBYJS(btn_Edit, "Edit Button");
			webActions.waitUntilDisplayed(txt_InternetBanking2, "Internet Banking 2");
			webActions.clearByJS(txt_InternetBanking2, "Internet Banking 2");
			webActions.waitAndSendKeysByChar(txt_InternetBanking2, iB2Flag, "Internet Banking2");
			webActions.clickBYJS(btn_OK, "OKs");
			webActions.waitUntilDisplayed(btn_Create, "Create"); 
			Assert.assertEquals(lbl_TableNewCreatedEntity.get(2).getText(), iB2Flag);
			report.reportPass("Edit CIF Entity");
		} catch (Exception e) {
			report.reportHardFail("Edit CIF Entity");
		}
	}
	public void removeCIFEntity() {
		try {
		String oldCount= lbl_RowCount.getText().split(" ")[0];
			webActions.clickBYJS(btn_Remove, "Remove Button"); 
			webActions.waitAndCickBYJS(btn_OK, "OK");
			webActions.waitUntilNotPresent(btn_OK, "OK");
			Thread.sleep(5000);
			String newCount= lbl_RowCount.getText().split(" ")[0];
			Assert.assertEquals(Integer.parseInt(oldCount)-1,Integer.parseInt(newCount));
			report.reportPass("Remove CIF Entity");
		} catch (Exception e) {
			report.reportHardFail("Remove CIF Entity");
		}
	}
	public void validateCIFEntityPageOptions() {
		try {
			webActions.assertDisplayed(btn_Create, "Create");
			webActions.assertDisplayed(btn_Edit, "Edit");
			webActions.assertDisplayed(btn_Remove, "Remove");
			webActions.assertDisplayed(btn_Search, "Search");
			webActions.assertDisplayed(btn_AddSeachCondition, "Add Search Condition");
			report.reportPass("Validate CIF Entity Page Options");

		} catch (Exception e) {
			report.reportHardFail("Validate CIF Entity Page Options");
		}
	}
}
