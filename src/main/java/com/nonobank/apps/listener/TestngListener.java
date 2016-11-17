package com.nonobank.apps.listener;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.nonobank.apps.actions.AndroidActions;
import com.nonobank.apps.actions.AppActions;
import com.nonobank.apps.actions.IOSActions;
import com.nonobank.apps.appium.AppiumOperation;
import com.nonobank.apps.driver.DriverFactory;
import com.nonobank.apps.testcase.base.BaseCase;
import com.nonobank.apps.utils.file.ParseProperties;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class TestngListener extends TestListenerAdapter {

	private static Logger logger = LogManager.getLogger(TestngListener.class);

	@Override
	public void onTestFailure(ITestResult tr) {
		super.onTestFailure(tr);
		String testcase = tr.getInstanceName();
		logger.error("用例" + testcase + "执行失败...");
		Throwable throwable = tr.getThrowable();

		if (null != throwable) {
			String detail = throwable.getMessage();
			logger.error("失败详细信息：" + detail);
		}

		BaseCase.resultsMap.put(tr.getStartMillis(), tr.getStatus());
		takeScreenShot(tr);
		
		AppiumDriver<WebElement> appiumDriver = DriverFactory.getAppiumDriver();
		AppActions appActions = null;
		
		if(appiumDriver instanceof AndroidDriver<?>){
			appActions = new AndroidActions((AndroidDriver<WebElement>)appiumDriver);
		}
		
		appActions.resetApp();
//		appActions.quit();
		String os = System.getProperties().getProperty("os.name");
		if (os.startsWith("Mac")){
			//zanshibuzuo
		}else{
			AppiumOperation.stopWindowsAppiumServer("4723");
			AppiumOperation.startWindowsServer("4723");
		}
		
		//AppiumOperation.stopWindowsAppiumServer(appiumServicePort);
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		String trName = tr.getName();
		super.onTestSkipped(tr);
		Throwable throwable = tr.getThrowable();

		if (null != throwable) {
			String detail = throwable.getMessage();
			logger.error(throwable.getLocalizedMessage());
			logger.error("失败详细信息：" + detail);
		}
		
		BaseCase.resultsMap.put(tr.getStartMillis(), tr.getStatus());
		logger.info(tr.getInstanceName() + " : " + trName + " Skipped...");
		takeScreenShot(tr);
		
		AppiumDriver<WebElement> appiumDriver = DriverFactory.getAppiumDriver();
		AppActions appActions = null;
		
		if(appiumDriver instanceof AndroidDriver<?>){
			appActions = new AndroidActions((AndroidDriver<WebElement>)appiumDriver);
		}else{
			appActions = new IOSActions((IOSDriver<WebElement>)appiumDriver);
		}
		
		appActions.resetApp();
//		appActions.quit();
	}

	@Override
	public void onTestSuccess(ITestResult tr) {
		super.onTestSuccess(tr);
		BaseCase.resultsMap.put(tr.getStartMillis(), tr.getStatus());
		logger.info(tr.getInstanceName() + " : " + tr.getName() + " Success...");
	}

	@Override
	public void onTestStart(ITestResult tr) {
		super.onTestStart(tr);
		logger.info(tr.getInstanceName() + " : " + tr.getName() + " Start...");
	}

	@Override
	public void onFinish(ITestContext testContext) {
		Iterator<ITestResult> listOfFailedTests = testContext.getFailedTests().getAllResults().iterator();
		while (listOfFailedTests.hasNext()) {
			ITestResult failedTest = listOfFailedTests.next();
			ITestNGMethod method = failedTest.getMethod();
			if (testContext.getFailedTests().getResults(method).size() > 1) {
				listOfFailedTests.remove();
			} else {
				if (testContext.getPassedTests().getResults(method).size() > 0) {
					listOfFailedTests.remove();
				}
			}
		}
	}

	/**
	 * 自动截图，保存图片到本地
	 * @param tr
	 */
	private void takeScreenShot(ITestResult tr) {

		logger.info("开始截图 : " + tr.getInstanceName() + " - " + tr.getName());

		Date currentTime = new Date();

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");

		String dateString = formatter.format(currentTime);

		AppiumDriver<WebElement> appiumDriver = DriverFactory.getAppiumDriver();

		String dir = ParseProperties.getInstance().getProperty("screenshot_dir") + File.separator +

				new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + File.separator + tr.getInstanceName()
				+ File.separator;

		File file = new File(dir);

		if (!file.exists()) {
			file.mkdir();
		}
		try {
			File srcFile = ((TakesScreenshot) appiumDriver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFile, new File(dir + File.separator + dateString + ".jpg"));
		} catch (Exception e) {
			logger.info("截图失败...");
		}
	}
}
