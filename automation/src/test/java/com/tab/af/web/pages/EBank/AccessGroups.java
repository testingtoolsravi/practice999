package com.tab.af.web.pages.EBank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.github.javafaker.Faker;
import com.tab.af.web.pages.BasePage;

import junit.framework.Assert;

public class AccessGroups extends BasePage {
	@FindBy(xpath = "//span[text()='=']//following::input[1]")
	private WebElement txt_SearchFilter;
	@FindBy(xpath = "//span[text()='Add search condition']")
	private WebElement btn_AddSearchConditon;
	@FindBy(xpath = "//span[text()='Search']")
	private WebElement btn_Search;
	
	@FindBy(xpath = "//span[text()='BPM']")
	private WebElement lbl_BPM;
	@FindBy(xpath = "//span[text()='Reports']")
	private WebElement lbl_Reports;
	@FindBy(xpath = "//span[text()='Accounting']")
	private WebElement lbl_Accounting;
	@FindBy(xpath = "//span[text()='Maintenance']")
	private WebElement lbl_Maintenance;
	@FindBy(xpath = "//span[text()='Administration']")
	private WebElement lbl_Administration;
	@FindBy(xpath = "//span[text()='Help']")
	private WebElement lbl_Help;
	@FindBy(xpath = "//span[text()='Journal Entry']")
	private WebElement lbl_JournalEntry;
	@FindBy(xpath = "//span[text()='Access Groups']")
	private WebElement lbl_AccessGroups;
	@FindBy(xpath = "//span[text()='Create']")
	private WebElement btn_Create;
	@FindBy(xpath = "//div[text()='Name']//following::input[1]")
	private WebElement txt_Name;
	@FindBy(xpath = "(//div[text()='Description']//following::input)[2]")
	private WebElement txt_Description;
	@FindBy(xpath = "//span[text()='User Access Group']//following::input[1]")
	private WebElement txt_UserAccessGroup;
	@FindBy(xpath = "(//span[text()='Add'])[1]")
	private WebElement btn_AddUserAccessGroup;
	@FindBy(xpath = "//span[text()='Account Access']//following::input[1]")
	private WebElement txt_AccountAccessType;
	@FindBy(xpath = "//span[text()='Account Access']//following::input[2]")
	private WebElement txt_AccountAccessNumber;
	@FindBy(xpath = "//span[text()='Account Access']//following::input[3]")
	private WebElement txt_AccountAccessBranch;
	@FindBy(xpath = "(//span[text()='Add'])[2]")
	private WebElement btn_AddAccountAccess;
	@FindBy(xpath = "//span[text()='OK']")
	private WebElement btn_OK;
	@FindBy(xpath = "//tr//td[2]")
	private List<WebElement> lbl_AccessGroupNames;
	@FindBy(xpath = "//tr//td[3]//div")
	private List<WebElement> lbl_AccessGroupDescription;
	@FindBy(xpath = "//span[text()='Edit']")
	private WebElement btn_Edit;
	@FindBy(xpath = "//span[text()='Excel']")
	private WebElement btn_Excel;
	@FindBy(xpath = "//span[text()='Export Access Group Data']")
	private WebElement btn_ExportAccessGroupData;
	@FindBy(xpath = "//span[text()='Remove']")
	private WebElement btn_Remove;
	@FindBy(xpath = "//div[text()='Access Group']")
	private WebElement lbl_AccessGroup;
	@FindBy(xpath = "//div[contains(@class,'paging-status')]//div[contains(text(),'row')]")
	private WebElement lbl_RowCount;
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		return ExpectedConditions.visibilityOf(lbl_AccessGroup);
	}

	

	 
	public void createAccessGroup(String userAccessGroup, String accountAccessType, String accountNumber, String branch,
			String type)

	{

		try {

			String Name = Faker.instance().lorem().fixedString(5);
			String Description = Faker.instance().lorem().fixedString(5);
			Map<String, String> m = new HashMap<String, String>();
			m.put("AccessGroupName", Name);
			m.put("AccessGroupDescription", Description);
			setTestDataMap(m);
			
			webActions.waitAndCickBYJS(btn_Create, "Create");
			webActions.waitAndSendKeysByChar(txt_Name, Name, "Name");
			webActions.sendKeysByChar(txt_Description, Description, "Description");
			webActions.SendKeysByCharAuto(txt_UserAccessGroup, userAccessGroup, "user Access Group");
			webActions.clickBYJS(btn_AddUserAccessGroup, "Add User Access Group");
			webActions.SendKeysByCharAuto(txt_AccountAccessType, accountAccessType, "Account Access Type"); 
			webActions.waitUntilDisplayed(txt_AccountAccessBranch, "Account Access Branch");
			webActions.waitForJSandJQueryToLoad();
			webActions.waitAndSendKeysByCharAuto(txt_AccountAccessNumber, accountNumber, "Account Access Number");
			webActions.waitForJSandJQueryToLoad();
			webActions.waitAndSendKeysByCharAuto(txt_AccountAccessBranch, branch, "Account Access Branch");
			webActions.clickBYJS(btn_AddAccountAccess, "Add Account Accesss");
			if (type.equalsIgnoreCase("debit")) {
				webActions.clickBYJS(webActions.findBy(By.xpath("//div[text()='" + branch + "']//following::input[1]")),
						"Debit");
			} else if (type.equalsIgnoreCase("credit")) {
				webActions.clickBYJS(webActions.findBy(By.xpath("//div[text()='" + branch + "']//following::input[2]")),
						"Credit");
			}
			webActions.clickBYJS(btn_OK, "OK Buton");
			webActions.waitForElementToBeNotPresent(txt_Name, "Name");
			report.reportPass("Create new Access Group");

		} catch (Exception e) {
			report.reportHardFail("Create new Access Group");
		}
	}

	public void validateAccessGroupCreatedSuccesfully() {
		try {
			int rowIndex = 0;
			boolean added = false;
			for (WebElement names : lbl_AccessGroupNames) { 
				if (names.getText().equals(getTestDataMap().get("AccessGroupName"))) {
					added = true;
					break;
				} else {
					rowIndex++;
				}
			}
			if (!added) {
				Assert.assertFalse(true);
			}

			Assert.assertEquals(getTestDataMap().get("AccessGroupDescription"),
					lbl_AccessGroupDescription.get(rowIndex + 1).getText());
			report.reportPass(" Access Group added");

		} catch (Exception e) {
			report.reportHardFail(" Access Group added");
		}

	}

	public void editAccessGroup(String newgroup) {
		try {
			String name = (String) getTestDataMap().get("AccessGroupName");
			webActions.clickAction(webActions.findBy(By.xpath("//tr[1]//td[2]//div[text()='" + name + "']")),
					"Access Group");
			webActions.clickBYJS(btn_Edit, "Edit");
			webActions.waitAndSendKeysByCharAuto(txt_UserAccessGroup, newgroup, "Access Group");
			webActions.clickBYJS(btn_AddUserAccessGroup, "Add User Access Group");
			webActions.clickBYJS(btn_OK, "OK Buton");
			report.reportPass("Edit Access Group");
		} catch (Exception e) {
			report.reportHardFail("Edit Access Group");
		}
	}

	public void exportAccessGroupData() {
		try {

			webActions.clickBYJS(btn_ExportAccessGroupData, "Export Access Group Data");
			// wait for download to complete
			Thread.sleep(10000);
			if (!global.isFileDownloaded("Report for Access Group.xlsx")) {
				throw new Exception("Downlaod Failed");
			}
			report.reportPass("File Downloaded");
		} catch (Exception e) {
			report.reportHardFail("File Downloaded");
		}
	}

	public void validateSearch() {
		try {
			String name = getTestDataMap().get("AccessGroupName").toString();
			addSearchCondtion("Name", name);
			webActions.clickAction(webActions.findBy(By.xpath("//tr[1]//td[2]//div[text()='" + name + "']")),
					"Access Group");
			report.reportPass("Validate Search");
		} catch (Exception e) {
			report.reportHardFail("Validate Search");
		}
	}
	public void removeAccessGroup() {
		try {
			String name = getTestDataMap().get("AccessGroupName").toString();
			String oldCount= lbl_RowCount.getText().split(" ")[0];
			 
			webActions.clickAction(webActions.findBy(By.xpath("//tr[1]//td[2]//div[text()='" + name + "']")),
					"Access Group");
			webActions.clickBYJS(btn_Remove, "Remove");
			webActions.waitAndCickBYJS(btn_OK, "OK");
			webActions.waitForElementToBeNotPresent(btn_OK, "OK"); 
			String newCount= lbl_RowCount.getText().split(" ")[0];
			Assert.assertEquals(Integer.parseInt(oldCount)-1,Integer.parseInt(newCount));
			report.reportPass("Remove Access Group");
		} catch (Exception e) {
			report.reportHardFail("Remove Access Group");
		}
	}
	

	public void addSearchCondtion(String conditionName, String value) {
		try {
		webActions.waitAndCickBYJS(btn_AddSearchConditon, "Add Search condition");
		WebElement element = webActions.findByText(conditionName, "//span");
		webActions.doubleClick(element, conditionName);
		webActions.waitAndSendKeysByChar(txt_SearchFilter, value, "Search filter Input");
		webActions.clickBYJS(btn_Search, "Filter Search");
		report.reportPass("Add Search Condtion:"+conditionName);
		}
		catch(Exception e)
		{
			report.reportHardFail("Add Search Condtion:"+conditionName);
		}

	}
	
	public void validateAccessGroupOptions()
	{
		try {
			webActions.assertDisplayed(btn_Search, "Search Button");
			webActions.assertDisplayed(btn_AddSearchConditon, "Add Search Condition");
			webActions.assertDisplayed(btn_Create, "Create Button");
			webActions.assertDisplayed(btn_Edit, "Edit Button");
			webActions.assertDisplayed(btn_Remove, "Remove Button");
			webActions.assertDisplayed(btn_ExportAccessGroupData, "Export Access Group Data Button");
			webActions.assertDisplayed(btn_Excel, "Excel Button");
			report.reportPass("Access group Page Options");
		}
		catch(Exception e)
		{
			report.reportHardFail("Access group Page Options");
		}

	
	}
}
