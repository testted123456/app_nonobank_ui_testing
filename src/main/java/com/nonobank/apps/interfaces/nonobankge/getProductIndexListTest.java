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

public class getProductIndexListTest {
	public static Logger logger = LogManager.getLogger(getProductIndexListTest.class);
	public static List<HashMap<String, String>> params = new ArrayList<HashMap<String, String>>();
	public static String url = "/msapi/user/degreecard";
	
	
	public static String  getProductIndexList(String productType,String max_expect,
			String min_expect,String pageNo,String sessionId,String type,String pageSize){
		HashMap<String, String> requestParams = new HashMap<String, String>();
		requestParams.put("productType", productType);
		requestParams.put("max_expect", max_expect);
		requestParams.put("min_expect", min_expect);
		requestParams.put("pageNo", pageNo);
		requestParams.put("sessionId", sessionId);
		requestParams.put("type", type);
		requestParams.put("pageSize", pageSize);
		String response = SendRequest.httpCommonPost(url, requestParams);
		JSONObject jsonObj2 = JSON.parseObject(response);
		String flag = jsonObj2.get("flag").toString();
		Assertion.assertEquals("1", flag, checkBankCardBinTest.class, "检查银行卡bin");
		return response;	
	}
	
	public static String getProductName(String productType,String max_expect,
			String min_expect,String pageNo,String sessionId,String type,String pageSize){
		String response=getProductIndexList(productType,max_expect,min_expect,pageNo,sessionId,type,pageSize);
		JSONObject jsonObj = JSON.parseObject(response);
		String data=jsonObj.get("data").toString();
		JSONObject jsonObj2 = JSON.parseObject(data);
		String productList=jsonObj2.get("productList").toString();
		JSONObject jsonObj3 = JSON.parseObject(productList);
		String titles=jsonObj3.get("title").toString();
		return titles;
	}
	
	
}
