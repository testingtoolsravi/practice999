package com.tab.af.web.pages.OnBoarding;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.github.javafaker.Faker;
import com.tab.af.reporting.ExtentTestManager;
import com.tab.af.web.pages.BasePage;

public class ApplicationEditor extends BasePage {
	@FindBy(xpath = "//span[text()=\"Search\"]")
	private WebElement btn_Search;
	@FindBy(xpath = "//span[text()=\"Application process\"]")
	private WebElement lbl_ApplicationProcess;
	@FindBy(xpath = "//span[text()='Create']")
	private WebElement btn_Create;
	@FindBy(xpath = "//span[text()='System Information']")
	private WebElement lbl_SystemInfomation;
	@FindBy(xpath = "(//div[text()='ID']//following::div)[1]")
	private WebElement lbl_ApplicantID;
	@FindBy(xpath = "//div[@class=\"v-window-closebox\"]")
	private WebElement btn_ClosePopup;
	@FindBy(xpath = "//span[text()='Decline']//..//parent::div")
	private WebElement btn_Decline;
	@FindBy(xpath = "//span[text()='Start Process']//..//parent::div")
	private WebElement btn_StartProcess;
	@FindBy(xpath = "//h1[text()='Process was successfully started']")
	private WebElement lbl_ProcessStartedSuccessfully;
	@FindBy(xpath = "//div[text()='Decline Application']")
	private WebElement lbl_DeclineApplication;
	@FindBy(xpath = "//span[text()='Reason']//following::input[1]")
	private WebElement lbl_DeclineReasonOne;
	@FindBy(xpath = "//textarea[@cuba-id=\"declineReasonTextArea\"]")
	private WebElement txt_DeclineComment;
	@FindBy(xpath = "//span[text()='OK']")
	private WebElement btn_OK;
	@FindBy(xpath = "//h1[text()='Application was successfully declined']")
	private WebElement lbl_ApplicationSuccessfullyDenied;
	@FindBy(xpath = "//h1[text()='Application decline initialized']")
	private WebElement lbl_ApplicationDeclineInitialized;
	@FindBy(xpath = "//span[text()='Withdraw']//..//parent::div")
	private WebElement btn_Withdraw;
	@FindBy(xpath = "//div[text()='Withdraw Application']")
	private WebElement lbl_WithdrawApplication;
	@FindBy(xpath = "//span[text()='Reason']//following::input")
	private WebElement lbl_WithDrawReason;
	@FindBy(xpath = "//span[text()='Comment']//following::textarea")
	private WebElement txt_WithdrawComment;
	@FindBy(xpath = "//h1[text()='Application was successfully withdrawn']")
	private WebElement lbl_ApplicationSuccessfullyWithDrawn;

	@Override
	protected ExpectedCondition<?> getPageLoadCondition() {

		return ExpectedConditions.visibilityOf(btn_Search);

	}

	public void selectcreatedDepositApplication() {
		try {

			String fullName = getTestDataMap().get("FIRST NAME") + " " + getTestDataMap().get("LAST NAME");
			selectProduct(fullName);
			report.reportPass("Select Created Application");
		} catch (Exception e) {
			report.reportHardFail("Select Created Application Failed");
		}

	}

	public void selectcreatedLoanApplication() {
		try {

			String companyName = getTestDataMap().get("company_name").toString();
			selectProduct(companyName);
			report.reportPass("Select Created Application");
		} catch (Exception e) {
			report.reportHardFail("Select Created Application Failed");
		}

	}

	private void selectProduct(String companyName) throws Exception {
		WebElement application = webActions.findByText(companyName, "//td//div");
		webActions.clickBYJS(application, "Created Application");
		String product = getTestDataMap().get("SelectedProduct").toString();
		WebElement productName = webActions.findByText(product, "//td//div");
		addApplicationUUIDtoReport(productName);
	}

	public void addApplicationUUIDtoReport(WebElement productName) throws Exception {
		webActions.rightClickAction(productName, "Creater Application");
		webActions.waitAndCickBYJS(lbl_SystemInfomation, "System Information");
		webActions.waitUntilDisplayed(lbl_ApplicantID, "Applicant ID");
		String ID = lbl_ApplicantID.getText();
		webActions.clickBYJS(btn_ClosePopup, "Close popup");
		ExtentTestManager.getTest().info("Application UUID: " + ID);

	}

	public LoanTasks selectcreatedLoanApplicationFromPolymer() {
		try {
			webActions.waitUntilDisplayed(btn_Create, "Create button");
			Map<String, String> map = getTestDataMap();
			String companyName = map.get("company_name").toString();
			if (map.get("legalEntityType").equalsIgnoreCase("Sole proprietor")) {

				if (map.get("rep1_middlename").equals("")) {

					companyName = map.get("rep1_firstname").trim() + " " + map.get("rep1_lastname").trim();
				} else {
					companyName = map.get("rep1_firstname").trim() + " " + map.get("rep1_middlename").trim() + " "
							+ map.get("rep1_lastname").trim();
				}
			}
			webActions.waitAndCickBYJS(webActions.findByText(companyName, "//td//div"), "Company Name: " + companyName);
			openSelectedProduct("Commercial Small Ticket Equipment");
			report.reportPass("Select Created Application");
		} catch (Exception e) {
			report.reportHardFail("Select Created Application Failed");
		}
		return (LoanTasks) base(LoanTasks.class);

	}

	public DepositTasks selectcreatedDepositApplicationFromPolymer() {
		try {
			Map<String, String> map = getTestDataMap();
			String name = map.get("FIRST NAME") + " " + map.get("LAST NAME");
			String productFullName = map.get("productType") + " " + map.get("productName");
			webActions.clickBYJS(webActions.findByText(name, "//td//div"), "Applicant Name: " + name);
			openSelectedProduct(productFullName);
			report.reportPass("Select Created Application");
		} catch (Exception e) {
			report.reportHardFail("Select Created Application Failed");
		}
		return (DepositTasks) base(DepositTasks.class);

	}

	public DepositTasks openDepositProduct() {
		openCreatedProductUnderApplication();
		return (DepositTasks) base(DepositTasks.class);
	}

	public LoanTasks openLoanProduct() {
		openCreatedProductUnderApplication();
		return (LoanTasks) base(LoanTasks.class);
	}

	public void openCreatedProductUnderApplication() {
		try {
			String selectedProduct = (String) getTestDataMap().get("SelectedProduct");
			WebElement product = webActions.findByText(selectedProduct, "//td//div");
			webActions.waitUntilDisplayed(product, selectedProduct);
			webActions.doubleClick(product, selectedProduct);

			report.reportPass("Select Product: " + selectedProduct + " Associated with Created Application");
		} catch (Exception e) {
			report.reportHardFail("Select Product: Associated with Created Application Failed");
		}
	}

	public void startProcessFromHomePage() {
		try {
			String selectedProduct = (String) getTestDataMap().get("SelectedProduct");
			WebElement product = webActions.findByText(selectedProduct, "//td//div");
			webActions.waitForStalenessOf(product, selectedProduct);
			expandAndFocusCreatedDepositApplicationProduct();
			webActions.waitUntilEnabledCubaButton(btn_StartProcess, "Start process");
			webActions.clickBYJS(btn_StartProcess, "Start process");
			webActions.waitUntilDisplayed(lbl_ProcessStartedSuccessfully, "Process SuccessFully Started");
			report.reportPass("Start Process From HomePage for Created Application");
		} catch (Exception e) {
			report.reportHardFail("Start Process From HomePage for Created Application");
		}
	}

	private void openSelectedProduct(String selectedProduct) {
		try {

			WebElement product = webActions.findByText(selectedProduct, "//td//div");
			webActions.waitUntilDisplayed(product, selectedProduct);
			webActions.doubleClick(product, selectedProduct);

			report.reportPass("Select Product: " + selectedProduct + " Associated with Created Application");
		} catch (Exception e) {
			report.reportHardFail("Select Product: Associated with Created Application Failed");
		}
	}

	public void declineDepositApplication() {
		try {
			expandAndFocusCreatedDepositApplicationProduct();
			webActions.waitUntilEnabledCubaButton(btn_Decline, "Decline");
			webActions.clickBYJS(btn_Decline, "Decline");
			webActions.waitUntilDisplayed(lbl_DeclineApplication, "Decline Application");
			webActions.clickBYJS(lbl_DeclineReasonOne, "Decline Reason Checkbox one");
			webActions.sendKeysByChar(txt_DeclineComment, Faker.instance().lorem().characters(10), "Decline Comment");
			webActions.clickBYJS(btn_OK, "OK");
			webActions.waitUntilNotPresent(btn_OK, "OK");
			webActions.waitUntilDisplayed(lbl_ApplicationSuccessfullyDenied, "Application Denied Successfully");
			report.reportPass("Decline Application for  product Associated with Created Application");
		} catch (Exception e) {
			report.reportHardFail("Decline Application for product Associated with Created Application");
		}
	}

	public void declineLoanApplication() {
		try {
			expandAndFocusCreatedLoanApplicationProduct();
			webActions.waitUntilEnabledCubaButton(btn_Decline, "Decline");
			webActions.clickBYJS(btn_Decline, "Decline");

			webActions.waitUntilDisplayed(lbl_ApplicationDeclineInitialized, "Application Decline Initialized");
			report.reportPass("Decline Application for  product Associated with Created Application");
		} catch (Exception e) {
			report.reportHardFail("Decline Application for product Associated with Created Application");
		}
	}

	public void withDrawDepositApplication() {
		try {
			expandAndFocusCreatedDepositApplicationProduct();
			withdrawApplication();
			report.reportPass("WithDraw Application for  product Associated with Created Deposit Application");
		} catch (Exception e) {
			report.reportHardFail("WithDraw Application for product Associated with Created Deposit Application");
		}
	}

	public void withDrawLoanApplication() {
		try {
			expandAndFocusCreatedLoanApplicationProduct();
			withdrawApplication();
			report.reportPass("WithDraw Application for  product Associated with Created  Loan Application");
		} catch (Exception e) {
			report.reportHardFail("WithDraw Application for product Associated with Created Loan Application");
		}
	}

	private void withdrawApplication() throws Exception {
		webActions.waitUntilEnabledCubaButton(btn_Withdraw, "WithDraw");
		webActions.clickBYJS(btn_Withdraw, "WithDraw");
		webActions.waitUntilDisplayed(lbl_WithdrawApplication, "withdraw Application");
		webActions.SendKeysByCharAuto(lbl_WithDrawReason, "Other", "withdraw Reason");
		webActions.sendKeysByChar(txt_WithdrawComment, Faker.instance().lorem().characters(5), "Withdraw Comment");
		webActions.clickBYJS(btn_OK, "OK");
		webActions.waitUntilNotPresent(btn_OK, "OK");
		webActions.waitUntilDisplayed(lbl_ApplicationSuccessfullyWithDrawn, "Application Withdrawn Successfully");
	}

	public void expandAndFocusCreatedDepositApplicationProduct() {
		expandDepositApplicant();
		focusOnCreatedProduct();

	}

	public void expandAndFocusCreatedLoanApplicationProduct() {
		expandLoanApplicant();
		focusOnCreatedProduct();

	}

	public void expandDepositApplicant() {
		try {
			Map<String, String> map = getTestDataMap();
			  webActions.waitForLoadingToComplete();
			String name = map.get("FIRST NAME") + " " + map.get("LAST NAME");
			WebElement applicant=webActions.findByText(name, "//td//div");
			webActions.waitAndCickBYJS(applicant, "Applicant Name: " + name);
			report.reportPass("Expand Applicant");
		} catch (Exception e) {
			report.reportHardFail("Expand Applicant");
		}
	}

	public void expandLoanApplicant() {
		try {
               webActions.waitForLoadingToComplete();
			String companyName = getTestDataMap().get("company_name").toString();
			WebElement applicant=webActions.findByText(companyName, "//td//div");
			webActions.waitAndCickBYJS(applicant, "Applicant Name: " + companyName);
			report.reportPass("Expand Applicant");
		} catch (Exception e) {
			report.reportHardFail("Expand Applicant");
		}
	}

	public void focusOnCreatedProduct() {
		try {
			Map<String, String> map = getTestDataMap();
			String selectedProduct = map.get("SelectedProduct");
			WebElement product = webActions.findByText(selectedProduct, "//td//div");
			webActions.waitUntilDisplayed(product, selectedProduct);
			webActions.clickAction(product, selectedProduct);
			report.reportPass("Focus on Created Product");
		} catch (Exception e) {
			report.reportHardFail("Focus on Created Product");
		}
	}
}
