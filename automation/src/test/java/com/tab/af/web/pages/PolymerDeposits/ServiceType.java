package com.tab.af.web.pages.PolymerDeposits;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.tab.af.testbase.TestBase;
import com.tab.af.web.pages.BasePage;

public class ServiceType extends BasePage {
	@FindBy(xpath = "//body")
	private WebElement page;
	String header = "home-view[name='resume']>div>h3";
	String btn_Personal = "h4[class='personal-label']";
	String btn_Business = "h4[class='business-label']";

	@Override
	protected ExpectedCondition getPageLoadCondition() {

		return ExpectedConditions.visibilityOf(page);
	}

	public ServiceType() {

		PageFactory.initElements(driver, this);
	}

	public void loadUserData() {
		try {
			
			
			setTestDataMap(json.getDepositMap());
		} catch (Exception e) {
			report.reportHardFail(e.getMessage());
		}

	}

	public void validateHomePage() {
		try {
		 	webActions.loadURL(TestBase.props.getProperty("da.int.url"));
			 
			String headerText = shadow.getText(header, "Homepage Header");
			Assert.assertEquals("What type of services are you looking for?", headerText);

			report.reportPass("Assert HomePage");
		} catch (Exception e) {
			report.reportHardFail("Assert HomePage");
		}
	}

	public ProductSelection selectServiceType(String service) {

		try {
			if (service.equalsIgnoreCase("Personal")) {
				getTestDataMap().put("productType", "Consumer");
				shadow.click(btn_Personal, "Service Type as Personal");
			} else if (service.equalsIgnoreCase("Business")) {
				getTestDataMap().put("productType", "Commercial");
				shadow.click(btn_Business, "Service Type as Business");
			}

			report.reportPass("Select Service type as " + service);
		} catch (Exception e) {
			report.reportHardFail("Select Service type as " + service);
		}

		return (ProductSelection) base(ProductSelection.class);
	}

}
