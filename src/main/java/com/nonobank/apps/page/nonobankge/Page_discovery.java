package com.nonobank.apps.page.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.nonobank.apps.page.base.BasePage;

public class Page_discovery extends BasePage {
	public static Logger logger = LogManager.getLogger(Page_discovery.class);
	
	public void click_integretion_center_shopping(){
		logger.info("[Page]点击综合中心商城。。。。。。");
		WebElement element = objectRepository.getWebElement("商城");
		element.click();	
	}
	
	public void click_integretion_center_community(){
		logger.info("[Page]点击综合中心社区。。。。。。");
		WebElement element = objectRepository.getWebElement("社区");
		element.click();	
	}
	
	public void click_integretion_center_activity(){
		logger.info("[Page]点击综合中心活动。。。。。。");
		WebElement element = objectRepository.getWebElement("活动");
		element.click();	
	}
	
	public void click_integretion_center_entertainment(){
		logger.info("[Page]点击综合中心娱乐。。。。。。");
		WebElement element = objectRepository.getWebElement("娱乐");
		element.click();	
	}
	
	public void click_integretion_center_live_telecast(){
		logger.info("[Page]点击综合中心直播。。。。。。");
		WebElement element = objectRepository.getWebElement("直播");
		element.click();		
	}
	
	public void click_integretion_center_mxd(){
		logger.info("[Page]点击综合中心名校贷。。。。。。");
		WebElement element = objectRepository.getWebElement("名校贷");
		element.click();		
	}
	
	public void click_understand_nono_componey_introduction(){
		logger.info("[Page]点击了解诺诺公司介绍。。。。。。");
		WebElement element = objectRepository.getWebElement("公司介绍");
		element.click();		
	}
	
	public void click_understand_nono_operation_data(){
		logger.info("[Page]点击了解诺诺运营数据。。。。。。");
		WebElement element = objectRepository.getWebElement("运营数据");
		element.click();		
	}
	
	public void click_understand_nono_novice_class(){
		logger.info("[Page]点击了解诺诺新手课堂。。。。。。");
		WebElement element = objectRepository.getWebElement("新手课堂");
		element.click();		
	}
	
	public void click_understand_nono_news(){
		logger.info("[Page]点击了解诺诺公司新闻。。。。。。");
		WebElement element = objectRepository.getWebElement("公司新闻");
		element.click();		
	}
	
	
	
	

}
