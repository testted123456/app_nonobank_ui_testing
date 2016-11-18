package com.nonobank.apps.page.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.nonobank.apps.page.base.BasePage;

public class Page_product extends BasePage{
	public static Logger logger = LogManager.getLogger(Page_product.class);
	
	public void click_nonoWallet(){
		logger.info("[Page]点击诺诺钱包。。。。。。");
		WebElement element = objectRepository.getWebElement("诺诺钱包");
		element.click();
	}
	public String getText_nnmoney_rate(){
		logger.info("[Page]获取诺诺钱包利息。。。。。。");
		WebElement element = objectRepository.getWebElement("诺诺钱包利息");
		String nnmoney_rate=element.getText();
		return nnmoney_rate;
	}
	public void click_xkzq(){
		logger.info("[Page]点击新客专区。。。。。。");
		WebElement element = objectRepository.getWebElement("新客专区");
		element.click();
	}
	public String getText_xkzq_rate(){
		logger.info("[Page]获取新客专区利息。。。。。。");
		WebElement element = objectRepository.getWebElement("新客专区利息");
		String xkzq_rate=element.getText();
		return xkzq_rate;
	}
	public void click_yys(){
		logger.info("[Page]点击月月升。。。。。。");
		WebElement element = objectRepository.getWebElement("月月升");
		element.click();
	}
	public String getText_yys_rate(){
		logger.info("[Page]获取月月升利息。。。。。。");
		WebElement element = objectRepository.getWebElement("月月升利息");
		String yys_rate=element.getText();
		return yys_rate;
	}
	public void click_dqtz(){
		logger.info("[Page]点击短期投资。。。。。。");
		WebElement element = objectRepository.getWebElement("短期投资");
		element.click();
	}
	public String getText_dqtz_rate(){
		logger.info("[Page]获取短期投资利息。。。。。。");
		WebElement element = objectRepository.getWebElement("短期投资利息");
		String dqtz_rate=element.getText();
		return dqtz_rate;
	}
	public void click_cqtz(){
		logger.info("[Page]点击长期投资。。。。。。");
		WebElement element = objectRepository.getWebElement("长期投资");
		element.click();
	}
	public String getText_cqtz_rate(){
		logger.info("[Page]获取长期投资利息。。。。。。");
		WebElement element = objectRepository.getWebElement("长期投资利息");
		String cqtz_rate=element.getText();
		return cqtz_rate;
	}
	public void click_tstz(){
		logger.info("[Page]点击特色投资。。。。。。");
		WebElement element = objectRepository.getWebElement("特色投资");
		element.click();
	}
	public String getText_tstz_rate(){
		logger.info("[Page]获取特色投资利息。。。。。。");
		WebElement element = objectRepository.getWebElement("特色投资利息");
		String tstz_rate=element.getText();
		return tstz_rate;
	}
	public void click_zzzq(){
		logger.info("[Page]点击债转专区。。。。。。");
		WebElement element = objectRepository.getWebElement("债转专区");
		element.click();
	}
	public String getText_zzzq_rate(){
		logger.info("[Page]获取债转专区利息。。。。。。");
		WebElement element = objectRepository.getWebElement("债转专区利息");
		String zzzq_rate=element.getText();
		return zzzq_rate;
	}
	
	
	
}
