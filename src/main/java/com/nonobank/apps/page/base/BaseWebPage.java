package com.nonobank.apps.page.base;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.nonobank.apps.driver.DriverFactory;
import com.nonobank.apps.objectRepository.WebObjectRepository;

public class BaseWebPage {
	
	public static Logger logger = LogManager.getLogger(BaseWebPage.class);
	
	protected WebDriver webDriver;
	protected WebObjectRepository webObjectRepository;
	protected String xmlFile;
	
	public BaseWebPage(){
		webDriver = DriverFactory.getWebDriver();
		this.xmlFile = "resources" + File.separator + "elements" + File.separator
				+ this.getClass().getName().replace(".", File.separator) + ".xml";
		webObjectRepository = new WebObjectRepository(webDriver, xmlFile);
	}
	
	public void setWebDriver(WebDriver webDriver){
		this.webDriver = webDriver;
	}

}
