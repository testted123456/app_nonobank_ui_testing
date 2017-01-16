package com.nonobank.apps.business.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.nonobank.apps.page.nonobankge.Page_common;
import com.nonobank.apps.page.nonobankge.Page_productList;
import com.nonobank.apps.utils.data.Assertion;

public class Biz_productList {
	public static Logger logger = LogManager.getLogger(Biz_productList.class);
	
	Page_productList page_productList=new Page_productList();
	Page_common page_common=new Page_common();
	
	public void click_byProductName(String productName,String expectMessage){
		logger.info("[Biz通过产品名点击]");
		page_productList.click_byProductName(productName);	
		handleResult(expectMessage);
	}
	private void handleResult(String expectMessage) {
		switch (expectMessage) {
		case "":
			String expect="";
			String actual=page_common.getText_title();
			Assertion.assertEquals(expect, actual, Biz_bindingBankcard.class, "");
			break;
		default:
			expect="";
			actual=page_common.getText_title();
			Assertion.assertEquals(expect, actual, Biz_bindingBankcard.class, "");
			break;
		}
	}
	
}
