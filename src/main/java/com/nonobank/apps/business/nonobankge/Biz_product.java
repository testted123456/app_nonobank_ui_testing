package com.nonobank.apps.business.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.nonobank.apps.page.nonobankge.Page_product;

public class Biz_product {
	public static Logger logger = LogManager.getLogger(Biz_product.class);
	Page_product page_product=new Page_product();
	
	public void click_xkzq(){
		logger.info("[Biz点击新客专区]");
		page_product.click_xkzq();
	}
	public void click_txjh(){
		logger.info("[Biz点击贴心计划]");
		page_product.click_txjh();
	}
	public void click_yys(){
		logger.info("[Biz点击月月升]");
		page_product.click_yys();
	}
	public void click_nny(){
		logger.info("[Biz点击诺诺盈]");
		page_product.click_nny();
	}
	public void click_tstz(){
		logger.info("[Biz点击特色投资]");
		page_product.click_tstz();
	}
	public void click_zzzq(){
		logger.info("[Biz点击债转专区]");
		page_product.click_zzzq();
	}
	
	
}
