package com.nonobank.apps.business.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.nonobank.apps.page.nonobankge.Page_withdrawal;

public class Biz_withdraw {
	public static Logger logger = LogManager.getLogger(Biz_withdraw.class);
	Page_withdrawal page_withdrawal=new Page_withdrawal(); 
	
	public void withdraw(String withdrawalAmount,String payPassword){
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
		System.out.println("-------------------------------------------------");
	}
	
}
