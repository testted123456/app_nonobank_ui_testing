package com.nonobank.apps.page.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.nonobank.apps.page.base.BasePage;

public class Page_login extends BasePage{
	public static Logger logger = LogManager.getLogger(Page_login.class);
	
	public void input_mobile(String mobile){
		logger.info("[Page]输入手机号码。。。。。。");
		WebElement element = objectRepository.getWebElement("请输入手机号/麦子通行证");
		element.sendKeys(mobile);
	}
	public void input_password(String password){
		logger.info("[Page]输入密码。。。。。。");
		WebElement element = objectRepository.getWebElement("登录密码");
		element.sendKeys(password);
	}
	public void click_password_eye(){
		logger.info("[Page]点击密码显示按钮。。。。。。");
		WebElement element = objectRepository.getWebElement("密码显示键");
		element.click();
	}
	public void click_login_issue(){
		logger.info("[Page]点击登录遇到问题。。。。。。");
		WebElement element = objectRepository.getWebElement("登录遇到问题");
		element.click();
	}
	public void click_login(){
		logger.info("[Page]点击登录。。。。。。");
		WebElement element = objectRepository.getWebElement("登录");
		element.click();
	}
	
	
	
}
