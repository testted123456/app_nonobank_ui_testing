package com.nonobank.apps.business.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.nonobank.apps.page.nonobankge.Page_common;
import com.nonobank.apps.page.nonobankge.Page_me;
import com.nonobank.apps.utils.data.Assertion;

public class Biz_me {
	public static Logger logger = LogManager.getLogger(Biz_me.class);
	Page_me page_me=new Page_me();
	Page_common page_common=new Page_common();
	
	public String getText_userName(){
		logger.info("[Biz]获取用户名。。。。。。");
		String userName=page_me.getText_userName();
		return userName;
	}
	public void click_settingIcon(String expectMessage){
		logger.info("[Biz]点击设置图标。。。。。。");
		page_me.click_settingIcon();
		handleResult(expectMessage);
	}
	public void click_messageIcon(String expectMessage){
		logger.info("[Biz]点击邮件图标。。。。。。");
		page_me.click_messageIcon();
		handleResult(expectMessage);
	}
	public void click_userIcon(String expectMessage){
		logger.info("[Biz]点击头像图标。。。。。。");
		page_me.click_userIcon();
		handleResult(expectMessage);
	}
	public double getText_total_earns(){
		logger.info("[Biz]获取累计收益金额。。。。。。");
		double total_earns=page_me.getText_total_earns();
		return total_earns;
	}
	public void click_amount_eye(String expectMessage){
		logger.info("[Biz]点击累计收益显示按钮。。。。。。");
		page_me.click_amount_eye();
		handleResult(expectMessage);
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
	public void click_recharge(String expectMessage){
		logger.info("[Biz]点击充值。。。。。。");
		page_me.click_recharge();
		handleResult(expectMessage);
	}
	public void click_takecash(String expectMessage){
		logger.info("[Biz]点击提现。。。。。。");
		page_me.click_takecash();
		handleResult(expectMessage);
	}
	public void click_nonoWallet(String expectMessage){
		logger.info("[Biz]点击诺诺钱包。。。。。。");
		page_me.click_nonoWallet();
		handleResult(expectMessage);
	}
	public void click_investRecord(String expectMessage){
		logger.info("[Biz]点击投资记录。。。。。。");
		page_me.click_investRecord();
		handleResult(expectMessage);
	}
	public void click_myWalfare(String expectMessage){
		logger.info("[Biz]点击我的福利。。。。。。");
		page_me.click_myWalfare();
		handleResult(expectMessage);
	}
	public void click_myCreditor(String expectMessage){
		logger.info("[Biz]点击我的债权。。。。。。");
		page_me.click_myCreditor();
		handleResult(expectMessage);
	}
	public void click_bankcard(String expectMessage){
		logger.info("[Biz]点击银行卡管理。。。。。。");
		page_me.click_bankcard();
		handleResult(expectMessage);
	}
	public void click_customer_service(String expectMessage){
		logger.info("[Biz]点击我的客服。。。。。。");
		page_me.click_customer_service();
		handleResult(expectMessage);
	}
	private void handleResult(String expectMessage) {
		switch (expectMessage) {
		case "我的银行卡":
			String expect="我的银行卡";
			String actual=page_common.getText_title();
			Assertion.assertEquals(expect, actual, Biz_bindingBankcard.class, "绑卡成功");
			break;
		default:
			expect="设置银行卡";
			actual=page_common.getText_title();
			Assertion.assertEquals(expect, actual, Biz_bindingBankcard.class, "绑卡失败");
			break;
		}
	}
	
}
