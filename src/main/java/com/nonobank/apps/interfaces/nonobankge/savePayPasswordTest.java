package com.nonobank.apps.interfaces.nonobankge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.nonobank.apps.interfaces.util.SendRequest;

public class savePayPasswordTest {
	public static Logger logger = LogManager.getLogger(savePayPasswordTest.class);
	public static List<HashMap<String, String>> params = new ArrayList<HashMap<String, String>>();
	public static String url = "/msapi/user/savePayPassword";
	
	public static String savePayPassword(String newZFPwd,String sessionId){
		HashMap<String, String> requestParams = new HashMap<String, String>();
		requestParams.put("newZFPwd", newZFPwd);
		requestParams.put("sessionId", sessionId);
		String response = SendRequest.httpCommonPost(url, requestParams);
		return response;
	}
	
}
