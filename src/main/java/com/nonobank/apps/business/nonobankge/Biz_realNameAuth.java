package com.nonobank.apps.business.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.nonobank.apps.page.nonobankge.Page_realNameAuth;

public class Biz_realNameAuth {
	public static Logger logger = LogManager.getLogger(Biz_realNameAuth.class);
	Page_realNameAuth page_realNameAuth=new Page_realNameAuth();
	
	public void realNameAuth(Var_realNameAuth var_realNameAuth){
		page_realNameAuth.input_realName(var_realNameAuth.getRealName());
		page_realNameAuth.input_idCard(var_realNameAuth.getIdCard());
		String prompt=page_realNameAuth.getText_prompt();
		Assert.assertEquals(prompt, "个人信息一旦确认将不可更改");
		page_realNameAuth.click_auth();
		page_realNameAuth.sleep(2000);
		String realName=page_realNameAuth.getText_CPM_realName();
		Assert.assertEquals(realName, var_realNameAuth.getRealName());
		String idCard=page_realNameAuth.getText_CPM_idCard();
		Assert.assertEquals(idCard, var_realNameAuth.getIdCard());
		page_realNameAuth.click_CPM_enter();
	}
	
	
	
	
}
