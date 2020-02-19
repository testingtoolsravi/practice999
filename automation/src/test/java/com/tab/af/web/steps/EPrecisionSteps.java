
package com.tab.af.web.steps;

import java.util.List;
import java.util.Map;

import com.tab.af.web.pages.EPrecision.CifEntity;
import com.tab.af.web.pages.EPrecision.EndOfDayJobs;
import com.tab.af.web.pages.EPrecision.HomePage;
import com.tab.af.web.pages.EPrecision.Login;
import com.tab.af.web.pages.EPrecision.Ping;
import com.tab.af.web.pages.EPrecision.Precision;
import com.tab.af.web.pages.EPrecision.ProcessErrors;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class EPrecisionSteps {

	Login login = new Login();
	HomePage home = new HomePage();
	ProcessErrors process = new ProcessErrors();
	EndOfDayJobs endOfDayJobs = new EndOfDayJobs();
	Precision precision = new Precision();
	CifEntity cifEntity=new CifEntity();
	Ping ping= new Ping();

	@Given("user logged into EPrecision as {string} and {string}")
	public void user_logged_into_EPrecision_as_and(String userName, String password) {
		home = login.login(userName, password);
	}

	@When("User navigates to process Errors")
	public void user_navigates_to_process_Errors() {
		process = home.navigateToProcessErros();
	}

	@Given("User is Logged in to EPrecsions")
	public void user_is_Logged_in_to_EPrecsions() {
		////
	}

	@Then("User should be able to see below  options")
	public void user_should_be_able_to_see_below_options(io.cucumber.datatable.DataTable dataTable) {
		process.validateProcessErrosScreenOptions(dataTable);
	}

	@When("User navigates to End of Day Jobs")
	public void user_navigates_to_End_of_Day_Jobs() {
		endOfDayJobs = home.navigateToEndOfDayJobs();
	}

	@Then("User should be able to see All End of Day Jobs options")
	public void user_should_be_able_to_see_All_End_of_Day_Jobs_options() {
		endOfDayJobs.validateEndofDaysPageOptions();
	}

	@When("User navigates to Precision")
	public void user_navigates_to_Precision() {
		precision = home.navigateToPrecisionOptions();
	}

	@Then("User should be able to see All Precision tab options")
	public void user_should_be_able_to_see_All_Precision_tab_options() {
		precision.validatePrecisionDropDownOptions();
	}
	 
	@When("user navigates to Cif Entity option")
	public void user_navigates_to_Cif_Entity_option() {
		cifEntity=   home.navigateToCifEntity();
	}

	@Then("user should be able to create Edit  Remove and search for the CIF Entity")
	public void user_should_be_able_to_create_Edit_Remove_and_search_for_the_CIF_Entity(DataTable table) {
		List<Map<String,String>> map=table.asMaps();
	    cifEntity.createCIFEntity(map.get(0).get("IbFlag"), map.get(0).get("Ib2Flag"), map.get(0).get("Branch"));
	    cifEntity.editCIFEntity(map.get(0).get("newIb2Flag"));
	    cifEntity.removeCIFEntity();
	}
	@When("user navigates to Ping options")
	public void user_navigates_to_Ping_options() {
	     ping =home.navigateToPingSystem();
	}

	@Then("user Should be able to See Ping Options")
	public void user_Should_be_able_to_See_Ping_Options() {
	  ping.validateOptions();
	}

	@When("user clicks on Ping Sonic button")
	public void user_clicks_on_Ping_Sonic_button() {
	   ping.clickPingSonicButton();
	}

	@Then("System up Message Should be Displayed")
	public void system_up_Message_Should_be_Displayed() {
	    ping.validateSonicPingSystemUpMessage();
	}
	@When("User is logged in to EPrecision and at HomePage")
	public void user_is_logged_in_to_EPrecision_and_at_HomePage() {
	    home.assertPage();
	}

	@Then("on Homepage below options should be available")
	public void on_Homepage_below_options_should_be_available(io.cucumber.datatable.DataTable dataTable) {
	    home.assertHomePageOptions();
	}

	@When("User navigates to End of Day Jobs and Clicks on All End of Day Jobs options")
	public void user_navigates_to_End_of_Day_Jobs_and_Clicks_on_All_End_of_Day_Jobs_options() {
	   endOfDayJobs=home.navigateToEndOfDayJobs();
	}

	@Then("Relative Message should be displayed to the User")
	public void relative_Message_should_be_displayed_to_the_User() {
	  endOfDayJobs.validateMessagesForAllOptions();
	}
	@When("User Expands the Precision Tab")
	public void user_Expands_the_Precision_Tab() {
	    home.clickPrecisionOption();
	}

	@Then("Precision Tab should have below options")
	public void precision_Tab_should_have_below_options(io.cucumber.datatable.DataTable dataTable) {
	     home.validatePrecisionTabOption();
	}

	@Then("User should be able to see below  options on CIF Entity Page")
	public void user_should_be_able_to_see_below_options_on_CIF_Entity_Page(io.cucumber.datatable.DataTable dataTable) {
	   cifEntity.validateCIFEntityPageOptions();
	}

}
