package com.tab.af.actions;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tab.af.engine.DriverEngine;
import com.tab.af.reporting.StepLogging;
import com.tab.af.testbase.TestBase;

public class WebActions {

	private DriverEngine driverEngine;
	private StepLogging log = StepLogging.logObject();
	private Properties prop = TestBase.props;
	long explicitPeriod = Long.parseLong(prop.getProperty("explicit.wait.timeout"));

	public DriverEngine getDriverEngine() {
		return driverEngine;
	}

	public WebActions(DriverEngine driverEngine) {
		this.driverEngine = driverEngine;
	}

	public void loadURL(String URL) {
		driverEngine.getWebDriver().get(URL);
	}

	public void refreshPage() {
		driverEngine.getWebDriver().navigate().refresh();
	}

	/**
	 * Load URL using JavaScript
	 * 
	 * @param URL
	 */
	public void loadURLByJS(String URL) {
		try {
			driverEngine.getWebDriver().executeScript("window.location=arguments[0];", URL);
			log.info("Load URL: ", URL);
		} catch (Exception e) {
			log.error("Load URL: ", URL, e);
			throw e;
		}
	}

	/**
	 * clears the Input field Value of Element using JS
	 * 
	 * @param element
	 * @param elementName
	 * @throws Exception
	 */
	public void clearByJS(WebElement element, String elementName) {
		try {
			// Using JS clear as Webelement.clear() is not supported
			(driverEngine.getWebDriver()).executeScript("arguments[0].value='';", element);
			log.info("Clear by JS on: ", elementName);
		} catch (Exception e) {
			log.error("Clear By JS on: ", elementName, e);
			throw e;
		}

	}

	/**
	 * clears the WebElement before sending value
	 * 
	 * @param element
	 * @param elementName
	 * @throws Exception
	 */
	public void sendKeys(WebElement element, String value, String elementName) {
		try {

			clearByJS(element, elementName);
			element.sendKeys(value);
			element.sendKeys(Keys.TAB);
			log.info("Send Keys value: ", value.replaceAll("[^A-Za-z0-9]", "") + " on " + elementName);
		} catch (Exception e) {
			log.error("Send Keys value: ", value.replaceAll("[^A-Za-z0-9]", "") + " on " + elementName, e);
			throw e;
		}
	}

	/**
	 * Enter String as a char
	 * 
	 * @param element
	 * @param elementName
	 * @throws Exception
	 */
	public void sendKeysByChar(WebElement element, String value, String elementName) {
		try {
			char[] arr = value.toCharArray();
			element.sendKeys(Keys.HOME);
			for (char c : arr) {
				element.sendKeys(c + "");
			}
			element.sendKeys(Keys.TAB);
			log.info("Send Keys By Char value: ", value + " on " + elementName);

		} catch (Exception e) {
			log.error("Send Keys value: ", value.replaceAll("[^A-Za-z0-9]", "") + " on " + elementName, e);
			throw e;
		}
	}

	/**
	 * Clear the Textbox and Enter String as a char
	 * 
	 * @param element
	 * @param elementName
	 * @throws Exception
	 */
	public void clearAndSendKeysByChar(WebElement element, String value, String elementName) {

		clearByJS(element, elementName);
		sendKeysByChar(element, value, elementName);

	}

	/**
	 * Wait for Element to be Displayed and enter String as a char
	 * 
	 * @param element
	 * @param elementName
	 * @throws Exception
	 */
	public void waitAndSendKeysByChar(WebElement element, String value, String elementName) throws Exception {

		waitUntilDisplayed(element, elementName);
		sendKeysByChar(element, value, elementName);
	}

	/**
	 * Wait for Element to be Displayed and enter String as a char in Autocomplete
	 * Input Textboxes TextBoxes
	 * 
	 * @param element
	 * @param elementName
	 * @throws Exception
	 */
	public void waitAndSendKeysByCharAuto(WebElement element, String value, String elementName) throws Exception {

		waitUntilDisplayed(element, elementName);
		SendKeysByCharAuto(element, value, elementName);

	}

	/**
	 * Wait for Element ,clear the field and then Sedn keys by char to Auto textbox
	 * 
	 * @param element
	 * @param value
	 * @param elementName
	 * @throws Exception
	 */
	public void waitClearSendKeysByCharAuto(WebElement element, String value, String elementName) throws Exception {

		waitUntilDisplayed(element, elementName);
		clearByJS(element, elementName);
		SendKeysByCharAuto(element, value, elementName);

	}

	/**
	 * Enter String as a char in Autocomplete Input TextBoxes
	 * 
	 * @param element
	 * @param elementName
	 * @throws Exception
	 */
	public void SendKeysByCharAuto(WebElement element, String value, String elementName) throws Exception {
		try {

			char[] arr = value.toCharArray();
			clickBYJS(element.findElement(By.xpath("//following-sibling::div")), elementName);
			waitForJSandJQueryToLoad();
			for (char c : arr) {
				element.sendKeys(String.valueOf(c));
			}
			selectDropDownOption(element, value);

			log.info("Send Keys By Char value: ", value + " on " + elementName);

		} catch (Exception e) {
			log.error("Send Keys value: ", value + " on " + elementName, e);
			throw e;
		}
	}

	private void selectDropDownOption(WebElement element, String value) {

		try {

			Actions actions = new Actions(driverEngine.getWebDriver());

			waitForJSandJQueryToLoad();
			WebElement option = findBy(By.xpath("//td[@role=\"listitem\"]//span[contains(text(),'" + value + "')]"),
					10);
			actions.sendKeys(option, Keys.ENTER).build().perform();
			waitForJSandJQueryToLoad();
		} catch (Exception e) {
			// ignoring
			e.printStackTrace();
		}
	}

	/**
	 * Click WebElement
	 * 
	 * @param element
	 * @param elementName
	 * @throws Exception
	 */
	public void click(WebElement element, String elementName) {
		try {
			element.click();
			log.info("Click on: ", elementName);
		} catch (Exception e) {
			log.error("Click on: ", elementName, e);
			throw e;
		}
	}

	/**
	 * wait Until WebElement Displayed Property is True and then Click
	 * 
	 * @param element
	 * @param elementName
	 * @throws Exception
	 */
	public void waitAndClick(WebElement element, String elementName) {

		waitForClickAbility(element, elementName);
		click(element, elementName);

	}

	/**
	 * wait Until WebElement Enabled Property is True and then Click
	 * 
	 * @param element
	 * @param elementName
	 * @throws Exception
	 */
	public void waitUntilEnabledAndClick(WebElement element, String elementName) throws Exception {

		waitUntilEnabled(element, elementName);
		click(element, elementName);
	}

	/**
	 * wait Until WebElement is Visible using WebDriverWait
	 * 
	 * @param element
	 * @param elementName
	 * @throws Exception
	 */
	public void waitForVisibility(WebElement element, String elementName) {
		try {
			WebDriverWait wait = new WebDriverWait(driverEngine.getWebDriver(), explicitPeriod);
			wait.ignoring(NoSuchElementException.class);
			wait.until(ExpectedConditions.visibilityOf(element));
			log.info("Wait for Element to be visible: ", elementName);
		} catch (Exception e) {
			log.error("Wait for Element to be visible: ", e);
			throw e;
		}

	}

	/**
	 * wait Until WebElement is Visible using WebDriverWait and Defined Wait Period
	 * 
	 * @param element
	 * @param elementName
	 * @throws Exception
	 */
	public WebElement waitForVisibility(WebElement element, String elementName, long period) {
		try {
			WebDriverWait wait = new WebDriverWait(driverEngine.getWebDriver(), period);
			wait.ignoring(NoSuchElementException.class).pollingEvery(Duration.ofMillis(500));
			wait.until(ExpectedConditions.visibilityOf(element));
			log.info("Wait for Element to be visible: ", elementName);
		} catch (Exception e) {
			log.error("Wait for Element to be visible: ", e);
			throw e;
		}
		return element;
	}

	/**
	 * Wait Until Element is Clickable
	 * 
	 * @param element
	 * @param elementName
	 */
	public void waitForClickAbility(WebElement element, String elementName) {
		try {
			WebDriverWait wait = new WebDriverWait(driverEngine.getWebDriver(), explicitPeriod);
			wait.ignoring(NoSuchElementException.class);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			log.info("Wait for Element to be Clickable: ", elementName);
		} catch (Exception e) {
			log.error("Wait for Element to be Clickable: ", e);
			throw e;
		}

	}

	/**
	 * Wait Until Element is Clickable and Perform JS Click
	 * 
	 * @param element
	 * @param elementName
	 */
	public void waitForClickAbilityAndClick(WebElement element, String elementName) {
		try {
			WebDriverWait wait = new WebDriverWait(driverEngine.getWebDriver(), explicitPeriod);
			wait.ignoring(NoSuchElementException.class);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			clickBYJS(element, elementName);
			log.info("Wait for Element to be Clickable: ", elementName);
		} catch (Exception e) {
			log.error("Wait for Element to be Clickable: ", e);
			throw e;
		}

	}

	/**
	 * Wait for Text to Be Present in Textbox
	 * 
	 * @param element
	 * @param elementName
	 */
	public void waitForTextToBePresentInValue(WebElement element, String value, String elementName) {
		try {
			WebDriverWait wait = new WebDriverWait(driverEngine.getWebDriver(), explicitPeriod);
			wait.ignoring(NoSuchElementException.class);
			wait.until(ExpectedConditions.textToBePresentInElementValue(element, value));
			log.info("Wait for Text to Present in Value: ", elementName);
		} catch (Exception e) {
			log.error("Wait for Text to Present in Value: ", e);
			throw e;
		}

	}

	/**
	 * Wait Until Element is not present in DOM anymore
	 * 
	 * @param element
	 * @param elementName
	 * @throws Exception
	 */
	public void waitForElementToBeNotPresent(WebElement element, String elementName) throws Exception {
		long timeout = explicitPeriod;
		do {
			try {

				if (element.isDisplayed()) {

					Thread.sleep(1000);
				}
				timeout--;
			} catch (NoSuchElementException | StaleElementReferenceException e) {
				log.info("Element is Not Present in DOM ", elementName);
				break;
			} catch (Exception e) {
				log.info("Wait for Element Not Present in DOM failed: ", elementName);
				throw e;
			}
		} while (timeout > 0);

	}

	/**
	 * Wait Until Element is Disabled
	 * 
	 * @param element
	 * @param elementName
	 */
	public void waitForElementToBeDisabled(WebElement element, String elementName) {

		try {
			WebDriverWait wait = new WebDriverWait(driverEngine.getWebDriver(), explicitPeriod);
			wait.ignoring(NoSuchElementException.class);
			wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(element)));

			log.info("Element is Disabled ", elementName);

		} catch (Exception e) {
			log.info("Element is Disabled: ", elementName);
			throw e;
		}

	}

	/**
	 * Wait For CUBA Loading to complete
	 * 
	 * @param element
	 * @param elementName
	 * @throws Exception
	 */
	public void waitForLoadingToComplete() throws Exception {
		try {
			WebElement element = findBy(By.xpath("//div[contains(@class,'v-loading-indicator')]"));
			waitUntilNotPresent(element, "Loading Bar");
			log.info("Wait Until Complete ", "Loading");
		} catch (NoSuchElementException e) {
			log.info("Wait Until Complete ", "Loading");
		} catch (Exception e) {

			log.error("Wait Until Complete ", "Loading", e);
			throw e;
		}
	}

	/**
	 * Click WebElement by JS click
	 * 
	 * @param element
	 * @param elementName
	 * @throws Exception
	 */
	public void clickBYJS(WebElement element, String elementName) {
		try {
			((JavascriptExecutor) driverEngine.getWebDriver()).executeScript("arguments[0].click();", element);
			log.info("Click by JS on: ", elementName);
		} catch (Exception e) {
			log.error("Click by JS on: ", elementName, e);
			throw e;
		}
	}

	/**
	 * Wait and Displayed and then Click WebElement by JS click
	 * 
	 * @param element
	 * @param elementName
	 * @throws Exception
	 */
	public void waitAndCickBYJS(WebElement element, String elementName) throws Exception {

		waitUntilDisplayed(element, elementName);
		clickBYJS(element, elementName);
	}
	/**
	 * Wait Until element is CUBA Enabeld and present in DOM , then Click WebElement by JS click
	 * 
	 * @param element
	 * @param elementName
	 * @throws Exception
	 */
	public void waitUntilEnabledAndCickBYJS(WebElement element, String elementName) throws Exception {

		waitUntilEnabledCubaButton(element, elementName);
		clickBYJS(element, elementName);
	}
	public WebElement findByText(String text, String prependingTag) {
		long timeout = explicitPeriod;
		WebElement element = null;
		do {
			try {
				if (prependingTag == "") {
					element = driverEngine.getWebDriver().findElement(By.xpath("//*[text()='" + text + "']"));
				} else {
					element = driverEngine.getWebDriver()
							.findElement(By.xpath(prependingTag + "[contains(text(),'" + text + "')]"));
				}

				break;
			} catch (NoSuchElementException e) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				timeout--;
			} catch (Exception e) {
				log.info("Find text By Element Failed due to: ", e.getClass().getCanonicalName());
				throw e;
			}
		} while (timeout > 0);
		return element;
	}

	/**
	 * Finds WebElement by Complete Text
	 * 
	 * @param text
	 * @return WebElement
	 */
	public WebElement findWebElementByText(String text) {
		long timeout = explicitPeriod;
		WebElement element = null;
		do {
			try {

				element = driverEngine.getWebDriver().findElement(By.xpath("//*[text()='" + text + "']"));

				break;
			} catch (NoSuchElementException e) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				timeout--;
			} catch (Exception e) {
				log.info("Find text By Element Failed due to: ", e.getClass().getCanonicalName());
				timeout = 0;
				throw e;
			}
		} while (timeout > 0);
		return element;
	}

	/**
	 * Finds WebElement by Contains Text
	 * 
	 * @param text
	 * @return WebElement
	 */
	public WebElement findWebElementByContainsText(String text) {
		long timeout = explicitPeriod;
		WebElement element = null;
		do {
			try {

				element = driverEngine.getWebDriver().findElement(By.xpath("//*[contains(text(),'" + text + "')]"));

				break;
			} catch (NoSuchElementException e) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				timeout--;
			} catch (Exception e) {
				log.info("Find text By Element Failed due to: ", e.getClass().getCanonicalName());
				timeout = 0;
				throw e;
			}
		} while (timeout > 0);
		return element;
	}

	/**
	 * Wait Until WebElement Displayed property return true while Ignoring
	 * NoSuchElementException
	 * 
	 * @param element
	 * @param elementName
	 * @throws Exception
	 * 
	 */
	public WebElement waitUntilDisplayed(WebElement element, String elementName) throws Exception {
		long timeout = explicitPeriod;
		do {
			try {

				if (element.isDisplayed()) {
					log.info("Element is Displayed: ", elementName);
					break;
				}
				Thread.sleep(1000);
				timeout--;
			} catch (NoSuchElementException e) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {

					e1.printStackTrace();
				}
				timeout--;
			} catch (Exception e) {
				log.info("Wait for Element to be Displayed failed: ", elementName);
				throw e;
			}
		} while (timeout > 0);
		if (timeout == 0) {
			throw new Exception("Wait for Element to be displayed Failed: " + elementName);
		}
		return element;
	}

	/**
	 * Wait Until Element class Attribute is enabled
	 * 
	 * @param element
	 * @param elementName
	 * @return
	 * @throws Exception
	 */
	public WebElement waitUntilClassEnabled(WebElement element, String elementName) throws Exception {
		long timeout = explicitPeriod;
		do {
			try {

				TimeUnit.MILLISECONDS.sleep(1000);
				String disabled = element.getAttribute("aria-disabled");
				if (disabled == null) {
					log.info("Element is Enabled: ", elementName);
					break;
				}
				timeout--;
			} catch (Exception e) {
				log.info("Wait for Element to be Enabled failed: ", elementName);
				throw e;
			}
		} while (timeout > 0);
		if (timeout == 0) {
			throw new Exception("Wait for Element Class to be Enabled: " + elementName);
		}
		return element;
	}

	/**
	 * Enter Credentials into a Alert
	 * 
	 * @param username
	 * @param password
	 */
	public void setCredentialsinAlert(String username, String password) {
		Alert alert = driverEngine.getWebDriver().switchTo().alert();
		alert.sendKeys(username + "\ue004" + password);

	}

	/**
	 * Scroll Element into ViewPort using JS
	 * 
	 * @param element
	 * @param elementName
	 */
	public void scrollIntoViewByJS(WebElement element, String elementName) {
		try {
			driverEngine.getWebDriver().executeScript("arguments[0].scrollIntoView(true);", element);
			log.info("Scroll to WebElement ", elementName);
		} catch (Exception e) {
			log.error("Wait for Element to be Displayed failed: ", e);
		}

	}

	/**
	 * Get Page Source
	 * 
	 * @return
	 */
	public String getPageSource() {
		String source = "";
		try {
			source = driverEngine.getWebDriver().getPageSource();
			log.info("Get Page Source ", "");
		} catch (Exception e) {
			log.error("Get Page Source", e);
		}
		return source;
	}

	/**
	 * Click the Specified webElement using Actions class
	 * 
	 * @param element
	 * @param elementName
	 */
	public void clickAction(WebElement element, String elementName) {
		try {
			Actions action = new Actions(driverEngine.getWebDriver());
			action.click(element).build().perform();
			log.info("Click By Action ", elementName);
		} catch (Exception e) {
			log.error("Click By Action : ", e);
			throw e;
		}
	}

	/**
	 * Click the Specified webElement using Actions class
	 * 
	 * @param element
	 * @param elementName
	 */
	public void rightClickAction(WebElement element, String elementName) {
		try {
			Actions action = new Actions(driverEngine.getWebDriver());
			action.contextClick(element).build().perform();
			log.info("Click By Action ", elementName);
		} catch (Exception e) {
			log.error("Click By Action : ", e);
			throw e;
		}
	}

	/**
	 * Click the Specified webElement using Actions class
	 * 
	 * @param element
	 * @param elementName
	 * @throws Exception
	 */
	public void WaitAndClickAction(WebElement element, String elementName) throws Exception {

		waitUntilDisplayed(element, elementName);
		clickAction(element, elementName);

	}

	/**
	 * Double the Specified webElement using Actions class
	 * 
	 * @param element
	 * @param elementName
	 */
	public void doubleClick(WebElement element, String elementName) {
		try {
			Actions action = new Actions(driverEngine.getWebDriver());
			action.doubleClick(element).build().perform();
			log.info("Scroll to WebElement ", elementName);
		} catch (Exception e) {
			log.error("Wait for Element to be Displayed failed: ", e);
			throw e;
		}
	}

	/**
	 * Double the Specified webElement using Actions class
	 * 
	 * @param element
	 * @param elementName
	 */
	public void authenticationLogin(String userName, String password) {
		try {
			Alert alert = driverEngine.getWebDriver().switchTo().alert();
			alert.sendKeys(userName + Keys.TAB + password);
			alert.accept();

			log.info("Send Keys to Alert ", "Authentication Alert");
		} catch (Exception e) {
			log.error("Send Keys to Alert ", e);
		}
	}

	/**
	 * Wait Until the WebElement Enabled Property return true while Ignoring
	 * NoSuchElementException
	 * 
	 * @param element
	 * @param elementName
	 * @throws Exception
	 */
	public WebElement waitUntilEnabled(WebElement element, String elementName) throws Exception {

		long timeout = explicitPeriod;
		do {
			try {
				TimeUnit.MILLISECONDS.sleep(500);
				if (element.isEnabled()) {
					log.info("Element is Enabled: ", elementName);
					break;
				}
				Thread.sleep(1000);
				timeout--;

			} catch (NoSuchElementException e) {
				Thread.sleep(1000);
				timeout--;
			} catch (Exception e) {
				log.info("Wait for Element to be Enabled failed: ", elementName);
				throw e;
			}
		} while (timeout > 0);
		if (timeout == 0) {
			throw new Exception("Wait for Element to be Enabled: " + elementName);
		}
		return element;
	}

	/**
	 * Wait Until CUBA UI Buttons are not Disabled
	 * 
	 * @param element
	 * @param elementName Note: Specific to UI and Element Tag must Be DIV
	 * @return
	 * @throws Exception Note: Element Should have a "aria-disabled" Attribute
	 *                   Otherwise condition Will always be Null
	 */
	public WebElement waitUntilEnabledCubaButton(WebElement element, String elementName) throws Exception {
		long timeout = explicitPeriod;
		do {
			try {

				if (element.getAttribute("aria-disabled") == null) {
					log.info("Element is Enabled: ", elementName);
					break;
				}
				Thread.sleep(1000);
				timeout--;
			} catch (NoSuchElementException e) {
				Thread.sleep(1000);
				timeout--;
			} catch (Exception e) {
				log.info("Wait for Element to be Enabled failed: ", elementName);
				throw e;
			}
		} while (timeout > 0);
		if (timeout == 0) {
			throw new Exception("Wait for Cuba Element to be Enabled: " + elementName);
		}
		return element;

	}

	/**
	 * Wait Until CUBA UI TextBoxes are not Disabled
	 * 
	 * @param element
	 * @param elementName Note: Specific to UI and Element Tag must Be DIV
	 * @return
	 * @throws Exception
	 */
	public WebElement waitUntilEnabledCubaTBox(WebElement element, String elementName) throws Exception {
		long timeout = explicitPeriod;
		do {
			try {
				TimeUnit.MILLISECONDS.sleep(500);
				if (element.getAttribute("disabled") == null) {
					log.info("Element is Enabled: ", elementName);
					break;
				}
				Thread.sleep(1000);
				timeout--;
			} catch (NoSuchElementException e) {
				Thread.sleep(1000);
				timeout--;
			} catch (Exception e) {
				log.info("Wait for Element to be Enabled failed : ", elementName);
				throw e;
			}
		} while (timeout > 0);
		if (timeout == 0) {
			throw new Exception("Wait for CUBA TextBox Element to be Enabled Failed: " + elementName);
		}
		return element;
	}

	/**
	 * Wait for "aria-disabled" Attribute to be present and Return value as true
	 * Specifica to CUBA Elements with "aria-disabled" parameter
	 * 
	 * @param element
	 * @param elementName Note: Ignoring StaleElementReferenceException and
	 *                    NoSuchElementException class
	 */
	public void waitUntilDisabled(WebElement element, String elementName) {
		try {
			long timeout = explicitPeriod;
			WebDriverWait wait = new WebDriverWait(driverEngine.getWebDriver(), timeout);
			wait.ignoring(StaleElementReferenceException.class);

			wait.until(new ExpectedCondition<Boolean>() {
				@Override
				public Boolean apply(WebDriver driver) {
					String enabled = element.getAttribute("aria-disabled");
					if (enabled.equals("true"))
						return true;
					else
						return false;
				}
			});
			log.info("Wait until Disabled", elementName);
		} catch (TimeoutException e) {
			log.info("Timeout Exception Occured ", elementName);
			throw e;
		}
	}

	public void assertDisplayed(WebElement element, String elementName) throws Exception {
		try {
			if (element.isDisplayed() == true) {

				log.info("Element is Displayed", elementName);
			} else {
				throw new Exception("Element not Displayed");
			}
		} catch (Exception e) {
			log.info("Assert Displayed Exception Occured ", elementName);
			throw e;
		}
	}

	/**
	 * Returns a index for the column Name Note: Specific to Tables in CUBA UI Only
	 * 
	 * @param ColumnName
	 * @return
	 */
	public int getColumnIndex(String ColumnName, List<WebElement> list) {
		int cIndex = 1;
		for (WebElement e : list) {

			if (e.getText().contentEquals(ColumnName)) {
				break;
			} else {
				cIndex++;
			}
		}

		return cIndex;
	}

	/**
	 * Returns Map of Index by ColumnaNames Input List Should contain header
	 * Elements Note: Specific to Tables in CUBA UI Only
	 * 
	 * @param elements
	 * @return
	 */
	public Map<String, Integer> getColumnIndexMap(List<WebElement> elements) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < elements.size(); i++) {
			map.put(elements.get(i).getText(), i + 1);
		}
		return map;

	}

	/**
	 * GET Table Row input WebElement
	 * 
	 * @param map
	 * @param row
	 * @param columnName
	 * @return
	 */
	public WebElement getRowElement(Map<String, Integer> map, int row, String columnName) {
		int cIndex = map.get(columnName);
		WebElement element = findBy(By.xpath("//tr[" + row + "]//td[" + cIndex + "]//div//input"));
		return element;

	}

	/**
	 * Clicks a Specified valued in the specified ColumnName Note:Specific to Tables
	 * in CUBA UI Only
	 * 
	 * @param ColumnName
	 * @param valueToSelect
	 */
	public void selectCellValue(String ColumnName, String valueToSelect, List<WebElement> webList) {
		int column = getColumnIndex(ColumnName, webList);
		List<WebElement> list = driverEngine.getWebDriver()
				.findElements(By.xpath("//tr//td[" + column + "]//div[text()]"));
		for (WebElement e : list) {
			if (e.getText().equals(valueToSelect)) {
				scrollIntoViewByJS(e, valueToSelect);
				doubleClick(e, valueToSelect);
				break;
			}
		}

	}

	public int getRowIndex(String ColumnName, String valueToSelect, List<WebElement> webList) {
		int column = getColumnIndex(ColumnName, webList);
		int rowIndex = 1;
		List<WebElement> list = driverEngine.getWebDriver()
				.findElements(By.xpath("//tr//td[" + column + "]//div[text()]"));
		for (WebElement e : list) {
			if (e.getText().equals(valueToSelect)) {
				break;
			} else {
				rowIndex++;
			}
		}
		return rowIndex;
	}

	public boolean waitForJSandJQueryToLoad() {

		WebDriverWait wait = new WebDriverWait(driverEngine.getWebDriver(), explicitPeriod);

		// wait for jQuery to load
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) ((JavascriptExecutor) driverEngine.getWebDriver())
							.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					// no jQuery present
					return true;
				}
			}
		};

		// wait for Javascript to load
		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driverEngine.getWebDriver()).executeScript("return document.readyState")
						.toString().equals("complete");
			}
		};

		return wait.until(jQueryLoad) && wait.until(jsLoad);
	}

	public void waitForStalenessOf(WebElement element, String elementName) {
		long timeout = explicitPeriod;
		try {
			WebDriverWait wait = new WebDriverWait(getDriverEngine().getWebDriver(), timeout);
			wait.until(ExpectedConditions.stalenessOf(element));
			log.info("Wait For Staleness of : ", elementName);
		} catch (Exception e) {
			log.info("Wait For Staleness of : ", elementName);
			throw e;
		}
	}

	/**
	 * FInd element by By object and wait for explicit Period
	 * 
	 * @param by
	 * @return WebElement
	 */
	public WebElement findBy(By by) {
		long timeout = explicitPeriod;
		WebElement element = null;
		do {
			try {

				element = driverEngine.getWebDriver().findElement(by);
				log.info("Element is Found: ", "");
				break;

			} catch (NoSuchElementException e) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {

					e1.printStackTrace();
				}
				timeout--;
			} catch (Exception e) {
				log.info("FInd Element failed: ", "");
				throw e;
			}
		} while (timeout > 0);
		return element;
	}

	/**
	 * FInd element by By object and wait for explicit Period
	 * 
	 * @param by
	 * @return WebElement
	 */
	public WebElement findBy(By by, long timeout) {

		WebElement element = null;
		do {
			try {

				element = driverEngine.getWebDriver().findElement(by);
				log.info("Element is Found: ", "");
				break;

			} catch (NoSuchElementException e) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {

					e1.printStackTrace();
				}
				timeout--;
			} catch (Exception e) {
				log.info("FInd Element failed: ", "");
				throw e;
			}
		} while (timeout > 0);
		return element;
	}

	/**
	 * FInd element List by By object
	 * 
	 * @param by
	 * @return WebElement
	 */
	public List<WebElement> findsBy(By by) {
		long timeout = explicitPeriod;
		List<WebElement> elementList = null;
		do {
			try {

				elementList = driverEngine.getWebDriver().findElements(by);
				log.info("Element is Found: ", "");
				break;

			} catch (NoSuchElementException e) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {

					e1.printStackTrace();
				}
				timeout--;
			} catch (Exception e) {
				log.info("FInd Element failed: ", "");
				throw e;
			}
		} while (timeout > 0);
		return elementList;
	}

	/**
	 * Wait Until Element is not DIsplayed
	 * 
	 * @param element
	 * @param elementName
	 * @return
	 * @throws Exception
	 */
	public WebElement waitUntilNotDisplayed(WebElement element, String elementName) throws Exception {
		long timeout = explicitPeriod;
		do {
			try {

				if (!element.isDisplayed()) {
					log.info("Element is Not Displayed: ", elementName);
					break;
				}
				Thread.sleep(1000);
				timeout--;
			} catch (Exception e) {
				log.info("Wait for Element to be Not Displayed failed: ", elementName);
				throw e;
			}
		} while (timeout > 0);
		return element;
	}

	/**
	 * Wait Until Value of Textbxo is not empty
	 * 
	 * @param element
	 * @param elementName
	 * @return
	 * @throws Exception
	 */
	public WebElement waitUntilValueisNotEmpty(WebElement element, String elementName) throws Exception {
		long timeout = explicitPeriod;
		do {
			try {

				if (!element.getAttribute("value").isEmpty()) {
					log.info("Wait for Element Value is not Empty: ", elementName);
					break;
				}
				Thread.sleep(1000);
				timeout--;
			} catch (Exception e) {
				log.info("Wait for Element Value is not Empty: ", elementName);
				throw e;
			}
		} while (timeout > 0);
		return element;
	}

	/**
	 * Wait Until is not present in DOM
	 * 
	 * @param element
	 * @param elementName
	 * @return
	 * @throws Exception
	 */
	public void waitUntilNotPresent(WebElement element, String elementName) throws Exception {
		long timeout = explicitPeriod;
		do {
			try {

				if (element.isDisplayed()) {
					log.info("Element is Not Present in DOM Anymore: ", elementName);
					break;
				}
				Thread.sleep(1000);
				timeout--;
			} catch (NoSuchElementException | StaleElementReferenceException e) {
				break;
			} catch (Exception e) {
				log.info("Element is Not Present in DOM Anymore: ", elementName);
				throw e;
			}
		} while (timeout > 0);

	}

	/**
	 * Switch to Other window than current Note: works Properly only when two
	 * windows are open
	 */
	public void switchToOtherOpenedWindow() {
		try {
			Thread.sleep(5000);
			WebDriver driver = driverEngine.getWebDriver();
			String curentHandle = driver.getWindowHandle();
			Set<String> handles = driver.getWindowHandles();
			for (String string : handles) {
				if (!string.equals(curentHandle)) {
					driver.switchTo().window(string);
					break;
				}
			}
			log.info("Switch to newly opened window ", "");
		} catch (Exception e) {
			log.error("Switch to newly opened window ", e);
		}
	}

	public String getBrowsername() {
		Capabilities cap = ((RemoteWebDriver) driverEngine.getWebDriver().getWrappedDriver()).getCapabilities();
		return cap.getBrowserName().toLowerCase();
	}
}
