package com.nonobank.apps.utils.data;

import com.nonobank.apps.utils.db.DBUtils;

public class BusinessUtils {
	
	//完善联系人信息，上传身份照片
	public static void fullfillIdCardPhoto(String mobile){
//		Connection con = DBUtils.getNonoConnection();
		String sql1="select id from user_info where mobile_num="+mobile+";";
		String user_id = 
//				DBUtils.getOneObject(con, sql1).toString();
		DBUtils.getValues("nono", "user", sql1);
		String sql2="insert into user_file_audit_info(user_id,file_type_id,title,is_auditing) "
				+ "value("+user_id+",'1','身份证','1')";
//		DBUtils.update(con,sql2);
		DBUtils.updateValues("nono", "user", sql2);
		String sql3 = "select id from user_file_audit_info where user_id="+user_id+";";
		String file_audit_id = 
//				DBUtils.getOneObject(con,sql3).toString();
				DBUtils.getValues("nono", "user", sql3);
		String sql4="insert into user_file_info(file_audit_id,file_name,file_type,file_path,file_size) "
				+ "value("+file_audit_id+",'QQ截图未命名.png','image/x-png','0a9635bcae3e54732a2dde65d5e942e00.png','270592')";
//		DBUtils.update(con,sql4);
		DBUtils.updateValues("nono", "user", sql4);
		DBUtils.closeConnection("nono", "user");
	}
	
	//录制视频
	public static void insertVedio(String mobile){
		String sql1 = "select id from user_info where mobile_num='" + mobile + "'";
		String userId = DBUtils.getValues("nono", "user", sql1);
		String sql2 = "select id from borrows where user_id='" + userId + "'";
		String boId = DBUtils.getValues("nono", "loan", sql2);
		String sql3 = "insert into borrows_archive(bo_id,keyword,bo_ext_param,content,is_confirm,is_audit,am_audit_id,am_audit_time,am_op_time) "
				+ "values(" + boId + ",'borrow_video_audit','7225627','2016-07-28 20:14:07：video_sub_mark 用户提交视频签约。',3,3,'1059','2016-07-29 13:49:38','2016-07-29 13:50:11')";
	    DBUtils.insertValues("nono", "loan", sql3);
	}
}
