package com.nonobank.apps.business.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.nonobank.apps.page.nonobankge.Page_common;
import com.nonobank.apps.page.nonobankge.Page_product;
import com.nonobank.apps.utils.data.Assertion;
import com.nonobank.apps.utils.variable.StringHandle;

public class Biz_product {
	public static Logger logger = LogManager.getLogger(Biz_product.class);
	Page_product page_product=new Page_product();
	Page_common page_common=new Page_common();
	
	public void click_productName(String productName){
		logger.info("[Biz根据productName，点击相应产品]");
	
		while(!page_product.isExist_productName(productName)){
			page_product.swipe_productList();
		}
		page_product.click_product(productName);
	}
	
	
	public void click_regularInvest(){
		logger.info("[Biz点击定投]");
		page_product.click_regularInvest();
	}
	public void click_directInvest(){
		logger.info("[Biz点击直投]");
		page_product.click_directInvest();
	}
	public void click_debtEquity(){
		logger.info("[Biz点击债转]");
		page_product.click_debtEquity();
		String progress_str=page_product.getText_progress();
		double progress=StringHandle.numFromString(progress_str);
		if(progress<100){
			page_product.click_product();
		}
		
	}


	
}
