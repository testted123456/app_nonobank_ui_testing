package com.nonobank.apps.page.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import com.nonobank.apps.page.base.BasePage;

public class Page_bindingBankcard extends BasePage{
	public static Logger logger = LogManager.getLogger(Page_bindingBankcard.class);

	public void input_userRealName(String realName){
		logger.info("[Page]输入姓名。。。。。。");
		WebElement element = objectRepository.getWebElement("姓名");
		element.sendKeys(realName);
	}
	public void input_userIdCard(String idCard){
		logger.info("[Page]输入身份证号。。。。。。");
		WebElement element = objectRepository.getWebElement("身份证号");
		element.sendKeys(idCard);
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
	public boolean isExist_bankName(String bankName){
		logger.info("[Page]银行是否存在。。。。。。");
		return objectRepository.isElementExistsByXpath("//android.widget.TextView[@text='"+bankName+"']", 3);
	}
	public void swipe_bankSelect(){
		logger.info("[Page]滑动银行选择框。。。。。。");
		WebElement element = objectRepository.getWebElementByXpath("//android.support.v7.widget.RecyclerView[@resource-id='com.nonoapp:id/rv_bank_list']");
		Point init_point = element.getLocation();
		Dimension dimension = element.getSize();
		int x = init_point.getX();
		int y = init_point.getY();
		int height = dimension.getHeight();
		int width = dimension.getWidth();
		appActions.swipe(x+width/2, y+height*6/7, x+width/2, y+height*5/7, 3000);
	}
	
	public void input_bankCardNum(String bankCardNum){
		logger.info("[Page]输入银行卡号码。。。。。。");
		WebElement element = objectRepository.getWebElement("银行卡号");
		try {
			appActions.inputComsumeInfo(element, bankCardNum);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
