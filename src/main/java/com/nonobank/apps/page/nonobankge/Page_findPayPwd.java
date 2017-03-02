package com.nonobank.apps.page.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.nonobank.apps.page.base.BasePage;

public class Page_findPayPwd extends BasePage{
	public static Logger logger = LogManager.getLogger(Page_findPayPwd.class);
	
	
	
	public void click_getSmsCode(){
		logger.info("[Page]点击获取验证码。。。。。。");
		WebElement element = objectRepository.getWebElement("获取验证码");
		element.click();
	}
	public void input_smsCode(String smsCode){
		logger.info("[Page]输入验证码。。。。。。");
		WebElement element = objectRepository.getWebElement("请输入验证码");
		element.sendKeys(smsCode);
	}
	public void input_newPayPwd(String newPayPwd){
		logger.info("[Page]输入验证码。。。。。。");
		WebElement element = objectRepository.getWebElement("新支付密码");
		element.sendKeys(newPayPwd);
	}
	public void input_secondPayPwd(String secondPayPwd){
		logger.info("[Page]输入验证码。。。。。。");
		WebElement element = objectRepository.getWebElement("确认支付密码");
		element.sendKeys(secondPayPwd);
	}
	public void click_submit(){
		logger.info("[Page]点击提交。。。。。。");
		WebElement element = objectRepository.getWebElement("提交");
		element.click();
	}
	
	
	
	
}
