package com.nonobank.apps.page.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.nonobank.apps.page.base.BasePage;

public class Page_modifyPayPwd extends BasePage{
	public static Logger logger = LogManager.getLogger(Page_modifyPayPwd.class);
	
	public void input_oldPayPwd(String oldPayPwd){
		logger.info("[Page]输入原支付密码。。。。。。");
		WebElement element = objectRepository.getWebElement("请输入原支付密码");
		element.sendKeys(oldPayPwd);
	}
	public void input_newPayPwd(String newPayPwd){
		logger.info("[Page]输入新支付密码。。。。。。");
		WebElement element = objectRepository.getWebElement("新支付密码");
		element.sendKeys(newPayPwd);
	}
	public void input_secondPayPwd(String secondPayPwd){
		logger.info("[Page]输入确认支付密码。。。。。。");
		WebElement element = objectRepository.getWebElement("确认支付密码");
		element.sendKeys(secondPayPwd);
	}
	public void click_forgetPayPwd(){
		logger.info("[Page]点击忘记支付密码。。。。。。");
		WebElement element = objectRepository.getWebElement("忘记密码");
		element.click();
	}
	public void click_enter(){
		logger.info("[Page]点击确定。。。。。。");
		WebElement element = objectRepository.getWebElement("确定");
		element.click();
	}
		
}
