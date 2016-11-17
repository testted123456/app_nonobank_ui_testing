package com.nonobank.apps.utils.data;

import java.sql.Connection;

import com.nonobank.apps.utils.db.DBUtils;

public class BankcodeUtils {
	
	public static void deleteBankcode(){
		Connection con = DBUtils.getConnection("nono", "nono");
		String sql="delete from bank_code where code='YJBSCHEYC'";
		DBUtils.deleteOneObject(con, sql);
		DBUtils.closeConnection("nono","nono");
	}
	public static void insertBankcode() {
		Connection con = DBUtils.getConnection("nono", "nono");
		String sql = "insert into bank_code(p_id,code,status,overdue_time) values('83','YJBSCHEYC','3','2017-11-30 10:12:00')";
		DBUtils.insertOneObject(con, sql);
		DBUtils.closeConnection("nono","nono");
	}
}
