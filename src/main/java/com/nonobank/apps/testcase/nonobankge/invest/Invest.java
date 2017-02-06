package com.nonobank.apps.testcase.nonobankge.invest;

import org.testng.annotations.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.nonobank.apps.business.nonobankge.Biz_common;
import com.nonobank.apps.business.nonobankge.Biz_gesturePwd;
import com.nonobank.apps.business.nonobankge.Biz_me;
import com.nonobank.apps.business.nonobankge.Biz_product;
import com.nonobank.apps.business.nonobankge.Biz_productInvest;
import com.nonobank.apps.business.nonobankge.Biz_register;
import com.nonobank.apps.interfaces.nonobankge.degreecardTest;
import com.nonobank.apps.interfaces.nonobankge.loginTest;
import com.nonobank.apps.testcase.base.BaseCase;
import com.nonobank.apps.utils.data.UserInfoUtils;

public class Invest extends BaseCase {

	Biz_register biz_register;
	Biz_common biz_common;
	Biz_me biz_me;
	Biz_gesturePwd biz_gesturePwd;
	Biz_product biz_product;
	Biz_productInvest biz_productInvest;

	@Test(dataProvider = "dataSource")
	public void test(String testcaseName,String testcaseDescription,String environment,
			String mobile,String pictureVerification,
			String smsCode,String password,String blackBox,String idCard,String realName,
			String productName,String investMoney,String payPwd,String bankSmsCode) {
		caseName = testcaseName;
		caseDescription = testcaseDescription;
		inputParams = mobile;
		// 注册
		biz_register.register(mobile, pictureVerification, smsCode, password, "注册成功", environment);
		// 接口---登录
		String username = UserInfoUtils.getUsername(mobile);
		String response_login = loginTest.login(username, "d051d170235c6682e334e6a5abd8ebdb", blackBox);
		JSONObject jsonObj_login = JSON.parseObject(response_login);
		String data_login = jsonObj_login.getString("data").toString();
		JSONObject jsonObj_login_data = JSON.parseObject(data_login);
		String sessionId = jsonObj_login_data.get("session_id").toString();
		String userId = jsonObj_login_data.get("m_id").toString();
		// 接口---实名认证
		degreecardTest.degreecard(idCard, realName, sessionId);
		//接口----绑卡
		
		
		// 点击跳过
		biz_gesturePwd.click_judge();
		//点击投资
		biz_common.click_product();
		//点击定投
		biz_product.click_regularInvest();
		//点击产品名称
		biz_product.click_productName(productName);
		biz_productInvest.productInvest(investMoney,payPwd,bankSmsCode,"");
		

	}

}
