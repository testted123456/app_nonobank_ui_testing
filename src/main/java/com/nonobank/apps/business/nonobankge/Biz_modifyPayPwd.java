package com.nonobank.apps.business.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.nonobank.apps.page.nonobankge.Page_accountSecurity;
import com.nonobank.apps.page.nonobankge.Page_common;
import com.nonobank.apps.page.nonobankge.Page_modifyPayPwd;
import com.nonobank.apps.utils.data.Assertion;

public class Biz_modifyPayPwd {

	public static Logger logger = LogManager.getLogger(Biz_modifyPayPwd.class);
	Page_modifyPayPwd page_modifyPayPwd=new Page_modifyPayPwd();
	Page_common page_common=new Page_common();
	Page_accountSecurity page_accountSecurity=new Page_accountSecurity();
	
	public void modifyPayPwd(String oldPayPwd,String newPayPwd,String secondPayPwd,
			String expectMessage){
		page_modifyPayPwd.input_oldPayPwd(oldPayPwd);
		page_modifyPayPwd.input_newPayPwd(newPayPwd);
		page_modifyPayPwd.input_secondPayPwd(secondPayPwd);
		page_modifyPayPwd.click_enter();
		handleResult(expectMessage);
	}
	
	public void modifyPayPwdExc(String oldPayPwd,String newPayPwd,String secondPayPwd,
			String oldPayPwd_error,String newPayPwd_num,String secondPayPwd_num,
			String newPayPwd_letter,String secondPayPwd_letter,
			String newPayPwd_one,String secondPayPwd_two,
			String expectMessage){
		//原支付密码错误
		page_modifyPayPwd.input_oldPayPwd(oldPayPwd_error);
		page_modifyPayPwd.input_newPayPwd(newPayPwd);
		page_modifyPayPwd.input_secondPayPwd(secondPayPwd);
		page_modifyPayPwd.click_enter();
		page_common.sleep(2000);
		page_common.click_backBtn();
		page_common.sleep(2000);
		page_accountSecurity.click_payPassword();
		//新支付密码为数字
		page_modifyPayPwd.input_oldPayPwd(oldPayPwd);
		page_modifyPayPwd.input_newPayPwd(newPayPwd_num);
		page_modifyPayPwd.input_secondPayPwd(secondPayPwd_num);
		page_modifyPayPwd.click_enter();
		page_common.sleep(2000);
		page_common.click_backBtn();
		page_common.sleep(2000);
		page_accountSecurity.click_payPassword();
		//新支付密码为纯字母
		page_modifyPayPwd.input_oldPayPwd(oldPayPwd);
		page_modifyPayPwd.input_newPayPwd(newPayPwd_letter);
		page_modifyPayPwd.input_secondPayPwd(secondPayPwd_letter);
		page_modifyPayPwd.click_enter();
		page_common.sleep(2000);
		page_common.click_backBtn();
		page_common.sleep(2000);
		page_accountSecurity.click_payPassword();
		//两次密码不一致
		page_modifyPayPwd.input_oldPayPwd(oldPayPwd);
		page_modifyPayPwd.input_newPayPwd(newPayPwd_one);
		page_modifyPayPwd.input_secondPayPwd(secondPayPwd_two);
		page_modifyPayPwd.click_enter();
		page_common.sleep(2000);
		page_common.click_backBtn();
		page_common.sleep(2000);
		page_accountSecurity.click_payPassword();
		//正确的情况
		page_modifyPayPwd.input_oldPayPwd(oldPayPwd);
		page_modifyPayPwd.input_newPayPwd(newPayPwd);
		page_modifyPayPwd.input_secondPayPwd(secondPayPwd);
		page_modifyPayPwd.click_enter();	
		handleResult(expectMessage);
	}
	private void handleResult(String expectMessage) {
		switch (expectMessage) {
		case "账户安全":
			String except="账户安全";
			String acturl=page_common.getText_title();
			Assertion.assertEquals(except, acturl, Biz_bindingBankcard.class, "修改支付密码页面");
			break;
		default:
			
			break;
		}
	}
	

}
