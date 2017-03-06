package com.nonobank.apps.business.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.nonobank.apps.page.nonobankge.Page_common;
import com.nonobank.apps.page.nonobankge.Page_me;
import com.nonobank.apps.page.nonobankge.Page_withdrawal;
import com.nonobank.apps.utils.data.Assertion;

public class Biz_withdraw {
	public static Logger logger = LogManager.getLogger(Biz_withdraw.class);
	Page_withdrawal page_withdrawal=new Page_withdrawal(); 
	Page_common page_common=new Page_common();
	Page_me page_me=new Page_me();
	
	public void withdraw(String withdrawalAmount,String payPassword,
			String realName,String expectMessage){
		logger.info("[Biz_提现]");
		System.out.println("-------------------------------------------------");
		double withdrawal_amount=page_withdrawal.getText_withdrawal_amount();
		page_withdrawal.input_withdrawal_amount(withdrawalAmount);
		page_withdrawal.sleep(1000);
		double fee=page_withdrawal.getText_poundage();
		double actual_account=page_withdrawal.getText_actual_account();
		Assert.assertEquals(fee+actual_account, Double.parseDouble(withdrawalAmount));
		page_withdrawal.click_withdrawal();
		page_withdrawal.sleep(2000);
		double withdrawalMoney=page_withdrawal.getText_CPM_withdrawalMoney();
		Assert.assertEquals(withdrawalMoney,Double.parseDouble(withdrawalAmount));
		page_withdrawal.input_CPM_payPassword(payPassword);
		page_withdrawal.click_CPM_enter();
		handleResult(expectMessage,realName);
		System.out.println("-------------------------------------------------");
	}
	public void withdrawExc(String withdrawalAmount_lower,String withdrawalAmount_more,
			String payPassword,String realName,String expectMessage){
		logger.info("[Biz_提现异常]");
		//输入提现金额为1元
		page_withdrawal.input_withdrawal_amount(withdrawalAmount_lower);
		page_withdrawal.sleep(1000);
		page_withdrawal.click_withdrawal();
		page_withdrawal.sleep(1000);
		//输入提现金额大于可提现金额
		page_withdrawal.input_withdrawal_amount(withdrawalAmount_more);
		page_withdrawal.sleep(1000);
		page_withdrawal.click_withdrawal();
		page_withdrawal.sleep(1000);
		page_withdrawal.input_CPM_payPassword(payPassword);
		page_withdrawal.click_CPM_enter();
		handleResult(expectMessage,realName);
		
	}
	private void handleResult(String expectMessage,String realName) {
		switch (expectMessage) {
		case "提现":
			String expect="您好，"+realName;
			String actual=page_me.getText_userName();
			Assertion.assertEquals(expect, actual, Biz_bindingBankcard.class, "绑卡成功");
			break;
		default:
		
			break;
		}
	}
}
