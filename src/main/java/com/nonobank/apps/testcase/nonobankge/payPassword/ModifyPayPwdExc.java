package com.nonobank.apps.testcase.nonobankge.payPassword;

import org.testng.annotations.Test;

import com.nonobank.apps.business.nonobankge.Biz_accountSecurity;
import com.nonobank.apps.business.nonobankge.Biz_common;
import com.nonobank.apps.business.nonobankge.Biz_gesturePwd;
import com.nonobank.apps.business.nonobankge.Biz_me;
import com.nonobank.apps.business.nonobankge.Biz_modifyPayPwd;
import com.nonobank.apps.business.nonobankge.Biz_register;
import com.nonobank.apps.business.nonobankge.Biz_setPayPassword;
import com.nonobank.apps.business.nonobankge.Biz_setting;
import com.nonobank.apps.testcase.base.BaseCase;

public class ModifyPayPwdExc extends BaseCase{

	Biz_register biz_register;
	Biz_common biz_common;
	Biz_me biz_me;
	Biz_setting biz_setting;
	Biz_accountSecurity biz_accountSecurity;
	Biz_setPayPassword biz_setPayPassword;
	Biz_gesturePwd biz_gesturePwd;
	Biz_modifyPayPwd biz_modifyPayPwd;
	
	@Test(dataProvider="dataSource")
	public void test(String testcaseName,String testcaseDescription,
			String environment,String mobile,String pictureVerification,
			String smsCode,String password,String payPassword,
			String payPassword_second,String newPayPwd,String secondPayPwd,
			String oldPayPwd_error,String newPayPwd_num,String secondPayPwd_num,
			String newPayPwd_letter,String secondPayPwd_letter,
			String newPayPwd_one,String secondPayPwd_two){
		caseName = testcaseName;
		caseDescription = testcaseDescription;
		inputParams = mobile;
		//注册---注册
		biz_register.register(mobile, pictureVerification, smsCode, password,"注册成功",environment);
		// 点击跳过
		biz_gesturePwd.click_judge();
		//点击我
		biz_common.click_me();
		//我的---点击设置
		biz_me.click_settingIcon("设置");
		//设置---点击账户安全
		biz_setting.click_securityAccount("账户安全");
		//账户安全---点击支付密码
		biz_accountSecurity.click_payPassword("设置支付密码");
		//设置支付密码----设置支付密码
		biz_setPayPassword.setPayPassword(payPassword, payPassword_second,"账户安全",mobile);
		//账户安全---点击支付密码
		biz_accountSecurity.click_payPassword("修改支付密码");
		//修改支付密码
		biz_modifyPayPwd.modifyPayPwdExc(payPassword, newPayPwd, secondPayPwd, 
				oldPayPwd_error, newPayPwd_num, secondPayPwd_num,
				newPayPwd_letter, secondPayPwd_letter, newPayPwd_one, secondPayPwd_two, "账户安全");
		//点击返回
		biz_common.click_backBtn();
		biz_setting.click_logout("退出");
		
	}
	
}
