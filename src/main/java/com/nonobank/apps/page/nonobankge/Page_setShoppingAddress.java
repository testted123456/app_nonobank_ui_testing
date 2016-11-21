package com.nonobank.apps.page.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.nonobank.apps.page.base.BasePage;

public class Page_setShoppingAddress extends BasePage{
	public static Logger logger = LogManager.getLogger(Page_setShoppingAddress.class);

	public void click_province(){
		logger.info("[Page]点击省份。。。。。。");
		WebElement element = objectRepository.getWebElement("省份");
		element.click();
	}
	public void click_city(){
		logger.info("[Page]点击城市。。。。。。");
		WebElement element = objectRepository.getWebElement("城市");
		element.click();
	}
	public void input_detailedAddress(String detailedAddress){
		logger.info("[Page]输入详细地址。。。。。。");
		WebElement element = objectRepository.getWebElement("详细地址");
		element.sendKeys(detailedAddress);
	}
	public void click_submit(){
		logger.info("[Page]点击提交。。。。。。");
		WebElement element = objectRepository.getWebElement("提交");
		element.click();
	}
	
	
}
