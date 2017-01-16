package com.nonobank.apps.testcase.base;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.csvreader.CsvWriter;
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
	public static List<List<String>> lst = new ArrayList<List<String>>();

	// 保存测试结果的map
	public static TreeMap<Long, Integer> resultsMap;
	public static String caseName = "请配置测试名称";
	public static String caseDescription = "请配置测试描述";
	public static String inputParams = "请配置输入参数";
	public static String actualResult = "请配置实际结果";
	public static String errorMessage = "请配置错误信息";
	public static int passCount = 0;
	public static int failCount = 0;

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
	@AfterMethod
	public void addData() {	
		if (actualResult.equals("成功")) {
			passCount++;
		} else {
			failCount++;
		}
		List<String> newLst = new ArrayList<>();
		newLst.add(caseName);
		newLst.add(caseDescription);
		newLst.add("用户手机号:" + inputParams);
		newLst.add(actualResult);
		newLst.add(errorMessage);
		lst.add(newLst);

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
	public void saveCSV() {
		try {
			OutputStream os = new FileOutputStream("./1.csv");
			CsvWriter writer = new CsvWriter(os, ',', Charset.forName("GBK"));
			String[] contents = { "case名称", "描述", "入参", "结果", "错误日志" };
			writer.writeRecord(contents);
			for (List<String> rowsData : lst) {
				List<String> list2 = new ArrayList<String>();
				for (String rowData : rowsData) {
					list2.add(rowData);
				}
				writer.writeRecord(list2.toArray(new String[list2.size()]));
			}
			String pass = ((double) passCount / (passCount + failCount)) * 100 + "%";
			String fail = (1 - ((double) passCount / (passCount + failCount))) * 100 + "%";
			String[] text = { "", "" };
			writer.writeRecord(text);
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
			String strDate = df.format(new Date());
			String[] endsTitle = { "最近一次运行时间", "成功case", "失败case", "成功率", "失败率" };
			writer.writeRecord(endsTitle);
			String[] endsValue = { strDate, passCount + "个", failCount + "个", pass, fail };
			writer.writeRecord(endsValue);
			writer.close();
			System.out.println(writer.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
