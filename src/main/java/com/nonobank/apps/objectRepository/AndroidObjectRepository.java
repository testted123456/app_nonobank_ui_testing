package com.nonobank.apps.objectRepository;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.nonobank.apps.driver.android.AndroidDriverWait;
import com.nonobank.apps.driver.android.ExpectedCondition;
import com.nonobank.apps.utils.file.ParseXML;
import io.appium.java_client.android.AndroidDriver;

public class AndroidObjectRepository extends AbstractObjectRepository {

	public AndroidObjectRepository(AndroidDriver<WebElement> driver, String xmlFile) {
		super(driver, xmlFile);
	}
	
	public WebElement getWebViewElement(String elementPath){
		Set<String> contexts = appiumDriver.getContextHandles();
		
		String context = null;
		WebElement element = null;
		
		for(String c : contexts){
			System.out.println("c的名字"+c);
			if(c.startsWith("WEBVIEW")){
				context = c;
				break;
			}
		}
		
		if(context != null){
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			WebDriver webDriver = appiumDriver.context(context);
			element = getWebElement(webDriver, elementPath);
		}else{
			element = getWebElement(elementPath);
		}
		
		return element;
	}
	
	public void switch_to_appview(){
		sleep(1000);
		appiumDriver.context("NATIVE_APP");
	}

	@Override
	public WebElement getWebElement(String elementPath) {
		// TODO Auto-generated method stub

		final String xpath = ParseXML.getElementXpath(elementPath, xmlFile, "android");
		AndroidDriver<WebElement> androidDriver = (AndroidDriver<WebElement>) appiumDriver;

		WebElement element = new AndroidDriverWait(androidDriver, 60).until(new ExpectedCondition<WebElement>() {
			public WebElement apply(AndroidDriver<WebElement> d) {
				return d.findElementByXPath(xpath);
			}
		});
		
		if(null == element){
			String msg = "抓取对象失败, xpath：" + elementPath;
			Assert.fail(msg);
		}

		return element;
	}

	@Override
	public List<WebElement> getWebElements(String elementPath) {
		// TODO Auto-generated method stub
		AndroidDriver<WebElement> androidDriver = (AndroidDriver<WebElement>) appiumDriver;
//		androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String xpath = ParseXML.getElementXpath(elementPath, xmlFile, "android");
		List<WebElement> elements = androidDriver.findElementsByXPath(xpath);
		return elements;
	}

	@Override
	public boolean isElementExists(String elementPath, final long seconds) {
		// TODO Auto-generated method stub
		WebElement element = null;

		try {
			final String xpath = ParseXML.getElementXpath(elementPath, xmlFile, "android");
			AndroidDriver<WebElement> androidDriver = (AndroidDriver<WebElement>) appiumDriver;

			element = new AndroidDriverWait(androidDriver, seconds).until(new ExpectedCondition<WebElement>() {
				public WebElement apply(AndroidDriver<WebElement> d) {
					return d.findElementByXPath(xpath);
				}
			});
		} catch (Exception e) {
		}

		return element == null ? false : true;
	}

	@Override
	public WebElement getWebElementByXpath(final String xpath) {
		// TODO Auto-generated method stub
		AndroidDriver<WebElement> androidDriver = (AndroidDriver<WebElement>) appiumDriver;

		WebElement element = new AndroidDriverWait(androidDriver, 60).until(new ExpectedCondition<WebElement>() {
			public WebElement apply(AndroidDriver<WebElement> d) {
				return d.findElementByXPath(xpath);
			}
		});
		
		if(null == element){
			String msg = "抓取对象失败, xpath：" + xpath;
			Assert.fail(msg);
		}

		return element;
	}

	@Override
	public boolean isElementExistsByXpath(final String xpath, long seconds) {
		// TODO Auto-generated method stub
		WebElement element = null;

		try {
			AndroidDriver<WebElement> androidDriver = (AndroidDriver<WebElement>) appiumDriver;

			element = new AndroidDriverWait(androidDriver, seconds).until(new ExpectedCondition<WebElement>() {
				public WebElement apply(AndroidDriver<WebElement> d) {
					return d.findElementByXPath(xpath);
				}
			});
		} catch (Exception e) {
		}

		return element == null ? false : true;
	}

	@Override
	public List<WebElement> getWebElementsByXpath(String xpath) {
		AndroidDriver<WebElement> androidDriver = (AndroidDriver<WebElement>) appiumDriver;
		List<WebElement> elements = androidDriver.findElementsByXPath(xpath);
		return elements;
	}
}
