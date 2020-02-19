package com.tab.af.web.pages.PolymerDeposits;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.tab.af.testbase.TestBase;
import com.tab.af.web.pages.BasePage;
import com.tab.af.web.pages.OnBoarding.Login;

public class Agreements extends BasePage {
	@FindBy(xpath = "//body")
	private WebElement page;
	String header = "mtz-wizard-step[name='agreementStep']>div[class='card']>div[class='agreement-info mdl-grid']>h1";
	String btn_ViewECD = "agreement-element[id='_agreementstep']>paper-button[role='button']";
	String btn_ClosePreview = "paper-dialog[id='documentDialog']>div[class='mdl-grid']>div[style='float:right']>iron-icon[icon='icons:clear']";
	String btn_AgreeECD = "paper-checkbox[id*='_customerAgreement']";
	String btn_Submit = "paper-button[id='_nextButton']";
	String lbl_SubmitSuccess = "paper-dialog[id='_submitApp']>div[class='mdl-grid']>div[style='text-align:center;align-items:center']>paper-button[id='trigger']";
	String btn_Next = "paper-button[id='_nextButton'][role='button']";
	@Override
	protected ExpectedCondition getPageLoadCondition() {

		return ExpectedConditions.visibilityOf(page);
	}

	public void validateAgreementsPage() {
		try {
        shadow.waitUntilDisplayed("h5[class='float-right']", "");
     
       
       List<WebElement> lo=shadow.findElements("paper-radio-button[id='_option'][aria-disabled='false'][role='radio']");
       for (WebElement webElement : lo) {
		if(webElement.getText().equalsIgnoreCase("NONE OF THE ABOVE/DOES NOT APPLY")) {
			webElement.click();
		}
		else if(webElement.getText().isEmpty() && webElement.isDisplayed()) {
			webElement.click();
		}
	}
       shadow.click(btn_Next, "Next");
			shadow.waitUntilDisplayed(header, "Agreementsa  Header");
			String headerText = shadow.getText(header, "Agreementsa  Header");
			Assert.assertEquals("Great! Time to review the terms", headerText);

			report.reportPass("Assert Agreements Page");
		} catch (Exception e) {
			report.reportHardFail("Assert Agreements Page");
		}
	}

	public Login completeAgreements() {
		try {
		 
			webActions.waitUntilDisplayed(shadow.findElement(btn_ViewECD), "View ECD");
			shadow.click(btn_ViewECD, "View ECD");
			webActions.waitUntilDisplayed(shadow.findElement(btn_ClosePreview),
					"Wait until Close PDF Preview Displayed");
			shadow.click(btn_ClosePreview, "Close Preview");
			webActions.waitUntilNotDisplayed(shadow.findElement(btn_ClosePreview), "Close PDF Preview Button");
			shadow.click(btn_AgreeECD, "Agree ECD Checkbox");

			shadow.click(btn_Submit, "Submit");

			webActions.waitUntilDisplayed(shadow.findElement(lbl_SubmitSuccess), "Submit Success").isDisplayed();
			//Wait for Application to be display in onboarding
			Thread.sleep(10000);
			String env = TestBase.props.getProperty("onboarding.env");
			String URL = "";
			if (env.equals("acpt")) {
				URL = TestBase.props.getProperty("onboarding.acpt.url");
				webActions.loadURL(URL);

			} else if (env.equals("int")) {
				URL = TestBase.props.getProperty("onboarding.int.url");
				webActions.loadURL(URL);
			}
			
			report.reportPass("Complete Agreements and Submit");
		} catch (Exception e) {
			report.reportHardFail("Complete Agreements and Submit");
		}
		return (Login)base(Login.class);
	}

}
