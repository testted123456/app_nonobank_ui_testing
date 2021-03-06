package com.nonobank.apps.testcase.nonobankge.registerLogin;

import org.testng.annotations.Test;

import com.nonobank.apps.business.nonobankge.Biz_common;
import com.nonobank.apps.business.nonobankge.Biz_gesturePwd;
import com.nonobank.apps.business.nonobankge.Biz_me;
import com.nonobank.apps.business.nonobankge.Biz_register;
import com.nonobank.apps.business.nonobankge.Biz_setting;
import com.nonobank.apps.testcase.base.BaseCase;

public class Register extends BaseCase{
	Biz_register biz_register;
	Biz_gesturePwd biz_gesturePwd;
	Biz_common biz_common;
	Biz_me biz_me;
	Biz_setting biz_setting;
	
	@Test(dataProvider="dataSource")
	public void test(String testcaseName,String testcaseDescription,
			String environment,String mobile,String pictureVerification,
			String smsCode,String password,
			String gesturePwd,String gesturePwd_again){
		caseName = testcaseName;
		caseDescription = testcaseDescription;
		inputParams = mobile;
		biz_register.register(mobile, pictureVerification, smsCode, password,"注册成功",environment);
		biz_gesturePwd.click_judge();
		biz_common.click_me();
		biz_me.click_settingIcon("设置");
		biz_setting.click_logout("退出");	
	}
	
	
}
