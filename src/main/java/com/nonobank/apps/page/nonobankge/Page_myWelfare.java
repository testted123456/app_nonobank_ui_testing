package com.nonobank.apps.page.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.nonobank.apps.page.base.BasePage;

public class Page_myWelfare extends BasePage{
	public static Logger logger = LogManager.getLogger(Page_myWelfare.class);
	
	public void click_cashCoupon(){
		logger.info("[Page]点击现金券。。。。。。");
		WebElement element = objectRepository.getWebElement("现金券");
		element.click();
	}
	
	public void click_increaseRateCoupon(){
		logger.info("[Page]点击加息券。。。。。。");
		WebElement element = objectRepository.getWebElement("加息券");
		element.click();
	}
	
	public void click_privilegePrincipal(){
		logger.info("[Page]点击特权本金。。。。。。");
		WebElement element = objectRepository.getWebElement("特权本金");
		element.click();
	}
	
	public void click_myCoin(){
		logger.info("[Page]点击我的诺币。。。。。。");
		WebElement element = objectRepository.getWebElement("我的诺币");
		element.click();
	}
	
	public void click_cashRedpackets(){
		logger.info("[Page]点击现金红包。。。。。。");
		WebElement element = objectRepository.getWebElement("现金红包");
		element.click();
	}
}
