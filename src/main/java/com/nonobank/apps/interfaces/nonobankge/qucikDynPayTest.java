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

public class qucikDynPayTest {
	public static Logger logger = LogManager.getLogger(qucikDynPayTest.class);
	public static List<HashMap<String, String>> params = new ArrayList<HashMap<String, String>>();
	public static String url = "/msapi/quickBill/qucikDynPay";
	
	public static String qucikDynPay(String rechargeMoney,String token_recharge,String userBankCardId,
			String bankSmsCode,String orderNum,String sessionId){
		HashMap<String, String> requestParams = new HashMap<String, String>();
		requestParams.put("amount", rechargeMoney);
		requestParams.put("terminal", "5");
		requestParams.put("token", token_recharge);
		requestParams.put("payid", sessionId);
		requestParams.put("bankid", userBankCardId);
		requestParams.put("validCode", bankSmsCode);
		requestParams.put("count", rechargeMoney);
		requestParams.put("externalRefNumber", orderNum);
		requestParams.put("sessionId", sessionId);
		requestParams.put("type", "");
		String response = SendRequest.httpCommonPost(url, requestParams);
		JSONObject jsonObj2 = JSON.parseObject(response);
		String flag = jsonObj2.get("flag").toString();
		Assertion.assertEquals("1", flag, qucikDynPayTest.class, "快速支付--账号余额充值");
		return response;
	}
}
