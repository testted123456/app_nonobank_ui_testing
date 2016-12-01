package com.nonobank.apps.page.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.nonobank.apps.page.base.BasePage;

public class Page_purchaseSuccess extends BasePage{
	public static Logger logger = LogManager.getLogger(Page_purchaseSuccess.class);
	
	public double getText_thisInvestEarning(){
		logger.info("[Page]获取本次投资可获收益。。。。。。");
		WebElement element = objectRepository.getWebElement("本次投资可获收益");
		String thisInvestEarning_str=element.getText();
		double thisInvestEarning=Double.parseDouble(thisInvestEarning_str);
		return thisInvestEarning;
	}
	public double getText_investMoney(){
		logger.info("[Page]获取投资金额。。。。。。");
		WebElement element = objectRepository.getWebElement("投资金额");
		String investMoney_str=element.getText();
		double investMoney=Double.parseDouble(investMoney_str);
		return investMoney;
	}
	public void click_viewInvestRecord(){
		logger.info("[Page]点击查看投资记录。。。。。。");
		WebElement element = objectRepository.getWebElement("查看投资记录");
		element.click();
	}
	public void click_continueInvest(){
		logger.info("[Page]点击继续投资。。。。。。");
		WebElement element = objectRepository.getWebElement("继续投资");
		element.click();
	}
	
	
	
}
