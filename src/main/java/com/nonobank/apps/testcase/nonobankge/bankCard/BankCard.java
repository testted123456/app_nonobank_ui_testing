package com.nonobank.apps.testcase.nonobankge.bankCard;

import org.testng.annotations.Test;
import com.nonobank.apps.business.nonobankge.Biz_bindingBankcard;
import com.nonobank.apps.business.nonobankge.Biz_common;
import com.nonobank.apps.business.nonobankge.Biz_gesturePwd;
import com.nonobank.apps.business.nonobankge.Biz_me;
import com.nonobank.apps.business.nonobankge.Biz_register;
import com.nonobank.apps.business.nonobankge.Biz_setting;
import com.nonobank.apps.interfaces.mock.KuaiqianPay;
import com.nonobank.apps.testcase.base.BaseCase;


public class BankCard extends BaseCase {
	Biz_register biz_register;
	Biz_common biz_common;
	Biz_me biz_me;
	Biz_bindingBankcard biz_bindingBankcard;
	Biz_setting biz_setting;
	Biz_gesturePwd biz_gesturePwd;

	@Test(dataProvider = "dataSource")
	public void test(String testcaseName,String testcaseDescription,String environment,String mobile,
			String pictureVerification, String smsCode,
			String password, String bankName,String bankCardNum, String bankMobile, String bankSmsCode, 
			String bankLimitPrompt,String blackBox,String idCard,String realName) {
		caseName = testcaseName;
		caseDescription = testcaseDescription;
		inputParams = mobile;
		// 注册
		biz_register.register(mobile, pictureVerification, smsCode, password,"注册成功",environment);		
		// 点击跳过
		biz_gesturePwd.click_judge();
		// 点击我的
		biz_common.click_me();
		// 点击银行卡管理
		biz_me.click_bankcard("银行卡管理");
		KuaiqianPay.bindingBankcard();
		// 绑定银行卡
		biz_bindingBankcard.bindingBankcard(bankName,bankCardNum,realName,idCard,bankMobile,bankSmsCode,"我的银行卡");
		//退出
		biz_me.click_settingIcon("设置");
		biz_setting.click_logout("退出");
	}

}
