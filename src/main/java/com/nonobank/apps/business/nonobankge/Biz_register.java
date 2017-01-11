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
	
	public void register(String mobile,String pictureVerification,String smsCode,
			String password){
		logger.info("[Biz_注册]");
		System.out.println("-------------------------------------------------");
		page_register.input_mobile(mobile);
		page_register.input_pictureVerification(pictureVerification);
		page_register.sleep(1000);
		page_register.click_getSmsCode();
		page_register.input_SmsCode(smsCode);
		page_register.input_password(password);
		page_register.click_passwordByLock();
		page_register.sleep(1000);
		page_register.click_register();	
		System.out.println("-------------------------------------------------");
	}
	
	
	
}
