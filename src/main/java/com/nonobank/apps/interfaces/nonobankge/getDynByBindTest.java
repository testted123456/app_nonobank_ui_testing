package com.nonobank.apps.interfaces.nonobankge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.nonobank.apps.interfaces.util.SendRequest;

public class getDynByBindTest {
	public static Logger logger = LogManager.getLogger(degreecardTest.class);
	public static List<HashMap<String, String>> params = new ArrayList<HashMap<String, String>>();
	public static String url = "/msapi/quickBill/getDynByBind";
	
	public static String degreecard(String bankCardNo,String bankCode,String idCard,
			String userId,String sessionId,String mobile,String realname){
		HashMap<String, String> requestParams = new HashMap<String, String>();
		requestParams.put("bankCardNo", bankCardNo);
		requestParams.put("bankCode", bankCode);
		requestParams.put("idno", idCard);
		requestParams.put("m_id", userId);
		requestParams.put("sessionId", sessionId);
		requestParams.put("mobile", mobile);
		requestParams.put("realname", realname);
		String response = SendRequest.httpCommonPost(url, requestParams);
		return response;
	}
}
