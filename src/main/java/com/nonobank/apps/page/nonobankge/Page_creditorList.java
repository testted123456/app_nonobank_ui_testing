package com.nonobank.apps.page.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.nonobank.apps.page.base.BasePage;

public class Page_creditorList extends BasePage{
	public static Logger logger = LogManager.getLogger(Page_creditorList.class);
	
	public String getText_prompt(){
		logger.info("[Page]获取小提示。。。。。。");
		WebElement element = objectRepository.getWebElement("小提示");
		String prompt=element.getText();
		return prompt;
	}
	
	
	
	

}
