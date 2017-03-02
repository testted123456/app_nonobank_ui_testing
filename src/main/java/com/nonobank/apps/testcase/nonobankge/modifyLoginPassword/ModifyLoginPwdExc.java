package com.nonobank.apps.testcase.nonobankge.modifyLoginPassword;

import org.testng.annotations.Test;
import com.nonobank.apps.business.nonobankge.Biz_accountSecurity;
import com.nonobank.apps.business.nonobankge.Biz_common;
import com.nonobank.apps.business.nonobankge.Biz_gesturePwd;
import com.nonobank.apps.business.nonobankge.Biz_me;
import com.nonobank.apps.business.nonobankge.Biz_modifyLoginPassword;
import com.nonobank.apps.business.nonobankge.Biz_register;
import com.nonobank.apps.business.nonobankge.Biz_setting;
import com.nonobank.apps.testcase.base.BaseCase;

public class ModifyLoginPwdExc extends BaseCase{

	Biz_register biz_register;
	Biz_common biz_common;
	Biz_me biz_me;
	Biz_setting biz_setting;
	Biz_accountSecurity biz_accountSecurity;
	Biz_gesturePwd biz_gesturePwd;
	Biz_modifyLoginPassword biz_modifyLoginPassword;

	@Test(dataProvider = "dataSource")
	public void test(String testcaseName,String testcaseDescription,
			String environment,String mobile,String pictureVerification,
			String smsCode,String password,String oldPassword,String newPassword,
			String ensurePassword,String oldPassword_error,String newPassword_error,
			String ensurePassword_error,String ensurePassword_exc) {
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
		//点击账户安全
		biz_setting.click_securityAccount("账户安全");
		//点击登录密码
		biz_accountSecurity.click_loginPassword("修改登录密码");
		//修改登录密码
		biz_modifyLoginPassword.modifyLoginPwdExc(oldPassword_error, oldPassword, newPassword_error,
				newPassword, ensurePassword_error, ensurePassword, ensurePassword_exc, "账户安全");
		//退出
		biz_common.click_backBtn();
		biz_setting.click_logout("退出");
	}

	
	
	
	
	
	
	
}
