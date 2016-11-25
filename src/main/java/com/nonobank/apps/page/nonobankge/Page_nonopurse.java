package com.nonobank.apps.page.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.nonobank.apps.page.base.BasePage;

public class Page_nonopurse extends BasePage{
	public static Logger logger = LogManager.getLogger(Page_nonopurse.class);
	
	public double getText_yesterdayEarn(){
		logger.info("【Page】获取昨日收益。。。。。。");
		WebElement element = objectRepository.getWebElement("昨日收益");
		String yesterdayEarn_str=element.getText();
		double yesterdayEarn=Double.parseDouble(yesterdayEarn_str);
		return yesterdayEarn;
	}
	
	public double getText_purseAssets(){
		logger.info("【Page】获取钱包资产。。。。。。");
		WebElement element = objectRepository.getWebElement("钱包资产");
		String purseAssets_str=element.getText();
		double purseAssets=Double.parseDouble(purseAssets_str);
		return purseAssets;
	}
	
	public double getText_accumulatedIncome(){
		logger.info("【Page】获取累计收益。。。。。。");
		WebElement element = objectRepository.getWebElement("累计收益");
		String accumulatedIncome_str=element.getText();
		double accumulatedIncome=Double.parseDouble(accumulatedIncome_str);
		return accumulatedIncome;
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
