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
		case "设置":
			String expect="设置";
			String actual=page_common.getText_title();
			Assertion.assertEquals(expect, actual, Biz_me.class, "点击设置图标成功");
			break;
		case "银行卡管理":
			expect="输入银行卡号";
			actual=page_common.getText_title();
			Assertion.assertEquals(expect, actual, Biz_me.class, "点击银行卡管理");
			break;		
		case "充值":
			expect="充值";
			actual=page_common.getText_title();
			Assertion.assertEquals(expect, actual, Biz_me.class, "点击充值");
			break;
		case "提现":
			expect="提现";
			actual=page_common.getText_title();
			Assertion.assertEquals(expect, actual, Biz_me.class, "点击提现");
			break;
		case "回款计划":
			expect="回款计划";
			actual=page_common.getText_title();
			Assertion.assertEquals(expect, actual, Biz_me.class, "点击回款计划");
			break;
		case "投资记录":
			expect="投资记录";
			actual=page_common.getText_title();
			Assertion.assertEquals(expect, actual, Biz_me.class, "点击投资记录");
			break;
		case "我的福利":
			expect="我的福利";
			actual=page_common.getText_title();
			Assertion.assertEquals(expect, actual, Biz_me.class, "点击我的福利");
			break;
		case "我的债权":
			expect="我的债权";
			actual=page_common.getText_title();
			Assertion.assertEquals(expect, actual, Biz_me.class, "点击我的债权");
			break;
		case "总资产":
			expect="总资产";
			actual=page_common.getText_title();
			Assertion.assertEquals(expect, actual, Biz_me.class, "点击总资产");
			break;
		case "可用余额":
			expect="可用余额";
			actual=page_common.getText_title();
			Assertion.assertEquals(expect, actual, Biz_me.class, "点击可用余额");
			break;
		case "累计收益":
			expect="累计收益";
			actual=page_common.getText_title();
			Assertion.assertEquals(expect, actual, Biz_me.class, "点击累计收益");
			break;
		case "消息中心":
			expect="消息中心";
			actual=page_common.getText_title();
			Assertion.assertEquals(expect, actual, Biz_me.class, "点击消息中心");
			break;
		default:
			
			break;
		}
	}
	
}
