package com.nonobank.apps.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import java.lang.IllegalArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import io.appium.java_client.events.api.general.AppiumWebDriverEventListener;

public class AppiumWebDriverEventListenerImpl implements AppiumWebDriverEventListener {

	private Logger logger = LogManager.getLogger(this.getClass().getName());

	public void beforeNavigateTo(String url, WebDriver driver) {
		// TODO Auto-generated method stub
	}

	public void afterNavigateTo(String url, WebDriver driver) {
		// TODO Auto-generated method stub
	}

	public void beforeNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub
	}

	public void afterNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub
	}

	public void beforeNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
	}

	public void afterNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
	}

	public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
	}

	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
	}

	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
	}

	public void onException(Throwable throwable, WebDriver driver) {
		// TODO Auto-generated method stub
		/**
		 * 如果不是NoSuchElementException（页面元素没找到）的异常，则把结果设为fail
		 */
		String noSuchElementException = NoSuchElementException.class.getName();
		String illegalArgumentException = IllegalArgumentException.class.getName();
		String throwableName = throwable.getClass().getName();
		String msg = throwable.getMessage();

		if (null != throwableName 
			&& !throwableName.equals(noSuchElementException)
			&& !(throwableName.equals(illegalArgumentException) && msg.startsWith("Cannot find elements when the selector is null"))) {
			logger.error(throwableName);
		}

		if (!noSuchElementException.equals(throwableName)
			&& !(throwableName.equals(illegalArgumentException) && msg.startsWith("Cannot find elements when the selector is null"))) {
			logger.error("发生异常 : " + msg);
			Assert.fail(msg);
		}
	}
}
