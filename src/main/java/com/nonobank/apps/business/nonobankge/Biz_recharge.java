package com.nonobank.apps.business.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.nonobank.apps.page.nonobankge.Page_recharge;
import com.nonobank.apps.page.nonobankge.Page_rechargeSuccess;
import com.nonobank.apps.page.nonobankge.Page_setPayPassword;
import com.nonobank.apps.page.nonobankge.Page_cashierDesk;

public class Biz_recharge {
	public static Logger logger = LogManager.getLogger(Biz_recharge.class);
	Page_recharge page_recharge=new Page_recharge();
	Page_setPayPassword page_setPayPassword=new Page_setPayPassword();
	Page_cashierDesk page_cashierDesk=new Page_cashierDesk();
	Page_rechargeSuccess page_rechargeSuccess=new Page_rechargeSuccess(); 
	
	public void recharge_noPayPassword(Var_recharge var_recharge){
		logger.info("[Biz_充值未设置支付密码]");
		System.out.println("-------------------------------------------------");
		String pop_prompt=page_recharge.getText_CPM_popUp();
		Assert.assertEquals(pop_prompt, "您尚未设置支付密码，请设置支付密码之后再进行交易。");
		page_recharge.click_CPM_settingIcon();
		page_recharge.sleep(1000);
		System.out.println("------------------------");
		page_setPayPassword.input_password(var_recharge.getPayPassword());
		page_setPayPassword.input_confirmPassword(var_recharge.getPayPassword_second());
		page_setPayPassword.click_confirm();
		page_setPayPassword.sleep(1000);
		System.out.println("------------------------");
		page_recharge.input_recharge_sum(var_recharge.getRechargeSum());
		page_recharge.click_next();
		page_recharge.sleep(2000);
		System.out.println("-------------------------------------------------");
		double payMoney=page_cashierDesk.getText_payMoney();
		Assert.assertEquals(payMoney, Double.parseDouble(var_recharge.getRechargeSum()));
//		Page_cashierDesk.getText_paymentMethod();
//		String bankLimit=Page_cashierDesk.getText_bankLimit();
		page_cashierDesk.click_next();
		page_cashierDesk.sleep(1000);
		double CMP_rechargeMoney=page_cashierDesk.getText_CMP_rechargeMoney();
		Assert.assertEquals(CMP_rechargeMoney, Double.parseDouble(var_recharge.getRechargeSum()));
		page_cashierDesk.input_CMP_payPassword(var_recharge.getPayPassword());
		page_cashierDesk.click_CMP_enter();
		page_cashierDesk.sleep(2000);
		String CMP2_prompt=page_cashierDesk.getText_CMP2_prompt();
//		Assert.assertEquals(CMP2_prompt, "");
		page_cashierDesk.input_CMP2_smsCode(var_recharge.getBankSmsCode());
		page_cashierDesk.click_CMP2_enterRecharge();
		page_cashierDesk.sleep(2000);
		System.out.println("-------------------------------------------------");
		double rechargeMoney=page_rechargeSuccess.getText_rechargeMoney();
		Assert.assertEquals(rechargeMoney, CMP_rechargeMoney);
		page_rechargeSuccess.click_finish();
		System.out.println("-------------------------------------------------");
	}
	
	
	
}
