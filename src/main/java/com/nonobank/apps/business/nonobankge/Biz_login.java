package com.nonobank.apps.business.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.nonobank.apps.page.nonobankge.Page_common;
import com.nonobank.apps.page.nonobankge.Page_gesturePassword;
import com.nonobank.apps.page.nonobankge.Page_login;
import com.nonobank.apps.testcase.base.BaseCase;
import com.nonobank.apps.utils.data.Assertion;

public class Biz_login extends BaseCase {
	public static Logger logger = LogManager.getLogger(Biz_login.class);
	Page_login page_login=new Page_login();
	Page_common page_common=new Page_common();
	Page_gesturePassword page_gesturePassword=new Page_gesturePassword();
	
	public void login(String mobile,String password,String expectMessage){
		logger.info("[Biz_登录]");
		System.out.println("-------------------------------------------------");
		page_login.input_mobile(mobile);
//		page_login.input_password(password);
		page_login.click_login();
		handleResult(expectMessage);
		System.out.println("-------------------------------------------------");
	}
	public void loginExc(String mobile_error,String mobile,String password_error,
			String mobile_new,String password){
		logger.info("[Biz_登录异常情况]");
		page_login.input_mobile(mobile_error);
		page_login.click_login();
		page_login.sleep(1000);
		page_login.input_mobile(mobile);
		page_login.sleep(1000);
		page_login.input_password(password_error);
		page_login.sleep(1000);
		page_login.click_login();
		page_login.sleep(1000);
		page_login.input_mobile(mobile_new);
		page_login.sleep(1000);
		page_login.input_password(password);
		page_login.sleep(1000);
		page_login.click_login();	
	}
	private void handleResult(String expectMessage) {
		switch (expectMessage) {
		case "注册":
			String expect="为了您的账户安全，请设置手势密码";
			String actual=page_gesturePassword.getText_prompt();
			Assertion.assertEquals(expect, actual, Biz_bindingBankcard.class, "注册成功");
			break;
		default:
			
			break;
		}
	}
}
