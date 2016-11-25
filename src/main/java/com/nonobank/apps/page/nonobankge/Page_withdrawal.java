package com.nonobank.apps.page.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.nonobank.apps.page.base.BasePage;

public class Page_withdrawal extends BasePage{
	public static Logger logger = LogManager.getLogger(Page_withdrawal.class);
	
	public double getText_withdrawal_amount(){
		logger.info("[Page]获取可提现金额。。。。。。");
		WebElement element = objectRepository.getWebElement("可提现金额");
		String withdrawal_amount_str=element.getText();
		double withdrawal_amount=Double.parseDouble(withdrawal_amount_str);
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
	
	public double getText_poundage(){
		logger.info("[Page]获取手续费。。。。。。");
		WebElement element = objectRepository.getWebElement("手续费");
		String poundage_str=element.getText();
		double poundage=Double.parseDouble(poundage_str);
		return poundage;
	}
	
	public double getText_actual_account(){
		logger.info("[Page]获取实际到账金额。。。。。。");
		WebElement element = objectRepository.getWebElement("实际到账");
		String actual_account_str=element.getText();
		double actual_account=Double.parseDouble(actual_account_str);
		return actual_account;
	}
	
	public void click_withdrawal(){
		logger.info("[Page]点击提现。。。。。。");
		WebElement element = objectRepository.getWebElement("提现");
		element.click();
	}
	
	public double getText_CPM_withdrawalMoney(){
		logger.info("[Page]获取弹窗-提现金额。。。。。。");
		WebElement element = objectRepository.getWebElement("弹窗-提现金额");
		String cpm_withdrawalMoney_str=element.getText();
		double cpm_withdrawalMoney=Double.parseDouble(cpm_withdrawalMoney_str);
		return cpm_withdrawalMoney;
	}
	
	public void input_CPM_payPassword(String payPassword){
		logger.info("[Page]输入弹窗-支付密码。。。。。。");
		WebElement element = objectRepository.getWebElement("弹窗-输入支付密码");
		element.sendKeys(payPassword);
	}
	
	public void click_CPM_enter(){
		logger.info("[Page]点击弹窗确认。。。。。。");
		WebElement element = objectRepository.getWebElement("弹窗-确定");
		element.click();
	}
	public void click_CPM_forgetPassword(){
		logger.info("[Page]点击弹窗-忘记密码。。。。。。");
		WebElement element = objectRepository.getWebElement("弹窗-忘记密码");
		element.click();
	}
	
	
	
}
