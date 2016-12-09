package com.nonobank.apps.page.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.nonobank.apps.page.base.BasePage;


public class Page_productList extends BasePage{
	public static Logger logger = LogManager.getLogger(Page_productList.class);
	
	public void click_byProductName(String productName){
		logger.info("【Page】通过产品名点击。。。。");
		WebElement element = objectRepository.getWebElementByXpath("//android.widget.TextView[@text='"+productName+"']");
		element.click();
	}
	
	
	
}
