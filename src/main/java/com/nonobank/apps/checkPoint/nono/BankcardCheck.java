package com.nonobank.apps.checkPoint.nono;

import java.sql.Connection;

import com.nonobank.apps.utils.data.Assertion;
import com.nonobank.apps.utils.db.DBUtils;

public class BankcardCheck {

	public static void verify_bankcard(String mobile){
		Connection con = DBUtils.getConnection("nono", "nono");
		String sql="select id from user_info where mobile_num='"+mobile+"' and user_type='1' and status='1'";
		String user_id=String.valueOf(DBUtils.getOneObject(con, sql));
		
		String sql2="select count(*) from user_bankcard_info where user_id='"+user_id+"'";
		String actual=String.valueOf(DBUtils.getOneObject(con, sql2));
		Assertion.assertEquals("1", actual, BankcardCheck.class, "设置银行卡-数据库检查");
		DBUtils.closeConnection("nono");	
	}
}
