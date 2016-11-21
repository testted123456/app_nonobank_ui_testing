package com.nonobank.apps.page.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.nonobank.apps.page.base.BasePage;

public class Page_findPassword extends BasePage {
	public static Logger logger = LogManager.getLogger(Page_findPassword.class);
	
	public void click_getSmsCode(){
		logger.info("[Page]点击获取验证码。。。。。。");
		WebElement element = objectRepository.getWebElement("获取验证码");
		element.click();
	}
	public void input_smsCode(String smsCode){
		logger.info("[Page]输入验证码。。。。。。");
		WebElement element = objectRepository.getWebElement("获取验证码");
		element.sendKeys(smsCode);
	}
	
	
}
