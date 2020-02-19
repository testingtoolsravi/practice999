package com.tab.af.web.pages.PolymerDeposits;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.github.javafaker.Faker;
import com.tab.af.web.pages.BasePage;

public class CertificateOfDeposit extends BasePage {
	@FindBy(xpath = "//body")
	private WebElement page;
	String header = "interest-options[id='_certificateOfDepositStep']>h1";
	String chk_Annualy = "paper-radio-button[name='Annually']";
	String chk_Manually = "paper-radio-button[name='Monthly']";
	String chk_PostedToCD = "paper-radio-button[name='CD']";
	String txt_FirstName = "paper-input[name='firstname']"; 
	String txt_LastName = "paper-input[name='lastname']"; 
	String txt_DateOfBirth = "paper-input[id='payOnDeathDobContainer'][placeholder='MM-DD-YYYY']";
	String btn_Next = "paper-button[id='_nextButton'][role='button']";
	String txt_PersonalPhone = "paper-input[id='_mobilePhoneNo'][name='phone'][error-message='Phone number should be 10 digits']"; 
	String txt_SSN = "paper-input[id='_ssnInputPOD'][aria-disabled='false']"; 
	String txt_PhysicalAddress = "paper-input[id='addressText'][error-message='Address cannot be empty']";
	String txt_PhysicalAddressCity = "paper-input[id='cityText'][error-message='City cannot be empty']";
	String drp_PhysicalAddressState = "paper-input[id='autocompleteInput'][error-message='State cannot be empty']";
	String txt_PhysicalAddressZIP = "paper-input[id='zipText'][error-message='Zip code should be 5 digits']";
	@Override
	protected ExpectedCondition getPageLoadCondition() {

		return ExpectedConditions.visibilityOf(page);
	}

	public void validateCODPage() {
		try {
			 shadow.waitAndfindElement(header, "cod  Header");
			String headerText = shadow.getText(header, "cod  Header");
			Assert.assertEquals("Just a few more details for your CD", headerText);

			report.reportPass("Assert HomePage");
		} catch (Exception e) {
			report.reportHardFail("Assert HomePage");
		}
	}

	public void interestFrequencyAndMethod(String frequency, String method) {
		try {
			selectInterestFrequency(frequency);
			selectInterestMethod(method);
			report.reportPass("Assert HomePage");
		} catch (Exception e) {
			report.reportHardFail("Assert HomePage");
		}

	}
	private void selectInterestFrequency(String frequency)
	{
		if(frequency.equalsIgnoreCase("Annually"))
		{
		shadow.click(chk_Annualy, "Annual Interest");
		}
		else if(frequency.equalsIgnoreCase("Monthly"))
		{
			shadow.click(chk_Manually, "Monthly Interest");
		}
	}
	private void selectInterestMethod(String method)
	{
		if(method.equalsIgnoreCase("Posted to CD"))
        {
       	 shadow.click(chk_PostedToCD, "Posted to CD"); 
        }
	}
	public Agreements payOnDeath()
	{
		try {
			Map<String, String> map=getTestDataMap();
			 
			
		 
			 shadow.sendKeys(txt_FirstName, Faker.instance().name().firstName(), "First Name");
			 
			 shadow.sendKeys(txt_LastName, Faker.instance().name().lastName(), "Last Name");
			 
			shadow.sendKeys(txt_PhysicalAddress, Faker.instance().address().streetAddress(), "Physical Address ");
			shadow.sendKeys(txt_PhysicalAddressCity,Faker.instance().address().cityName(), "Physical Address City");
			shadow.sendKeystoAuto(drp_PhysicalAddressState, Faker.instance().address().state(), "Physical Address State");
			shadow.sendKeys(txt_PhysicalAddressZIP, Faker.instance().address().zipCode(), "Physical Address City");
			 
			  shadow.sendKeys(txt_PersonalPhone, map.get("PHONE"), "Personal Phone");
			 webActions.sendKeys(shadow.findElements(txt_SSN).get(0), Faker.instance().number().digits(9), "SSN");
			 String dob= map.get("DOB/YOB");
			 if(dob.length()==4) {
				 dob="0101"+dob;
			 }
			shadow.sendKeys(txt_DateOfBirth, dob, "DOB");
			shadow.click(btn_Next, "Next");
			report.reportPass("Pay on Death");
		} catch (Exception e) {
			report.reportHardFail("Pay on Death");
		}
		return (Agreements)base(Agreements.class);
	}
}
