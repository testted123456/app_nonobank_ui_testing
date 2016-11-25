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
	public double getText_exceptYield(){
		logger.info("[Page]获取预期年化。。。。。。");
		WebElement element = objectRepository.getWebElement("预期年化");
		String exceptYield_str=element.getText();
		double exceptYield=StringHandle.expectEarnings(exceptYield_str);
		return exceptYield;
	}
	
	
	
	
}
