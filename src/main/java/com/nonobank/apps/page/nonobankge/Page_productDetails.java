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
	public double getText_allInvestPerson(){
		logger.info("[Page]获取累计投资人次。。。。。。");
		WebElement element = objectRepository.getWebElement("累计投资人次");
		String allInvestPerson_str=element.getText();
		double allInvestPerson=StringHandle.expectEarnings(allInvestPerson_str);
		return allInvestPerson;
	}
	public String getText_next(){
		logger.info("[Page]获取按钮内容。。。。。。");
		WebElement element = objectRepository.getWebElement("下一步或者已售罄");
		String text=element.getText();
		return text;
	}
	public void click_nextORsoldout(){
		logger.info("[Page]点击下一步。。。。。。");
		WebElement element = objectRepository.getWebElement("下一步或者已售罄");
		element.click();
	}
	
	
	
}
