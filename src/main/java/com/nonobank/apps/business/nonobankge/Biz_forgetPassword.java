package com.nonobank.apps.business.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.nonobank.apps.page.nonobankge.Page_findPassword;
import com.nonobank.apps.page.nonobankge.Page_register;

public class Biz_forgetPassword {
	public static Logger logger = LogManager.getLogger(Biz_forgetPassword.class);
	Page_findPassword page_findPassword=new Page_findPassword();
	
	public void forgetPassword(Var_forgetPassword var_forgetPassword){
		page_findPassword.input_idCard(var_forgetPassword.getIdCard());
		page_findPassword.click_getSmsCode();
		page_findPassword.sleep(1000);
		page_findPassword.input_smsCode(var_forgetPassword.getVerificationCode());
		page_findPassword.click_submit();
	}
}
