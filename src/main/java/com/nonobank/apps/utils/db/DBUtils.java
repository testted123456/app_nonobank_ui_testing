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
	public static Connection connection_nono_user;
	public static Connection connection_pay_user;
	public static Connection connection_nono_loan;
	public static Connection connection_pay_loan;
	public static Connection connection_nono_licai;
	public static Connection connection_pay_licai;
	public static Connection connection_nono_account;
	public static Connection connection_pay_account;
	public static Connection connection_nono_payment;
	public static Connection connection_pay_payment;
	public static Connection connection_nono_product;
	public static Connection connection_pay_product;
	public static Connection connection_nono_trade;
	public static Connection connection_pay_trade;
	public static Connection connection_nono_infra;
	public static Connection connection_pay_infra;
	
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			con = DriverManager.getConnection(url, name, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(dbname.equals("nono")){
			if(username.trim().equals("nono")){
				connection_nono_nono = con;
			}
			if(username.trim().equals("user")){
				connection_nono_user = con;
			}
			if(username.trim().equals("loan")){
				connection_nono_loan = con;
			}
			if(username.trim().equals("licai")){
				connection_nono_licai = con;
			}
			if(username.trim().equals("account")){
				connection_nono_account = con;
			}
			if(username.trim().equals("payment")){
				connection_nono_payment = con;
			}
			if(username.trim().equals("product")){
				connection_nono_product = con;
			}
			if(username.trim().equals("trade")){
				connection_nono_trade = con;
			}
			if(username.trim().equals("infra")){
				connection_nono_infra = con;
			}
		}else if(dbname.equals("pay")){
			if(username.trim().equals("user")){
				connection_pay_user = con;
			}
			if(username.trim().equals("loan")){
				connection_pay_loan = con;
			}
			if(username.trim().equals("licai")){
				connection_pay_licai = con;
			}
			if(username.trim().equals("account")){
				connection_pay_account = con;
			}
			if(username.trim().equals("payment")){
				connection_pay_payment = con;
			}
			if(username.trim().equals("product")){
				connection_pay_product = con;
			}
			if(username.trim().equals("trade")){
				connection_pay_trade = con;
			}
			if(username.trim().equals("infra")){
				connection_pay_infra = con;
			}
		}
		return con;
	}

	/**
	 * 返回一个字段值
	 * 
	 * @param con
	 * @param sql
	 * @return
	 */
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
		try {
			objArr = qr.insert(con, sql, new ArrayHandler());
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
//	public static void main(String[] args) throws Exception {
//		String url="jdbc:mysql://192.168.4.13:3306/db_nono";
//		String user="nonobank";
//		String password="B67891234bc34dsdfd12h";
//		String jdbcDriver = "com.mysql.jdbc.Driver";
//		DbUtils.loadDriver(jdbcDriver); 
//		String sql="update borrows set bo_is_finish='1',bo_is_success='1',bo_can_success='3' where id=1394242";
//		Connection con = DriverManager.getConnection(url, user, password);
//		QueryRunner qr = new QueryRunner();
//		int objArr = 0;
//		objArr = qr.update(con, sql);
//	
//	}
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

	/**
	 * 返回一行记录
	 * 
	 * @param con
	 * @param sql
	 * @return
	 */
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

	public static void closeConnection(String dbname, String username) {
		Connection conn=null;
		if(dbname.equals("nono")){
			if(username.trim().equals("nono")){
				conn=connection_nono_nono;
			}
			if(username.trim().equals("user")){
				conn=connection_nono_user;
			}
			if(username.trim().equals("loan")){
				conn=connection_nono_loan;
			}
			if(username.trim().equals("licai")){
				conn=connection_nono_licai;
			}
			if(username.trim().equals("account")){
				conn=connection_nono_account;
			}
			if(username.trim().equals("payment")){
				conn=connection_nono_payment;
			}
			if(username.trim().equals("product")){
				conn=connection_nono_product;
			}
			if(username.trim().equals("trade")){
				conn=connection_nono_trade;
			}
			if(username.trim().equals("infra")){
				conn=connection_nono_infra;
			}
		}else if(dbname.equals("pay")){
			if(username.trim().equals("user")){
				conn=connection_pay_user;
			}
			if(username.trim().equals("loan")){
				conn=connection_pay_loan;
			}
			if(username.trim().equals("licai")){
				conn=connection_pay_licai;
			}
			if(username.trim().equals("account")){
				conn=connection_pay_account;
			}
			if(username.trim().equals("payment")){
				conn=connection_pay_payment;
			}
			if(username.trim().equals("product")){
				conn=connection_pay_product;
			}
			if(username.trim().equals("trade")){
				conn=connection_pay_trade;
			}
			if(username.trim().equals("infra")){
				conn=connection_pay_infra;
			}
		}
		try {
			DbUtils.close(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		conn = null;
	}
	
	public static String getValues(String dbname, String username, String sql){
		Connection con = getConnection(dbname, username);
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
	
	public static String insertValues(String dbname, String username, String sql){
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
