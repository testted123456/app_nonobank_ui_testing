package com.nonobank.apps.business.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.nonobank.apps.interfaces.mock.KuaiqianPay;
import com.nonobank.apps.page.nonobankge.Page_bindingBankcard;
import com.nonobank.apps.page.nonobankge.Page_debt;
import com.nonobank.apps.page.nonobankge.Page_invest;
import com.nonobank.apps.page.nonobankge.Page_setPayPassword;

public class Biz_debt {
	public static Logger logger = LogManager.getLogger(Biz_debt.class);
	
	Page_debt page_debt=new Page_debt();
	Page_invest page_invest=new Page_invest();
	Page_setPayPassword page_setPayPassword=new Page_setPayPassword();
	Page_bindingBankcard page_bindingBankcard=new Page_bindingBankcard();
	
	public void debtInvest(String payPwd,String bankName,String bankCardNum,
			String realName,String idCard,String bankMobile,String bankSmsCode){
		page_debt.click_buyAll();
		page_debt.sleep(1000);
		page_debt.click_atOnceInvest();
		page_debt.sleep(1000);
		
		page_invest.click_pay();
		//点击立即设置
		page_invest.click_CPM_setting();
		page_setPayPassword.sleep(1000);
		page_setPayPassword.input_password(payPwd);
		page_setPayPassword.sleep(1000);
		page_setPayPassword.input_confirmPassword(payPwd);
		page_setPayPassword.sleep(1000);
		page_setPayPassword.click_confirm();
		page_setPayPassword.sleep(1000);
		page_invest.click_pay();
		
		KuaiqianPay.bindingBankcard();
		page_bindingBankcard.click_selectBank();
		page_bindingBankcard.sleep(1000);
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
		page_setPayPassword.sleep(1000);
		page_invest.click_pay();
		
		page_invest.click_CPM_nextStep();
		page_invest.sleep(1000);
		KuaiqianPay.pay();
		page_invest.input_CPM_payPwd(payPwd);
		page_invest.sleep(1000);
		page_invest.click_CPM_payPwd_next();
		page_invest.sleep(1000);
		page_invest.input_CPM_smsCode(bankSmsCode);
		page_invest.sleep(1000);
		page_invest.click_investFinish();	
	}
	
}
