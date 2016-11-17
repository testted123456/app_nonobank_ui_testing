package com.nonobank.apps.objectRepository;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.nonobank.apps.utils.file.ParseXML;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;

public abstract class AbstractObjectRepository{
	
	AppiumDriver<WebElement> appiumDriver;
	
	String xmlFile;
	
	public AbstractObjectRepository(AppiumDriver<WebElement> appiumDriver, String xmlFile){
		this.appiumDriver = appiumDriver;
		this.xmlFile = xmlFile;
	}
	
	public abstract WebElement getWebElementByXpath(String xpath);
	
	public abstract WebElement getWebElement(String elementPath);
	
	public abstract WebElement getWebViewElement(String elementPath);
	
	public abstract void switch_to_appview();
	
	public WebElement getWebElement(WebDriver webDriver, String elementPath){
		String app = null;
		
		if(appiumDriver instanceof IOSDriver){
			app = "ios";
		}else{
			app = "android";
		}
		
		final String xpath = ParseXML.getElementXpath(elementPath, xmlFile, app);

		try {
			WebDriverWait wait = new WebDriverWait(webDriver, 60);
			return wait.until(new org.openqa.selenium.support.ui.ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					return d.findElement(By.xpath(xpath));
				}
			});
		} catch (NoSuchElementException e) {
			String msg = "找不页面对象，xpath : " + xpath;
			return null;
		}
	}
	
	public abstract List<WebElement> getWebElements(String elementPath);
	
	public abstract List<WebElement> getWebElementsByXpath(String xpath);
	
	public abstract boolean isElementExists(String elementPath, long seconds);
	
	public abstract boolean isElementExistsByXpath(String xpath, long seconds);
	
	public boolean isElementDisplayed(String elementPath){
		WebElement element = getWebElement(elementPath);

		if (null != element) {
			return element.isDisplayed();
		}
		return false;
	}
	
	public void sleep(long ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void waitForElementDisplayed(WebElement element, int seconds){
		for(int i=0;i<seconds;i++){
			if(element.isDisplayed()){
				break;
			}else{
				sleep(1000);
			}
		}
	}
}
