package com.nonobank.apps.page.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.nonobank.apps.page.base.BasePage;

public class Page_product extends BasePage{
	public static Logger logger = LogManager.getLogger(Page_product.class);
	
	public void click_xkzq(){
		logger.info("[Page]点击新客专区。。。。。。");
		WebElement element = objectRepository.getWebElement("新客专区");
		element.click();
	}
	public void click_txjh(){
		logger.info("[Page]点击贴心计划。。。。。。");
		WebElement element = objectRepository.getWebElement("贴心计划");
		element.click();
	}
	public void click_yys(){
		logger.info("[Page]点击月月升。。。。。。");
		WebElement element = objectRepository.getWebElement("月月升");
		element.click();
	}
	public void click_tstz(){
		logger.info("[Page]点击特色投资。。。。。。");
		WebElement element = objectRepository.getWebElement("特色投资");
		element.click();
	}
	public void click_zzzq(){
		logger.info("[Page]点击债转专区。。。。。。");
		WebElement element = objectRepository.getWebElement("债转专区");
		element.click();
	}
	public void click_nny(){
		logger.info("[Page]点击诺诺盈。。。。。。");
		WebElement element = objectRepository.getWebElement("诺诺盈");
		element.click();	
	}
	
	
}
