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
}
