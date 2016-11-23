package com.nonobank.apps.business.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.nonobank.apps.page.nonobankge.Page_register;
import com.nonobank.apps.page.nonobankge.Page_common;
import com.nonobank.apps.page.nonobankge.Page_guide_portal;
import com.nonobank.apps.page.nonobankge.Page_login;


public class Biz_register {

	public static Logger logger = LogManager.getLogger(Biz_register.class);
	Page_register page_register=new Page_register();
	Page_guide_portal Page_guide_portal=new Page_guide_portal();
	Page_common page_common=new Page_common();
	Page_login page_login=new Page_login();
		
	public void register(Var_register var_register){
		if(Page_guide_portal.isExist_bottomArea()){
			Page_guide_portal.swipe_page();
			Page_guide_portal.swipe_page();
			Page_guide_portal.swipe_page();
			Page_guide_portal.sleep(1000);
			Page_guide_portal.click_partake();
		}
		if(page_common.isExist_me() && page_common.is_me_displayed()){
			page_common.click_me();			
		}
		if(page_login.isExist_login()){
			page_common.click_rightTitle();
		}	
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
