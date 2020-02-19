package com.tab.af.actions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tab.af.engine.DriverEngine;
import com.tab.af.reporting.StepLogging;
import com.tab.af.testbase.TestBase;

public class ShadowActions {

	private DriverEngine driverEngine;
	private StepLogging log = StepLogging.logObject();
	long explicitPeriod = Long.parseLong(TestBase.props.getProperty("explicit.wait.timeout"));

	public ShadowActions(DriverEngine driverEngine) {
		this.driverEngine = driverEngine;

	}

	private Object injectShadowExecuter(String javascript) {

		JavascriptExecutor js = (JavascriptExecutor) driverEngine.getWebDriver();
		waitForPageLoaded();
		return js.executeScript(javascript);

	}

	private Object injectShadowExecuter(String javascript, WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driverEngine.getWebDriver();
		waitForPageLoaded();
		return js.executeScript(javascript, element);

	}

	private Object executerGetObject(String script) {
		String javascript = convertJStoText().toString();
		javascript += script;
		return injectShadowExecuter(javascript);
	}

	private Object executerGetObject(String script, WebElement element) {
		String javascript = convertJStoText().toString();
		javascript += script;
		return injectShadowExecuter(javascript, element);
	}

	private StringBuilder convertJStoText() {
		InputStream in = getClass().getResourceAsStream("/querySelector.js");
		BufferedReader reader = null;
		// File jsFile = new File("querySelector.js");
		// BufferedReader reader = null;
		StringBuilder text = new StringBuilder();
		// reader = new BufferedReader(new FileReader(jsFile));
		reader = new BufferedReader(new InputStreamReader(in));
		if (reader != null) {
			try {
				while (reader.ready()) {
					text.append(reader.readLine());
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (reader != null) {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return text;
	}

	private void fixLocator(SearchContext context, String cssLocator, WebElement element) {
		if (element instanceof RemoteWebElement) {
			try {

				Class[] parameterTypes = new Class[] { SearchContext.class, String.class, String.class };
				Method m = element.getClass().getDeclaredMethod("setFoundBy", parameterTypes);
				m.setAccessible(true);
				Object[] parameters = new Object[] { context, "cssSelector", cssLocator };
				m.invoke(element, parameters);
			} catch (Exception fail) {
				// fail("Something bad happened when fixing locator");
			}
		}
	}

	private void waitForPageLoaded() {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};
		try {
			Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(driverEngine.getWebDriver(), explicitPeriod);
			wait.until(expectation);
		} catch (Throwable error) {
			// Assertions.fail("Timeout waiting for Page Load Request to complete.");
		}
	}

	public WebElement findElement(String cssSelector) {
		WebElement element = null;
		element = (WebElement) executerGetObject("return getObject(\"" + cssSelector + "\");");
		fixLocator(driverEngine.getWebDriver(), cssSelector, element);
		return element;
	}

	public WebElement findElement(WebElement parent, String cssSelector) {
		WebElement element = null;
		element = (WebElement) executerGetObject("return getObject(\"" + cssSelector + "\", arguments[0]);", parent);
		fixLocator(driverEngine.getWebDriver(), cssSelector, element);
		return element;
	}

	public List<WebElement> findElements(String cssSelector) {
		List<WebElement> element = null;
		Object object = executerGetObject("return getAllObject(\"" + cssSelector + "\");");
		if (object != null && object instanceof List<?>) {
			element = (List<WebElement>) object;
		}
		for (WebElement webElement : element) {
			fixLocator(driverEngine.getWebDriver(), cssSelector, webElement);
		}
		return element;
	}

	public List<WebElement> findElements(WebElement parent, String cssSelector) {
		List<WebElement> element = null;
		Object object = executerGetObject("return getAllObject(\"" + cssSelector + "\", arguments[0]);", parent);
		if (object != null && object instanceof List<?>) {
			element = (List<WebElement>) object;
		}
		for (WebElement webElement : element) {
			fixLocator(driverEngine.getWebDriver(), cssSelector, webElement);
		}
		return element;
	}

	public WebElement getShadowElement(WebElement parent, String selector) {
		WebElement element = null;
		element = (WebElement) executerGetObject("return getShadowElement(arguments[0],\"" + selector + "\");", parent);
		fixLocator(driverEngine.getWebDriver(), selector, element);
		return element;
	}

	public List<WebElement> getAllShadowElement(WebElement parent, String selector) {
		List<WebElement> elements = null;
		Object object = executerGetObject("return getAllShadowElement(arguments[0],\"" + selector + "\");", parent);
		if (object != null && object instanceof List<?>) {
			elements = (List<WebElement>) object;
		}
		for (WebElement element : elements) {
			fixLocator(driverEngine.getWebDriver(), selector, element);
		}
		return elements;
	}

	public WebElement getParentElement(WebElement element) {
		return (WebElement) executerGetObject("return getParentElement(arguments[0]);", element);
	}

	public List<WebElement> getChildElements(WebElement parent) {
		List<WebElement> elements = null;
		Object object = executerGetObject("return getChildElements(arguments[0]);", parent);
		if (object != null && object instanceof List<?>) {
			elements = (List<WebElement>) object;
		}
		return elements;
	}

	public List<WebElement> getSiblingElements(WebElement element) {
		List<WebElement> elements = null;
		Object object = executerGetObject("return getSiblingElements(arguments[0]);", element);
		if (object != null && object instanceof List<?>) {
			elements = (List<WebElement>) object;
		}
		return elements;
	}

	public WebElement getSiblingElement(WebElement element, String selector) {
		return (WebElement) executerGetObject("return getSiblingElement(arguments[0],\"" + selector + "\");", element);
	}

	public WebElement getNextSiblingElement(WebElement element) {
		return (WebElement) executerGetObject("return getNextSiblingElement(arguments[0]);", element);
	}

	public WebElement getPreviousSiblingElement(WebElement element) {
		return (WebElement) executerGetObject("return getPreviousSiblingElement(arguments[0]);", element);
	}

	public boolean isVisible(WebElement element) {
		return (Boolean) executerGetObject("return isVisible(arguments[0]);", element);
	}

	public boolean isChecked(WebElement element) {
		return (Boolean) executerGetObject("return isChecked(arguments[0]);", element);
	}

	public boolean isDisabled(WebElement element) {
		return (Boolean) executerGetObject("return isDisabled(arguments[0]);", element);
	}

	public String getAttribute(WebElement element, String attribute) {
		return (String) executerGetObject("return getAttribute(arguments[0],\"" + attribute + "\");", element);
	}

	public void selectCheckbox(WebElement parentElement, String label) {
		executerGetObject("return selectCheckbox(\"" + label + "\",arguments[0]);", parentElement);
	}

	public void selectCheckbox(String label) {
		executerGetObject("return selectCheckbox(\"" + label + "\");");
	}

	public void selectRadio(WebElement parentElement, String label) {
		executerGetObject("return selectRadio(\"" + label + "\",arguments[0]);", parentElement);
	}

	public void selectRadio(String label) {
		executerGetObject("return selectRadio(\"" + label + "\");");
	}

	public void selectDropdown(WebElement parentElement, String label) {
		executerGetObject("return selectDropdown(\"" + label + "\",arguments[0]);", parentElement);
	}

	public void selectDropdown(String label) {
		executerGetObject("return selectDropdown(\"" + label + "\");");
	}

	public void scrollTo(WebElement element) {
		executerGetObject("return scrollTo(arguments[0]);", element);
	}

	public WebElement waitUntilPresentinDOM(String cssLocator) throws Exception {
		WebElement element = null;
		int explicitPeriod = 60;
		do {

			try {
				element = findElement(cssLocator);

				if (element == null) {
					Thread.sleep(1000);
					explicitPeriod--;

				} else {
					break;
				}
			} catch (Exception e) {
				throw e;
			}
		} while (explicitPeriod > 0);
		return element;
	}

	/**
	 * Click Element
	 * 
	 * @param cssLocator
	 * @param elementName
	 */
	public void click(String cssLocator, String elementName) {
		try {
			WebElement element = findElement(cssLocator);
			element.click();
			log.info("Click on: ", elementName);
		} catch (Exception e) {
			log.error("Click on: ", elementName, e);
			throw e;
		}

	}

	/**
	 * Wait for Explicit Period of time Until Element Returned is not Null and Click
	 * 
	 * @param cssLocator
	 * @param elementName
	 * @throws Exception
	 */
	public void waitAndClick(String cssLocator, String elementName) throws Exception {
		try {
			WebElement element = waitAndfindElement(cssLocator, elementName);
			element.click();
			log.info("Click on: ", elementName);
		} catch (Exception e) {
			log.error("Click on: ", elementName, e);
			throw e;
		}

	}

	/**
	 * Click the Element with Matching Text from a List of WebElement
	 * 
	 * @param cssLocator
	 * @param elementName
	 */
	public void clickByTextInList(String cssLocator, String texttoClick, String elementName) {
		try {
			
			List<WebElement> list = findElements(cssLocator);

			for (WebElement element : list) {

				if (element.getText().equals(texttoClick)) {
					element.click();
					break;
				}
			}
			log.info("Click on Element By texts: ", elementName);
		} catch (Exception e) {
			log.error("Click on Element By text: ", elementName, e);
			throw e;
		}

	}

	/**
	 * Send Keys To Element
	 * 
	 * @param cssLocator
	 * @param elementName
	 */
	public void sendKeys(String cssLocator, String value, String elementName) {
		try {
			WebElement element = findElement(cssLocator);
			((JavascriptExecutor) driverEngine.getWebDriver()).executeScript("arguments[0].value=''", element);
			element.sendKeys(value);
			log.info("Sendkeys on: ", elementName);
		} catch (Exception e) {
			log.error("Sendkeys on: ", elementName, e);
			throw e;
		}

	}

	/**
	 * Wait for Explicit Period of time Until Element Returned is not Null and Send
	 * Keys
	 * 
	 * @param cssLocator
	 * @param value
	 * @param elementName
	 * @throws Exception
	 */
	public void waitAndSendKeys(String cssLocator, String value, String elementName) throws Exception {
		try {
			WebElement element = waitAndfindElement(cssLocator, elementName);
			((JavascriptExecutor) driverEngine.getWebDriver()).executeScript("arguments[0].value=''", element);
			element.sendKeys(value);
			log.info("Sendkeys on: ", elementName);
		} catch (Exception e) {
			log.error("Sendkeys on: ", elementName, e);
			throw e;
		}

	}
	/**
	 * Wait for Explicit Period of time Until Element Returned is not Null and Displayed and Send
	 * Keys
	 * 
	 * @param cssLocator
	 * @param value
	 * @param elementName
	 * @throws Exception
	 */
	public void waitUntilDisplayedAndSendKeys(String cssLocator, String value, String elementName) throws Exception {
		try {
			WebElement element = waitUntilDisplayed(cssLocator, elementName);
			((JavascriptExecutor) driverEngine.getWebDriver()).executeScript("arguments[0].value=''", element);
			element.sendKeys(value);
			log.info("Sendkeys on: ", elementName);
		} catch (Exception e) {
			log.error("Sendkeys on: ", elementName, e);
			throw e;
		}

	}
	/**Wait Until Element is not null,Displayed and Click
	 * @param cssLocator
	 * @param value
	 * @param elementName
	 * @throws Exception
	 */
	public void waitUntilDisplayedAndClick(String cssLocator, String elementName) throws Exception {
		try {
			WebElement element = waitUntilDisplayed(cssLocator, elementName); 
			element.click();
			log.info("Sendkeys on: ", elementName);
		} catch (Exception e) {
			log.error("Sendkeys on: ", elementName, e);
			throw e;
		}

	}
	/**
	 * Clear textbox Value
	 * 
	 * @param cssLocator
	 * @param value
	 * @param elementName
	 * @throws Exception
	 */
	public void clear(String cssLocator, String elementName) throws Exception {
		try {
			WebElement element = findElement(cssLocator);
			JavascriptExecutor js = (JavascriptExecutor) driverEngine.getWebDriver();
			js.executeScript("arguments[0].value='';", element);
			log.info("Sendkeys on: ", elementName);
		} catch (Exception e) {
			log.error("Sendkeys on: ", elementName, e);
			throw e;
		}

	}

	/**
	 * Wait for Explicit Period of time Until Element Returned is not Null
	 * 
	 * @param cssSelector
	 * @param elementName
	 * @return
	 * @throws Exception
	 */
	public WebElement waitAndfindElement(String cssSelector, String elementName) throws Exception {
		WebElement element = null;
		long timeout=explicitPeriod;
		do {

			try {

				element = (WebElement) executerGetObject("return getObject(\"" + cssSelector + "\");");
				fixLocator(driverEngine.getWebDriver(), cssSelector, element);

				if (element != null) {
					log.info("Element is Displayed: ", elementName);
					break;
				} else {
					 TimeUnit.MILLISECONDS.sleep(1000);
					timeout--;
				}

			} catch (JavascriptException e) {

				 TimeUnit.MILLISECONDS.sleep(1000);

				timeout--;
			} catch (Exception e) {
				log.info("Wait for Element to be Displayed failed: ", elementName);
				break;
			}
		} while (timeout > 0);
		return element;
	}

	/**
	 * Wait for Explicit Period of time Until Element Returned is not Null and is Displayed
	 * 
	 * @param cssSelector
	 * @param elementName
	 * @return
	 * @throws Exception
	 */
	public WebElement waitUntilDisplayed(String cssSelector, String elementName) throws Exception {
		WebElement element = null;
		do {

			try {

				element = (WebElement) executerGetObject("return getObject(\"" + cssSelector + "\");");
				fixLocator(driverEngine.getWebDriver(), cssSelector, element);

				if (element != null) {
					if (element.isDisplayed()) {
						log.info("Element is Displayed: ", elementName);
						break;
					}
				} else {
					explicitPeriod--;
				}

			} catch (JavascriptException e) {

				TimeUnit.MILLISECONDS.sleep(1000);

				explicitPeriod--;
			} catch (Exception e) {
				log.info("Wait for Element to be Displayed failed: ", elementName);
				break;
			}
		} while (explicitPeriod > 0);
		return element;
	}

	/**
	 * Select Radio Button by Label From a List of Radio Buttons
	 * 
	 * @param cssLocator
	 * @param label
	 * @param elementName
	 * @throws Exception
	 */
	public void selectRadioButonByLabel(String cssLocator, String label, String elementName) throws Exception {
		try {

			List<WebElement> list = findElements(cssLocator);

			for (WebElement element : list) {

				if (element.getText().equals(label)) {
					element.click();

					break;
				}
			}

			log.info("Click Radio Button: ", elementName);
		} catch (Exception e) {
			log.error("Click Radio Button: ", elementName, e);
			throw e;
		}

	}

	/**
	 * Send Keys to AutoFill Dropdowns
	 * 
	 * @param cssSelector
	 * @param value
	 * @param elementName
	 */
	public void sendKeystoAuto(String cssSelector, String value, String elementName) {
		try {
			WebElement element = findElement(cssSelector);
			element.sendKeys(value);
			// Added Below property To click on the Dropdown that is Currently Enabled
			List<WebElement> dropDownList = findElements(
					"paper-item[role='option'][class='active'][aria-disabled='false']");
			for (WebElement webElement : dropDownList) {
				webElement.click();
			}
			log.info("Send Keys to AutoComplete Input: ", elementName);
		} catch (Exception e) {
			log.error("Send Keys to AutoComplete Input: ", elementName, e);
			throw e;
		}
	}

	/**
	 * Get Text Attribute of Element
	 * 
	 * @param cssSelector
	 * @param elementName
	 * @return
	 */
	public String getText(String cssSelector, String elementName) {
		String text = "";
		try {
			WebElement element = findElement(cssSelector);
			text = element.getText();
			log.info("Get text: " + text, elementName);
		} catch (Exception e) {
			log.error("Get text: ", elementName, e);
			throw e;
		}
		return text;
	}
}
