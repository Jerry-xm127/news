package com.news.service;

import java.util.List;

import com.news.bean.Column;

public interface IColumnService {
	//获得栏目列表
	public List<Column> queryAll() throws Exception;
}
