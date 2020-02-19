package com.tab.af.web.pages.PolymerDeposits;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.tab.af.web.pages.BasePage;

public class ProductSelection extends BasePage {
	@FindBy(xpath = "//body")
	private WebElement page;
	String lbl_ProductTypes = "//h4[class='product-select-header']";
	String lst_ProductType = "div[id='productlineDiv']>paper-item[class='position-abs']";
	String btn_Business = "h4[class='business-label']";
	String btn_Select = ">div[class='mdl-card--border product-card-bottom justify-content-between']>a";
	String btn_OpenNow = "div[id='selectedProductsDiv']>selected-products>paper-button";
	String MonthCD3 = "div[id='card_CD_3_MON']";
	String MonthCD6 = "div[id='card_CD_6_MONTH']";
	String MonthCD9 = "div[id='card_CD9COM']";
	String MonthCD12 = "div[id='card_CD_12_MON']";
	String MonthCD18 = "div[id='card_CD_18_MONT']";
	String MonthCD24 = "div[id='card_CD_24']";
	String MonthCD36 = "div[id='card_CD_36_MON']";
	String MonthCD48 = "div[id='card_CD_48_MON']";
	String MonthCD60 = "div[id='card_CD_60_MON']";
	String tabChromeChecking = "div[id='card_CHROME_CH']";
	String highYieldChecking = "div[id='card_HYC']";
	String checking365 = "div[id='card_365_CHECK']";
	String kasasaCash = "div[id='card_KASASA_CAS']";
	String kasasaSaver = "div[id='card_KASASA_SAV']";
	String moneyMarketAccount = "div[id='card_MMA']";
	String highYieldSavings = "div[id='card_HYS']";
	String premiumSavings = "div[id='card_PREM_SAV']";
	String businessMonthCD3 = "div[id='card_BUS_CD_3M']";
	String businessMonthCD6 = "div[id='card_BUS_CD_6M']";
	String businessMonthCD9 = "div[id='card_BUS_CD_9M']";
	String businessMonthCD12 = "div[id='card_BUS_CD_12M']";
	String businessMonthCD18 = "div[id='card_BUS_CD_18M']";
	String businessMonthCD24 = "div[id='card_BUS_CD_24M']";
	String businessMonthCD36 = "div[id='card_BUS_CD_36M']";
	String businessMonthCD48 = "div[id='card_BUS_CD_48M']";
	String businessMonthCD60 = "div[id='card_BUS_CD_60M']";
	String analyzedBusinessChecking = "div[id='card_AN_BUS_CHE']";
	String businessAdvantagePrepaid = "div[id='card_BUS_ADVAN']";
	String businessChecking = "div[id='card_BUS_CHECK']";
	String businessmoneyMarket = "div[id='card_BUS_MMA']";
	String businessSavings = "div[id='card_BUS_SAVING']";

	@Override
	protected ExpectedCondition getPageLoadCondition() {

		return ExpectedConditions.visibilityOf(page);
	}

	public BasicInformation selectPersonalProduct(String productType, String productName) {

		try {

			shadow.waitUntilDisplayed(lst_ProductType, "Products List");
			List<WebElement> productTypesList = shadow.findElements(lst_ProductType);
			for (WebElement webElement : productTypesList) {
				if (webElement.getText().trim().contains(productType)) {
					webActions.click(webElement, "Product Type");
					break;
				}
			}
			if (productType.equalsIgnoreCase("Certificate of Deposit")) {
				selectPersonalCertificateOfDepositProduct(productName);
			} else if (productType.equalsIgnoreCase("Checking")) {
				selectPersonalCheckingProduct(productName);
			} else if (productType.equalsIgnoreCase("Money Market Account")) {
				selectPersonalMoneyMarketAccountProduct(productName);
			} else if (productType.equalsIgnoreCase("Savings")) {
				selectPersonalSavingsProduct(productName);
			}
			getTestDataMap().put("productName", productName);
			report.reportPass("Select Service type as " + productType + "and Product As " + productName);
		} catch (Exception e) {
			report.reportHardFail("Select Service type as " + productType + "and Product As " + productName);
		}

		return (BasicInformation) base(BasicInformation.class);
	}

	private void selectPersonalSavingsProduct(String productName) {
		try {
			String product = "div[id='productlineDiv']>" + personalSavingsLocator(productName);
			clickProduct(product, productName);
			report.reportPass("Select  COD Product As " + productName);
		} catch (Exception e) {
			report.reportHardFail("Select  COD Product As " + productName);
		}
	}

	private String personalSavingsLocator(String productName) {
		if (productName.equalsIgnoreCase("High Yield Savings")) {
			return highYieldSavings;
		} else if (productName.equalsIgnoreCase("Premium Savings")) {
			return premiumSavings;
		}

		return "";
	}

	private void selectPersonalMoneyMarketAccountProduct(String productName) {
		try {
			String product = "div[id='productlineDiv']>" + personalMoneyMarketLocator(productName);
			clickProduct(product, productName);
			report.reportPass("Select  COD Product As " + productName);
		} catch (Exception e) {
			report.reportHardFail("Select  COD Product As " + productName);
		}
	}

	private String personalMoneyMarketLocator(String productName) {
		if (productName.equalsIgnoreCase("Money Market Account")) {
			return moneyMarketAccount;
		}

		return "";
	}

	private void selectPersonalCertificateOfDepositProduct(String productName) {
		try {
			String product = "div[id='productlineDiv']>" + codPersonalLocator(productName);
			clickProduct(product, productName);
			report.reportPass("Select  COD Product As " + productName);
		} catch (Exception e) {
			report.reportHardFail("Select  COD Product As " + productName);
		}
	}

	private String codPersonalLocator(String productName) {
		if (productName.equalsIgnoreCase("3 Month CD")) {
			return MonthCD3;
		} else if (productName.equalsIgnoreCase("6 Month CD")) {
			return MonthCD6;
		} else if (productName.equalsIgnoreCase("9 Month CD")) {
			return MonthCD9;
		} else if (productName.equalsIgnoreCase("12 Month CD")) {
			return MonthCD12;
		} else if (productName.equalsIgnoreCase("18 Month CD")) {
			return MonthCD18;
		} else if (productName.equalsIgnoreCase("24 Month CD")) {
			return MonthCD24;
		} else if (productName.equalsIgnoreCase("36 Month CD")) {
			return MonthCD36;
		} else if (productName.equalsIgnoreCase("48 Month CD")) {
			return MonthCD48;
		} else if (productName.equalsIgnoreCase("60 Month CD")) {
			return MonthCD60;
		}
		return "";
	}

	private void selectPersonalCheckingProduct(String productName) {
		try {
			String product = "div[id='productlineDiv']>" + personalCheckingLocator(productName);
			clickProduct(product, productName);
			report.reportPass("Select  Checking Product As " + productName);
		} catch (Exception e) {
			report.reportHardFail("Select  Checking Product As " + productName);
		}
	}

	private String personalCheckingLocator(String productName) {
		if (productName.equalsIgnoreCase("TAB Chrome Checking")) {
			return tabChromeChecking;
		} else if (productName.equalsIgnoreCase("High Yield Checking")) {
			return highYieldChecking;
		} else if (productName.equalsIgnoreCase("365 Checking")) {
			return checking365;
		} else if (productName.equalsIgnoreCase("Kasasa Cash")) {
			return kasasaCash;
		} else if (productName.equalsIgnoreCase("Kasasa Saver")) {
			return kasasaSaver;
		}

		return "";
	}

	private void clickProduct(String product, String productName) throws Exception {
		WebElement element = shadow.waitAndfindElement(product, productName);
		webActions.waitUntilDisplayed(element, productName);

		shadow.click(product + btn_Select, productName);
		webActions.waitUntilEnabled(shadow.findElement(btn_OpenNow), "Open Now");
		webActions.clickBYJS(shadow.findElement(btn_OpenNow), "Open Now");
	}

	public BasicInformation selectBusinessProduct(String productType, String productName) {

		try {

			shadow.waitUntilDisplayed(lst_ProductType, "Products List");
			List<WebElement> productTypesList = shadow.findElements(lst_ProductType);
			for (WebElement webElement : productTypesList) {
				if (webElement.getText().trim().contains(productType)) {
					webActions.click(webElement, "Product Type");
					break;
				}
			}
			if (productType.equalsIgnoreCase("Certificate of Deposit")) {
				selectBusinessCertificateOfDepositProduct(productName);
			} else if (productType.equalsIgnoreCase("Checking")) {
				selectBusinessCheckingProduct(productName);
			} else if (productType.equalsIgnoreCase("Money Market Account")) {
				selectBusinessMoneyMarketAccountProduct(productName);
			} else if (productType.equalsIgnoreCase("Savings")) {
				selectBusinessSavingsProduct(productName);
			}
			getTestDataMap().put("productName", productName);
			report.reportPass("Select Service type as " + productType + "and Product As " + productName);
		} catch (Exception e) {
			report.reportHardFail("Select Service type as " + productType + "and Product As " + productName);
		}

		return (BasicInformation) base(BasicInformation.class);
	}

	private void selectBusinessCertificateOfDepositProduct(String productName) {
		try {
			String product = "div[id='productlineDiv']>" + codBusinessLocator(productName);
			clickProduct(product, productName);
			report.reportPass("Select  COD Product As " + productName);
		} catch (Exception e) {
			report.reportHardFail("Select  COD Product As " + productName);
		}
	}

	private String codBusinessLocator(String productName) {
		if (productName.equalsIgnoreCase("3 Month CD")) {
			return businessMonthCD3;
		} else if (productName.equalsIgnoreCase("6 Month CD")) {
			return businessMonthCD6;
		} else if (productName.equalsIgnoreCase("9 Month CD")) {
			return businessMonthCD9;
		} else if (productName.equalsIgnoreCase("12 Month CD")) {
			return businessMonthCD12;
		} else if (productName.equalsIgnoreCase("18 Month CD")) {
			return businessMonthCD18;
		} else if (productName.equalsIgnoreCase("24 Month CD")) {
			return businessMonthCD24;
		} else if (productName.equalsIgnoreCase("36 Month CD")) {
			return businessMonthCD36;
		} else if (productName.equalsIgnoreCase("48 Month CD")) {
			return businessMonthCD48;
		} else if (productName.equalsIgnoreCase("60 Month CD")) {
			return businessMonthCD60;
		}
		return "";
	}

	private void selectBusinessCheckingProduct(String productName) {
		try {
			String product = "div[id='productlineDiv']>" + businessCheckingLocator(productName);
			clickProduct(product, productName);
			report.reportPass("Select  Checking Product As " + productName);
		} catch (Exception e) {
			report.reportHardFail("Select  Checking Product As " + productName);
		}
	}

	private String businessCheckingLocator(String productName) {
		if (productName.equalsIgnoreCase("Analyzed Business Checking")) {
			return analyzedBusinessChecking;
		} else if (productName.equalsIgnoreCase("Business Advantage Prepaid")) {
			return businessAdvantagePrepaid;
		} else if (productName.equalsIgnoreCase("Business Checking")) {
			return businessChecking;
		}

		return "";
	}

	private void selectBusinessMoneyMarketAccountProduct(String productName) {
		try {
			String product = "div[id='productlineDiv']>" + businessMoneyMarketLocator(productName);
			clickProduct(product, productName);
			report.reportPass("Select  COD Product As " + productName);
		} catch (Exception e) {
			report.reportHardFail("Select  COD Product As " + productName);
		}
	}

	private String businessMoneyMarketLocator(String productName) {
		if (productName.equalsIgnoreCase("Money Market")) {
			return businessmoneyMarket;
		}

		return "";
	}

	private void selectBusinessSavingsProduct(String productName) {
		try {
			String product = "div[id='productlineDiv']>" + businessSavingsLocator(productName);
			clickProduct(product, productName);
			report.reportPass("Select  COD Product As " + productName);
		} catch (Exception e) {
			report.reportHardFail("Select  COD Product As " + productName);
		}
	}

	private String businessSavingsLocator(String productName) {
		if (productName.equalsIgnoreCase("Business Savings")) {
			return businessSavings;
		}

		return "";
	}
}
