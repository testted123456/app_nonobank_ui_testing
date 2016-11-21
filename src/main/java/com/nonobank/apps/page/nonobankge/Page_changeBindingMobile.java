package com.nonobank.apps.page.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.nonobank.apps.page.base.BasePage;

public class Page_changeBindingMobile extends BasePage{
	public static Logger logger = LogManager.getLogger(Page_ChangeBindingMobile.class);

	public void input_mobile(String mobile){
		logger.info("[Page]输入要绑定的手机。。。。。。");
		WebElement element = objectRepository.getWebElement("请输入要绑定的手机号");
		element.sendKeys(mobile);
	}
	public void click_getSmsCode(){
		logger.info("[Page]点击发送验证码。。。。。。");
		WebElement element = objectRepository.getWebElement("发送验证码");
		element.click();
	}
	public void input_smsCode(String smsCode){
		logger.info("[Page]输入验证码。。。。。。");
		WebElement element = objectRepository.getWebElement("验证码");
		element.sendKeys(smsCode);
	}
	public void click_auth(){
		logger.info("[Page]点击去验证。。。。。。");
		WebElement element = objectRepository.getWebElement("去验证");
		element.click();
	}
	
}
