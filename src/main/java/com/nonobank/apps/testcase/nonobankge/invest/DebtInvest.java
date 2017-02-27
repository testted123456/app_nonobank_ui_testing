package com.nonobank.apps.testcase.nonobankge.invest;

import org.testng.annotations.Test;
import com.nonobank.apps.business.nonobankge.Biz_bindingBankcard;
import com.nonobank.apps.business.nonobankge.Biz_common;
import com.nonobank.apps.business.nonobankge.Biz_debt;
import com.nonobank.apps.business.nonobankge.Biz_gesturePwd;
import com.nonobank.apps.business.nonobankge.Biz_me;
import com.nonobank.apps.business.nonobankge.Biz_product;
import com.nonobank.apps.business.nonobankge.Biz_productInvest;
import com.nonobank.apps.business.nonobankge.Biz_register;
import com.nonobank.apps.business.nonobankge.Biz_setting;
import com.nonobank.apps.testcase.base.BaseCase;

public class DebtInvest extends BaseCase {
	Biz_register biz_register;
	Biz_common biz_common;
	Biz_me biz_me;
	Biz_gesturePwd biz_gesturePwd;
	Biz_product biz_product;
	Biz_productInvest biz_productInvest;
	Biz_bindingBankcard biz_bindingBankcard;
	Biz_setting biz_setting;
	Biz_debt biz_debt;
	
	@Test(dataProvider = "dataSource")
	public void test(String testcaseName, String testcaseDescription, String environment, String mobile,
			String pictureVerification, String smsCode, String password, String idCard, String realName,
			String bankName, String bankCardNum, String bankMobile, String bankSmsCode,String payPwd) {
		caseName = testcaseName;
		caseDescription = testcaseDescription;
		inputParams = mobile;
		// 注册
		biz_register.register(mobile, pictureVerification, smsCode, password, "注册成功", environment);
		// 点击跳过
		biz_gesturePwd.click_judge();
		biz_common.click_product();
		biz_product.click_debtEquity();
		biz_debt.debtInvest(payPwd, bankName, bankCardNum, realName, idCard, bankMobile, bankSmsCode);
		// 退出
		biz_common.click_me();
		biz_me.click_settingIcon("设置");
		biz_setting.click_logout("退出");
	}

}
