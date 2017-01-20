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

public class payRouteTest {
	public static Logger logger = LogManager.getLogger(payRouteTest.class);
	public static List<HashMap<String, String>> params = new ArrayList<HashMap<String, String>>();
	public static String url = "/msapi/route/payRoute";
	
	public static String payRoute(String rechargeMoney,String bankCode,String sessionId){
		HashMap<String, String> requestParams = new HashMap<String, String>();
		requestParams.put("money", rechargeMoney);
		requestParams.put("terminal", "5");
		requestParams.put("bankCode", bankCode);
		requestParams.put("sessionId", sessionId);
		String response = SendRequest.httpCommonPost(url, requestParams);
		JSONObject jsonObj2 = JSON.parseObject(response);
		String flag = jsonObj2.get("flag").toString();
		Assertion.assertEquals("1", flag, payRouteTest.class, "支付路由");
		return response;
	}
}
