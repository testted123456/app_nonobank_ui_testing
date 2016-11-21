package com.nonobank.apps.page.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.nonobank.apps.page.base.BasePage;

public class Page_modifyLoginPassword extends BasePage{
	public static Logger logger = LogManager.getLogger(Page_modifyLoginPassword.class);
	
	public void input_oldPassword(String oldPassword){
		logger.info("[Page]输入原始密码。。。。。。");
		WebElement element = objectRepository.getWebElement("请输入原始密码");
		element.sendKeys(oldPassword);
	}
	public void input_newPassword(String newPassword){
		logger.info("[Page]输入新密码。。。。。。");
		WebElement element = objectRepository.getWebElement("请输入新密码");
		element.sendKeys(newPassword);
	}
	public void input_ensurePassword(String ensurePassword){
		logger.info("[Page]输入确认密码。。。。。。");
		WebElement element = objectRepository.getWebElement("请输入确认密码");
		element.sendKeys(ensurePassword);
	}
	public void click_enter(){
		logger.info("[Page]点击确认。。。。。。");
		WebElement element = objectRepository.getWebElement("确认");
		element.click();
	}
	public String getText_prompt(){
		logger.info("[Page]获取小提示。。。。。。");
		WebElement element = objectRepository.getWebElement("小提示");
		String prompt=element.getText();
		return prompt;
	}
	public void click_forgetPassword(){
		logger.info("[Page]点击忘记密码。。。。。。");
		WebElement element = objectRepository.getWebElement("忘记密码");
		element.click();
	}
	
	

}
