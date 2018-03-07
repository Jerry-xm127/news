package com.news.test;

import java.sql.Connection;
import java.util.Date;

import org.junit.jupiter.api.Test;

import com.news.bean.Column;
import com.news.bean.Keywords;
import com.news.bean.News;
import com.news.dao.INewsDao;
import com.news.dao.impl.NewsDaoImpl;
import com.news.util.C3p0Util;

class TestNews {

	@Test
	void testAdd() {
		try {
			Connection conn = C3p0Util.getConn();
			News news = new News();
			Column column = new Column();
			Keywords keywords = new Keywords();
			news.setNewsTitle("ww");
			news.setNewsIntro("ww");
			news.setNewsContent("ww");
			news.setNewsAuthor("ww");
			column.setColumnId(1);
			news.setColumn(column);
			news.setNewsDate(new Date());
			news.setBrowseCount(12);
			keywords.setKeyId(1);
			news.setKeywords(keywords);
			INewsDao dao = new NewsDaoImpl();
			dao.add(news, conn);
			C3p0Util.closeConn(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
