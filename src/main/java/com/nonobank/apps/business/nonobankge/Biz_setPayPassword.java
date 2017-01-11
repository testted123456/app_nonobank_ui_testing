package com.nonobank.apps.business.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.nonobank.apps.page.nonobankge.Page_common;
import com.nonobank.apps.page.nonobankge.Page_setPayPassword;

public class Biz_setPayPassword {
	public static Logger logger = LogManager.getLogger(Biz_setPayPassword.class);
	
	Page_setPayPassword page_setPayPassword=new Page_setPayPassword();
	Page_common page_common=new Page_common();
	
	public void setPayPassword(String payPassword,String payPassword_second){
		logger.info("[Biz]设置支付密码。。。。。。");
		System.out.println("------------------------------------------------");
		page_setPayPassword.input_password(payPassword);
		page_setPayPassword.sleep(2000);
		page_setPayPassword.input_confirmPassword(payPassword_second);
		page_setPayPassword.sleep(2000);
		page_setPayPassword.click_confirm();
		String title=page_common.getText_title();
		Assert.assertEquals(title, "账户安全");
		System.out.println("------------------------------------------------");
	}

}
