package com.nonobank.apps.page.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.nonobank.apps.page.base.BasePage;

public class Page_withdrawal extends BasePage{
	public static Logger logger = LogManager.getLogger(Page_withdrawal.class);
	
	public String getText_withdrawal_amount(){
		logger.info("[Page]获取可提现金额。。。。。。");
		WebElement element = objectRepository.getWebElement("可提现金额");
		String withdrawal_amount=element.getText();
		return withdrawal_amount;
	}
	
	public void click_addBankCard(){
		logger.info("[Page]点击添加银行卡。。。。。。");
		WebElement element = objectRepository.getWebElement("添加银行卡");
		element.click();
	}
	
	public void input_withdrawal_amount(String withdrawalAmount){
		logger.info("[Page]输入提现金额。。。。。。");
		WebElement element = objectRepository.getWebElement("输入提现金额");
		element.sendKeys(withdrawalAmount);
	}
	
	public String getText_poundage(){
		logger.info("[Page]获取手续费。。。。。。");
		WebElement element = objectRepository.getWebElement("手续费");
		String poundage=element.getText();
		return poundage;
	}
	
	public String getText_actual_account(){
		logger.info("[Page]获取实际到账金额。。。。。。");
		WebElement element = objectRepository.getWebElement("实际到账");
		String actual_account=element.getText();
		return actual_account;
	}
	
	public void click_withdrawal(){
		logger.info("[Page]点击提现。。。。。。");
		WebElement element = objectRepository.getWebElement("提现");
		element.click();
	}
}
