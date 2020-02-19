package com.tab.af.web.pages.PolymerDeposits;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.github.javafaker.Faker;
import com.tab.af.web.pages.BasePage;

public class BasicInformation extends BasePage {
	@FindBy(xpath = "//body")
	private WebElement page;
	String btn_ManualEntry = "paper-button[id='manual']";
	String lbl_BasicInfo="mtz-wizard-step[label='Basic Information']>div>h1[class='basic-info-label']";
	String txt_FirstName = "paper-input[id='firstName']";
	String txt_MiddleName = "paper-input[id='middleName']";
	String txt_LastName = "paper-input[id='lastName']";
	String txt_Email = "iron-form[id='_basicInfoForm']>form>div>paper-input[id='email'][aria-disabled='false']";
	String txt_DateOfBirth = "paper-input[id='dob']";
	String btn_Next = "paper-button[id='_nextButton'][role='button']";
	String txt_PersonalPhone = "paper-input[id='_mobilePhoneNo']";
	String txt_HomePhone = "paper-input[id='_homePhoneNo']";
	String txt_SSN = "iron-form[id='_basicInfoForm']>form>div>paper-input[id='_ssnInput'][aria-disabled='false']";
	String txt_LicenseNumber = "paper-input[id='driversLicenseNum']"; 
	String drp_LicenseState = "paper-autocomplete[id='driversLicenseState']>paper-input[id='autocompleteInput']";
	String txt_LicenseExpiryDate = "paper-input[id='expiryDatepicker']";
	String txt_LicenseIssueDate = "paper-input[id='issueDatepicker']";
	String txt_PhysicalAddress = "paper-input[id='addressText']";
	String txt_PhysicalAddressCity = "paper-input[id='cityText']";
	String drp_PhysicalAddressState = "paper-autocomplete[id='_stateDD']>paper-input[id='autocompleteInput']";
	String txt_PhysicalAddressZIP = "paper-input[id='zipText']";
	String chk_CheckIFMailingSameAsPhysical = "paper-checkbox[id='mailingSameAsPhysical']";
	String txt_SecurityCodeWord= "paper-input[id='securityCodeWord']";
	String drp_Occupation = "paper-autocomplete[id='_occupationDD']>paper-input[id='autocompleteInput']";
	String drp_IncomeRange = "paper-autocomplete[id='_incomeDD']>paper-input[id='autocompleteInput']";
	String lst_IncomeRange="paper-autocomplete[id='_incomeDD']>paper-item[role='option']";
	String rBtn_PoliticallyExposedPerson = "custom-radio-group[id='politicallyExposedPerson']>paper-radio-button[id='_option']";
	String rBtn_WillAccountBeusedFOrBusinessOrCommercialPurpose = "custom-radio-group[id='accountForCommercialPurposeQue']>paper-radio-button[id='_option']";
	String chk_NotSubjectToBackupWitholding="paper-radio-button[name='no']";
	String chk_CertifyTaxCertification="paper-checkbox[id='_irsSubjectToBackupWitholding']";
	
	String drp_legalEntityList = "paper-item[class='paper-item']";
	String drp_legalEntity = "paper-input-container[id='container']";
	String txt_taxID = "paper-input[id='_taxID']"; 
	String txt_companyName = "paper-input[id='companyName']";
	String txt_DoingBusinessAs="paper-input[name='doingBusinessAs']";
	String drp_NatureOfBusinessList = "paper-dropdown-menu[id='natureOfBusinessControl']";
	String drp_NatureOfBusiness = "paper-item[role='option'][aria-disabled='false']";
	String txt_email = "paper-input[label='Email Address']";
	String txt_mobile = "paper-input[id='_mobilePhoneNo']";
	String txt_Home = "paper-input[id='_homePhoneNo']";
	String txt_businessPhone = "paper-input[id='_businessPhoneNo']";
	
	@Override
	protected ExpectedCondition getPageLoadCondition() {

		return ExpectedConditions.visibilityOf(page);
	}

	public void selectEntryAsManual() {

		try {
			shadow.waitAndClick(btn_ManualEntry, "Manual Entry ");
			report.reportPass("Manual Entry ");
		} catch (Exception e) {
			report.reportHardFail("Manual Entry ");
		}

	}
	public void assertBasicInfoPage()
	   {
		   try {
			  
			    shadow.waitAndfindElement(lbl_BasicInfo, "Homepage Header");
			   String headerText=shadow.findElements(lbl_BasicInfo).get(1).getText();
			   Assert.assertEquals("Now, let's gather some basic Information", headerText);
			   
			   report.reportPass("Assert Basic Information Page");
		} catch (Exception e) {
			report.reportHardFail("Assert Basic Information Page");
		}
	   }
	public void fillBasicInfo() {
		try {
               
			Map<String, String> map = getTestDataMap();
			shadow.waitAndSendKeys(txt_FirstName, map.get("FIRST NAME"), "First Name");
			shadow.sendKeys(txt_MiddleName, map.get("MIDDLE NAME"), "Middle Name");
			shadow.sendKeys(txt_LastName, map.get("LAST NAME"), "Last Name");
			 webActions.sendKeys(shadow.findElements(txt_Email).get(0), global.lowRiskEmail(), "Email");
			 String dob =  map.get("DOB/YOB");
			 if(dob.length()==4) {
				 dob="0101"+dob;
			 }
			shadow.sendKeys(txt_DateOfBirth, dob, "Date of Birth");
			shadow.sendKeys(txt_PersonalPhone, map.get("PHONE"), "Personal Phone");
			shadow.sendKeys(txt_HomePhone, map.get("PHONE"), "Home Phone");
			 
			 webActions.sendKeys(shadow.findElements(txt_SSN).get(0), map.get("SSN"), "SSN");
			shadow.click(btn_Next, "Next");
			report.reportPass("Fill Basic info");
		} catch (Exception e) {
			report.reportHardFail("Fill Basic Info");
		}
	}
	public void driversLicenseInfo() {
		try {
		 
			shadow.waitUntilDisplayedAndSendKeys(txt_LicenseNumber,Faker.instance().number().digits(8), "License Number");
			shadow.sendKeystoAuto(drp_LicenseState, getTestDataMap().get("STATE").toString(), "License State");
			shadow.sendKeys(txt_LicenseExpiryDate, "10102030", "License Expiry Date");
			shadow.sendKeys(txt_LicenseIssueDate, "10102010", "License Issue Date");
			report.reportPass("Fill Applicant Drivers License");
		} catch (Exception e) {
			report.reportHardFail("Fill  Drivers License");
		}

	}
	public void PhysicalAddress() {
		try {
			Map<String, String> map = getTestDataMap();
			shadow.waitUntilDisplayedAndSendKeys(txt_PhysicalAddress, map.get("ADDRESS"), "Physical Address ");
			shadow.sendKeys(txt_PhysicalAddressCity, map.get("CITY"), "Physical Address City");
			shadow.sendKeystoAuto(drp_PhysicalAddressState, map.get("STATE"), "Physical Address State");
			shadow.sendKeys(txt_PhysicalAddressZIP, map.get("ZIP"), "Physical Address City");
			report.reportPass("Fill Physical Address");
		} catch (Exception e) {
			report.reportHardFail("Fill Physical Address");
		}

	}
	public void MailingAddressSameasPhysical() {
		try {
			shadow.click(chk_CheckIFMailingSameAsPhysical, "Check if Mailing Address Same as Physical");
			 

			report.reportPass("Fill Applicant Mailing Address");
		} catch (Exception e) {
			report.reportHardFail("Fill Applicant Mailing Address");

		}
	}
	public void otherImportantInformation(String incomeRange,String politicallyExposedPerson,String businessOrCommercialPurpose) {
		try {
			shadow.sendKeys(txt_SecurityCodeWord, Faker.instance().number().digits(4), "Security Code word");
			shadow.sendKeystoAuto(drp_Occupation,"Administrative Services", "Occupation");
			 shadow.click(drp_IncomeRange, "Income Range");
			shadow.clickByTextInList(lst_IncomeRange, incomeRange, "Income Range");
			shadow.selectRadioButonByLabel(rBtn_PoliticallyExposedPerson, politicallyExposedPerson,
					"Politically Exposed Person");
			shadow.selectRadioButonByLabel(rBtn_WillAccountBeusedFOrBusinessOrCommercialPurpose, businessOrCommercialPurpose,
					"Will your account be used for business or commercial purposes");
			report.reportPass("Fill Other Important Information"); 
			
		} catch (Exception e) {
			report.reportHardFail("Fill Other Important Information");

		}
		 
	}
	public CertificateOfDeposit backupWithholding()
	{
		try {
			
		 
		shadow.click(chk_NotSubjectToBackupWitholding, "Not Subject to Backup withholding");
		WebElement element=shadow.findElement(chk_CertifyTaxCertification);
		webActions.waitAndClick(element, "Backup WithHolding");
		shadow.click(btn_Next, "Next");
		report.reportPass("Backup Withholding");
	} catch (Exception e) {
		report.reportHardFail("Backup WithHolding");

	}
	return (CertificateOfDeposit)base(CertificateOfDeposit.class);
	}
	public void legalEntityInfo(String legalEntityType) {
		try {
			
			 
		Map<String, String> map = getTestDataMap();
 
		shadow.waitAndClick(drp_legalEntity, "Legal Entity");
		shadow.clickByTextInList(drp_legalEntityList, legalEntityType, "Legal Entity Type");
		shadow.sendKeys(txt_taxID, map.get("SSN"), "SSN Field");  
		shadow.sendKeys(txt_companyName,Faker.instance().company().name(), "Company Name");
		shadow.sendKeys(txt_DoingBusinessAs,Faker.instance().random().hex(6), "Doing Business As");
		shadow.click(drp_NatureOfBusinessList, "Nature Of Business");
		shadow.clickByTextInList(drp_NatureOfBusiness, "Educational Services", "Nature Of Business");
		 
	 shadow.sendKeys(txt_email,global.lowRiskEmail(), "EMail");
		shadow.sendKeys(txt_mobile, map.get("PHONE"), "Mobile");  
		shadow.sendKeys(txt_HomePhone, map.get("PHONE"), "Home");  
		shadow.sendKeys(txt_businessPhone, map.get("PHONE"), "Business");  
		report.reportPass("Legal Entity Info");
		shadow.click(btn_Next, "Next");
		} catch (Exception e) {
			report.reportHardFail("Legal Entity Info");

		}
	}
}