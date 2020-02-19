package com.tab.af.web.pages.EPrecision;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.tab.af.testbase.TestBase;
import com.tab.af.web.pages.BasePage; 

public class Login extends BasePage {
	@FindBy(xpath = "//input[@name=\"loginField\"]")
	private WebElement txt_UserName;

	@FindBy(xpath = "//input[@name=\"passwordField\"]")
	private WebElement txt_Password;

	@FindBy(xpath = "//span[text()='Submit']")
	private WebElement btn_Login;
  public Login()
  {
	  PageFactory.initElements(driver, this);
  }
	public HomePage login(String userName, String password) {
		try {

			String URL = TestBase.props.getProperty("eprecision.int.url");
			webActions.loadURL(URL);

			base(Login.class);
			webActions.waitUntilDisplayed(txt_UserName, "UserName");
			TestBase.props.put("Ebank.build.version", global.getBuildVersionFromSource(webActions.getPageSource()));
			webActions.sendKeys(txt_UserName, userName, "UserName");
			webActions.sendKeys(txt_Password, password, "Password");
			webActions.clickBYJS(btn_Login, "Login button");
			report.reportPass("Login Success");
			 
		} catch (Exception e) {
			report.reportHardFail("Login With Valid Credentials");
		}
		return (HomePage) base(HomePage.class);
	}

	@Override
	protected ExpectedCondition getPageLoadCondition() {

		return ExpectedConditions.visibilityOf(txt_UserName);
	}
}
