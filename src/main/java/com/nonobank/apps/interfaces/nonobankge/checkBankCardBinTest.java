package com.nonobank.apps.interfaces.nonobankge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.nonobank.apps.interfaces.util.SendRequest;

public class checkBankCardBinTest {
	public static Logger logger = LogManager.getLogger(checkBankCardBinTest.class);
	public static List<HashMap<String, String>> params = new ArrayList<HashMap<String, String>>();
	public static String url = "/msapi/user/degreecard";
	
	public static String checkBankCardBin(String bankCardNo,String bankCode){
		HashMap<String, String> requestParams = new HashMap<String, String>();
		requestParams.put("bankCardNo", bankCardNo);
		requestParams.put("bankCode", bankCode);
		String response = SendRequest.httpCommonPost(url, requestParams);
		return response;
	}
}
