package com.tab.af.web.pages.OnBoarding;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Map;

import org.joda.time.DateTime;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.github.javafaker.Faker;
import com.tab.af.testbase.TestBase;
import com.tab.af.web.pages.BasePage;

public class ApplicationCreation extends BasePage {

	/// For Applications Pages
	@FindBy(xpath = "//span[text()='Create']")
	private WebElement btn_Create;
	@FindBy(xpath = "//span[text()='OK']")
	private WebElement btn_OK;
	@FindBy(xpath = "//div[text()='Application Product Selection']")
	private WebElement lbl_ApplicationProductSelection;
	@FindBy(xpath = "//div[text()='Product Line']//following::input[1]")
	private WebElement lkp_ProductLine;

	@FindBy(xpath = "//div[text()='Product Type']//following::input[1]")
	private WebElement lkp_ProductType;
	@FindBy(xpath = "//div[text()='Customer Type']//following::input[1]")
	private WebElement lkp_CustomerType;

	@FindBy(xpath = "//div[text()='SSN']//following::input[1]")
	private WebElement txt_SSN;
	@FindBy(xpath = "//div[text()='Email']//following::input[1]")
	private WebElement txt_Email;
	@FindBy(xpath = "//div[text()='First Name']//following::input[1]")
	private WebElement txt_FirstName;
	@FindBy(xpath = "//div[text()='Middle Name']//following::input[1]")
	private WebElement txt_MiddleName;
	@FindBy(xpath = "//div[text()='Last Name']//following::input[1]")
	private WebElement txt_LastName;
	@FindBy(xpath = "//div[text()='Date of Birth']//following::input[1]")
	private WebElement txt_DateOfBirth;
	@FindBy(xpath = "//div[contains(text(),'Date of Birth') or contains(text(),'DOB') ]//following::input[1]")
	private WebElement txt_DOB;
	@FindBy(xpath = "//div[text()='Security Code Word']//following::input[1]")
	private WebElement txt_SecurityCodeWord;
	@FindBy(xpath = "//div[text()='Drivers License #']//following::input[1]")
	private WebElement txt_DrivingLicenseNo;
	@FindBy(xpath = "//div[text()='DL State']//following::input[1]")
	private WebElement txt_DrivingLicenseState;
	@FindBy(xpath = "//div[text()='DL Exp']//following::input[1]")
	private WebElement txt_DrivingLicenseExpiry;
	@FindBy(xpath = "//div[text()='DL Issue']//following::input[1]")
	private WebElement txt_DrivingLicenseIssue;
	@FindBy(xpath = "//div[text()='DL Issue']//following::input[1]")
	private WebElement btn_CreateAddress;
	@FindBy(xpath = "//span[text()='Addresses']")
	private WebElement lbl_Addresses;
	@FindBy(xpath = "//div[text()='Address Type']//following::input[1]")
	private WebElement txt_AddressType;
	@FindBy(xpath = "//div[text()='Address 1']//following::input[1]")
	private WebElement txt_AddressOne;
	@FindBy(xpath = "(//div[text()='City'])[2]//following::input[1]")
	private WebElement txt_City;
	@FindBy(xpath = "(//div[text()='State'])[2]//following::input[1]")
	private WebElement txt_State;
	@FindBy(xpath = "(//div[text()='Zip'])[2]//following::input[1]")
	private WebElement txt_Zip;
	@FindBy(xpath = "//span[text()='Same As']//..//parent::div")
	private WebElement btn_SameAs;
	@FindBy(xpath = "//div[text()='Applicant Address Edit']")
	private WebElement lbl_ApplicantAddressEdit;
	@FindBy(xpath = "//div[text()='Applicant Phone Editor']")
	private WebElement lbl_ApplicantPhoneEditor;
	@FindBy(xpath = "//span[text()='Phones']//following::span[text()='Create']")
	private WebElement btn_CreatePhones;
	@FindBy(xpath = "//div[text()='Phone Type']//following::input[1]")
	private WebElement txt_PhoneType;
	@FindBy(xpath = "(//div[text()='Phone Number'])[2]//following::input[1]")
	private WebElement txt_PhoneNumber;
	@FindBy(xpath = "//span[text()='Start Process']")
	private WebElement btn_StartProcess;
	@FindBy(xpath = "//div[text()='Legal Entity']//following::input[1]")
	private WebElement txt_LegalEntity;
	@FindBy(xpath = "//div[text()='Business State']//following::input[1]")
	private WebElement txt_BusinessState;
	@FindBy(xpath = "//div[text()='Year Established']//following::input[1]")
	private WebElement txt_YearEstablished;
	@FindBy(xpath = "//div[text()='Tax Id']//following::input[1]")
	private WebElement txt_TaxId;
	@FindBy(xpath = "//div[text()='Company Name']//following::input[1]")
	private WebElement txt_companyName;
	@FindBy(xpath = "//div[text()='Frequency']//following::input[1]")
	private WebElement txt_CDInfoFrequency;
	@FindBy(xpath = "//div[text()='Method']//following::input[1]")
	private WebElement txt_CDInfoMethod;
	@FindBy(xpath = "//div[text()='Company you haul for']//following::input[1]")
	private WebElement txt_companyHaul;
	@FindBy(xpath = "//div[contains(text(),'Years in Business') or contains(text(),'CDL Driving Exp (Years)') ]//following::input[1]")
	private WebElement txt_CdlDrivingExperience;
	@FindBy(xpath = "//div[text()='CDL Driving Exp (Years)']//following::input[1]")
	private WebElement txt_CdlDrivingExperienceLoans;
	@FindBy(xpath = "//div[text()='Ownership %']//following::input[1]")
	private WebElement txt_OwnerShipInfo;
	@FindBy(xpath = "//span[text()='Opportunity Info']")
	private WebElement lbl_OpportunityInfo;
	@FindBy(xpath = "//span[text()='Opportunity Info']//following::div[text()='Name']//following::input[1]")
	private WebElement txt_OpportunityInfo_Name;
	@FindBy(xpath = "//span[text()='Opportunity Info']//following::div[text()='Current lender']//following::input[1]")
	private WebElement txt_OpportunityInfo_CurrentLender;
	@FindBy(xpath = "//span[text()='Opportunity Info']//following::div[text()='Description'][1]//following::input[1]")
	private WebElement txt_OpportunityInfo_Description;
	@FindBy(xpath = "//span[text()='Opportunity Info']//following::div[text()='Participation']//following::input[1]")
	private WebElement txt_OpportunityInfo_Participation;
	@FindBy(xpath = "//span[text()='Opportunity Info']//following::div[text()='Close date']//following::input[1]")
	private WebElement txt_OpportunityInfo_CloseDate;
	@FindBy(xpath = "//span[text()='Opportunity Info']//following::div[text()='Type']//following::input[1]")
	private WebElement txt_OpportunityInfo_Type;
	@FindBy(xpath = "//span[text()='Opportunity Info']//following::div[text()='Amount']//following::input[1]")
	private WebElement txt_OpportunityInfo_Amount;
	@FindBy(xpath = "//span[text()='Collateral']//following::div[text()='Have you found the equipment you would like to purchase?']//following::input[1]")
	private WebElement chk_FoundEquipmentToPurchase;
	@FindBy(xpath = "//span[text()='Equipment']//following::span[text()='Create'][1]")
	private WebElement btn_Equipment_Create;
	@FindBy(xpath = "(//div[text()='Year']//following::input[1])[1]")
	private WebElement txt_Equipment_Year;
	@FindBy(xpath = "(//div[text()='Make']//following::input[1])[1]")
	private WebElement txt_Equipment_Make;
	@FindBy(xpath = "//span[text()='Equipment Info']//following::div[text()='Make']//following::input[1]")
	private WebElement txt_Equipment_MakeAuto;
	@FindBy(xpath = "(//div[text()='Model']//following::input[1])[1]")
	private WebElement txt_Equipment_Model;
	@FindBy(xpath = "(//div[text()='Body Type']//following::input[1])[1]")
	private WebElement txt_Equipment_BodyType;
	@FindBy(xpath = "//div[text()='Equipment Cost']//following::input[1]")
	private WebElement txt_Equipment_EquipmentCost;
	@FindBy(xpath = "//div[text()='Down Payment']//following::input[1]")
	private WebElement txt_Equipment_DownPayment;
	@FindBy(xpath = "//div[text()='VIN']//following::input[1]")
	private WebElement txt_Equipment_VIN;
	@FindBy(xpath = "//span[text()='Applicants']//following::span[text()='Create'][1]")
	private WebElement btn_ApplicantsCreate;
	@FindBy(xpath = "//div[text()='Provider Detail']")
	private WebElement lbl_ProviderDetails;
	@FindBy(xpath = "//span[text()='LexisNexis request']")
	private WebElement btn_LexusNexusRequest;
	@FindBy(xpath = "//div[text()='Lexis Nexis Type']")
	private WebElement lbl_LexusNexusType;
	@FindBy(xpath = "//div[text()='Individual']//parent::td//parent::tr[@class=\"v-table-row v-selected\"]")
	private WebElement btn_IndividualApplicantHighlight;
	@FindBy(xpath = "//span[text()='Applicants']//following::span[text()='Remove'][1]")
	private WebElement btn_RemoveApplicant;
	@FindBy(xpath = "//div[text()='Are you sure you want to delete selected elements?']")
	private WebElement lbl_confirmRemoveSelectedElement;
	@FindBy(xpath = "//h1[text()='You have removed the main applicant. Please set another applicant as the main. ']")
	private WebElement lbl_YouHaveRemovedApplicantMessage;
	@FindBy(xpath = "//h1[text()='Application saved.']")
	private WebElement lbl_ApplicationSaved;
	@FindBy(xpath = "//div[text()='Entity Type']")
	private WebElement lbl_EntityType;
	@FindBy(xpath = "//span[text()='Cancel']")
	private WebElement btn_Cancel;
	@FindBy(xpath = "(//span[text()='Cancel'])[2]")
	private WebElement btn_CancelExistingApplicant;
	@FindBy(xpath = "//span[text()='Cancel']")
	private WebElement lbl_BasicInfo;
	@FindBy(xpath = "//div[text()='Would you like to fill form with data from existing applicant?']")
	private WebElement lbl_FillExistingData;
	@FindBy(xpath = "//div[@cuba-id=\"applicantsTable\"]")
	private WebElement btn_ApplicantsTable;
	@FindBy(xpath = "//div[text()='Individual']")
	private WebElement lbl_ApplicantsTableIndividual;
	@FindBy(xpath = "//span[text()='System Information']")
	private WebElement lbl_SystemInfomation;
	@FindBy(xpath = "(//div[text()='ID']//following::div)[1]")
	private WebElement lbl_ApplicantID;
	@FindBy(xpath = "//div[@class=\"v-window-closebox\"]")
	private WebElement btn_ClosePopup;

	public void createDepositProduct(String productLine, String productType, String customerType, String productName) {
		try {
			Map map = json.getDepositMap();
			setTestDataMap(map);
			setApplicant("Applicant1", map);
			selecProduct(productLine, productType, customerType, productName);
			report.reportPass("Create Deposit Product");
		} catch (Exception e) {
			report.reportHardFail("Create Deposit Product");
		}
	}

	public void createLoanProduct(String productLine, String productType, String customerType, String productName) {
		try {

			setTestDataMap(json.getLoanMap());
			selecProduct(productLine, productType, customerType, productName);
			report.reportPass("Create Loan Product");
		} catch (Exception e) {
			report.reportHardFail("Create Loan Product" + e.getMessage());
		}
	}

	private void selecProduct(String productLine, String productType, String customerType, String productName)
			throws Exception {

		webActions.waitAndCickBYJS(btn_Create, "Create Button");
		webActions.waitAndSendKeysByCharAuto(lkp_ProductLine, productLine, "Product Line");
		webActions.waitAndSendKeysByCharAuto(lkp_ProductType, productType, "Product Type");
		webActions.waitClearSendKeysByCharAuto(lkp_CustomerType, customerType, "Customer Type");
		webActions.clickBYJS(webActions.findByText(productName, "//label"), "Product Name");
		getTestDataMap().put("productType", productType);
		getTestDataMap().put("SelectedProduct", productName);
		getTestDataMap().put("productLine", productLine);
		webActions.clickBYJS(btn_OK, "OK");
	}

	private void cancelExistingDataPopup() throws Exception {
		try {

			webActions.waitForVisibility(lbl_FillExistingData, "Fill Existing Data Popup", 20);
			webActions.clickBYJS(btn_CancelExistingApplicant, "Cancel Existign Applicant");
			webActions.waitUntilNotPresent(lbl_FillExistingData, "Fill Existing Data Popup");
		} catch (NoSuchElementException | TimeoutException e) {
			/// ignoring SInce THis is not a Existing User
		}
	}

	public void fillIndividualBasicandDrivingInfo() {
		try {

			Map<String, String> map = getTestDataMap();
			webActions.waitAndSendKeysByChar(txt_SSN, Keys.HOME + map.get("SSN"), "SSN Field");
			cancelExistingDataPopup();
			webActions.sendKeysByChar(txt_Email, global.lowRiskEmail(), "Email");
			webActions.sendKeysByChar(txt_FirstName, map.get("FIRST NAME"), "First name");
			webActions.sendKeysByChar(txt_MiddleName, map.get("MIDDLE NAME"), "Middle Name");
			webActions.sendKeysByChar(txt_LastName, map.get("LAST NAME"), "Last Name");

			String dob;

			/// Test Data is Sometimes Missing Complete DOB
			if (map.get("DOB/YOB").length() == 4) {
				dob = "0101" + map.get("DOB/YOB");
			} else {
				dob = map.get("DOB/YOB");
			}
			webActions.sendKeysByChar(txt_DateOfBirth, dob, "Date of Birth");
			webActions.sendKeysByChar(txt_SecurityCodeWord, "1234", "Security Code Word");
			String license = map.get("DRIVERS LICENSE").isEmpty() ? Faker.instance().number().digits(6)
					: map.get("DRIVERS LICENSE");
			String licenseState = map.get("DL STATE").isEmpty() ? Faker.instance().address().state()
					: map.get("DL STATE");
			webActions.sendKeysByChar(txt_DrivingLicenseNo, license, "Driving License #");
			webActions.SendKeysByCharAuto(txt_DrivingLicenseState, licenseState, "Driving License State");
			webActions.sendKeysByChar(txt_DrivingLicenseExpiry, "10102020", "SSN Field");
			webActions.sendKeysByChar(txt_DrivingLicenseIssue, "10102010", "SSN Field");
			report.reportPass("Fill Individual Info");
		} catch (Exception e) {
			report.reportHardFail("Fill Individual Info");
		}

	}

	private void soleProperiotorInfo() {
		try {

			Map<String, String> map = getTestDataMap();
			webActions.waitAndSendKeysByChar(txt_SSN, Keys.HOME + map.get("SSN"), "SSN Field");
			cancelExistingDataPopup();
			webActions.sendKeysByChar(txt_Email, global.lowRiskEmail(), "Email");
			webActions.sendKeysByChar(txt_FirstName, map.get("FIRST NAME"), "First name");
			webActions.sendKeysByChar(txt_MiddleName, map.get("MIDDLE NAME"), "Middle Name");
			webActions.sendKeysByChar(txt_LastName, map.get("LAST NAME"), "Last Name");

			String dob;

			/// Test Data is Sometimes Missing Complete DOB
			if (map.get("DOB/YOB").length() == 4) {
				dob = "0101" + map.get("DOB/YOB");
			} else {
				dob = map.get("DOB/YOB");
			}
			webActions.sendKeysByChar(txt_DOB, dob, "Date of Birth");
			webActions.SendKeysByCharAuto(txt_BusinessState, map.get("STATE"), "Business State");
			webActions.sendKeysByChar(txt_YearEstablished, "2010", "Year Established");
			if (getTestDataMap().get("productLine").equals("Loan")) {
				webActions.sendKeysByChar(txt_companyHaul, Faker.instance().company().name().replace("-", ""),
						"Company you Haul for");
				webActions.sendKeysByChar(txt_CdlDrivingExperience, Faker.instance().random().nextInt(5, 15).toString(),
						"CDL Driving Experience Years");

			}

			report.reportPass("Fill Legal Entity  Info");
		} catch (Exception e) {
			report.reportHardFail("Fill Legal Entity Info");
		}

	}

	/**
	 * For Loans WorkAround Data Needs to be filled from Deposit Seed Data
	 * 
	 */
	private void individualLoanDepositInfo() {
		try {

			Map<String, String> map = getTestDataMap();
			webActions.waitAndSendKeysByChar(txt_SSN, Keys.HOME + map.get("SSN"), "SSN Field");
			cancelExistingDataPopup();

			webActions.sendKeysByChar(txt_Email, global.lowRiskEmail(), "E-mail");
			webActions.sendKeysByChar(txt_FirstName, map.get("FIRST NAME"), "First name");
			webActions.sendKeysByChar(txt_MiddleName, map.get("MIDDLE NAME"), "Middle Name");
			webActions.sendKeysByChar(txt_LastName, map.get("LAST NAME"), "Last Name");
			String dob;

			/// Test Data is Sometimes Missing Complete DOB
			if (map.get("DOB/YOB").length() == 4) {
				dob = "0101" + map.get("DOB/YOB");
			} else {
				dob = map.get("DOB/YOB");
			}
			webActions.sendKeysByChar(txt_DOB, dob, "Date of Birth");
			if (getTestDataMap().get("productLine").equals("Loan")) {
				webActions.sendKeysByChar(txt_companyHaul, Faker.instance().company().name().replace("-", ""),
						"Company you Haul for");
				webActions.sendKeysByChar(txt_CdlDrivingExperience, Faker.instance().random().nextInt(5, 15).toString(),
						"CDL Driving Experience Years");
				webActions.sendKeysByChar(txt_OwnerShipInfo, "82", "OwnerShip Info");

			}

			report.reportPass("Fill Legal Entity Individual Info");
		} catch (Exception e) {
			report.reportHardFail("Fill Legal Entity Individual Info");
		}
	}

	private void corporationInfo() {
		if (getTestDataMap().get("productLine").equals("Loan")) {
			fillLoanCorporationInfo();
		} else {
			fillDepositCorporationInfo();
		}

	}

	private void fillLoanCorporationInfo() {
		try {

			Map<String, String> map = getTestDataMap();
			webActions.waitAndSendKeysByChar(txt_TaxId, Keys.HOME + map.get("company_fein"), "TAX ID Field");
			cancelExistingDataPopup();
			webActions.sendKeysByChar(txt_Email, global.lowRiskEmail(), "Email");

			webActions.sendKeysByChar(txt_companyName, map.get("company_name"), "");
			webActions.SendKeysByCharAuto(txt_BusinessState, map.get("bus_st"), "Business State");
			webActions.sendKeysByChar(txt_YearEstablished, "2010", "Year Established");
			if (!getTestDataMap().get("productType").toString().equalsIgnoreCase("Loan") && getTestDataMap()
					.get("SelectedProduct").toString().equalsIgnoreCase("Commercial Small Ticket Equipment")) {
				webActions.sendKeysByChar(txt_companyHaul, map.get("company_name"), "Company you Haul for");
				webActions.sendKeysByChar(txt_CdlDrivingExperience, Faker.instance().random().nextInt(5, 15).toString(),
						"CDL Driving Experience Years");
			}

			report.reportPass("Fill Corporate Info");
		} catch (Exception e) {
			report.reportHardFail("Fill Corporate Info");
		}
	}

	private void fillDepositCorporationInfo() {
		try {

			Map<String, String> map = getTestDataMap();
			webActions.waitAndSendKeysByChar(txt_TaxId, map.get("SSN"), "SSN Field");
			cancelExistingDataPopup();
			webActions.sendKeysByChar(txt_Email, global.lowRiskEmail(), "Email");

			webActions.sendKeysByChar(txt_companyName, map.get(""), "");
			webActions.SendKeysByCharAuto(txt_BusinessState, map.get("STATE"), "Business State");
			webActions.sendKeysByChar(txt_YearEstablished, "2010", "Year Established");
			if (getTestDataMap().get("productLine").equals("Loan")) {
				webActions.sendKeysByChar(txt_companyHaul, Faker.instance().company().name().replace("-", ""),
						"Company you Haul for");
				webActions.sendKeysByChar(txt_CdlDrivingExperience, Faker.instance().random().nextInt(5, 15).toString(),
						"CDL Driving Experience Years");
			}

			report.reportPass("Fill Deposit Corporate Info");
		} catch (Exception e) {
			report.reportHardFail("Fill Deposit Corporate Info");
		}
	}

	public void clearSSN() {
		webActions.clearByJS(txt_SSN, "SSN Fields");
	}

	public void fillPhysicalAddressDetails() {
		if (getTestDataMap().get("productLine").equals("Loan")) {
			fillLoanPhysicalAddressDetails();
		} else {
			fillDepositPhysicalAddressDetails();
		}

	}

	public void fillLoanPhysicalAddressDetails() {
		try {
			Map<String, String> map = getTestDataMap();
			webActions.clickBYJS(btn_Create, "Create Button");
			webActions.waitAndSendKeysByCharAuto(txt_AddressType, "Physical", "Address Type");
			webActions.sendKeysByChar(txt_AddressOne, map.get("bus_addr1"), "Address one");
			webActions.sendKeysByChar(txt_City, map.get("bus_city_name"), "CITY name");
			webActions.SendKeysByCharAuto(txt_State, map.get("bus_st"), "STATE Name");
			webActions.sendKeysByChar(txt_Zip, Keys.HOME + map.get("company_zip"), "ZIP");
			webActions.clickBYJS(btn_OK, "OK");
			report.reportPass("Fill  Physical Address");
		} catch (Exception e) {
			report.reportHardFail("Fill  Physical Address");
		}

	}

	public void fillDepositPhysicalAddressDetails() {
		try {
			Map<String, String> map = getTestDataMap();
			webActions.clickBYJS(btn_Create, "Create Button");
			webActions.waitAndSendKeysByCharAuto(txt_AddressType, "Physical", "Address Type");
			webActions.sendKeysByChar(txt_AddressOne, map.get("ADDRESS"), "Address one");
			webActions.sendKeysByChar(txt_City, map.get("CITY"), "CITY name");
			webActions.SendKeysByCharAuto(txt_State, map.get("STATE"), "STATE Name");
			webActions.sendKeysByChar(txt_Zip, map.get("ZIP"), "ZIP");
			webActions.clickBYJS(btn_OK, "OK");
			report.reportPass("Fill  Physical Address");
		} catch (Exception e) {
			report.reportHardFail("Fill  Physical Address");
		}
	}

	public void selectMailingAddessSameAsPhysical() {
		try {
			webActions.waitAndCickBYJS(btn_SameAs, "Same as ");
			webActions.waitUntilDisplayed(lbl_ApplicantAddressEdit, "Applicant Address Edit");
			webActions.clickBYJS(btn_OK, "OK");
			report.reportPass("Select Mailing Address same as Physical");
		} catch (Exception e) {
			report.reportHardFail("Select Mailing Address same as Physical");
		}

	}

	public void fillPhonesInfo() {
		if (getTestDataMap().get("productLine").equals("Loan")) {
			fillLoanPhonesInfo();
		} else {
			fillDepositPhonesInfo();
		}

	}

	public void fillLoanPhonesInfo() {
		try {
			webActions.clickBYJS(btn_CreatePhones, "Create Phoness");
			webActions.waitAndSendKeysByCharAuto(txt_PhoneType, "Mobile", "Mobile");
			webActions.sendKeysByChar(txt_PhoneNumber, Keys.HOME + getTestDataMap().get("company_phone").toString(),
					"Phone Number");
			webActions.clickBYJS(btn_OK, "OK");
			clickSaveButton();
			report.reportPass("Fill Phones Info");
		} catch (Exception e) {
			report.reportHardFail("Fill Phones Info");
		}
	}

	public void fillDepositPhonesInfo() {
		try {
			webActions.clickBYJS(btn_CreatePhones, "Create Phones");
			webActions.waitAndSendKeysByCharAuto(txt_PhoneType, "Mobile", "Mobile");
			webActions.sendKeysByChar(txt_PhoneNumber, Keys.HOME + getTestDataMap().get("PHONE").toString(),
					"Phone Number");
			webActions.clickBYJS(btn_OK, "OK");
			clickSaveButton();
			report.reportPass("Fill Phones Info");
		} catch (Exception e) {
			report.reportHardFail("Fill Phones Info");
		}

	}

	public void addCDInfo(String frequency, String method) throws Exception {
		webActions.waitAndSendKeysByCharAuto(txt_CDInfoFrequency, frequency, "CD Info Fequency");
		webActions.SendKeysByCharAuto(txt_CDInfoMethod, method, "CD Info Method");
	}

	public ApplicationEditor startDepositProcess() {
		try {
			if (getTestDataMap().get("productType").equals("Certificate of Deposit")) {
				addCDInfo("Monthly", "CD");
			}
			webActions.waitAndCickBYJS(btn_StartProcess, "Start Process");
			report.reportPass("Start Process");

		} catch (Exception e) {
			report.reportHardFail("Start Process");
		}
		return (ApplicationEditor) base(ApplicationEditor.class);
	}

	public ApplicationEditor startLoanProcess() {
		try {

			webActions.waitAndCickBYJS(btn_StartProcess, "Start Process");
			report.reportPass("Start Process");

		} catch (Exception e) {
			report.reportHardFail("Start Process");
		}
		return (ApplicationEditor) base(ApplicationEditor.class);
	}

	public void selectLegalEntity(String legalEntity) {
		try {
			webActions.waitUntilDisplayed(btn_ApplicantsTable, "Applicants Table");
			webActions.clickBYJS(btn_Create, "Create Applicant");
			webActions.waitAndSendKeysByCharAuto(txt_LegalEntity, legalEntity, "Select legal Entity");
			report.reportPass("Select Legal Entity:" + legalEntity);
		} catch (Exception e) {
			report.reportHardFail("Select Legal Entity:" + legalEntity);
		}

	}

	public void fillLegalEntityInfo(String legalEntity) {
		try {
			webActions.waitAndSendKeysByCharAuto(txt_LegalEntity, legalEntity, "Select legal Entity");

			if (legalEntity.equalsIgnoreCase("Sole Proprietor")) {
				soleProperiotorInfo();
			} else if (legalEntity.equalsIgnoreCase("Corporation")) {
				corporationInfo();
			} else if (legalEntity.equals("Individual")) {
				individualLoanDepositInfo();
			}
			report.reportPass("Fill Legal Entity Info");
		} catch (Exception e) {
			report.reportHardFail("Fill Legal Entity Info");
		}

	}

	public void assertEntityInfoSaved() {
		try {
			WebElement application = webActions.findByText(getTestDataMap().get("bus_company_name").toString(),
					"//td//div");
			webActions.waitUntilDisplayed(application, "Created Loan Application");
			webActions.assertDisplayed(application, "Created Loan Application");
			report.reportPass("Entity Info Saved");
		} catch (Exception e) {
			report.reportHardFail("Entity Info Saved");
		}
	}

	public void fillOpportunityInfo(String businessType, String Amount) {
		try {
			webActions.sendKeysByChar(txt_OpportunityInfo_Name, Faker.instance().name().firstName(), "Name");
			webActions.sendKeysByChar(txt_OpportunityInfo_CurrentLender, Faker.instance().company().name(),
					"current Lender");
			webActions.waitAndSendKeysByCharAuto(txt_OpportunityInfo_Type, businessType, "Business Type");
			webActions.clearAndSendKeysByChar(txt_OpportunityInfo_Amount, Amount, "Amount");
			webActions.sendKeysByChar(txt_OpportunityInfo_Description, Faker.instance().book().title(), "Description");
			webActions.sendKeysByChar(txt_OpportunityInfo_CloseDate,
					Keys.HOME + DateTime.now().plusDays(4).toString("MM/dd/yyyy"), "close date");
			report.reportPass("Opportunity Info");
		} catch (Exception e) {
			report.reportHardFail("Opportunity Info");
		}

	}

	public void fillEquipmentInfo() {

		if (!getTestDataMap().get("productType").toString().equalsIgnoreCase("Loan")
				&& !getTestDataMap().get("SelectedProduct").toString().equalsIgnoreCase("Commercial ABL")) {
			try {

				webActions.clickBYJS(chk_FoundEquipmentToPurchase,
						"Have you found the equipment you would like to purchase");
				webActions.clickBYJS(btn_Equipment_Create, "Create Equipment");
				webActions.waitAndSendKeysByCharAuto(txt_Equipment_Year, "2018", "Equipment Year");

				webActions.SendKeysByCharAuto(txt_Equipment_Make, "CHEVROLET COMMERCIAL", "Equipment Make");

				webActions.SendKeysByCharAuto(txt_Equipment_Model, "City Express", "Equipment Model");

				webActions.SendKeysByCharAuto(txt_Equipment_BodyType, "City Express LS", "Equipment Body Type");

				webActions.waitForTextToBePresentInValue(txt_Equipment_MakeAuto, "CHEVROLET COMMERCIAL",
						"Equipment Mak Auto Populated");
				webActions.sendKeysByChar(txt_Equipment_VIN, Faker.instance().crypto().md5().substring(0, 17), "VIN");
				webActions.sendKeysByChar(txt_Equipment_EquipmentCost, "12000", "Equipment Cost");
				webActions.sendKeysByChar(txt_Equipment_DownPayment, "2000", "Down Payment");
				webActions.clickBYJS(btn_OK, "OK");
				report.reportPass("Equipment Info");
			} catch (Exception e) {
				report.reportHardFail("Equipment Info");
			}
		}

	}

	public void lexusRequstForCorporateEntity() {
		try {
			webActions.waitUntilDisplayed(lbl_EntityType, "Entity Type Table");
			clickSaveButton();
			webActions.waitUntilDisplayed(lbl_ApplicationSaved, "Application saved Label");
			WebElement applicant = webActions.findBy(By.xpath("//div[text()='Corporation']//following::div[text()='"
					+ getTestDataMap().get("company_name") + "']"));
			webActions.doubleClick(applicant, "Applicant");

			webActions.waitAndCickBYJS(lbl_ProviderDetails, "Provider Details");
			webActions.waitAndCickBYJS(btn_LexusNexusRequest, "Lexus Nexus Request");
			webActions.waitUntilDisplayed(lbl_LexusNexusType, "Lexus nexus type");
			webActions.clickBYJS(btn_OK, "OK");
			webActions.waitUntilDisplayed(btn_LexusNexusRequest, "Lexus Nexus Request");
			clickSaveButton();
			report.reportPass("Lexus Nexus Request");
		} catch (Exception e) {
			report.reportHardFail("Lexus Nexus Request fail");
		}

	}

	public void createApplicant() {
		try {
			webActions.waitUntilDisplayed(btn_ApplicantsTable, "Applicants Table");
			webActions.clickBYJS(btn_Create, "Create Applicant");
			report.reportPass("Create Applicant Click ");
		} catch (Exception e) {
			report.reportHardFail("Create Applicant Click ");
		}
	}

	public void addSecondJointHolder() {
		try {

			Map<String, String> map = json.getDepositMap();

			setApplicant("Applicant2", map);

			webActions.waitAndSendKeysByChar(txt_SSN, Keys.HOME + map.get("SSN"), "SSN Field");
			cancelExistingDataPopup();
			webActions.sendKeysByChar(txt_Email, global.lowRiskEmail(), "Email");
			webActions.sendKeysByChar(txt_FirstName, map.get("FIRST NAME"), "First name");
			webActions.sendKeysByChar(txt_MiddleName, map.get("MIDDLE NAME"), "Middle Name");
			webActions.sendKeysByChar(txt_LastName, map.get("LAST NAME"), "Last Name");
			String dob = "";

			/// Test Data is Sometimes Missing Complete DOB
			if (map.get("DOB/YOB").length() == 4) {
				dob = "0101" + map.get("DOB/YOB");
			} else {
				dob = map.get("DOB/YOB");
			}
			webActions.sendKeysByChar(txt_DateOfBirth, dob, "Date of Birth");
			webActions.sendKeysByChar(txt_SecurityCodeWord, Faker.instance().random().hex(4), "Security Code Word");
			String license = map.get("DRIVERS LICENSE").isEmpty() ? Faker.instance().number().digits(6)
					: map.get("DRIVERS LICENSE");
			String licenseState = map.get("DL STATE").isEmpty() ? Faker.instance().address().state()
					: map.get("DL STATE");
			webActions.sendKeysByChar(txt_DrivingLicenseNo, license, "Driving License #");
			webActions.SendKeysByCharAuto(txt_DrivingLicenseState, licenseState, "Driving License State");
			webActions.sendKeysByChar(txt_DrivingLicenseExpiry, "10102020", "SSN Field");
			webActions.sendKeysByChar(txt_DrivingLicenseIssue, "10102010", "SSN Field");
			addAddressAndPhoneInfo(map);
			clickSaveButton();
			report.reportPass("Add Second Account Holder");
		} catch (Exception e) {
			report.reportHardFail("Add Second Account Holder");
		}
	}

	public void addAddressAndPhoneInfo(Map<String, String> map) throws Exception {
		webActions.clickBYJS(btn_Create, "Create Button");
		webActions.waitAndSendKeysByCharAuto(txt_AddressType, "Physical", "Address Type");
		webActions.sendKeysByChar(txt_AddressOne, map.get("ADDRESS"), "Address one");
		webActions.sendKeysByChar(txt_City, map.get("CITY"), "CITY name");
		webActions.SendKeysByCharAuto(txt_State, map.get("STATE"), "STATE Name");
		webActions.sendKeysByChar(txt_Zip, map.get("ZIP"), "ZIP");
		webActions.clickBYJS(btn_OK, "OK1");
		webActions.waitUntilNotPresent(btn_OK, "OK1");
		webActions.waitUntilEnabledCubaButton(btn_SameAs, "Same as ");
		webActions.waitAndCickBYJS(btn_SameAs, "Same as ");
		webActions.waitUntilDisplayed(lbl_ApplicantAddressEdit, "Applicant Address Edit Label");
		webActions.clickBYJS(btn_OK, "OK2");
		webActions.clickBYJS(btn_CreatePhones, "Create Phones");
		webActions.waitUntilDisplayed(lbl_ApplicantPhoneEditor, "Applicant Phone Editor Label");
		webActions.waitAndSendKeysByCharAuto(txt_PhoneType, "Mobile", "Mobile");
		webActions.sendKeysByChar(txt_PhoneNumber, Keys.HOME + map.get("PHONE"), "Phone Number");
		webActions.clickBYJS(btn_OK, "OK3");
	}

	public void secondLegalEntityInfo(String secondLegalEntityType) {
		try {

			if (secondLegalEntityType.equalsIgnoreCase("Individual")) {
				addSecondJointHolder();
			}

			report.reportPass("Fill Second Legal Entity  Info: " + secondLegalEntityType);
		} catch (Exception e) {
			report.reportHardFail("Fill Second Legal Entity  Info: " + secondLegalEntityType);
		}
	}

	public void addLoanIndividualInfo() {
		try {
			webActions.waitAndCickBYJS(btn_ApplicantsCreate, "Create Applicants");
			webActions.waitAndSendKeysByCharAuto(txt_LegalEntity, "Individual", "Select legal Entity");
			loanIndividualInfo();
			report.reportPass("Add Loan Individual Info");
		} catch (Exception e) {
			report.reportHardFail("Add Loan Individual Info");
		}
	}

	public void loanIndividualInfo() {
		try {

			Map<String, String> map = json.getIndividualMap();
			webActions.waitAndSendKeysByChar(txt_SSN, Keys.HOME + map.get("SSN"), "SSN Field");
			cancelExistingDataPopup();
			webActions.sendKeysByChar(txt_Email, global.lowRiskEmail(), "Email");
			webActions.sendKeysByChar(txt_FirstName, map.get("First Name"), "First name");
			webActions.sendKeysByChar(txt_MiddleName, map.get("Middle"), "Middle Name");
			webActions.sendKeysByChar(txt_LastName, map.get("Last Name"), "Last Name");

			String dob = map.get("DOB/YOB");

			/// Test Data is Sometimes Missing Complete DOB

			if (map.get("DOB/YOB").length() == 4) {

				dob = "0101" + map.get("rep1_dob");
			}
			webActions.sendKeysByChar(txt_DateOfBirth, dob, "Date of Birth");
			webActions.sendKeysByChar(txt_SecurityCodeWord, "1234", "Security Code Word");
			if (getTestDataMap().get("SelectedProduct").toString()
					.equalsIgnoreCase("Commercial Small Ticket Equipment")) {
				webActions.sendKeysByChar(txt_companyHaul, Faker.instance().company().name().replace("-", ""),
						"Company you Haul for");
				webActions.sendKeysByChar(txt_CdlDrivingExperienceLoans,

						Faker.instance().random().nextInt(5, 15).toString(), "CDL Driving Experience Years");
			}
			webActions.sendKeysByChar(txt_OwnerShipInfo, "80", "OwnerShip Info");
			webActions.clickBYJS(btn_Create, "Create Button");
			String address = map.get("House #") + " " + map.get("Street Name") + " " + map.get("Str Suf") + " "
					+ map.get("Unit") + " " + map.get("Unit #");
			webActions.waitAndSendKeysByCharAuto(txt_AddressType, "Physical", "Address Type");
			webActions.sendKeysByChar(txt_AddressOne, address, "Address one");
			webActions.sendKeysByChar(txt_City, map.get("City"), "CITY name");
			webActions.SendKeysByCharAuto(txt_State, map.get("State"), "STATE Name");
			webActions.sendKeysByChar(txt_Zip, map.get("ZIP Code"), "ZIP");
			webActions.clickBYJS(btn_OK, "OK1");
			webActions.waitUntilNotPresent(btn_OK, "OK1");
			webActions.waitUntilEnabledCubaButton(btn_SameAs, "Same as ");
			webActions.waitAndCickBYJS(btn_SameAs, "Same as ");
			webActions.waitUntilDisplayed(lbl_ApplicantAddressEdit, "Applicant Address Edit Label");
			webActions.clickBYJS(btn_OK, "OK2");
			webActions.clickBYJS(btn_CreatePhones, "Create Phones");
			webActions.waitUntilDisplayed(lbl_ApplicantPhoneEditor, "Applicant Phone Editor Label");
			webActions.waitAndSendKeysByCharAuto(txt_PhoneType, "Mobile", "Mobile");
			webActions.sendKeysByChar(txt_PhoneNumber, Keys.HOME + map.get("PHONE"), "Phone Number");
			webActions.clickBYJS(btn_OK, "OK3");
			clickSaveButton();
			report.reportPass("Fill Loan Indiviual  Info");
		} catch (Exception e) {
			report.reportHardFail("Fill Loan Indiviual  Info");
		}
	}

	public void updateLoanIndividualGuarantor() {
		try {
			webActions.waitUntilDisplayed(btn_ApplicantsCreate, "Create Applicants");
			clickSaveButton();
			webActions.waitUntilDisplayed(lbl_ApplicationSaved, "Application Saved");
			webActions.clickAction(lbl_ApplicantsTableIndividual, "Applicants Table Individual");
			webActions.rightClickAction(lbl_ApplicantsTableIndividual, "Applicants Table Individual");
			webActions.waitAndCickBYJS(lbl_SystemInfomation, "System Information");
			webActions.waitUntilDisplayed(lbl_ApplicantID, "Applicant ID");
			String ID = lbl_ApplicantID.getText();
			webActions.clickBYJS(btn_ClosePopup, "Close System information popup");
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection(TestBase.props.getProperty("onboarding.int.db"));

			String query = "UPDATE [int.onboarding].dbo.EDGE_APPLICANT SET guarantor = '0'  WHERE id='" + ID + "'";

			Statement st = conn.createStatement();

			st.executeUpdate(query);
			report.reportPass("Update Loan Indiviual  Guarantor value to 0");
		} catch (Exception e) {
			report.reportHardFail("Update Loan Indiviual  Guarantor value to 0");
		}

	}

	@Override
	protected ExpectedCondition<?> getPageLoadCondition() {
		return ExpectedConditions.visibilityOf(btn_Create);
	}

}
