package com.nonobank.apps.business.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import com.nonobank.apps.page.nonobankge.Page_purchase;
import com.nonobank.apps.page.nonobankge.Page_common;
import com.nonobank.apps.page.nonobankge.Page_invest;
import com.nonobank.apps.page.nonobankge.Page_productDetails;
import com.nonobank.apps.page.nonobankge.Page_purchaseSuccess;
import com.nonobank.apps.page.nonobankge.Page_setPayPassword;
import com.nonobank.apps.utils.data.Assertion;



public class Biz_productInvest {
	public static Logger logger = LogManager.getLogger(Biz_productInvest.class);
	Page_productDetails page_productDetails=new Page_productDetails();
	Page_purchase page_purchase=new Page_purchase();
	Page_purchaseSuccess page_purchaseSuccess=new Page_purchaseSuccess();
	Page_common page_common=new Page_common();
	Page_invest page_invest=new Page_invest();
	Page_setPayPassword page_setPayPassword=new Page_setPayPassword();

	public void productInvest(String investMoney,String payPwd,String bankSmsCode,String expectMessage){
		logger.info("[Biz_产品购买]");
		System.out.println("--------------------------------------------------------------------");
		//预期年化收益
		String rate=page_productDetails.getText_rate();
		logger.info("预期年化收益rate:"+rate);
		//项目期限
		String expect=page_productDetails.getText_expect();
		logger.info("项目期限expect:"+expect);
		//起投金额
		double start_money=page_productDetails.getText_start_money();
		logger.info("起投金额:"+start_money);
		//获取累计投资人次
		double allInvestPerson=page_productDetails.getText_allInvestPerson();
		logger.info("获取累计投资人次:"+allInvestPerson);
		//判断按钮为已售罄还是下一步
		String content=page_productDetails.getText_next();
		if(content.equals("已售罄")){
			System.out.println("已售罄");
			
		}
		if(content.equals("立即投资")){
			page_productDetails.click_nextORsoldout();
			page_productDetails.sleep(2000);
			String rate2=page_invest.getText_rate();	
			logger.info("年化收益:"+rate2);
			String expect2=page_invest.getText_expect();
			logger.info("项目期限:"+expect2);
			page_invest.input_investMoney(investMoney);
			page_invest.sleep(1000);
			page_invest.click_balance();
			page_invest.sleep(1000);
			page_invest.click_pay();
			page_invest.sleep(1000);
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
			page_invest.click_CPM_nextStep();
			page_invest.sleep(1000);
			page_invest.input_CPM_payPwd(payPwd);
			page_invest.sleep(1000);
			page_invest.click_CPM_payPwd_next();
			page_invest.sleep(1000);
			page_invest.input_CPM_smsCode(bankSmsCode);
			page_invest.sleep(1000);
		}	
		handleResult(expectMessage);
		System.out.println("--------------------------------------------------------------------");
	}
	private void handleResult(String expectMessage) {
		switch (expectMessage) {
		case "投资":
			String expect="投资";
			String actual=page_common.getText_title();
			Assertion.assertEquals(expect, actual, Biz_bindingBankcard.class, "");
			break;
		default:
			
			break;
		}
	}
	
	
}
