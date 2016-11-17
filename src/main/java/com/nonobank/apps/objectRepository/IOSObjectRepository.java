package com.nonobank.apps.objectRepository;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import com.nonobank.apps.driver.ios.ExpectedCondition;
import com.nonobank.apps.driver.ios.IOSDriverWait;
import com.nonobank.apps.utils.file.ParseXML;
import io.appium.java_client.ios.IOSDriver;

public class IOSObjectRepository extends AbstractObjectRepository {
	
	public static Logger logger = LogManager.getLogger(AbstractObjectRepository.class);

	public IOSObjectRepository(IOSDriver<WebElement> iosDriver, String xmlFile) {
		super(iosDriver, xmlFile);
	}

	@Override
	public WebElement getWebElement(String elementPath) {
		final String xpath = ParseXML.getElementXpath(elementPath, xmlFile, "ios");
		return getWebElementByXpath(xpath);
	}

	@Override
	public List<WebElement> getWebElements(String elementPath) {
		IOSDriver<WebElement> iosDriver = (IOSDriver<WebElement>) appiumDriver;
		String xpath = ParseXML.getElementXpath(elementPath, xmlFile, "ios");
		List<WebElement> elements = iosDriver.findElementsByXPath(xpath);
		return elements;
	}

	@Override
	public boolean isElementExists(String elementPath, long seconds) {
		// TODO Auto-generated method stub
		WebElement element = null;

		try {
			final String xpath = ParseXML.getElementXpath(elementPath, xmlFile, "ios");
			IOSDriver<WebElement> iosDriver = (IOSDriver<WebElement>) appiumDriver;

			element = new IOSDriverWait(iosDriver, seconds).until(new ExpectedCondition<WebElement>() {
				public WebElement apply(IOSDriver<WebElement> d) {
					return d.findElementByXPath(xpath);
				}
			});
		} catch (Exception e) {
		}

		return element == null ? false : true;
	}

	@Override
	public WebElement getWebElementByXpath(final String xpath) {
		IOSDriver<WebElement> iosDriver = (IOSDriver<WebElement>) appiumDriver;
		WebElement element = null;
		
		try{
			element = new IOSDriverWait(iosDriver, 45).until(new ExpectedCondition<WebElement>() {
				public WebElement apply(IOSDriver<WebElement> d) {
					return d.findElementByXPath(xpath);
				}
			});
		}catch(NoSuchElementException e){
			logger.error("抓取对象失败，xpath：" + xpath);
		}

		return element;
	}

	@Override
	public boolean isElementExistsByXpath(final String xpath, long seconds) {
		WebElement element = null;

		try {
			IOSDriver<WebElement> iosDriver = (IOSDriver<WebElement>) appiumDriver;

			element = new IOSDriverWait(iosDriver, seconds).until(new ExpectedCondition<WebElement>() {
				public WebElement apply(IOSDriver<WebElement> d) {
					return d.findElementByXPath(xpath);
				}
			});
		} catch (Exception e) {
		}

		return element == null ? false : true;
	}

	@Override
	public List<WebElement> getWebElementsByXpath(String xpath) {
		IOSDriver<WebElement> iosDriver = (IOSDriver<WebElement>) appiumDriver;
		List<WebElement> elements = iosDriver.findElementsByXPath(xpath);
		return elements;
	}

	@Override
	public WebElement getWebViewElement(String elementPath) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void switch_to_appview() {
		// TODO Auto-generated method stub
		
	}
}
