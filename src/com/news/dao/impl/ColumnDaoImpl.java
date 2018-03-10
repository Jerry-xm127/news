package com.news.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.news.bean.Column;
import com.news.dao.IColumnDao;

public class ColumnDaoImpl implements IColumnDao {

	@Override
	public List<Column> queryAll(Connection conn) throws Exception {
		if(conn == null) {
			throw new Exception("数据库连接加载失败");
		}
		List<Column> listColumn = new ArrayList<>();
		ResultSet rs = null;
		String sql = "SELECT c.column_id,c.column_name FROM `column` c;";
		PreparedStatement pst = conn.prepareStatement(sql);
		rs = pst.executeQuery();
		while(rs.next()) {
			Column column = new Column();
			column.setColumnId(rs.getInt(1));
			column.setColumnName(rs.getString(2));
			listColumn.add(column);
		}
		pst.close();
		rs.close();
		return listColumn;
	}

}
