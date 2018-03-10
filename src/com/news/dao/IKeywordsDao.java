package com.news.dao;

import java.sql.Connection;
import java.util.List;

import com.news.bean.Keywords;

public interface IKeywordsDao {
	//获取关键字列表
	public List<Keywords> queryAll(Connection conn) throws Exception;
}
