package com.nonobank.apps.checkPoint.nono;

import java.sql.Connection;
import com.nonobank.apps.utils.data.Assertion;
import com.nonobank.apps.utils.db.DBUtils;


public class RegisterCheck {
	public static void verify_register(String mobile){
		Connection con = DBUtils.getConnection("nono", "nono");
		String sql="select COUNT(*) from user_info where mobile_num='"+mobile+"' and user_type='1' and status='1'";
		String actual=String.valueOf(DBUtils.getOneObject(con, sql));
		Assertion.assertEquals("1", actual, RegisterCheck.class, "注册-数据库检查");
		DBUtils.closeConnection("nono");	
	}
}
