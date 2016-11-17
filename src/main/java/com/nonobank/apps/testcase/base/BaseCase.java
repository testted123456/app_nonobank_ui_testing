package com.nonobank.apps.testcase.base;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.TreeMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.nonobank.apps.actions.AndroidActions;
import com.nonobank.apps.actions.AppActions;
import com.nonobank.apps.actions.IOSActions;
import com.nonobank.apps.driver.DriverFactory;
import com.nonobank.apps.utils.file.ParseXLSX;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class BaseCase {
	protected static Logger logger = LogManager.getLogger(BaseCase.class);

	// 测试数据文件，保存在TestData下
	public String testfile;

	// 保存测试结果的map
	public static TreeMap<Long, Integer> resultsMap;

	public BaseCase() {
		logger.info("[case]初始化类:" + this.getClass().getName());

		// 测试数据文件，文件名字必须和testcase的类名相同
		testfile = "TestData" + File.separator + this.getClass().getName().replace(".", File.separator) + ".xlsx";
		resultsMap = new TreeMap<Long, Integer>();
	}

	// 测试数据保存到二维数组testdata，sheet的名字必须和testng的测试方法相同都为test
	@DataProvider(name = "dataSource")
	public Object[][] dataSource(Method method) {
		logger.info("[BaseCase]开始准备测试数据...");

		Object[][] testdata = null;
		// 测试方法默认为test
		testdata = ParseXLSX.getDataValue(testfile, "test");
		return testdata;
	}

	@BeforeSuite
	public void init() {
//		logger.info("开始执行case: " + this.getClass().getName());
		logger.info("[BaseCase]启动AppDriver...");
		DriverFactory.getAppiumDriver();
	}

	@BeforeClass
	public void init_fields() {
		logger.info("================================================================");
		
		logger.info("[BaseCase]开始执行case: " + this.getClass().getName());
		logger.info("[BaseCase]初始化business...");
		Class clazz = this.getClass();
		Field[] fields = clazz.getDeclaredFields();

		for (Field f : fields) {
			String type = f.getType().getName();
			if (type.startsWith("com.nonobank.apps.business")) {
				f.setAccessible(true);
				try {
					f.set(this, Class.forName(type).newInstance());
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	@AfterClass
	public void after_class(){
		AppiumDriver<WebElement> appiumDriver = DriverFactory.getAppiumDriver();
		AppActions appActions = null;
		
		if(appiumDriver instanceof AndroidDriver<?>){
			appActions = new AndroidActions((AndroidDriver<WebElement>)appiumDriver);
		}else{
			appActions = new IOSActions((IOSDriver<WebElement>)appiumDriver);
		}
		
		logger.info("[BaseCase]重置App...");
		appActions.resetApp();
	}
	
	@AfterSuite
	public void after_suite(){
		AppiumDriver<WebElement> appiumDriver = DriverFactory.getAppiumDriver();
		AppActions appActions = null;
		
		if(appiumDriver instanceof AndroidDriver<?>){
			appActions = new AndroidActions((AndroidDriver<WebElement>)appiumDriver);
		}else{
			appActions = new IOSActions((IOSDriver<WebElement>)appiumDriver);
		}
		
		logger.info("[BaseCase]关闭App...");
		appActions.closeApp();
	}
}
