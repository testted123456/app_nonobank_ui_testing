package com.nonobank.apps.page.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.nonobank.apps.page.base.BasePage;

public class Page_debt extends BasePage{

	public static Logger logger = LogManager.getLogger(Page_debt.class);
	
	
	public String getText_rate(){
		logger.info("[Page]获取预期年化收益。。。。。。");
		WebElement element = objectRepository.getWebElement("预期年化利率");
		String rate=element.getText();
		return rate;
	}
	public String getText_debtPrincipal(){
		logger.info("[Page]获取债转本金。。。。。。");
		WebElement element = objectRepository.getWebElement("债转本金");
		String debtPrincipal=element.getText();
		return debtPrincipal;
	}
	public String getText_plusMoney(){
		logger.info("[Page]获取剩余总额。。。。。。");
		WebElement element = objectRepository.getWebElement("剩余总额");
		String plusMoney=element.getText();
		return plusMoney;
	}
	public void click_buyAll(){
		logger.info("[Page]点击购买全部。。。。。。");
		WebElement element = objectRepository.getWebElement("购买全部");
		element.click();
	}
	public void click_select(){
		logger.info("[Page]点击挑选。。。。。。");
		WebElement element = objectRepository.getWebElement("挑选");
		element.click();
	}
	public void click_atOnceInvest(){
		logger.info("[Page]点击马上投资。。。。。。");
		WebElement element = objectRepository.getWebElement("马上投资");
		element.click();
	}
	
	
	
}
