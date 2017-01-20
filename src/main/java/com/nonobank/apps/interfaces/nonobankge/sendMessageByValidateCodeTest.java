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

public class sendMessageByValidateCodeTest {
	public static Logger logger = LogManager.getLogger(sendMessageByValidateCodeTest.class);
	public static List<HashMap<String, String>> params = new ArrayList<HashMap<String, String>>();
	public static String url = "/msapi/user/sendMessageByValidateCode";
	
	public static String sendMessageByValidateCode(String imgSessionId,String phone){
		String sms_type="4";
		String black_box="";
		String validateCode="0615";
		HashMap<String, String> requestParams = new HashMap<String, String>();
		requestParams.put("sessionId", imgSessionId);
		requestParams.put("phone", phone);
		requestParams.put("sms_type", sms_type);
		requestParams.put("black_box", black_box);
		requestParams.put("validateCode", validateCode);
		String response = SendRequest.httpCommonPost(url, requestParams);
		JSONObject jsonObj2 = JSON.parseObject(response);
		String flag = jsonObj2.get("flag").toString();
		Assertion.assertEquals("1", flag, sendMessageByValidateCodeTest.class, "发送短信验证码");
		return response;
	}
	
}
