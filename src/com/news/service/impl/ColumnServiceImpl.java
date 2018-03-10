package com.news.service.impl;

import java.sql.Connection;
import java.util.List;

import com.news.bean.Column;
import com.news.dao.IColumnDao;
import com.news.dao.impl.ColumnDaoImpl;
import com.news.service.IColumnService;
import com.news.util.C3p0Util;

public class ColumnServiceImpl implements IColumnService {
	
	private IColumnDao columnDao = new ColumnDaoImpl();

	@Override
	public List<Column> queryAll() throws Exception {
		Connection conn = C3p0Util.getConn();
		List<Column> list = columnDao.queryAll(conn);
		C3p0Util.closeConn(conn);
		return list;
	}

}
