package com.nonobank.apps.business.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.nonobank.apps.page.nonobankge.Page_findPayPwd;
import com.nonobank.apps.page.nonobankge.Page_modifyPayPwd;

public class Biz_findPayPwd {

	public static Logger logger = LogManager.getLogger(Biz_findPayPwd.class);
	
	Page_findPayPwd page_findPayPwd=new Page_findPayPwd();
	Page_modifyPayPwd page_modifyPayPwd=new Page_modifyPayPwd();
	
	public void findPayPwd(String smsCode,String newPayPwd,String secondPayPwd){
		page_modifyPayPwd.click_forgetPayPwd();
		page_modifyPayPwd.sleep(2000);
		page_findPayPwd.click_getSmsCode();
		page_modifyPayPwd.sleep(2000);
		page_findPayPwd.input_smsCode(smsCode);
		page_modifyPayPwd.sleep(2000);
		page_findPayPwd.input_newPayPwd(newPayPwd);
		page_modifyPayPwd.sleep(2000);
		page_findPayPwd.input_secondPayPwd(secondPayPwd);
		page_modifyPayPwd.sleep(2000);
		page_findPayPwd.click_submit();
	}

	
	
	
	
}
