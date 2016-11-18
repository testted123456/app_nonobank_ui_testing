package com.nonobank.apps.page.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.nonobank.apps.page.base.BasePage;

public class Page_productIntroduce extends BasePage{
	public static Logger logger = LogManager.getLogger(Page_productIntroduce.class);
	
	public void click_planIntroduce(){
		logger.info("[Page]点击计划介绍。。。。。。");
		WebElement element = objectRepository.getWebElement("计划介绍");
		element.click();
	}
	public void click_purchaseRecord(){
		logger.info("[Page]点击购买记录。。。。。。");
		WebElement element = objectRepository.getWebElement("购买记录");
		element.click();
	}
	public String getText_planSummary(){
		logger.info("[Page]获取计划总结。。。。。。");
		WebElement element = objectRepository.getWebElement("计划总结");
		String planSummary=element.getText();
		return planSummary;
	}
	public String getText_investInfo(){
		logger.info("[Page]获取投资及收益率。。。。。。");
		WebElement element = objectRepository.getWebElement("投资及收益率");
		String investInfo=element.getText();
		return investInfo;
	}
	public String getText_profitInfo(){
		logger.info("[Page]获取如何获得收益。。。。。。");
		WebElement element = objectRepository.getWebElement("如何获得收益");
		String profitInfo=element.getText();
		return profitInfo;
	}
	public String getText_quitInfo(){
		logger.info("[Page]获取退出方式。。。。。。");
		WebElement element = objectRepository.getWebElement("退出方式");
		String quitInfo=element.getText();
		return quitInfo;
	}
	public String getText_quitFeeInfo(){
		logger.info("[Page]获取退出手续费。。。。。。");
		WebElement element = objectRepository.getWebElement("退出手续费");
		String quitFeeInfo=element.getText();
		return quitFeeInfo;
	}
	public String getText_profitStartTime(){
		logger.info("[Page]获取计息时间。。。。。。");
		WebElement element = objectRepository.getWebElement("计息时间");
		String profitStartTime=element.getText();
		return profitStartTime;
	}
	public String getText_collectionMode(){
		logger.info("[Page]获取收款方式。。。。。。");
		WebElement element = objectRepository.getWebElement("收款方式");
		String collectionMode=element.getText();
		return collectionMode;
	}
	public void click_helpCenter(){
		logger.info("[Page]点击帮助中心。。。。。。");
		WebElement element = objectRepository.getWebElement("帮助中心");
		element.click();
	}
	public void click_serviceProtocol(){
		logger.info("[Page]点击服务协议。。。。。。");
		WebElement element = objectRepository.getWebElement("服务协议");
		element.click();
	}
	
}
