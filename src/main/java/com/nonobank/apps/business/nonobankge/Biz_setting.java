package com.nonobank.apps.business.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.nonobank.apps.page.nonobankge.Page_setting;


public class Biz_setting {
	public static Logger logger = LogManager.getLogger(Biz_setting.class);
	Page_setting page_setting=new Page_setting();
	
	public void click_maiziPass(){
		logger.info("[Biz]点击麦子通行证。。。。。。");
		page_setting.click_maiziPass();
	}
	public void click_realNameAuth(){
		logger.info("[Biz]点击实名认证。。。。。。");
		page_setting.click_realNameAuth();
	}
	public String getText_realNameAuthStatus(){
		logger.info("[Biz]获取实名认证状态。。。。。。");
		String realNameAuthStatus=page_setting.getText_realNameAuthStatus();
		return realNameAuthStatus;
	}
	public void click_bindingMobile(){
		logger.info("[Biz]点击绑定手机。。。。。。");
		page_setting.click_bindingMobile();
	}
	public String getText_bindingMobileCode(){
		logger.info("[Biz]获取绑定手机号码。。。。。。");
		String bindingMobileCode=page_setting.getText_bindingMobileCode();
		return bindingMobileCode;
	}
	public void click_shippingAddress(){
		logger.info("[Biz]点击收货地址。。。。。。");
		page_setting.click_shippingAddress();
	}
	public void click_securityAccount(){
		logger.info("[Biz]点击账号安全。。。。。。");
		page_setting.click_securityAccount();
	}
	public void click_feedback(){
		logger.info("[Biz]点击我要反馈。。。。。。");
		page_setting.click_feedback();
	}
	public String getText_version(){
		logger.info("[Biz]获取版本号。。。。。。");
		String version=page_setting.getText_version();
		return version;
	}
	public String getText_hotline(){
		logger.info("[Biz]获取客服热线。。。。。。");
		String hotline=page_setting.getText_hotline();
		return hotline;
	}
	public void click_logout(){
		logger.info("[Biz]点击安全退出。。。。。。");
		page_setting.click_logout();
	}
	
	
	
}
