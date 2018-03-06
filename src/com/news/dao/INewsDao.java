package com.news.dao;

import java.sql.Connection;
import java.util.List;

import com.news.bean.News;
import com.news.util.PageUtil;

public interface INewsDao {
	//添加新闻
	public void add(News news, Connection conn) throws Exception;
	//删除新闻
	public void del(Integer id, Connection conn) throws Exception;
	//编辑修改新闻
	public void update(News news, Connection conn) throws Exception;
	//查询所有新闻信息
	public List<News> queryAll(Connection conn) throws Exception;
	//根据id查询具体的新闻信息
	public News queryById(Integer id, Connection conn) throws Exception;
	//分页+搜索
	public PageUtil<News> queryPage(PageUtil<News> page, Connection conn) throws Exception;
}
