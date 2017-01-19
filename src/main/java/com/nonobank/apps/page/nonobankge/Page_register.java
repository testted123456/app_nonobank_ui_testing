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
	public void click_control(){
		logger.info("[Page]点击注册协议。。。。。。");
		WebElement element = objectRepository.getWebElement("注册协议勾选框");
		element.click();
	}
	public void click_nextStep(){
		logger.info("[Page]点击下一步。。。。。。");
		WebElement element = objectRepository.getWebElement("下一步");
		element.click();
	}
	public String getText_smsSendTo(){
		logger.info("[Page]短信将发送至。。。。。。");
		WebElement element = objectRepository.getWebElement("短信验证码将发送至");
		String text=element.getText();
		return text;
	}
	public void click_getSmsCode(){
		logger.info("[Page]点击获取验证码。。。。。。");
		WebElement element = objectRepository.getWebElement("获取验证码");
		element.click();	
	}
	public void input_pictureVerification(String pictureVerification){
		logger.info("[Page]输入图片验证码。。。。。。");
		WebElement element = objectRepository.getWebElement("图形验证码");
		element.sendKeys(pictureVerification);
	}	
	public void click_pictureVerification(){
		logger.info("[Page]点击图片验证码。。。。。。");
		WebElement element = objectRepository.getWebElement("图片验证码");
		element.click();
	}
	public void click_enter(){
		logger.info("[Page]点击图形验证码-确认。。。。。。");
		WebElement element = objectRepository.getWebElement("图形验证码-确认");
		element.click();
	}
	public boolean isExist_enter(){
		logger.info("[Page]图形验证码-确认是否存在。。。。。。");
		boolean a=objectRepository.isElementExists("图形验证码-确认", 5);
		return a;
	}
	public void click_cancel(){
		logger.info("[Page]点击图形验证码-取消。。。。。。");
		WebElement element = objectRepository.getWebElement("图形验证码-取消");
		element.click();
	}	
	public void input_SmsCode(String smsCode){
		logger.info("[Page]输入短信验证码。。。。。。");
		WebElement element = objectRepository.getWebElement("请输入短信验证码");
		element.sendKeys(smsCode);
	}
	public String getText_pwdForYourAccount(){
		logger.info("[Page]将为你的账号设置密码。。。。。。");
		WebElement element = objectRepository.getWebElement("将为你的账号设置密码");
		String text=element.getText();
		return text;
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
	public void click_invitation(){
		logger.info("[Page]点击邀请码提示按钮。。。。。。");
		WebElement element = objectRepository.getWebElement("邀请码输入提示按钮");
		element.click();
	}	
	public void input_invitationSystem(String invitationSystem){
		logger.info("[Page]输入邀请码。。。。。。");
		WebElement element = objectRepository.getWebElement("输入邀请码");
		element.sendKeys(invitationSystem);
	}	
	public void click_register(){
		logger.info("[Page]点击完成。。。。。。");
		WebElement element = objectRepository.getWebElement("完成");
		element.click();
	}


}
