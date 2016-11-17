package com.nonobank.apps.actions;

import java.util.ArrayList;
import org.openqa.selenium.WebElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;

public class IOSActions extends AppActions {
	
	public IOSActions(IOSDriver<WebElement> driver) {
		super(driver);
	}
	
	public void inputGesturePassword(String gesture_password, ArrayList<? extends Object> objs) {
		TouchAction touchAction = new TouchAction(driver);
		
		String [] passwords = gesture_password.split(",");
		int length = passwords.length;
		int [] numbers = new int[length];
		
		for(int i=0;i<length;i++){
			numbers[i] = Integer.parseInt(passwords[i].trim());
		}
		
		for(int i=0;i<length;i++){
			int number = numbers[i];
			WebElement element = (WebElement)objs.get(number);

			if(i==0){
				touchAction = touchAction.press(element);
			}else{
				touchAction = touchAction.moveTo(element);
			}
		}
		touchAction.release().perform();
	}
}

