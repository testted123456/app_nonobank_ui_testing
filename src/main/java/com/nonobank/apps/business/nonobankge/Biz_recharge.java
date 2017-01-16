package com.nonobank.apps.business.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.nonobank.apps.page.nonobankge.Page_recharge;
import com.nonobank.apps.page.nonobankge.Page_rechargeSuccess;
import com.nonobank.apps.page.nonobankge.Page_setPayPassword;
import com.nonobank.apps.utils.data.Assertion;
import com.nonobank.apps.page.nonobankge.Page_cashierDesk;
import com.nonobank.apps.page.nonobankge.Page_common;

public class Biz_recharge {
	public static Logger logger = LogManager.getLogger(Biz_recharge.class);
	Page_recharge page_recharge=new Page_recharge();
	Page_setPayPassword page_setPayPassword=new Page_setPayPassword();
	Page_cashierDesk page_cashierDesk=new Page_cashierDesk();
	Page_rechargeSuccess page_rechargeSuccess=new Page_rechargeSuccess(); 
	Page_common page_common=new Page_common();
	
	public void recharge_noPayPassword(String payPassword,String payPassword_second,
			String rechargeSum,String bankSmsCode,String expectMessage){
		logger.info("[Biz_充值未设置支付密码]");
		System.out.println("-------------------------------------------------");
		String pop_prompt=page_recharge.getText_CPM_popUp();
		Assert.assertEquals(pop_prompt, "您尚未设置支付密码，请设置支付密码之后再进行交易。");
		page_recharge.click_CPM_settingIcon();
		page_recharge.sleep(1000);
		System.out.println("------------------------");
		page_setPayPassword.input_password(payPassword);
		page_setPayPassword.input_confirmPassword(payPassword_second);
		page_setPayPassword.click_confirm();
		page_setPayPassword.sleep(1000);
		System.out.println("------------------------");
		page_recharge.input_recharge_sum(rechargeSum);
		page_recharge.click_next();
		page_recharge.sleep(2000);
		System.out.println("-------------------------------------------------");
		double payMoney=page_cashierDesk.getText_payMoney();
		Assert.assertEquals(payMoney, Double.parseDouble(rechargeSum));
//		Page_cashierDesk.getText_paymentMethod();
//		String bankLimit=Page_cashierDesk.getText_bankLimit();
		page_cashierDesk.click_next();
		page_cashierDesk.sleep(1000);
		double CMP_rechargeMoney=page_cashierDesk.getText_CMP_rechargeMoney();
		Assert.assertEquals(CMP_rechargeMoney, Double.parseDouble(rechargeSum));
		page_cashierDesk.input_CMP_payPassword(payPassword);
		page_cashierDesk.click_CMP_enter();
		page_cashierDesk.sleep(2000);
		String CMP2_prompt=page_cashierDesk.getText_CMP2_prompt();
//		Assert.assertEquals(CMP2_prompt, "");
		page_cashierDesk.input_CMP2_smsCode(bankSmsCode);
		page_cashierDesk.click_CMP2_enterRecharge();
		page_cashierDesk.sleep(2000);
		System.out.println("-------------------------------------------------");
		double rechargeMoney=page_rechargeSuccess.getText_rechargeMoney();
		Assert.assertEquals(rechargeMoney, CMP_rechargeMoney);
		page_rechargeSuccess.click_finish();
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
