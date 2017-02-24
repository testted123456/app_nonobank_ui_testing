package com.nonobank.apps.testcase.nonobankge.withdraw;

import org.testng.annotations.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.nonobank.apps.business.nonobankge.Biz_common;
import com.nonobank.apps.business.nonobankge.Biz_gesturePwd;
import com.nonobank.apps.business.nonobankge.Biz_me;
import com.nonobank.apps.business.nonobankge.Biz_recharge;
import com.nonobank.apps.business.nonobankge.Biz_register;
import com.nonobank.apps.business.nonobankge.Biz_setting;
import com.nonobank.apps.business.nonobankge.Biz_withdraw;
import com.nonobank.apps.business.nonobankge.Var_recharge;
import com.nonobank.apps.business.nonobankge.Var_register;
import com.nonobank.apps.business.nonobankge.Var_withdraw;
import com.nonobank.apps.interfaces.nonobankge.checkBankCardBinTest;
import com.nonobank.apps.interfaces.nonobankge.degreecardTest;
import com.nonobank.apps.interfaces.nonobankge.generateKQMobileOrderNoByRechargeTest;
import com.nonobank.apps.interfaces.nonobankge.getDynByBindTest;
import com.nonobank.apps.interfaces.nonobankge.getPayGNumByRechargeTest;
import com.nonobank.apps.interfaces.nonobankge.loginTest;
import com.nonobank.apps.interfaces.nonobankge.payRouteTest;
import com.nonobank.apps.interfaces.nonobankge.qucikDynPayTest;
import com.nonobank.apps.interfaces.nonobankge.saveBankCardTest;
import com.nonobank.apps.testcase.base.BaseCase;
import com.nonobank.apps.utils.data.UserInfoUtils;

public class Withdraw extends BaseCase {
	Biz_register biz_register;
	Biz_common biz_common;
	Biz_me biz_me;
	Biz_recharge biz_recharge;
	Biz_withdraw biz_withdraw;
	Biz_gesturePwd biz_gesturePwd;
	Biz_setting biz_setting;

	@Test(dataProvider = "dataSource")
	public void test(String testcaseName, String testcaseDescription, String environment, String mobile,
			String pictureVerification, String smsCode, String password,String idCard,
			String realName, String payPassword, String payPassword_second, String rechargeSum,
			String bankSmsCode,String bankCardNum,String bankName,String bankMobile,
			String smsCode_recharge,String withdrawalAmount) {
		caseName = testcaseName;
		caseDescription = testcaseDescription;
		inputParams = mobile;
		// 注册---注册
		biz_register.register(mobile, pictureVerification, smsCode, password, "注册成功", environment);
		// 点击跳过
		biz_gesturePwd.click_judge();
		// 点击我的
		biz_common.click_me();
		// 我的---点击充值
		biz_me.click_recharge("充值");
		// 充值
		biz_recharge.recharge_noPayPassword(payPassword, payPassword_second, rechargeSum, bankSmsCode,
				bankName, bankCardNum, bankMobile, realName, idCard, smsCode_recharge, "充值");
		// 点击我的
		biz_common.click_me();
		// 我的----提现
		biz_me.click_takecash("提现");
		// 提现----提现流程
		biz_withdraw.withdraw(withdrawalAmount,payPassword,realName, "提现");
		// 退出
		biz_me.click_settingIcon("设置");
		biz_setting.click_logout("退出");
	}

}

// logger.info("------------------------------------------------------------------------------------");
// // 接口---登录
// String username=UserInfoUtils.getUsername(mobile);
// String response_login = loginTest.login(username,
// "d051d170235c6682e334e6a5abd8ebdb", blackBox);
// JSONObject jsonObj_login = JSON.parseObject(response_login);
// String data_login=jsonObj_login.getString("data").toString();
// JSONObject jsonObj_login_data = JSON.parseObject(data_login);
// String sessionId = jsonObj_login_data.get("session_id").toString();
// String userId = jsonObj_login_data.get("m_id").toString();
// // 接口---实名认证
// degreecardTest.degreecard(idCard, realName, sessionId);
// // 接口---设置支付密码
// // savePayPasswordTest.savePayPassword(newZFPwd, sessionId);
// // 接口---检查银行卡bin
// checkBankCardBinTest.checkBankCardBin(bankCardNo, bankCode);
// // 接口---绑卡获取动态码
// String response_getDynByBind =
// getDynByBindTest.degreecard(bankCardNo, bankCode, idCard, userId,
// sessionId,
// bankMobile, realName);
// JSONObject jsonObj_getDynByBind =
// JSON.parseObject(response_getDynByBind);
// String externalRefNumber =
// jsonObj_getDynByBind.get("externalRefNumber").toString();
// String token_bankcard = jsonObj_getDynByBind.get("token").toString();
// // 接口---绑卡
// saveBankCardTest.saveBankCard(bankCardNo, idCard, bankCode,
// token_bankcard, bankMobile, bank_validCode, userId,
// externalRefNumber, sessionId, realName);
// // 接口---支付路由
// String response_payRoute = payRouteTest.payRoute(rechargeMoney,
// bankCode, sessionId);
// JSONObject jsonObj_payRoute = JSON.parseObject(response_payRoute);
// String userBankCardId =
// jsonObj_payRoute.get("userBankCardId").toString();
// // 生成订单号-账号余额充值
// String response_generateKQMobileOrderNoByRecharge =
// generateKQMobileOrderNoByRechargeTest
// .generateKQMobileOrderNoByRecharge(sessionId);
// JSONObject jsonObj_generateKQMobileOrderNoByRecharge = JSON
// .parseObject(response_generateKQMobileOrderNoByRecharge);
// String data_generateKQMobileOrderNoByRecharge =
// jsonObj_generateKQMobileOrderNoByRecharge.get("data")
// .toString();
// JSONObject jsonObj_data_generateKQMobileOrderNoByRecharge = JSON
// .parseObject(data_generateKQMobileOrderNoByRecharge);
// String orderNum =
// jsonObj_data_generateKQMobileOrderNoByRecharge.get("orderNum").toString();
// // 快速支付发送验证码--账号余额充值
// String response_getPayGNumByRecharge =
// getPayGNumByRechargeTest.getPayGNumByRecharge(rechargeMoney,
// payPassword,
// sessionId, userBankCardId, orderNum);
// JSONObject jsonObj_getPayGNumByRecharge =
// JSON.parseObject(response_getPayGNumByRecharge);
// String token_recharge =
// jsonObj_getPayGNumByRecharge.get("token").toString();
// // 快速支付--账号余额充值
// qucikDynPayTest.qucikDynPay(rechargeMoney, token_recharge,
// userBankCardId, recharge_SmsCode, orderNum, sessionId);
// logger.info("------------------------------------------------------------------------------------");
