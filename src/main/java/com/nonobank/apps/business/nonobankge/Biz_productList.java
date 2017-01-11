package com.nonobank.apps.business.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.nonobank.apps.page.nonobankge.Page_productList;

public class Biz_productList {
	public static Logger logger = LogManager.getLogger(Biz_productList.class);
	
	Page_productList page_productList=new Page_productList();
	
	public void click_byProductName(String productName){
		logger.info("[Biz通过产品名点击]");
		page_productList.click_byProductName(productName);	
	}
	
}
