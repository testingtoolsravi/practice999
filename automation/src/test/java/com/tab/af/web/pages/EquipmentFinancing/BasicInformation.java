package com.tab.af.web.pages.EquipmentFinancing;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.github.javafaker.Faker;
import com.tab.af.testbase.TestBase;
import com.tab.af.web.pages.BasePage;

public class BasicInformation extends BasePage {
	@FindBy(xpath = "//body")
	private WebElement page;
	String drp_legalEntity = "paper-input-container[id='container']";
	String drp_legalEntityList = "paper-item[class='paper-item']";
	String txt_taxID = "paper-input[id='taxId']";
	String txt_SSN = "paper-input[id='ssn']";
	String txt_companyName = "paper-input[id='companyName']";
	String txt_doingBusinessAs = "paper-input[id='doingBusinessAs']";
	String txt_email = "paper-input[id='email']";
	String txt_mobile = "paper-input[id='_mobilePhoneNo']";
	String txt_businessPhone = "paper-input[id='_businessPhoneNo']";
	String btn_Next = "paper-button[id='_nextButton']";
	String txt_FirstName = "paper-input[id='firstName']";
	String txt_MiddleName = "paper-input[id='middleName']";
	String txt_LastName = "paper-input[id='lastName']";
	String txt_DateOfBirth = "paper-input[id='datecontrol_dob']";
	String txt_yearsDriving = "paper-input[id='yearsDriving']";
	@Override
	protected ExpectedCondition getPageLoadCondition() {

		return ExpectedConditions.visibilityOf(page);
	}

	public BasicInformation() {

		PageFactory.initElements(driver, this);
	}

	public void loadUserData()  {
		
		try {
			setTestDataMap(json.getLoanMap());
		} catch (Exception e) {
			 
		 report.reportHardFail(e.getMessage());
		}
	}

	public BusinessInformation fillBasicInformation(String legalEntityType, String businessAs,String secondApplicantType) {
		getTestDataMap().put("legalEntityType", legalEntityType);
		getTestDataMap().put("secondApplicantType", secondApplicantType);
		webActions.loadURL(TestBase.props.getProperty("equipment.financing.int.url"));
		
		if (legalEntityType.equalsIgnoreCase("Sole proprietor")) {
			fillSoleProperiotorBasicInformation(legalEntityType, businessAs);
		} else {
			try {
				Map<String, String> map = getTestDataMap(); 
				shadow.click(drp_legalEntity, "Legal Entity");
				shadow.clickByTextInList(drp_legalEntityList, legalEntityType, "Legal Entity Type");
				shadow.sendKeys(txt_taxID, map.get("bestfein"), "Tax ID");
				shadow.sendKeys(txt_companyName, map.get("bestcompanyname"), "Company name");
				shadow.sendKeys(txt_doingBusinessAs, businessAs, "Business As");
				shadow.sendKeys(txt_email, global.lowRiskEmail(), "Email");
				shadow.sendKeys(txt_mobile, map.get("bestphone"), "Mobile");
				shadow.sendKeys(txt_businessPhone, map.get("bestphone"), "Business");
				shadow.click(btn_Next, "Next");
				report.reportPass("Fill Basic Information");
			} catch (Exception e) {
				report.reportHardFail("Fill Basic Information");
			}
			
		}
		return (BusinessInformation) base(BusinessInformation.class);
	}

	public void fillSoleProperiotorBasicInformation(String legalEntityType, String businessAs) {
		
		try {
			Map<String, String> map = getTestDataMap();
			shadow.click(drp_legalEntity, "Legal Entity");
			shadow.clickByTextInList(drp_legalEntityList, legalEntityType, "Legal Entity Type");
			shadow.sendKeys(txt_SSN, map.get("rep1_ssn"), "SSN"); 
			shadow.sendKeys(txt_FirstName, map.get("rep1_firstname"), "First Name"); 
			shadow.sendKeys(txt_MiddleName, map.get("rep1_middlename"), "Middle Name"); 
			shadow.sendKeys(txt_LastName, map.get("rep1_lastname"), "Last Name"); 
			shadow.sendKeys(txt_doingBusinessAs, businessAs, "Business As");
			shadow.sendKeys(txt_email, global.lowRiskEmail(), "Email");
			shadow.sendKeys(txt_DateOfBirth, global.formatDateString( map.get("rep1_dob")), "Date of Birth");
			shadow.sendKeys(txt_mobile, map.get("bestphone"), "Mobile");
			shadow.sendKeys(txt_businessPhone, map.get("bestphone"), "Business");
			shadow.sendKeys(txt_yearsDriving, Faker.instance().random().nextInt(1, 5).toString(), "Business");
			shadow.click(btn_Next, "Next");
			report.reportPass("Fill Sole Properiotor Basic Information");
		} catch (Exception e) {
			report.reportHardFail("Fill Sole Properiotor Basic Information");
		}

	}
	

}
