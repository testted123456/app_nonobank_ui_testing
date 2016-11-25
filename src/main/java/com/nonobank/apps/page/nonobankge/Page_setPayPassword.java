package com.nonobank.apps.page.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.nonobank.apps.page.base.BasePage;

public class Page_setPayPassword extends BasePage{
	
public static Logger logger = LogManager.getLogger(Page_setPayPassword.class);
	
	public void input_password(String payPassword){
		logger.info("[Page]输入支付密码。。。。。。");
		WebElement element = objectRepository.getWebElement("支付密码");
		element.sendKeys(payPassword);
	}
	
	public void input_confirmPassword(String payPassword_second){
		logger.info("[Page]确认支付密码。。。。。。");
		WebElement element = objectRepository.getWebElement("确认支付密码");
		element.sendKeys(payPassword_second);
	}
	
	public void click_confirm(){
		logger.info("[Page]点击确定。。。。。。");
		WebElement element = objectRepository.getWebElement("确定");
		element.click();
	}
}
