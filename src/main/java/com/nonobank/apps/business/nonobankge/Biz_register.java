package com.nonobank.apps.business.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.nonobank.apps.page.nonobankge.Page_register;


public class Biz_register {

	public static Logger logger = LogManager.getLogger(Biz_register.class);
	Page_register page_register=new Page_register();
	
//	private enum register_enum{
//		mobile(),pictureVerification(),smsCode(),password();
//	}
	
	public void register(Var_register var_register){
		page_register.input_mobile(var_register.getMobile());
		page_register.input_pictureVerification(var_register.getPictureVerification());
		page_register.sleep(1000);
		page_register.click_getSmsCode();
		page_register.input_SmsCode(var_register.getSmsCode());
		page_register.input_password(var_register.getPassword());
		page_register.click_passwordByLock();
		page_register.sleep(1000);
		page_register.click_register();	
	}
	
	
	
}
