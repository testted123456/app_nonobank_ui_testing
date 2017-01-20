package com.nonobank.apps.page.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.nonobank.apps.page.base.BasePage;

public class Page_bindingBankcard extends BasePage{
	public static Logger logger = LogManager.getLogger(Page_bindingBankcard.class);

	public String getText_userRealName(){
		logger.info("[Page]获取用户姓名。。。。。。");
		WebElement element = objectRepository.getWebElement("姓名");
		String userRealName=element.getText();
		return userRealName;
	}
	public String getText_userIdCard(){
		logger.info("[Page]获取用户身份证号。。。。。。");
		WebElement element = objectRepository.getWebElement("身份证号");
		String userIdCard=element.getText();
		return userIdCard;
	}
	public void click_selectBank(){
		logger.info("[Page]点击请选择你的银行。。。。。。");
		WebElement element = objectRepository.getWebElement("请选择你的银行");
		element.click();
	}
	/*
	 * @bankName:中信银行，华夏银行，广东发展银行，平安银行，中国农业银行，中国光大银行，中国工商银行，中国银行
	 * 中国建设银行，招商银行，兴业银行，上海浦东发展银行，交通银行，中国民生银行，中国邮政储蓄银行
	 */
	public void select_bank(String bankName){
		logger.info("[Page]选择银行。。。。。。");
		WebElement element = objectRepository.getWebElementByXpath("//android.widget.TextView[@text='"+bankName+"']");
		element.click();
	}
	public void input_bankCardNum(String bankCardNum){
		logger.info("[Page]输入银行卡号码。。。。。。");
		WebElement element = objectRepository.getWebElement("银行卡号");
		element.sendKeys(bankCardNum);
	}
	public void input_bankMobile(String bankMobile){
		logger.info("[Page]输入预留手机号。。。。。。");
		WebElement element = objectRepository.getWebElement("预留手机号");
		element.sendKeys(bankMobile);
	}
	public void click_nextStep(){
		logger.info("[Page]点击下一步。。。。。。");
		WebElement element = objectRepository.getWebElement("下一步");
		element.click();
	}
	public void click_getSmsCode(){
		logger.info("[Page]点击获取验证码。。。。。。");
		WebElement element = objectRepository.getWebElement("获取验证码");
		element.click();
	}
	public void input_bankSmsCode(String bankSmsCode){
		logger.info("[Page]输入验证码。。。。。。");
		WebElement element = objectRepository.getWebElement("请输入验证码");
		element.sendKeys(bankSmsCode);
	}
	public String getText_prompt(){
		logger.info("[Page]获取小提示。。。。。。");
		WebElement element = objectRepository.getWebElement("小提示");
		String prompt=element.getText();
		return prompt;
	}
	public void click_enter(){
		logger.info("[Page]点击确定。。。。。。");
		WebElement element = objectRepository.getWebElement("确定");
		element.click();
	}
	
	
}
