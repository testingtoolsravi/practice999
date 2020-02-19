package com.tab.af.web.pages.EPrecision;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.tab.af.web.pages.BasePage;

public class HomePage extends BasePage {
	@FindBy(xpath = "//span[text()='Sonic']//following::span[@class=\"v-menubar-submenu-indicator-icon\"][1]//span")
	private WebElement lbl_Sonic;
	@FindBy(xpath = "//span[text()='First Data']")
	private WebElement lbl_FirstData;
	@FindBy(xpath = "//span[text()='Process Errors']")
	private WebElement lbl_ProcessErrors;
	@FindBy(xpath = "//span[text()='End Of Day Jobs']")
	private WebElement lbl_EndOfDayJobJobs;
	@FindBy(xpath = "//span[text()='Precision']")
	private WebElement lbl_Precision;
	@FindBy(xpath = "//span[text()='Administration']")
	private WebElement lbl_Administration;
	@FindBy(xpath = "//span[text()='Help']")
	private WebElement lbl_Help;
	@FindBy(xpath = "//span[text()='Object']//following::span[@class=\"v-menubar-submenu-indicator-icon\"][1]//span")
	private WebElement lbl_Object;
	@FindBy(xpath = "//span[text()='Cif Entity']")
	private WebElement lbl_CifEntity;
	@FindBy(xpath = "//span[text()='Ping']")
	private WebElement lbl_Ping;
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		 
		return ExpectedConditions.visibilityOf(lbl_FirstData);
	}

	public ProcessErrors navigateToProcessErros() {
		try {
			webActions.clickAction(lbl_FirstData, "lbl_FirstData");
			webActions.clickAction(lbl_ProcessErrors, "Process Errors");
			report.reportPass("Process Errors");
		} catch (Exception e) {
			report.reportHardFail("Process Errors");
		}
		return (ProcessErrors) base(ProcessErrors.class);
	}

	public EndOfDayJobs navigateToEndOfDayJobs() {
		try {
			webActions.clickAction(lbl_FirstData, "lbl_FirstData");
			webActions.clickAction(lbl_EndOfDayJobJobs, "Process Errors"); 
			report.reportPass("End Of Day Jobs");
		} catch (Exception e) {
			report.reportHardFail("End Of Day Jobs");
		}
		return (EndOfDayJobs) base(EndOfDayJobs.class);
	}
	public Precision navigateToPrecisionOptions() {
		try {
			webActions.clickAction(lbl_Precision, "Precision");
			report.reportPass("Precision");
		} catch (Exception e) {
			report.reportHardFail("Precision");
		}
		return (Precision) base(Precision.class);
	}
	public CifEntity navigateToCifEntity() {
		try {
			 
		 
		 
			webActions.clickAction(lbl_Precision, "Precision");
			
			webActions.clickAction(lbl_Sonic, "Sonic");
		 
			webActions.clickAction(lbl_Object, "Object");
			 
			 
			webActions.clickAction(lbl_CifEntity, "CIF Entity");
			report.reportPass("CIF Entity");
		} catch (Exception e) {
			report.reportHardFail("CIF Entity");
		}
		return (CifEntity) base(CifEntity.class);
	}
	public Ping navigateToPingSystem() {
		try {
			   
			webActions.clickAction(lbl_Precision, "Precision");
			webActions.clickAction(lbl_Ping, "Ping"); 
			report.reportPass("CIF Entity");
		} catch (Exception e) {
			report.reportHardFail("CIF Entity");
		}
		return (Ping) base(Ping.class);
	}
	public void assertPage() {
		try {
			 
			webActions.assertDisplayed(lbl_FirstData, "First Data"); 
			report.reportPass("Assert Home Page");
		} catch (Exception e) {
			report.reportHardFail("Assert Home Page");
		}
		 
	}
	public void assertHomePageOptions() {
		try {
			 
			webActions.assertDisplayed(lbl_FirstData, "First Data"); 
			webActions.assertDisplayed(lbl_Administration, "Administration");
			webActions.assertDisplayed(lbl_Precision, "First Data");
			webActions.assertDisplayed(lbl_Help, "Help");
			report.reportPass("Assert Home Page");
		} catch (Exception e) {
			report.reportHardFail("Assert Home Page");
		}
		 
	}
	public void clickPrecisionOption() {
		try {
			 
			webActions.clickAction(lbl_Precision, "Precision Option");
			report.reportPass("Click Precision Option");
		} catch (Exception e) {
			report.reportHardFail("Assert Home PageClick Precision Option");
		}
		 
	}
	
	public void validatePrecisionTabOption() {
		try {
			 
			webActions.assertDisplayed(lbl_Sonic, "Sonic Option");
			webActions.assertDisplayed(lbl_Ping, "Ping Option");
			report.reportPass("Precision Tab Option");
		} catch (Exception e) {
			report.reportHardFail("Precision Tab Option");
		}
		 
	}
}
