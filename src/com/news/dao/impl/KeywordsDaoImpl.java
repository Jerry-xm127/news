package com.news.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.news.bean.Keywords;
import com.news.dao.IKeywordsDao;

public class KeywordsDaoImpl implements IKeywordsDao {

	@Override
	public List<Keywords> queryAll(Connection conn) throws Exception {
		if(conn == null) {
			throw new Exception("数据库连接加载失败");
		}
		List<Keywords> listKeywords = new ArrayList<>();
		ResultSet rs = null;
		String sql = "SELECT k.key_id,k.key_name FROM keywords k;";
		PreparedStatement pst = conn.prepareStatement(sql);
		rs = pst.executeQuery();
		while(rs.next()) {
			Keywords keywords = new Keywords();
			keywords.setKeyId(rs.getInt(1));;
			keywords.setKeyName(rs.getString(2));
			listKeywords.add(keywords);
		}
		pst.close();
		rs.close();
		return listKeywords;
	}

}
