package com.nonobank.apps.page.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.nonobank.apps.page.base.BasePage;
import com.nonobank.apps.utils.variable.StringHandle;

public class Page_invest extends BasePage{
	public static Logger logger = LogManager.getLogger(Page_invest.class);
		
	public String getText_rate(){
		logger.info("[Page]获取预期年化收益。。。。。。");
		WebElement element = objectRepository.getWebElement("预期年化收益");
		String rate=element.getText();
		return rate;
	}
	public String getText_customValue(){
		logger.info("[Page]获取剩余可投金额。。。。。。");
		WebElement element = objectRepository.getWebElement("剩余可投金额");
		String customValue=element.getText();
		return customValue;
	}
	public String getText_expect(){
		logger.info("[Page]获取项目期限。。。。。。");
		WebElement element = objectRepository.getWebElement("项目期限");
		String expect=element.getText();
		return expect;
	}
	public String getText_invest(){
		logger.info("[Page]获取预期收益。。。。。。");
		WebElement element = objectRepository.getWebElement("预期收益");
		String invest=element.getText();
		return invest;
	}

	public void input_investMoney(String investMoney){
		logger.info("[Page]输入投资金额。。。。。。");
		WebElement element = objectRepository.getWebElement("投资金额");
		element.sendKeys(investMoney);
	}
	public void click_cashTicket(){
		logger.info("[Page]点击现金券。。。。。。");
		WebElement element = objectRepository.getWebElement("现金券");
		element.click();
	}
	public void click_rateTicket(){
		logger.info("[Page]点击加息券。。。。。。");
		WebElement element = objectRepository.getWebElement("加息券");
		element.click();
	}
	public double getText_balance(){
		logger.info("[Page]获取余额。。。。。。");
		WebElement element = objectRepository.getWebElement("余额");
		String balance_str=element.getText();
		double balance=StringHandle.numFromString(balance_str);
		return balance;
	}
	public void click_balance(){
		logger.info("[Page]点击余额。。。。。。");
		WebElement element = objectRepository.getWebElement("余额");
		element.click();
	}
	public double getText_balancePayMoney(){
		logger.info("[Page]获取余额支付金额。。。。。。");
		WebElement element = objectRepository.getWebElement("余额支付金额");
		String balance_str=element.getText();
		double balancePayMoney=StringHandle.numFromString(balance_str);
		return balancePayMoney;
	}
	public double getText_needPay(){
		logger.info("[Page]获取还需支付。。。。。。");
		WebElement element = objectRepository.getWebElement("还需支付");
		String balance_str=element.getText();
		double needPay=StringHandle.numFromString(balance_str);
		return needPay;
	}
	public void click_pay(){
		logger.info("[Page]点击支付。。。。。。");
		WebElement element = objectRepository.getWebElement("支付");
		element.click();
	}
	public String getText_CPM_payMethod(){
		logger.info("[Page]获取POP-付款方式。。。。。。");
		WebElement element = objectRepository.getWebElement("POP-付款方式");
		String payMethod=element.getText();
		return payMethod;
	}
	public String getText_CPM_needPayMoney(){
		logger.info("[Page]获取POP-需支付金额。。。。。。");
		WebElement element = objectRepository.getWebElement("POP-需支付金额");
		String payMethod=element.getText();
		return payMethod;
	}
	public void click_CPM_nextStep(){
		logger.info("[Page]点击POP-下一步。。。。。。");
		WebElement element = objectRepository.getWebElement("POP-下一步");
		element.click();
	}
	public void input_CPM_payPwd(String payPwd){
		logger.info("[Page]POP-请输入支付密码。。。。。。");
		WebElement element = objectRepository.getWebElement("POP-请输入支付密码");
		element.sendKeys(payPwd);
	}
	public void click_CPM_payPwd_next(){
		logger.info("[Page]POP-请输入支付密码-下一步。。。。。。");
		WebElement element = objectRepository.getWebElement("POP-请输入支付密码-下一步");
		element.click();
	}
	public void input_CPM_smsCode(String bankSmsCode){
		logger.info("[Page]POP-输入短信验证码。。。。。。");
		WebElement element = objectRepository.getWebElement("POP-短信验证码");
		element.sendKeys(bankSmsCode);	
	}
	public void click_CPM_setting(){
		logger.info("[Page]POP-点击立即设置。。。。。。");
		WebElement element = objectRepository.getWebElement("POP-立即设置");
		element.click();
	}
	
}
