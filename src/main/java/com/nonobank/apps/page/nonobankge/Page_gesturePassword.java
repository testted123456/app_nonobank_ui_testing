package com.nonobank.apps.page.nonobankge;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import com.nonobank.apps.page.base.BasePage;

public class Page_gesturePassword extends BasePage{
	public static Logger logger = LogManager.getLogger(Page_gesturePassword.class);
	
	public void click_judge(){
		logger.info("点击跳过");
		WebElement element = objectRepository.getWebElement("跳过");
		element.click();
	}
	public String getText_prompt(){
		logger.info("获取提示信息");
		WebElement element = objectRepository.getWebElement("提示信息");
		String prompt=element.getText();
		return prompt;
	}
	public void set_gesturePwd(String gesturePwd){
		logger.info("设置手势密码");
		ArrayList<Point> points = new ArrayList<Point>();
		
		if(objectRepository.isElementExists("手势密码", 10)){
			logger.info("[page]输入手势密码...");
			WebElement element = objectRepository.getWebElement("手势密码");
			points = getGesturePasswordPoints(element);
			appActions.inputGesturePassword(gesturePwd, points);
		}else{
			logger.warn("[page]手势密码页面不存在...");
		}		
	}
	
	public ArrayList<Point> getGesturePasswordPoints(WebElement element) {
		Point init_point = element.getLocation();
		Dimension dimension = element.getSize();
		int x = init_point.getX();
		int y = init_point.getY();
		int height = dimension.getHeight();
		int width = dimension.getWidth();
		int each_width = width/3;
		int each_height = height/3;
		ArrayList<Point> points = new ArrayList<Point>();
		
		for(int col=0;col<3;col++){
			for(int row=0;row<3;row++){
				int pointX = (int)(x+each_width*(row+0.5));
				int pointY = (int)(y+each_height*(col+0.5));
				Point p = new Point(pointX, pointY);
				points.add(p);
			}
		}
		
		return points;
	}
	
	
}
