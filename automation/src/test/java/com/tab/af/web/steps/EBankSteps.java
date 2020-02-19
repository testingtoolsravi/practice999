package com.tab.af.web.steps;

import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;

import com.tab.af.web.pages.EBank.AccessGroups;
import com.tab.af.web.pages.EBank.BatchTransactionHistory;
import com.tab.af.web.pages.EBank.HomePage;
import com.tab.af.web.pages.EBank.InterestRates;
import com.tab.af.web.pages.EBank.JournalAccess;
import com.tab.af.web.pages.EBank.Login;
import com.tab.af.web.pages.EBank.ScheduledTasks;
import com.tab.af.web.pages.EBank.TemplateManagement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class EBankSteps {

	Login login = new Login();
	AccessGroups access = new AccessGroups();
	JournalAccess journal = new JournalAccess();
	TemplateManagement template = new TemplateManagement();
	BatchTransactionHistory batch = new BatchTransactionHistory();
	HomePage home = new HomePage();
	InterestRates interest = new InterestRates();
	ScheduledTasks scheduledTask= new ScheduledTasks();
	@Given("user logged into EBank as {string} and {string}")
	public void user_logged_into_EBank_as_and(String userName, String password) {
		home = login.login(userName, password);
		
	}

	@Given("User is Logged in and All options are Displayed")
	public void user_is_Logged_in_and_All_options_are_Displayed() {
		
		 home.verifyAvailableTabs();
	}

	@When("User navigates to Acess Group and create a new Access Group")
	public void user_navigates_to_Acess_Group_and_create_a_new_Access_Group(DataTable table) {
		access = home.openAccessGroups();
		List<Map<String, String>> data = table.asMaps(String.class, String.class);
		access.createAccessGroup(data.get(0).get("userAccessGroup"), data.get(0).get("accountAccessType"),
				data.get(0).get("accountNumber"), data.get(0).get("branch"), data.get(0).get("type"));
	}

	@Then("Access group should be created Successfully")
	public void access_group_should_be_created_Successfully() {

		access.validateAccessGroupCreatedSuccesfully();

	}

	@Then("user should be able to edit search download and remove actions Successfully")
	public void user_should_be_able_to_edit_search_download_and_remove_actions_Successfully() {
		access.editAccessGroup("Anonymous [anonymous]");
		access.exportAccessGroupData();
		access.validateSearch();
		access.removeAccessGroup();
	}

	@When("User navigates to Journal Batch")
	public void user_navigates_to_Journal_Batch() {
		journal = home.openJournalAccess();
	}

	@Then("On Journal Batch screen search create edit remove addsearchcondtion and excel options should be displayed")
	public void on_Journal_Batch_screen_search_create_edit_remove_addsearchcondtion_and_excel_options_should_be_displayed() {
		journal.verifyOptions();
	}

	@When("User navigates to Template Management")
	public void user_navigates_to_Template_Management() {
		template = home.openTemplateManagement();
	}

	@Then("On Template Management screen create edit remove Excel search and addsearchcondtion options should be displayed")
	public void on_Template_Management_screen_create_edit_remove_Excel_search_and_addsearchcondtion_options_should_be_displayed() {
		template.verifyOptions();
	}

	@When("User navigates to Batch Transaction History")
	public void user_navigates_to_Batch_Transaction_History() {
		batch = home.openBatchTransactionHistory();
	}

	@Then("User should be able to Download Excel Data and perform search")
	public void user_should_be_able_to_Download_Excel_Data_and_perform_search() {
		batch.downloadExcel();
		batch.verifyOptions();
		batch.validateSearch("Account", "1011169");
	}

	@When("User create a Interest with Active Status")
	public void user_create_a_Interest_with_Active_Status() {
		interest = home.openInterestRates();
		interest.createInterestRate("365 Checking CONSUMER", "1", "Active", "2", "10");
	}

	@Then("Active Status not allowed Warning should be Displayed")
	public void active_Status_not_allowed_Warning_should_be_Displayed() {

		interest.interestStatePendingWarning();
	}

	@When("user changes Status to Pending")
	public void user_changes_Status_to_Pending() {
		interest.changeRateStatusandSave("Pending");
	}

	@Then("Interest should be saved")
	public void interest_should_be_saved() {

	}

	 
	@When("users update any Interest data")
	public void users_update_any_Interest_data() {
		 
	   interest.updateEffectiveDateandSave(DateTime.now().plusDays(10).toString("MM/dd/yyyy"));
	}

	@Then("changes should be updated")
	public void changes_should_be_updated() {
	    interest.validateDateUpdated(DateTime.now().plusDays(10).toString("MM/dd/yyyy"));
	}
	@Then("user should be able to seach for the Interest Rate")
	public void user_should_be_able_to_seach_for_the_Interest_Rate() {
	     interest.validateSearch("Product desc", "365 Checking CONSUMER");
	}
	@When("user changes status to Active After Saving")
	public void user_changes_status_to_Active_After_Saving() {
		interest.changeRateStatusandSave("Active");
	}

	@Then("Same user cannot change Status warning Should be Displayed")
	public void same_user_cannot_change_Status_warning_Should_be_Displayed() {
	    interest.interestMustbeChangedByOtherUserWarning();
	}
	@When("user logsin with Other User and changes Status to Active")
	public void user_logsin_with_Other_User_and_changes_Status_to_Active() {
	   login.logOut();
	   login.login("admin", "admin");
	   home.openInterestRates();
	}

	@Then("Product should be saved with Active Status")
	public void product_should_be_saved_with_Active_Status() {
	    interest.selectInterestRateByBalance();
	    interest.changeRateStatusandSave("Active");
	}
	 

	@Then("Below Tabs should be available to the user")
	public void below_Tabs_should_be_available_to_the_user(DataTable dataTable) {
	    home.validateAdminHomePageTabs();
	}

	@Then("Below Accounting Tab should be Journal Entry Tab")
	public void below_Accounting_Tab_should_be_Journal_Entry_Tab() {
	   home.openAccounting();
	   home.openJournalEntry();
	}

	@Then("Below Journal Entry Tab Should be below Options")
	public void below_Journal_Entry_Tab_Should_be_below_Options(io.cucumber.datatable.DataTable dataTable) {
	    home.validateJournalEntryOptions();
	}

	@When("User navigates to Access Groups")
	public void user_navigates_to_Access_Groups() {
	   access= home.openAccessGroups();
	}

	@Then("Access Groups Page should have below Options")
	public void access_Groups_Page_should_have_below_Options(io.cucumber.datatable.DataTable dataTable) {
	   access.validateAccessGroupOptions();
	}

	@Then("On Batch Transaction page bel should be displayed")
	public void on_Batch_Transaction_page_bel_should_be_displayed(io.cucumber.datatable.DataTable dataTable) {
	     batch.validateBatchTransactionHistoryOptions();
	}

	@When("User Expands Maintenance Option")
	public void user_Expands_Maintenance_Option() {
	   home.openMaintenance();
	}

	@Then("In Maintenance tab below options should be displayed")
	public void in_Maintenance_tab_below_options_should_be_displayed(io.cucumber.datatable.DataTable dataTable) {
	   home.validateMaintenanceOptions();
	}

	@When("User Navigates to Entities Page")
	public void user_Navigates_to_Entities_Page() {
	   home.openEntities();
	}

	@Then("Application should navigate to Entities Page")
	public void application_should_navigate_to_Entities_Page() {
	     home.validateEntitiesPageLoaded();
	}

	@When("User Navigates to Interest Rates Page")
	public void user_Navigates_to_Interest_Rates_Page() {
		interest=  home.openInterestRates();
	}

	@Then("Interest Rates Page should have below options")
	public void interest_Rates_Page_should_have_below_options(io.cucumber.datatable.DataTable dataTable) {
	    interest.validatePageOptions();
	}

	@When("User Expands Administration Tab")
	public void user_Expands_Administration_Tab() {
	    home.clickAdministrationTab();
	}

	@Then("Administration Tab should have below options")
	public void administration_Tab_should_have_below_options(io.cucumber.datatable.DataTable dataTable) {
	    home.validateAdminHomePageTabs();
	}

	@When("User Navigates to Scheduled Tasks")
	public void user_Navigates_to_Scheduled_Tasks() {
	  scheduledTask=  home.openScheduledTasks();
	}

	@Then("Scheduled tasks Page should have below options")
	public void scheduled_tasks_Page_should_have_below_options(io.cucumber.datatable.DataTable dataTable) {
		scheduledTask.validateScheduledTaskPageOptions();
	}



}
