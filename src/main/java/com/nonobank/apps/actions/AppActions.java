package com.nonobank.apps.actions;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.nonobank.apps.page.nonobankge.Page_bindingBankcard;

import io.appium.java_client.AppiumDriver;
import junit.framework.Assert;

public abstract class AppActions {
	public static Logger logger = LogManager.getLogger(AppActions.class);
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
	public void inputComsumeInfo(WebElement element, String cardnum) throws Exception{
		String actual = "";  
        int i = 0;  
        do  
        {  
            element.click();  
            String[] str = cardnum.split("");  
            for (int j = 0; j < str.length; j++)  
            {  
                pressKeyCode(Integer.parseInt(str[j]) + 7);  
                // 如果当前长度超过预期的值说明多输入了一个数字，需要回删一个字符  
                if (element.getText().replace(" ", "").length() > (j + 1))  
                {  
                    logger.info("长度输入超过预期，需要回删一个字符");
                    pressKeyCode(67);  
                }  
  
                if (j == str.length / 2)  
                {  
                    element.click(); // 点击元素，确保与Appium有交互，否则会超时自动关闭session  
                    pressKeyCode(123); // 将光标移动到末尾  
                }  
            }  
            actual = element.getText().replace(" ", "");  
            logger.info("第 " + (i + 1) + " 次输入,期望值为: " + cardnum + " 实际值为：" + actual + " " + cardnum.equals(actual));  
            i++;  
            if (!actual.equals(cardnum))  
            {  
                element.clear();  
            }  
        } while (!actual.equals(cardnum));  
        Assert.assertEquals(actual, cardnum);
			
	}
	/** 
     * 模拟键盘输入 
     *  
     * @param keyCode 
     */  
    private  void pressKeyCode(int keyCode)  
    {  
        try  
        {  
        	String os = System.getProperties().getProperty("os.name");
        	if (os.startsWith("Mac")) {
        		 String cmdStr = "export ANDROID_HOME=/Users/user/Library/Android/sdk;export PATH=$PATH:$ANDROID_HOME:$ANDROID_HOME/platform-tools;"+"adb shell input keyevent " + keyCode; 
                 String[] cmds = { "/bin/sh", "-c", cmdStr};
        		 Runtime.getRuntime().exec(cmds).waitFor(); 
        	}else{
       		     String cmdStr2 = "adb shell input keyevent " + keyCode; 
        		 Runtime.getRuntime().exec(cmdStr2); 
        	}           
			Thread.sleep(800);
        } catch (Exception e)  
        {  
            e.printStackTrace();  
        }  
    }  
	
	
}
