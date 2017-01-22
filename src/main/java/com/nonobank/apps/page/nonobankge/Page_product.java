package com.nonobank.apps.page.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.nonobank.apps.page.base.BasePage;

public class Page_product extends BasePage{
	public static Logger logger = LogManager.getLogger(Page_product.class);
	
	public void click_regularInvest(){
		logger.info("[Page]点击定投。。。。。。");
		WebElement element = objectRepository.getWebElement("定投");
		element.click();
	}
	public void click_directInvest(){
		logger.info("[Page]点击直投。。。。。。");
		WebElement element = objectRepository.getWebElement("直投");
		element.click();
	}
	public void click_debtEquity(){
		logger.info("[Page]点击债转。。。。。。");
		WebElement element = objectRepository.getWebElement("债转");
		element.click();
	}
	public String getText_bannerTag(){
		logger.info("[Page]获取横幅标题。。。。。。");
		WebElement element = objectRepository.getWebElement("横幅标题");
		String bannerTag=element.getText();
		return bannerTag;
	}
	public String getText_bannerContent(){
		logger.info("[Page]获取横幅标题。。。。。。");
		WebElement element = objectRepository.getWebElement("横幅内容");
		String bannerContent=element.getText();
		return bannerContent;
	}
	public void click_product(String productName){
		logger.info("[Page]点击相应产品。。。。。。");
		WebElement element = objectRepository.getWebElementByXpath("//android.widget.TextView[@text='"+productName+"']");
		element.click();
	}
	
}
