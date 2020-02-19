package com.tab.af.web.pages.EquipmentFinancing;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.tab.af.testbase.TestBase;
import com.tab.af.web.pages.BasePage;
import com.tab.af.web.pages.OnBoarding.Login;

public class Agreements extends BasePage {
	@FindBy(xpath = "//body")
	private WebElement page;
	String btn_ViewECD = "agreement-element[id='agreementComponent']>paper-button";
	String btn_ClosePreview = "paper-dialog[id='documentDialog']>div[class='mdl-grid']>iron-icon[icon='icons:clear'][style='float:right; cursor:pointer']";
	String btn_AgreeECD = "paper-checkbox[class='green white agreement-accept']";
	String btn_Submit = "paper-button[id='_nextButton']";
	String lbl_SubmitSuccess = "submit-popup[id='_applicationCompletionModal']>paper-dialog>div>div[style='text-align:center']>h1";
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		return ExpectedConditions.visibilityOf(page);
	}

	public Login completeAgreements() {
		try {
			webActions.waitUntilDisplayed(shadow.findElement(btn_ViewECD), "View ECD");
			shadow.click(btn_ViewECD, "View ECD");
			webActions.waitUntilDisplayed(shadow.findElement(btn_ClosePreview), "Wait until Close PDF Preview Displayed");
			 shadow.click(btn_ClosePreview, "Close Preview");
			 webActions.waitUntilNotDisplayed(shadow.findElement(btn_ClosePreview), "Close PDF Preview Button");
			 shadow.click(btn_AgreeECD, "Agree ECD Checkbox");
			 
			 shadow.click(btn_Submit, "Submit"); 
			 
			 webActions.waitUntilDisplayed(shadow.findElement(lbl_SubmitSuccess),"Submit Success") ;
			String env = TestBase.props.getProperty("onboarding.env");
			String URL="";
			if(env.equals("acpt"))
			{
				URL=TestBase.props.getProperty("onboarding.acpt.url"); 
				webActions.loadURL(URL);
			 
			} else if(env.equals("int")){
				URL=TestBase.props.getProperty("onboarding.int.url");
				webActions.loadURL(URL);
			}
			report.reportPass("Complete Agreements and Submit");
		} catch (Exception e) {
			report.reportHardFail("Complete Agreements and Submit");
		}
return (Login)base(Login.class);
	}
}
