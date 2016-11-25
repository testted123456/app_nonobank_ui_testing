package com.nonobank.apps.business.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.nonobank.apps.page.nonobankge.Page_productDetails;
import com.nonobank.apps.utils.variable.StringHandle;


public class Biz_productInvest {
	public static Logger logger = LogManager.getLogger(Biz_productInvest.class);
	Page_productDetails page_productDetails=new Page_productDetails();
	
	public void productInvest(){
		logger.info("[Biz_产品购买]");
		//预期年化收益
		String rate=page_productDetails.getText_rate();
		double double_rate=Double.parseDouble(rate);
		//项目金额
		String amount=page_productDetails.getText_amount();
		//项目期限
		String expect=page_productDetails.getText_expect();
		String expect_num=StringHandle.numFromString(expect);
		double double_expect=Double.parseDouble(expect_num);
		//起投金额
		String start_money=page_productDetails.getText_start_money();
		//完成进度
		String schedule=page_productDetails.getText_schedule();
		//收益说明
		String earnings_intro=page_productDetails.getText_earnings_intro();
		//保障方式
		String security_mode=page_productDetails.getText_security_mode();
		//剩余可投
		String residue_invest_amount=page_productDetails.getText_residue_invest_amount();
		double double_residue_invest_amount=Double.parseDouble(residue_invest_amount);
		//获取每份投资金额
		String eachInvestMoney=page_productDetails.getText_eachInvestMoney();
		double double_eachInvestMoney=Double.parseDouble(eachInvestMoney);
		//投资金额
		String investMoney=Var_productInvest.getInvest_count();
		double double_investMoney=Double.parseDouble(investMoney);
		
		if(double_residue_invest_amount>double_investMoney&&double_investMoney%double_eachInvestMoney==0){
			page_productDetails.input_invest_count(Var_productInvest.getInvest_count());
			//预期收益
			String expect_earning=page_productDetails.getText_expect_earning();
			double double_earning=Double.parseDouble(expect_earning);
			//计算出的预期收益
			double earning=double_investMoney*double_expect*double_rate/12;
			Assert.assertEquals(Math.abs(double_earning-earning), 0.01);
			page_productDetails.click_invest();
			
			
			
			
		}
	}
	
	
	
}
