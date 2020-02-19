package com.tab.af.web.pages.common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.tab.af.web.pages.BasePage;

public class Commons  extends BasePage{
	@FindBy(xpath = "//html")
	private WebElement lbl_html;
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		 
		return ExpectedConditions.visibilityOf(lbl_html);
	}
	public Commons() {
		PageFactory.initElements(driver,this  );
	}
	public void refreshPage() {
		webActions.refreshPage();
		webActions.waitForJSandJQueryToLoad();
	}
	
	

}
