package com.tab.af.web.pages.EquipmentFinancing;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.tab.af.web.pages.BasePage;

public class BusinessInformation extends BasePage {
	@FindBy(xpath = "//body")
	private WebElement page;
	private final String Applicant1 = "Applicant1";
	private final String Applicant2 = "Applicant2";
	String txt_Address = "paper-input[id='addressText']";
	String txt_City = "paper-input[id='cityText']";
	String drp_State = "paper-autocomplete[id='_stateDD']>paper-input[id='autocompleteInput']";
	String txt_Zip = "paper-input[id='zipText']";
	String rBtn_MCAuthority = "radio-group[id='mcAuthority']>paper-radio-button[id='_option']";
	String txt_YearsAsOwners = "paper-input[id='yearsAsOwners']";
	String txt_YearsEstablished = "paper-input[id='yearFiled']";
	String drp_BusinessState = "paper-autocomplete[id='_stateDD'][label='Business State']>paper-input[id='autocompleteInput']";
	String rBtn_FinanceTruckTrailer = "radio-group[id='ownATruck']>paper-radio-button[id='_option']";
	String btn_AddApplicant = "paper-button[id='_addApplicantButton']";
	String txt_FirstName = "paper-input[id='firstName']";
	String txt_MiddleName = "paper-input[id='middleName']";
	String txt_LastName = "paper-input[id='lastName']";
	String txt_Email = "applicant-info[id='_applicantInfo_0']>paper-input[id='email'][label='Email Address']";
	String txt_MobilePhoneNo = "applicant-info[id='_applicantInfo_0']>paper-input[id='_mobilePhoneNo']";
	String txt_HomePhoneNo = "paper-input[id='_homePhoneNo']";
	String txt_DateOFBirth = "paper-input[id='datecontrol_dob']";
	String txt_SSN = "paper-input[id='ssn']";
	String txt_Ownership = "paper-input[id='ownership']";
	String txt_YearsDriving = "paper-input[id='yearsDriving']";
	String txt_PhysicalAddress = "address-info[id='_physicalAddress']>paper-input[id='addressText']";
	String txt_PhysicalAddressCity = "address-info[id='_physicalAddress']>paper-input[id='cityText']";
	String drp_PhysicalAddressState = "address-info[id='_physicalAddress']>paper-input[id='autocompleteInput']";
	String txt_PhysicalAddressZIP = "address-info[id='_physicalAddress']>paper-input[id='zipText']";
	String chk_CheckIFMailingSameAsPhysical = "paper-checkbox[id='mailingSameAsPhysical']";
	String rBtn_PoliticallyExposedPerson = "span[class='political-info-sec']>radio-group[id='politicallyExposedPerson']>paper-radio-button[id='_option']";
	String rBtn_PoliticallyExposedPersonSoleProp = "span[class='political-info-sec']>radio-group>paper-radio-button[id='_option']";
	String rBtn_DeclaredBankRuptcy = "radio-group[id='everDeclaredBankruptcy']>paper-radio-button[id='_option']";
	String rBtn_DefendantInLegalAction = "radio-group[id='haveDefendant']>paper-radio-button[id='_option']";
	String rBtn_AnyItemRepossessed = "radio-group[id='anyItemRepossessed']>paper-radio-button[id='_option']";
	String rBtn_isTransportationInvolved = "radio-group[id='isTransportationInvolved']>paper-radio-button[id='_option']";
	String rBtn_isInternetGamblingInvolved = "radio-group[id='isInternetGamblingInvolved']>paper-radio-button[id='_option']";
	String rbtn_isMoneyService = "radio-group[id='isMoneyService']>paper-radio-button[id='_option']";
	String btn_SendInvite = "business-info[id='businessInfoComponent']>paper-button";
	String txt_Applicant2FirstName = "applicant-info[id='_applicantInfo_1']>paper-input[id='firstName']";
	String txt_Applicant2MiddleName = "applicant-info[id='_applicantInfo_1']>paper-input[id='middleName']";
	String txt_Applicant2LastName = "applicant-info[id='_applicantInfo_1']>paper-input[id='lastName']";
	String txt_Applicant2Email = "applicant-info[id='_applicantInfo_1']>paper-input[id='email']";
	String txt_Applicant2Mobile = "applicant-info[id='_applicantInfo_1']>paper-input[id='_mobilePhoneNo']";
	String txt_Applicant2HomePhone = "applicant-info[id='_applicantInfo_1']>paper-input[id='_homePhoneNo']";
	String txt_Applicant2DateOfBirth = "applicant-info[id='_applicantInfo_1']>paper-input[id='datecontrol_dob']";
	String txt_Applicant2SSN = "applicant-info[id='_applicantInfo_1']>paper-input[id='ssn']";
	String txt_Applicant2OwnerShip = "applicant-info[id='_applicantInfo_1']>paper-input[id='ownership']";
	String txt_Applicant2YearsDriving = "applicant-info[id='_applicantInfo_1']>paper-input[id='yearsDriving']";
	String txt_Applicant2PhysicalAddress = "applicant-info[id='_applicantInfo_1']>address-info[id='_physicalAddress']>paper-input[id='addressText']";
	String txt_Applicant2City = "applicant-info[id='_applicantInfo_1']>address-info[id='_physicalAddress']>paper-input[id='cityText']";
	String txt_Applicant2State = "applicant-info[id='_applicantInfo_1']>address-info[id='_physicalAddress']>paper-autocomplete[id='_stateDD']>paper-input";
	String txt_Applicant2ZIP = "applicant-info[id='_applicantInfo_1']>address-info[id='_physicalAddress']>paper-input[id='zipText']";
	String chk_Applicant2MailingSameAsPhysical = "applicant-info[id='_applicantInfo_1']>paper-checkbox[id='mailingSameAsPhysical']";
	String rBtn_Applicant2PoliticallyExposedPerson = "applicant-info[id='_applicantInfo_1']>radio-group[id='politicallyExposedPerson']>paper-radio-button[id='_option']";
	String rBtn_Applicant2DeclaredBankruptcy = "applicant-info[id='_applicantInfo_1']>legal-info>radio-group[id='everDeclaredBankruptcy']>paper-radio-button";
	String rBtn_Applicant2DefendantInLegalAction = "applicant-info[id='_applicantInfo_1']>legal-info>radio-group[id='haveDefendant']>paper-radio-button";
	String rBtn_Applicant2ItemRepossessed = "applicant-info[id='_applicantInfo_1']>legal-info>radio-group[id='anyItemRepossessed']>paper-radio-button";
	String btn_SendInvite2 = "paper-button[id='_btnSendInvite']";
	String lbl_inviteSentSuccessfully = "h4[class='green-bolder pull-right']";
	String btn_Next = "paper-button[id='_nextButton']";
	String btn_EnterManually = "iron-form[id='_businessInfoForm']>iron-collapse[id='inviteApplicantStatus_1']>paper-button[data-target='manual']";

	///// Sole Propreitor
	String txt_Applicant1FirstName = "applicant-info[id='_applicantInfo_0']>paper-input[id='firstName']";
	String txt_Applicant1MiddleName = "applicant-info[id='_applicantInfo_0']>paper-input[id='middleName']";
	String txt_Applicant1LastName = "applicant-info[id='_applicantInfo_0']>paper-input[id='lastName']";
	String txt_Applicant1Email = "applicant-info[id='_applicantInfo_0']>paper-input[id='email']";
	String txt_Applicant1Mobile = "applicant-info[id='_applicantInfo_0']>paper-input[id='_mobilePhoneNo']";
	String txt_Applicant1HomePhone = "applicant-info[id='_applicantInfo_0']>paper-input[id='_homePhoneNo']";
	String txt_Applicant1DateOfBirth = "applicant-info[id='_applicantInfo_0']>paper-input[id='datecontrol_dob']";
	String txt_Applicant1SSN = "applicant-info[id='_applicantInfo_0']>paper-input[id='ssn']";
	String txt_Applicant1YearsDriving = "applicant-info[id='_applicantInfo_0']>paper-input[id='yearsDriving']";
	String txt_Applicant1Address = "applicant-info[id='_applicantInfo_0']>paper-input[id='addressText']";
	String txt_Applicant1City = "applicant-info[id='_applicantInfo_0']>paper-input[id='cityText']";
	String txt_Applicant1State = "applicant-info[id='_applicantInfo_0']>address-info[id='_physicalAddress']>paper-autocomplete[id='_stateDD']>paper-input";
	String txt_Applicant1ZIP = "applicant-info[id='_applicantInfo_0']>address-info[id='_physicalAddress']>paper-input[id='zipText']";
	String chk_Applicant1MailingSameAsPhysical = "applicant-info[id='_applicantInfo_0']>paper-checkbox[id='mailingSameAsPhysical']";
	String rBtn_Applicant1PoliticallyExposedPerson = "applicant-info[id='_applicantInfo_0']>radio-group[id='politicallyExposedPerson']>paper-radio-button[id='_option']";
	String rBtn_Applicant1DeclaredBankruptcy = "applicant-info[id='_applicantInfo_0']>legal-info>radio-group[id='everDeclaredBankruptcy']>paper-radio-button";
	String rBtn_Applicant1DefendantInLegalAction = "applicant-info[id='_applicantInfo_0']>legal-info>radio-group[id='haveDefendant']>paper-radio-button";
	String rBtn_Applicant1ItemRepossessed = "applicant-info[id='_applicantInfo_0']>legal-info>radio-group[id='anyItemRepossessed']>paper-radio-button";

	String btn_Submit = "paper-button[id='_nextButton']";

	String lbl_SubmitSuccess = "modal-popup[id='successPopup']>paper-dialog[id='_modal']>div>div>h1";

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		return ExpectedConditions.visibilityOf(page);
	}

	public void submitApplication() {
		try {

			shadow.click("paper-button[id='_saveButton']", "Submit");
			webActions.waitUntilDisplayed(shadow.findElement(lbl_SubmitSuccess), "Success");
			webActions.switchToOtherOpenedWindow();
			report.reportPass("Fill Business Information");
		} catch (Exception e) {
			report.reportHardFail("Fill Business Information");
		}
	}

	public void fillBusinessInformation() {

		try {
			Map<String, String> map = getTestDataMap();
			shadow.waitAndSendKeys(txt_Address, map.get("bestaddr"), "Business Information Address");
			shadow.sendKeys(txt_City, map.get("bestcity"), "Business Information City");
			shadow.sendKeystoAuto(drp_State, map.get("beststate"), "Business Information State");
			shadow.sendKeys(txt_Zip, map.get("bestzip"), "Business Information ZIP");
			report.reportPass("Fill Business Information");
		} catch (Exception e) {
			report.reportHardFail("Fill Business Information");
		}
	}

	public void fillTruckingInformation(String mcAuthority, String yearsAsOwner, String yearEstablished,
			String financedATruck) {
		try {
			Map<String, String> map = getTestDataMap();
			shadow.sendKeys(txt_YearsAsOwners, yearsAsOwner, "Trucking Information Years as Owners");
			shadow.sendKeys(txt_YearsEstablished, yearEstablished, "Trucking Information Year Established");
			shadow.sendKeystoAuto(drp_BusinessState, map.get("beststate"), "Business Information State");
			shadow.selectRadioButonByLabel(rBtn_FinanceTruckTrailer, financedATruck,
					"Have you Ever financed a truck trailer");
			report.reportPass("Fill Business Information");
		} catch (Exception e) {
			report.reportHardFail("Fill Business Information");
		}

	}

	public void fillOtherImportantInformation(String involvedinTransportTrucking, String involvedinInternetGambling,
			String moneyServiceBusiness) {
		try {
			shadow.selectRadioButonByLabel(rBtn_isTransportationInvolved, involvedinTransportTrucking,
					"This Business is involved in the transportation/trucking industry");
			shadow.selectRadioButonByLabel(rBtn_isInternetGamblingInvolved, involvedinInternetGambling,
					"Is business involved in Internet Gambling ");
			shadow.selectRadioButonByLabel(rbtn_isMoneyService, moneyServiceBusiness,
					"Is business a Money Services Business");
			report.reportPass("Fill Applicant Legal Information");
		} catch (Exception e) {
			report.reportHardFail("Fill Applicant Legal Information");

		}

	}

	public void addApplicantOne(String ownership, String yearsDriving, String politicallyExposedPerson,
			String declaredBankRuptcy, String defendantInAnyLegalAction, String anyItemRepossessed) {
		try {
			shadow.click(btn_AddApplicant, "Add Applicant");
			if (getTestDataMap().get("legalEntityType").toString().equalsIgnoreCase("Sole proprietor")
					&& getTestDataMap().get("secondApplicantType").toString().equalsIgnoreCase("Manual")) {
				shadow.waitAndClick(btn_EnterManually, "Enter Manually");
			}
			applicantOneBasicInformation(ownership, yearsDriving);
			applicantOnePhysicalAddress();
			applicantOneMailingAddressSameasPhysical(politicallyExposedPerson);
			legalInformation(declaredBankRuptcy, defendantInAnyLegalAction, anyItemRepossessed);
			report.reportPass("Fill Business Information");
		} catch (Exception e) {
			report.reportHardFail("Fill Business Information");
		}

	}

	public void applicantOneBasicInformation(String ownership, String yearsDriving) {
		try {
			setApplicant(Applicant1, json.getIndividualMap());
			Map<String, String> map = getApplicant(Applicant1);
			shadow.waitAndSendKeys(txt_FirstName, map.get("First Name"), "FirstName");
			shadow.sendKeys(txt_MiddleName, map.get("Middle"), "Middle Name");
			shadow.sendKeys(txt_LastName, map.get("Last Name"), "Last Name");

			shadow.sendKeys(txt_Email, global.lowRiskEmail(), "Email");

			shadow.sendKeys(txt_MobilePhoneNo, map.get("PHONE"), "Mobile No.");
			shadow.sendKeys(txt_HomePhoneNo, map.get("PHONE"), "Home No.");

			shadow.sendKeys(txt_DateOFBirth, map.get("DOB/YOB"), "Date of Birth");

			shadow.sendKeys(txt_SSN, map.get("SSN"), "SSn");
			shadow.sendKeys(txt_Ownership, ownership, "ownership");
			shadow.sendKeys(txt_YearsDriving, yearsDriving, "Years Driving");

			report.reportPass("Fill Applicant Basic Information");
		} catch (Exception e) {
			report.reportHardFail("Fill Applicant Basic Information");
		}

	}

	public void applicantOnePhysicalAddress() {
		try {
			Map<String, String> map = getApplicant(Applicant1);
			String address = map.get("House #") + " " + map.get("Street Name") + " " + map.get("Str Suf") + " "
					+ map.get("Unit") + " " + map.get("Unit #");
			shadow.waitAndSendKeys(txt_PhysicalAddress, address, "Physical Address ");
			shadow.sendKeys(txt_PhysicalAddressCity, map.get("City"), "Physical Address City");
			shadow.sendKeystoAuto(drp_PhysicalAddressState, map.get("State"), "Physical Address State");
			shadow.sendKeys(txt_PhysicalAddressZIP, map.get("ZIP Code"), "Physical Address City");
			report.reportPass("Fill Applicant Basic Physical Address");
		} catch (Exception e) {
			report.reportHardFail("Fill Applicant Basic Physical Address");
		}

	}

	public void applicantOneMailingAddressSameasPhysical(String politicallyExposedPerson) {
		try {
			shadow.click(chk_CheckIFMailingSameAsPhysical, "Check if Mailing Address Same as Physical");
			if (getTestDataMap().get("legalEntityType").toString().equalsIgnoreCase("Sole proprietor")) {
				shadow.selectRadioButonByLabel(rBtn_PoliticallyExposedPersonSoleProp, politicallyExposedPerson,
						"Politically Exposed Person");
			} else {
				shadow.selectRadioButonByLabel(rBtn_PoliticallyExposedPerson, politicallyExposedPerson,
						"Politically Exposed Person");
			}

			report.reportPass("Fill Applicant Basic Physical Address");
		} catch (Exception e) {
			report.reportHardFail("Fill Applicant Basic Physical Address");

		}
	}

	public void legalInformation(String declaredBankRuptcy, String defendantInAnyLegalAction,
			String anyItemRepossessed) {
		try {
			shadow.selectRadioButonByLabel(rBtn_DeclaredBankRuptcy, declaredBankRuptcy,
					"Have you ever declared bankruptcy");
			shadow.selectRadioButonByLabel(rBtn_DefendantInLegalAction, defendantInAnyLegalAction,
					"Are you a defendant in any Legal Action");
			shadow.selectRadioButonByLabel(rBtn_AnyItemRepossessed, anyItemRepossessed,
					"Have you ever had an item repossessed");
			report.reportPass("Fill Applicant Legal Information");
		} catch (Exception e) {
			report.reportHardFail("Fill Applicant Legal Information");

		}

	}

	public HaulingInformation sendInviteToSecondApplicant(String ownership) {
		shadow.click(btn_AddApplicant, "Add Applicant");
		if (getTestDataMap().get("legalEntityType").toString().equalsIgnoreCase("Sole proprietor")) {
			sendInviteToSecondApplicantSolePropreitor(ownership);
		} else {
			try {

				setApplicant(Applicant2, json.getIndividualMap());
				Map<String, String> map = getApplicant(Applicant2);
				shadow.waitAndClick(btn_SendInvite, "Send Invites");

				shadow.waitAndSendKeys(txt_Applicant2FirstName, map.get("First Name"), "Applicant two First Name");
				shadow.sendKeys(txt_Applicant2MiddleName, map.get("Middle"), "Applicant two Middle Name");
				shadow.sendKeys(txt_Applicant2LastName, map.get("Last Name"), "Applicant two Last Name");
				shadow.sendKeys(txt_Applicant2Email, global.lowRiskEmail(), "Applicant two Email");
				shadow.sendKeys(txt_Applicant2Mobile, map.get("PHONE"), "Applicant two Mobile");

				shadow.sendKeys(txt_Applicant2OwnerShip, ownership, "Applicant two Ownership");

				shadow.click(btn_SendInvite2, "Send invite");
				shadow.waitAndfindElement(lbl_inviteSentSuccessfully, "Invite Sent Successfully");
				shadow.click(btn_Next, "Next");
				report.reportPass("Fill Second Applicant Information");
			} catch (Exception e) {
				report.reportHardFail("Fill Second Applicant Information");

			}
		}

		return (HaulingInformation) base(HaulingInformation.class);
	}

	public void sendInviteToSecondApplicantSolePropreitor(String ownership) {
		try {

			shadow.waitAndClick(btn_SendInvite, "Send Invites");
			setApplicant(Applicant2, json.getIndividualMap());
			Map<String, String> map = getApplicant(Applicant2);
			shadow.waitAndSendKeys(txt_Applicant1FirstName, map.get("First Name"), "Applicant One First Name");
			shadow.sendKeys(txt_Applicant1MiddleName, map.get("Middle"), "Applicant One Middle Name");
			shadow.sendKeys(txt_Applicant1LastName, map.get("Last Name"), "Applicant One Last Name");
			shadow.sendKeys(txt_Applicant1Email, global.lowRiskEmail(), "Applicant One Email");
			shadow.sendKeys(txt_Applicant1Mobile, map.get("PHONE"), "Applicant One Mobile");

			shadow.click(btn_SendInvite2, "Send invite");
			shadow.waitAndfindElement(lbl_inviteSentSuccessfully, "Invite Sent Successfully");
			shadow.click(btn_Next, "Next");
			report.reportPass("Fill Second Applicant Information");
		} catch (Exception e) {
			report.reportHardFail("Fill Second Applicant Information");

		}
	}

	public HaulingInformation enterSecondApplicantManually(String ownership, String politicallyExposed,
			String declaredBankruptcy, String legalAction, String itemRepossesed, String yearsDriving) {
		if (getTestDataMap().get("legalEntityType").toString().equalsIgnoreCase("Sole proprietor")) {
			addApplicantOne(ownership, politicallyExposed, declaredBankruptcy, legalAction, itemRepossesed,
					yearsDriving);
		} else {
			secondApplicantManualBasicInformation(ownership, yearsDriving);
			secondApplicantManualPhysicalInformation();
			secondApplicantMailingAddressSameasPhysical(politicallyExposed);
			secondApplicantLegalInformation(declaredBankruptcy, legalAction, itemRepossesed);
		}

		return (HaulingInformation) base(HaulingInformation.class);
	}

	public void secondApplicantManualBasicInformation(String ownership, String yearsDriving) {
		try {

			shadow.click(btn_AddApplicant, "Add Applicant");

			shadow.waitAndClick(btn_EnterManually, "Enter Manually");
			setApplicant(Applicant2, json.getIndividualMap());
			Map<String, String> map = getApplicant(Applicant2);
			shadow.waitAndSendKeys(txt_Applicant2FirstName, map.get("First Name"), "Applicant two First Name");
			shadow.sendKeys(txt_Applicant2MiddleName, map.get("Middle"), "Applicant two Middle Name");
			shadow.sendKeys(txt_Applicant2LastName, map.get("Last Name"), "Applicant two Last Name");
			shadow.sendKeys(txt_Applicant2Email, global.lowRiskEmail(), "Applicant two Email");
			shadow.sendKeys(txt_Applicant2Mobile, map.get("PHONE"), "Applicant two Mobile");
			shadow.sendKeys(txt_Applicant2HomePhone, map.get("PHONE"), "Applicant two Home Phone");
			shadow.sendKeys(txt_Applicant2DateOfBirth, map.get("DOB/YOB"), "Applicant two DOB");
			shadow.sendKeys(txt_Applicant2SSN, map.get("SSN"), "Applicant two SSN");
			shadow.sendKeys(txt_Applicant2OwnerShip, ownership, "Applicant two Ownership");
			shadow.sendKeys(txt_Applicant2YearsDriving, yearsDriving, "Applicant two Years Driving");
			report.reportPass("Fill Second Applicant Basic Information");
		} catch (Exception e) {
			report.reportHardFail("Fill Second Applicant Basic Information");

		}
	}

	public void secondApplicantManualPhysicalInformation() {
		try {

			Map<String, String> map = getApplicant(Applicant2);
			String address = map.get("House #") + " " + map.get("Street Name") + " " + map.get("Str Suf") + " "
					+ map.get("Unit") + " " + map.get("Unit #");
			shadow.sendKeys(txt_Applicant2PhysicalAddress, address, "Applicant two Address");
			shadow.sendKeys(txt_Applicant2City, map.get("City"), "Applicant two City");
			shadow.sendKeystoAuto(txt_Applicant2State, map.get("State"), "Applicant two State");
			shadow.sendKeys(txt_Applicant2ZIP, map.get("ZIP Code"), "Applicant two ZIP");
			report.reportPass("Fill Second Applicant Physical Address");
		} catch (Exception e) {
			report.reportHardFail("Fill Second Applicant Physical Address");

		}
	}

	public void secondApplicantMailingAddressSameasPhysical(String politicallyExposed) {
		try {

			shadow.click(chk_Applicant2MailingSameAsPhysical,
					"Applicant two Check if mailing address is same as physical address");
			shadow.selectRadioButonByLabel(rBtn_Applicant2PoliticallyExposedPerson, politicallyExposed,
					"Applicant two Politically Exposed Person");

			report.reportPass(" Second Applicant Mailing Address Same as Physical Address");
		} catch (Exception e) {
			report.reportHardFail(" Second Applicant Mailing Address Same as Physical Address");

		}
	}

	public void secondApplicantLegalInformation(String declaredBankruptcy, String legalAction, String itemRepossesed) {
		try {

			shadow.selectRadioButonByLabel(rBtn_Applicant2DeclaredBankruptcy, declaredBankruptcy,
					"Have you ever declared bankruptcy");
			shadow.selectRadioButonByLabel(rBtn_Applicant2DefendantInLegalAction, legalAction,
					"Are you a defendant in any Legal Action");
			shadow.selectRadioButonByLabel(rBtn_Applicant2ItemRepossessed, itemRepossesed,
					"Have you ever had an item repossessed");
			shadow.click(btn_Next, "Next");
			report.reportPass(" Second Applicant Legal Information");
		} catch (Exception e) {
			report.reportHardFail(" Second Applicant Legal Information");

		}
	}

	public HaulingInformation enterManuallySecondApplicantSolePropreitor(String ownership, String yearsOfDriving,
			String politicallyExposed, String declaredBankRuptcy, String defendantInAnyLegalAction,
			String anyItemRepossessed) {
		try {

			shadow.click(btn_AddApplicant, "Add Applicant");
			shadow.waitAndClick(btn_EnterManually, "EnterManually");
			setApplicant(Applicant2, json.getIndividualMap());
			Map<String, String> map = getApplicant(Applicant2);
			shadow.waitAndSendKeys(txt_Applicant1FirstName, map.get("First Name"), "Applicant One First Name");
			shadow.sendKeys(txt_Applicant1MiddleName, map.get("Middle"), "Applicant One Middle Name");
			shadow.sendKeys(txt_Applicant1LastName, map.get("Last Name"), "Applicant One Last Name");
			shadow.sendKeys(txt_Applicant1Email, global.lowRiskEmail(), "Applicant One Email");
			shadow.sendKeys(txt_Applicant1Mobile, map.get("PHONE"), "Applicant One Mobile");
			shadow.sendKeys(txt_Applicant1HomePhone, map.get("PHONE"), "Applicant One Home Phone");
			shadow.sendKeys(txt_Applicant1DateOfBirth, map.get("DOB/YOB"), "Applicant One DOB");
			shadow.sendKeys(txt_Applicant1SSN, map.get("SSN"), "Applicant One SSN");
			shadow.sendKeys(txt_Applicant1YearsDriving, yearsOfDriving, "Applicant One years Of Driving");
			String address = map.get("House #") + " " + map.get("Street Name") + " " + map.get("Str Suf") + " "
					+ map.get("Unit") + " " + map.get("Unit #");
			shadow.sendKeys(txt_Applicant1Address, address, "Applicant One ADDRESS");
			shadow.sendKeys(txt_Applicant1City, map.get("City"), "Applicant One CITY");
			shadow.sendKeystoAuto(txt_Applicant1State, map.get("State"), "Applicant One State");
			shadow.sendKeys(txt_Applicant1ZIP, map.get("ZIP Code"), "Applicant One ZIP");
			shadow.click(chk_Applicant1MailingSameAsPhysical, "Applicant One Mailing Address Same as Physical");
			shadow.selectRadioButonByLabel(rBtn_Applicant1PoliticallyExposedPerson, politicallyExposed,
					"Applicant One Politically Exposed Person");
			shadow.selectRadioButonByLabel(rBtn_Applicant1DeclaredBankruptcy, declaredBankRuptcy,
					"Have you ever declared bankruptcy");
			shadow.selectRadioButonByLabel(rBtn_Applicant1DefendantInLegalAction, defendantInAnyLegalAction,
					"Are you a defendant in any Legal Action");
			shadow.selectRadioButonByLabel(rBtn_Applicant1ItemRepossessed, anyItemRepossessed,
					"Have you ever had an item repossessed");
			shadow.click(btn_Next, "Next");
			report.reportPass("Fill   Applicant Information");
		} catch (Exception e) {
			report.reportHardFail("Fill   Applicant Information");

		}
		return (HaulingInformation) base(HaulingInformation.class);
	}

	public void inviteApplicanInfo() {
		try {

			report.reportPass("Fill   Applicant Information");
		} catch (Exception e) {
			report.reportHardFail("Fill   Applicant Information");

		}
	}

	public void enterSecondApplicantInviteInfo(String ownership, String yearsOfDriving, String politicallyExposed,
			String declaredBankRuptcy, String defendantInAnyLegalAction, String anyItemRepossessed) {
		try {

			 
			Map<String, String> map = getApplicant(Applicant2);
			shadow.waitAndSendKeys(txt_FirstName, map.get("First Name"), "Applicant One First Name");
			shadow.sendKeys(txt_MiddleName, map.get("Middle"), "Applicant One Middle Name");
			shadow.sendKeys(txt_LastName, map.get("Last Name"), "Applicant One Last Name");
			shadow.sendKeys("applicant-info>paper-input[id='email']", global.lowRiskEmail(), "Applicant One Email");
			shadow.sendKeys("applicant-info>paper-input[id='_mobilePhoneNo']", map.get("PHONE"),
					"Applicant One Mobile");
			shadow.sendKeys(txt_HomePhoneNo, map.get("PHONE"), "Applicant One Home Phone");
			shadow.sendKeys(txt_DateOFBirth, map.get("DOB/YOB"), "Applicant One DOB");
			shadow.sendKeys(txt_SSN, map.get("SSN"), "Applicant One SSN");
			shadow.sendKeys(txt_YearsDriving, yearsOfDriving, "Applicant One years Of Driving");
			String address = map.get("House #") + " " + map.get("Street Name") + " " + map.get("Str Suf") + " "
					+ map.get("Unit") + " " + map.get("Unit #");
			shadow.sendKeys(txt_PhysicalAddress, address, "Applicant One ADDRESS");
			shadow.sendKeys(txt_PhysicalAddressCity, map.get("City"), "Applicant One CITY");
			shadow.sendKeystoAuto(drp_PhysicalAddressState, map.get("State"), "Applicant One State");
			shadow.sendKeys(txt_PhysicalAddressZIP, map.get("ZIP Code"), "Applicant One ZIP");
			shadow.click(chk_CheckIFMailingSameAsPhysical, "Applicant One Mailing Address Same as Physical");
			shadow.selectRadioButonByLabel(rBtn_PoliticallyExposedPerson, politicallyExposed,
					"Applicant One Politically Exposed Person");
			shadow.selectRadioButonByLabel(rBtn_DeclaredBankRuptcy, declaredBankRuptcy,
					"Have you ever declared bankruptcy");
			shadow.selectRadioButonByLabel(rBtn_DefendantInLegalAction, defendantInAnyLegalAction,
					"Are you a defendant in any Legal Action");
			shadow.selectRadioButonByLabel(rBtn_AnyItemRepossessed, anyItemRepossessed,
					"Have you ever had an item repossessed");

			report.reportPass("Fill   Applicant Information");
		} catch (Exception e) {
			report.reportHardFail("Fill   Applicant Information");

		}

	}
}
