package com.nonobank.apps.interfaces.nonobankge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.nonobank.apps.interfaces.util.SendRequest;

public class saveBankCardTest {
	public static Logger logger = LogManager.getLogger(saveBankCardTest.class);
	public static List<HashMap<String, String>> params = new ArrayList<HashMap<String, String>>();
	public static String url = "/msapi/quickBill/saveBankCard";
	
	public static String saveBankCard(String bankCardNo,String idCard,String bankcode,
			String token,String mobile,String validCode,String userId,
			String externalRefNumber,String sessionId,String realname){
		HashMap<String, String> requestParams = new HashMap<String, String>();
		requestParams.put("bankCardNo", bankCardNo);
		requestParams.put("idno", idCard);
		requestParams.put("bankcode", bankcode);
		requestParams.put("token", token);
		requestParams.put("mobile", mobile);
		requestParams.put("validCode", validCode);
		requestParams.put("m_id", userId);
		requestParams.put("externalRefNumber", externalRefNumber);
		requestParams.put("sessionId", sessionId);
		requestParams.put("realname", realname);
		String response = SendRequest.httpCommonPost(url, requestParams);
		return response;
	}
	
}
