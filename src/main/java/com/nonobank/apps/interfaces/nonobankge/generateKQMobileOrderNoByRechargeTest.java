package com.nonobank.apps.interfaces.nonobankge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.nonobank.apps.interfaces.util.SendRequest;

public class generateKQMobileOrderNoByRechargeTest {
	public static Logger logger = LogManager.getLogger(generateKQMobileOrderNoByRechargeTest.class);
	public static List<HashMap<String, String>> params = new ArrayList<HashMap<String, String>>();
	public static String url = "/msapi/user/generateKQMobileOrderNo";
	
	public static String generateKQMobileOrderNoByRecharge(String sessionId){
		HashMap<String, String> requestParams = new HashMap<String, String>();
		requestParams.put("terminal", "5");
		requestParams.put("sessionId", sessionId);
		String response = SendRequest.httpCommonPost(url, requestParams);
		return response;
	}
}
