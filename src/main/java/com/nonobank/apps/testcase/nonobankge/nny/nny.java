package com.nonobank.apps.testcase.nonobankge.nny;

import org.testng.annotations.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.nonobank.apps.business.nonobankge.Biz_common;
import com.nonobank.apps.business.nonobankge.Biz_me;
import com.nonobank.apps.business.nonobankge.Biz_product;
import com.nonobank.apps.business.nonobankge.Biz_productInvest;
import com.nonobank.apps.business.nonobankge.Biz_productList;
import com.nonobank.apps.business.nonobankge.Biz_register;
import com.nonobank.apps.business.nonobankge.Var_productInvest;
import com.nonobank.apps.business.nonobankge.Var_productList;
import com.nonobank.apps.business.nonobankge.Var_register;
import com.nonobank.apps.interfaces.nonobankge.checkBankCardBinTest;
import com.nonobank.apps.interfaces.nonobankge.degreecardTest;
import com.nonobank.apps.interfaces.nonobankge.generateKQMobileOrderNoByRechargeTest;
import com.nonobank.apps.interfaces.nonobankge.getDynByBindTest;
import com.nonobank.apps.interfaces.nonobankge.getPayGNumByRechargeTest;
import com.nonobank.apps.interfaces.nonobankge.loginTest;
import com.nonobank.apps.interfaces.nonobankge.payRouteTest;
import com.nonobank.apps.interfaces.nonobankge.qucikDynPayTest;
import com.nonobank.apps.interfaces.nonobankge.saveBankCardTest;
import com.nonobank.apps.interfaces.nonobankge.savePayPasswordTest;
import com.nonobank.apps.testcase.base.BaseCase;

public class nny extends BaseCase{
	Biz_register biz_register;
	Biz_common biz_common;
	Biz_me biz_me;
	Biz_product biz_product;
	Biz_productList biz_productList;
	Biz_productInvest biz_productInvest;
	
	@Test(dataProvider = "dataSource")
	public void test(String testcaseName,String testcaseDescription,
			String environment,String mobile,String pictureVerification,
			String smsCode,String username,
			String password,String blackBox,
			String idCard,String realName,String newZFPwd,String bankCardNo,
			String bankCode,String validCode,String rechargeMoney,String bankSmsCode,
			String productName,String payPassword) {	
		caseName = testcaseName;
		caseDescription = testcaseDescription;
		inputParams = mobile;
		// 注册---注册
		biz_register.register(mobile, pictureVerification, smsCode, password,"",environment);
		System.out.println("-----------------------------------------------------------------------------------");	
		//接口---登录
		String response_login=loginTest.login(username, password, blackBox);
		JSONObject jsonObj_login=JSON.parseObject(response_login);
		String sessionId = jsonObj_login.get("session_id").toString();
		String userId = jsonObj_login.get("m_id").toString();
		//接口---实名认证
		degreecardTest.degreecard(idCard, realName, sessionId);
		//接口---设置支付密码
		savePayPasswordTest.savePayPassword(newZFPwd, sessionId);
		//接口---检查银行卡bin
		checkBankCardBinTest.checkBankCardBin(bankCardNo,bankCode);
		//接口---绑卡获取动态码
		String response_getDynByBind=getDynByBindTest.degreecard(bankCardNo,bankCode,idCard,userId,sessionId,mobile,realName);
		JSONObject jsonObj_getDynByBind=JSON.parseObject(response_getDynByBind);
		String externalRefNumber=jsonObj_getDynByBind.get("externalRefNumber").toString();
		String token_bankcard=jsonObj_getDynByBind.get("token").toString();
		//接口---绑卡
		saveBankCardTest.saveBankCard(bankCardNo,idCard,bankCode,token_bankcard,mobile,validCode,userId,externalRefNumber,sessionId,realName);
		//接口---支付路由
		String response_payRoute=payRouteTest.payRoute(rechargeMoney, bankCode, sessionId);
		JSONObject jsonObj_payRoute=JSON.parseObject(response_payRoute);
		String userBankCardId=jsonObj_payRoute.get("userBankCardId").toString();
		//生成订单号-账号余额充值
		String response_generateKQMobileOrderNoByRecharge=generateKQMobileOrderNoByRechargeTest.generateKQMobileOrderNoByRecharge(sessionId);
		JSONObject jsonObj_generateKQMobileOrderNoByRecharge=JSON.parseObject(response_generateKQMobileOrderNoByRecharge);
		String data_generateKQMobileOrderNoByRecharge=jsonObj_generateKQMobileOrderNoByRecharge.get("data").toString();
		JSONObject jsonObj_data_generateKQMobileOrderNoByRecharge=JSON.parseObject(data_generateKQMobileOrderNoByRecharge);
		String orderNum=jsonObj_data_generateKQMobileOrderNoByRecharge.get("orderNum").toString();
		//快速支付发送验证码--账号余额充值
		String response_getPayGNumByRecharge=getPayGNumByRechargeTest.getPayGNumByRecharge(rechargeMoney, newZFPwd, sessionId, userBankCardId, orderNum);
		JSONObject jsonObj_getPayGNumByRecharge=JSON.parseObject(response_getPayGNumByRecharge);
		String token_recharge=jsonObj_getPayGNumByRecharge.get("token").toString();
		//快速支付--账号余额充值
		qucikDynPayTest.qucikDynPay(rechargeMoney, token_recharge, userBankCardId, bankSmsCode, orderNum, sessionId);
		System.out.println("-----------------------------------------------------------------------------------");	

		// 点击产品
		biz_common.click_product();
		// 产品---诺诺盈
	
		//贴心计划---根据产品名点击相应计划
		biz_productList.click_byProductName(productName,"");
		//产品购买
	
	}
	
}
