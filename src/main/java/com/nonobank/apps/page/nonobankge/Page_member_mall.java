package com.nonobank.apps.page.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.nonobank.apps.page.base.BasePage;

public class Page_member_mall extends BasePage {
	public static Logger logger = LogManager.getLogger(Page_member_mall.class);
	
	public void click_ordinery_members(){
		logger.info("[Page]点击会员商城普通。。。。。。");
		WebElement element = objectRepository.getWebElement("普通");
		element.click();
	}
	
	public void click_vip1(){
		logger.info("[Page]点击会员商城VIP。。。。。。");
		WebElement element = objectRepository.getWebElement("VIP1");
		element.click();
	}
	
	public void click_vip2(){
		logger.info("[Page]点击会员商城VIP2。。。。。。");
		WebElement element = objectRepository.getWebElement("VIP2");
		element.click();
	}
	
	public void click_vip3(){
		logger.info("[Page]点击会员商城VIP3。。。。。。");
		WebElement element = objectRepository.getWebElement("VIP3");
		element.click();
	}
	
	public void click_(){
		logger.info("[Page]点击会员商城VIP3。。。。。。");
		WebElement element = objectRepository.getWebElement("VIP3");
		element.click();
	}
	
	
	

}
