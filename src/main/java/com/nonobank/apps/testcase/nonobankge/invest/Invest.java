package com.nonobank.apps.testcase.nonobankge.invest;

import org.testng.annotations.Test;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.nonobank.apps.business.nonobankge.Biz_bindingBankcard;
import com.nonobank.apps.business.nonobankge.Biz_common;
import com.nonobank.apps.business.nonobankge.Biz_gesturePwd;
import com.nonobank.apps.business.nonobankge.Biz_investRecord;
import com.nonobank.apps.business.nonobankge.Biz_me;
import com.nonobank.apps.business.nonobankge.Biz_product;
import com.nonobank.apps.business.nonobankge.Biz_productInvest;
import com.nonobank.apps.business.nonobankge.Biz_register;
import com.nonobank.apps.business.nonobankge.Biz_setting;
import com.nonobank.apps.interfaces.nonobankge.FinancePlan;
import com.nonobank.apps.interfaces.nonobankge.getProductIndexListTest;
import com.nonobank.apps.interfaces.nonobankge.loginTest;
import com.nonobank.apps.testcase.base.BaseCase;
import com.nonobank.apps.utils.data.MobileUtil;

public class Invest extends BaseCase {

	Biz_register biz_register;
	Biz_common biz_common;
	Biz_me biz_me;
	Biz_gesturePwd biz_gesturePwd;
	Biz_product biz_product;
	Biz_productInvest biz_productInvest;
	Biz_bindingBankcard biz_bindingBankcard;
	Biz_setting biz_setting;
	Biz_investRecord biz_investRecord;
	
	@Test(dataProvider = "dataSource")
	public void test(String testcaseName, String testcaseDescription, String environment, String mobile,
			String pictureVerification, String smsCode, String password, String idCard, String realName,
			String bankName, String bankCardNum, String bankMobile, String bankSmsCode, String productName,
			String investMoney, String payPwd,String blackBox) {
		caseName = testcaseName;
		caseDescription = testcaseDescription;
		inputParams = mobile;
		// 注册
		biz_register.register(mobile, pictureVerification, smsCode, password, "注册成功", environment);
		// 点击跳过
		biz_gesturePwd.click_judge();
		
		switch (productName) {
		case "月月升":
			FinancePlan.monthRise();
			// 点击投资
			biz_common.click_product();
			biz_product.click_regularInvest();
			break;
		case "新客计划":
			FinancePlan.newPlan();
			// 点击投资
			biz_common.click_product();
			biz_product.click_regularInvest();
			break;
		case "贴心计划":
			FinancePlan.caringPlan();
			// 点击投资
			biz_common.click_product();
			biz_product.click_regularInvest();
			break;
		case "精选计划":
			FinancePlan.featuredPlan();
			// 点击投资
			biz_common.click_product();
			biz_product.click_regularInvest();
			break;
		case "诺诺盈":
			FinancePlan.nonoying();
			// 点击投资
			biz_common.click_product();
			biz_product.click_directInvest();
			break;
		default:
			break;
		}
		// 接口---登录
		String username = MobileUtil.getUserName(mobile);
		String response_login = loginTest.login(username, "d051d170235c6682e334e6a5abd8ebdb", blackBox);
		JSONObject jsonObj_login = JSON.parseObject(response_login);
		String data_login = jsonObj_login.getString("data").toString();
		JSONObject jsonObj_login_data = JSON.parseObject(data_login);
		String sessionId = jsonObj_login_data.get("session_id").toString();
		String userId = jsonObj_login_data.get("m_id").toString();
		//接口---获取可投产品
		String productType="0";
		String max_expect="";
		String min_expect="";
		String pageNo="0";
		String type="";
		String pageSize="20";
		String productTitle=getProductIndexListTest.getProductName(productType,max_expect,min_expect,pageNo,sessionId,type,pageSize,productName);
		System.out.println(productTitle);
		
		
		// 点击产品名称
		biz_product.click_productName(productTitle);
		biz_productInvest.productInvest(investMoney, payPwd, bankSmsCode,bankName, bankCardNum, realName, idCard, bankMobile, productTitle);
		//退出
		biz_common.click_me();
		biz_investRecord.getInvestRecord("计划类");
		biz_common.click_backBtn();
		biz_me.click_settingIcon("设置");
		biz_setting.click_logout("退出");
	}

}
