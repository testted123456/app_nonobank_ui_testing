package com.nonobank.apps.business.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.nonobank.apps.page.nonobankge.Page_login;
import com.nonobank.apps.testcase.base.BaseCase;

public class Biz_login extends BaseCase {
	public static Logger logger = LogManager.getLogger(Biz_login.class);
	Page_login page_login=new Page_login();
	
	public void login(Var_login var_login){
		logger.info("[Biz_登录]");
		page_login.input_mobile(var_login.getMobile());
		page_login.input_password(var_login.getPassword());
		page_login.click_login();	
	}
}
