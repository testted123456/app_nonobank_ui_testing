package com.nonobank.apps.testcase.nonobankge.recharge;

import org.testng.annotations.Test;

import com.nonobank.apps.business.nonobankge.Biz_accountSecurity;
import com.nonobank.apps.business.nonobankge.Biz_bindingBankcard;
import com.nonobank.apps.business.nonobankge.Biz_common;
import com.nonobank.apps.business.nonobankge.Biz_gesturePwd;
import com.nonobank.apps.business.nonobankge.Biz_me;
import com.nonobank.apps.business.nonobankge.Biz_recharge;
import com.nonobank.apps.business.nonobankge.Biz_register;
import com.nonobank.apps.business.nonobankge.Biz_setPayPassword;
import com.nonobank.apps.business.nonobankge.Biz_setting;
import com.nonobank.apps.interfaces.mock.KuaiqianPay;
import com.nonobank.apps.testcase.base.BaseCase;

public class RechargeFirstBankCard extends BaseCase {
	Biz_register biz_register;
	Biz_common biz_common;
	Biz_me biz_me;
	Biz_recharge biz_recharge;
	Biz_gesturePwd biz_gesturePwd;
	Biz_setting biz_setting;
	Biz_accountSecurity biz_accountSecurity;
	Biz_setPayPassword biz_setPayPassword;
	Biz_bindingBankcard biz_bindingBankcard;

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
		// 我的---点击设置
		biz_me.click_settingIcon("设置");
		// 设置---点击账户安全
		biz_setting.click_securityAccount("账户安全");
		// 账户安全---点击支付密码
		biz_accountSecurity.click_payPassword("设置支付密码");
		// 设置支付密码----设置支付密码
		biz_setPayPassword.setPayPassword(payPassword,payPassword_second,"账户安全");
		// 点击返回
		biz_common.click_backBtn();
		// 点击返回
		biz_common.click_backBtn();
		// 点击银行卡管理
		biz_me.click_bankcard("银行卡管理");
		KuaiqianPay.bindingBankcard();
		// 绑定银行卡
		biz_bindingBankcard.bindingBankcard(bankName,bankCardNum,realName,idCard,bankMobile,bankSmsCode,"我的银行卡");
		// 我的---点击充值
		biz_me.click_recharge("充值");
		// 充值
		biz_recharge.recharge_firstBankCard(payPassword,rechargeSum,realName,smsCode_recharge,"充值");
		// 退出
		biz_me.click_settingIcon("设置");
		biz_setting.click_logout("退出");
	}
}
