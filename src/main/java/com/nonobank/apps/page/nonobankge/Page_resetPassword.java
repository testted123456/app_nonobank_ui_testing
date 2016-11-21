package com.nonobank.apps.page.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.nonobank.apps.page.base.BasePage;

public class Page_resetPassword extends BasePage{
	public static Logger logger = LogManager.getLogger(Page_resetPassword.class);
	
	public void input_newPassword(String newPassword){
		logger.info("[Page]输入新密码。。。。。。");
		WebElement element = objectRepository.getWebElement("新密码");
		element.sendKeys(newPassword);
	}
	public void input_repeatPassword(String repeatPassword){
		logger.info("[Page]输入新密码。。。。。。");
		WebElement element = objectRepository.getWebElement("确认密码");
		element.sendKeys(repeatPassword);
	}
	public void click_enter(){
		logger.info("[Page]点击确认。。。。。。");
		WebElement element = objectRepository.getWebElement("确定");
		element.click();
	}

}
