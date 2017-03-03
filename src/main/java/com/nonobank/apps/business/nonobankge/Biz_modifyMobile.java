package com.nonobank.apps.business.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.nonobank.apps.page.nonobankge.Page_bindingMobile;
import com.nonobank.apps.page.nonobankge.Page_changeBindingMobile;
import com.nonobank.apps.page.nonobankge.Page_common;
import com.nonobank.apps.utils.data.Assertion;

public class Biz_modifyMobile {
	
	public static Logger logger = LogManager.getLogger(Biz_modifyMobile.class);
	Page_bindingMobile page_bindingMobile=new Page_bindingMobile();
	Page_changeBindingMobile page_changeBindingMobile=new Page_changeBindingMobile();
	Page_common page_common=new Page_common();
	
	public void modifyMobile(String mobile,String password,String newMobile,
			String smsCode,String expectMessage){
		String begin=mobile.substring(0, 3);
		String end=mobile.substring(7, 11);
		String bindingMobile=page_bindingMobile.getText_bindingMobile();
		String begin2=bindingMobile.substring(0, 3);
		String end2=bindingMobile.substring(7, 11);
		Assert.assertEquals(begin, begin2);
//		Assert.assertEquals(end, end2);
		page_bindingMobile.input_loginPassword(password);
		page_bindingMobile.sleep(1000);
		page_bindingMobile.click_replaceBinding();
		page_bindingMobile.sleep(1000);
		page_changeBindingMobile.input_mobile(newMobile);
		page_changeBindingMobile.sleep(1000);
		page_changeBindingMobile.click_getSmsCode();
		page_changeBindingMobile.sleep(1000);
		page_changeBindingMobile.input_smsCode(smsCode);
		page_changeBindingMobile.sleep(1000);
		page_changeBindingMobile.click_auth();	
		page_changeBindingMobile.sleep(5000);
		handleResult(expectMessage);
	}
	
	public void modifyMobileExc(String mobile,String loginPwd,String newMobile,
			String loginPwd_error,String newMobile_error,String smsCode_error,
			String smsCode,String expectMessage){
		//输入错误的登录密码
		page_bindingMobile.input_loginPassword(loginPwd_error);
		page_bindingMobile.sleep(1000);
		page_bindingMobile.click_replaceBinding();
		page_bindingMobile.sleep(1000);
		//输入错误的手机号码
		page_bindingMobile.input_loginPassword(loginPwd);
		page_bindingMobile.sleep(1000);
		page_bindingMobile.click_replaceBinding();
		page_bindingMobile.sleep(1000);
		page_changeBindingMobile.input_mobile(newMobile_error);
		page_changeBindingMobile.sleep(1000);
		page_changeBindingMobile.click_getSmsCode();
		page_changeBindingMobile.sleep(1000);
		page_changeBindingMobile.input_smsCode(smsCode);
		page_changeBindingMobile.sleep(1000);
		page_changeBindingMobile.click_auth();
		page_changeBindingMobile.sleep(1000);
		page_common.click_backBtn();
		page_bindingMobile.sleep(1000);
		page_bindingMobile.click_replaceBinding();
		page_bindingMobile.sleep(1000);
		//输入错误的验证码
		page_changeBindingMobile.input_mobile(newMobile);
		page_changeBindingMobile.sleep(1000);
		page_changeBindingMobile.click_getSmsCode();
		page_changeBindingMobile.sleep(1000);
		page_changeBindingMobile.input_smsCode(smsCode_error);
		page_changeBindingMobile.sleep(1000);
		page_changeBindingMobile.click_auth();
		page_common.click_backBtn();
		page_bindingMobile.sleep(1000);
		page_bindingMobile.click_replaceBinding();
		page_bindingMobile.sleep(1000);
		//正确的情况
		page_changeBindingMobile.input_mobile(newMobile);
		page_changeBindingMobile.sleep(1000);
		page_changeBindingMobile.click_getSmsCode();
		page_changeBindingMobile.sleep(1000);
		page_changeBindingMobile.input_smsCode(smsCode);
		page_changeBindingMobile.sleep(1000);
		page_changeBindingMobile.click_auth();
		page_changeBindingMobile.sleep(5000);
		handleResult(expectMessage);
		
	}
	
	
	private void handleResult(String expectMessage) {
		switch (expectMessage) {
		case "设置":
			String except="设置";
			String acturl=page_common.getText_title();
			Assertion.assertEquals(except, acturl, Biz_bindingBankcard.class, "更换绑定手机号码成功");
			break;
		default:
			
			break;
		}
	}
}
