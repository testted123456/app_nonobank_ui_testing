package com.nonobank.apps.page.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.nonobank.apps.page.base.BasePage;

public class Page_member_mall extends BasePage {
	public static Logger logger = LogManager.getLogger(Page_member_mall.class);
	
	public void click_ordinery_members(){
		logger.info("[Page]点击会员商城普通。。。。。。");
		WebElement element = objectRepository.getWebElement("普通");
		element.click();
	}
	
	public void click_vip1(){
		logger.info("[Page]点击会员商城VIP。。。。。。");
		WebElement element = objectRepository.getWebElement("VIP1");
		element.click();
	}
	
	public void click_vip2(){
		logger.info("[Page]点击会员商城VIP2。。。。。。");
		WebElement element = objectRepository.getWebElement("VIP2");
		element.click();
	}
	
	public void click_vip3(){
		logger.info("[Page]点击会员商城VIP3。。。。。。");
		WebElement element = objectRepository.getWebElement("VIP3");
		element.click();
	}
	
	public void click_my_privilege_exchange(){
		logger.info("[Page]点击会员商城我的特权诺币兑换。。。。。。");
		WebElement element = objectRepository.getWebElement("诺币兑换");
		element.click();
	}
	
	public void click_withdraw_crash_free(){
		logger.info("[Page]点击会员商城我的特权免费提现。。。。。。");
		WebElement element = objectRepository.getWebElement("免费提现");
		element.click();
	}
	
	public void click_nono_money_addition(){
		logger.info("[Page]点击会员商城我的特权诺币加成。。。。。。");
		WebElement element = objectRepository.getWebElement("诺币加成");
		element.click();
	}
	
	public void click_birthday_present(){
		logger.info("[Page]点击会员商城我的特权生日礼遇。。。。。。");
		WebElement element = objectRepository.getWebElement("生日礼遇");
		element.click();
	}
	
	public void click_crash_coupon(){
		logger.info("[Page]点击会员商城我的特权专享现金券。。。。。。");
		WebElement element = objectRepository.getWebElement("专享现金券");
		element.click();
	}
	
	public void click_vip_activity(){
		logger.info("[Page]点击会员商城我的特权VIP活动。。。。。。");
		WebElement element = objectRepository.getWebElement("VIP活动");
		element.click();
	}
	
	public void click_investment_adviser(){
		logger.info("[Page]点击会员商城我的特权投资顾问。。。。。。");
		WebElement element = objectRepository.getWebElement("投资顾问");
		element.click();	
	}
	
	public void click_no_money(){
		logger.info("[Page]点击会员商城诺币。。。。。。");
		WebElement element = objectRepository.getWebElement("诺币");
		element.click();	
	}
	
	public void click_conversion_record(){
		logger.info("[Page]点击会员兑换记录。。。。。。");
		WebElement element = objectRepository.getWebElement("兑换记录");
		element.click();	
	}
}
