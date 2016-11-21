package com.nonobank.apps.page.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.nonobank.apps.page.base.BasePage;

public class Page_nonopurse_capitalRecord extends BasePage{
public static Logger logger = LogManager.getLogger(Page_productIntroduce.class);
	
	public void click_planIntroduce(){
		logger.info("[Page]点击计划介绍。。。。。。");
		WebElement element = objectRepository.getWebElement("计划介绍");
		element.click();
	}
}
