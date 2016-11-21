package com.nonobank.apps.page.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.nonobank.apps.page.base.BasePage;

public class Page_myDebts extends BasePage{
	public static Logger logger = LogManager.getLogger(Page_myDebts.class);
	
	public void click_debtsList(){
		logger.info("[Page]点击债权列表。。。。。。");
		WebElement element = objectRepository.getWebElement("债权列表");
		element.click();
	}
	
	public void click_debtsSwapRecord(){
		logger.info("[Page]点击债转记录。。。。。。");
		WebElement element = objectRepository.getWebElement("债转记录");
		element.click();
	}
	
	
}
