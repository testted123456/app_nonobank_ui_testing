package com.nonobank.apps.interfaces.nonobankge;

import java.sql.Connection;

import com.nonobank.apps.utils.db.DBUtils;

public class bankCard {

	public static void bindingBankCard(String userId,String bankCardNo,String bankCode){		
		Connection con = DBUtils.getConnection("nono", "nono");
		String sql="insert into user_bankcard_info(user_id,bank_card_no,bank_code,is_default) values("+userId+","+bankCardNo+","+bankCode+",'1')";
		DBUtils.insertOneObject(con, sql);
		String sql2="insert into user_bankcard_auth(user_id,auth_type,auth_status,short_no) values("+userId+",2,1,"+bankCardNo+")";
		DBUtils.insertOneObject(con, sql2);
	}
	
}
