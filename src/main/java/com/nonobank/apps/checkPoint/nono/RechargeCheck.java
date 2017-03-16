package com.nonobank.apps.checkPoint.nono;

import java.sql.Connection;

import com.nonobank.apps.utils.data.Assertion;
import com.nonobank.apps.utils.db.DBUtils;

public class RechargeCheck {
	public static void verify_recharge(String mobile,String accountBalance){
		
		Connection con = DBUtils.getConnection("nono", "nono");
		String sql="select id from user_info where mobile_num='"+mobile+"' and user_type='1' and status='1'";
		String user_id=String.valueOf(DBUtils.getOneObject(con, sql));
		
		String sql2="select balance from finance_account where user_id='"+user_id+"' and role_id='7'";
		String balance=String.valueOf(DBUtils.getOneObject(con, sql2));
		Assertion.assertEquals(accountBalance, balance, RechargeCheck.class, "充值-数据库检查");
		DBUtils.closeConnection("nono");
			
	}
}
