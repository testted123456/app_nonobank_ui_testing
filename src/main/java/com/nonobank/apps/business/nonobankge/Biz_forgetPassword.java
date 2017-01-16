package com.nonobank.apps.business.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.nonobank.apps.page.nonobankge.Page_common;
import com.nonobank.apps.page.nonobankge.Page_findPassword;
import com.nonobank.apps.page.nonobankge.Page_register;
import com.nonobank.apps.utils.data.Assertion;

public class Biz_forgetPassword {
	public static Logger logger = LogManager.getLogger(Biz_forgetPassword.class);
	Page_findPassword page_findPassword=new Page_findPassword();
	Page_common page_common=new Page_common();
	
	public void forgetPassword(String idCard,String verificationCode,String expectMessage){
		logger.info("[Biz_忘记密码]");
		System.out.println("-------------------------------------------------");
		page_findPassword.input_idCard(idCard);
		page_findPassword.click_getSmsCode();
		page_findPassword.sleep(1000);
		page_findPassword.input_smsCode(verificationCode);
		page_findPassword.click_submit();
		handleResult(expectMessage);
		System.out.println("-------------------------------------------------");
	}
	private void handleResult(String expectMessage) {
		switch (expectMessage) {
		case "":
			String expect="";
			String actual=page_common.getText_title();
			Assertion.assertEquals(expect, actual, Biz_bindingBankcard.class, "");
			break;
		default:
			expect="";
			actual=page_common.getText_title();
			Assertion.assertEquals(expect, actual, Biz_bindingBankcard.class, "");
			break;
		}
	}
}
