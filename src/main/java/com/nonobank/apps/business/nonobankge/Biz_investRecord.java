package com.nonobank.apps.business.nonobankge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.nonobank.apps.page.nonobankge.Page_investment_record;

public class Biz_investRecord {
	public static Logger logger = LogManager.getLogger(Biz_investRecord.class);
	Page_investment_record page_investment_record=new Page_investment_record();
	
	public void getInvestRecord(String category){
		logger.info("[Biz_投资记录]");
		switch (category) {
		case "计划类":
			page_investment_record.click_plan_class();
			break;
		case "诺诺盈":
			page_investment_record.click_nonoying_class();
			break;
		case "债转类":
			page_investment_record.click_debtswap_class();
			break;
		default:
			break;
		}	
		String investPlanName=page_investment_record.getText_investPlanName();
		String investPlanMoney=page_investment_record.getText_investPlanMoney();
		logger.info("投资计划名称："+investPlanName+",投资计划金额"+investPlanMoney);	
	}
	
	
	
}
