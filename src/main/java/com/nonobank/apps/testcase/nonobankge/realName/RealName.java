package com.nonobank.apps.testcase.nonobankge.realName;

import org.testng.annotations.Test;

import com.nonobank.apps.business.nonobankge.Biz_common;
import com.nonobank.apps.business.nonobankge.Biz_gesturePwd;
import com.nonobank.apps.business.nonobankge.Biz_me;
import com.nonobank.apps.business.nonobankge.Biz_realNameAuth;
import com.nonobank.apps.business.nonobankge.Biz_register;
import com.nonobank.apps.business.nonobankge.Biz_setting;
import com.nonobank.apps.business.nonobankge.Var_realNameAuth;
import com.nonobank.apps.business.nonobankge.Var_register;
import com.nonobank.apps.testcase.base.BaseCase;

public class RealName extends BaseCase{
	Biz_register biz_register;
	Biz_common biz_common;
	Biz_gesturePwd biz_gesturePwd;
	Biz_me biz_me; 
	Biz_setting biz_setting;
	Biz_realNameAuth biz_realNameAuth;
	
	@Test(dataProvider="dataSource")
	public void test(String testcaseName,String testcaseDescription,
			String environment,String mobile,String pictureVerification,
			String smsCode,String password,String realName,String idCard){
		caseName = testcaseName;
		caseDescription = testcaseDescription;
		inputParams = mobile;
		biz_register.register(mobile, pictureVerification, smsCode, password,"注册成功",environment);
		biz_gesturePwd.click_judge();
		//点击我的
		biz_common.click_me();
		//点击设置
		biz_me.click_settingIcon("设置");
		//点击实名认证
		biz_setting.click_realNameAuth("实名认证");
		//实名认证
		biz_realNameAuth.realNameAuth(realName, idCard,"实名认证");
		biz_common.click_backBtn();
		biz_common.click_me();
		biz_me.click_settingIcon("设置");
		biz_setting.click_logout("退出");
				
	}
		
}
