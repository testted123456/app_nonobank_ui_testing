package com.nonobank.apps.interfaces.mock;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.nonobank.apps.interfaces.util.SendRequest;



public class KuaiqianPay {
	public static Logger logger = LogManager.getLogger(KuaiqianPay.class);	
	
	public static String bindingBankcard(){
		String url = "192.168.1.41:8080/kuaiqian-pay/SetInterfaces?inter=QueryTxn&num=00";
		String response = SendRequest.httpCommonGet(url);
		return response;	
	}
	public static String pay(){
		String url = "192.168.1.41:8080/kuaiqian-pay/SetInterfaces?inter=QueryTxn&num=0003";
		String response = SendRequest.httpCommonGet(url);
		return response;
	}
	
	
}
