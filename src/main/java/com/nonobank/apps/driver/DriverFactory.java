package com.nonobank.apps.driver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.nonobank.apps.driver.web.ChromeWebDriver;
import com.nonobank.apps.driver.web.FirefoxWebDriver;
import com.nonobank.apps.driver.web.IEWebDriver;
import com.nonobank.apps.listener.AppiumWebDriverEventListenerImpl;
import com.nonobank.apps.utils.file.ParseProperties;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.events.EventFiringWebDriverFactory;
import io.appium.java_client.ios.IOSDriver;

public class DriverFactory {

	static Logger logger = LogManager.getLogger(DriverFactory.class);

	private static AppiumDriver<WebElement> appiumDriver;
	
	private static WebDriver webDriver;
	
	static Properties prop = ParseProperties.getInstance();
	
	static DesiredCapabilities initCapabilities(){
		String app = prop.getProperty("app").trim();
		
		String newCommandTimeout = prop.getProperty(app + ".newCommandTimeout");
		String unicodeKeyboard = prop.getProperty(app + ".unicodeKeyboard");
		String resetKeyboard = prop.getProperty(app + ".resetKeyboard");
		String platformName = prop.getProperty(app + ".platformName");
		String deviceName = prop.getProperty(app + ".deviceName");
		String platformVersion = prop.getProperty(app + ".platformVersion");
		String noReset = prop.getProperty(app + ".noReset");
		String sessionOverride = prop.getProperty(app + ".sessionOverride");
		String running_app = prop.getProperty("running_app").trim();
		String appDir = prop.getProperty(app + "." + running_app + ".appDir");

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("newCommandTimeout", newCommandTimeout);
		// 输入中文
		capabilities.setCapability("unicodeKeyboard", unicodeKeyboard);
		capabilities.setCapability("resetKeyboard", resetKeyboard);
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("platformName", platformName);
		capabilities.setCapability("deviceName", deviceName);
		// 设置系统版本
		capabilities.setCapability("platformVersion", platformVersion);
		// 设置app路径
		capabilities.setCapability("app", appDir);
//		capabilities.setCapability("autoWebview", "true");
//		capabilities.setCapability("automationName", "selendroid");
		
		if(app.equals("android")){
			String appPackage = prop.getProperty(app + "." + running_app + ".appPackage");
			String appActivity = prop.getProperty(app + "." + running_app + ".appActivity");
			// 设置app的主包名和主类名
			capabilities.setCapability("appPackage", appPackage);
			capabilities.setCapability("appActivity", appActivity);
		}else{
			String udid = prop.getProperty(app + "." + running_app + ".udid");
			String bundleId = prop.getProperty(app + "." + running_app + ".bundleId");
			capabilities.setCapability("udid", udid);
			capabilities.setCapability("bundleId", bundleId);
		}
		
		// 不需要每次重新安装apk
		capabilities.setCapability("noReset", noReset);
		// session可以被覆盖
		capabilities.setCapability("sessionOverride", sessionOverride);
		
		return capabilities;
	}
	
	static IOSDriver<WebElement> getIOSDriver(){
		IOSDriver<WebElement> iosDriver;
		String url = prop.getProperty("ios.url");
		DesiredCapabilities capabilities = initCapabilities();
		
		try {
			iosDriver = new IOSDriver<WebElement>(new URL(url), capabilities);
			return iosDriver;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}

	static AndroidDriver<WebElement> getAndroidDriver() {
		AndroidDriver<WebElement> androidDriver;
		String url = prop.getProperty("android.url");
		DesiredCapabilities capabilities = initCapabilities();
		
		try {
			androidDriver = new AndroidDriver<WebElement>(new URL(url), capabilities);
			return androidDriver;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public static AppiumDriver<WebElement> getAppiumDriver() {
		
		if (null != appiumDriver) {
			return appiumDriver;
		}

		if (prop.getProperty("app").trim().toLowerCase().equals("android")) {
			appiumDriver = getAndroidDriver();
		}else{
			appiumDriver = getIOSDriver();
		}
		
		appiumDriver = EventFiringWebDriverFactory.getEventFiringWebDriver(appiumDriver, new AppiumWebDriverEventListenerImpl());
		return appiumDriver;
	}
	
	public static WebDriver getWebDriver(){
		
		if(null != webDriver){
			return webDriver;
		}
		
		String browser = prop.getProperty("browser");
		
		if(browser.equals("firefox")){
			FirefoxWebDriver firefoxWebDriver = new FirefoxWebDriver();
			webDriver = firefoxWebDriver.getInstance();
		}
		
		if(browser.equals("chrome")){
			webDriver =  new ChromeWebDriver().getInstance();
		}
		
		if(browser.equals("ie")){
			webDriver = new IEWebDriver().getInstance();
		}
		
		return webDriver;
	}
}
