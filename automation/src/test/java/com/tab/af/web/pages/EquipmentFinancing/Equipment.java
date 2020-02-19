package com.tab.af.web.pages.EquipmentFinancing;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.tab.af.web.pages.BasePage;

public class Equipment extends BasePage {
	@FindBy(xpath = "//body")
	private WebElement page;
	String rBtn_EquipmentType = "radio-group[aria-invalid='true']>paper-radio-button[id='_option'][role='radio']";
	String txt_Year = "paper-input[id='year']";
	String txt_Make = "paper-input[id='make']";
	String txt_Model = "paper-input[id='model']";
	String txt_InvoiceAmount = "paper-input[id='salePrice']";
	String btn_Next = "paper-button[id='_nextButton']";
	
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		return ExpectedConditions.visibilityOf(page);
	}

	public Documents fillHaulingReference(String equipmentType, String year, String make, String model,
			String invoiceAmount) {
		try {
		 
			shadow.waitAndSendKeys(txt_Year, year, "Year");
			shadow.selectRadioButonByLabel(rBtn_EquipmentType, "Used", "Equipment Type");
			shadow.sendKeys(txt_Make, make, "Make"); 
			shadow.sendKeys(txt_Model, model, "Model");
			shadow.sendKeys(txt_InvoiceAmount, invoiceAmount, "Invoice Amount");
			shadow.click(btn_Next, "Next");
			report.reportPass("Fill Hauling Reference");
		} catch (Exception e) {
			report.reportHardFail("Fill Hauling Reference");
		}
		return (Documents) base(Documents.class);
	}
}
