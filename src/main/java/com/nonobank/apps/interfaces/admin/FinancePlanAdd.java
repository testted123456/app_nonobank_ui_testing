package com.nonobank.apps.interfaces.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.nonobank.apps.interfaces.util.SendRequest;
import com.nonobank.apps.interfaces.util.SendRequestAlone;


public class FinancePlanAdd {
	public static Logger logger = LogManager.getLogger(FinancePlanAdd.class);
	public static List<HashMap<String, String>> params = new ArrayList<HashMap<String, String>>();
	
	public static String url = "https://www.sit.nonobank.com/Admin/Licai/FinancePlanAdd";
	
//	public static void financePlan(){
//		HashMap<String, String> requestParams = new HashMap<String, String>();
//		requestParams.put("title", "精选计划9999期");
//		requestParams.put("scope", scope);
//		requestParams.put("price", "100000");
//		requestParams.put("price_increment","100");
//		requestParams.put("price_min", "100");
//		requestParams.put("price_adjust", ""0);
//		requestParams.put("price_max", "10000");
//		requestParams.put("rate_min", "10%");
//		requestParams.put("rate_max", "12%");
//		requestParams.put("stop_bidding_days", "");
//		requestParams.put("auto_bid", "1");
//		requestParams.put("earnings_intro", earnings_intro);
//		requestParams.put("buy_limit", buy_limit);
//		requestParams.put("redeem_normal_way", redeem_normal_way);
//		requestParams.put("redeem_other_way", redeem_other_way);
//		requestParams.put("finish_date", finish_date);
//		requestParams.put("slogan", slogan);
//		requestParams.put("explanation", explanation);
//		requestParams.put("expect", expect);
//		requestParams.put("expect_unit", expect_unit);
//		requestParams.put("start_date", start_date);
//		requestParams.put("operator", operator);
//		requestParams.put("status", status);
//		requestParams.put("protect_plan", protect_plan);
//		requestParams.put("transfer_enable", transfer_enable);
//		requestParams.put("need_bankcode", need_bankcode);
//		requestParams.put("show_scope", show_scope);
//		requestParams.put("template", template);
//		requestParams.put("rate_show", rate_show);
//		requestParams.put("suffix", suffix);
//		requestParams.put("user_level", user_level);
//		requestParams.put("collection_mode", collection_mode);
//		requestParams.put("borrows_range", borrows_range);
//		requestParams.put("show_content", show_content);
//		requestParams.put("is_auto_clone", is_auto_clone);
//		requestParams.put("rate_desc", rate_desc);
//		String response = SendRequestAlone.httpCommonPost(url, requestParams);	
//	}
	
	
	
}
