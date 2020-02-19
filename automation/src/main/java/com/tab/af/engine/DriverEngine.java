package com.tab.af.engine;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ThreadGuard;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.tab.af.actions.ShadowActions;
import com.tab.af.actions.WebActions;
import com.tab.af.reporting.ReportLibrary;
import com.tab.af.testbase.TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverEngine {

	private EventFiringWebDriver webDriver;
	private WebActions webActions;
	private ReportLibrary reportLibrary;
	private ShadowActions shadowActions;
	private String browser;
	private String browserVersion;
	private WebDriverEvents webDriverEvents = WebDriverEvents.getInstance();

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public String getBrowserVersion() {
		return browserVersion;
	}

	public void setBrowserVersion(String browserVersion) {
		this.browserVersion = browserVersion;
	}

	public DriverEngine() {
		initialize();
	}

	public void initialize() {
		initalizeWebActions();
		initalizeReportLibrary();
		initalizeShadowActions();
	}

	private void initalizeWebActions() {
		webActions = new WebActions(this);
	}

	private void initalizeReportLibrary() {
		reportLibrary = new ReportLibrary(this);
	}

	private void initalizeShadowActions() {
		shadowActions = new ShadowActions(this);
	}

	public WebActions getWebActions() {
		return webActions;
	}

	public ReportLibrary getReportLibrary() {
		return reportLibrary;
	}

	public EventFiringWebDriver getWebDriver() {
		return webDriver;
	}

	public ShadowActions getShadowActions() {
		return shadowActions;
	}

	public void setWebDriver(EventFiringWebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public void setUpWebDriver(String browserType, Capabilities caps, boolean remoteExecution) throws Exception {
		selectDriverType(browserType, caps, remoteExecution);
	}

	private final void selectDriverType(String browserType, Capabilities caps, boolean remoteExecution)
			throws Exception {
		if (remoteExecution)
			setUpRemoteWebDriver(browserType, caps);
		else
			setUpLocalWebDriver(browserType, caps);

	}

	private void setUpRemoteWebDriver(String browser, Capabilities caps) throws Exception {
		try {

			webDriver = new EventFiringWebDriver(ThreadGuard.protect(createRemoteDriver(caps)));

			if (Boolean.parseBoolean(TestBase.props.getProperty("Selenium.Event.log"))) {
				webDriver.register(webDriverEvents);
			}
		} catch (MalformedURLException e) {
			System.out.println("setUpRemoteWebDriver, The url provided was malformed.");
			
			throw e;
		} catch (SessionNotCreatedException e) {
			System.out.println("setUpRemoteWebDriver, The session could not be created.");
			throw e;
		} catch (WebDriverException e) {
			System.out.println(
					"setUpRemoteWebDriver, The webdriver created on one thread was accessed by another thread or the session could not be created");
			throw e;

		}
	}

	private RemoteWebDriver createRemoteDriver(Capabilities caps) throws Exception {
		RemoteWebDriver remoteWebDriver;

		String hubURL = TestBase.props.getProperty("grid.url");
		switch ("grid") {
		case "grid":
			remoteWebDriver = new RemoteWebDriver(new URL(hubURL), caps);
			break;
		default:
			System.out.println("an attempt to create a remote web driver for grid is failed");
			remoteWebDriver = new RemoteWebDriver(new URL(hubURL), caps);
		}
		return remoteWebDriver;
	}

	private void setUpLocalWebDriver(String browserType, Capabilities caps) throws Exception {
		EventFiringWebDriver eventDriver;
		switch (browserType.toUpperCase()) {
		case "CHROME":

			eventDriver = setUpLocalChromeDriver(caps);

			break;
		case "FIREFOX":
			eventDriver = setUpLocalFirefoxDriver(caps);

			break;
		case "IE":
			eventDriver = setUpLocalIeDriver(caps);

			break;
		default:
			throw new IllegalArgumentException(browserType + " is not supported. Please choose another browser.");
		}
		webDriver = eventDriver;
		// #############
		if (Boolean.parseBoolean(TestBase.props.getProperty("Selenium.Event.log"))) {
			webDriver.register(webDriverEvents);
		}
		setBrowser(caps.getBrowserName());
		setBrowserVersion(caps.getVersion());
	}

	private EventFiringWebDriver setUpLocalChromeDriver(Capabilities caps) throws Exception {
		EventFiringWebDriver webDriver;
		ChromeOptions options = (ChromeOptions) caps;

		WebDriverManager.chromedriver().version(TestBase.props.getProperty("chrome.binary.version")).setup();

		if (caps == null) {
			webDriver = new EventFiringWebDriver(ThreadGuard.protect(new ChromeDriver()));
		} else {
			webDriver = new EventFiringWebDriver(ThreadGuard.protect(new ChromeDriver(options)));

		}

		return webDriver;
	}

	private EventFiringWebDriver setUpLocalFirefoxDriver(Capabilities caps) throws Exception {
		EventFiringWebDriver webDriver;
		FirefoxOptions options = (FirefoxOptions) caps;
		WebDriverManager.firefoxdriver().version(TestBase.props.getProperty("firefox.binary.version")).setup();

		if (caps == null) {
			webDriver = new EventFiringWebDriver(ThreadGuard.protect(new FirefoxDriver()));
		}

		else {
			webDriver = new EventFiringWebDriver(ThreadGuard.protect(new FirefoxDriver(options)));
		}

		return webDriver;
	}

	private EventFiringWebDriver setUpLocalIeDriver(Capabilities caps) throws Exception {
		EventFiringWebDriver webDriver;
		InternetExplorerOptions options = (InternetExplorerOptions) caps;
		WebDriverManager.iedriver().version(TestBase.props.getProperty("ie.binary.version")).arch32().setup();
		if (caps == null) {
			webDriver = new EventFiringWebDriver(ThreadGuard.protect(new InternetExplorerDriver()));
		} else {
			webDriver = new EventFiringWebDriver(ThreadGuard.protect(new InternetExplorerDriver(options)));
		}
		return webDriver;
	}

}
