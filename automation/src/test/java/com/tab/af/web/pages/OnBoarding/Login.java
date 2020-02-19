package com.tab.af.web.pages.OnBoarding;

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

	@FindBy(xpath = "//div[@cuba-id=\"WebGroupBox\"]//following::textarea[@cuba-id=\"WebResizableTextArea\"]")
	private List<WebElement> lbl_QuestionList;

	public Login() {
		PageFactory.initElements(driver, this);
	}

	public ApplicationsHome loginToApplication() {
		try {
			String env = TestBase.props.getProperty("onboarding.env");
			String URL = "";
			if (env.equals("acpt")) {
				URL = TestBase.props.getProperty("onboarding.acpt.url");
				webActions.loadURL(URL);

			} else if (env.equals("int")) {
				URL = TestBase.props.getProperty("onboarding.int.url");
				webActions.loadURL(URL);
			} else {
				throw new Exception("Environment not Specified");
			}
			base(Login.class);
			webActions.waitUntilDisplayed(txt_UserName, "UserName");
			TestBase.props.put("build.version", global.getBuildVersionFromSource(webActions.getPageSource()));
			String userName = TestBase.props.getProperty("user.name");
			String password = TestBase.props.getProperty("user.password");
			webActions.sendKeys(txt_UserName, userName, "UserName");
			webActions.sendKeys(txt_Password, password, "Password");
			webActions.clickBYJS(btn_Login, "Login button");
			report.reportPass("Login Success");
			return (ApplicationsHome) base(ApplicationsHome.class);
		} catch (Exception e) {
			report.reportHardFail("Login With Valid Credentials");
		}
		return (ApplicationsHome) base(ApplicationsHome.class);
	}

	public void loginAs(String userName, String password) {
		try {
			webActions.waitUntilDisplayed(txt_UserName, "UserName");
			webActions.sendKeys(txt_UserName, userName, "UserName");
			webActions.sendKeys(txt_Password, password, "Password");
			webActions.clickBYJS(btn_Login, "Login button");
			report.reportPass("Login Success");

		} catch (Exception e) {
			report.reportHardFail("Login With Valid Credentials");
		}
	}

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		return ExpectedConditions.visibilityOf(txt_UserName);

	}

}
