package com.news.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 项目名称：shopdemo-1212 
 * 类名称：C3p0Util 
 * 类描述：c3p0连接数据库工具类 
 * 创建人：zqw
 * 创建时间：2017年12月26日下午5:22:25
 * 
 */
public class C3p0Util {
	//读取配置文件方式使用
	private static ComboPooledDataSource dateSource = new ComboPooledDataSource();
	
	protected static Connection conn = null;
	public static Connection getConn() throws Exception{
										 	// 数据库连接类
		conn = dateSource.getConnection();
		//事务操作: 荣辱与共 同生共死
		//操作数据库: 一次连接中     两条语句, insert语句		update语句
		//订单表     订单详情表
		//insert 订单表  返回订单号 
		//insert 详情表  
		//conn.setAutoCommit(false);			//手动提交事务操作
		return conn;
	}
	
	public static void closeConn(Connection conn, PreparedStatement ps, ResultSet rs) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void closeConn(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
