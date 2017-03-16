package com.nonobank.apps.checkPoint.nono;

import java.sql.Connection;

import com.nonobank.apps.utils.data.Assertion;
import com.nonobank.apps.utils.db.DBUtils;

public class RealNameCheck {
	public static void verify_realName(String mobile){
		Connection con = DBUtils.getConnection("nono", "nono");
		String sql="select COUNT(*) from user_info where mobile_num='"+mobile+"' and user_type='1' and id_num is not null and is_card='1' and status='1'";
		String actual=String.valueOf(DBUtils.getOneObject(con, sql));
		Assertion.assertEquals("1", actual, RealNameCheck.class, "实名认证-数据库检查");
		DBUtils.closeConnection("nono");
	}

}
