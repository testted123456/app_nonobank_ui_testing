package com.nonobank.apps.page.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.nonobank.apps.page.base.BasePage;

public class Page_common extends BasePage{
	public static Logger logger = LogManager.getLogger(Page_common.class);
	
	public boolean isExist_pop(){
		logger.info("[Page]pop是否存在。。。。。。");
		boolean isExist_pop=objectRepository.isElementExists("POP关闭按钮", 5);
		return isExist_pop;
	}
	public void press_find(){
		logger.info("[Page]长按发现。。。。。。");
		WebElement element = objectRepository.getWebElement("发现");
		longPress(element);
	}
	public boolean isExist_update(){
		logger.info("[Page]立即更新是否存在。。。。。。");
		boolean isExist_update=objectRepository.isElementExists("立即更新", 5);
		return isExist_update;
	}
	public void close_update(){
		logger.info("[Page]点击立即更新关闭按钮。。。。。。");
		WebElement element = objectRepository.getWebElement("立即更新关闭按钮");
		element.click();
	}	
	//environment取值为stb,sit,pre,prd
	public void select_environment(String environment){
		logger.info("[Page]选择环境。。。。。。");
		WebElement element=objectRepository.getWebElementByXpath("//android.widget.TextView[@text='"+environment+"']");
		element.click();
	}
	public void close_pop(){
		logger.info("[Page]关闭pop。。。。。。");
		WebElement element = objectRepository.getWebElement("POP关闭按钮");
		element.click();
	}
	public String getText_title(){
		logger.info("[Page]获取页面标题[title_name]。。。。。。");
		WebElement element = objectRepository.getWebElement("页面标题");
		String title=element.getText();
		return title;
	}
	public String getText_title2(){
		logger.info("[Page]获取页面标题2[tv_title]。。。。。。");
		WebElement element = objectRepository.getWebElement("页面标题2");
		String title=element.getText();
		return title;
	}
	public void click_backBtn(){
		logger.info("[Page]点击返回按钮。。。。。。");
		WebElement element = objectRepository.getWebElement("返回按钮");
		element.click();
	}
	public String getText_rightTitle(){
		logger.info("[Page]获取页面右侧标题。。。。。。");
		WebElement element = objectRepository.getWebElement("页面右侧标题");
		String rightTitle=element.getText();
		return rightTitle;
	}
	public void click_rightTitle(){
		logger.info("[Page]点击页面右侧标题。。。。。。");
		WebElement element = objectRepository.getWebElement("页面右侧标题");
		element.click();
	}
	public void click_me(){
		logger.info("[Page]点击我的。。。。。。");
		WebElement element = objectRepository.getWebElement("我的");
		element.click();
	}
	public boolean isExist_me(){
		boolean isExist=objectRepository.isElementExists("我的", 5);
		return isExist;
	}
	public void click_find(){
		logger.info("[Page]点击发现。。。。。。");
		WebElement element = objectRepository.getWebElement("发现");
		element.click();
	}
	public double getText_findNum(){
		logger.info("[Page]获取发现消息数量。。。。。。");
		WebElement element = objectRepository.getWebElement("发现消息数量");
		String findNum_str=element.getText();
		double findNum=Double.parseDouble(findNum_str);
		return findNum;
	}
	public void click_product(){
		logger.info("[Page]点击产品。。。。。。");
		WebElement element = objectRepository.getWebElement("产品");
		element.click();
	}
	public void click_home(){
		logger.info("[Page]点击首页。。。。。。");
		WebElement element = objectRepository.getWebElement("首页");
		element.click();
	}
	
	
}
