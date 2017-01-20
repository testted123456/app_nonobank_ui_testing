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


public class registerTest {
	public static Logger logger = LogManager.getLogger(registerTest.class);
	public static List<HashMap<String, String>> params = new ArrayList<HashMap<String, String>>();
	public static String url = "/msapi/user/register";
	
	public static String register(String smsCode,String phone,String smscodeSessionId){
		HashMap<String, String> requestParams = new HashMap<String, String>();
		requestParams.put("borrowtype", "学生");
		requestParams.put("validatemobile", smsCode);
		requestParams.put("password", "d051d170235c6682e334e6a5abd8ebdb");
		requestParams.put("terminal","13");
		requestParams.put("mobile", phone);
		requestParams.put("approach2", "5.5.0");
		requestParams.put("approach", "mxd_andorid");
		requestParams.put("sessionId", smscodeSessionId);
		requestParams.put("am_id", "719");
		String response = SendRequest.httpCommonPost(url, requestParams);
		JSONObject jsonObj2 = JSON.parseObject(response);
		String flag = jsonObj2.get("flag").toString();
		Assertion.assertEquals("1", flag, registerTest.class, "注册");
		return response;
	}
	
}
