package com.nonobank.apps.page.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.nonobank.apps.page.base.BasePage;

public class Page_bindingMobile extends BasePage{
	public static Logger logger = LogManager.getLogger(Page_BindingMobile.class);

	public String getText_bindingMobile(){
		logger.info("[Page]获取当前绑定手机。。。。。。");
		WebElement element = objectRepository.getWebElement("当前绑定手机");
		String bindingMobile=element.getText();
		return bindingMobile;
	}
	public void input_loginPassword(String password){
		logger.info("[Page]输入手机号码。。。。。。");
		WebElement element = objectRepository.getWebElement("请输入登录密码");
		element.sendKeys(password);
	}
	public void click_replaceBinding(){
		logger.info("[Page]点击更换绑定。。。。。。");
		WebElement element = objectRepository.getWebElement("更换绑定");
		element.click();
	}
	public String getText_prompt(){
		logger.info("[Page]获取小提示。。。。。。");
		WebElement element = objectRepository.getWebElement("小提示");
		String prompt=element.getText();
		return prompt;
	}
	
	
}
