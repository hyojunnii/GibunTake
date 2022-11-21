package com.gnt.common;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTemplate {
	//커넥션 가져오기
		public static Connection getConnection() {
			Connection conn = null;
			try {
				//드라이버 준비
				Properties prop = new Properties();
				String filePath = JDBCTemplate.class.getResource("/db/setup/data.properties").getPath(); //JDBCTemplate를 갖고 있는 폴더
				prop.load(new FileInputStream(filePath));
				
				
				String driver = prop.getProperty("driver");
				String url = prop.getProperty("url");
				String Id = prop.getProperty("dbId");
				String Pwd = prop.getProperty("dbPwd");
				
//			String driver = "oracle.jdbc.driver.OracleDriver";
//			String url = "jdbc:oracle:thin:@localhost:1521:xe";
//			String dbId = "C##SEMIGNT";
//			String dbPwd = "SEMIGNT";
				Class.forName(driver);
				
				conn= DriverManager.getConnection(url, Id, Pwd);
				conn.setAutoCommit(false);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return conn;	
		}
		
		

		
		//커밋, 롤백
		public static void commit(Connection conn) {
			try {
				if(conn !=null && !conn.isClosed())conn.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		public static void rollback(Connection conn) {
			try {
				if(conn !=null && !conn.isClosed())conn.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		public static void close(Statement stmt) {
			try {
				if(stmt !=null && !stmt.isClosed())stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		public static void close(ResultSet rs) {
			try {
				if(rs !=null && !rs.isClosed())rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		public static void close(Connection conn) {
			try {
				if(conn !=null && !conn.isClosed())conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
