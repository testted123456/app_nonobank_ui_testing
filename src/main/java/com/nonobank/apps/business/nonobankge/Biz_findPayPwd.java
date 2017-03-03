package com.nonobank.apps.business.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.nonobank.apps.page.nonobankge.Page_accountSecurity;
import com.nonobank.apps.page.nonobankge.Page_common;
import com.nonobank.apps.page.nonobankge.Page_findPayPwd;
import com.nonobank.apps.page.nonobankge.Page_modifyPayPwd;
import com.nonobank.apps.utils.data.Assertion;

public class Biz_findPayPwd {

	public static Logger logger = LogManager.getLogger(Biz_findPayPwd.class);
	
	Page_findPayPwd page_findPayPwd=new Page_findPayPwd();
	Page_modifyPayPwd page_modifyPayPwd=new Page_modifyPayPwd();
	Page_common page_common=new Page_common();
	Page_accountSecurity page_accountSecurity=new Page_accountSecurity();
	
	public void findPayPwd(String smsCode,String newPayPwd,String secondPayPwd,
			String expectMessage){
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
		page_modifyPayPwd.sleep(2000);
		handleResult(expectMessage);
	}

	public void findPayPwdExc(String smsCode,String newPayPwd,String secondPayPwd,
			String newPayPwd_num,String secondPayPwd_num,
			String newPayPwd_letter,String secondPayPwd_letter,
			String newPayPwd_one,String secondPayPwd_two,
			String expectMessage){
		//纯数字
		page_modifyPayPwd.click_forgetPayPwd();
		page_modifyPayPwd.sleep(2000);
		page_findPayPwd.click_getSmsCode();
		page_modifyPayPwd.sleep(2000);
		page_findPayPwd.input_smsCode(smsCode);
		page_modifyPayPwd.sleep(2000);
		page_findPayPwd.input_newPayPwd(newPayPwd_num);
		page_modifyPayPwd.sleep(2000);
		page_findPayPwd.input_secondPayPwd(secondPayPwd_num);
		page_modifyPayPwd.sleep(2000);
		page_findPayPwd.click_submit();
		page_modifyPayPwd.sleep(2000);
		page_common.click_backBtn();
		page_modifyPayPwd.sleep(2000);
		//纯字母
		page_accountSecurity.click_payPassword();
		page_accountSecurity.sleep(2000);
		page_modifyPayPwd.click_forgetPayPwd();
		page_modifyPayPwd.sleep(2000);
		page_findPayPwd.click_getSmsCode();
		page_modifyPayPwd.sleep(2000);
		page_findPayPwd.input_smsCode(smsCode);
		page_modifyPayPwd.sleep(2000);
		page_findPayPwd.input_newPayPwd(newPayPwd_letter);
		page_modifyPayPwd.sleep(2000);
		page_findPayPwd.input_secondPayPwd(secondPayPwd_letter);
		page_modifyPayPwd.sleep(2000);
		page_findPayPwd.click_submit();
		page_modifyPayPwd.sleep(2000);
		page_common.click_backBtn();
		page_modifyPayPwd.sleep(2000);
		//两次不一样
		page_accountSecurity.click_payPassword();
		page_accountSecurity.sleep(2000);
		page_modifyPayPwd.click_forgetPayPwd();
		page_modifyPayPwd.sleep(2000);
		page_findPayPwd.click_getSmsCode();
		page_modifyPayPwd.sleep(2000);
		page_findPayPwd.input_smsCode(smsCode);
		page_modifyPayPwd.sleep(2000);
		page_findPayPwd.input_newPayPwd(newPayPwd_one);
		page_modifyPayPwd.sleep(2000);
		page_findPayPwd.input_secondPayPwd(secondPayPwd_two);
		page_modifyPayPwd.sleep(2000);
		page_findPayPwd.click_submit();
		page_modifyPayPwd.sleep(2000);
		page_common.click_backBtn();
		page_modifyPayPwd.sleep(2000);
		//正确的
		page_accountSecurity.click_payPassword();
		page_accountSecurity.sleep(2000);
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
		page_modifyPayPwd.sleep(2000);
		handleResult(expectMessage);
	}
	private void handleResult(String expectMessage) {
		switch (expectMessage) {
		case "账户安全":
			String except="账户安全";
			String acturl=page_common.getText_title();
			Assertion.assertEquals(except, acturl, Biz_bindingBankcard.class, "设置支付密码页面");
			break;
		default:
			
			break;
		}
	}
	
	
	
}
