package com.nonobank.apps.page.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.nonobank.apps.page.base.BasePage;

public class Page_me extends BasePage{
	public static Logger logger = LogManager.getLogger(Page_me.class);
	
	public String getText_user_name(){
		logger.info("[Page]获取用户名。。。。。。");
		WebElement element = objectRepository.getWebElement("用户名");
		String user_name=element.getText();
		return user_name;
	}
	public void click_settingIcon(){
		logger.info("[Page]点击设置图标。。。。。。");
		WebElement element = objectRepository.getWebElement("设置图标");
		element.click();
	}
	public void click_messageIcon(){
		logger.info("[Page]点击邮件图标。。。。。。");
		WebElement element = objectRepository.getWebElement("邮件图标");
		element.click();
	}
	public void click_userIcon(){
		logger.info("[Page]点击头像图标。。。。。。");
		WebElement element = objectRepository.getWebElement("头像图标");
		element.click();
	}
	public double getText_total_earns(){
		logger.info("[Page]获取累计收益金额。。。。。。");
		WebElement element = objectRepository.getWebElement("累计收益金额");
		String total_earns_str=element.getText();
		double total_earns=Double.parseDouble(total_earns_str);
		return total_earns;
	}
	public void click_amount_eye(){
		logger.info("[Page]点击累计收益显示按钮。。。。。。");
		WebElement element = objectRepository.getWebElement("累计收益显示按钮");
		element.click();
	}
	public double getText_total_asset(){
		logger.info("[Page]获取总资产。。。。。。");
		WebElement element = objectRepository.getWebElement("总资产");
		String total_asset_str=element.getText();
		double total_asset=Double.parseDouble(total_asset_str);
		return total_asset;
	}
	public double getText_total_balance(){
		logger.info("[Page]获取可用余额。。。。。。");
		WebElement element = objectRepository.getWebElement("可用余额");
		String total_balance_str=element.getText();
		double total_balance=Double.parseDouble(total_balance_str);
		return total_balance;
	}
	public void click_recharge(){
		logger.info("[Page]点击充值。。。。。。");
		WebElement element = objectRepository.getWebElement("充值");
		element.click();
	}
	public void click_takecash(){
		logger.info("[Page]点击提现。。。。。。");
		WebElement element = objectRepository.getWebElement("提现");
		element.click();
	}
	public void click_nonoWallet(){
		logger.info("[Page]点击诺诺钱包。。。。。。");
		WebElement element = objectRepository.getWebElement("诺诺钱包");
		element.click();
	}
	public void click_investRecord(){
		logger.info("[Page]点击投资记录。。。。。。");
		WebElement element = objectRepository.getWebElement("投资记录");
		element.click();
	}
	public void click_myWalfare(){
		logger.info("[Page]点击我的福利。。。。。。");
		WebElement element = objectRepository.getWebElement("我的福利");
		element.click();
	}
	public void click_myCreditor(){
		logger.info("[Page]点击我的债权。。。。。。");
		WebElement element = objectRepository.getWebElement("我的债权");
		element.click();
	}
	public void click_bankcard(){
		logger.info("[Page]点击银行卡管理。。。。。。");
		WebElement element = objectRepository.getWebElement("银行卡管理");
		element.click();
	}
	public void click_customer_service(){
		logger.info("[Page]点击我的客服。。。。。。");
		WebElement element = objectRepository.getWebElement("我的客服");
		element.click();
	}
	
	
	
}
