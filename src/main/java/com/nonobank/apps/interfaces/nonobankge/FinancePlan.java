package com.nonobank.apps.interfaces.nonobankge;

import java.sql.Connection;

import com.nonobank.apps.utils.db.DBUtils;

public class FinancePlan {
	public static void featuredPlan(){		
		Connection con = DBUtils.getConnection("nono", "nono");
		String sql="insert into finance_plan(title,scope,price,price_increment,price_min,"
				+ "price_max,rate_min,rate_max,stop_bidding_days,auto_bid,earnings_intro,"
				+ "publish_date,finish_date,slogan,expect,start_date,STATUS,protect_plan,"
				+ "show_scope,recommend_scope,rate_show,user_level) values('精选计划','11',"
				+ "'1000000','100','100','10000','8','12','5','1','精选计划',DATE(NOW()),"
				+ "'2018-01-01','精选计划','1',DATE(NOW()),'3','质量保障服务计划','6','3','12%','0,1,2,3')";
		DBUtils.insertOneObject(con, sql);
	}
	public static void monthRise(){		
		Connection con = DBUtils.getConnection("nono", "nono");
		String sql="insert into finance_plan(title,scope,price,price_increment,price_min,"
				+ "price_max,rate_min,rate_max,stop_bidding_days,auto_bid,earnings_intro,"
				+ "publish_date,finish_date,slogan,expect,start_date,STATUS,protect_plan,"
				+ "show_scope,recommend_scope,rate_show,user_level,rate_desc) values('月月升','11',"
				+ "'1000000','100','100','10000','8','12','5','1','月月升',DATE(NOW()),"
				+ "'2018-01-01','月月升','1',DATE(NOW()),'3','质量保障服务计划','6','3','12%','0,1,2,3','月月升')";
		DBUtils.insertOneObject(con, sql);
	}
	public static void newPlan(){		
		Connection con = DBUtils.getConnection("nono", "nono");
		String sql="insert into finance_plan(title,scope,price,price_increment,price_min,"
				+ "price_max,rate_min,rate_max,stop_bidding_days,auto_bid,earnings_intro,"
				+ "publish_date,finish_date,slogan,expect,start_date,STATUS,protect_plan,"
				+ "show_scope,recommend_scope,rate_show,user_level,rate_desc) values('新客计划','11',"
				+ "'1000000','100','100','10000','8','12','5','1','新客计划',DATE(NOW()),"
				+ "'2018-01-01','新客计划','1',DATE(NOW()),'3','质量保障服务计划','6','3','12%','0,1,2,3','新客计划')";
		DBUtils.insertOneObject(con, sql);
	}
	public static void caringPlan(){		
		Connection con = DBUtils.getConnection("nono", "nono");
		String sql="insert into finance_plan(title,scope,price,price_increment,price_min,"
				+ "price_max,rate_min,rate_max,stop_bidding_days,auto_bid,earnings_intro,"
				+ "publish_date,finish_date,slogan,expect,start_date,STATUS,protect_plan,"
				+ "show_scope,recommend_scope,rate_show,user_level,rate_desc) values('贴心计划','11',"
				+ "'1000000','100','100','10000','8','12','5','1','贴心计划',DATE(NOW()),"
				+ "'2018-01-01','贴心计划','1',DATE(NOW()),'3','质量保障服务计划','6','3','12%','0,1,2,3','贴心计划')";
		DBUtils.insertOneObject(con, sql);
	}
	public static void nonoying(){		
		Connection con = DBUtils.getConnection("nono", "nono");
		String sql="insert into finance_plan(title,scope,price,price_increment,price_min,"
				+ "price_max,rate_min,rate_max,stop_bidding_days,auto_bid,earnings_intro,"
				+ "publish_date,finish_date,slogan,expect,start_date,STATUS,protect_plan,"
				+ "show_scope,recommend_scope,rate_show,user_level,rate_desc) values('诺诺盈','11',"
				+ "'1000000','100','100','10000','8','12','5','1','诺诺盈',DATE(NOW()),"
				+ "'2018-01-01','诺诺盈','1',DATE(NOW()),'3','质量保障服务计划','6','3','12%','0,1,2,3','诺诺盈')";
		DBUtils.insertOneObject(con, sql);
	}
	public static void debtPlan(){		
		Connection con = DBUtils.getConnection("nono", "nono");
		String sql="insert into finance_plan(title,scope,price,price_increment,price_min,"
				+ "price_max,rate_min,rate_max,stop_bidding_days,auto_bid,earnings_intro,"
				+ "publish_date,finish_date,slogan,expect,start_date,STATUS,protect_plan,"
				+ "show_scope,recommend_scope,rate_show,user_level,rate_desc) values('债转计划','11',"
				+ "'1000000','100','100','10000','8','12','5','1','债转计划',DATE(NOW()),"
				+ "'2018-01-01','债转计划','1',DATE(NOW()),'3','质量保障服务计划','6','3','12%','0,1,2,3','债转计划')";
		DBUtils.insertOneObject(con, sql);
	}
	
	
}
