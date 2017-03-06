package com.nonobank.apps.testcase.nonobankge.withdraw;

import org.testng.annotations.Test;

import com.nonobank.apps.business.nonobankge.Biz_common;
import com.nonobank.apps.business.nonobankge.Biz_gesturePwd;
import com.nonobank.apps.business.nonobankge.Biz_me;
import com.nonobank.apps.business.nonobankge.Biz_recharge;
import com.nonobank.apps.business.nonobankge.Biz_register;
import com.nonobank.apps.business.nonobankge.Biz_setting;
import com.nonobank.apps.business.nonobankge.Biz_withdraw;
import com.nonobank.apps.testcase.base.BaseCase;

public class WithdrawExc extends BaseCase{
	
	Biz_register biz_register;
	Biz_common biz_common;
	Biz_me biz_me;
	Biz_recharge biz_recharge;
	Biz_withdraw biz_withdraw;
	Biz_gesturePwd biz_gesturePwd;
	Biz_setting biz_setting;

	@Test(dataProvider = "dataSource")
	public void test(String testcaseName, String testcaseDescription, String environment, String mobile,
			String pictureVerification, String smsCode, String password,String idCard,
			String realName, String payPassword, String payPassword_second, String rechargeSum,
			String bankSmsCode,String bankCardNum,String bankName,String bankMobile,
			String smsCode_recharge,String withdrawalAmount_lower,String withdrawalAmount_more) {
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
		biz_recharge.recharge_noPayPassword(payPassword, payPassword_second, rechargeSum, bankSmsCode,
				bankName, bankCardNum, bankMobile, realName, idCard, smsCode_recharge, "充值");
		// 点击我的
		biz_common.click_me();
		// 我的----提现
		biz_me.click_takecash("提现");
		// 提现----提现流程
		biz_withdraw.withdrawExc(withdrawalAmount_lower,withdrawalAmount_more,payPassword_second,realName, "提现");
		// 退出
		biz_me.click_settingIcon("设置");
		biz_setting.click_logout("退出");
	}
	
	
	

}
