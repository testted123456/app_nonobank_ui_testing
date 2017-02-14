package com.nonobank.apps.page.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.nonobank.apps.page.base.BasePage;
import com.nonobank.apps.utils.variable.StringHandle;

public class Page_recharge extends BasePage{
	public static Logger logger = LogManager.getLogger(Page_recharge.class);
	
	public String getText_CPM_popUp(){
		logger.info("[Page]获取弹窗-文本内容。。。。。。");
		WebElement element = objectRepository.getWebElement("弹窗-设置支付密码");
		String popUp=element.getText();
		return popUp;
	}
	
	public void click_CPM_settingIcon(){
		logger.info("[Page]点击弹窗-立即设置。。。。。。");
		WebElement element = objectRepository.getWebElement("弹窗-立即设置");
		element.click();
	}
	
	public double getText_balance(){
		logger.info("[Page]获取账户余额。。。。。。");
		WebElement element = objectRepository.getWebElement("账户余额");
		String balance_str=element.getText();
		double balance=StringHandle.numFromString(balance_str);
		return balance;
	}
	
	public void input_recharge_sum(String rechargeSum){
		logger.info("[Page]输入充值金额。。。。。。");
		WebElement element = objectRepository.getWebElement("充值金额");
		element.sendKeys(rechargeSum);
	}
	
	public void click_ImmediatelyRecharge(){
		logger.info("[Page]点击立即充值。。。。。。");
		WebElement element = objectRepository.getWebElement("立即充值");
		element.click();
	}
	
	public String getText_CPM_title(){
		logger.info("[Page]获取弹窗title。。。。。。");
		WebElement element = objectRepository.getWebElement("弹窗-标题");
		String title=element.getText();
		return title;
	}
	
	public String getText_CPM_needPayMoney(){
		logger.info("[Page]获取需付款金额。。。。。。");
		WebElement element = objectRepository.getWebElement("弹窗-需付款金额");
		String needPayMoney=element.getText();
		return needPayMoney;
	}
	
	public void click_CPM_nextStep(){
		logger.info("[Page]点击弹窗下一步。。。。。。");
		WebElement element = objectRepository.getWebElement("弹窗-下一步");
		element.click();
	}
	
	public void input_CPM_payPwd(String payPwd){
		logger.info("[Page]输入弹窗-支付密码。。。。。。");
		WebElement element = objectRepository.getWebElement("弹窗-支付密码");
		element.sendKeys(payPwd);
	}
	
	public void click_CPM_payPwd_nextStep(){
		logger.info("[Page]点击弹窗-支付密码-下一步。。。。。。");
		WebElement element = objectRepository.getWebElement("弹窗-支付密码-下一步");
		element.click();
	}
	
	public void input_CPM_smsCode(String smsCode){
		logger.info("[Page]输入弹窗-验证码。。。。。。");
		WebElement element = objectRepository.getWebElement("弹窗-验证码");
		element.sendKeys(smsCode);
	}
	
	
	
}
