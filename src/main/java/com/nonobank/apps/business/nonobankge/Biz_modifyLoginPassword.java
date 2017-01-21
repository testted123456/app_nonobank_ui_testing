package com.nonobank.apps.business.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.nonobank.apps.page.nonobankge.Page_common;
import com.nonobank.apps.page.nonobankge.Page_modifyLoginPassword;
import com.nonobank.apps.utils.data.Assertion;

public class Biz_modifyLoginPassword {
	public static Logger logger = LogManager.getLogger(Biz_modifyLoginPassword.class);
	Page_common page_common=new Page_common();
	Page_modifyLoginPassword page_modifyLoginPassword=new Page_modifyLoginPassword();
	
	public void modifyLoginPassword(String oldPassword,String newPassword,
			String ensurePassword,String expectMessage){
		page_modifyLoginPassword.input_oldPassword(oldPassword);
		page_modifyLoginPassword.sleep(1000);
		page_modifyLoginPassword.input_newPassword(newPassword);
		page_modifyLoginPassword.sleep(1000);
		page_modifyLoginPassword.input_ensurePassword(ensurePassword);
		page_modifyLoginPassword.sleep(1000);
		String prompt=page_modifyLoginPassword.getText_prompt();
		Assert.assertEquals(prompt, "密码6-16位，至少包含数字，字母，下划线中的两种");
		page_modifyLoginPassword.click_enter();
		handleResult(expectMessage);
	}
	private void handleResult(String expectMessage) {
		switch (expectMessage) {
		case "账户安全":
			String except="账户安全";
			String acturl=page_common.getText_title();
			Assertion.assertEquals(except, acturl, Biz_bindingBankcard.class, "修改登录密码页面");
			break;
		default:
			
			break;
		}
	}
		
}
