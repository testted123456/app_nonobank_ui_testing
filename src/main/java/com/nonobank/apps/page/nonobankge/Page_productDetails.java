package com.nonobank.apps.page.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.nonobank.apps.page.base.BasePage;
import com.nonobank.apps.utils.variable.StringHandle;

public class Page_productDetails extends BasePage{
	public static Logger logger = LogManager.getLogger(Page_productDetails.class);
	
	public String getText_rate(){
		logger.info("[Page]获取预期年化收益。。。。。。");
		WebElement element = objectRepository.getWebElement("预期年化收益");
		String rate=element.getText();
		return rate;
	}
	public double getText_amount(){
		logger.info("[Page]获取项目金额。。。。。。");
		WebElement element = objectRepository.getWebElement("项目金额");
		String amount_str=element.getText();
		double amount=Double.parseDouble(amount_str);
		return amount;
	}
	public String getText_expect(){
		logger.info("[Page]获取项目期限。。。。。。");
		WebElement element = objectRepository.getWebElement("项目期限");
		String expect=element.getText();
		return expect;
	}
	public double getText_start_money(){
		logger.info("[Page]获取起投金额。。。。。。");
		WebElement element = objectRepository.getWebElement("起投金额");
		String start_money_str=element.getText();
		double start_money=Double.parseDouble(start_money_str);
		return start_money;
	}
	public double getText_schedule(){
		logger.info("[Page]获取项目进度。。。。。。");
		WebElement element = objectRepository.getWebElement("项目进度");
		String schedule_str=element.getText();
		double schedule=StringHandle.expectEarnings(schedule_str);
		return schedule;
	}
	public String getText_earnings_intro(){
		logger.info("[Page]获取收益说明。。。。。。");
		WebElement element = objectRepository.getWebElement("收益说明");
		String earnings_intro=element.getText();
		return earnings_intro;
	}
	public String getText_security_mode(){
		logger.info("[Page]获取保障方式。。。。。。");
		WebElement element = objectRepository.getWebElement("保障方式");
		String security_mode=element.getText();
		return security_mode;
	}
	public void click_product_intro(){
		logger.info("[Page]点击产品介绍。。。。。。");
		WebElement element = objectRepository.getWebElement("产品介绍");
		element.click();
	}
	public double getText_eachInvestMoney(){
		logger.info("[Page]获取每份投资金额。。。。。。");
		WebElement element = objectRepository.getWebElement("投资金额");
		String eachInvestMoney_str=element.getText();
		double eachInvestMoney=Double.parseDouble(eachInvestMoney_str);
		return eachInvestMoney;
	}
	public void input_invest_count(String invest_count){
		logger.info("[Page]输入投资金额。。。。。。");
		WebElement element = objectRepository.getWebElement("投资金额");
		element.sendKeys(invest_count);	
	}
	public void click_product_cut(){
		logger.info("[Page]点击投资金额减号。。。。。。");
		WebElement element = objectRepository.getWebElement("投资金额减号");
		element.click();
	}
	public void click_product_add(){
		logger.info("[Page]点击投资金额加号。。。。。。");
		WebElement element = objectRepository.getWebElement("投资金额加号");
		element.click();
	}
	public double getText_expect_earning(){
		logger.info("[Page]获取预期收益。。。。。。");
		WebElement element = objectRepository.getWebElement("预期收益");
		String expect_earning_str=element.getText();
		double expect_earning=Double.parseDouble(expect_earning_str);
		return expect_earning;
	}
	public double getText_residue_invest_amount(){
		logger.info("[Page]获取剩余可投。。。。。。");
		WebElement element = objectRepository.getWebElement("剩余可投");
		String residue_invest_amount_str=element.getText();
		double residue_invest_amount=Double.parseDouble(residue_invest_amount_str);
		return residue_invest_amount;
	}
	public void click_invest(){
		logger.info("[Page]点击马上投资。。。。。。");
		WebElement element = objectRepository.getWebElement("马上投资");
		element.click();
	}
	
	
	
	
}
