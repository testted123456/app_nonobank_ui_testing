package com.nonobank.apps.business.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.nonobank.apps.page.nonobankge.Page_common;
import com.nonobank.apps.page.nonobankge.Page_product;
import com.nonobank.apps.utils.data.Assertion;

public class Biz_product {
	public static Logger logger = LogManager.getLogger(Biz_product.class);
	Page_product page_product=new Page_product();
	Page_common page_common=new Page_common();
	
	public void click_xkzq(String expectMessage){
		logger.info("[Biz点击新客专区]");
		page_product.click_xkzq();
		handleResult(expectMessage);
	}
	public void click_txjh(String expectMessage){
		logger.info("[Biz点击贴心计划]");
		page_product.click_txjh();
		handleResult(expectMessage);
	}
	public void click_yys(String expectMessage){
		logger.info("[Biz点击月月升]");
		page_product.click_yys();
		handleResult(expectMessage);
	}
	public void click_nny(String expectMessage){
		logger.info("[Biz点击诺诺盈]");
		page_product.click_nny();
		handleResult(expectMessage);
	}
	public void click_tstz(String expectMessage){
		logger.info("[Biz点击特色投资]");
		page_product.click_tstz();
		handleResult(expectMessage);
	}
	public void click_zzzq(String expectMessage){
		logger.info("[Biz点击债转专区]");
		page_product.click_zzzq();
		handleResult(expectMessage);
	}
	private void handleResult(String expectMessage) {
		switch (expectMessage) {
		case "我的银行卡":
			String expect="我的银行卡";
			String actual=page_common.getText_title();
			Assertion.assertEquals(expect, actual, Biz_bindingBankcard.class, "绑卡成功");
			break;
		default:
			expect="设置银行卡";
			actual=page_common.getText_title();
			Assertion.assertEquals(expect, actual, Biz_bindingBankcard.class, "绑卡失败");
			break;
		}
	}
	
}
