package com.nonobank.apps.page.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.nonobank.apps.page.base.BasePage;

public class Page_investment_record extends BasePage{
	
	public static Logger logger = LogManager.getLogger(Page_investment_record.class);
	
	public void click_plan_class(){
		logger.info("【Page】点击计划类。。。。。。");
		WebElement element = objectRepository.getWebElement("计划类");
		element.click();
	}
	
	public void click_nonoying_class(){
		logger.info("【Page】点击诺诺盈。。。。。。");
		WebElement element = objectRepository.getWebElement("诺诺盈");
		element.click();
	}
	
	public void click_debtswap_class(){
		logger.info("【Page】点击债转类。。。。。。");
		WebElement element = objectRepository.getWebElement("债转类");
		element.click();
	}
	

}
