package com.nonobank.apps.business.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.nonobank.apps.page.nonobankge.Page_common;

public class Biz_common {
	public static Logger logger = LogManager.getLogger(Biz_common.class);
	
	Page_common page_common=new Page_common();
	
	public void click_home(){
		logger.info("[Biz]点击首页。。。。。。");
		System.out.println("-------------------------------------------------");
		page_common.click_home();
		System.out.println("-------------------------------------------------");
	}
	public void click_product(){
		logger.info("[Biz]点击产品。。。。。。");
		System.out.println("-------------------------------------------------");
		page_common.click_product();
		System.out.println("-------------------------------------------------");
	}
	public void click_find(){
		logger.info("[Biz]点击发现。。。。。。");
		System.out.println("-------------------------------------------------");
		page_common.click_find();
		System.out.println("-------------------------------------------------");
	}
	public double getText_getText_findNum(){
		logger.info("[Biz]获取发现数量。。。。。。");
		System.out.println("-------------------------------------------------");
		double findNum=page_common.getText_findNum();
		return findNum;	
	}
	public void click_me(){
		logger.info("[Biz]点击我的。。。。。。");
		System.out.println("-------------------------------------------------");
		page_common.click_me();
		System.out.println("-------------------------------------------------");
	}
	public String getText_title(){
		logger.info("[Biz]获取页面标题[title_name]。。。。。。");
		System.out.println("-------------------------------------------------");
		String title=page_common.getText_title();
		return title;
	}
	public String getText_title2(){
		logger.info("[Biz]获取页面标题2[tv_title]。。。。。。");
		System.out.println("-------------------------------------------------");
		String title2=page_common.getText_title2();
		return title2;
	}
	public void click_backBtn(){
		logger.info("[Biz]点击返回按钮。。。。。。");
		System.out.println("-------------------------------------------------");
		page_common.click_backBtn();
		System.out.println("-------------------------------------------------");
	}
	public String getText_rightTitle(){
		logger.info("[Biz]获取页面右侧标题。。。。。。");
		System.out.println("-------------------------------------------------");
		String rightTitle=page_common.getText_rightTitle();
		return rightTitle;
	}
	public void click_rightTitle(){
		logger.info("[Biz]点击页面右侧标题。。。。。。");
		System.out.println("-------------------------------------------------");
		page_common.click_rightTitle();
		System.out.println("-------------------------------------------------");
	}
	
	
	
	
}
