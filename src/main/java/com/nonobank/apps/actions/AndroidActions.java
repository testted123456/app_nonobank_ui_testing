package com.nonobank.apps.actions;

import java.util.ArrayList;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class AndroidActions extends AppActions {

	public AndroidActions(AndroidDriver<WebElement> driver){
		super(driver);
	}
	
	@Override
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
			Point point = (Point)objs.get(number);
			int x = point.getX();
			int y = point.getY();

			if(i==0){
				touchAction = touchAction.press(x, y);
			}else{
				Point last_point = (Point)objs.get(numbers[i-1]);
				int offsetX = x - last_point.getX();
				int offsetY = y - last_point.getY();
				System.out.println("移动的X坐标为："+offsetX);
				System.out.println("移动的Y坐标为："+offsetY);
				touchAction = touchAction.moveTo(offsetX, offsetY);
			}
		
		}
		touchAction.release().perform();
	}

}
