package com.nonobank.apps.interfaces.nonobankge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.nonobank.apps.interfaces.util.SendRequest;



public class getSessionIdTest {
	
	public static Logger logger = LogManager.getLogger(getSessionIdTest.class);
	public static List<HashMap<String, String>> params = new ArrayList<HashMap<String, String>>();
	public static String url = "/msapi/user/getSessionId";
	
	public static String getImgSessionId(){
		String response = SendRequest.httpCommonGet(url);
		JSONObject jsonObj = JSON.parseObject(response);
		String data = jsonObj.get("data").toString();
		JSONObject jsonObj2 = JSON.parseObject(data);
		String imgSessionId=jsonObj2.get("session_id").toString();
		return imgSessionId;
	}
	
	
}
