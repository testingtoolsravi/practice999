package com.tab.af.web.pages.EBank;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.github.javafaker.Faker;
import com.tab.af.web.pages.BasePage;

public class JournalBatch extends BasePage {
	@FindBy(xpath = "//div[text()='Journal Batch']")
	private WebElement lbl_JournalBatch;
	@FindBy(xpath = "//span[text()='=']//following::input[1]")
	private WebElement txt_SearchFilter;
	@FindBy(xpath = "//span[text()='Add search condition']")
	private WebElement btn_AddSearchConditon;
	@FindBy(xpath = "//span[text()='Search']")
	private WebElement btn_Search;
	@FindBy(xpath = "//div[text()='Interest Rates']")
	private WebElement lbl_InterestRatesTab;
	@FindBy(xpath = "//span[text()='Create']")
	private WebElement btn_Create;
	@FindBy(xpath = "//span[text()='Cancel']")
	private WebElement btn_Cancel;
	@FindBy(xpath = "//span[text()='Create Template']")
	private WebElement btn_CreateTemplate;
	@FindBy(xpath = "//span[text()='OK']")
	private WebElement btn_Ok;
	@FindBy(xpath = "//div[text()='Template Name']//following::input[1]")
	private WebElement txt_TemplateName;
	@FindBy(xpath = "//div[text()='Screen']//following::div[text()='Description']//following::input[1]")
	private WebElement txt_TemplateDescripiton;
	@FindBy(xpath = "//tbody/tr//td[contains(@class,'table-header-')]")
	private List<WebElement> tbl_JournalIemsheader;
	@FindBy(xpath = "//span[text()='Submit']")
	private WebElement btn_Submit;
	@FindBy(xpath = "//span[text()='Add']")
	private WebElement btn_Add;

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(lbl_JournalBatch);
	}

	public void createBatch() {
		try {
			webActions.clickBYJS(btn_Create, "Create");
			webActions.waitAndCickBYJS(btn_CreateTemplate, "Create Template");
			webActions.sendKeysByChar(txt_TemplateName, Faker.instance().lorem().characters(6), "Template Name");
			webActions.sendKeysByChar(txt_TemplateDescripiton, Faker.instance().lorem().characters(6),
					"Template Description");
			webActions.clickBYJS(btn_Ok, "OK");
			webActions.waitUntilNotPresent(btn_Ok, "OK");
			Map<String, Integer> cKey = webActions.getColumnIndexMap(tbl_JournalIemsheader);
			for (int i = 1; i <= 2; i++) {
				webActions.clickBYJS(btn_Add, "Add Button");
				webActions.waitForJSandJQueryToLoad();
				webActions.waitAndSendKeysByCharAuto(webActions.getRowElement(cKey, i, "Account"), "500106938001",
						"Account Row " + i + " ");
				webActions.SendKeysByCharAuto(webActions.getRowElement(cKey, i, "Selector"), "500 - Opening Advance",
						"Selector Row " + i + " ");
				webActions.SendKeysByCharAuto(webActions.getRowElement(cKey, i, "Amount"),
						Faker.instance().number().numberBetween(300, 500) + "", "Amount Row " + i + " ");
				webActions.SendKeysByCharAuto(webActions.getRowElement(cKey, i, "Description"),
						Faker.instance().lorem().characters(6), "Description Row " + i + " ");
				webActions.waitUntilValueisNotEmpty(webActions.getRowElement(cKey, 1, "Balance"),
						"Balance Row " + i + " ");

				webActions.clickBYJS(btn_Submit, "Submit");
			}
			report.reportPass("Create batch");
		} catch (Exception e) {
			report.reportHardFail("Create batch Fail");
		}
	}

}
