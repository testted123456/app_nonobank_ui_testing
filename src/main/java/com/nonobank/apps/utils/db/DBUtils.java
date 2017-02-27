package com.nonobank.apps.utils.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.nonobank.apps.utils.file.ParseProperties;

public class DBUtils {
	
	public static Logger logger = LogManager.getLogger(DBUtils.class);
	
	public static Connection connection_nono_nono;
	public static Connection connection_pay_nono;
	
	
	/**
	 * @param dbname
	 * @return
	 */
	public static Connection getConnection(String dbname, String username) {
		String driver = ParseProperties.getInstance().getProperty("mySql_driver");
		String url = ParseProperties.getInstance().getProperty("mySql_url_" + dbname);
		String name = ParseProperties.getInstance().getProperty("db_name_" + username);
		String password = ParseProperties.getInstance().getProperty("db_password_" + username);

		Connection con = null;

		try {
			try {
				Class.forName(driver);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			con = DriverManager.getConnection(url, name, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(dbname.equals("nono")){
				connection_nono_nono = con;	
		}else if(dbname.equals("pay")){
			    connection_pay_nono = con;
		}
		return con;
	}
	public static void closeConnection(String dbname) {
		Connection conn=null;
		if(dbname.equals("nono")){
				conn=connection_nono_nono;
		}else if(dbname.equals("pay")){
				conn=connection_pay_nono;
		}
		try {
			DbUtils.close(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		conn = null;
	}

	//返回一个字段值
	public static Object getOneObject(Connection con, String sql) {
		Object[] objs = getOneLine(con, sql);
		if (objs.length == 0) {
			return null;
		}
		if (objs.length == 1) {
			return objs[0];
		} else {
			logger.info("get more than one objects.");
			return null;
		}
	}

	// 插入一行sql
	public static Object[] insertOneObject(Connection con, String sql) {
		QueryRunner qr = new QueryRunner();
		Object[] objArr = null;
		System.out.println("开始执行insert语句");
		System.out.println("sql为："+sql);
		try {
			objArr = qr.insert(con, sql, new ArrayHandler());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("执行insert语句成功");
		return objArr;
	}
	// 更新一行sql
	public static int updateOneObject(Connection con, String sql){
		QueryRunner qr = new QueryRunner();
		int objArr = 0;
		System.out.println("开始执行update语句");
		System.out.println("sql为："+sql);
		try {
			objArr = qr.update(con, sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("执行update语句成功");
		return objArr;
	}

	// 删除一行sql
	public static int deleteOneObject(Connection con, String sql) {
		QueryRunner qr = new QueryRunner();
		int objArr = 0;
		try {
			objArr = qr.update(con, sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return objArr;
	}

	//返回一行记录
	public static Object[] getOneLine(Connection con, String sql) {
		QueryRunner qr = new QueryRunner();
		Object[] objArr = null;
		try {
			objArr = qr.query(con, sql, new ArrayHandler());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return objArr;
	}

	
	
	public static String getValues(String dbname,String username,String sql){
		Connection con = getConnection(dbname,username);
		Object obj = getOneLine(con, sql);
		String str = null;
		if(obj instanceof Object[]){
			Object[] objs = (Object[])obj;
			for(int i=0;i<objs.length;i++){
				if(i==0){
					str = objs[i].toString();
				}else{
					str = str + ","  + objs[i];
				}
			}
		}
		return str.trim();
	}
	
	public static String insertValues(String dbname,String username,String sql){
		Connection con = getConnection(dbname, username);
		Object obj = insertOneObject(con, sql);
		String str = null;
		if(obj instanceof Object[]){
			Object[] objs = (Object[])obj;
			
			for(int i=0;i<objs.length;i++){
				if(i==0){
					str = objs[i].toString();
				}else{
					str = str + ","  + objs[i];
				}
			}
		}
		return str.trim();
	}
	
	public static String updateValues(String dbname, String username, String sql){
		Connection con = getConnection(dbname, username);
		int obj = updateOneObject(con, sql);
		String str=Integer.toString(obj);
		return str;
	}
	
	public static String deleteValues(String dbname, String username, String sql){
		Connection con = getConnection(dbname, username);
		int obj = deleteOneObject(con, sql);
		String str=Integer.toString(obj);
		return str;
	}
}
