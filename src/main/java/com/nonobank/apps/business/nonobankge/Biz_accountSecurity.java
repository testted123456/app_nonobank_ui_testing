package com.nonobank.apps.business.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.nonobank.apps.page.nonobankge.Page_accountSecurity;

public class Biz_accountSecurity {
	public static Logger logger = LogManager.getLogger(Biz_accountSecurity.class);
	
	Page_accountSecurity page_accountSecurity=new Page_accountSecurity();
	
	public void click_loginPassword(){
		logger.info("[Biz]点击登录密码。。。。。。");
		page_accountSecurity.click_loginPassword();
	}
	public void click_gesturePasswordLock(){
		logger.info("[Biz]点击手势密码开关。。。。。。");
		page_accountSecurity.click_gesturePasswordLock();
	}
	public void click_payPassword(){
		logger.info("[Biz]点击支付密码。。。。。。");
		page_accountSecurity.click_payPassword();
	}
	
	
}
