package com.nonobank.apps.page.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.nonobank.apps.page.base.BasePage;
import com.nonobank.apps.utils.variable.StringHandle;

public class Page_purchase extends BasePage{
	public static Logger logger = LogManager.getLogger(Page_purchase.class);

	public double getText_purchaseMoney(){
		logger.info("[Page]获取购买金额。。。。。。");
		WebElement element = objectRepository.getWebElement("购买金额");
		String purchaseMoney_str=element.getText();
		double purchaseMoney=Double.parseDouble(purchaseMoney_str);
		return purchaseMoney;
	}
	public String getText_exceptYield(){
		logger.info("[Page]获取预期年化。。。。。。");
		WebElement element = objectRepository.getWebElement("预期年化");
		String exceptYield=element.getText();
		return exceptYield;
	}
	public String getText_investDeadline(){
		logger.info("[Page]获取投资期限。。。。。。");
		WebElement element = objectRepository.getWebElement("投资期限");
		String investDeadline=element.getText();
		return investDeadline;
	}
	public double getText_exceptEarnings(){
		logger.info("[Page]获取预期收益。。。。。。");
		WebElement element = objectRepository.getWebElement("预期收益");
		String exceptEarnings_str=element.getText();
		double exceptEarnings=Double.parseDouble(exceptEarnings_str);
		return exceptEarnings;
	}
	public double getText_paymentMethod_balance(){
		logger.info("[Page]获取付款方式-账户余额。。。。。。");
		WebElement element = objectRepository.getWebElement("付款方式-账户余额");
		String paymentMethod_balance_str=element.getText();
		double paymentMethod_balance=StringHandle.numFromString(paymentMethod_balance_str);
		return paymentMethod_balance;
	}
	public void click_cashCoupon(){
		logger.info("[Page]点击现金券。。。。。。");
		WebElement element = objectRepository.getWebElement("现金券");
		element.click();
	}
	public String getText_cashCouponPrompt(){
		logger.info("[Page]获取现金券提示。。。。。。");
		WebElement element = objectRepository.getWebElement("现金券");
		String cashCouponPrompt=element.getText();
		return cashCouponPrompt;
	}
	public void click_debtList(){
		logger.info("[Page]点击待匹配债权。。。。。。");
		WebElement element = objectRepository.getWebElement("待匹配债权");
		element.click();
	}
	public double getText_stayPaymentMoney(){
		logger.info("[Page]获取待支付金额。。。。。。");
		WebElement element = objectRepository.getWebElement("待支付金额");
		String stayPaymentMoney_str=element.getText();
		double stayPaymentMoney=Double.parseDouble(stayPaymentMoney_str);
		return stayPaymentMoney;
	}
	public void click_confirmPay(){
		logger.info("[Page]点击确认支付。。。。。。");
		WebElement element = objectRepository.getWebElement("确认支付");
		element.click();
	}
	public double getText_CMP_thisInvestMoney(){
		logger.info("[Page]获取弹窗-本次投资金额。。。。。。");
		WebElement element = objectRepository.getWebElement("弹窗-本次投资金额");
		String CMP_thisInvestMoney_str=element.getText();
		double CMP_thisInvestMoney=Double.parseDouble(CMP_thisInvestMoney_str);
		return CMP_thisInvestMoney;
	}
	public double getText_CMP_cashCouponPayMoney(){
		logger.info("[Page]获取弹窗-现金券支付金额。。。。。。");
		WebElement element = objectRepository.getWebElement("弹窗-现金券支付金额");
		String CMP_cashCouponPayMoney_str=element.getText();
		double CMP_cashCouponPayMoney=Double.parseDouble(CMP_cashCouponPayMoney_str);
		return CMP_cashCouponPayMoney;
	}
	public double getText_CMP_balancePayMoney(){
		logger.info("[Page]获取弹窗-账户余额支付金额。。。。。。");
		WebElement element = objectRepository.getWebElement("弹窗-账户余额支付金额");
		String CMP_balancePayMoney_str=element.getText();
		double CMP_balancePayMoney=Double.parseDouble(CMP_balancePayMoney_str);
		return CMP_balancePayMoney;
	}
	public void input_CMP_payPassword(String payPassword){
		logger.info("[Page]输入支付密码。。。。。。");
		WebElement element = objectRepository.getWebElement("弹窗-请输入支付密码");
		element.sendKeys(payPassword);
	}
	public void click_CMP_enter(){
		logger.info("[Page]点击确定。。。。。。");
		WebElement element = objectRepository.getWebElement("弹窗-确定");
		element.click();
	}
	
}
