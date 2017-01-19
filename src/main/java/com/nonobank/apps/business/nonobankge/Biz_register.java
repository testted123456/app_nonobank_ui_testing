package com.nonobank.apps.business.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.nonobank.apps.page.nonobankge.Page_common;
import com.nonobank.apps.page.nonobankge.Page_gesturePassword;
import com.nonobank.apps.page.nonobankge.Page_guide_portal;
import com.nonobank.apps.page.nonobankge.Page_register;
import com.nonobank.apps.utils.data.Assertion;

import junit.framework.Assert;


public class Biz_register {

	public static Logger logger = LogManager.getLogger(Biz_register.class);
	Page_register page_register=new Page_register();
	Page_common page_common=new Page_common();
	Page_guide_portal page_guide_portal=new Page_guide_portal();
	Page_gesturePassword page_gesturePassword=new Page_gesturePassword();
	
	
	public void register(String mobile,String pictureVerification,String smsCode,
			String password,String expectMessage,String environment){
		logger.info("[Biz_注册]");
		System.out.println("-------------------------------------------------");
		if(page_guide_portal.isExist_bottomArea()){
			page_guide_portal.swipe_page();
			page_guide_portal.sleep(1000);
			page_guide_portal.swipe_page();
			page_guide_portal.sleep(1000);
			page_guide_portal.swipe_page();
			page_guide_portal.sleep(1000);
			page_guide_portal.click_partake();
		}
		if(page_common.isExist_me()){
			page_common.press_find();
			page_common.sleep(2000);
			page_common.select_environment(environment);
			page_common.sleep(3000);
		}
		if(page_common.isExist_pop()){
			page_common.close_pop();
		}
		if(page_common.isExist_me()){
			page_common.click_me();
			page_common.sleep(1000);
			page_common.click_rightTitle();
		}
		page_register.input_mobile(mobile);
		page_register.click_nextStep();
		page_register.sleep(1000);
		String text_smsSendTo=page_register.getText_smsSendTo();
		Assert.assertEquals("短信验证码将发送至"+mobile, text_smsSendTo);
		page_register.sleep(1000);
		page_register.click_getSmsCode();
		page_register.sleep(1000);
		page_register.input_pictureVerification(pictureVerification);
		page_register.sleep(1000);
		page_register.click_enter();
		page_register.sleep(1000);
		if(page_register.isExist_enter()){
			page_register.click_enter();
		}
		page_register.input_SmsCode(smsCode);
		page_register.sleep(1000);
		page_register.click_nextStep();
		page_register.sleep(1000);
		String text_pwdForYourAccount=page_register.getText_pwdForYourAccount();
		Assert.assertEquals("请为你的账号"+mobile+"设置密码", text_pwdForYourAccount);
		page_register.sleep(1000);
		page_register.input_password(password);
		page_register.sleep(1000);
		page_register.click_passwordByLock();
		page_register.sleep(1000);
		page_register.click_register();
		handleResult(expectMessage);
		System.out.println("-------------------------------------------------");
	}
	private void handleResult(String expectMessage) {
		switch (expectMessage) {
		case "注册成功":
			String expect="为了您的账户安全，请设置手势密码";
			String actual=page_gesturePassword.getText_prompt();
			Assertion.assertEquals(expect, actual, Biz_bindingBankcard.class, "注册成功");
			break;
		default:
		
			break;
		}
	}
	
	
	
}
