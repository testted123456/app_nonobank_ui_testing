package com.nonobank.apps.page.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.nonobank.apps.page.base.BasePage;

public class Page_common extends BasePage{
	public static Logger logger = LogManager.getLogger(Page_common.class);
	
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
		logger.info("[Page]我的是否存在。。。。。。");
		boolean isExist_me=objectRepository.isElementExists("我的", 5);
		return isExist_me;
	}
	public boolean is_me_displayed(){
		logger.info("[Page]我的是否显示。。。。。。");
		WebElement element = objectRepository.getWebElement("我的");
		return element.isDisplayed();
	}
	public void click_find(){
		logger.info("[Page]点击发现。。。。。。");
		WebElement element = objectRepository.getWebElement("发现");
		element.click();
	}
	public String getText_findNum(){
		logger.info("[Page]获取发现消息数量。。。。。。");
		WebElement element = objectRepository.getWebElement("发现消息数量");
		String findNum=element.getText();
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
