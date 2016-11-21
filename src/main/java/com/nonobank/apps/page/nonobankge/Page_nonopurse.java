package com.nonobank.apps.page.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.nonobank.apps.page.base.BasePage;

public class Page_nonopurse extends BasePage{
	public static Logger logger = LogManager.getLogger(Page_nonopurse.class);
	
	public void click_operationRecord(){
		logger.info("【Page】点击操作记录。。。。。。");
		WebElement element = objectRepository.getWebElement("操作记录");
		element.click();
	}
	
	public void click_purseAssets(){
		logger.info("【Page】点击钱包资产。。。。。。");
		WebElement element = objectRepository.getWebElement("钱包资产");
		element.click();
	}
	
	public void click_accumulatedIncome(){
		logger.info("【Page】点击累计收益。。。。。。");
		WebElement element = objectRepository.getWebElement("累计收益");
		element.click();
	}
	
	public void click_suspendSale(){
		logger.info("【Page】点击暂停发售。。。。。。");
		WebElement element = objectRepository.getWebElement("暂停发售");
		element.click();
	}
	
	public void click_turnOut(){
		logger.info("【Page】点击转出。。。。。。");
		WebElement element = objectRepository.getWebElement("转出");
		element.click();
	}
}
