package com.tab.af.web.pages.OnBoarding;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.tab.af.web.pages.BasePage;

 
public class ApplicationsHome extends BasePage {

	@FindBy(xpath = "//span[text()='Application']")
	private WebElement lnl_Application;
	@FindBy(xpath = "//span[text()='Applications']")
	private WebElement lnk_Applications;
	@FindBy(xpath = "//span[text()='Administration']")
	private WebElement lnk_Administration;
	@FindBy(xpath = "//span[text()='Email History']")
	private WebElement lnk_EmailHistory;
	@FindBy(xpath = "//div[@cuba-id=\"logoutButton\"]")
	private WebElement btn_Logout;
	@Override
	protected ExpectedCondition getPageLoadCondition() { 
		return ExpectedConditions.visibilityOf(lnl_Application);
	}

	public ApplicationCreation openApplications() {
		try { 
			webActions.waitUntilDisplayed(lnl_Application, "Application Link"); 
			webActions.clickAction(lnl_Application, "Application");
			webActions.waitAndCickBYJS(lnk_Applications, "Applications Link");
			report.reportPass("Open Applications");
		} catch (Exception e) {
			report.reportHardFail("Open Applications");
		}
		return (ApplicationCreation) base(ApplicationCreation.class);
	}
	public ApplicationEditor openLoanApplicationsPolymer() {
		try { 
			webActions.waitAndCickBYJS(lnl_Application, "Application Link"); 
			webActions.waitAndCickBYJS(lnk_Applications, "Applications Link");
			report.reportPass("Open Applications");
		} catch (Exception e) {
			report.reportHardFail("Open Applications");
		}
		return (ApplicationEditor) base(ApplicationEditor.class);
	}
	public ApplicationEditor openDespoitApplicationsPolymer() {
		try { 
			webActions.waitAndCickBYJS(lnl_Application, "Application Link"); 
			webActions.waitAndCickBYJS(lnk_Applications, "Applications Link");
			report.reportPass("Open Applications");
		} catch (Exception e) {
			report.reportHardFail("Open Applications");
		}
		return (ApplicationEditor) base(ApplicationEditor.class);
	}
	public EmailHistory openEmailHistory() {
		try { 
			webActions.clickAction(lnk_Administration, "Administration"); 
			webActions.clickAction(lnk_EmailHistory, "Email History");
			report.reportPass("Open Email History");
		} catch (Exception e) {
			report.reportHardFail("Open Email History");
		}
		return (EmailHistory) base(EmailHistory.class);
	}
	 public void logOut() {
		  try {
			  webActions.clickBYJS(btn_Logout, "Logout"); 
		  report.reportPass("Login Success"); 
		} catch (Exception e) {
			report.reportHardFail("Login With Valid Credentials");
		}
	  }
}
