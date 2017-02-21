package com.nonobank.apps.page.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import com.nonobank.apps.page.base.BasePage;

public class Page_product extends BasePage{
	public static Logger logger = LogManager.getLogger(Page_product.class);
	
	public void click_regularInvest(){
		logger.info("[Page]点击定投。。。。。。");
		WebElement element = objectRepository.getWebElement("定投");
		element.click();
	}
	public void click_directInvest(){
		logger.info("[Page]点击直投。。。。。。");
		WebElement element = objectRepository.getWebElement("直投");
		element.click();
	}
	public void click_debtEquity(){
		logger.info("[Page]点击债转。。。。。。");
		WebElement element = objectRepository.getWebElement("债转");
		element.click();
	}
	public String getText_bannerTag(){
		logger.info("[Page]获取横幅标题。。。。。。");
		WebElement element = objectRepository.getWebElement("横幅标题");
		String bannerTag=element.getText();
		return bannerTag;
	}
	public String getText_bannerContent(){
		logger.info("[Page]获取横幅标题。。。。。。");
		WebElement element = objectRepository.getWebElement("横幅内容");
		String bannerContent=element.getText();
		return bannerContent;
	}
	public String getText_progress(){
		logger.info("[Page]获取当前产品进度。。。。。。");
		WebElement element = objectRepository.getWebElement("当前产品进度");
		String progress=element.getText();
		return progress;
	}
	public void click_product(){
		logger.info("[Page]点击相应产品。。。。。。");
		WebElement element = objectRepository.getWebElement("当前产品进度");
		element.click();
	}
	public void click_product(String productName){
		logger.info("[Page]点击相应产品。。。。。。");
		WebElement element = objectRepository.getWebElementByXpath("//android.widget.TextView[@text='"+productName+"']");
		element.click();
	}
	public boolean isExist_productName(String productName){
		logger.info("[Page]产品是否存在。。。。。。");
		boolean  isExist_productName=objectRepository.isElementExistsByXpath("//android.widget.TextView[@text='"+productName+"']", 5);
		return isExist_productName;
	}
	public void swipe_productList(){
		logger.info("[Page]滑动产品列表。。。。。。");
		WebElement element = objectRepository.getWebElement("产品当前list");
		Point init_point = element.getLocation();
		int x = init_point.getX();
		int y = init_point.getY();
		Dimension dimension = element.getSize();
		int height = dimension.getHeight();
		int width = dimension.getWidth();		
		appActions.swipe(x+width/2, y+height/2, x+width/2, y+height/4, 500);		
	}
	
}
