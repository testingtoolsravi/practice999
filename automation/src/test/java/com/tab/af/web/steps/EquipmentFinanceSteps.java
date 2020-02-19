package com.tab.af.web.steps;

import java.util.List;
import java.util.Map;

import com.tab.af.web.pages.EquipmentFinancing.Agreements;
import com.tab.af.web.pages.EquipmentFinancing.BasicInformation;
import com.tab.af.web.pages.EquipmentFinancing.BusinessInformation;
import com.tab.af.web.pages.EquipmentFinancing.Documents;
import com.tab.af.web.pages.EquipmentFinancing.Equipment;
import com.tab.af.web.pages.EquipmentFinancing.HaulingInformation;
import com.tab.af.web.pages.OnBoarding.ApplicationCreation;
import com.tab.af.web.pages.OnBoarding.ApplicationEditor;
import com.tab.af.web.pages.OnBoarding.ApplicationsHome;
import com.tab.af.web.pages.OnBoarding.EmailHistory;
import com.tab.af.web.pages.OnBoarding.LoanTasks;
import com.tab.af.web.pages.OnBoarding.Login;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class EquipmentFinanceSteps {

	BasicInformation basicInfo = new BasicInformation();
	BusinessInformation businessInformation = new BusinessInformation();
	HaulingInformation haulingInformation = new HaulingInformation();
	Equipment equipment = new Equipment();
	Documents documents = new Documents();
	Agreements agreements = new Agreements();
	Login login = new Login();
	ApplicationsHome home = new ApplicationsHome();
	ApplicationEditor editor= new ApplicationEditor();
	ApplicationCreation creation = new ApplicationCreation();
	LoanTasks loanTask= new LoanTasks(); 
EmailHistory emailHistory=new EmailHistory();
	@Given("loads users  data")
	public void loads_users_data() {
		basicInfo.loadUserData();
	}

	@Given("User is on BasicInfo Page")
	public void user_is_on_BasicInfo_Page() {

	}

	@When("user create an application with Entity as")
	public void user_create_an_application_with_Entity_as(DataTable dataTable) {

		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

		businessInformation = basicInfo.fillBasicInformation(data.get(0).get("LegalEntity"), "trucking",
				data.get(0).get("secondApplicantType"));
		businessInformation.fillBusinessInformation();
		businessInformation.fillTruckingInformation("No", "5", "2015", "No");
		businessInformation.fillOtherImportantInformation("No", "No", "No");
		businessInformation.addApplicantOne("75", "5", "No", "No", "No", "No");
		haulingInformation = businessInformation.sendInviteToSecondApplicant("5");
		equipment = haulingInformation.fillHaulingReference("No", "15000");
		documents = equipment.fillHaulingReference("Used", "2018", "CHEVROLET COMMERCIAL", "City Express", "20000");
		agreements = documents.uploadDocuments();
		login=agreements.completeAgreements();
		home=login.loginToApplication();
		emailHistory=home.openEmailHistory();
		emailHistory.selectEmail();
		
		//Applicant Two 
		businessInformation.enterSecondApplicantInviteInfo("5", "5", "No", "No", "No", "No");
		businessInformation.submitApplication();
	}

	@When("user create an application with Entity as Sole PropReitor")
	public void user_create_an_application_with_Entity_as_Sole_PropReitor(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

		businessInformation = basicInfo.fillBasicInformation(data.get(0).get("LegalEntity"), "trucking",
				data.get(0).get("secondApplicantType"));
		businessInformation.applicantOnePhysicalAddress();
		businessInformation.fillTruckingInformation("No", "5", "2015", "No");
		businessInformation.applicantOneMailingAddressSameasPhysical("No");

		businessInformation.legalInformation("No", "No", "No");
		businessInformation.fillOtherImportantInformation("No", "No", "No");
		haulingInformation = businessInformation.sendInviteToSecondApplicant("5");
		equipment = haulingInformation.fillHaulingReference("No", "15000");
		documents = equipment.fillHaulingReference("Used", "2018", "CHEVROLET COMMERCIAL", "City Express", "20000");
		agreements = documents.uploadDocuments();
		login=agreements.completeAgreements();
		home=login.loginToApplication();
		emailHistory=home.openEmailHistory();
		emailHistory.selectEmail();
		businessInformation.enterSecondApplicantInviteInfo("5", "5", "No", "No", "No", "No");
		businessInformation.submitApplication();
	}

	@When("user create an application with Entity as and Second Applicant Manually")
	public void user_create_an_application_with_Entity_as_and_Second_Applicant_Manually(
			io.cucumber.datatable.DataTable dataTable) throws Exception {
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

		businessInformation = basicInfo.fillBasicInformation(data.get(0).get("LegalEntity"), "trucking",
				data.get(0).get("secondApplicantType"));
		businessInformation.fillBusinessInformation();
		businessInformation.fillTruckingInformation("No", "5", "2015", "No");
		businessInformation.fillOtherImportantInformation("No", "No", "No");
		businessInformation.addApplicantOne("75", "5", "No", "No", "No", "No");
		haulingInformation = businessInformation.enterSecondApplicantManually("5", "No", "No", "No", "No", "5");
		equipment = haulingInformation.fillHaulingReference("No", "15000");
		documents = equipment.fillHaulingReference("Used", "2018", "CHEVROLET COMMERCIAL", "City Express", "20000");
		agreements = documents.uploadDocuments();
		agreements.completeAgreements();
		home = login.loginToApplication();
	}

	@When("user create an application with Entity as Sole Propreitor and Second Applicant Manually")
	public void user_create_an_application_with_Entity_as_Sole_Propreitor_and_Second_Applicant_Manually(
			io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

		businessInformation = basicInfo.fillBasicInformation(data.get(0).get("LegalEntity"), "trucking",
				data.get(0).get("secondApplicantType"));
		businessInformation.fillBusinessInformation();
		businessInformation.fillTruckingInformation("No", "5", "2015", "No");

		businessInformation.applicantOneMailingAddressSameasPhysical("No");
		businessInformation.legalInformation("No", "No", "No");
		businessInformation.fillOtherImportantInformation("No", "No", "No");
		haulingInformation = businessInformation.enterManuallySecondApplicantSolePropreitor("5", "5", "No", "No", "No",
				"No");
		equipment = haulingInformation.fillHaulingReference("No", "15000");
		documents = equipment.fillHaulingReference("Used", "2018", "CHEVROLET COMMERCIAL", "City Express", "20000");
		agreements = documents.uploadDocuments();
		login = agreements.completeAgreements();
		home = login.loginToApplication();
	}

	@Then("Application Should be Displayed in OnBoarding After Submission")
	public void application_Should_be_Displayed_in_OnBoarding_After_Submission() {
		
		editor = home.openLoanApplicationsPolymer();
		loanTask=editor.selectcreatedLoanApplicationFromPolymer();

		loanTask.checkInLoanPackage();
		loanTask.compileSmallTicketCreditSummary();
		loanTask.standardException();
		loanTask.smeCreditAnalystApproval();
		loanTask.sendApproveLetter();
		loanTask.equipmentCheckList();
		loanTask.smeFunding();
		
		

	}
}
