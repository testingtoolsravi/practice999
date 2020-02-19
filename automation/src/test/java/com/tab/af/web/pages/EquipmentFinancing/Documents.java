package com.tab.af.web.pages.EquipmentFinancing;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.tab.af.web.pages.BasePage;

public class Documents extends BasePage {
	@FindBy(xpath = "//body")
	private WebElement page;
	String btn_UploadInvoice = "vaadin-upload[upload-type='Invoice']>input[id='fileInput']";
	String btn_VehicleSpecifications = "vaadin-upload[upload-type='Specifications']>input[id='fileInput']";
	String btn_DriversLicense = "vaadin-upload[upload-type='Driver License']>input[id='fileInput']";
	String btn_Other = "vaadin-upload[upload-type='Miscellaneous Funding Documents']>input[id='fileInput']"; 
	String samplePDF=System.getProperty("user.dir")+"//src//main//resources//PDFSample.pdf";

    String btn_Next = "paper-button[id='_nextButton']";
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		return ExpectedConditions.visibilityOf(page);
	}

	public Agreements uploadDocuments() {
		try {
			 
				shadow.waitAndSendKeys(btn_UploadInvoice, samplePDF, "Invoice Documents");
				shadow.sendKeys(btn_VehicleSpecifications, samplePDF, "Vehicle Specfications Document");
		    shadow.sendKeys(btn_DriversLicense, samplePDF, "Drivers License Document");
		    shadow.sendKeys(btn_Other, samplePDF, "Other Document");
			shadow.click(btn_Next, "Next");
			report.reportPass("Upload Documents");
		} catch (Exception e) {
			report.reportHardFail("Upload Documents");
		}
		return (Agreements) base(Agreements.class);
	}
}