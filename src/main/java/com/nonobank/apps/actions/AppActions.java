package com.nonobank.apps.actions;

import java.util.ArrayList;
import org.openqa.selenium.WebElement;
import io.appium.java_client.AppiumDriver;

public abstract class AppActions {

    AppiumDriver<WebElement> driver;
    
    public AppActions(AppiumDriver<WebElement> driver){
    	this.driver = driver;
    }
    
	public void swipeToUp(int during) {
		// TODO Auto-generated method stub
		int width = driver.manage().window().getSize().width;
		int height = driver.manage().window().getSize().height;
		driver.swipe(width / 2, height * 3 / 4, width / 2, height / 4, during);
	}

	public void swipeToDown(int during) {
		// TODO Auto-generated method stub
		int width = driver.manage().window().getSize().width;
		int height = driver.manage().window().getSize().height;
		driver.swipe(width / 2, height / 4, width / 2, height * 3 / 4, during);
	}

	public void swipeToLeft(int during) {
		// TODO Auto-generated method stub
		int width = driver.manage().window().getSize().width;
		int height = driver.manage().window().getSize().height;
		driver.swipe(width * 3 / 4, height / 2, width / 4, height / 2, during);

	}

	public void swipeToRight(int during) {
		// TODO Auto-generated method stub
		int width = driver.manage().window().getSize().width;
		int height = driver.manage().window().getSize().height;
		driver.swipe(width / 4, height / 2, width * 3 / 4, height / 2, during);
	}

	public void swipe(int startX, int startY, int endX, int endY, int ms) {
		// TODO Auto-generated method stub
		driver.swipe(startX, startY, endX, endY, ms);
	}

	public int getWidth() {
		// TODO Auto-generated method stub
		return driver.manage().window().getSize().width;
	}

	public int getHeight() {
		// TODO Auto-generated method stub
		return driver.manage().window().getSize().height;
	}

	public abstract void inputGesturePassword(String gesture_password, ArrayList<? extends Object> objs);

	public void closeApp() {
		// TODO Auto-generated method stub
		driver.closeApp();
	}
	
	public void resetApp(){
		driver.resetApp();
	}
	
	public void quit(){
		driver.quit();
	}
	
	public void longPress(WebElement element){
		driver.tap(1, element, 5000);
	}
	public void launchApp(){
		driver.launchApp();
	}
	public void sleep(long ms) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
