package com.nonobank.apps.testcase.nonobankge.invest;

import org.testng.annotations.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.nonobank.apps.business.nonobankge.Biz_bindingBankcard;
import com.nonobank.apps.business.nonobankge.Biz_common;
import com.nonobank.apps.business.nonobankge.Biz_gesturePwd;
import com.nonobank.apps.business.nonobankge.Biz_me;
import com.nonobank.apps.business.nonobankge.Biz_product;
import com.nonobank.apps.business.nonobankge.Biz_productInvest;
import com.nonobank.apps.business.nonobankge.Biz_register;
import com.nonobank.apps.interfaces.nonobankge.bankCard;
import com.nonobank.apps.interfaces.nonobankge.degreecardTest;
import com.nonobank.apps.interfaces.nonobankge.loginTest;
import com.nonobank.apps.interfaces.nonobankge.savePayPasswordTest;
import com.nonobank.apps.testcase.base.BaseCase;
import com.nonobank.apps.utils.data.UserInfoUtils;

public class Invest extends BaseCase {

	Biz_register biz_register;
	Biz_common biz_common;
	Biz_me biz_me;
	Biz_gesturePwd biz_gesturePwd;
	Biz_product biz_product;
	Biz_productInvest biz_productInvest;
	Biz_bindingBankcard biz_bindingBankcard;

	@Test(dataProvider = "dataSource")
	public void test(String testcaseName,String testcaseDescription,String environment,
			String mobile,String pictureVerification,String smsCode,String password,
			String idCard,String realName,String bankName,String bankCardNum,
			String bankMobile,String bankSmsCode,
			String productName,String investMoney,String payPwd) {
		caseName = testcaseName;
		caseDescription = testcaseDescription;
		inputParams = mobile;
		// 注册
		biz_register.register(mobile, pictureVerification, smsCode, password, "注册成功", environment);
		// 点击跳过
		biz_gesturePwd.click_judge();
		// 点击我的
		biz_common.click_me();
		// 点击银行卡管理
		biz_me.click_bankcard("银行卡管理");
		// 绑定银行卡
		biz_bindingBankcard.bindingBankcard(bankName,bankCardNum,realName,idCard,bankMobile,bankSmsCode,"我的银行卡");
		//点击投资
		biz_common.click_product();
		//点击定投
		biz_product.click_regularInvest();
		//点击产品名称
		biz_product.click_productName(productName);
		biz_productInvest.productInvest(investMoney,payPwd,bankSmsCode,productName);
		

	}

}
