package com.nonobank.apps.interfaces.mxd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.nonobank.apps.interfaces.util.SendRequest;
import com.nonobank.apps.utils.data.IdCardGenerator;
import com.nonobank.apps.utils.data.UserInfoUtils;


public class authenticateSchoolRollTest {
	public static Logger logger = LogManager.getLogger(authenticateSchoolRollTest.class);
	public static List<HashMap<String, String>> params = new ArrayList<HashMap<String, String>>();
	public static String url = "https://openapi.sit.nonobank.com/nono-web/app5/authenticateSchoolRoll";
	IdCardGenerator IdCardGenerator=new IdCardGenerator();
	
	public void dataProvider(){
		String phone=UserInfoUtils.getUnregisterMobile();
		String imgSessionId=getSessionIdTest.getImgSessionId();
		String smscodeSessionId=sendMessageByValidateCodeTest.getSmscodeSessionId(imgSessionId, phone);
		String smsCode=sendMessageByValidateCodeTest.getSmsCode(imgSessionId, phone);
		String userId=registerTest.getUserId(smsCode, phone, smscodeSessionId);
		String idCard=IdCardGenerator.generateUnUsedIdCardNumberByAge("22");
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("userId", userId);
		jsonObj.put("college", "复旦大学");
		jsonObj.put("entranceYear", "2015");
		jsonObj.put("idNumber", idCard);
		jsonObj.put("name", "韩诺");
		jsonObj.put("schoolRoll", "本科");
		HashMap<String, String> requsetParams = new HashMap<String, String>();
		requsetParams.put("request", jsonObj.toJSONString());
		params.add(requsetParams);
	}
	@Test
	public void test(){
		dataProvider();
		for (int i = 0; i < params.size(); i++) {
			String response =SendRequest.httpCommonPostByAbsoluteUrl(url, params.get(i));
			logger.info("响应消息：" + response);
			JSONObject jsonObj = JSON.parseObject(response);

			Assert.assertEquals("1", jsonObj.get("flag"));
		}
	}
	
	public static void authenticateSchoolRoll(String userId,String idCard){
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("userId", userId);
		jsonObj.put("college", "复旦大学");
		jsonObj.put("entranceYear", "2015");
		jsonObj.put("idNumber", idCard);
		jsonObj.put("name", "韩诺");
		jsonObj.put("schoolRoll", "本科");
		HashMap<String, String> requsetParams = new HashMap<String, String>();
		requsetParams.put("request", jsonObj.toJSONString());
		params.add(requsetParams);
		SendRequest.httpCommonPostByAbsoluteUrl(url, requsetParams);
	}
	
	
	
}
