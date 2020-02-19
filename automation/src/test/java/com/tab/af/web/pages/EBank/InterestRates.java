package com.tab.af.web.pages.EBank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.joda.time.DateTime;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.github.javafaker.Faker;
import com.tab.af.web.pages.BasePage;

import junit.framework.Assert;

public class InterestRates extends BasePage {
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
	@FindBy(xpath = "//span[text()='OK']")
	private WebElement btn_Ok;
	@FindBy(xpath = "//span[text()='Edit']//parent::span//parent::div[@role=\"button\"]")
	private WebElement btn_Edit;
	@FindBy(xpath = "(//div[@class=\"v-splitpanel-first-container v-scrollable\"]//div)[1]")
	private WebElement lbl_InterstRatesTable;
	@FindBy(xpath = "//div[@class=\"v-splitpanel-second-container v-scrollable\"]//div[contains(@class,'v-gridlayout v-layout')]")
	private WebElement lbl_InterstRatesEditor;
	@FindBy(xpath = "//div[text()='Product']//following::input[1]")
	private WebElement txt_Product;
	@FindBy(xpath = "//div[text()='Sort Order']//following::input[1]")
	private WebElement txt_SortOrder;
	@FindBy(xpath = "(//div[text()='Rate Status']//following::input[1])[2]")
	private WebElement txt_RateStatus;
	@FindBy(xpath = "(//div[text()='Effective Date']//following::input[1])[2]")
	private WebElement txt_EffectiveDate;
	@FindBy(xpath = "//div[text()='Rate Tier 1']//following::input[1]")
	private WebElement txt_RateTier1Balance;
	@FindBy(xpath = "//div[text()='Rate Tier 1']//following::input[2]")
	private WebElement txt_RateTier2Interest;
	@FindBy(xpath = "//div[text()='Rate Tier 1']//following::input[3]")
	private WebElement txt_RateTier3Interest;
	@FindBy(xpath = "//p[text()='Interest Rates must be created with Pending status']")
	private WebElement lbl_InterestCannotBeActiveWarning;
	@FindBy(xpath = "//p[text()='Interest Rates must set active by a different user than the creator.']")
	private WebElement lbl_InterestMustBeSetbyOtherUserWarning;
	@FindBy(xpath = "//div[text()='Product desc'][1]//following::tr//td[3]")
	private List<WebElement> lbl_ProductDescList;
	@FindBy(xpath = "//tr[contains(@class,'v-table-row')]//td[1]//div")
	private List<WebElement> lbl_TableRows;

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(lbl_InterestRatesTab);
	}
	public void validatePageOptions() {
		try {
			webActions.assertDisplayed(btn_Search, "Search button");
			webActions.assertDisplayed(btn_AddSearchConditon, "Add Search Condition button");
			webActions.assertDisplayed(btn_Create, "Create button");
			webActions.assertDisplayed(btn_Edit, "Edit button");
			report.reportPass("Validate Interest Rates Page options");
		} catch (Exception e) {
			report.reportHardFail("Validate Interest Rates Page options");
		}
	}
	public void createInterestRate(String productType, String sortOrder, String rateStatus, String interest,
			String apy) {
		try {
			webActions.clickBYJS(btn_Create, "Create");
			webActions.waitUntilEnabled(txt_Product, "Product");
			webActions.waitAndSendKeysByCharAuto(txt_Product, productType, "Product");
			webActions.sendKeysByChar(txt_SortOrder, sortOrder, "Sort Order");
			webActions.SendKeysByCharAuto(txt_RateStatus, rateStatus, "Rate Status");
			webActions.sendKeysByChar(txt_EffectiveDate, Keys.HOME + DateTime.now().toString("MM/dd/yyyy"),
					"Effective Date");
			String balance = Faker.instance().random().nextInt(500, 1500).toString();
			Map m = new HashMap<String, String>();
			m.put("balance", balance);
			setTestDataMap(m);
			webActions.sendKeysByChar(txt_RateTier1Balance, balance, "Balance");
			webActions.sendKeysByChar(txt_RateTier2Interest, interest, "Interest");
			webActions.sendKeysByChar(txt_RateTier3Interest, apy, "Apy");
			webActions.clickBYJS(btn_Ok, "OK");
			report.reportPass("Create Interest Rate");
		} catch (Exception e) {
			report.reportHardFail("Create Interest Rate");
		}
	}

	public void interestStatePendingWarning() {
		try {

			webActions.waitUntilDisplayed(lbl_InterestCannotBeActiveWarning,
					"Interest Rates must be created with Pending status");

			report.reportPass("Interest Rates must be created with Pending status warning");
		} catch (Exception e) {
			report.reportHardFail("Interest Rates must be created with Pending status warning");
		}
	}

	public void interestMustbeChangedByOtherUserWarning() {
		try {

			webActions.waitUntilDisplayed(lbl_InterestMustBeSetbyOtherUserWarning,
					"Interest Rates must be changed by Other user");
			webActions.clickBYJS(btn_Cancel, "Cancel");
			report.reportPass("Interest Rates must be changed by Other user warning");
		} catch (Exception e) {
			report.reportHardFail("Interest Rates must be changed by Other user warning");
		}
	}

	public void changeRateStatusandSave(String rateStatus) {
		try {
			Thread.sleep(10000);
			if (!txt_RateStatus.isEnabled()) {
				webActions.waitUntilEnabledCubaButton(btn_Edit, "Edit Button");
				webActions.waitUntilClassEnabled(btn_Edit, "Edit Button");
				
				webActions.clickBYJS(btn_Edit, "Edit Button");
				
			 
			}

			webActions.waitUntilEnabledCubaTBox(txt_RateStatus, "Rate Status");
			webActions.clearByJS(txt_RateStatus, "Rate Status");
			webActions.SendKeysByCharAuto(txt_RateStatus, rateStatus, "Rate Status"); 
			webActions.clickBYJS(btn_Ok, "OK");
			report.reportPass("Change Rate Status");
		} catch (Exception e) {
			report.reportHardFail("Change Rate Status");
		}
	}

	public void updateEffectiveDateandSave(String newDate) {
		try {

			webActions.waitUntilEnabledCubaButton(btn_Edit, "Edit Button");
			webActions.clickBYJS(btn_Edit, "Edit Button");
			webActions.waitUntilEnabledCubaTBox(txt_EffectiveDate, "Effective Date");
			webActions.clearByJS(txt_EffectiveDate, "Effective Date");
			webActions.sendKeysByChar(txt_EffectiveDate, newDate, "Effective date");
			webActions.waitUntilDisplayed(txt_EffectiveDate, "Effective Date");

			webActions.clickBYJS(btn_Ok, "OK");
			report.reportPass("update Effective Date");
		} catch (Exception e) {
			report.reportHardFail("update Effective Date");
		}
	}

	public void validateDateUpdated(String newDate) {
		try {
			Assert.assertEquals(newDate, txt_EffectiveDate.getAttribute("value"));
			report.reportPass("Effective Date updated");
		} catch (Exception e) {
			report.reportHardFail("Effective Date updated");
		}
	}

	public void validateSearch(String conditon, String name) {
		try {

			addSearchCondtion(conditon, name);
			Thread.sleep(5000);
			for (WebElement desc : lbl_ProductDescList) {
				if (!desc.getText().equalsIgnoreCase("Product desc") && !desc.getText().equals("")) {

					if (!desc.getText().equals(name)) {
						throw new Exception("Search failed");
					}
				}
			}
			report.reportPass("Validate Search");
		} catch (Exception e) {
			report.reportHardFail("Validate Search");
		}
	}

	public void selectInterestRateByBalance() {
		try {
			int rowNum = 1;
			boolean found = true;
			int time = 10;
			for (WebElement webElement : lbl_TableRows) {
				webActions.clickAction(webElement, "Table Row " + rowNum);
				do {
					WebElement row = webElement.findElement(By.xpath("../.."));
					Thread.sleep(1000);
					time--;
					if (row.getAttribute("class").toString().contains("v-selected")) {
						break;
					}
				} while (time > 0);

				rowNum++;
				String balance = (String) getTestDataMap().get("balance");
				if (txt_RateTier1Balance.getAttribute("value").replace(",", "").equalsIgnoreCase(balance)) {

					found = false;
					break;
				}

			}
			if (found) {
				throw new Exception("Select Create interest Failed");
			}
			webActions.waitForElementToBeDisabled(txt_RateStatus, "Rate Status");
			report.reportPass("Select Create interest");
		} catch (Exception e) {
			report.reportHardFail("Select Create interest");
		}

	}

	public void verifyStatusUpdated(String Expected) {
		try {
			Assert.assertEquals(Expected, txt_RateStatus.getAttribute("value").equalsIgnoreCase(Expected));
			report.reportPass("Rate Status updated succesfully");
		} catch (Exception e) {
			report.reportHardFail("Rate Status updated succesfully");
		}
	}

	public void addSearchCondtion(String conditionName, String value) {
		try {
			webActions.waitAndCickBYJS(btn_AddSearchConditon, "Add Search condition");
			WebElement element = webActions.findByText(conditionName, "//span");
			webActions.doubleClick(element, conditionName);
			webActions.waitAndSendKeysByChar(txt_SearchFilter, value, "Search filter Input");
			webActions.clickBYJS(btn_Search, "Filter Search");
			report.reportPass("Add Search Condtion:" + conditionName);
		} catch (Exception e) {
			report.reportHardFail("Add Search Condtion:" + conditionName);
		}

	}
}
