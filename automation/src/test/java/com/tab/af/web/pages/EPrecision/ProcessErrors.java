package com.tab.af.web.pages.EPrecision;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.tab.af.web.pages.BasePage;

import io.cucumber.datatable.DataTable;
import junit.framework.Assert;

public class ProcessErrors extends BasePage {
	@FindBy(xpath = "//div[text()='Firstdata Process Errors']")
	private WebElement lbl_FirstdataProcessErrors;
	@FindBy(xpath = "//span[text()='Add search condition']")
	private WebElement btn_AddSearchConditon;
	@FindBy(xpath = "//span[text()='Search']")
	private WebElement btn_Search;
	@FindBy(xpath = "//td[contains(@class,\"v-table-header-cell v-table-header\")]")
	private List<WebElement> lbl_TableHeaders;

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(lbl_FirstdataProcessErrors);
	}

	public void validateProcessErrosScreenOptions(DataTable dataTable) {
		try {
			Assert.assertEquals(true,btn_Search.isDisplayed());
			Assert.assertEquals(true,btn_AddSearchConditon.isDisplayed());
		 
			List<String> ExpectedHeaderText=  dataTable.asList();
			
			for(WebElement header: lbl_TableHeaders)
			{
				if(!header.getText().equalsIgnoreCase(""))
				{
				boolean condition=false; 
				for(int i=0;i<ExpectedHeaderText.size();i++)
				{ 
					if(header.getText().equalsIgnoreCase(ExpectedHeaderText.get(i)))
					{
						condition=true;
					}
				}
				if(condition==false)
				{
					System.out.print("");;
				}
				Assert.assertEquals(true, condition);
				}
			}
			report.reportPass("All Options Displayed");

		} catch (Exception e) {
			report.reportHardFail("All Options Displayed");
		}
	}
}

