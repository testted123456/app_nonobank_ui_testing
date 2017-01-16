package com.nonobank.apps.business.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.nonobank.apps.page.nonobankge.Page_accountSecurity;
import com.nonobank.apps.page.nonobankge.Page_common;
import com.nonobank.apps.utils.data.Assertion;

public class Biz_accountSecurity {
	public static Logger logger = LogManager.getLogger(Biz_accountSecurity.class);
	
	Page_accountSecurity page_accountSecurity=new Page_accountSecurity();
	Page_common page_common=new Page_common();

	
	public void click_loginPassword(String expectMessage){
		logger.info("[Biz]点击登录密码。。。。。。");
		page_accountSecurity.click_loginPassword();
		handleResult(expectMessage);
	}
	public void click_gesturePasswordLock(String expectMessage){
		logger.info("[Biz]点击手势密码开关。。。。。。");
		page_accountSecurity.click_gesturePasswordLock();
		handleResult(expectMessage);
	}
	public void click_payPassword(String expectMessage){
		logger.info("[Biz]点击支付密码。。。。。。");
		page_accountSecurity.click_payPassword();
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
