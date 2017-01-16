package com.nonobank.apps.business.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.nonobank.apps.page.nonobankge.Page_common;
import com.nonobank.apps.page.nonobankge.Page_register;
import com.nonobank.apps.utils.data.Assertion;


public class Biz_register {

	public static Logger logger = LogManager.getLogger(Biz_register.class);
	Page_register page_register=new Page_register();
	Page_common page_common=new Page_common();
	
	
	public void register(String mobile,String pictureVerification,String smsCode,
			String password,String expectMessage){
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
