package com.news.dao.impl;

import java.sql.Connection;
import java.util.List;

import com.news.bean.News;
import com.news.dao.INewsDao;
import com.news.util.PageUtil;

public class NewsDaoImpl implements INewsDao{

	@Override
	public void add(News news, Connection conn) throws Exception {
		// TODO Auto-generated method stub
		
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
