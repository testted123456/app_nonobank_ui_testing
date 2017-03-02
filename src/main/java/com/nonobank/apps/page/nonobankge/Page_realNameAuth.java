package com.nonobank.apps.page.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.nonobank.apps.page.base.BasePage;

public class Page_realNameAuth extends BasePage{
	public static Logger logger = LogManager.getLogger(Page_realNameAuth.class);
	
	public void input_realName(String realName){
		logger.info("[Page]输入姓名。。。。。。");
		WebElement element = objectRepository.getWebElement("姓名");
		element.sendKeys(realName);
	}
	public void input_idCard(String idCard){
		logger.info("[Page]输入身份证号码。。。。。。");
		WebElement element = objectRepository.getWebElement("身份证号码");
		element.sendKeys(idCard);
	}
	public void click_auth(){
		logger.info("[Page]点击实名认证。。。。。。");
		WebElement element = objectRepository.getWebElement("实名认证");
		element.click();
	}
	public String getText_prompt(){
		logger.info("[Page]获取小提示。。。。。。");
		WebElement element = objectRepository.getWebElement("小提示");
		String prompt=element.getText();
		return prompt;
	}
	
	public String getText_CPM_prompt(){
		logger.info("[Page]获取弹窗-提示信息。。。。。。");
		WebElement element = objectRepository.getWebElement("弹窗-提示信息");
		String CPM_prompt=element.getText();
		return CPM_prompt;
	}
	public String getText_CPM_realName(){
		logger.info("[Page]获取弹窗-姓名。。。。。。");
		WebElement element = objectRepository.getWebElement("弹窗-姓名");
		String CPM_realName=element.getText();
		return CPM_realName;
	}
	public String getText_CPM_idCard(){
		logger.info("[Page]获取弹窗-身份证号码。。。。。。");
		WebElement element = objectRepository.getWebElement("弹窗-身份证号码");
		String CPM_idCard=element.getText();
		return CPM_idCard;
	}
	public void click_CPM_returnModify(){
		logger.info("[Page]点击弹窗-返回修改。。。。。。");
		WebElement element = objectRepository.getWebElement("弹窗-返回修改");
		element.click();
	}
	public void click_CPM_gotoModify(){
		logger.info("[Page]点击弹窗-去修改。。。。。。");
		WebElement element = objectRepository.getWebElement("弹窗-去修改");
		element.click();
	}
	public void click_CPM_enter(){
		logger.info("[Page]点击弹窗-确定。。。。。。");
		WebElement element = objectRepository.getWebElement("弹窗-确定");
		element.click();
	}
	
	
}
