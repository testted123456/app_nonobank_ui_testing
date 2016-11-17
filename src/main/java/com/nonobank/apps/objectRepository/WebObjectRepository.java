package com.nonobank.apps.objectRepository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.nonobank.apps.utils.file.ParseXML;

public class WebObjectRepository {

	private static final Logger logger = LogManager.getLogger(WebObjectRepository.class);
	private WebDriver webDriver;
	private String xmlFile;
	
	public WebObjectRepository(WebDriver driver, String xmlFile){
		this.webDriver = driver;
		this.xmlFile = xmlFile;
	}
	
	public WebElement getWebElementByXpath(String xpath, final long time){
		final By by = By.xpath(xpath);
		
		try {
			WebDriverWait wait = new WebDriverWait(webDriver, time);
			return wait.until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver d) {
					return d.findElement(by);
				}
			});
		} catch (NoSuchElementException e) {
			String msg = "找不页面对象，xpath : " + by.toString();
			logger.info(msg);
			return null;
		}
	}
	
	public WebElement getWebElement(String elementName, final long time){
		String xpath = ParseXML.getElementXpath(elementName, xmlFile, "web");
		return getWebElementByXpath(xpath, time);
	}
	
	public WebElement getWebElement(String elementName){
		String xpath = ParseXML.getElementXpath(elementName, xmlFile, "web");
		return getWebElementByXpath(xpath, 20);
	}
	
	/**
	 * alert窗口是否存在
	 * @param driver
	 * @return
	 */
	public boolean isAlertExists(long ms) {
		int round = (int) ms / 1000;
		for (int i = 0; i <= round; i++) {
			try {
				webDriver.switchTo().alert();
				return true;
			} catch (NoAlertPresentException ex) {
				sleep(1000);
			}
		}
		return false;
	}

	// 关闭alert
	public void closeAlert() {
		webDriver.switchTo().alert().accept();
	}

	// 获取alert内容
	public String getAlertText() {
		return webDriver.switchTo().alert().getText();
	}
	
	public void acceptAlert(){
		webDriver.switchTo().alert().accept();
	}
	
	public void sleep(long t) {
		try {
			Thread.sleep(t);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public boolean isElementExists(String elementName, long time) {
		try {
			WebElement element = getWebElement(elementName, time);
			return (null != element);
		} catch (Exception e) {
			return false;
		}
	}
}
