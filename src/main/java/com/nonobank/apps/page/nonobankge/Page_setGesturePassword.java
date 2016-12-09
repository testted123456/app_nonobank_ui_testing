package com.nonobank.apps.page.nonobankge;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import com.nonobank.apps.page.base.BasePage;

public class Page_setGesturePassword extends BasePage{
	
	public void swipe_setGesturePassword(){
		logger.info("[Page]设置手势密码。。。。。。");
		WebElement element = objectRepository.getWebElement("大图标");
		Point init_point = element.getLocation();
		int x_point = init_point.getX();
		int y_point = init_point.getY();
		Dimension dimension = element.getSize();
		int height = dimension.getHeight();
		int width = dimension.getWidth();
		int each_width = width/3;
		int each_height = height/3;
//		appActions.swipe(startX, startY, endX, endY, ms);
		
	}
	
	
}
