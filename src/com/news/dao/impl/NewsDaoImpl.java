package com.news.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.news.bean.News;
import com.news.dao.INewsDao;
import com.news.util.DateUtil;
import com.news.util.PageUtil;

public class NewsDaoImpl implements INewsDao{

	@Override
	public void add(News news, Connection conn) throws Exception {
		if(news == null) {
			throw new Exception("添加的新闻信息为空");
		}
		if(conn == null) {
			throw new Exception("数据库连接加载失败");
		}
		String sql = "INSERT INTO news(news_title,news_intro,news_content,news_author,columns_id,news_date,browse_count,key_id) "
				+ "VALUES(?,?,?,?,?,?,?,?);";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, news.getNewsTitle());
		pst.setString(2, news.getNewsIntro());
		pst.setString(3, news.getNewsContent());
		pst.setString(4, news.getNewsAuthor());
		pst.setInt(5, news.getColumn().getColumnId());
		pst.setDate(6, DateUtil.utilChangeSql(news.getNewsDate()));
		pst.setInt(7, news.getBrowseCount());
		pst.setInt(8, news.getKeywords().getKeyId());
		pst.executeUpdate();
		pst.close();
		
	}

	@Override
	public void del(Integer id, Connection conn) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(News news, Connection conn) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<News> queryAll(Connection conn) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public News queryById(Integer id, Connection conn) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageUtil<News> queryPage(PageUtil<News> page, Connection conn) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
