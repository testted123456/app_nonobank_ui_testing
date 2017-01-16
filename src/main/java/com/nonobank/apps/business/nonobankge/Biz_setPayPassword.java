package com.nonobank.apps.business.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.nonobank.apps.page.nonobankge.Page_common;
import com.nonobank.apps.page.nonobankge.Page_setPayPassword;
import com.nonobank.apps.utils.data.Assertion;

public class Biz_setPayPassword {
	public static Logger logger = LogManager.getLogger(Biz_setPayPassword.class);
	
	Page_setPayPassword page_setPayPassword=new Page_setPayPassword();
	Page_common page_common=new Page_common();
	
	public void setPayPassword(String payPassword,String payPassword_second,String expectMessage){
		logger.info("[Biz]设置支付密码。。。。。。");
		System.out.println("------------------------------------------------");
		page_setPayPassword.input_password(payPassword);
		page_setPayPassword.sleep(2000);
		page_setPayPassword.input_confirmPassword(payPassword_second);
		page_setPayPassword.sleep(2000);
		page_setPayPassword.click_confirm();
		String title=page_common.getText_title();
		Assert.assertEquals(title, "账户安全");
		handleResult(expectMessage);
		System.out.println("------------------------------------------------");
	}
	private void handleResult(String expectMessage) {
		switch (expectMessage) {
		case "我的银行卡":
			String expect="我的银行卡";
			String actual=page_common.getText_title();
			Assertion.assertEquals(expect, actual, Biz_bindingBankcard.class, "绑卡成功");
			break;
		default:
			expect="设置银行卡";
			actual=page_common.getText_title();
			Assertion.assertEquals(expect, actual, Biz_bindingBankcard.class, "绑卡失败");
			break;
		}
	}
}
