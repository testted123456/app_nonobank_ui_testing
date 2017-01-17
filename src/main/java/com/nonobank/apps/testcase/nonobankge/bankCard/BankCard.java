package com.nonobank.apps.testcase.nonobankge.bankCard;

import org.testng.annotations.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.nonobank.apps.business.nonobankge.Biz_bindingBankcard;
import com.nonobank.apps.business.nonobankge.Biz_common;
import com.nonobank.apps.business.nonobankge.Biz_me;
import com.nonobank.apps.business.nonobankge.Biz_register;
import com.nonobank.apps.business.nonobankge.Biz_setting;
import com.nonobank.apps.business.nonobankge.Var_bindingBankcard;
import com.nonobank.apps.business.nonobankge.Var_register;
import com.nonobank.apps.interfaces.nonobankge.degreecardTest;
import com.nonobank.apps.interfaces.nonobankge.loginTest;
import com.nonobank.apps.testcase.base.BaseCase;

public class BankCard extends BaseCase {
	Biz_register biz_register;
	Biz_common biz_common;
	Biz_me biz_me;
	Biz_bindingBankcard biz_bindingBankcard;
	Biz_setting biz_setting;

	@Test(dataProvider = "dataSource")
	public void test(String mobile, String pictureVerification, String smsCode, String password, String bankName,
			String bankCardNum, String bankMobile, String bankSmsCode, String bankLimitPrompt, String username,
			String blackBox, String idCard, String realName) {
		// 注册
		biz_register.register(mobile, pictureVerification, smsCode, password, "");
		// 实名认证--接口
		// 接口---登录
		String response_login = loginTest.login(username, password, blackBox);
		JSONObject jsonObj_login = JSON.parseObject(response_login);
		String sessionId = jsonObj_login.get("session_id").toString();
		String userId = jsonObj_login.get("m_id").toString();
		// 接口---实名认证
		degreecardTest.degreecard(idCard, realName, sessionId);
		// 点击我的
		biz_common.click_me();
		// 点击银行卡管理
		biz_me.click_bankcard("");
		// 绑定银行卡
		biz_bindingBankcard.bindingBankcard(bankName, bankCardNum, bankMobile, bankSmsCode, bankLimitPrompt, "");
	}

}
