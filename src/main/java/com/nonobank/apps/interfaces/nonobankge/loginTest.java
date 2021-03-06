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

public class loginTest {
	public static Logger logger = LogManager.getLogger(loginTest.class);
	public static List<HashMap<String, String>> params = new ArrayList<HashMap<String, String>>();
	public static String url = "/msapi/user/login";
	
	public static String login(String username,String password,String blackBox){
		HashMap<String, String> requestParams = new HashMap<String, String>();
		requestParams.put("password", password);
		requestParams.put("terminal", "5");
		requestParams.put("username", username);
		requestParams.put("version", "4.5.0");
		requestParams.put("blackBox", blackBox);
		String response = SendRequest.httpCommonPost(url, requestParams);
		JSONObject jsonObj2 = JSON.parseObject(response);
		String flag = jsonObj2.get("flag").toString();
		Assertion.assertEquals("1", flag, loginTest.class, "登录");
		return response;
	}
}
