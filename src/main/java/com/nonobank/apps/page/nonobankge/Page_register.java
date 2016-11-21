package com.nonobank.apps.page.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.nonobank.apps.page.base.BasePage;

public class Page_register extends BasePage{
	public static Logger logger = LogManager.getLogger(Page_register.class);
	
	public void input_mobile(String mobile){
		logger.info("[Page]输入手机号码。。。。。。");
		WebElement element = objectRepository.getWebElement("请输入手机号");
		element.sendKeys(mobile);
	}
	public void input_pictureVerification(String pictureVerification){
		logger.info("[Page]输入图片验证码。。。。。。");
		WebElement element = objectRepository.getWebElement("请输入图片验证码");
		element.sendKeys(pictureVerification);
	}
	public void click_pictureVerification(){
		logger.info("[Page]点击图片验证码。。。。。。");
		WebElement element = objectRepository.getWebElement("图片验证码");
		element.click();
	}
	public void click_getSmsCode(){
		logger.info("[Page]点击获取验证码。。。。。。");
		WebElement element = objectRepository.getWebElement("获取验证码");
		element.click();	
	}
	public void input_SmsCode(String smsCode){
		logger.info("[Page]输入短信验证码。。。。。。");
		WebElement element = objectRepository.getWebElement("请输入短信验证码");
		element.sendKeys(smsCode);
	}
	public void input_invitationSystem(String invitationSystem){
		logger.info("[Page]输入邀请码(选填)。。。。。。");
		WebElement element = objectRepository.getWebElement("请输入邀请码(选填)");
		element.sendKeys(invitationSystem);
	}
	public void input_password(String password){
		logger.info("[Page]输入密码。。。。。。");
		WebElement element = objectRepository.getWebElement("请输入密码");
		element.sendKeys(password);
	}
	public void click_passwordByLock(){
		logger.info("[Page]点击密码显示按钮。。。。。。");
		WebElement element = objectRepository.getWebElement("密码显示按钮");
		element.click();
	}
	public void click_register(){
		logger.info("[Page]点击注册。。。。。。");
		WebElement element = objectRepository.getWebElement("注册");
		element.click();
	}
	public void click_login(){
		logger.info("[Page]点击登录>。。。。。。");
		WebElement element = objectRepository.getWebElement("登录>");
		element.click();
	}
	

}
