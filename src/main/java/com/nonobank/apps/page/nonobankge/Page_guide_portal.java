package com.nonobank.apps.page.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.nonobank.apps.page.base.BasePage;

public class Page_guide_portal extends BasePage{
	public static Logger logger = LogManager.getLogger(Page_guide_portal.class);
	
	public void click_partake(){
		logger.info("[Page]点击立即参与。。。。。。");
		WebElement element = objectRepository.getWebElement("底层区域");
		element.click();
	}
	
	public boolean isExist_bottomArea(){
		logger.info("[Page]底部区域是否存在。。。。。。");
		boolean isExist_bottomArea=objectRepository.isElementExists("底层区域", 5);
		return isExist_bottomArea;
	}
	
	public void swipe_page(){
		logger.info("[page]滑动导航页面...");
		int width = appActions.getWidth();
		int height = appActions.getHeight();
		appActions.swipe(width * 3 / 4, height / 2, 1, height / 2, 500);
	}
	
	

}
