package com.tab.af.web.pages.OnBoarding;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.tab.af.web.pages.BasePage;
import com.tab.af.web.pages.EquipmentFinancing.BasicInformation;

public class EmailHistory extends BasePage {

	@FindBy(xpath = "//div[text()='Email History']")
	private WebElement lbl_EmailHistory;
	@FindBy(xpath = "//div[text()='Address']//following::input[1]")
	private WebElement txt_Address;
	@FindBy(xpath = "//span[text()='Show as HTML']")
	private WebElement btn_ShowasHTML;
	@FindBy(xpath = "//a[contains(text(),'LETS MAKE THIS HAPPEN!')]")
	private WebElement btn_LetsMakeThisHappen;
	@FindBy(xpath = "//td//div[text()='Last Attempt Time']")
	private WebElement th_LastAttemptTime;
	@FindBy(xpath = "//div[text()='Descending']")
	private WebElement lbl_Descending;
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(lbl_EmailHistory);
	}
	public BasicInformation selectEmail() {
		try {
			Map<String, String> map= getTestDataMap();
			webActions.rightClickAction(th_LastAttemptTime, "Last Attempt time");
			webActions.waitAndCickBYJS(lbl_Descending, "Descending Order by Last Attempt Time");
			String name= (String) getTestDataMap().get("company_name");
			if (map.get("legalEntityType").equalsIgnoreCase("Sole proprietor")) {
				 
				if (getApplicant("Applicant2").get("Middle").equals("")) {

					name = map.get("First Name").trim() + " " + map.get("Last Name").trim();
				} else {
					name = map.get("First Name").trim() + " " + map.get("Middle").trim() + " "
							+ map.get("Last Name").trim();
				}
			}
			
			webActions.clickAction(webActions.findByText(name, "//td//div"), "Email: " + name);
			webActions.waitForTextToBePresentInValue(txt_Address, "GGKDev@tabbank.com", "Address");
			webActions.clickBYJS(btn_ShowasHTML, "Show as HTML");
			webActions.switchToOtherOpenedWindow();
			webActions.clickBYJS(btn_LetsMakeThisHappen, "LETS MAKE THIS HAPPEN");
			
			report.reportPass("Select email");
		} catch (Exception e) {
			report.reportHardFail("Select Email");
		}
		return (BasicInformation)base(BasicInformation.class);
	}

}
