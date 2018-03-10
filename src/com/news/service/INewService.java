package com.news.service;


import com.news.bean.News;

public interface INewService {
	//新闻的添加发布
	public void release(News news) throws Exception;
}
