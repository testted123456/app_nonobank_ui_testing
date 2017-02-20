package com.nonobank.apps.testcase.nonobankge.modifyMobile;

import org.testng.annotations.Test;

import com.nonobank.apps.business.nonobankge.Biz_accountSecurity;
import com.nonobank.apps.business.nonobankge.Biz_common;
import com.nonobank.apps.business.nonobankge.Biz_gesturePwd;
import com.nonobank.apps.business.nonobankge.Biz_me;
import com.nonobank.apps.business.nonobankge.Biz_modifyMobile;
import com.nonobank.apps.business.nonobankge.Biz_realNameAuth;
import com.nonobank.apps.business.nonobankge.Biz_register;
import com.nonobank.apps.business.nonobankge.Biz_setPayPassword;
import com.nonobank.apps.business.nonobankge.Biz_setting;
import com.nonobank.apps.testcase.base.BaseCase;

public class ModifyMobileByRealName extends BaseCase{
	Biz_register biz_register;
	Biz_common biz_common;
	Biz_me biz_me;
	Biz_setting biz_setting;
	Biz_accountSecurity biz_accountSecurity;
	Biz_setPayPassword biz_setPayPassword;
	Biz_gesturePwd biz_gesturePwd;
	Biz_modifyMobile biz_modifyMobile;
	Biz_realNameAuth biz_realNameAuth;

	@Test(dataProvider = "dataSource")
	public void test(String testcaseName,String testcaseDescription,
			String environment,String mobile,String pictureVerification,
			String smsCode,String password,String newMobile,String smsCode2,
			String realName,String idCard) {
		caseName = testcaseName;
		caseDescription = testcaseDescription;
		inputParams = mobile;
		// 注册---注册
		biz_register.register(mobile, pictureVerification, smsCode, password, "注册成功", environment);
		// 点击跳过
		biz_gesturePwd.click_judge();
		// 点击我
		biz_common.click_me();
		// 我的---点击设置
		biz_me.click_settingIcon("设置");
		//点击实名认证
		biz_setting.click_realNameAuth("实名认证");
		//实名认证
		biz_realNameAuth.realNameAuth(realName, idCard,"实名认证");
		// 设置---点击绑定手机
		biz_setting.click_bindingMobile("设置");
		//更换绑定手机号码
		biz_modifyMobile.modifyMobile(mobile, password, newMobile, smsCode2, "设置");
		//退出
		biz_setting.click_logout("退出");
	}

	
}
