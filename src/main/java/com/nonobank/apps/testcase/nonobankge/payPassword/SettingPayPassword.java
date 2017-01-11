package com.nonobank.apps.testcase.nonobankge.payPassword;

import org.testng.annotations.Test;

import com.nonobank.apps.business.nonobankge.Biz_accountSecurity;
import com.nonobank.apps.business.nonobankge.Biz_common;
import com.nonobank.apps.business.nonobankge.Biz_me;
import com.nonobank.apps.business.nonobankge.Biz_register;
import com.nonobank.apps.business.nonobankge.Biz_setPayPassword;
import com.nonobank.apps.business.nonobankge.Biz_setting;
import com.nonobank.apps.business.nonobankge.Var_register;
import com.nonobank.apps.business.nonobankge.Var_setPayPassword;
import com.nonobank.apps.testcase.base.BaseCase;

public class SettingPayPassword extends BaseCase{
	Biz_register biz_register;
	Biz_common biz_common;
	Biz_me biz_me;
	Biz_setting biz_setting;
	Biz_accountSecurity biz_accountSecurity;
	Biz_setPayPassword biz_setPayPassword;
	
	@Test(dataProvider="dataSource")
	public void test(String mobile,String pictureVerification,String smsCode,String password,
			String payPassword,String payPassword_second){
		//注册---注册
		biz_register.register(mobile, pictureVerification, smsCode, password);
		//点击我
		biz_common.click_me();
		//我的---点击设置
		biz_me.click_settingIcon();
		//设置---点击账户安全
		biz_setting.click_securityAccount();
		//账户安全---点击支付密码
		biz_accountSecurity.click_payPassword();
		//设置支付密码----设置支付密码
		biz_setPayPassword.setPayPassword(payPassword, payPassword_second);
		
	}
	
}
