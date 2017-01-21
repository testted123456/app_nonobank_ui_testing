package com.nonobank.apps.testcase.nonobankge.recharge;

import org.testng.annotations.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.nonobank.apps.business.nonobankge.Biz_common;
import com.nonobank.apps.business.nonobankge.Biz_gesturePwd;
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
import com.nonobank.apps.utils.data.UserInfoUtils;

public class Recharge extends BaseCase {
	Biz_register biz_register;
	Biz_common biz_common;
	Biz_me biz_me;
	Biz_recharge biz_recharge;
	Biz_gesturePwd biz_gesturePwd;
	
	@Test(dataProvider = "dataSource")
	public void test(String environment,String mobile,String pictureVerification,String smsCode,
			String password,String blackBox,String idCard,String realName,
			String bankCardNo,String bankCode,String bank_validCode,
			String rechargeMoney,String bank_mobile,
			String payPassword,String payPassword_second,String rechargeSum,String recharge_SmsCode) {		
		// 注册---注册
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
		// 接口---设置支付密码
//		savePayPasswordTest.savePayPassword(newZFPwd, sessionId);
		// 接口---检查银行卡bin
//		checkBankCardBinTest.checkBankCardBin(bankCardNo, bankCode);
//		// 接口---绑卡获取动态码
//		String response_getDynByBind = getDynByBindTest.degreecard(bankCardNo, bankCode, idCard, 
//				userId, sessionId,bank_mobile, realName);
//		JSONObject jsonObj_getDynByBind = JSON.parseObject(response_getDynByBind);
//		String externalRefNumber = jsonObj_getDynByBind.get("externalRefNumber").toString();
//		String token_bankcard = jsonObj_getDynByBind.get("token").toString();
//		// 接口---绑卡
//		saveBankCardTest.saveBankCard(bankCardNo, idCard, bankCode, token_bankcard, bank_mobile, bank_validCode, userId,
//				externalRefNumber, sessionId, realName);
		// 点击跳过
		biz_gesturePwd.click_judge();
		//点击我的
		biz_common.click_me();
		//我的----点击充值
		biz_me.click_recharge("充值");
		//充值
		biz_recharge.recharge_noPayPassword(payPassword,payPassword_second,rechargeSum,recharge_SmsCode,"");

	}

}
