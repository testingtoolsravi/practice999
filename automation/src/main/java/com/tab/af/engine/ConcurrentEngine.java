package com.tab.af.engine;

import com.tab.af.testbase.TestBase;
import org.openqa.selenium.Capabilities;

import java.util.concurrent.ConcurrentHashMap;

import static org.testng.Assert.assertNotNull;

public class ConcurrentEngine {

	private static ConcurrentHashMap<Long, DriverEngine> engines = new ConcurrentHashMap<>();

	public static DriverEngine getEngine() {
		return engines.get(Thread.currentThread().getId());
	}

	public static void createEngine(Capabilities caps, String browserName, boolean remoteExecution) throws Exception {
		try {
			DriverEngine engine = null;
			try {
				engine = new DriverEngine();
			} catch (Exception e) {
				e.printStackTrace();
			}

			engine.setUpWebDriver(browserName, caps, remoteExecution);
			assertNotNull(engine.getWebDriver().getWrappedDriver(), "Webdriver was not set up correctly.");
			engines.putIfAbsent(Thread.currentThread().getId(), engine);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	public static void destroyEngine() {
		if (engines.containsKey(Thread.currentThread().getId())) {
			if (!TestBase.props.getProperty("run.type").equalsIgnoreCase("api")) {
				if (!getEngine().getWebDriver().toString().contains("null")) {
					cleanUpDriverProcesses();
				}
			}
			engines.remove(Thread.currentThread().getId());
		}
	}

	public static void closeDriver() {
		getEngine().getWebDriver().close();
	}

	public static void cleanUpDriverProcesses() {
		getEngine().getWebDriver().quit();
	}
}
