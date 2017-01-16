package com.nonobank.apps.testcase.nonobankge.realName;

import org.testng.annotations.Test;

import com.nonobank.apps.business.nonobankge.Biz_common;
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
	Biz_me biz_me; 
	Biz_setting biz_setting;
	Biz_realNameAuth biz_realNameAuth;
	
	@Test(dataProvider="dataSource")
	public void test(String mobile,String pictureVerification,String smsCode,String password,
			String realName,String idCard){
		//注册
		biz_register.register(mobile, pictureVerification, smsCode, password,"");
		//点击我的
		biz_common.click_me();
		//点击设置
		biz_me.click_settingIcon("");
		//点击实名认证
		biz_setting.click_realNameAuth("");
		//实名认证
		biz_realNameAuth.realNameAuth(realName, idCard,"");
				
	}
		
}
