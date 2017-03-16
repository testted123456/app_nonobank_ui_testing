package com.nonobank.apps.business.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.nonobank.apps.checkPoint.nono.BankcardCheck;
import com.nonobank.apps.page.nonobankge.Page_bindingBankcard;
import com.nonobank.apps.page.nonobankge.Page_common;
import com.nonobank.apps.page.nonobankge.Page_me;
import com.nonobank.apps.utils.data.Assertion;

public class Biz_bindingBankcard {
	public static Logger logger = LogManager.getLogger(Biz_bindingBankcard.class);
	Page_bindingBankcard page_bindingBankcard=new Page_bindingBankcard();
	Page_common page_common=new Page_common();
	Page_me page_me=new Page_me();
	
	public void bindingBankcard(String bankName,String bankCardNum,
			String realName,String idCard,String bankMobile,
			String bankSmsCode,String expectMessage,String mobile){
		logger.info("[Biz_绑定银行卡]");
		System.out.println("-------------------------------------------------");
		page_bindingBankcard.click_selectBank();
		page_bindingBankcard.sleep(1000);
		while(!page_bindingBankcard.isExist_bankName(bankName)){
			page_bindingBankcard.swipe_bankSelect();
		}
		page_bindingBankcard.select_bank(bankName);
		page_bindingBankcard.sleep(1000);
		page_bindingBankcard.input_bankCardNum(bankCardNum);
		page_bindingBankcard.sleep(1000);
		page_bindingBankcard.click_nextStep();
		page_bindingBankcard.sleep(1000);
		page_bindingBankcard.click_nextStep();
		page_bindingBankcard.sleep(1000);
		
		page_bindingBankcard.input_userRealName(realName);
		page_bindingBankcard.sleep(1000);
		page_bindingBankcard.input_userIdCard(idCard);
		page_bindingBankcard.sleep(1000);
		page_bindingBankcard.input_bankMobile(bankMobile);
		page_bindingBankcard.sleep(1000);
		page_bindingBankcard.click_getSmsCode();
		page_bindingBankcard.sleep(1000);
		page_bindingBankcard.input_bankSmsCode(bankSmsCode);
		page_bindingBankcard.sleep(1000);
		page_bindingBankcard.click_nextStep();
		//绑卡-数据库检查
		BankcardCheck.verify_bankcard(mobile);
		handleResult(expectMessage,realName);
		System.out.println("-------------------------------------------------");
	}
	public void bindingBankcardFirstRealName(String bankName,String bankCardNum,String realName,
			String bankMobile,String bankSmsCode,String expectMessage,String mobile){
		logger.info("[Biz_绑定银行卡]");
		System.out.println("-------------------------------------------------");
		page_bindingBankcard.click_selectBank();
		page_bindingBankcard.sleep(1000);
		while(!page_bindingBankcard.isExist_bankName(bankName)){
			page_bindingBankcard.swipe_bankSelect();
		}
		page_bindingBankcard.select_bank(bankName);
		page_bindingBankcard.sleep(1000);
		page_bindingBankcard.input_bankCardNum(bankCardNum);
		page_bindingBankcard.sleep(1000);
		page_bindingBankcard.click_nextStep();
		page_bindingBankcard.sleep(1000);
		page_bindingBankcard.click_nextStep();
		page_bindingBankcard.sleep(1000);
		
		page_bindingBankcard.input_bankMobile(bankMobile);
		page_bindingBankcard.sleep(1000);
		page_bindingBankcard.click_getSmsCode();
		page_bindingBankcard.sleep(1000);
		page_bindingBankcard.input_bankSmsCode(bankSmsCode);
		page_bindingBankcard.sleep(1000);
		page_bindingBankcard.click_nextStep();
		page_bindingBankcard.sleep(5000);
		//绑卡-数据库检查
		BankcardCheck.verify_bankcard(mobile);
		handleResult(expectMessage,realName);
		System.out.println("-------------------------------------------------");
	}
	public void bankCardExc(String bankName_notBank,String bankCardNum_notBank,
			String bankCardNum_error,String bankName,String bankCardNum,
			String realName,String idCard,String bankMobile,
			String bankSmsCode,String expectMessage,String mobile){
		logger.info("[Biz_绑定银行卡]");
		System.out.println("-------------------------------------------------");
		//只输入银行卡号码
		page_bindingBankcard.input_bankCardNum(bankCardNum);
		page_bindingBankcard.sleep(1000);
		page_bindingBankcard.click_nextStep();
		page_bindingBankcard.sleep(1000);
		page_bindingBankcard.click_nextStep();
		page_bindingBankcard.sleep(1000);
		page_common.click_backBtn();
		page_me.click_bankcard();
		page_bindingBankcard.sleep(1000);
		//银行卡与银行不是一个
//		page_bindingBankcard.click_selectBank();
//		page_bindingBankcard.sleep(1000);
//		while(!page_bindingBankcard.isExist_bankName(bankName_notBank)){
//			page_bindingBankcard.swipe_bankSelect();
//		}
//		page_bindingBankcard.select_bank(bankName_notBank);
//		page_bindingBankcard.sleep(1000);
//		page_bindingBankcard.input_bankCardNum(bankCardNum_notBank);
//		page_bindingBankcard.sleep(1000);
//		page_bindingBankcard.click_nextStep();
//		page_bindingBankcard.sleep(1000);
//		page_bindingBankcard.click_nextStep();
//		page_bindingBankcard.sleep(1000);
//		page_common.click_backBtn();
//		page_me.click_bankcard();
		//银行卡号码不准确
//		page_bindingBankcard.click_selectBank();
//		page_bindingBankcard.sleep(1000);
//		while(!page_bindingBankcard.isExist_bankName(bankName_notBank)){
//			page_bindingBankcard.swipe_bankSelect();
//		}
//		page_bindingBankcard.select_bank(bankName_notBank);
//		page_bindingBankcard.sleep(1000);
//		page_bindingBankcard.input_bankCardNum(bankCardNum_error);
//		page_bindingBankcard.sleep(1000);
//		page_bindingBankcard.click_nextStep();
//		page_bindingBankcard.sleep(1000);
//		page_bindingBankcard.click_nextStep();
//		page_bindingBankcard.sleep(1000);
//		page_common.click_backBtn();
//		page_me.click_bankcard();
//		page_bindingBankcard.sleep(1000);
		//正确的情况
		page_bindingBankcard.click_selectBank();
		page_bindingBankcard.sleep(1000);
		while(!page_bindingBankcard.isExist_bankName(bankName)){
			page_bindingBankcard.swipe_bankSelect();
		}
		page_bindingBankcard.select_bank(bankName);
		page_bindingBankcard.sleep(1000);
		page_bindingBankcard.input_bankCardNum(bankCardNum);
		page_bindingBankcard.sleep(1000);
		page_bindingBankcard.click_nextStep();
		page_bindingBankcard.sleep(1000);
		page_bindingBankcard.click_nextStep();
		page_bindingBankcard.sleep(1000);
		
		
		page_bindingBankcard.input_userRealName(realName);
		page_bindingBankcard.sleep(1000);
		page_bindingBankcard.input_userIdCard(idCard);
		page_bindingBankcard.sleep(1000);
		page_bindingBankcard.input_bankMobile(bankMobile);
		page_bindingBankcard.sleep(1000);
		page_bindingBankcard.click_getSmsCode();
		page_bindingBankcard.sleep(1000);
		page_bindingBankcard.input_bankSmsCode(bankSmsCode);
		page_bindingBankcard.sleep(1000);
		page_bindingBankcard.click_nextStep();
		//绑卡-数据库检查
		BankcardCheck.verify_bankcard(mobile);
		handleResult(expectMessage,realName);
	}
	private void handleResult(String expectMessage,String realName) {
		switch (expectMessage) {
		case "我的银行卡":
			String expect="您好，"+realName;
			String actual=page_me.getText_userName();
			Assertion.assertEquals(expect, actual, Biz_bindingBankcard.class, "绑卡成功");
			break;
		default:
			expect="设置银行卡";
			actual=page_common.getText_title();
			Assertion.assertEquals(expect, actual, Biz_bindingBankcard.class, "绑卡失败");
			break;
		}
	}
	
}
