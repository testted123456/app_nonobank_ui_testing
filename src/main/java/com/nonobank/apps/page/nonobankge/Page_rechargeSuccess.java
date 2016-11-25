package com.nonobank.apps.page.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.nonobank.apps.page.base.BasePage;
import com.nonobank.apps.utils.variable.StringHandle;

public class Page_rechargeSuccess extends BasePage{

	public static Logger logger = LogManager.getLogger(Page_rechargeSuccess.class);
	
	public double getText_rechargeMoney(){
		logger.info("[Page]获取充值金额。。。。。。");
		WebElement element = objectRepository.getWebElement("充值金额");
		String rechargeMoney_text=element.getText();
		double rechargeMoney=StringHandle.numFromString(rechargeMoney_text);
		return rechargeMoney;
	}
	public void click_finish(){
		logger.info("[Page]点击完成。。。。。。");
		WebElement element = objectRepository.getWebElement("完成");
		element.click();
	}
	
}
