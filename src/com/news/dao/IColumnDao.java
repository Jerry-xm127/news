package com.news.dao;

import java.sql.Connection;
import java.util.List;

import com.news.bean.Column;

public interface IColumnDao {
	//查询栏目列表
	public List<Column> queryAll(Connection conn) throws Exception;
}
