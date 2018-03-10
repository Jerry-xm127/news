package com.news.test;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.news.bean.Column;
import com.news.dao.IColumnDao;
import com.news.dao.impl.ColumnDaoImpl;
import com.news.util.C3p0Util;

class TestColumn {

	@Test
	void testQueryAll() {
		try {
			Connection conn = C3p0Util.getConn();
			List<Column> list = new ArrayList<>();
			IColumnDao dao = new ColumnDaoImpl();
			list = dao.queryAll(conn);
			list.forEach(item -> System.out.println(item));
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
