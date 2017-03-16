package com.nonobank.apps.business.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.nonobank.apps.page.nonobankge.Page_recharge;
import com.nonobank.apps.page.nonobankge.Page_rechargeSuccess;
import com.nonobank.apps.page.nonobankge.Page_setPayPassword;
import com.nonobank.apps.utils.data.Assertion;
import com.nonobank.apps.checkPoint.nono.RechargeCheck;
import com.nonobank.apps.page.nonobankge.Page_bindingBankcard;
import com.nonobank.apps.page.nonobankge.Page_cashierDesk;
import com.nonobank.apps.page.nonobankge.Page_common;
import com.nonobank.apps.page.nonobankge.Page_me;

public class Biz_recharge {
	public static Logger logger = LogManager.getLogger(Biz_recharge.class);
	Page_recharge page_recharge=new Page_recharge();
	Page_setPayPassword page_setPayPassword=new Page_setPayPassword();
	Page_cashierDesk page_cashierDesk=new Page_cashierDesk();
	Page_rechargeSuccess page_rechargeSuccess=new Page_rechargeSuccess(); 
	Page_common page_common=new Page_common();
	Page_me page_me=new Page_me();
	Page_bindingBankcard page_bindingBankcard=new Page_bindingBankcard();
	
	public void recharge_noPayPassword(String payPassword,String payPassword_second,
			String rechargeSum,String bankSmsCode,String bankName,String bankCardNum,
			String bankMobile,String realName,String idCard,
			String smsCode_recharge,String expectMessage,String mobile){
		logger.info("[Biz_充值未设置支付密码]");
		System.out.println("-------------------------------------------------");
		page_recharge.input_recharge_sum(rechargeSum);
		page_recharge.sleep(1000);
		page_recharge.click_ImmediatelyRecharge();
		page_recharge.sleep(1000);
		String cpm_text=page_recharge.getText_CPM_popUp();
		Assert.assertEquals(cpm_text, "您尚未设置支付密码，请设置支付密码之后再进行交易。");
		page_recharge.click_CPM_settingIcon();
		page_recharge.sleep(2000);
		page_setPayPassword.input_password(payPassword_second);
		page_setPayPassword.sleep(1000);
		page_setPayPassword.input_confirmPassword(payPassword_second);
		page_setPayPassword.sleep(1000);
		page_setPayPassword.click_confirm();
		page_setPayPassword.sleep(1000);
		page_recharge.click_ImmediatelyRecharge();
		page_setPayPassword.sleep(1000);
		
		page_bindingBankcard.click_selectBank();
		page_bindingBankcard.sleep(1000);
		page_bindingBankcard.select_bank(bankName);
		page_bindingBankcard.sleep(1000);
		page_bindingBankcard.input_bankCardNum(bankCardNum);
		page_bindingBankcard.sleep(1000);
		page_bindingBankcard.click_nextStep();
		page_bindingBankcard.sleep(1000);
		if(page_bindingBankcard.isExist_nextStep()){
			page_bindingBankcard.click_nextStep();
			page_bindingBankcard.sleep(1000);
		}
		
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
		page_bindingBankcard.sleep(1000);
		
		page_recharge.click_ImmediatelyRecharge();
		page_recharge.sleep(1000);
		
//		String cpm_title=page_recharge.getText_CPM_title();
//		Assert.assertEquals(cpm_title, "付款详情");
		page_recharge.sleep(1000);
		page_recharge.click_CPM_nextStep();
		page_recharge.sleep(1000);
//		cpm_title=page_recharge.getText_CPM_title();
//		Assert.assertEquals(cpm_title, "输入支付密码");
		page_recharge.sleep(1000);
		page_recharge.input_CPM_payPwd(payPassword);
		page_recharge.sleep(1000);
		page_recharge.click_CPM_payPwd_nextStep();
		page_recharge.sleep(1000);
//		cpm_title=page_recharge.getText_CPM_title();
//		Assert.assertEquals(cpm_title, "输入验证码");
		page_recharge.sleep(1000);
		page_recharge.input_CPM_smsCode(smsCode_recharge);
		page_recharge.sleep(1000);
		
//		double rechargeMoney=page_rechargeSuccess.getText_rechargeMoney();
		page_rechargeSuccess.click_finish();
		page_rechargeSuccess.sleep(1000);
		//充值-数据库检查
		RechargeCheck.verify_recharge(mobile, rechargeSum);
		handleResult(expectMessage,realName);
		System.out.println("-------------------------------------------------");
	}
	public void recharge_firstPayPassword(String payPassword,String rechargeSum,String bankSmsCode,
			String bankName,String bankCardNum,
			String bankMobile,String realName,String idCard,
			String smsCode_recharge,String expectMessage,String mobile){
		logger.info("[Biz_充值已设置支付密码]");
		System.out.println("-------------------------------------------------");
		page_recharge.input_recharge_sum(rechargeSum);
		page_recharge.sleep(1000);
		page_recharge.click_ImmediatelyRecharge();
		page_recharge.sleep(1000);
		
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
		page_bindingBankcard.sleep(1000);	
		page_recharge.click_ImmediatelyRecharge();
		page_recharge.sleep(1000);
		page_recharge.click_CPM_nextStep();
		page_recharge.sleep(1000);
		page_recharge.input_CPM_payPwd(payPassword);
		page_recharge.sleep(1000);
		page_recharge.click_CPM_payPwd_nextStep();
		page_recharge.sleep(1000);
		page_recharge.input_CPM_smsCode(smsCode_recharge);
		page_recharge.sleep(1000);
		page_rechargeSuccess.click_finish();
		page_rechargeSuccess.sleep(1000);
		//充值-数据库检查
		RechargeCheck.verify_recharge(mobile, rechargeSum);
		handleResult(expectMessage,realName);
		System.out.println("-------------------------------------------------");
	}
	public void recharge_firstBankCard(String payPassword,String rechargeSum,
			String realName,String smsCode_recharge,String expectMessage,String mobile){
		logger.info("[Biz_充值已绑卡]");
		System.out.println("-------------------------------------------------");
		page_recharge.input_recharge_sum(rechargeSum);
		page_recharge.sleep(1000);
		page_recharge.click_ImmediatelyRecharge();
		page_recharge.sleep(1000);
		page_recharge.click_CPM_nextStep();
		page_recharge.sleep(1000);
		page_recharge.input_CPM_payPwd(payPassword);
		page_recharge.sleep(1000);
		page_recharge.click_CPM_payPwd_nextStep();
		page_recharge.sleep(1000);
		page_recharge.input_CPM_smsCode(smsCode_recharge);
		page_recharge.sleep(1000);
		page_rechargeSuccess.click_finish();
		page_rechargeSuccess.sleep(1000);
		//充值-数据库检查
		RechargeCheck.verify_recharge(mobile, rechargeSum);
		handleResult(expectMessage,realName);
		System.out.println("-------------------------------------------------");
	}
	public void rechargeExc(String payPassword,String payPassword_second,
			String rechargeSum,String bankSmsCode,String bankName,String bankCardNum,
			String bankMobile,String realName,String idCard,
			String smsCode_recharge,String rechargeSum_zero,String expectMessage,String mobile){
		logger.info("[Biz_充值未设置支付密码]");
		System.out.println("-------------------------------------------------");
		page_recharge.input_recharge_sum(rechargeSum_zero);
		page_recharge.sleep(1000);
		page_recharge.click_ImmediatelyRecharge();
		page_recharge.sleep(1000);
		String cpm_text=page_recharge.getText_CPM_popUp();
		Assert.assertEquals(cpm_text, "您尚未设置支付密码，请设置支付密码之后再进行交易。");
		page_recharge.click_CPM_settingIcon();
		page_recharge.sleep(2000);
		page_setPayPassword.input_password(payPassword_second);
		page_setPayPassword.sleep(1000);
		page_setPayPassword.input_confirmPassword(payPassword_second);
		page_setPayPassword.sleep(1000);
		page_setPayPassword.click_confirm();
		page_setPayPassword.sleep(1000);
		page_recharge.click_ImmediatelyRecharge();
		page_setPayPassword.sleep(1000);
		
		page_bindingBankcard.click_selectBank();
		page_bindingBankcard.sleep(1000);
		page_bindingBankcard.select_bank(bankName);
		page_bindingBankcard.sleep(1000);
		page_bindingBankcard.input_bankCardNum(bankCardNum);
		page_bindingBankcard.sleep(1000);
		page_bindingBankcard.click_nextStep();
		page_bindingBankcard.sleep(1000);
		if(page_bindingBankcard.isExist_nextStep()){
			page_bindingBankcard.click_nextStep();
			page_bindingBankcard.sleep(1000);
		}
		
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
		page_bindingBankcard.sleep(1000);
		
		page_recharge.click_ImmediatelyRecharge();
		page_recharge.sleep(1000);
		page_recharge.sleep(1000);
		page_recharge.click_CPM_nextStep();
		page_recharge.sleep(1000);
		page_recharge.sleep(1000);
		page_recharge.input_CPM_payPwd(payPassword);
		page_recharge.sleep(1000);
		page_recharge.click_CPM_payPwd_nextStep();
		page_recharge.sleep(1000);
		page_recharge.click_CPM_payPwd_nextStep();
		page_recharge.sleep(1000);
		page_recharge.click_CPM_payPwd_nextStep();
		page_recharge.sleep(1000);
		//支付金额为0的情况
		page_recharge.click_CPM_back();
		page_recharge.sleep(1000);
		page_recharge.click_CPM_back();
		page_recharge.sleep(1000);
		//充值金额2000000元，大于银行限额
		page_recharge.input_recharge_sum("2000000");
		page_recharge.sleep(1000);
		page_recharge.click_ImmediatelyRecharge();
		page_recharge.sleep(3000);
		String title=page_common.getText_title();
		Assert.assertEquals(title, "输入银行卡号");
		page_common.click_backBtn();
		//正确的情况
		page_recharge.input_recharge_sum(rechargeSum);
		page_recharge.sleep(1000);
		page_recharge.click_ImmediatelyRecharge();
		page_recharge.sleep(1000);
		page_recharge.click_CPM_nextStep();
		page_recharge.sleep(1000);
		page_recharge.input_CPM_payPwd(payPassword);
		page_recharge.sleep(1000);
		page_recharge.click_CPM_payPwd_nextStep();
		page_recharge.sleep(1000);
		page_recharge.input_CPM_smsCode(smsCode_recharge);
		page_recharge.sleep(1000);
		page_rechargeSuccess.click_finish();
		page_rechargeSuccess.sleep(1000);
		//充值-数据库检查
		RechargeCheck.verify_recharge(mobile, rechargeSum);
		handleResult(expectMessage,realName);
	}
	private void handleResult(String expectMessage,String realName) {
		switch (expectMessage) {
		case "充值":
			String expect="您好，"+realName;
			String actual=page_me.getText_userName();
			Assertion.assertEquals(expect, actual, Biz_bindingBankcard.class, "绑卡成功");
			break;
		default:
			break;
		}
	}
	
	
}
