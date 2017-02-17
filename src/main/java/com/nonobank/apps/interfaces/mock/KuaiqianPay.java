package com.nonobank.apps.interfaces.mock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.nonobank.apps.interfaces.util.SendRequest;
import com.nonobank.apps.utils.data.BankCardUtils;


public class KuaiqianPay {
	public static Logger logger = LogManager.getLogger(KuaiqianPay.class);
	public static List<HashMap<String, String>> params = new ArrayList<HashMap<String, String>>();
	public static String url = "192.168.1.41:8080/kuaiqian-pay/SetInterface";
	
	public static String bindingBankcard(){
		HashMap<String, String> requestParams = new HashMap<String, String>();
		requestParams.put("inter", "QueryTxn");
		
		String response = SendRequest.httpCommonPostByAbsoluteUrl(url, requestParams);
		return response;	
	}
	public static String pay(){
		HashMap<String, String> requestParams = new HashMap<String, String>();
		requestParams.put("inter", "QueryTxn");
		
		String response = SendRequest.httpCommonPostByAbsoluteUrl(url, requestParams);
		return response;
	}
	
	
}
