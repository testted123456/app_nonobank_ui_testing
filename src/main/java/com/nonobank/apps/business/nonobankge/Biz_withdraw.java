package com.nonobank.apps.business.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.nonobank.apps.page.nonobankge.Page_withdrawal;

public class Biz_withdraw {
	public static Logger logger = LogManager.getLogger(Biz_withdraw.class);
	Page_withdrawal page_withdrawal=new Page_withdrawal(); 
	
	public void withdraw(Var_withdraw var_withdraw){
		logger.info("[Biz_提现]");
		String withdrawal_amount=page_withdrawal.getText_withdrawal_amount();
		page_withdrawal.input_withdrawal_amount(var_withdraw.getWithdrawalAmount());
		page_withdrawal.sleep(1000);
		int fee=Integer.parseInt(page_withdrawal.getText_poundage());
		int actual_account=Integer.parseInt(page_withdrawal.getText_actual_account());
		Assert.assertEquals(fee+actual_account, var_withdraw.getWithdrawalAmount());
		page_withdrawal.click_withdrawal();
		page_withdrawal.sleep(2000);
		String withdrawalMoney=page_withdrawal.getText_CPM_withdrawalMoney();
		Assert.assertEquals(withdrawalMoney, var_withdraw.getWithdrawalAmount());
		page_withdrawal.input_CPM_payPassword(var_withdraw.getPayPassword());
		page_withdrawal.click_CPM_enter();	
	}
	
}
