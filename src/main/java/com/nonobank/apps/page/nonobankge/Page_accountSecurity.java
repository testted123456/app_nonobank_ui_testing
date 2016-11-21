package com.nonobank.apps.page.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.nonobank.apps.page.base.BasePage;

public class Page_accountSecurity extends BasePage{
	public static Logger logger = LogManager.getLogger(Page_accountSecurity.class);

	public void click_loginPassword(){
		logger.info("[Page]点击登录密码。。。。。。");
		WebElement element = objectRepository.getWebElement("登录密码");
		element.click();
	}
	public void click_payPassword(){
		logger.info("[Page]点击支付密码。。。。。。");
		WebElement element = objectRepository.getWebElement("支付密码");
		element.click();
	}
	public void click_gesturePasswordLock(){
		logger.info("[Page]点击手势密码开关。。。。。。");
		WebElement element = objectRepository.getWebElement("手势密码开关");
		element.click();
	}
	
	
	
}
