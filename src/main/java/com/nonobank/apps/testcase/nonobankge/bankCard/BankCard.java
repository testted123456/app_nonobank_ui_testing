package com.nonobank.apps.testcase.nonobankge.bankCard;

import org.testng.annotations.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.nonobank.apps.business.nonobankge.Biz_bindingBankcard;
import com.nonobank.apps.business.nonobankge.Biz_common;
import com.nonobank.apps.business.nonobankge.Biz_gesturePwd;
import com.nonobank.apps.business.nonobankge.Biz_me;
import com.nonobank.apps.business.nonobankge.Biz_register;
import com.nonobank.apps.business.nonobankge.Biz_setting;
import com.nonobank.apps.business.nonobankge.Var_bindingBankcard;
import com.nonobank.apps.business.nonobankge.Var_register;
import com.nonobank.apps.interfaces.nonobankge.bankCard;
import com.nonobank.apps.interfaces.nonobankge.degreecardTest;
import com.nonobank.apps.interfaces.nonobankge.loginTest;
import com.nonobank.apps.testcase.base.BaseCase;
import com.nonobank.apps.utils.data.UserInfoUtils;

public class BankCard extends BaseCase {
	Biz_register biz_register;
	Biz_common biz_common;
	Biz_me biz_me;
	Biz_bindingBankcard biz_bindingBankcard;
	Biz_setting biz_setting;
	Biz_gesturePwd biz_gesturePwd;

	@Test(dataProvider = "dataSource")
	public void test(String environment,String mobile, String pictureVerification, String smsCode,
			String password, String bankName,String bankCardNum, String bankMobile, String bankSmsCode, 
			String bankLimitPrompt,String blackBox,String idCard,String realName) {
		// 注册
		biz_register.register(mobile, pictureVerification, smsCode, password,"注册成功",environment);		
		// 接口---登录
		String username=UserInfoUtils.getUsername(mobile);
		String response_login = loginTest.login(username, "d051d170235c6682e334e6a5abd8ebdb", blackBox);
		JSONObject jsonObj_login = JSON.parseObject(response_login);
		String data_login=jsonObj_login.getString("data").toString();
		JSONObject jsonObj_login_data = JSON.parseObject(data_login);
		String sessionId = jsonObj_login_data.get("session_id").toString();
		String userId = jsonObj_login_data.get("m_id").toString();
		// 接口---实名认证
		degreecardTest.degreecard(idCard, realName, sessionId);
		// 点击跳过
		biz_gesturePwd.click_judge();
		// 点击我的
		biz_common.click_me();
		// 点击银行卡管理
		biz_me.click_bankcard("银行卡管理");
		// 绑定银行卡
//		biz_bindingBankcard.bindingBankcard(bankName, bankCardNum, bankMobile, bankSmsCode, bankLimitPrompt, "");
		String bankCode="1";
		bankCard.bindingBankCard(userId, bankCardNum, bankCode);
	}

}
