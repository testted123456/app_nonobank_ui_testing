package com.nonobank.apps.business.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.nonobank.apps.page.nonobankge.Page_common;
import com.nonobank.apps.page.nonobankge.Page_withdrawal;
import com.nonobank.apps.utils.data.Assertion;

public class Biz_withdraw {
	public static Logger logger = LogManager.getLogger(Biz_withdraw.class);
	Page_withdrawal page_withdrawal=new Page_withdrawal(); 
	Page_common page_common=new Page_common();
	
	public void withdraw(String withdrawalAmount,String payPassword,String expectMessage){
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
		handleResult(expectMessage);
		System.out.println("-------------------------------------------------");
	}
	private void handleResult(String expectMessage) {
		switch (expectMessage) {
		case "我的银行卡":
			String expect="我的银行卡";
			String actual=page_common.getText_title();
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
