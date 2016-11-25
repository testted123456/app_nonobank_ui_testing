package com.nonobank.apps.page.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.nonobank.apps.page.base.BasePage;

public class Page_home extends BasePage{
	public static Logger logger = LogManager.getLogger(Page_home.class);
	
	public void click_top_bar_one(){
		logger.info("[Page]点击跑马灯。。。。。。");
		WebElement element = objectRepository.getWebElement("跑马灯");
		element.click();
	}
	public void click_top_bar_two(){
		logger.info("[Page]点击邀请有礼。。。。。。");
		WebElement element = objectRepository.getWebElement("邀请有礼");
		element.click();
	}
	public void click_top_bar_three(){
		logger.info("[Page]点击攒钱活动。。。。。。");
		WebElement element = objectRepository.getWebElement("攒钱活动");
		element.click();
	}
	public void click_top_bar_four(){
		logger.info("[Page]点击安全保障。。。。。。");
		WebElement element = objectRepository.getWebElement("安全保障");
		element.click();
	}
	
	
	
}
