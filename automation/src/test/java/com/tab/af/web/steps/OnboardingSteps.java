package com.tab.af.web.steps;

import java.util.List;
import java.util.Map;

import com.tab.af.web.pages.OnBoarding.ApplicationCreation;
import com.tab.af.web.pages.OnBoarding.ApplicationEditor;
import com.tab.af.web.pages.OnBoarding.ApplicationsHome;
import com.tab.af.web.pages.OnBoarding.DepositTasks;
import com.tab.af.web.pages.OnBoarding.LoanTasks;
import com.tab.af.web.pages.OnBoarding.Login;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class OnboardingSteps {

	Login login = new Login();
	ApplicationsHome home = new ApplicationsHome();;
	ApplicationCreation app = new ApplicationCreation();
	DepositTasks depositTask = new DepositTasks();
	LoanTasks loanTask = new LoanTasks();
	ApplicationEditor appEditor = new ApplicationEditor();

	@Given("user logged into Onboarding")
	public void user_logged_into_Onboarding() {

		home = login.loginToApplication();
	}

	@Given("User is Starting to create a Product")
	public void user_is_Starting_to_create_a_Product() {

		app = home.openApplications();
	}

	@When("user creates a Deposit product with specfications and Clicks create")
	public void user_creates_a_Deposit_product_with_specfications_and_Clicks_create(DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		app.createDepositProduct(data.get(0).get("ProductLine"), data.get(0).get("ProductType"),
				data.get(0).get("CustomerType"), data.get(0).get("ProductName"));

	}

	@When("user creates a Loan product with specifications and Clicks create")
	public void user_creates_a_Loan_product_with_specifications_and_Clicks_create(
			io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		app.createLoanProduct(data.get(0).get("ProductLine"), data.get(0).get("ProductType"),
				data.get(0).get("CustomerType"), data.get(0).get("ProductName"));
	}

	@When("Fills the Details for the Individual Information")
	public void fills_the_Details_for_the_Individual_Information() {
		app.fillIndividualBasicandDrivingInfo();
		app.fillPhysicalAddressDetails();
		app.selectMailingAddessSameAsPhysical();
		app.fillPhonesInfo();
		appEditor = app.startDepositProcess();

	}

	@When("Fills the Details for the Legal Entity")
	public void fills_the_Details_for_the_Legal_Entity(DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		app.fillLegalEntityInfo(data.get(0).get("LegalEntity"));
		app.fillPhysicalAddressDetails();
		app.selectMailingAddessSameAsPhysical();
		app.fillPhonesInfo();
		appEditor = app.startDepositProcess();
	}

	@When("Fills the Details for the Loans Legal Entity")
	public void fills_the_Details_for_the_Loans_Legal_Entity(io.cucumber.datatable.DataTable dataTable)
			throws Exception {
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		app.fillLegalEntityInfo(data.get(0).get("LegalEntity"));
		app.fillPhysicalAddressDetails();
		app.selectMailingAddessSameAsPhysical();
		app.fillPhonesInfo();

	}

	@Then("Product should be added in OnBoarding results Table")
	public void product_should_be_added_in_OnBoarding_results_Table() {

		appEditor.selectcreatedDepositApplication();
		depositTask = appEditor.openDepositProduct();

	}

	@Then("Entity details should be saved")
	public void entity_details_should_be_saved() {
		app.assertEntityInfoSaved();

	}

	@When("User fills opportunity ,collateral and Equipment Info and starts Process")
	public void user_fills_opportunity_collateral_and_Equipment_Info_and_starts_Process(
			io.cucumber.datatable.DataTable dataTable) {

		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		app.fillOpportunityInfo(data.get(0).get("BusinessType"), data.get(0).get("Amount"));
		app.fillEquipmentInfo();
		app.addLoanIndividualInfo();
		app.updateLoanIndividualGuarantor();
		appEditor = app.startLoanProcess();

	}

	@When("User fills opportunity ,collateral  and starts Process")
	public void user_fills_opportunity_collateral_and_starts_Process(io.cucumber.datatable.DataTable dataTable) {

		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		app.fillOpportunityInfo(data.get(0).get("BusinessType"), data.get(0).get("Amount"));
		app.addLoanIndividualInfo();
		app.updateLoanIndividualGuarantor();
		appEditor = app.startLoanProcess();
	}

	@Then("user should be able to Start the Process")
	public void user_should_be_able_to_Start_the_Process() {
		appEditor.selectcreatedLoanApplication();
		loanTask = appEditor.openLoanProduct();
	}

	@Then("User should be able to Complete Verifications and Create account")
	public void user_should_be_able_to_Complete_Verifications_and_Create_account() {

		depositTask.completeSingleConsumerDepositTasks();
		depositTask.verifyAccountCreated("Applicant1");
	}

	@Then("User should be able to Complete commercial Verifications and Create account")
	public void user_should_be_able_to_Complete_commercial_Verifications_and_Create_account() {
		depositTask.completeCommercialDepositTasks();
		depositTask.verifyCIFAccountCreated();
	}

	@Then("User should be able to Complete consumer COD Verifications and Create account")
	public void User_should_be_able_to_Complete_consumer_COD_Verifications_and_Create_account() {

		depositTask.completeApplicationVerificationTask();
		depositTask.customerVerificationQATask();
		depositTask.completeDecisionTask();
		depositTask.completeCIFAccountCreationTask();
		depositTask.completeSendWelcomeEmailTask();
		depositTask.completeFundingTask();
	}

	@Then("User should be able to Complete commercial COD Verifications and Create account")
	public void user_should_be_able_to_Complete_commercial_COD_Verifications_and_Create_account() {
		User_should_be_able_to_Complete_consumer_COD_Verifications_and_Create_account();

	}

	@Then("User should be able to Complete commercial Savings Verifications and Create account")
	public void user_should_be_able_to_Complete_commercial_Savings_Verifications_and_Create_account() {
		User_should_be_able_to_Complete_consumer_COD_Verifications_and_Create_account();
	}

	@Then("Complete the tasks generated for Small Ticket Loan")
	public void complete_the_tasks_generated_for_Small_Ticket_Loan() {

		loanTask.checkInLoanPackage();
		loanTask.compileSmallTicketCreditSummary();
		loanTask.standardException();
		loanTask.smeCreditAnalystApproval();
		loanTask.sendApproveLetter();
		loanTask.equipmentCheckList();
		loanTask.smeFunding();
	}

	@When("user completes the task generated for Large Ticket Loan")
	public void user_completes_the_task_generated_for_Large_Ticket_Loan() {
		loanTask.checkInLoanPackage();
		loanTask.compileCreditSummary();
		loanTask.collateralValuation();
		loanTask.largeTicketscoringTask();
		loanTask.standardException();
		loanTask.equipmentCheckList();
		loanTask.approveTask();
		loanTask.sendApproveLetter();
		loanTask.smeFunding();

	}

	@When("Fills the Details for the Joint Applicant")
	public void fills_the_Details_for_the_Joint_Applicant() {
		app.fillIndividualBasicandDrivingInfo();
		app.fillPhysicalAddressDetails();
		app.selectMailingAddessSameAsPhysical();
		app.fillPhonesInfo();
		app.createApplicant();
		app.addSecondJointHolder();
		appEditor = app.startDepositProcess();

	}

	@Then("User should be able to Complete Joint Applicant Verifications and Create account")
	public void user_should_be_able_to_Complete_Joint_Applicant_Verifications_and_Create_account() {
		depositTask.completeApplicationVerificationTask();
		depositTask.completeApproveVerificationTask("Applicant1");
		depositTask.completeApproveVerificationTask("Applicant2");
		depositTask.verifyAccountCreated("Applicant1");
		depositTask.verifyAccountCreated("Applicant2");
	}

	@When("Fills the Details for the Joint Legal Entity")
	public void fills_the_Details_for_the_Joint_Legal_Entity(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		app.fillLegalEntityInfo(data.get(0).get("LegalEntity"));
		app.fillPhysicalAddressDetails();
		app.selectMailingAddessSameAsPhysical();
		app.fillPhonesInfo();
		app.selectLegalEntity(data.get(1).get("LegalEntity"));
		app.secondLegalEntityInfo(data.get(1).get("LegalEntity"));
		appEditor = app.startDepositProcess();
	}

	@When("user completes the task generated for ABL Loan")
	public void user_completes_the_task_generated_for_ABL_Loan() {
		loanTask.checkInLoanPackage();
		loanTask.scoringTask();
		loanTask.backgroundSearchesUCCFilingsTaskTask();
		loanTask.DebtorCreditReviewTask();
		loanTask.assignUnderWriterTask();
		loanTask.compileCreditSummary();
		loanTask.TaxGuardReport8821();
		loanTask.legalsPrepration();
		loanTask.tmsDiscoveryAndSetup();
		loanTask.standardException();
		loanTask.approveTask();
		loanTask.legalDocsExecution();
		loanTask.loanAccountSetup();
		loanTask.prefundingLegalReview();
		loanTask.fundingTask();
	}

	@When("user completes the task generated for Participation Loan")
	public void user_completes_the_task_generated_for_Participation_Loan() {
		loanTask.checkInLoanPackage();
		loanTask.scoringTask();
		loanTask.backgroundSearchesUCCFilingsTaskTask();
		loanTask.assignUnderWriterTask();
		loanTask.compileCreditSummary();
		loanTask.TaxGuardReport8821();
		loanTask.legalsPrepration();
		loanTask.tmsOnBoarding();
		loanTask.standardException();
		loanTask.approveTask();
		loanTask.legalDocsExecution();
		loanTask.loanAccountSetup();
		loanTask.prefundingLegalReview();
		loanTask.fundingTask();
	}

	@When("user completes the task generated for Rediscount Loan")
	public void user_completes_the_task_generated_for_Rediscount_Loan() {
		loanTask.checkInLoanPackage();
		loanTask.scoringTask();
		loanTask.backgroundSearchesUCCFilingsTaskTask();
		loanTask.assignUnderWriterTask();
		loanTask.compileCreditSummary();
		loanTask.TaxGuardReport8821();
		loanTask.legalsPrepration();
		loanTask.tmsOnBoarding();
		loanTask.standardException();
		loanTask.approveTask();
		loanTask.legalDocsExecution();
		loanTask.loanAccountSetup();
		loanTask.prefundingLegalReview();
		loanTask.fundingTask();
	}

	@When("user completes the task generated for Small Ticket Factoring Loan")
	public void user_completes_the_task_generated_for_Small_Ticket_Factoring_Loan() {
		loanTask.attachSignedApplicationAndTermSheetTask();
		loanTask.generateVerificationLetter();
		loanTask.backgroundSearchesUCCFilingsTaskTask();
		loanTask.scoringTask();
		loanTask.DebtorCreditReviewTask();
		loanTask.TaxGuardReport8821();
		loanTask.standardException();
		loanTask.approveOneTask();
		home.logOut();
		login.loginAs("admin", "abc123");
		home.openApplications();
		appEditor.selectcreatedLoanApplication();
		loanTask.approveTwoTask();
		loanTask.arVerification();
		loanTask.tmsOnBoarding();
		loanTask.legalsPrepration();
		loanTask.legalDocsExecution();
		loanTask.loanAccountSetup();
		loanTask.prefundingReview();
		loanTask.fundingTask();
	}

	@When("user completes the task generated for Large Ticket Factoring Loan")
	public void user_completes_the_task_generated_for_Large_Ticket_Factoring_Loan() {
		loanTask.checkInLoanPackage();
		loanTask.scoringTask();
		loanTask.DebtorCreditReviewTask();
		loanTask.backgroundSearchesUCCFilingsTaskTask();
		loanTask.arVerification();
		loanTask.compileCreditSummary();
		loanTask.TaxGuardReport8821();
		loanTask.legalsPrepration();
		loanTask.tmsDiscoveryAndSetup();
		loanTask.standardException();
		loanTask.approveTask();
		loanTask.legalDocsExecution();
		loanTask.loanAccountSetup();
		loanTask.prefundingLegalReview();
		loanTask.fundingTask();

	}

	@When("user adds Indiviudal Info Starts the Loan Process")
	public void user_adds_Indiviudal_Info_Starts_the_Loan_Process() {
		app.addLoanIndividualInfo();
		app.updateLoanIndividualGuarantor();
		appEditor = app.startLoanProcess();
		appEditor.selectcreatedLoanApplication();
		loanTask = appEditor.openLoanProduct();
	}

	@Then("user completes the task generated for Smart Loan")
	public void user_completes_the_task_generated_for_Smart_Loan() {
		loanTask.backgroundSearchesUCCFilingsTaskTask();
		loanTask.scoringTask();
		loanTask.compileCreditSummary();
		loanTask.standardException();
		loanTask.approveOneTask();
		loanTask.legalDocuments();
		loanTask.fundingTask();
	}

	@When("Fills Individual Info and starts the process")
	public void fills_Individual_Info_and_starts_the_process() {
		app.fillIndividualBasicandDrivingInfo();
		app.fillPhysicalAddressDetails();
		app.selectMailingAddessSameAsPhysical();
		app.fillPhonesInfo();
		appEditor = app.startDepositProcess();
	}

	@Then("User should be Able to Decline the Application from HomePage")
	public void user_should_be_Able_to_Decline_the_Application_from_HomePage() {
		appEditor.declineDepositApplication();
	}

	@Then("User should be Able to WithDraw the Application from HomePage")
	public void user_should_be_Able_to_WithDraw_the_Application_from_HomePage() {
		appEditor.withDrawDepositApplication();
	}

	@When("user Starts process for Declined Application from HomePage")
	public void user_Starts_process_for_Declined_Application_from_HomePage() {
		home.openApplications();
		appEditor.startProcessFromHomePage();
		depositTask = appEditor.openDepositProduct();
	}

	@Then("User should be able to complete the Deposit tasks")
	public void user_should_be_able_to_complete_the_Deposit_tasks() {
		depositTask.completeApplicationVerificationTask();
		depositTask.completeApproveVerificationTask("Applicant1");
		depositTask.completeDOAWelcomeMailTask();
		depositTask.completeDOAFundingTask();
		depositTask.verifyAccountCreated("Applicant1");
	}

	@Then("User should be able to Request and Send KIQ Questions")
	public void user_should_be_able_to_Request_and_Send_KIQ_Questions() {
		depositTask.completeApplicationVerificationTask();
		depositTask.completeApproveVerificationTask("Applicant1");
	}

	@When("User Declines the Loan Application from HomePage")
	public void user_Declines_the_Loan_Application_from_HomePage() {
		home.openApplications();
		appEditor.declineLoanApplication();
		home.openApplications();
		appEditor.startProcessFromHomePage();
		loanTask = appEditor.openLoanProduct();
	}

	@Then("User should be able to Restart process for Declined Application from HomePage")
	public void user_should_be_able_to_Restart_process_for_Declined_Application_from_HomePage() {
		complete_the_tasks_generated_for_Small_Ticket_Loan();
	}
	
	
	@When("User navigates to Applications homepage")
	public void user_navigates_to_Applications_homepage() {
	  home.openApplications();
	}

	@Then("User should be Able to WithDraw the Loan Application from HomePage")
	public void user_should_be_Able_to_WithDraw_the_Loan_Application_from_HomePage() {
	   appEditor.withDrawLoanApplication();
	}
	
	
	@Then("User should be able to Complete the Decline task generated for Small Ticket Loan")
	public void user_should_be_able_to_Complete_the_Decline_task_generated_for_Small_Ticket_Loan() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

}
