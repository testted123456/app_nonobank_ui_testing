package com.nonobank.apps.testcase.nonobankge.recharge;

import org.testng.annotations.Test;

import com.nonobank.apps.business.nonobankge.Biz_common;
import com.nonobank.apps.business.nonobankge.Biz_gesturePwd;
import com.nonobank.apps.business.nonobankge.Biz_me;
import com.nonobank.apps.business.nonobankge.Biz_recharge;
import com.nonobank.apps.business.nonobankge.Biz_register;
import com.nonobank.apps.business.nonobankge.Biz_setting;
import com.nonobank.apps.testcase.base.BaseCase;

public class Recharge extends BaseCase {
	Biz_register biz_register;
	Biz_common biz_common;
	Biz_me biz_me;
	Biz_recharge biz_recharge;
	Biz_gesturePwd biz_gesturePwd;
	Biz_setting biz_setting;

	@Test(dataProvider = "dataSource")
	public void test(String testcaseName, String testcaseDescription, String environment, String mobile,
			String pictureVerification, String smsCode, String password, String idCard, String realName,
			String bankCardNum, String bankName, String bankMobile, String payPassword, String payPassword_second,
			String rechargeSum, String bankSmsCode, String smsCode_recharge) {
		caseName = testcaseName;
		caseDescription = testcaseDescription;
		inputParams = mobile;
		// 注册---注册
		biz_register.register(mobile, pictureVerification, smsCode, password, "注册成功", environment);
		// 点击跳过
		biz_gesturePwd.click_judge();
		// 点击我的
		biz_common.click_me();
		// 我的---点击充值
		biz_me.click_recharge("充值");
		// 充值
		biz_recharge.recharge_noPayPassword(payPassword, payPassword_second, rechargeSum, bankSmsCode, bankName,
				bankCardNum, bankMobile, realName, idCard, smsCode_recharge, "充值",mobile);
		// 退出
		biz_me.click_settingIcon("设置");
		biz_setting.click_logout("退出");
	}

}
