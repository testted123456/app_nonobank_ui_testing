package com.nonobank.apps.business.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.nonobank.apps.page.nonobankge.Page_common;
import com.nonobank.apps.page.nonobankge.Page_setting;
import com.nonobank.apps.utils.data.Assertion;


public class Biz_setting {
	public static Logger logger = LogManager.getLogger(Biz_setting.class);
	Page_setting page_setting=new Page_setting();
	Page_common page_common=new Page_common();
	
	public void click_maiziPass(String expectMessage){
		logger.info("[Biz]点击麦子通行证。。。。。。");
		page_setting.click_maiziPass();
		handleResult(expectMessage);
	}
	public void click_realNameAuth(String expectMessage){
		logger.info("[Biz]点击实名认证。。。。。。");
		page_setting.click_realNameAuth();
		handleResult(expectMessage);
	}
	public String getText_realNameAuthStatus(){
		logger.info("[Biz]获取实名认证状态。。。。。。");
		String realNameAuthStatus=page_setting.getText_realNameAuthStatus();
		return realNameAuthStatus;
	}
	public void click_bindingMobile(String expectMessage){
		logger.info("[Biz]点击绑定手机。。。。。。");
		page_setting.click_bindingMobile();
		handleResult(expectMessage);
	}
	public String getText_bindingMobileCode(){
		logger.info("[Biz]获取绑定手机号码。。。。。。");
		String bindingMobileCode=page_setting.getText_bindingMobileCode();
		return bindingMobileCode;
	}
	public void click_shippingAddress(String expectMessage){
		logger.info("[Biz]点击收货地址。。。。。。");
		page_setting.click_shippingAddress();
		handleResult(expectMessage);
	}
	public void click_securityAccount(String expectMessage){
		logger.info("[Biz]点击账号安全。。。。。。");
		page_setting.click_securityAccount();
		handleResult(expectMessage);
	}
	public void click_feedback(String expectMessage){
		logger.info("[Biz]点击我要反馈。。。。。。");
		page_setting.click_feedback();
		handleResult(expectMessage);
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
	public void click_logout(String expectMessage){
		logger.info("[Biz]点击安全退出。。。。。。");
		page_setting.click_logout();
		page_setting.sleep(1000);
		page_setting.click_logout_enter();
		handleResult(expectMessage);
	}
	
	private void handleResult(String expectMessage) {
		switch (expectMessage) {
		case "退出":
			boolean isExist_me=page_common.isExist_me();
			Assertion.assertEquals(true, isExist_me, Biz_bindingBankcard.class, "退出登录成功");
			break;
		case "实名认证":
			String except="实名认证";
			String acturl=page_common.getText_title();
			Assertion.assertEquals(except, acturl, Biz_bindingBankcard.class, "实名认证页面");
			break;
		case "绑定手机":
			except="绑定手机";
			acturl=page_common.getText_title();
			Assertion.assertEquals(except, acturl, Biz_bindingBankcard.class, "绑定手机页面");
			break;
		case "设置收货地址":
			except="设置收货地址";
			acturl=page_common.getText_title();
			Assertion.assertEquals(except, acturl, Biz_bindingBankcard.class, "设置收货地址页面");
			break;
		case "账户安全":
			except="账户安全";
			acturl=page_common.getText_title();
			Assertion.assertEquals(except, acturl, Biz_bindingBankcard.class, "账户安全页面");
			break;
		case "我要反馈":
			except="我要反馈";
			acturl=page_common.getText_title();
			Assertion.assertEquals(except, acturl, Biz_bindingBankcard.class, "我要反馈页面");
			break;
		default:
		
			break;
		}
	}
	
}
