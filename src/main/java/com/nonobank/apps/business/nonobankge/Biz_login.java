package com.nonobank.apps.business.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.nonobank.apps.page.nonobankge.Page_common;
import com.nonobank.apps.page.nonobankge.Page_login;
import com.nonobank.apps.testcase.base.BaseCase;
import com.nonobank.apps.utils.data.Assertion;

public class Biz_login extends BaseCase {
	public static Logger logger = LogManager.getLogger(Biz_login.class);
	Page_login page_login=new Page_login();
	Page_common page_common=new Page_common();
	
	public void login(String mobile,String password,String expectMessage){
		logger.info("[Biz_登录]");
		System.out.println("-------------------------------------------------");
		page_login.input_mobile(mobile);
		page_login.input_password(password);
		page_login.click_login();
		handleResult(expectMessage);
		System.out.println("-------------------------------------------------");
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
