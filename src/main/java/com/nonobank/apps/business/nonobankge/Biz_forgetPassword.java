package com.nonobank.apps.business.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.nonobank.apps.page.nonobankge.Page_findPassword;
import com.nonobank.apps.page.nonobankge.Page_register;

public class Biz_forgetPassword {
	public static Logger logger = LogManager.getLogger(Biz_forgetPassword.class);
	Page_findPassword page_findPassword=new Page_findPassword();
	
	public void forgetPassword(String idCard,String verificationCode){
		logger.info("[Biz_忘记密码]");
		System.out.println("-------------------------------------------------");
		page_findPassword.input_idCard(idCard);
		page_findPassword.click_getSmsCode();
		page_findPassword.sleep(1000);
		page_findPassword.input_smsCode(verificationCode);
		page_findPassword.click_submit();
		System.out.println("-------------------------------------------------");
	}
}
