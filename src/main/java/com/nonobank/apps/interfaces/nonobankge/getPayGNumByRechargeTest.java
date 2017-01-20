package com.nonobank.apps.interfaces.nonobankge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.nonobank.apps.interfaces.util.SendRequest;
import com.nonobank.apps.utils.data.Assertion;

public class getPayGNumByRechargeTest {
	public static Logger logger = LogManager.getLogger(getPayGNumByRechargeTest.class);
	public static List<HashMap<String, String>> params = new ArrayList<HashMap<String, String>>();
	public static String url = "/msapi/quickBill/getPayGNum";
	
	public static String getPayGNumByRecharge(String rechargeMoney,String newZFPwd,String sessionId,
			String userBankCardId,String orderNum){
		HashMap<String, String> requestParams = new HashMap<String, String>();
		requestParams.put("address", "");
		requestParams.put("receiver", "");
		requestParams.put("count", rechargeMoney);
		requestParams.put("sessionId", sessionId);
		requestParams.put("payMode", "1");
		requestParams.put("interest", "");
		requestParams.put("terminal", "5");
		requestParams.put("coupon", "");
		requestParams.put("key", "1");
		requestParams.put("paypassword", newZFPwd);
		requestParams.put("bankid", userBankCardId);
		requestParams.put("paycode", "2");
		requestParams.put("externalRefNumber", orderNum);
		requestParams.put("mobileNum", "");
		requestParams.put("type", "");
		String response = SendRequest.httpCommonPost(url, requestParams);
		JSONObject jsonObj2 = JSON.parseObject(response);
		String flag = jsonObj2.get("flag").toString();
		Assertion.assertEquals("1", flag, getPayGNumByRechargeTest.class, "快速支付发送验证码--账号余额充值");
		return response;
	}
}
