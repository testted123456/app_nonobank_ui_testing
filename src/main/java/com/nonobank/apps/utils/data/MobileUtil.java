package com.nonobank.apps.utils.data;

import java.sql.Connection;

import com.nonobank.apps.utils.db.DBUtils;


public class MobileUtil {

	public static String getUnRegisterMobile() {
		String mobile = RandomUtils.getInstance().generateMobilePhoneNumber();
		Connection conn = DBUtils.getConnection("nono","nono");
		String sql = "select count(*) from user_info WHERE mobile_num='" + mobile + "'";
		String count =  String.valueOf(DBUtils.getOneObject(conn, sql));
		while (Integer.parseInt(count) > 0) {
			mobile = RandomUtils.getInstance().generateMobilePhoneNumber();
			sql = "select count(*) from user_info WHERE mobile_num='" + mobile + "'";
			count =  String.valueOf(DBUtils.getOneObject(conn, sql));
		}
		DBUtils.closeConnection("nono");
		return mobile;
	}

	public static String getUserName(String mobile){
		Connection conn = DBUtils.getConnection("nono","nono");
		String sql = "select user_name from user_info WHERE mobile_num='" + mobile + "'";
		String user_name=String.valueOf(DBUtils.getOneObject(conn, sql));
		return user_name;	
	}
	
	
}
