package com.nonobank.apps.page.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.nonobank.apps.page.base.BasePage;

public class Page_setting extends BasePage{
	public static Logger logger = LogManager.getLogger(Page_setting.class);
	
	public void click_maiziPass(){
		logger.info("[Page]点击麦子通行证。。。。。。");
		WebElement element = objectRepository.getWebElement("麦子通行证");
		element.click();
	}
	public void click_realNameAuth(){
		logger.info("[Page]点击实名认证。。。。。。");
		WebElement element = objectRepository.getWebElement("实名认证");
		element.click();
	}
	public String getText_realNameAuthStatus(){
		logger.info("[Page]获取实名认证状态。。。。。。");
		WebElement element = objectRepository.getWebElement("实名认证状态");
		String realNameAuthStatus=element.getText();
		return realNameAuthStatus;
	}
	public void click_bindingMobile(){
		logger.info("[Page]点击绑定手机。。。。。。");
		WebElement element = objectRepository.getWebElement("绑定手机");
		element.click();
	}
	public String getText_bindingMobileCode(){
		logger.info("[Page]获取绑定手机号码。。。。。。");
		WebElement element = objectRepository.getWebElement("绑定手机号码");
		String bindingMobileCode=element.getText();
		return bindingMobileCode;
	}
	public void click_shippingAddress(){
		logger.info("[Page]点击收货地址。。。。。。");
		WebElement element = objectRepository.getWebElement("收货地址");
		element.click();
	}
	public void click_securityAccount(){
		logger.info("[Page]点击账号安全。。。。。。");
		WebElement element = objectRepository.getWebElement("账号安全");
		element.click();
	}
	public void click_feedback(){
		logger.info("[Page]点击我要反馈。。。。。。");
		WebElement element = objectRepository.getWebElement("我要反馈");
		element.click();
	}
	public String getText_version(){
		logger.info("[Page]获取版本号。。。。。。");
		WebElement element = objectRepository.getWebElement("版本号");
		String version=element.getText();
		return version;
	}
	public String getText_hotline(){
		logger.info("[Page]获取客服热线。。。。。。");
		WebElement element = objectRepository.getWebElement("客服热线");
		String hotline=element.getText();
		return hotline;
	}
	public void click_logout(){
		logger.info("[Page]点击安全退出。。。。。。");
		WebElement element = objectRepository.getWebElement("安全退出");
		element.click();
	}
	
}
