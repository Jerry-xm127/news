package com.news.service;



import com.news.bean.News;
import com.news.util.PageUtil;

public interface INewsService {
	//新闻的添加发布
	public void release(News news) throws Exception;
	//新闻列表分页+搜索
	public PageUtil<News> queryPage(PageUtil<News> page) throws Exception;
	//符合搜索条件的新闻数量
	public int queryCount(News news) throws Exception;
}
