package com.nonobank.apps.page.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import com.nonobank.apps.page.base.BasePage;
import com.nonobank.apps.utils.variable.StringHandle;

public class Page_selectCashCoupon extends BasePage{
	public static Logger logger = LogManager.getLogger(Page_selectCashCoupon.class);

	public String getText_cashCouponShow(){
		logger.info("[Page]获取现金券展示。。。。。。");
		WebElement element = objectRepository.getWebElement("现金券展示");
		String cashCouponShow=element.getText();
		return cashCouponShow;
	}
	public double getText_cashCouponAmount(){
		logger.info("[Page]获取现金券金额。。。。。。");
		WebElement element = objectRepository.getWebElement("现金券金额");
		String cashCouponAmount_str=element.getText();
		double cashCouponAmount=StringHandle.numFromString(cashCouponAmount_str);
		return cashCouponAmount;
	}
	public String getText_cashCouponType(){
		logger.info("[Page]获取现金券类型。。。。。。");
		WebElement element = objectRepository.getWebElement("现金券类型");
		String cashCouponType=element.getText();
		return cashCouponType;
	}
	public String getText_cashCouponSuperposition(){
		logger.info("[Page]获取现金券叠加。。。。。。");
		WebElement element = objectRepository.getWebElement("现金券叠加");
		String cashCouponSuperposition=element.getText();
		return cashCouponSuperposition;
	}
	public String getText_cashCouponLimit(){
		logger.info("[Page]获取现金券限制。。。。。。");
		WebElement element = objectRepository.getWebElement("现金券限制");
		String cashCouponLimit=element.getText();
		return cashCouponLimit;
	}
	public String getText_cashCouponEnd(){
		logger.info("[Page]获取现金券结束日期。。。。。。");
		WebElement element = objectRepository.getWebElement("现金券结束日期");
		String cashCouponEnd=element.getText();
		return cashCouponEnd;
	}
	public String getText_cashCouponState(){
		logger.info("[Page]获取现金券状态。。。。。。");
		WebElement element = objectRepository.getWebElement("现金券状态");
		String cashCouponState=element.getText();
		return cashCouponState;
	}
	
	
	
}
