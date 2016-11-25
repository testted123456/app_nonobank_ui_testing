package com.nonobank.apps.page.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.nonobank.apps.page.base.BasePage;

public class Page_cashierDesk extends BasePage{
	public static Logger logger = LogManager.getLogger(Page_cashierDesk.class);
	
	public double getText_payMoney(){
		logger.info("[Page]获取支付金额。。。。。。");
		WebElement element = objectRepository.getWebElement("支付金额");
		String payMoney_str=element.getText();
		double payMoney=Double.parseDouble(payMoney_str);
		return payMoney;
	}
	public String getText_paymentMethod(){
		logger.info("[Page]获取付款方式。。。。。。");
		WebElement element = objectRepository.getWebElement("付款方式");
		String paymentMethod=element.getText();
		return paymentMethod;
	}
	public String getText_bankLimit(){
		logger.info("[Page]获取银行限额信息。。。。。。");
		WebElement element = objectRepository.getWebElement("银行限额信息");
		String bankLimit=element.getText();
		return bankLimit;
	}
	public void click_next(){
		logger.info("[Page]点击下一步。。。。。。");
		WebElement element = objectRepository.getWebElement("下一步");
		element.click();
	}
	public double getText_CMP_rechargeMoney(){
		logger.info("[Page]获取弹窗充值金额。。。。。。");
		WebElement element = objectRepository.getWebElement("弹窗-充值金额");
		String CMP_rechargeMoney_str=element.getText();
		double CMP_rechargeMoney=Double.parseDouble(CMP_rechargeMoney_str);
		return CMP_rechargeMoney;
	}
	public void input_CMP_payPassword(String payPassword){
		logger.info("[Page]输入弹窗支付密码。。。。。。");
		WebElement element = objectRepository.getWebElement("弹窗-请输入支付密码");
		element.sendKeys(payPassword);
	}
	public void click_CMP_forgetPassword(){
		logger.info("[Page]点击弹窗忘记密码。。。。。。");
		WebElement element = objectRepository.getWebElement("弹窗-忘记密码");
		element.click();
	}
	public void click_CMP_enter(){
		logger.info("[Page]点击弹窗-确定。。。。。。");
		WebElement element = objectRepository.getWebElement("弹窗-确定");
		element.click();
	}
	public String getText_CMP2_prompt(){
		logger.info("[Page]获取弹窗-提示信息。。。。。。");
		WebElement element = objectRepository.getWebElement("弹窗-提示信息");
		String CMP2_prompt=element.getText();
		return CMP2_prompt;
	}
	public void input_CMP2_smsCode(String bankSmsCode){
		logger.info("[Page]输入弹窗-验证码。。。。。。");
		WebElement element = objectRepository.getWebElement("弹窗-验证码");
		element.sendKeys(bankSmsCode);
	}
	public void click_CMP2_enterRecharge(){
		logger.info("[Page]点击弹窗-确认充值。。。。。。");
		WebElement element = objectRepository.getWebElement("弹窗-确认充值");
		element.click();
	}
	
	
}
