package com.news.service.impl;

import java.sql.Connection;
import java.sql.SQLException;

import com.news.bean.News;
import com.news.dao.INewsDao;
import com.news.dao.impl.NewsDaoImpl;
import com.news.service.INewsService;
import com.news.util.C3p0Util;
import com.news.util.PageUtil;

public class NewsServiceImpl implements INewsService {
	
	private INewsDao newsDao = new NewsDaoImpl();

	@Override
	public void release(News news) throws Exception {
		Connection conn = C3p0Util.getConn();
		conn.setAutoCommit(false); 					//开启事务
		try {
			newsDao.add(news, conn);
			conn.commit();							//提交
		} catch (SQLException e) {
			conn.rollback();
			e.printStackTrace();
		}finally {
			C3p0Util.closeConn(conn);
		}
		
	}

	@Override
	public PageUtil<News> queryPage(PageUtil<News> page) throws Exception {
		Connection conn = C3p0Util.getConn();
		conn.setAutoCommit(false); 					//开启事务
		try {
			newsDao.queryPage(page, conn);
			conn.commit();							//提交
		} catch (SQLException e) {
			conn.rollback();
			e.printStackTrace();
		}finally {
			C3p0Util.closeConn(conn);
		}
		return page;
	}

	@Override
	public int queryCount(News news) throws Exception {
		int num = 0;
		Connection conn = C3p0Util.getConn();
		conn.setAutoCommit(false); 					//开启事务
		try {
			num =newsDao.queryCount(news, conn);
			conn.commit();							//提交
		} catch (SQLException e) {
			conn.rollback();
			e.printStackTrace();
		}finally {
			C3p0Util.closeConn(conn);
		}
		return num;
	}

}
