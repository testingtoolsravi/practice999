package com.tab.af.web.pages.EBank;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.tab.af.testbase.TestBase;
import com.tab.af.web.pages.BasePage;

public class Login extends BasePage {
	@FindBy(xpath = "//div[text()='Login']//following::input[1]")
	private WebElement txt_UserName;

	@FindBy(xpath = "*//div[text()='Password']//following::input[1]")
	private WebElement txt_Password;

	@FindBy(xpath = "//span[text()='Submit']")
	private WebElement btn_Login;
	@FindBy(xpath = "//div[contains(@class,'logout-button') and @role=\"button\"]")
	private WebElement btn_LogOut;
  public Login()
  {
	  PageFactory.initElements(driver, this);
  }
	public HomePage login(String userName, String password) {
		try {
			
		 	String URL = TestBase.props.getProperty("ebank.int.url");
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
	public HomePage loginAsAdmin() {
		try {
			
		 	String URL = TestBase.props.getProperty("ebank.int.url");
			 webActions.loadURL(URL);
		 String adminUser=TestBase.props.getProperty("admin.user");
		 String adminPassword=TestBase.props.getProperty("admin.password");
			base(Login.class);
			webActions.waitUntilDisplayed(txt_UserName, "UserName");
			TestBase.props.put("Ebank.build.version", global.getBuildVersionFromSource(webActions.getPageSource()));
			webActions.sendKeys(txt_UserName, adminUser , "UserName");
			webActions.sendKeys(txt_Password,adminPassword , "Password");
			webActions.clickBYJS(btn_Login, "Login button");
			report.reportPass("Login Success as Admin");
			 
		} catch (Exception e) {
			report.reportHardFail("Login Failure as Admin");
		}
		return (HomePage) base(HomePage.class);
	}
   public void logOut()
   {
	   try {
		   webActions.clickBYJS(btn_LogOut, "Logout");
		   webActions.waitUntilDisplayed(btn_Login, "Login Button");
		   report.reportPass("Logout Success");
	} catch (Exception e) {
		report.reportHardFail("Logout Success");
	}
	
   }
	@Override
	protected ExpectedCondition getPageLoadCondition() {

		return ExpectedConditions.visibilityOf(txt_UserName);
	}

}
