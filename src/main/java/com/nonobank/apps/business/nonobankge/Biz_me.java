package com.nonobank.apps.business.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.nonobank.apps.page.nonobankge.Page_me;

public class Biz_me {
	public static Logger logger = LogManager.getLogger(Biz_me.class);
	Page_me page_me=new Page_me();
	
	public String getText_userName(){
		logger.info("[Biz]获取用户名。。。。。。");
		String userName=page_me.getText_userName();
		return userName;
	}
	public void click_settingIcon(){
		logger.info("[Biz]点击设置图标。。。。。。");
		page_me.click_settingIcon();
	}
	public void click_messageIcon(){
		logger.info("[Biz]点击邮件图标。。。。。。");
		page_me.click_messageIcon();
	}
	public void click_userIcon(){
		logger.info("[Biz]点击头像图标。。。。。。");
		page_me.click_userIcon();
	}
	public double getText_total_earns(){
		logger.info("[Biz]获取累计收益金额。。。。。。");
		double total_earns=page_me.getText_total_earns();
		return total_earns;
	}
	public void click_amount_eye(){
		logger.info("[Biz]点击累计收益显示按钮。。。。。。");
		page_me.click_amount_eye();
	}
	public double getText_total_asset(){
		logger.info("[Biz]获取总资产。。。。。。");
		double total_asset=page_me.getText_total_earns();
		return total_asset;
	}
	public double getText_total_balance(){
		logger.info("[Biz]获取可用余额。。。。。。");
		double total_balance=page_me.getText_total_earns();
		return total_balance;
	}
	public void click_recharge(){
		logger.info("[Biz]点击充值。。。。。。");
		page_me.click_recharge();
	}
	public void click_takecash(){
		logger.info("[Biz]点击提现。。。。。。");
		page_me.click_takecash();
	}
	public void click_nonoWallet(){
		logger.info("[Biz]点击诺诺钱包。。。。。。");
		page_me.click_nonoWallet();
	}
	public void click_investRecord(){
		logger.info("[Biz]点击投资记录。。。。。。");
		page_me.click_investRecord();
	}
	public void click_myWalfare(){
		logger.info("[Biz]点击我的福利。。。。。。");
		page_me.click_myWalfare();
	}
	public void click_myCreditor(){
		logger.info("[Biz]点击我的债权。。。。。。");
		page_me.click_myCreditor();
	}
	public void click_bankcard(){
		logger.info("[Biz]点击银行卡管理。。。。。。");
		page_me.click_bankcard();
	}
	public void click_customer_service(){
		logger.info("[Biz]点击我的客服。。。。。。");
		page_me.click_customer_service();
	}
	
}
