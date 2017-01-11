package com.nonobank.apps.business.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import com.nonobank.apps.page.nonobankge.Page_purchase;
import com.nonobank.apps.page.nonobankge.Page_productDetails;
import com.nonobank.apps.page.nonobankge.Page_purchaseSuccess;



public class Biz_productInvest {
	public static Logger logger = LogManager.getLogger(Biz_productInvest.class);
	Page_productDetails page_productDetails=new Page_productDetails();
	Page_purchase page_purchase=new Page_purchase();
	Page_purchaseSuccess page_purchaseSuccess=new Page_purchaseSuccess();
	
	public void productInvest(String payPassword){
		logger.info("[Biz_产品购买]");
		System.out.println("--------------------------------------------------------------------");
		//预期年化收益
		String rate=page_productDetails.getText_rate();
		//项目金额
		double amount=page_productDetails.getText_amount();
		//项目期限
		String expect=page_productDetails.getText_expect();
		//起投金额
		double start_money=page_productDetails.getText_start_money();
		//完成进度
		double schedule=page_productDetails.getText_schedule();
		//收益说明
		String earnings_intro=page_productDetails.getText_earnings_intro();
		//保障方式
		String security_mode=page_productDetails.getText_security_mode();
		//剩余可投
		double residue_invest_amount=page_productDetails.getText_residue_invest_amount();
		//获取每份投资金额
		double eachInvestMoney=page_productDetails.getText_eachInvestMoney();
		//投资金额
		String investMoney=Var_productInvest.getInvest_count();
		double double_investMoney=Double.parseDouble(investMoney);
		
		if(residue_invest_amount>double_investMoney&&double_investMoney%eachInvestMoney==0){
			page_productDetails.input_invest_count(Var_productInvest.getInvest_count());
			//预期收益
			double expect_earning=page_productDetails.getText_expect_earning();
			//点击马上投资
			page_productDetails.click_invest();
			System.out.println("--------------------------------------------------------------------");
			//获取购买金额
			double purchaseMoney=page_purchase.getText_purchaseMoney();
			Assert.assertEquals(purchaseMoney, double_investMoney);
			//获取预期年化
			String exceptYield=page_purchase.getText_exceptYield();
			Assert.assertEquals(exceptYield, rate);
			//获取投资期限
			String investDeadline=page_purchase.getText_investDeadline();
			Assert.assertEquals(investDeadline, expect);
			//获取预期收益
			double exceptEarnings=page_purchase.getText_exceptEarnings();
			Assert.assertEquals(exceptEarnings, expect_earning);
			//获取待支付金额
			double stayPaymentMoney=page_purchase.getText_stayPaymentMoney();
			Assert.assertEquals(stayPaymentMoney, purchaseMoney);
			//点击确认支付
			page_purchase.click_confirmPay();
			//获取弹窗-本次投资金额
			double thisInvestMoney=page_purchase.getText_CMP_thisInvestMoney();
			Assert.assertEquals(thisInvestMoney, stayPaymentMoney);
			//获取弹窗-现金券支付金额
			double cashCouponPayMoney=page_purchase.getText_CMP_cashCouponPayMoney();
			//获取弹窗-账号余额支付金额
			double balancePayMoney=page_purchase.getText_CMP_balancePayMoney();
			Assert.assertEquals(thisInvestMoney, cashCouponPayMoney+balancePayMoney);
			//弹窗--输入支付密码
			page_purchase.input_CMP_payPassword(payPassword);
			//弹窗--点击确定
			page_purchase.click_CMP_enter();
			System.out.println("--------------------------------------------------------------------");
			//本次预计收益
			double thisInvestEarning=page_purchaseSuccess.getText_thisInvestEarning();
			Assert.assertEquals(thisInvestEarning, exceptEarnings);
			//本次投资金额
			double investMoney2=page_purchaseSuccess.getText_investMoney();
			Assert.assertEquals(investMoney2, investMoney);
			System.out.println("--------------------------------------------------------------------");
		}
	}
	
	
	
}
