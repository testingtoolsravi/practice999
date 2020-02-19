package com.tab.af.engine;

import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;

import com.google.gson.Gson;
import com.tab.af.testbase.TestBase;

public class BrowserCapabilities {

	 
	 
	public Capabilities getCapabilities(String browserName)
            throws IOException, ParseException {
		JSONParser parser = new JSONParser();
		FileReader reader = new FileReader(System.getProperty("user.dir")+"\\src\\main\\resources\\capabilities.json");

		Object obj = parser.parse(reader);
		JSONObject parentObject = (JSONObject) obj;
		JSONObject browser = (JSONObject) parentObject.get(browserName);
		JSONObject arguments = (JSONObject) browser.get("arguments");
		JSONObject capabilities = (JSONObject) browser.get("capabilities");
        Map<String, String> m = new HashMap<>();

		if (browserName.equalsIgnoreCase("chrome")) {
			m= new Gson().fromJson(arguments.toString(), Map.class);
			ChromeOptions options = new ChromeOptions();
			Set<String> keys = m.keySet();
			for (String key : keys) {
				options.addArguments(m.get(key));
			}
			options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
			options.setExperimentalOption("useAutomationExtension", false);
            Map<String, Object> prefs = new HashMap<>();
			prefs.put("credentials_enable_service", false);
			prefs.put("password_manager_enabled", false); 
			options.setExperimentalOption("prefs", prefs);
			//File file = new File(System.getProperty("user.dir")+"\\src\\main\\resources\\XPath-Helper_v2.0.2.crx");
			//options.addExtensions(file);
			m.clear();
			m= new Gson().fromJson(capabilities.toString(), Map.class);
			keys = m.keySet();
			for (String key : keys) {
				options.setCapability(key, m.get(key));
			}
			return  options;
		}
		if (browserName.equalsIgnoreCase("firefox")) {
			m= new Gson().fromJson(arguments.toString(), Map.class);
			FirefoxOptions options = new FirefoxOptions();
            if (TestBase.props.getProperty("run.type").equals("local"))
			{
			options.setBinary(TestBase.props.getProperty("firefox.binary.path"));
			}
			Set<String> keys = m.keySet();
			for (String key : keys) {
				options.addArguments(m.get(key)); 
			}
			m.clear();
			m= new Gson().fromJson(capabilities.toString(), Map.class);
			keys = m.keySet();
			for (String key : keys) {
				options.setCapability(key, m.get(key));
			}
			return  options;
		}
		if (browserName.equalsIgnoreCase("ie")) {
			 
			InternetExplorerOptions options = new InternetExplorerOptions(); 
			m= new Gson().fromJson(capabilities.toString(), Map.class);
			Set<String> keys = m.keySet();
			for (String key : keys) {
				options.setCapability(key, m.get(key));
			}
			return  options;
		}
		return null;

	}

	
}
