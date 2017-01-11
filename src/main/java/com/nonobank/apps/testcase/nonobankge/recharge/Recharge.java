package com.nonobank.apps.testcase.nonobankge.recharge;

import org.testng.annotations.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.nonobank.apps.business.nonobankge.Biz_common;
import com.nonobank.apps.business.nonobankge.Biz_me;
import com.nonobank.apps.business.nonobankge.Biz_recharge;
import com.nonobank.apps.business.nonobankge.Biz_register;
import com.nonobank.apps.business.nonobankge.Var_recharge;
import com.nonobank.apps.business.nonobankge.Var_register;
import com.nonobank.apps.interfaces.nonobankge.checkBankCardBinTest;
import com.nonobank.apps.interfaces.nonobankge.degreecardTest;
import com.nonobank.apps.interfaces.nonobankge.getDynByBindTest;
import com.nonobank.apps.interfaces.nonobankge.loginTest;
import com.nonobank.apps.interfaces.nonobankge.saveBankCardTest;
import com.nonobank.apps.interfaces.nonobankge.savePayPasswordTest;
import com.nonobank.apps.testcase.base.BaseCase;

public class Recharge extends BaseCase {
	Biz_register biz_register;
	Biz_common biz_common;
	Biz_me biz_me;
	Biz_recharge biz_recharge;
	
	@Test(dataProvider = "dataSource")
	public void test(String mobile,String username,String password,String blackBox,
			String idCard,String realName,String newZFPwd,String bankCardNo,
			String bankCode,String validCode,String rechargeMoney,String bankSmsCode,
			String pictureVerification,String smsCode,String payPassword,
			String payPassword_second,String rechargeSum) {		
		// 注册---注册
		biz_register.register(mobile, pictureVerification, smsCode, password);
		// 接口---登录
		String response_login = loginTest.login(username, password, blackBox);
		JSONObject jsonObj_login = JSON.parseObject(response_login);
		String sessionId = jsonObj_login.get("session_id").toString();
		String userId = jsonObj_login.get("m_id").toString();
		// 接口---实名认证
		degreecardTest.degreecard(idCard, realName, sessionId);
		// 接口---设置支付密码
//		savePayPasswordTest.savePayPassword(newZFPwd, sessionId);
		// 接口---检查银行卡bin
		checkBankCardBinTest.checkBankCardBin(bankCardNo, bankCode);
		// 接口---绑卡获取动态码
		String response_getDynByBind = getDynByBindTest.degreecard(bankCardNo, bankCode, idCard, userId, sessionId,
				mobile, realName);
		JSONObject jsonObj_getDynByBind = JSON.parseObject(response_getDynByBind);
		String externalRefNumber = jsonObj_getDynByBind.get("externalRefNumber").toString();
		String token_bankcard = jsonObj_getDynByBind.get("token").toString();
		// 接口---绑卡
		saveBankCardTest.saveBankCard(bankCardNo, idCard, bankCode, token_bankcard, mobile, validCode, userId,
				externalRefNumber, sessionId, realName);
		//点击我的
		biz_common.click_me();
		//我的----点击充值
		biz_me.click_recharge();
		//充值
		biz_recharge.recharge_noPayPassword(payPassword, payPassword_second, rechargeSum, bankSmsCode);

	}

}
