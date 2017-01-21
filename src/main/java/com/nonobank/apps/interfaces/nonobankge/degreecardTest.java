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

public class degreecardTest {
	public static Logger logger = LogManager.getLogger(degreecardTest.class);
	public static List<HashMap<String, String>> params = new ArrayList<HashMap<String, String>>();
	public static String url = "/msapi/user/degreecard";
	
	public static String degreecard(String idCard,String realName,String sessionId){
		HashMap<String, String> requestParams = new HashMap<String, String>();
		requestParams.put("myCard", idCard);
		requestParams.put("myName", realName);
		requestParams.put("sessionId", sessionId);
		String response = SendRequest.httpCommonPost(url, requestParams);
		JSONObject jsonObj2 = JSON.parseObject(response);
		String flag = jsonObj2.get("flag").toString();
		Assertion.assertEquals("8", flag, degreecardTest.class, "实名认证");
		return response;
	}
	
}
