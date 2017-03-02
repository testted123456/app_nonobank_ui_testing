package com.nonobank.apps.business.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.nonobank.apps.page.nonobankge.Page_modifyPayPwd;

public class Biz_modifyPayPwd {

	public static Logger logger = LogManager.getLogger(Biz_modifyPayPwd.class);
	Page_modifyPayPwd page_modifyPayPwd=new Page_modifyPayPwd();
	
	public void modifyPayPwd(String oldPayPwd,String newPayPwd,String secondPayPwd){
		page_modifyPayPwd.input_oldPayPwd(oldPayPwd);
		page_modifyPayPwd.input_newPayPwd(newPayPwd);
		page_modifyPayPwd.input_secondPayPwd(secondPayPwd);
		page_modifyPayPwd.click_enter();
	}
	
	

}
