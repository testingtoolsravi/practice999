package com.tab.af.web.pages.OnBoarding;

import org.joda.time.DateTime;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.json.JsonException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.github.javafaker.Faker;
import com.tab.af.testbase.TestBase;
import com.tab.af.web.pages.BasePage;

public class LoanTasks extends BasePage {
	@FindBy(xpath = "//span[text()=\"Application process\"]")
	private WebElement lbl_ApplicationProcess;
	@FindBy(xpath = "//span[text()='Perform']/..//parent::div")
	private WebElement btn_Perform;
	@FindBy(xpath = "//*[contains(text(),'Do you want to return to the application editor')]")
	private WebElement lbl_ReturnToTask;
	@FindBy(xpath = "//div[@role=\"button\"]//following::span[text()='Yes']")
	private WebElement btn_DialogYes;
	@FindBy(xpath = "//div[contains(text(),'Application Editor')]")
	private WebElement lbl_ApplicationEditor;
	@FindBy(xpath = "//div[text()='Check-In Loan Package']")
	private WebElement lbl_CheckInLoanPackage;
	@FindBy(xpath = "//div[text()='Check-In Loan Package']//following::td[1]")
	private WebElement lbl_CheckInLoanPackageState;
	@FindBy(xpath = "//div[text()='Compile Credit Summary']")
	private WebElement lbl_CompileCreditSummary;
	@FindBy(xpath = "//div[text()='Compile Credit Summary']//following::td[1]")
	private WebElement lbl_CompileCreditSummaryState;
	@FindBy(xpath = "//div[text()='8821 & Tax Guard Report']")
	private WebElement lbl_TaxGuardReport8821;
	@FindBy(xpath = "//div[text()='8821 & Tax Guard Report']//following::td[1]")
	private WebElement lbl_TaxGuardReport8821TaskState;
	@FindBy(xpath = "//div[text()='Legals Preparation']")
	private WebElement lbl_LegalsPeparation;
	@FindBy(xpath = "//div[text()='Legals Preparation']//following::td[1]")
	private WebElement lbl_LegalsPeparationTaskState;
	@FindBy(xpath = "//div[text()='TMS Discovery and Setup']")
	private WebElement lbl_TMSDiscoveryAndSetup;
	@FindBy(xpath = "//div[text()='TMS Discovery and Setup']//following::td[1]")
	private WebElement lbl_TMSDiscoveryAndSetupTaskState;
	@FindBy(xpath = "//div[text()='TMS Onboarding']")
	private WebElement lbl_TMSOnBoarding;
	@FindBy(xpath = "//div[text()='TMS Onboarding']//following::td[1]")
	private WebElement llbl_TMSOnBoardingTaskState;
	@FindBy(xpath = "//div[text()='Legal Docs Execution']")
	private WebElement lbl_LegalDocsExecution;
	@FindBy(xpath = "//div[text()='Legal Docs Execution']//following::td[1]")
	private WebElement lbl_LegalDocsExecutionTaskState;
	@FindBy(xpath = "//div[text()='Legal Documents']")
	private WebElement lbl_LegalDocuments;
	@FindBy(xpath = "//div[text()='Legal Documents']//following::td[1]")
	private WebElement lbl_LegalDocumentsTaskState;
	@FindBy(xpath = "//div[text()='Loan Account Setup']")
	private WebElement lbl_LoanAccountSetup;
	@FindBy(xpath = "//div[text()='Loan Account Setup']//following::td[1]")
	private WebElement lbl_LoanAccountSetupTaskState;
	@FindBy(xpath = "//div[text()='Prefunding Legal Review']")
	private WebElement lbl_PrefundingLegalReview;
	@FindBy(xpath = "//div[text()='Prefunding Legal Review']//following::td[1]")
	private WebElement lbl_PrefundingLegalReviewTaskState;
	@FindBy(xpath = "//div[text()='Prefunding Legal Review']")
	private WebElement lbl_PrefundingReview;
	@FindBy(xpath = "//div[text()='Prefunding Legal Review']//following::td[1]")
	private WebElement lbl_PrefundingReviewTaskState;
	@FindBy(xpath = "//div[text()='Decline review']")
	private WebElement lbl_DeclineReview;
	@FindBy(xpath = "//div[text()='Decline review']//following::td[1]")
	private WebElement lbl_DeclineReviewTaskState;
	@FindBy(xpath = "(//div[text()='Funding'])[2]")
	private WebElement lbl_Funding;
	@FindBy(xpath = "(//div[text()='Funding'])[2]//following::td[1]")
	private WebElement lbl_FundingTaskState;
	@FindBy(xpath = "//div[text()='Standard exception task']")
	private WebElement lbl_StandardExceptionTask;
	@FindBy(xpath = "//div[text()='Collateral Valuation']")
	private WebElement lbl_CollateralValuation;
	@FindBy(xpath = "//div[text()='Collateral Valuation']//following::td[1]")
	private WebElement lbl_CollateralValuationTaskState;
	@FindBy(xpath = "//div[text()='Scoring']")
	private WebElement lbl_ScoringTask;
	@FindBy(xpath = "//td[2]//div[text()='Scoring']//following::td[1]")
	private WebElement lbl_ScoringTaskState;
	@FindBy(xpath = "//div[text()='Attach Signed Application and Term Sheet']")
	private WebElement lbl_AttachSignedApplicationAndTermSheetTask;
	@FindBy(xpath = "//div[text()='Attach Signed Application and Term Sheet']//following::td[1]")
	private WebElement lbl_AttachSignedApplicationAndTermSheetTaskState;
	@FindBy(xpath = "//div[text()='Generate Verification Letter']")
	private WebElement lbl_GenerateVerificationLetterTask;
	@FindBy(xpath = "//div[text()='Generate Verification Letter']//following::td[1]")
	private WebElement lbl_GenerateVerificationLetterTaskState;
	@FindBy(xpath = "//div[text()='Approve (1)']")
	private WebElement lbl_ApproveOne;
	@FindBy(xpath = "//div[text()='Approve (1)']//following::td[1]")
	private WebElement lbl_ApproveOneTaskState;
	@FindBy(xpath = "//div[text()='Approve (2)']")
	private WebElement lbl_ApproveTwo;
	@FindBy(xpath = "//div[text()='Approve (2)']//following::td[1]")
	private WebElement lbl_ApproveTwoTaskState;
	@FindBy(xpath = "//div[text()='A/R Verification']")
	private WebElement lbl_ARVerification;
	@FindBy(xpath = "//div[text()='A/R Verification']//following::td[1]")
	private WebElement lbl_ARVerificationTaskState;
	@FindBy(xpath = "//div[text()='Background Searches / UCC Filings']")
	private WebElement lbl_BackGroundSearchsUCCFilingsTask;
	@FindBy(xpath = "//div[text()='Background Searches / UCC Filings']//following::td[1]")
	private WebElement lbl_BackGroundSearchsUCCFilingsTaskState;
	@FindBy(xpath = "//div[text()='Debtor Credit Review']")
	private WebElement lbl_DebtorCreditReview;
	@FindBy(xpath = "//div[text()='Debtor Credit Review']//following::td[1]")
	private WebElement lbl_DebtorCreditReviewTaskState;
	@FindBy(xpath = "//div[text()='Approve Task']")
	private WebElement lbl_ApproveTask;
	@FindBy(xpath = "//div[text()='Approve Task']//following::td[1]")
	private WebElement lbl_ApproveTaskState;
	@FindBy(xpath = "//div[text()='Standard exception task']//following::td[1]")
	private WebElement lbl_StandardExceptionTaskState;
	@FindBy(xpath = "//div[text()='SME Approval']")
	private WebElement lbl_SMEApproval;
	@FindBy(xpath = "//div[text()='SME Approval']//following::td[1]")
	private WebElement lbl_SMEApprovalTaskState;
	@FindBy(xpath = "//div[text()='Send Approve Letter']")
	private WebElement lbl_SendApproveLetter;
	@FindBy(xpath = "//div[text()='Send Approve Letter']//following::td[1]")
	private WebElement lbl_SendApproveLetterState;
	@FindBy(xpath = "//div[text()='Equipment Checklist']")
	private WebElement lbl_EquipmentChecklist;
	@FindBy(xpath = "//div[text()='Equipment Checklist']//following::td[1]")
	private WebElement lbl_EquipmentChecklistState;
	@FindBy(xpath = "//div[text()='SME Funding']")
	private WebElement lbl_SMEFunding;
	@FindBy(xpath = "//div[text()='SME Funding']//following::td[1]")
	private WebElement lbl_SMEFundingState;
	@FindBy(xpath = "//div[text()='SME Credit Analyst Approval']")
	private WebElement lbl_SMECreditAnalystApproval;
	@FindBy(xpath = "//div[text()='SME Credit Analyst Approval']//following::td[1]")
	private WebElement lbl_SMECreditAnalystApprovalState;
	@FindBy(xpath = "//div[text()='Senior SME Credit Analyst Approval']")
	private WebElement lbl_SeniorSMEFCreditAnalystApproval;
	@FindBy(xpath = "//div[text()='Senior SME Credit Analyst Approval']//following::td[1]")
	private WebElement lbl_SeniorCreditAnalystApprovalState;
	@FindBy(xpath = "//div[text()='Assign Underwriter']")
	private WebElement lbl_AssignUnderwriter;
	@FindBy(xpath = "//div[text()='Assign Underwriter']//following::td[1]")
	private WebElement lbl_AssignUnderwriterState;
	@FindBy(xpath = "//span[text()='Begin Work']")
	private WebElement btn_BeginWork;
	@FindBy(xpath = "//div[text()='Operating Accounts']//following::input[1]")
	private WebElement drp_OperatingAccounts;
	@FindBy(xpath = "//div[text()='38 Operating Account']//following::input[1]")
	private WebElement drp_38OperatingAccount;
	@FindBy(xpath = "//div[@role='button']//following::span[text()='Approve']")
	private WebElement btn_Approve;
	@FindBy(xpath = "//span[text()='Begin Review']")
	private WebElement btn_BeginReview;
	@FindBy(xpath = "//span[text()='Complete']")
	private WebElement btn_Complete;
	@FindBy(xpath = "//div[text()='Confirm Complete Task']")
	private WebElement lbl_ConfirmCompleteTask;
	@FindBy(xpath = "//span[text()='Finish process']")
	private WebElement btn_FinishProcess;
	@FindBy(xpath = "//label[text()='No Exception']//following::span[text()='Add'][1]")
	private WebElement btn_AddException;
	@FindBy(xpath = "//div[text()='Business Exception Templates']")
	private WebElement lbl_BusinessExceptionTemplates;
	@FindBy(xpath = "//div[@cuba-id='businessExceptionTemplatesTable']//tr[2]//td[2]//div")
	private WebElement lbl_SecondException;
	@FindBy(xpath = "//div[text()='Business Exception Templates']//following::span[text()='Create']")
	private WebElement btn_CreateException;
	@FindBy(xpath = "(//div[text()='Exception name']//following::input[1])[2]")
	private WebElement txt_ExceptionName;
	@FindBy(xpath = "//span[text()='Generate Letter']")
	private WebElement btn_GenerateLetter;
	@FindBy(xpath = "//h1[text()='Letters were successfully generated']")
	private WebElement lbl_LettersGeneratedSuccessfullyMessage;
	@FindBy(xpath = "//span[text()='Dealership name']//following::input[1]")
	private WebElement txt_DealershipName;
	@FindBy(xpath = "//span[text()='Dealer contact']//following::input[1]")
	private WebElement txt_Dealercontact;
	@FindBy(xpath = "//span[text()='Dealer phone']//following::input[1]")
	private WebElement txt_Dealerphone;
	@FindBy(xpath = "//span[text()='Dealer email']//following::input[1]")
	private WebElement txt_DealerEmail;
	@FindBy(xpath = "//div[text()='Title work']//following::input[1]")
	private WebElement txt_Titlework;
	@FindBy(xpath = "//div[text()='Payment Type']//following::input[1]")
	private WebElement txt_PaymentType;
	@FindBy(xpath = "(//div[text()='Team']//following::input[@type=\"text\"])[1]")
	private WebElement txt_Team;
	@FindBy(xpath = "//div[text()='Team Designation']//following::input[1]")
	private WebElement txt_TeamDesignation;
	@FindBy(xpath = "//div[text()='Dealer name']//following::input[1]")
	private WebElement txt_DealerName;
	@FindBy(xpath = "//div[text()='Phone number']//following::input[1]")
	private WebElement txt_DealerPhoneNumber;
	@FindBy(xpath = "//div[text()='Email address']//following::input[1]")
	private WebElement txt_DealerEmailAddress;
	@FindBy(xpath = "//div[text()='Date opened']//following::input[1]")
	private WebElement txt_DateOpened;
	@FindBy(xpath = "//div[text()='First payment date']//following::input[1]")
	private WebElement txt_FirstPaymentDate;
	@FindBy(xpath = "//div[text()='Payment amount']//following::input[1]")
	private WebElement txt_PaymentAmount;
	@FindBy(xpath = "//div[text()='Maturity date']//following::input[1]")
	private WebElement txt_MaturityDate;
	@FindBy(xpath = "//span[text()='=']//following::input[1]")
	private WebElement txt_SearchFilter;
	@FindBy(xpath = "//span[text()='Search']")
	private WebElement btn_Search;
	@FindBy(xpath = "//div[text()='TAB Bank']")
	private WebElement lbl_TabBank;
	@FindBy(xpath = "//span[text()='Assigned groups']//following::span[text()='Add']")
	private WebElement btn_AddGroups;
	@FindBy(xpath = "//div[text()='Application Task']")
	private WebElement lbl_ApplicationTask;
	@FindBy(xpath = "//span[text()='Add search condition']")
	private WebElement btn_AddSearchCondition;
	@FindBy(xpath = "//div[text()='Add condition']")
	private WebElement lbl_AddCondition;
	@FindBy(xpath = "//div[text()='OLD_TAB Bank']")
	private WebElement lbl_OlbTabBank;
	@FindBy(xpath = "//span[text()='Start Scoring Process']//parent::span//parent::div")
	private WebElement btn_StartScoringProcess;
	@FindBy(xpath = "//span[text()='Request providers']//parent::span//parent::div")
	private WebElement btn_RequestProviders;
	@FindBy(xpath = "(//div[text()='State']//following::input[@type=\"text\"])[1]")
	private WebElement txt_TaskState;
	@FindBy(xpath = "//div[text()='Start scoring process for application?']")
	private WebElement lbl_StartScoringProcessForApplication;
	@FindBy(xpath = "//div[text()='Response received']")
	private WebElement lbl_ResponseReceived;
	@FindBy(xpath = "//span[text()='Start']")
	private WebElement btn_Start;
	@FindBy(xpath = "//div[@cuba-id=\"companiesTable_composition\"]//table[@class='v-table-table']//tr[1]//td[@class='v-table-cell-content']//div")
	private WebElement lbl_TableRow;
	@FindBy(xpath = "//span[text()='Select']//..//parent::div")
	private WebElement btn_Select;
	@FindBy(xpath = "//div[text()='CalculationResult']")
	private WebElement lbl_CalculationResult;
	@FindBy(xpath = "//span[text()='OK']")
	private WebElement btn_OK;
	@FindBy(xpath = "//span[text()='Add to set']")
	private WebElement btn_AddToSet;
	@FindBy(xpath = "//span[text()='Add to set']")
	private WebElement tbl_CompaniesTable;
	@FindBy(xpath = "//span[text()='View']/..//parent::div")
	private WebElement btn_View;
	@FindBy(xpath = "//label[text()='Tax Guard sent for Approval']")
	private WebElement chk_TaxGuardSentForApproval;
	@FindBy(xpath = "//label[text()='8821 Received & Tax Guard Ordered']")
	private WebElement chk_8821ReceivedAndTaxGuardOrderes;
	@FindBy(xpath = "//label[text()='Tax Guard Approved']")
	private WebElement chk_TaxGuardApproved;
	@FindBy(xpath = "//label[text()='8821 Created & Sent']")
	private WebElement chk_8821CreatedAndSent;
	@FindBy(xpath = "//label[text()='Attachments Saved']")
	private WebElement chk_AttachmentsSaved;
	@FindBy(xpath = "//div[text()='Initial Funding Amount']//following::input[1]")
	private WebElement txt_InitialFundingAmount;
	@FindBy(xpath = "//div[text()='First Fund Date']//following::input[1]")
	private WebElement txt_FirstFundDate;
	@FindBy(xpath = "//div[text()='Stucky Account']//following::input[1]")
	private WebElement txt_StuckyAccount;
	@FindBy(xpath = "//div[text()='Lock Box']//following::input[1]")
	private WebElement txt_LockBox;
	@FindBy(xpath = "//div[text()='Operating Accounts']//following::input[1]")
	private WebElement txt_OperatingAccounts;
	@FindBy(xpath = "//div[text()='FS Account']//following::input[1]")
	private WebElement txt_FSAccount;
	@FindBy(xpath = "//div[text()='Term Loan Account']//following::input[1]")
	private WebElement txt_TermLoanAccount;
	@FindBy(xpath = "//div[text()='Operating Account']//following::input[1]")
	private WebElement txt_OperatingAccount;
	@FindBy(xpath = "//div[text()='38 Operating Account']//following::input[1]")
	private WebElement txt_38OperatingAccounts;
	@FindBy(xpath = "//h1[text()='Application saved.']")
	private WebElement lbl_ApplicationSaved;
	@FindBy(xpath = "//label[text()='Fully Executed Docs Received']")
	private WebElement chk_FullyExecutedDocsReceived;
	@FindBy(xpath = "//label[text()='Legals Sent']")
	private WebElement chk_LegalsSent;

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
		webActions.clickBYJS(btn_Search, "Filter Search");	}

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

	public void resumeCreatedApplication() {
		try {

			webActions.waitUntilDisplayed(lbl_ReturnToTask, "Do you want to return to the application editor");
			webActions.clickBYJS(btn_DialogYes, "Yes Button");
			webActions.waitUntilDisplayed(lbl_ApplicationEditor, "Application Editor");
			report.reportPass("Select Product:   Associated with Created Application");
		} catch (Exception e) {
			report.reportHardFail("Select Product: Associated with Created Application Failed");
		}
	}

	public void checkInLoanPackage() {
		try {
			addAssignedGroup(lbl_CheckInLoanPackage, "Check in Loan Package");
			webActions.waitUntilEnabledCubaButton(btn_Perform, "Perform Button");
			webActions.clickBYJS(btn_Perform, "Perform Button");
			webActions.waitAndCickBYJS(btn_BeginWork, "Begin Work");
			webActions.waitAndCickBYJS(btn_Complete, "Complete");
			resumeCreatedApplication();
			focusTask(lbl_CheckInLoanPackage, "Application Verification");
			assertTaskStatusDone(lbl_CheckInLoanPackageState);
			report.reportPass("Check in Loan Package Task");
		} catch (Exception e) {
			report.reportHardFail("Check in Loan Package Task Failed");
		}
	}

	public void compileSmallTicketCreditSummary() {
		try {
			focusTask(lbl_CompileCreditSummary, "Check in Loan Package");
			webActions.waitUntilEnabledCubaButton(btn_Perform, "Perform Button");
			webActions.clickBYJS(btn_Perform, "Perform Button");
			webActions.waitAndCickBYJS(btn_BeginWork, "Begin Work");
			waitForTaskStateToBeInProgress();
			webActions.clickBYJS(btn_StartScoringProcess, "Start Scoring process");
			webActions.waitUntilDisplayed(lbl_StartScoringProcessForApplication, "StartScoringProcessForApplication");
			webActions.clickBYJS(btn_Start, "Start");
			webActions.waitUntilDisplayed(btn_AddToSet, "Add To Set");
			selectMatchScore(lbl_TableRow, "Match Score Table Row");
			webActions.waitUntilDisplayed(lbl_CalculationResult, "Cal Result");
			webActions.clickBYJS(btn_OK, "ok");
			webActions.waitUntilNotPresent(btn_OK, "ok");
			webActions.waitAndCickBYJS(btn_Complete, "Complete");
			resumeCreatedApplication();
			focusTask(lbl_CompileCreditSummary, "Application Verification");
			assertTaskStatusDone(lbl_CompileCreditSummaryState);
			report.reportPass("Compile Credit Summary Task");
		} catch (Exception e) {
			report.reportHardFail("Compile Credit Summary Task Failed");
		}
	}

	public void compileCreditSummary() {
		try {
			addAssignedGroup(lbl_CompileCreditSummary, "Compile Credits Summary");
			webActions.waitUntilEnabledCubaButton(btn_Perform, "Perform Button");
			webActions.clickBYJS(btn_Perform, "Perform Button");
			webActions.waitAndCickBYJS(btn_BeginWork, "Begin Work");
			waitForTaskStateToBeInProgress();
			webActions.waitAndCickBYJS(btn_Complete, "Complete");
			resumeCreatedApplication();
			focusTask(lbl_CompileCreditSummary, "Application Verification");
			assertTaskStatusDone(lbl_CompileCreditSummaryState);
			report.reportPass("Compile Credit Summary Task");
		} catch (Exception e) {
			report.reportHardFail("Compile Credit Summary Task Failed");
		}
	}

	public void collateralValuation() {
		try {
			focusTask(lbl_CollateralValuation, "Collaeral Valuation");
			webActions.waitUntilEnabledCubaButton(btn_Perform, "Perform Button");
			webActions.clickBYJS(btn_Perform, "Perform Button");
			webActions.waitAndCickBYJS(btn_BeginWork, "Begin Work");
			waitForTaskStateToBeInProgress();
			webActions.waitAndCickBYJS(btn_Complete, "Complete");
			resumeCreatedApplication();
			focusTask(lbl_CollateralValuation, "Collateral Valuation Task ");
			assertTaskStatusDone(lbl_CollateralValuationTaskState);
			report.reportPass("Collateral Valuation  Task");
		} catch (Exception e) {
			report.reportHardFail("Collateral Valuation Task Failed");
		}
	}

	public void largeTicketscoringTask() {
		try {
			addAssignedGroup(lbl_ScoringTask, "Scoring Tasks");
			webActions.waitUntilEnabledCubaButton(btn_Perform, "Perform Button");
			webActions.clickBYJS(btn_Perform, "Perform Button");
			webActions.waitAndCickBYJS(btn_BeginWork, "Begin Work");
			waitForTaskStateToBeInProgress();
			webActions.clickBYJS(btn_StartScoringProcess, "Start Scoring process");
			webActions.waitUntilDisplayed(lbl_StartScoringProcessForApplication, "StartScoringProcessForApplication");
			webActions.clickBYJS(btn_Start, "Start");
			webActions.waitUntilDisplayed(btn_AddToSet, "Add To Set");
			selectMatchScore(lbl_TableRow, "Match Score Table Row");
			webActions.waitUntilDisplayed(lbl_CalculationResult, "Cal Result");
			webActions.clickBYJS(btn_OK, "ok");
			webActions.waitUntilNotPresent(btn_OK, "ok");
			webActions.waitAndCickBYJS(btn_Complete, "Complete");
			resumeCreatedApplication();
			focusTask(lbl_ScoringTask, "Collateral Valuation Task ");
			assertTaskStatusDone(lbl_ScoringTaskState);
			report.reportPass("Scoring Task");
		} catch (Exception e) {
			report.reportHardFail("Scoring Task Failed");
		}
	}

	public void approveTask() {
		try {
			addAssignedGroup(lbl_ApproveTask, "Approve Task");
			webActions.waitUntilEnabledCubaButton(btn_Perform, "Perform Button");
			webActions.clickBYJS(btn_Perform, "Perform Button");
			webActions.waitAndCickBYJS(btn_BeginWork, "Begin Work");
			waitForTaskStateToBeInProgress();
			webActions.waitAndCickBYJS(btn_Approve, "Approve");
			webActions.waitAndCickBYJS(btn_DialogYes, "Yes");
			resumeCreatedApplication();
			focusTask(lbl_ApproveTask, "Approve Task");
			assertTaskStatusDone(lbl_ApproveTaskState);
			report.reportPass("Approve Task");
		} catch (Exception e) {
			report.reportHardFail("Approve Task Failed");
		}
	}

	public void standardException() {
		try {
			addAssignedGroup(lbl_StandardExceptionTask, "Standard exception");
			webActions.waitUntilEnabledCubaButton(btn_Perform, "Perform Button");
			webActions.clickBYJS(btn_Perform, "Perform Button");
			webActions.waitAndCickBYJS(btn_BeginWork, "Begin Work");
			waitForTaskStateToBeInProgress();
			webActions.waitAndCickBYJS(btn_AddException, "Add Exception");
			webActions.waitUntilDisplayed(lbl_BusinessExceptionTemplates, "Business Exception Templates");

			/**
			 * In case Exception are not Present for the Task Creating a New one
			 */
			try {
				webActions.doubleClick(lbl_SecondException, "Second Exception");
			} catch (JsonException e) {
				webActions.clickBYJS(btn_CreateException, "Create Exception");
				webActions.waitAndSendKeysByChar(txt_ExceptionName, Faker.instance().lorem().characters(8),
						"Exception Name");
				webActions.clickBYJS(btn_OK, "OK");
				webActions.waitUntilNotPresent(btn_OK, "OK");
				webActions.waitUntilEnabledCubaButton(btn_Select, "Select");
				webActions.clickBYJS(btn_Select, "Select");
				webActions.waitUntilNotPresent(btn_Select, "Select");
			}
			webActions.waitUntilNotPresent(lbl_SecondException, "Second Exception");
			webActions.waitAndCickBYJS(btn_Complete, "Complete");
			resumeCreatedApplication();
			focusTask(lbl_StandardExceptionTask, "Standard Exception");
			assertTaskStatusDone(lbl_StandardExceptionTaskState);
			report.reportPass("Standard exception Task");
		} catch (Exception e) {
			report.reportHardFail("Standard exception Task Failed");
		}
	}

	public void smeApproval() {
		try {
			focusTask(lbl_SMEApproval, "SME Approval");
			webActions.waitUntilEnabledCubaButton(btn_Perform, "Perform Button");
			webActions.clickBYJS(btn_Perform, "Perform Button");
			webActions.waitAndCickBYJS(btn_BeginWork, "Begin Work");
			webActions.waitAndCickBYJS(btn_Approve, "Approve");
			webActions.waitAndCickBYJS(btn_DialogYes, "Yes Button");
			resumeCreatedApplication();
			focusTask(lbl_SMEApproval, "Application Verification");
			assertTaskStatusDone(lbl_SMEApprovalTaskState);
			report.reportPass("SME Approval Task");
		} catch (Exception e) {
			report.reportHardFail("SME Approval Task Failed");
		}
	}

	public void sendApproveLetter() {
		try {
			focusTask(lbl_SendApproveLetter, "Check in Loan Package");
			webActions.waitUntilEnabledCubaButton(btn_Perform, "Perform Button");
			webActions.clickBYJS(btn_Perform, "Perform Button");
			webActions.waitAndCickBYJS(btn_BeginWork, "Begin work");
			webActions.waitUntilDisplayed(btn_Complete, "complete button");
			waitForTaskStateToBeInProgress();
			webActions.waitUntilDisplayed(btn_GenerateLetter, "Generate Letter");
			webActions.clearByJS(txt_Team, "Team");
			webActions.SendKeysByCharAuto(txt_Team, "blueteam.sme@tabbank.com", "Team");
			webActions.clearByJS(txt_TeamDesignation, "Designation");
			webActions.waitAndSendKeysByCharAuto(txt_TeamDesignation, "Blue", "TeamDesignation");
			webActions.clickBYJS(btn_GenerateLetter, "Generate Letter");
			webActions.waitUntilDisplayed(lbl_LettersGeneratedSuccessfullyMessage, "Letter Generated Succsessfully");
			webActions.scrollIntoViewByJS(btn_Complete, "Complete");
			webActions.waitAndCickBYJS(btn_Complete, "Complete");
			resumeCreatedApplication();

			focusTask(lbl_SendApproveLetter, "Application Verification");
			assertTaskStatusDone(lbl_SendApproveLetterState);
			report.reportPass("Send Approve Letter Task");
		} catch (Exception e) {
			report.reportHardFail("Send Approve Letter Task Failed");
		}
	}

	public void equipmentCheckList() {
		try {
			focusTask(lbl_EquipmentChecklistState, "Check in Loan Package");
			webActions.waitUntilEnabledCubaButton(btn_Perform, "Perform Button");
			webActions.clickBYJS(btn_Perform, "Perform Button");
			webActions.waitAndCickBYJS(btn_BeginWork, "Begin work");
			webActions.waitUntilDisplayed(btn_Complete, "Complete");
			webActions.sendKeysByChar(txt_DealershipName, Faker.instance().funnyName().name(), "DealerShip Name");
			webActions.sendKeysByChar(txt_Dealercontact, Faker.instance().internet().emailAddress(), "Dealer Contact");
			webActions.clearAndSendKeysByChar(txt_Dealerphone, Faker.instance().phoneNumber().cellPhone(),
					"Dealer Phone");
			webActions.sendKeysByChar(txt_DealerEmail, Faker.instance().internet().emailAddress(), "Dealer email");
			webActions.waitAndSendKeysByCharAuto(txt_Titlework, "Dealer", "Title Work");
			webActions.waitAndSendKeysByCharAuto(txt_PaymentType, "ACH", "Payment Type");
			webActions.waitAndSendKeysByCharAuto(txt_DealerName, "Northland Credit Corporation", "DealerName");
			webActions.waitAndSendKeysByCharAuto(txt_DealerPhoneNumber,
					"(952)242-9258 <Matt Day> (Work Phone - Primary Phone)", "DealerPhoneNumber");
			webActions.waitAndSendKeysByCharAuto(txt_DealerEmailAddress,
					"mday@northlandcredit.com <Matt Day> (Email - Primary Email)", "DealerEmailAddress");
			// add payment type here ACH
			webActions.sendKeysByChar(txt_DateOpened, DateTime.now().toString("MMddyyyy"), "Date opened");
			webActions.sendKeysByChar(txt_FirstPaymentDate, DateTime.now().toString("MMddyyyy"), "First Payment Date");
			webActions.sendKeysByChar(txt_PaymentAmount, Faker.instance().random().nextInt(500, 600).toString(),
					"Payment Amount");
			webActions.sendKeysByChar(txt_MaturityDate, DateTime.now().plusYears(1).toString("MMddyyyy"),
					"Maturity Date");
			if (getTestDataMap().get("SelectedProduct") != null ? getTestDataMap().get("SelectedProduct").toString()
					.equalsIgnoreCase("Commercial Large Ticket Equipment") : false) {
				webActions.waitAndSendKeysByCharAuto(txt_TeamDesignation, "Blue", "TeamDesignation");
			}
			webActions.scrollIntoViewByJS(btn_Complete, "Complete");
			webActions.waitAndCickBYJS(btn_Complete, "Complete");
			resumeCreatedApplication();

			focusTask(lbl_EquipmentChecklistState, "Application Verification");
			assertTaskStatusDone(lbl_EquipmentChecklistState);
			report.reportPass("Equipment ChecklistTask");
		} catch (Exception e) {
			report.reportHardFail("Equipment Checklist Task Failed");
		}
	}

	public void smeFunding() {
		try {
			focusTask(lbl_SMEFunding, "Check in Loan Package");
			webActions.waitUntilEnabledCubaButton(btn_Perform, "Perform Button");
			webActions.clickBYJS(btn_Perform, "Perform Button");
			webActions.waitAndCickBYJS(btn_BeginWork, "Begin work");
			webActions.waitAndCickBYJS(btn_FinishProcess, "Complete");
			webActions.waitAndCickBYJS(btn_DialogYes, "Yes Button");
			resumeCreatedApplication();

			focusTask(lbl_SMEFunding, "Application Verification");
			assertTaskStatusDone(lbl_SMEFundingState);
			report.reportPass("SME Funding Task");
		} catch (Exception e) {
			report.reportHardFail("SME Funding Task Failed");
		}
	}

	public void smeCreditAnalystApproval() {
		try {
			addAssignedGroup(lbl_SMECreditAnalystApproval, "Check in Loan Package");
			webActions.waitUntilEnabledCubaButton(btn_Perform, "Perform Button");
			webActions.clickBYJS(btn_Perform, "Perform Button");
			webActions.waitAndCickBYJS(btn_BeginWork, "Begin work");
			webActions.waitAndCickBYJS(btn_Approve, "Approve");
			webActions.waitAndCickBYJS(btn_DialogYes, "Yes Button");
			resumeCreatedApplication();

			focusTask(lbl_SMECreditAnalystApproval, "Application Verification");
			assertTaskStatusDone(lbl_SMECreditAnalystApprovalState);
			report.reportPass("SME Credit Analyst Approval Task");
		} catch (Exception e) {
			report.reportHardFail("SME Credit Analyst Approval Task Failed");
		}
	}

	public void seniorSMECreditAnalystApproval() {
		try {
			selectTask(lbl_SeniorCreditAnalystApprovalState, "Check in Loan Package");
			webActions.waitUntilEnabledCubaButton(btn_Perform, "Perform Button");
			webActions.clickBYJS(btn_Perform, "Perform Button");
			webActions.waitAndCickBYJS(btn_BeginWork, "Begin work");
			webActions.waitAndCickBYJS(btn_Approve, "Approve");
			webActions.waitAndCickBYJS(btn_DialogYes, "Yes Button");
			resumeCreatedApplication();

			focusTask(lbl_SeniorCreditAnalystApprovalState, "Application Verification");
			assertTaskStatusDone(lbl_SeniorCreditAnalystApprovalState);
			report.reportPass("Senior SME Credit Analyst Approval Task");
		} catch (Exception e) {
			report.reportHardFail("Senior SME Credit Analyst Approval Task Failed");
		}
	}

	private void selectMatchScore(WebElement element, String elementName) throws Exception {
		int iteration = 0;

		do {
			try {

				webActions.doubleClick(element, elementName);
				Thread.sleep(8000);
				iteration++;

			} catch (Exception e) {
				break;
			}
		} while (iteration < 3);

	}

	public void assignUnderWriterTask() {
		try {
			addAssignedGroup(lbl_AssignUnderwriter, "Assign Underwriter");
			webActions.waitUntilEnabledCubaButton(btn_Perform, "Perform Button");
			webActions.clickBYJS(btn_Perform, "Perform Button");
			webActions.waitAndCickBYJS(btn_BeginWork, "Begin work");
			webActions.waitAndCickBYJS(btn_Complete, "Complete");
			resumeCreatedApplication();

			focusTask(lbl_AssignUnderwriter, "Assign Underwriter");
			assertTaskStatusDone(lbl_AssignUnderwriterState);
			report.reportPass("Assign UnderWriter Task");
		} catch (Exception e) {
			report.reportHardFail("Assign UnderWriter Task Failed");
		}
	}

	public void scoringTask() {

		try {
			addAssignedGroup(lbl_ScoringTask, "Scoring Task");
			webActions.waitUntilEnabledCubaButton(btn_Perform, "Perform Button");
			webActions.clickBYJS(btn_Perform, "Perform Button");
			webActions.waitAndCickBYJS(btn_BeginWork, "Begin Work");
			waitForTaskStateToBeInProgress();
//			webActions.clickBYJS(btn_RequestProviders, "Request Providers");
//			webActions.waitUntilDisplayed(lbl_ResponseReceived, "Response Received");
//			webActions.clickBYJS(btn_OK, "ok");
//			webActions.waitUntilNotPresent(btn_OK, "ok");
//			webActions.waitUntilDisplayed(btn_AddToSet, "Add To Set");
//			selectMatchScore(lbl_TableRow, "Match Score Table Row");
//			webActions.waitUntilDisplayed(lbl_CalculationResult, "Cal Result");
//			webActions.clickBYJS(btn_OK, "ok");
//			webActions.waitUntilNotPresent(btn_OK, "ok");
			webActions.waitAndCickBYJS(btn_Complete, "Complete");
			resumeCreatedApplication();
			focusTask(lbl_ScoringTask, "Scoring Task");
			assertTaskStatusDone(lbl_ScoringTaskState);
			report.reportPass("Scoring Task");
		} catch (Exception e) {
			report.reportHardFail("Scoring Task Failed");
		}
	}

	public void backgroundSearchesUCCFilingsTaskTask() {

		try {

			addAssignedGroup(lbl_BackGroundSearchsUCCFilingsTask, "BackGround Searchs UCC Filings Task");
			webActions.waitUntilEnabledCubaButton(btn_Perform, "Perform Button");
			webActions.clickBYJS(btn_Perform, "Perform Button");
			webActions.waitAndCickBYJS(btn_BeginWork, "Begin Work");
			waitForTaskStateToBeInProgress();
			webActions.waitAndCickBYJS(btn_Complete, "Complete");
			resumeCreatedApplication();
			focusTask(lbl_BackGroundSearchsUCCFilingsTask, "BackGround Searchs UCC Filings Task");
			assertTaskStatusDone(lbl_BackGroundSearchsUCCFilingsTaskState);
			report.reportPass("BackGround Searchs UCC Filings Task");
		} catch (Exception e) {
			report.reportHardFail("BackGround Searchs UCC Filing Task Failed");
		}
	}

	public void DebtorCreditReviewTask() {

		try {
			addAssignedGroup(lbl_DebtorCreditReview, "Debtor Credit Review");
			webActions.waitUntilEnabledCubaButton(btn_Perform, "Perform Button");
			webActions.clickBYJS(btn_Perform, "Perform Button");
			webActions.waitAndCickBYJS(btn_BeginWork, "Begin Work");
			waitForTaskStateToBeInProgress();
			webActions.waitAndCickBYJS(btn_Complete, "Complete");
			resumeCreatedApplication();
			focusTask(lbl_DebtorCreditReview, "Debtor Credit Review");
			assertTaskStatusDone(lbl_DebtorCreditReviewTaskState);
			report.reportPass("Debtor Credit Review Task");
		} catch (Exception e) {
			report.reportHardFail("Debtor Credit Review Task Failed");
		}
	}

	public void TaxGuardReport8821() {
		try {
			addAssignedGroup(lbl_TaxGuardReport8821, "Tax Guard Report 8821");
			webActions.waitUntilEnabledCubaButton(btn_Perform, "Perform Button");
			webActions.clickBYJS(btn_Perform, "Perform Button");
			webActions.waitAndCickBYJS(btn_BeginWork, "Begin Work");
			waitForTaskStateToBeInProgress();
			webActions.clickBYJS(chk_TaxGuardSentForApproval, "Tax Guard sent for Approval");
			webActions.clickBYJS(chk_8821ReceivedAndTaxGuardOrderes, "8821 Received & Tax Guard Ordered");
			webActions.clickBYJS(chk_TaxGuardApproved, "Tax Guard Approved");
			webActions.clickBYJS(chk_8821CreatedAndSent, "8821 Created & Sent");
			webActions.clickBYJS(chk_AttachmentsSaved, "Attachments Saved");
			webActions.waitUntilDisplayed(lbl_ConfirmCompleteTask, "Confirm Complete Task");
			webActions.clickBYJS(btn_DialogYes, "Complete Task Dialog yes");
			resumeCreatedApplication();
			focusTask(lbl_TaxGuardReport8821, "Check in Loan Package");
			assertTaskStatusDone(lbl_TaxGuardReport8821TaskState);
			report.reportPass("TaxGuard Report 8821 Task");
		} catch (Exception e) {
			report.reportHardFail("TaxGuard Report 8821 Task Failed");
		}
	}

	public void tmsDiscoveryAndSetup() {
		try {
			addAccountSection();
			addAssignedGroup(lbl_TMSDiscoveryAndSetup, "TMS Discovery and Setup");
			webActions.waitUntilEnabledCubaButton(btn_Perform, "Perform Button");
			webActions.clickBYJS(btn_Perform, "Perform Button");
			webActions.waitAndCickBYJS(btn_BeginWork, "Begin Work");

			waitForTaskStateToBeInProgress();
			webActions.waitAndCickBYJS(btn_Complete, "Complete");
			resumeCreatedApplication();
			focusTask(lbl_TMSDiscoveryAndSetup, "TMS Discovery and Setup ");
			assertTaskStatusDone(lbl_TMSDiscoveryAndSetupTaskState);
			report.reportPass("TMS Discovery and Setup Task");
		} catch (Exception e) {
			report.reportHardFail("TMS Discovery and Setup Task Failed");
		}
	}

	private void addAccountSection() {
		try {
			webActions.scrollIntoViewByJS(txt_InitialFundingAmount, "Initial Funding Amount");
			webActions.sendKeysByChar(txt_InitialFundingAmount, Faker.instance().number().numberBetween(100, 500) + "",
					"Initial Funding Amount");
			webActions.sendKeysByChar(txt_FirstFundDate, DateTime.now().toString("MMddyyyy"), "First Fund Date");
			if (getTestDataMap().get("SelectedProduct").toString()
					.equalsIgnoreCase("Commercial Large Ticket Factoring")) {
				webActions.sendKeysByChar(txt_FSAccount, Faker.instance().lorem().characters(6) + "", "FS Account");
				webActions.sendKeysByChar(txt_TermLoanAccount, Faker.instance().number().numberBetween(100, 500) + "",
						"Term Loan Amount");
				webActions.sendKeysByChar(txt_OperatingAccount, Faker.instance().number().numberBetween(100, 500) + "",
						"Operating Account");

			} else {
				webActions.sendKeysByChar(txt_StuckyAccount, Faker.instance().number().numberBetween(100, 500) + "",
						"Stucky Account");
				webActions.sendKeysByChar(txt_LockBox, Faker.instance().number().numberBetween(100, 500) + "",
						"Lock Box");
				webActions.sendKeysByChar(txt_OperatingAccounts, Faker.instance().number().numberBetween(100, 500) + "",
						"Operating Accounts");
				webActions.sendKeysByChar(txt_38OperatingAccounts,
						Faker.instance().number().numberBetween(100, 500) + "", "38 Operating Account");
			}
			clickSaveButton();
			webActions.waitUntilDisplayed(lbl_ApplicationSaved, "Application Saved Label");
			report.reportPass("Add Account Section Saved");
		} catch (Exception e) {
			report.reportHardFail("Add Account Section Saved Failed");
		}
	}

	public void legalsPrepration() {
		try {
			addAssignedGroup(lbl_LegalsPeparation, "Legals preparation");
			webActions.waitUntilEnabledCubaButton(btn_Perform, "Perform Button");
			webActions.clickBYJS(btn_Perform, "Perform Button");
			webActions.waitAndCickBYJS(btn_BeginWork, "Begin Work");

			waitForTaskStateToBeInProgress();
			webActions.waitAndCickBYJS(btn_Complete, "Complete");
			resumeCreatedApplication();
			focusTask(lbl_LegalsPeparation, "TMS Discovery and Setup ");
			assertTaskStatusDone(lbl_LegalsPeparationTaskState);
			report.reportPass("Legals preparation Task");
		} catch (Exception e) {
			report.reportHardFail("Legals preparation Task Failed");
		}
	}

	public void legalDocsExecution() {
		try {
			addAssignedGroup(lbl_LegalDocsExecution, "Legal Docs Execution");
			webActions.waitUntilEnabledCubaButton(btn_Perform, "Perform Button");
			webActions.clickBYJS(btn_Perform, "Perform Button");
			webActions.waitAndCickBYJS(btn_BeginWork, "Begin Work");

			waitForTaskStateToBeInProgress();
			webActions.clickBYJS(chk_FullyExecutedDocsReceived, "Fully Executed Docs Received");
			webActions.clickBYJS(chk_LegalsSent, "Legals Sent");
			webActions.waitAndCickBYJS(btn_Complete, "Complete");
			resumeCreatedApplication();
			focusTask(lbl_LegalDocsExecution, "Legal Docs Execution");
			assertTaskStatusDone(lbl_LegalDocsExecutionTaskState);
			report.reportPass("Legal Docs Execution Task");
		} catch (Exception e) {
			report.reportHardFail("Legal Docs Execution Task Failed");
		}
	}
	public void legalDocuments() {
		try {
			addAssignedGroup(lbl_LegalDocuments, "Documents");
			webActions.waitUntilEnabledCubaButton(btn_Perform, "Perform Button");
			webActions.clickBYJS(btn_Perform, "Perform Button");
			webActions.waitAndCickBYJS(btn_BeginWork, "Begin Work");

			waitForTaskStateToBeInProgress(); 
			webActions.waitAndCickBYJS(btn_Complete, "Complete");
			resumeCreatedApplication();
			focusTask(lbl_LegalDocuments, "Legal Docs Execution");
			assertTaskStatusDone(lbl_LegalDocumentsTaskState);
			report.reportPass("Legal Documents Task");
		} catch (Exception e) {
			report.reportHardFail("Legal Documents Task Failed");
		}
	}
	public void loanAccountSetup() {
		try {
			addAssignedGroup(lbl_LoanAccountSetup, "Loan Account Setup");
			webActions.waitUntilEnabledCubaButton(btn_Perform, "Perform Button");
			webActions.clickBYJS(btn_Perform, "Perform Button");
			webActions.waitAndCickBYJS(btn_BeginWork, "Begin Work");

			waitForTaskStateToBeInProgress();
			webActions.waitAndCickBYJS(btn_Complete, "Complete");
			resumeCreatedApplication();
			focusTask(lbl_LoanAccountSetup, "Loan Account Setup");
			assertTaskStatusDone(lbl_LoanAccountSetupTaskState);
			report.reportPass("Loan Account Setup Task");
		} catch (Exception e) {
			report.reportHardFail("Loan Account Setup Task Failed");
		}
	}

	public void prefundingLegalReview() {
		try {
			addAssignedGroup(lbl_PrefundingLegalReview, "Prefunding Legal Review");
			webActions.waitUntilEnabledCubaButton(btn_Perform, "Perform Button");
			webActions.clickBYJS(btn_Perform, "Perform Button");
			webActions.waitAndCickBYJS(btn_BeginWork, "Begin Work");

			waitForTaskStateToBeInProgress();
			webActions.waitAndCickBYJS(btn_Complete, "Complete");
			resumeCreatedApplication();
			focusTask(lbl_PrefundingLegalReview, "Prefunding Legal Review");
			assertTaskStatusDone(lbl_PrefundingLegalReviewTaskState);
			report.reportPass("Prefunding Legal Review Task");
		} catch (Exception e) {
			report.reportHardFail("Prefunding Legal Review Task Failed");
		}
	}

	public void fundingTask() {
		try {
			addAssignedGroup(lbl_Funding, "Funding");
			webActions.waitUntilEnabledCubaButton(btn_Perform, "Perform Button");
			webActions.clickBYJS(btn_Perform, "Perform Button");
			webActions.waitAndCickBYJS(btn_BeginWork, "Begin Work");

			waitForTaskStateToBeInProgress();
			webActions.waitAndCickBYJS(btn_FinishProcess, "Finish process");
			webActions.waitAndCickBYJS(btn_DialogYes, "Yes Button");
			resumeCreatedApplication();
			focusTask(lbl_Funding, "Funding");
			assertTaskStatusDone(lbl_FundingTaskState);
			report.reportPass("Funding Task");
		} catch (Exception e) {
			report.reportHardFail("Funding Task Failed");
		}
	}

	public void tmsOnBoarding() {
		try {

			addAssignedGroup(lbl_TMSOnBoarding, "TMS OnBoarding");
			webActions.waitUntilEnabledCubaButton(btn_Perform, "Perform Button");
			webActions.clickBYJS(btn_Perform, "Perform Button");
			webActions.waitAndCickBYJS(btn_BeginWork, "Begin Work");

			waitForTaskStateToBeInProgress();
			webActions.waitAndCickBYJS(btn_Complete, "Complete");
			resumeCreatedApplication();
			focusTask(lbl_TMSOnBoarding, "TMS OnBoarding");
			assertTaskStatusDone(llbl_TMSOnBoardingTaskState);
			report.reportPass("TMS OnBoarding Task");
		} catch (Exception e) {
			report.reportHardFail("TMS OnBoarding Task Failed");
		}
	}

	public void attachSignedApplicationAndTermSheetTask() {

		try {
			addAssignedGroup(lbl_AttachSignedApplicationAndTermSheetTask,
					"Attach Signed Application and Term Sheet Task");
			webActions.waitUntilEnabledCubaButton(btn_Perform, "Perform Button");
			webActions.clickBYJS(btn_Perform, "Perform Button");
			webActions.waitAndCickBYJS(btn_BeginWork, "Begin Work");
			waitForTaskStateToBeInProgress();
			webActions.waitAndCickBYJS(btn_Complete, "Complete");
			resumeCreatedApplication();
			focusTask(lbl_AttachSignedApplicationAndTermSheetTask, "Attach Signed Application and Term Sheet Task");
			assertTaskStatusDone(lbl_AttachSignedApplicationAndTermSheetTaskState);
			report.reportPass("Attach Signed Application and Term Sheet Task");
		} catch (Exception e) {
			report.reportHardFail("Attach Signed Application and Term Sheet Task Failed");
		}
	}

	public void generateVerificationLetter() {

		try {
			addAssignedGroup(lbl_GenerateVerificationLetterTask, "Generate Verification Letter");
			webActions.waitUntilEnabledCubaButton(btn_Perform, "Perform Button");
			webActions.clickBYJS(btn_Perform, "Perform Button");
			webActions.waitAndCickBYJS(btn_BeginWork, "Begin Work");
			waitForTaskStateToBeInProgress();
			webActions.clickBYJS(btn_GenerateLetter, "Generate Letter");
			webActions.waitUntilDisplayed(lbl_LettersGeneratedSuccessfullyMessage, "Letters Generated Successfully");
			webActions.waitAndCickBYJS(btn_Complete, "Complete");
			resumeCreatedApplication();
			focusTask(lbl_GenerateVerificationLetterTask, "Generate Verification Letter Task");
			assertTaskStatusDone(lbl_GenerateVerificationLetterTaskState);
			report.reportPass("Generate Verification Letter Task");
		} catch (Exception e) {
			report.reportHardFail("Generate Verification Letter Task Failed");
		}
	}

	public void approveOneTask() {

		try {
			addAssignedGroup(lbl_ApproveOne, "Approve (1)");
			webActions.waitUntilEnabledCubaButton(btn_Perform, "Perform Button");
			webActions.clickBYJS(btn_Perform, "Perform Button");
			webActions.waitAndCickBYJS(btn_BeginWork, "Begin Work");
			waitForTaskStateToBeInProgress();
			webActions.waitAndCickBYJS(btn_Approve, "Approve");
			webActions.waitAndCickBYJS(btn_DialogYes, "Approve Dialog Yes");
			resumeCreatedApplication();
			focusTask(lbl_ApproveOne, "Approve (1) Task");
			assertTaskStatusDone(lbl_ApproveOneTaskState);
			report.reportPass("Approve (1) Task");
		} catch (Exception e) {
			report.reportHardFail("Approve (1) Task Failed");
		}
	}

	public void approveTwoTask() {

		try {
			addAssignedGroup(lbl_ApproveTwo, "Approve (2)");
			webActions.waitUntilEnabledCubaButton(btn_Perform, "Perform Button");
			webActions.clickBYJS(btn_Perform, "Perform Button");
			webActions.waitAndCickBYJS(btn_BeginWork, "Begin Work");
			waitForTaskStateToBeInProgress();
			webActions.waitAndCickBYJS(btn_Approve, "Approve");
			webActions.waitAndCickBYJS(btn_DialogYes, "Approve Dialog Yes");
			resumeCreatedApplication();
			focusTask(lbl_ApproveTwo, "Approve (2) Task");
			assertTaskStatusDone(lbl_ApproveTwoTaskState);
			report.reportPass("Approve (2) Task");
		} catch (Exception e) {
			report.reportHardFail("Approve (2) Task Failed");
		}
	}

	public void arVerification() {

		try {
			addAssignedGroup(lbl_ARVerification, "A/R Verification");
			webActions.waitUntilEnabledCubaButton(btn_Perform, "Perform Button");
			webActions.clickBYJS(btn_Perform, "Perform Button");
			webActions.waitAndCickBYJS(btn_BeginWork, "Begin Work");
			waitForTaskStateToBeInProgress();
			webActions.waitAndCickBYJS(btn_Complete, "Complete");
			resumeCreatedApplication();
			focusTask(lbl_ARVerification, "A/R Verification Task");
			assertTaskStatusDone(lbl_ARVerificationTaskState);
			report.reportPass("A/R Verification Task");
		} catch (Exception e) {
			report.reportHardFail("A/R Verification Task Failed");
		}
	}

	public void prefundingReview() {
		try {
			addAssignedGroup(lbl_PrefundingReview, "Prefunding  Review");
			webActions.waitUntilEnabledCubaButton(btn_Perform, "Perform Button");
			webActions.clickBYJS(btn_Perform, "Perform Button");
			webActions.waitAndCickBYJS(btn_BeginWork, "Begin Work");

			waitForTaskStateToBeInProgress();
			webActions.waitAndCickBYJS(btn_Complete, "Complete");
			resumeCreatedApplication();
			focusTask(lbl_PrefundingReview, "Prefunding  Review");
			assertTaskStatusDone(lbl_PrefundingReviewTaskState);
			report.reportPass("Prefunding  Review Task");
		} catch (Exception e) {
			report.reportHardFail("Prefunding  Review Task Failed");
		}
	}
	public void declineReview() {
		try {
			addAssignedGroup(lbl_DeclineReview, "Decline  Review");
			webActions.waitUntilEnabledCubaButton(btn_Perform, "Perform Button");
			webActions.clickBYJS(btn_Perform, "Perform Button");
			webActions.waitAndCickBYJS(btn_BeginReview, "Begin Review");

			waitForTaskStateToBeInProgress();
			webActions.waitAndCickBYJS(btn_Complete, "Complete");
			resumeCreatedApplication();
			focusTask(lbl_PrefundingReview, "Prefunding  Review");
			assertTaskStatusDone(lbl_PrefundingReviewTaskState);
			report.reportPass("Prefunding  Review Task");
		} catch (Exception e) {
			report.reportHardFail("Prefunding  Review Task Failed");
		}
	}
	private void waitForTaskStateToBeInProgress() {
		webActions.waitForTextToBePresentInValue(txt_TaskState, "In progress", "Task State");
	}

	private void assertTaskStatusDone(WebElement element) throws Exception {
		global.assertStringEquals(element.getText(), "Done");
	}
}
