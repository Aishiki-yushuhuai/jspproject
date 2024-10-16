package com.shelley.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * JDBC操作的工具类
 * @author Mr.Diao
 *
 */
public class JdbcUtils {
	
	private static DataSource dataSource = null;
	
	static {
		//数据源只能被创建一次
		dataSource = new ComboPooledDataSource("helloc3p0");
	}
		
	/**
	 * 获取数据库连接
	 * @return
	 * @throws SQLException 
	 */
	public static Connection getConnection() throws SQLException {
		
		return dataSource.getConnection();
	}
	
	/**
	 * 关闭数据库连接
	 * @param conn
	 */
	public static void releaseConnection(Connection conn) {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
