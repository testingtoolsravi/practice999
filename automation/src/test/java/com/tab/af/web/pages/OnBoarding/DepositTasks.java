package com.tab.af.web.pages.OnBoarding;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.tab.af.testbase.TestBase;
import com.tab.af.web.pages.BasePage;

public class DepositTasks extends BasePage {
	@FindBy(xpath = "//span[text()=\"Application process\"]")
	private WebElement lbl_ApplicationProcess;
	@FindBy(xpath = "//div[contains(text(),'Application Editor')]")
	private WebElement lbl_ApplicationEditor;
	@FindBy(xpath = "//div[text()='Application Task']")
	private WebElement lbl_ApplicationTask;
	@FindBy(xpath = "//span[text()='Assigned groups']//following::span[text()='Add']")
	private WebElement btn_AddGroups;
	@FindBy(xpath = "//div[text()='Application Product Selection']")
	private WebElement lbl_ApplicationProductSelection;
	@FindBy(xpath = "//span[text()='Application process']//following::tr//td[@class=\"v-table-header-cell\"]//div[text()]")
	private List<WebElement> lbl_ApplicationProcessHeader;
	@FindBy(xpath = "//div[text()=\"Application Verification\"]")
	private WebElement lbl_ApplicationVerification;
	@FindBy(xpath = "//span[text()='Begin Work']")
	private WebElement btn_BeginWork;
	@FindBy(xpath = "//span[text()='Begin Review']")
	private WebElement btn_BeginReview;
	@FindBy(xpath = "//span[text()='Complete']")
	private WebElement btn_Complete;
	@FindBy(xpath = "//div[text()='OLD_TAB Bank']")
	private WebElement lbl_OlbTabBank;
	@FindBy(xpath = "//div[text()='TAB Bank']")
	private WebElement lbl_TabBank;
	@FindBy(xpath = "//div[contains(text(),'approve (Verification Task)')]")
	private WebElement lbl_ApproveVerificationTask;
	@FindBy(xpath = "(//span[text()='Perform']//parent::span//parent::div[@role=\"button\"])[1]")
	private WebElement btn_PeformPreciseID;
	// @FindBy(xpath = "*[cuba-id='infoGrid']")
	// private WebElement btn_ApproveIDInfoGrid;
	@FindBy(xpath = "//div[@role=\"button\"]//following::span[text()='OK']")
	private WebElement btn_OK;
	@FindBy(xpath = "//span[contains(text(),'Continue Work')]")
	private WebElement btn_ContinueWork;
	@FindBy(xpath = "//div[@role='button']//following::span[text()='Approve']")
	private WebElement btn_Approve;
	@FindBy(xpath = "//div[@role=\"button\"]//following::span[text()='Yes']")
	private WebElement btn_DialogYes;
	// @FindBy(xpath = "(//div[@cuba-id=\"performBtn\"])[1]")
	// private WebElement btn_ApproveIDPerform;
	@FindBy(xpath = "//span[text()='Perform']/..//parent::div")
	private WebElement btn_Perform;
	@FindBy(xpath = "//div[text()='KIQ']")
	private WebElement lbl_KIQ;
	@FindBy(xpath = "//div[text()='Number of questions']")
	private WebElement lbl_NumberofQuestions;
	@FindBy(xpath = "//label[text()='NONE OF THE ABOVE/DOES NOT APPLY']")
	private List<WebElement> lbl_NoneofTheAbove;
	@FindBy(xpath = "//div[@cuba-id=\"WebGroupBox\"]//following::textarea[@cuba-id=\"WebResizableTextArea\"]")
	private List<WebElement> lbl_QuestionList;
	@FindBy(xpath = "//span[text()='Send KIQ answers']")
	private WebElement btn_SendKIQAnswers;
	@FindBy(xpath = "//div[text()='DOA welcome email']")
	private WebElement lbl_DOAWelcomeEMail;
	@FindBy(xpath = "//div[text()='DOA welcome email']//following::div[1]")
	private WebElement lbl_DOAWelcomeEMailTaskState;
	@FindBy(xpath = "//div[text()='DOA Funding']")
	private WebElement lbl_DOAFunding;
	@FindBy(xpath = "//div[text()='DOA Funding']//following::div[1]")
	private WebElement lbl_DOAFundingTaskState;
	@FindBy(xpath = "//div[contains(text(),'Non-FCRA Decline E-Mail')]")
	private WebElement lbl_NONFCRADeclinEmail;
	@FindBy(xpath = "//span[text()='Request status']")
	private WebElement lbl_RequestStatus;
	@FindBy(xpath = "//span[text()='Close']")
	private WebElement btn_Close;
	@FindBy(xpath = "//span[text()='Cancel']")
	private WebElement btn_Cancel;
	@FindBy(xpath = "//span[text()='Add search condition']")
	private WebElement btn_AddSearchCondition;
	@FindBy(xpath = "//div[text()='Add condition']")
	private WebElement lbl_AddCondition;
	@FindBy(xpath = "//div[text()='Application Verification']//following::td[1]")
	private WebElement lbl_ApplicationVerificationState;
	@FindBy(xpath = "//div[contains(text(),'approve (Verification Task)')]//following::td[1]")
	private WebElement lbl_ApproveVerificationState;
	@FindBy(xpath = "//div[contains(text(),'welcome email')]//following::td[1]")
	private WebElement lbl_WelcomeEmailState;
	@FindBy(xpath = "//span[text()='Save & Close']")
	private WebElement btn_SaveAndClose;
	@FindBy(xpath = "//span[text()='Save']/..//parent::div[@role=\"button\"]")
	private WebElement btn_Save;
	@FindBy(xpath = "//span[text()='View']/..//parent::div[@role=\"button\"]")
	private WebElement btn_View;
	@FindBy(xpath = "//h1[text()='Application saved.']")
	private WebElement lbl_ApplicationSaved;
	@FindBy(xpath = "//span[text()='=']//following::input[1]")
	private WebElement txt_SearchFilter;
	@FindBy(xpath = "//span[text()='Search']")
	private WebElement btn_Search;
	@FindBy(xpath = "//span[text()='View']//..//parent::div[@role=\"button\"]")
	private WebElement btn_ViewTask;
	@FindBy(xpath = "//div[contains(text(),'accounts create')]")
	private WebElement lbl_ApplicantAccountCreatedTask;
	@FindBy(xpath = "//span[contains(text(),'Customer ID')]")
	private WebElement lbl_ExecutionLogResult;
	@FindBy(xpath = "//div[text()='View Task Screen']")
	private WebElement lbl_ViewTaskScren;
	@FindBy(xpath = "//span[text()='Execution log']//following::textarea")
	private WebElement txt_AccountDetailsTextArea;
	@FindBy(xpath = "//div[@aria-label=\"close button\"]")
	private WebElement btn_ClosePopUp;
	@FindBy(xpath = "//div[text()='Description']//following::textarea")
	private WebElement txt_AccountDetailsDescription;
	@FindBy(xpath = "//div[contains(text(),'Customer Verification/QA')]")
	private WebElement lbl_CustomerVerificationQA;
	@FindBy(xpath = "//div[text()='Customer Verification/QA']//following::td[1]")
	private WebElement lbl_CustomerVerificationQAState;
	@FindBy(xpath = "//div[contains(text(),'Decision')]")
	private WebElement lbl_Decision;
	@FindBy(xpath = "//div[text()='Decision']//following::td[1]")
	private WebElement lbl_DecisionState;
	@FindBy(xpath = "//div[contains(text(),'CIF/Account Creation')]")
	private WebElement lbl_CIFAccountCreation;

	@FindBy(xpath = "//div[text()='CIF/Account Creation']//following::td[1]")
	private WebElement lbl_CIFAccountCreationState;
	@FindBy(xpath = "//div[contains(text(),'Send Welcome E-Mail')]")
	private WebElement lbl_SendWelcomeEMail;
	@FindBy(xpath = "//div[text()='Send Welcome E-Mail']//following::td[1]")
	private WebElement lbl_SendWelcomeEMailState;
	@FindBy(xpath = "//span[text()='Generate Letter']")
	private WebElement btn_GenerateLetter;
	@FindBy(xpath = "//td[2]//div[contains(text(),'Funding')]")
	private WebElement lbl_Funding;
	@FindBy(xpath = "(//div[text()='Funding']//following::td[2])[1]")
	private WebElement lbl_FundingState;
	@FindBy(xpath = "//*[contains(text(),'Do you want to return to the application editor')]")
	private WebElement lbl_ReturnToTask;
	@FindBy(xpath = "//h1[text()='Letters were successfully generated']")
	private WebElement lbl_LettersGeneratedMessage;
	@FindBy(xpath = "(//tr//child::input)[1]")
	private WebElement txt_ApplicantStatus;
	@FindBy(xpath = "//span[text()='Create Precision Accounts']")
	private WebElement btn_CreatePrecisionAccounts;
	@FindBy(xpath = "//div[text()='Accounts created']")
	private WebElement lbl_AccountsCreated;

	@FindBy(xpath = "//span[text()='Addresses']")
	private WebElement lbl_Addresses;
	private String drp_ApplicantStatus = "//following::input[@autocomplete='nope'][1]";

	@Override
	protected ExpectedCondition getPageLoadCondition() {

		return ExpectedConditions.visibilityOf(lbl_ApplicationProcess);
	}

	public void focusTask(WebElement element, String elementName) throws Exception {
		webActions.waitUntilDisplayed(element, elementName);
		webActions.scrollIntoViewByJS(element, elementName);
		webActions.clickAction(element, elementName);
		webActions.waitUntilEnabledCubaTBox(btn_View, "View");
	}

	public void selectTask(WebElement element, String elementName) throws Exception {
		webActions.waitUntilDisplayed(element, elementName);
		webActions.scrollIntoViewByJS(element, elementName);
		webActions.clickBYJS(element, elementName);
		webActions.doubleClick(element, elementName);
	}

	public void addSearchCondtion(String conditionName, String value) throws Exception {
		webActions.waitAndCickBYJS(btn_AddSearchCondition, "Add Search Condition");
		webActions.waitUntilDisplayed(lbl_AddCondition, "Add Condition");
		WebElement element = webActions.findByText(conditionName, "//span");
		webActions.doubleClick(element, conditionName);
		webActions.waitUntilNotPresent(element, conditionName);
		webActions.waitAndSendKeysByChar(txt_SearchFilter, value, "Search filter Input");
		webActions.clickBYJS(btn_Search, "Filter Search");

	}

	public void addAssignedGroup(WebElement task, String taskName) {
		try {
			boolean assignGroup = true;
			WebElement groups = task.findElement(By.xpath("//following::td[6]"));
			if (groups.getText().contains("OLD_TAB Bank") || groups.getText().contains("TAB Bank"))

			{
				assignGroup = false;
			}
			if (assignGroup) {
				selectTask(task, "");
				webActions.waitUntilDisplayed(lbl_ApplicationTask, "Application Task");
				webActions.clickBYJS(btn_AddGroups, "Add Button");

				if (TestBase.props.getProperty("onboarding.env").equals("acpt")) {
					addSearchCondtion("Name", "TAB Bank");

					webActions.waitUntilDisplayed(lbl_TabBank, "TabBank");
					webActions.doubleClick(lbl_TabBank, "TabBank");
				} else if (TestBase.props.getProperty("onboarding.env").equals("int"))

				{
					addSearchCondtion("Name", "OLD_TAB Bank");
					webActions.waitUntilDisplayed(lbl_OlbTabBank, "OLD TabBank");
					webActions.doubleClick(lbl_OlbTabBank, "OLD TabBank");
				}
				webActions.waitUntilDisplayed(btn_OK, "OK Button");
				webActions.clickBYJS(btn_OK, "OK Button");
				report.reportPass("Assign OLD TAB Bank Group");
			}
		} catch (Exception e) {
			report.reportHardFail("Assign OLD TAB Bank Group");
		}

	}

	public void selectCreatedProduct() {
		try {
			String selectedProduct = (String) getTestDataMap().get("SelectedProduct");

			// webActions.waitUntilDisplayed(btn_AddSearchCondition, "Add Search
			// Condition");
			// WebElement product = webActions.findByText(selectedProduct, "//td//div");
			// webActions.waitUntilDisplayed(product, selectedProduct);
			// webActions.doubleClick(product, selectedProduct);
			webActions.waitUntilDisplayed(lbl_ReturnToTask, "Do you want to return to the application editor");
			webActions.clickBYJS(btn_DialogYes, "Yes Button");
			webActions.waitUntilDisplayed(lbl_ApplicationEditor, "Application Editor");
			report.reportPass("Select Product: " + selectedProduct + " Associated with Created Application");
		} catch (Exception e) {
			report.reportHardFail("Select Product: Associated with Created Application Failed");
		}

	}

	public void completeSingleConsumerDepositTasks() {
		completeApplicationVerificationTask();
		completeApproveVerificationTask("Applicant1");
		//completeDOAWelcomeMailTask();
		//completeDOAFundingTask();
	}

	public void completeCommercialDepositTasks() {
		completeApplicationVerificationTask();
		customerVerificationQATask();
		completeDecisionTask();
		completeCIFAccountCreationTask();
		completeSendWelcomeEmailTask();
		completeFundingTask();
	}

	public void completeApplicationVerificationTask() {
		try {
			addAssignedGroup(lbl_ApplicationVerification, "Application Verification");
			webActions.waitUntilEnabledAndCickBYJS(btn_Perform, "Perform Button");
			webActions.waitAndCickBYJS(btn_BeginWork, "Begin Work");
			webActions.waitAndCickBYJS(btn_Complete, "Complete");
			selectCreatedProduct();
			selectTask(lbl_ApplicationVerification, "Application Verification");
			assertTaskStatusDone(lbl_ApplicationVerificationState);
			report.reportPass("Complete Task:  Application Verification");
		} catch (Exception e) {
			report.reportHardFail("Complete Task: Application Verification Failed");
		}
	}

	public void customerVerificationQATask() {
		try {
			addAssignedGroup(lbl_CustomerVerificationQA, " Customer Verification QA");
			webActions.waitUntilEnabledAndCickBYJS(btn_Perform, "Perform Button");
			webActions.waitAndCickBYJS(btn_BeginWork, "Begin Work");
			webActions.waitAndCickBYJS(btn_Complete, "Complete");
			selectCreatedProduct();
			assertTaskStatusDone(lbl_CustomerVerificationQAState);
			report.reportPass("Complete Task: customerVerificationQA");
		} catch (Exception e) {
			report.reportHardFail("Complete Task: customerVerificationQA");
		}
	}

	public void completeDecisionTask() {
		try {
			addAssignedGroup(lbl_Decision, "Decision");
			webActions.waitUntilEnabledAndCickBYJS(btn_Perform, "Perform Button");
			webActions.waitAndCickBYJS(btn_BeginReview, "Begin Reivew");
			webActions.waitAndCickBYJS(btn_Approve, "Approve");
			webActions.waitAndCickBYJS(btn_DialogYes, "Yes");
			selectCreatedProduct();
			assertTaskStatusDone(lbl_DecisionState);
			report.reportPass("Complete Task: Decision");
		} catch (Exception e) {
			report.reportHardFail("Complete Task: Decision");
		}
	}

	public void completeCIFAccountCreationTask() {
		try {
			Map<String, String> map = getTestDataMap();
			String name = map.get("FIRST NAME") + " " + map.get("LAST NAME");
			addAssignedGroup(lbl_CIFAccountCreation, "CIF Account Creation");
			webActions.waitUntilEnabledAndCickBYJS(btn_Perform, "Perform Button");
			webActions.waitAndCickBYJS(btn_BeginWork, "Begin work");
			webActions.waitUntilDisplayed(btn_Complete, "complete button");
			WebElement mainApplicant = webActions.findWebElementByText(name);
			webActions.clickAction(mainApplicant, "Main Applicant");
			webActions.clearByJS(webActions.findBy(By.xpath("//*[text()='" + name + "']" + drp_ApplicantStatus)),
					"Clear Application Status");
			WebElement applicantStatus = webActions
					.findBy(By.xpath("//*[text()='" + name + "']" + drp_ApplicantStatus));
			webActions.SendKeysByCharAuto(applicantStatus, "Approved", "Application Status");

			/**
			 * Automation Specific Issue Edit Page is Opening
			 */
			try {
				boolean pageLoad = webActions.waitForVisibility(lbl_Addresses, "Address Label ", 10).isDisplayed();
				if (pageLoad) {
					webActions.clickBYJS(btn_Cancel, "Cancel Button");
					webActions.waitUntilDisplayed(btn_CreatePrecisionAccounts, "Create Precision Accounts");
				}
			} catch (TimeoutException e) {

			}
			/**
			 * 
			 */

			webActions.clickBYJS(btn_Save, "Save button");
			webActions.waitUntilDisplayed(lbl_ApplicationSaved, "Application Saved Message");
			webActions.clickBYJS(btn_CreatePrecisionAccounts, "Create Precision Accounts");
			webActions.waitUntilDisplayed(lbl_AccountsCreated, "Account Created Message");
			webActions.clickBYJS(btn_OK, "OK Button");
			webActions.waitAndCickBYJS(btn_Complete, "Complete");
			selectCreatedProduct();
			assertTaskStatusDone(lbl_CIFAccountCreationState);
			report.reportPass("Complete Task: CIFaccountCreation");
		} catch (Exception e) {
			report.reportHardFail("Complete Task: CIFaccountCreation");
		}
	}

	public void completeSendWelcomeEmailTask() {
		try {
			addAssignedGroup(lbl_SendWelcomeEMail, "weclome mail");
			webActions.waitUntilEnabledAndCickBYJS(btn_Perform, "Perform Button");
			webActions.waitAndCickBYJS(btn_BeginWork, "Begin work");
			webActions.waitUntilDisplayed(btn_Complete, "complete button");
			webActions.waitUntilDisplayed(btn_GenerateLetter, "Generate Letter");

			webActions.clickBYJS(btn_GenerateLetter, "Generate Letter");
			webActions.waitUntilDisplayed(lbl_LettersGeneratedMessage, "Letter Generated Succsessfully");
			webActions.waitAndCickBYJS(btn_Complete, "Complete");
			selectCreatedProduct();
			assertTaskStatusDone(lbl_SendWelcomeEMailState);
			report.reportPass("Complete Task: Send Welcome Email");
		} catch (Exception e) {
			report.reportHardFail("Complete Task: Send Welcome Email Failed");
		}
	}

	public void completeFundingTask() {
		try {
			addAssignedGroup(lbl_Funding, "Funding");
			webActions.waitUntilEnabledAndCickBYJS(btn_Perform, "Perform Button");
			webActions.waitAndCickBYJS(btn_BeginWork, "Begin work");
			webActions.waitAndCickBYJS(btn_Complete, "Complete");
			selectCreatedProduct();
			webActions.waitUntilDisplayed(lbl_ApplicationEditor, "Application Editor");
			assertTaskStatusDone(lbl_FundingState);
			report.reportPass("Complete Task: Funding");
		} catch (Exception e) {
			report.reportHardFail("Complete Task: Fundin");
		}
	}

	public void completeApproveVerificationTask(String applicantNo) {
		try {
			Map<String, String> map = getApplicant(applicantNo);
			String name = map.get("FIRST NAME") + " " + map.get("LAST NAME");
			WebElement task = webActions
					.findWebElementByContainsText("Applicant [" + name + "] approve (Verification Task)");
			addAssignedGroup(task, "Approve Precise ID " + name);
			webActions.waitUntilEnabledAndCickBYJS(btn_Perform, "Perform Button");
			webActions.waitAndCickBYJS(btn_ContinueWork, "Continue Work");
			webActions.waitUntilEnabledCubaButton(btn_PeformPreciseID, "Perform Precise ID");
			webActions.waitAndCickBYJS(btn_PeformPreciseID, "Perform Precise ID");
			webActions.waitAndClick(lbl_KIQ, "KIQ Tab");
			webActions.waitUntilDisplayed(lbl_NumberofQuestions, "Number of Questions");

			selectKIQQuestions(map);
			webActions.clickBYJS(btn_SendKIQAnswers, "Send KIQ Answers");
			webActions.waitUntilDisplayed(lbl_RequestStatus, "Request Status");
			webActions.clickBYJS(btn_Close, "Close Button");
			webActions.waitAndCickBYJS(btn_Approve, "Approve Work");
			webActions.waitAndCickBYJS(btn_DialogYes, "Yes Button");
			selectCreatedProduct();
			task = webActions.findWebElementByContainsText("Applicant [" + name + "] approve (Verification Task)");
			selectTask(task, "Approve Precise ID " + name);
			WebElement taskState = webActions.findBy(By.xpath(
					"//*[contains(text(),'Applicant [" + name + "] approve (Verification Task)')]//following::td[1]"));
			assertTaskStatusDone(taskState);
			report.reportPass("Complete Task: Approve Precise ID");
		} catch (Exception e) {
			report.reportHardFail("Complete Task: Approve Precise ID");
		}
	}

	public void completeDOAWelcomeMailTask() {
		try {
			selectTask(lbl_DOAWelcomeEMail, "DOA welcome mail");
//			assignGroup();
//			webActions.click(btn_SaveAndClose, "Save and Close");
//			selectCreatedProduct();
//			webActions.waitUntilDisplayed(lbl_DOAWelcomeEMail, "DOA Welcome EMail");
//			webActions.scrollIntoViewByJS(lbl_DOAWelcomeEMail, "DOA Welcome EMail");
			assertTaskStatusDone(lbl_DOAWelcomeEMailTaskState);
			report.reportPass("Complete Task: DOA Welcome Email");
		} catch (Exception e) {
			report.reportHardFail("Complete Task: DOA Welcome Email Failed");
		}
	}

	public void completeDOAFundingTask() {
		try {
			selectTask(lbl_DOAFunding, "DOA  Funding");
//			assignGroup();
//			webActions.click(btn_SaveAndClose, "Save and Close");
//			selectCreatedProduct();
//			webActions.waitUntilDisplayed(lbl_DOAWelcomeEMail, "DOA Welcome EMail");
//			webActions.scrollIntoViewByJS(lbl_DOAWelcomeEMail, "DOA Welcome EMail");
			assertTaskStatusDone(lbl_DOAFundingTaskState);
			report.reportPass("Complete Task: DOA Funding");
		} catch (Exception e) {
			report.reportHardFail("Complete Task: DOA Funding Failed");
		}
	}

	public void completeNonFCRADeclineTask() {
		try {
			// selectCreatedProduct();
			addAssignedGroup(lbl_NONFCRADeclinEmail, "DOA Welcome EMail");
			webActions.waitUntilEnabledAndCickBYJS(btn_Perform, "Perform Button");
			assertTaskStatusDone(lbl_ApproveVerificationState);
			report.reportPass("Complete Task: Welcome Email");
		} catch (Exception e) {
			report.reportHardFail("Complete Task: Welcome Email Failed");
		}
	}

	public void verifyAccountCreated(String applicantNo) {
		try {
			Map<String, String> map = getApplicant(applicantNo);
			String name = map.get("FIRST NAME") + " " + map.get("LAST NAME");
			WebElement task = webActions.findWebElementByContainsText("Applicant [" + name + "] accounts create");
			focusTask(task, "Applicant Acount Created Task");
			webActions.waitUntilEnabledCubaButton(btn_ViewTask, "View Task");
			webActions.clickBYJS(btn_ViewTask, "View Task");
			webActions.waitUntilDisplayed(lbl_ExecutionLogResult, "Execution Log Result");
			webActions.doubleClick(lbl_ExecutionLogResult, "Execution Log Result");
			webActions.waitUntilDisplayed(txt_AccountDetailsTextArea, "Account Details");
			String[] lines = txt_AccountDetailsTextArea.getAttribute("value").split("\n");
			String accNum = "";
			if (applicantNo.equalsIgnoreCase("Applicant1")) {
				accNum = lines[4];
			} else {
				for (int i = 0; i < lines.length; i++) {
					if (lines[i].contains(map.get("LAST NAME"))) {
						accNum = lines[i + 1];
						break;
					}
				}
			}

			boolean accountCreated = StringUtils.isNumeric(accNum.replace("Account Num ", "").trim());
			Assert.assertTrue(accountCreated);
			report.reportPass("Account Created successfully for: " + applicantNo);
			webActions.clickBYJS(btn_ClosePopUp, "Close Account Create Popup");
			webActions.waitUntilNotPresent(btn_ClosePopUp, "Close Account Create Popup");
		} catch (Exception e) {
			report.reportHardFail("Account creation failed for: " + applicantNo);
		}
	}

	public void verifyCIFAccountCreated() {
		try {

			focusTask(lbl_CIFAccountCreation, "CIF  Account Created Task");
			webActions.clickBYJS(btn_ViewTask, "View Task");
			webActions.waitUntilDisplayed(lbl_ViewTaskScren, "View Task Screen");
			webActions.waitUntilDisplayed(txt_AccountDetailsDescription, "Account Details");
			Assert.assertTrue(txt_AccountDetailsDescription.getAttribute("value").contains("Account Num "));
			report.reportPass("Account Created successfully");
		} catch (Exception e) {
			report.reportHardFail("Account creation failed");
		}
	}

	public void selectKIQQuestions(Map<String, String> map) {
		try {
			Map<String, Set<String>> kiqMap = global.getKIQKeyMap();
			for (int itr = 0; itr < lbl_QuestionList.size(); itr++) {

				String questionText = lbl_QuestionList.get(itr).getAttribute("value");
				Set<String> keySet = kiqMap.get(questionText);
				if (questionText.contains("Based on our records, you previously lived on")) {
					keySet = kiqMap.get(
							"Based on our records, you previously lived on. Please choose the city where this street is located.");
				}
				if (questionText.contains("From the list below, what is the area code for phone number ending in")) {
					keySet = kiqMap.get("From the list below, what is the area code for phone number ending in");
				}
				boolean found = false;
				boolean keyState = false;
				for (String key : keySet) {
					if (questionText.contains("Select the vehicle you purchased or leased prior to")) {
						String[] vehicleKeys = key.split("\\+");
						if (map.get(vehicleKeys[0].trim()).isEmpty() || map.get(vehicleKeys[1].trim()).isEmpty()) {
							keyState = true;
						} else {
							keyState = false;
							break;
						}
					} else {
						if (map.get(key).trim().isEmpty() || map.get(key).equalsIgnoreCase("NONE OF THE ABOVE")) {
							keyState = true;
						} else {
							keyState = false;
							break;
						}
					}
				}
				if (keyState) {
					WebElement noneOfAbove = webActions.findBy(
							By.xpath("(//label[text()='NONE OF THE ABOVE/DOES NOT APPLY']//preceding-sibling::input)["
									+ (itr + 1) + "]"));
					webActions.clickBYJS(noneOfAbove, "None Of the Above");
					continue;
				}

				for (String key : keySet) {

					if (found) {
						break;
					}
					String possibleAnswer = map.get(key);
					if (questionText.contains("Select the vehicle you purchased or leased prior to")) {
						String[] vehicleKeys = key.split("\\+");
						String make = map.get(vehicleKeys[0].trim());
						String model = map.get(vehicleKeys[1].trim());
						possibleAnswer = make + " " + model;
					}
					if (questionText.contains("what is the area code for phone number ending in")) {
						possibleAnswer = map.get(key).substring(0, 3);
					}
					if (possibleAnswer.trim().isEmpty()) {
						continue;
					}
					List<WebElement> answerList = lbl_QuestionList.get(itr).findElements(
							By.xpath("//following::div[@cuba-id=\"outWalletAnswer" + (itr + 1) + "\"]//label"));
					for (WebElement element : answerList) {

						String answer = element.getText().replaceAll("[^a-zA-Z0-9 -]", "");

						if (questionText.contains("dollar range")) {
							try {
								String[] range = answer.replace("$", "").split("-");
								int lowerRange = Integer.parseInt(range[0].trim());
								int upperRange = Integer.parseInt(range[1].trim());

								int value = Integer.parseInt(possibleAnswer.trim());
								if (value >= lowerRange && value <= upperRange) {
									// WebElement chkBox = webActions.findWebElementByText(answer);
									webActions.clickBYJS(element, answer);
									found = true;
									break;
								}

							} catch (NumberFormatException e) {
								continue;
							}

						}
						if (answer.contains(possibleAnswer)) {
							found = true;
							WebElement chkBox = webActions.findWebElementByText(answer);
							webActions.clickBYJS(chkBox, answer);
							break;
						}
					}

				}
				if (!found) {
					WebElement noneOfAbove = webActions.findBy(
							By.xpath("(//label[text()='NONE OF THE ABOVE/DOES NOT APPLY']//preceding-sibling::input)["
									+ (itr + 1) + "]"));
					webActions.clickBYJS(noneOfAbove, "None Of the Above");

				}
			}
			report.reportPass("KIQ Selected SuccessFully");
		} catch (Exception e) {
			report.reportHardFail("KIQ Selected SuccessFully");
		}
	}

	private void assertTaskStatusDone(WebElement element) throws Exception {
		global.assertStringEquals(element.getText(), "Done");
	}
}
