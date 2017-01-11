package com.nonobank.apps.business.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.nonobank.apps.page.nonobankge.Page_realNameAuth;

public class Biz_realNameAuth {
	public static Logger logger = LogManager.getLogger(Biz_realNameAuth.class);
	Page_realNameAuth page_realNameAuth=new Page_realNameAuth();
	
	public void realNameAuth(String realName,String idCard){
		logger.info("[Biz_实名认证]");
		System.out.println("-------------------------------------------------");
		page_realNameAuth.input_realName(realName);
		page_realNameAuth.input_idCard(idCard);
		String prompt=page_realNameAuth.getText_prompt();
		Assert.assertEquals(prompt, "个人信息一旦确认将不可更改");
		page_realNameAuth.click_auth();
		page_realNameAuth.sleep(2000);
		String real_Name=page_realNameAuth.getText_CPM_realName();
		Assert.assertEquals(real_Name, realName);
		String id_Card=page_realNameAuth.getText_CPM_idCard();
		Assert.assertEquals(id_Card, idCard);
		page_realNameAuth.click_CPM_enter();
		System.out.println("-------------------------------------------------");
	}
	
	
	
	
}
