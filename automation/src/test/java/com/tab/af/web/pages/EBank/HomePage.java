package com.tab.af.web.pages.EBank;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.tab.af.web.pages.BasePage;

import junit.framework.Assert;

public class HomePage extends BasePage {
	@FindBy(xpath = "//span[text()='Access Groups']")
	private WebElement lbl_AccessGroups;
	@FindBy(xpath = "//span[text()='Accounting']")
	private WebElement lbl_Accounting;
	@FindBy(xpath = "//span[text()='Journal Entry']")
	private WebElement lbl_JournalEntry;
	@FindBy(xpath = "//span[text()='Journal Batch']")
	private WebElement lbl_JournalBatch;
	@FindBy(xpath = "//span[text()='Batch Transaction History']")
	private WebElement lbl_BatchTransactionHistory;
	@FindBy(xpath = "//span[text()='Template Management']")
	private WebElement lbl_TemplateManagement;
	@FindBy(xpath = "//span[text()='Maintenance']")
	private WebElement lbl_Maintenance;
	@FindBy(xpath = "//span[text()='Interest Rates']")
	private WebElement lbl_InterestRates;
	@FindBy(xpath = "//span[text()='Entities']")
	private WebElement lbl_Entities;
	@FindBy(xpath = "//div[text()='Entities']")
	private WebElement lbl_EntitiesTabHeader;
	@FindBy(xpath = "//span[@class=\"v-menubar-menuitem-caption\"]")
	private List<WebElement> lbl_OptionsList;
	@FindBy(xpath = "//span[text()='BPM']")
	private WebElement lbl_BPM;
	@FindBy(xpath = "//span[text()='Reports']")
	private WebElement lbl_Reports;
	@FindBy(xpath = "//span[text()='Administration']")
	private WebElement lbl_Administration;
	@FindBy(xpath = "//span[text()='Help']")
	private WebElement lbl_Help;
	@FindBy(xpath = "//span[text()='Users']")
	private WebElement lbl_Users;
	@FindBy(xpath = "//span[text()='Roles']")
	private WebElement lbl_Roles;
	@FindBy(xpath = "//span[text()='Dynamic Attributes']")
	private WebElement lbl_DynamicAttributes;
	@FindBy(xpath = "//span[text()='User Sessions']")
	private WebElement lbl_UserSessions;
	@FindBy(xpath = "//span[text()='Locks']")
	private WebElement lbl_Locks;
	@FindBy(xpath = "//span[text()='External Files']")
	private WebElement lbl_ExternalFiles;
	@FindBy(xpath = "//span[text()='Email History']")
	private WebElement lbl_EmailHistory;
	@FindBy(xpath = "//span[text()='Scheduled Tasks']")
	private WebElement lbl_ScheduledTasks;
	@FindBy(xpath = "//span[text()='Restore Deleted Entities']")
	private WebElement lbl_RestoreDeletedEntities;
	@FindBy(xpath = "//span[text()='Entity Inspector']")
	private WebElement lbl_EntityInspector;
	@FindBy(xpath = "//span[text()='Application Properties']")
	private WebElement lbl_ApplicationProperties;
	@FindBy(xpath = "//span[text()='JMX Console']")
	private WebElement lbl_JMXConsole;
	@FindBy(xpath = "//span[text()='Entity Log']")
	private WebElement lbl_EntityLog;
	@FindBy(xpath = "//span[text()='Server Log']")
	private WebElement lbl_ServerLog;
	@FindBy(xpath = "//span[text()='Screen Profiler']")
	private WebElement lbl_ScreenProfiler;
	@FindBy(xpath = "//span[text()='Performance Statistics']")
	private WebElement lbl_PerformanceStatistics;
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		return ExpectedConditions.visibilityOf(lbl_Accounting);
	}

	public AccessGroups openAccessGroups() {
		try {

			webActions.WaitAndClickAction(lbl_Accounting, "Accounting tab");
			webActions.WaitAndClickAction(lbl_JournalEntry, "Journal Entry");
			webActions.WaitAndClickAction(lbl_AccessGroups, "Access Groups");

			report.reportPass("Open access Groups");
		} catch (Exception e) {
			report.reportHardFail("Open access Groups");
		}

		return (AccessGroups) base(AccessGroups.class);
	}

	public BatchTransactionHistory openBatchTransactionHistory() {
		try {
			webActions.WaitAndClickAction(lbl_Accounting, "Accounting tab");
			webActions.WaitAndClickAction(lbl_JournalEntry, "Journal Entry");
			webActions.WaitAndClickAction(lbl_BatchTransactionHistory, "Batch Transaction History");
			report.reportPass("Batch Transaction History");
		} catch (Exception e) {
			report.reportHardFail("Batch Transaction History");
		}
		return (BatchTransactionHistory) base(BatchTransactionHistory.class);
	}

	public JournalAccess openJournalAccess() {
		try {
			webActions.WaitAndClickAction(lbl_Accounting, "Accounting tab");
			webActions.WaitAndClickAction(lbl_JournalEntry, "Journal Entry");
			webActions.WaitAndClickAction(lbl_JournalBatch, "Journal Batch");
			report.reportPass("journal Access");
		} catch (Exception e) {
			report.reportHardFail("journal Access");
		}
		return (JournalAccess) base(JournalAccess.class);
	}

	public void verifyAvailableTabs() {
		try {
			Assert.assertEquals(6, lbl_OptionsList.size());

			report.reportPass("All Otions Displayed");

		} catch (Exception e) {
			report.reportHardFail("All Otions Displayed");
		}
	}

	public TemplateManagement openTemplateManagement() {
		try {
			webActions.WaitAndClickAction(lbl_Accounting, "Accounting tab");
			webActions.WaitAndClickAction(lbl_JournalEntry, "Journal Entry");
			webActions.WaitAndClickAction(lbl_TemplateManagement, "Template Management");
			report.reportPass(" Template Management");
		} catch (Exception e) {
			report.reportHardFail(" Template Management");
		}
		return (TemplateManagement) base(TemplateManagement.class);
	}

	public InterestRates openInterestRates() {
		try {
			webActions.WaitAndClickAction(lbl_Maintenance, "Open Interest Rates");
			webActions.WaitAndClickAction(lbl_InterestRates, "Interest Rates");

			report.reportPass("Open Interest Rates");
		} catch (Exception e) {
			report.reportHardFail("Open Interest Rates");
		}

		return (InterestRates) base(InterestRates.class);
	}

	public void validateAdminHomePageTabs() {
		try {
			webActions.assertDisplayed(lbl_BPM, "BPM");
			webActions.assertDisplayed(lbl_Reports, "Reports");
			webActions.assertDisplayed(lbl_Accounting, "Accounting");
			webActions.assertDisplayed(lbl_Maintenance, "Maintenance");
			webActions.assertDisplayed(lbl_Administration, "Administration");
			webActions.assertDisplayed(lbl_Help, "Help");
			report.reportPass("Validate EBank HomePage Tabs");
		} catch (Exception e) {
			report.reportHardFail("Validate EBank HomePage Tabs");
		}

	}

	public void openAccounting() {
		try {

			webActions.WaitAndClickAction(lbl_Accounting, "Accounting");
			report.reportPass("Open Accounting");
		} catch (Exception e) {
			report.reportHardFail("Open Accounting");
		}
	}

	public void openJournalEntry() {
		try {

			webActions.WaitAndClickAction(lbl_JournalEntry, "Journal Entry");
			report.reportPass("Journal Entry");
		} catch (Exception e) {
			report.reportHardFail("Journal Entry");
		}
	}
	
	public void validateJournalEntryOptions() {
		try {

			webActions.assertDisplayed(lbl_AccessGroups, "Access Groups");
			webActions.assertDisplayed(lbl_JournalBatch, "Journal Batch");
			webActions.assertDisplayed(lbl_TemplateManagement, "Template Management");
			webActions.assertDisplayed(lbl_BatchTransactionHistory, "Batch Transaction History"); 
			report.reportPass("Journal Entry Options");
		} catch (Exception e) {
			report.reportHardFail("Journal Entry Options");
		}
	}
	public void openMaintenance() {
		try {

			webActions.clickAction(lbl_Maintenance, "Maintenance");
			report.reportPass("Maintenance");
		} catch (Exception e) {
			report.reportHardFail("Maintenance");
		}
	}
	public void validateMaintenanceOptions() {
		try {

			webActions.assertDisplayed(lbl_InterestRates, "Interest Rates");
			webActions.assertDisplayed(lbl_Entities, "Entities"); 
			report.reportPass("Maintenenace Options");
		} catch (Exception e) {
			report.reportHardFail("Maintenenace Options");
		}
	}
	public void openEntities() {
		try {
			webActions.clickAction(lbl_Maintenance, "Maintenance");
			webActions.clickAction(lbl_Entities, "Entities");
			report.reportPass("Entities");
		} catch (Exception e) {
			report.reportHardFail("Entities");
		}
	}
	public void validateEntitiesPageLoaded() {
		try {
              webActions.waitForJSandJQueryToLoad();
			webActions.assertDisplayed(lbl_EntitiesTabHeader, "Entities Tab Header");
			report.reportPass("Entities Tab Header");
		} catch (Exception e) {
			report.reportHardFail("Entities Tab Header");
		}
	}
	public void clickAdministrationTab() {
		try {
			webActions.clickAction(lbl_Administration, "Administration"); 
			report.reportPass("Administration Tab");
		} catch (Exception e) {
			report.reportHardFail("Administration Tab");
		}
	}
	
	public void validateAdministrationTabOptions() {
		try {

			webActions.assertDisplayed(lbl_Users, "users");
			webActions.assertDisplayed(lbl_AccessGroups, "Access Groups"); 
			webActions.assertDisplayed(lbl_Roles, "Roles");
			webActions.assertDisplayed(lbl_DynamicAttributes, "Dynamic Attribute");
			webActions.assertDisplayed(lbl_UserSessions, "User Sessions");
			webActions.assertDisplayed(lbl_Locks, "Locks");
			webActions.assertDisplayed(lbl_ExternalFiles, "External Files");
			webActions.assertDisplayed(lbl_EmailHistory, "Email History");
			webActions.assertDisplayed(lbl_ScheduledTasks, "Scheduled Tasks");
			webActions.assertDisplayed(lbl_RestoreDeletedEntities, "Restore Deleted Entities");
			webActions.assertDisplayed(lbl_EntityInspector, "Entity Inspector");
			webActions.assertDisplayed(lbl_ApplicationProperties, "Application Properties");
			webActions.assertDisplayed(lbl_JMXConsole, "JMX Console");
			webActions.assertDisplayed(lbl_EntityLog, "Entity Log");
			webActions.assertDisplayed(lbl_ServerLog, "Server Log");
			webActions.assertDisplayed(lbl_ScreenProfiler, "Screen Profiler");
			webActions.assertDisplayed(lbl_PerformanceStatistics, "Performance Statistics");
			report.reportPass("Maintenenace Options");
		} catch (Exception e) {
			report.reportHardFail("Maintenenace Options");
		}
	}
	public ScheduledTasks openScheduledTasks() {
		try {

			webActions.WaitAndClickAction(lbl_Administration, "Administration Tab");
			webActions.WaitAndClickAction(lbl_ScheduledTasks, "Scheduled Tasks"); 
			report.reportPass("Open Scheduled Tasks");
		} catch (Exception e) {
			report.reportHardFail("Open Scheduled Tasks");
		}

		return (ScheduledTasks) base(ScheduledTasks.class);
	}
}
