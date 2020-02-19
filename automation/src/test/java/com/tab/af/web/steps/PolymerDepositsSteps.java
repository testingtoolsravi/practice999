package com.tab.af.web.steps;

import java.util.List;
import java.util.Map;

import com.tab.af.web.pages.OnBoarding.ApplicationEditor;
import com.tab.af.web.pages.OnBoarding.ApplicationsHome;
import com.tab.af.web.pages.OnBoarding.DepositTasks;
import com.tab.af.web.pages.OnBoarding.Login;
import com.tab.af.web.pages.PolymerDeposits.Agreements;
import com.tab.af.web.pages.PolymerDeposits.BasicInformation;
import com.tab.af.web.pages.PolymerDeposits.CertificateOfDeposit;
import com.tab.af.web.pages.PolymerDeposits.ProductSelection;
import com.tab.af.web.pages.PolymerDeposits.ServiceType;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class PolymerDepositsSteps {

	ServiceType serviceType = new ServiceType();
	ProductSelection productSelection = new ProductSelection();
	BasicInformation basicInformation = new BasicInformation();
	CertificateOfDeposit certificateOfDeposit = new CertificateOfDeposit();
	Agreements agreements = new Agreements();
	Login login = new Login();
	ApplicationsHome home = new ApplicationsHome();;
	ApplicationEditor editor = new ApplicationEditor();
DepositTasks depositTask= new DepositTasks();
	@Given("User Test Data is loaded")
	public void user_Test_Data_is_loaded() {
		serviceType.loadUserData();
	}

	@Given("User is on DOA HomePage")
	public void user_is_on_DOA_HomePage() {

		serviceType.validateHomePage();
	}

	@When("User selects service type as {string}")
	public void user_selects_service_type_as(String service) {
		productSelection = serviceType.selectServiceType(service);
	}

	@When("Product as {string},{string}")
	public void product_as(String productType, String productName) {
		basicInformation = productSelection.selectPersonalProduct(productType, productName);
	}
	@When("Business Product as {string},{string}")
	public void business_Product_as(String productType, String productName) 
	{
		basicInformation = productSelection.selectBusinessProduct(productType, productName);
	}

	@Then("On Clicking OpenNow User should be Navigated to Basic InformationPage")
	public void on_Clicking_OpenNow_User_should_be_Navigated_to_Basic_InformationPage() {
		

	}
	@When("User fills all Legal Entity Information and clicks Next")
	public void user_fills_all_Legal_Entity_Information_and_clicks_Next(io.cucumber.datatable.DataTable dataTable) {
	    
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		basicInformation.legalEntityInfo(data.get(0).get("Legal Entity"));
		 
		basicInformation.PhysicalAddress();
		basicInformation.MailingAddressSameasPhysical(); 
		basicInformation.otherImportantInformation(data.get(0).get("incomeRange"),
				data.get(0).get("politicallyExposedPerson"), data.get(0).get("politicallyExposedPerson"));
		certificateOfDeposit = basicInformation.backupWithholding();

	}

	@When("User fills all Basic Information and clicks Next")
	public void user_fills_all_Basic_Information_and_clicks_Next(DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		basicInformation.selectEntryAsManual();
		basicInformation.fillBasicInfo();
		basicInformation.driversLicenseInfo();
		basicInformation.PhysicalAddress();
		basicInformation.MailingAddressSameasPhysical();
		basicInformation.otherImportantInformation(data.get(0).get("incomeRange"),
				data.get(0).get("politicallyExposedPerson"), data.get(0).get("politicallyExposedPerson"));
		certificateOfDeposit = basicInformation.backupWithholding();
	}

	@Then("Certificate of Deposit Page should be displayed")
	public void certificate_of_Deposit_Page_should_be_displayed() {
		certificateOfDeposit.validateCODPage();

	}

	@When("User fills Details for COD Page and click Next")
	public void user_fills_Details_for_COD_Page_and_click_Next(DataTable dataTable) {

		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		certificateOfDeposit.interestFrequencyAndMethod(data.get(0).get("frequency"), data.get(0).get("method"));
		agreements = certificateOfDeposit.payOnDeath();
	}

	@Then("Agreements Page Should be loaded")
	public void agreements_Page_Should_be_loaded() {
		agreements.validateAgreementsPage();
		
		 
		

	}
	@When("User Submits the Application")
	public void user_Submits_the_Application() {
		login = agreements.completeAgreements();
	}

	@Then("User should be able to Resume Application in Onboarding")
	public void user_should_be_able_to_Resume_Application_in_Onboarding() {
		home = login.loginToApplication();
		editor = home.openDespoitApplicationsPolymer();
		depositTask=editor.selectcreatedDepositApplicationFromPolymer();
	}

	@Then("Complete the Consumer Deposit Task")
	public void complete_the_Consumer_Deposit_Task() {
	   depositTask.customerVerificationQATask();
	   depositTask.completeDecisionTask();
	   depositTask.completeCIFAccountCreationTask();
	   depositTask.completeSendWelcomeEmailTask();
	   depositTask.completeFundingTask();
	}
	@Then("Complete the Consumer Checking Deposit Task")
	public void complete_the_Consumer_Checking_Deposit_Task() {
		depositTask.completeApplicationVerificationTask();
		depositTask.completeApproveVerificationTask("Applicant1");
		depositTask.verifyAccountCreated("Applicant1");
	}
	


}
