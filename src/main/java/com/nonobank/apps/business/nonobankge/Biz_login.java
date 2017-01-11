package com.nonobank.apps.business.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.nonobank.apps.page.nonobankge.Page_login;
import com.nonobank.apps.testcase.base.BaseCase;

public class Biz_login extends BaseCase {
	public static Logger logger = LogManager.getLogger(Biz_login.class);
	Page_login page_login=new Page_login();
	
	public void login(String mobile,String password){
		logger.info("[Biz_登录]");
		System.out.println("-------------------------------------------------");
		page_login.input_mobile(mobile);
		page_login.input_password(password);
		page_login.click_login();	
		System.out.println("-------------------------------------------------");
	}
}
