package com.nonobank.apps.page.base;

import java.io.File;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import com.nonobank.apps.actions.AndroidActions;
import com.nonobank.apps.actions.AppActions;
import com.nonobank.apps.actions.IOSActions;
import com.nonobank.apps.driver.DriverFactory;
import com.nonobank.apps.objectRepository.AbstractObjectRepository;
import com.nonobank.apps.objectRepository.AndroidObjectRepository;
import com.nonobank.apps.objectRepository.IOSObjectRepository;
import com.nonobank.apps.utils.file.ParseProperties;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class BasePage {

	public static Logger logger = LogManager.getLogger(BasePage.class);

	protected AppiumDriver<WebElement> appiumDriver;
	protected AbstractObjectRepository objectRepository;
	protected AppActions appActions;
	protected String xmlFile;
	protected Properties prop = ParseProperties.getInstance();

	public BasePage() {
		appiumDriver = DriverFactory.getAppiumDriver();
		xmlFile = "elements" + File.separator + this.getClass().getName().replace(".", File.separator) + ".xml";

		if(appiumDriver instanceof AndroidDriver<?>){
			appActions = new AndroidActions((AndroidDriver<WebElement>)appiumDriver);
			objectRepository = new AndroidObjectRepository((AndroidDriver<WebElement>)appiumDriver, xmlFile);
		}else{
			appActions = new IOSActions((IOSDriver<WebElement>)appiumDriver);
			objectRepository = new IOSObjectRepository((IOSDriver<WebElement>)appiumDriver, xmlFile);
		}
	}

	public void sleep(long ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void press(WebElement element,int x,int y){
		TouchAction touchAction = new TouchAction(appiumDriver);
		touchAction.press(element, x, y);
	}
	public void longPress(WebElement element){
		TouchAction touchAction = new TouchAction(appiumDriver);
		touchAction.press(element).waitAction(5000);
		touchAction.perform();
	}
	public void tap(WebElement element,int x,int y){
		TouchAction touchAction = new TouchAction(appiumDriver);
		touchAction.tap(element, x, y);
	}
	
}
