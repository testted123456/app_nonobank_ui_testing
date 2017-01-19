package com.nonobank.apps.testcase.nonobankge.registerLogin;

import org.testng.annotations.Test;

import com.nonobank.apps.business.nonobankge.Biz_common;
import com.nonobank.apps.business.nonobankge.Biz_gesturePwd;
import com.nonobank.apps.business.nonobankge.Biz_login;
import com.nonobank.apps.business.nonobankge.Biz_me;
import com.nonobank.apps.business.nonobankge.Biz_register;
import com.nonobank.apps.business.nonobankge.Biz_setting;
import com.nonobank.apps.testcase.base.BaseCase;



public class Login extends BaseCase{
	Biz_register biz_register;
	Biz_gesturePwd biz_gesturePwd;
	Biz_common biz_common;
	Biz_me biz_me;
	Biz_setting biz_setting;
	Biz_login biz_login;
	@Test(dataProvider="dataSource")
	public void test(String environment,String mobile,String pictureVerification,
			String smsCode,String password){
		biz_register.register(mobile, pictureVerification, smsCode, password,"注册成功",environment);
		biz_gesturePwd.click_judge();
		biz_common.click_me();
		biz_me.click_settingIcon("设置");
		biz_setting.click_logout("退出");
		biz_common.click_me();
		biz_login.login(mobile, password,"注册");
		biz_gesturePwd.click_judge();
		biz_common.click_me();
		biz_me.click_settingIcon("设置");
		biz_setting.click_logout("退出");
			
	}
}
	
