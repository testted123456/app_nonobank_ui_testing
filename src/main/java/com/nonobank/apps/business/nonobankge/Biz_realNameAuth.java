package com.nonobank.apps.business.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.nonobank.apps.checkPoint.nono.RealNameCheck;
import com.nonobank.apps.page.nonobankge.Page_common;
import com.nonobank.apps.page.nonobankge.Page_realNameAuth;
import com.nonobank.apps.page.nonobankge.Page_setting;
import com.nonobank.apps.utils.data.Assertion;

public class Biz_realNameAuth {
	public static Logger logger = LogManager.getLogger(Biz_realNameAuth.class);
	Page_realNameAuth page_realNameAuth=new Page_realNameAuth();
	Page_common page_common=new Page_common();
	Page_setting page_setting=new Page_setting();
	
	public void realNameAuth(String realName,String idCard,String expectMessage,String mobile){
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
		//实名认证-数据库检查
		RealNameCheck.verify_realName(mobile);
		handleResult(expectMessage);
		System.out.println("-------------------------------------------------");
	}
	public void realNameAuthExc(String realName,String idCard_error,String idCard_exist,
			String idCard,String expectMessage,String mobile){

		logger.info("[Biz_实名认证]");
		page_realNameAuth.click_auth();
		page_realNameAuth.sleep(1000);
		page_realNameAuth.input_realName(realName);
		page_realNameAuth.click_auth();
		page_realNameAuth.sleep(1000);
		page_realNameAuth.input_idCard(idCard_error);
		page_realNameAuth.sleep(1000);
		page_realNameAuth.click_auth();
		page_realNameAuth.sleep(1000);
		String prompt=page_realNameAuth.getText_CPM_prompt();
		Assert.assertEquals(prompt, "身份证号码格式不对,请仔细核查");
		page_realNameAuth.sleep(1000);
		page_realNameAuth.click_CPM_gotoModify();
		page_realNameAuth.sleep(1000);
		page_common.click_backBtn();
		page_realNameAuth.sleep(1000);
		page_setting.click_realNameAuth();
		page_realNameAuth.sleep(1000);
		page_realNameAuth.input_realName(realName);
		page_realNameAuth.sleep(1000);
		page_realNameAuth.input_idCard(idCard_exist);
		page_realNameAuth.sleep(1000);
		page_realNameAuth.click_auth();
		page_realNameAuth.sleep(1000);
		page_realNameAuth.click_CPM_enter();
		page_realNameAuth.sleep(1000);
		String prompt3=page_realNameAuth.getText_CPM_prompt();
		Assert.assertEquals(prompt3, "该身份证号码已经存在，如果您已注册，请联系客服找回用户名和密码");
		page_realNameAuth.sleep(1000);
		page_realNameAuth.click_CPM_gotoModify();
		page_realNameAuth.sleep(1000);
		page_common.click_backBtn();
		page_realNameAuth.sleep(1000);
		page_setting.click_realNameAuth();
		page_realNameAuth.sleep(1000);
		page_realNameAuth.input_realName(realName);
		page_realNameAuth.sleep(1000);
		page_realNameAuth.input_idCard(idCard);
		page_realNameAuth.click_auth();
		page_realNameAuth.sleep(2000);
		page_realNameAuth.click_CPM_enter();
		//实名认证-数据库检查
		RealNameCheck.verify_realName(mobile);
		handleResult(expectMessage);	
	}
	private void handleResult(String expectMessage) {
		switch (expectMessage) {
		case "实名认证":
			String expect="设置";
			String actual=page_common.getText_title();
			Assertion.assertEquals(expect, actual, Biz_realNameAuth.class, "实名认证成功");
			break;
		default:
			break;
		}
	}
	
	
	
}
