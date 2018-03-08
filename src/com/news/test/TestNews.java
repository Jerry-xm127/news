package com.news.test;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.news.bean.Column;
import com.news.bean.Keywords;
import com.news.bean.News;
import com.news.dao.INewsDao;
import com.news.dao.impl.NewsDaoImpl;
import com.news.util.C3p0Util;
import com.news.util.PageUtil;

class TestNews {

	//@Test
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
	
	//@Test
	void testDel() {
		try {
			Connection conn = C3p0Util.getConn();
			INewsDao dao = new NewsDaoImpl();
			Integer id = 3;
			dao.del(id, conn);
			C3p0Util.closeConn(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	//增量修改有点小问题
	//@Test
	void testUpdate() {
		try {
			Connection conn = C3p0Util.getConn();
			News news = new News();
			Column column = new Column();
			Keywords keywords = new Keywords();
			news.setNewsTitle("ss");
			news.setNewsIntro("ss");
			news.setNewsContent("ss");
			news.setNewsAuthor("ss");
			news.setNewsDate(new Date());
			column.setColumnId(2);
			news.setColumn(column);
			news.setBrowseCount(55);
			news.setNewsId(5);
			INewsDao dao = new NewsDaoImpl();
			dao.update(news, conn);
			C3p0Util.closeConn(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	void testPage() {
		try {
			Connection conn = C3p0Util.getConn();
			PageUtil<News> page = new PageUtil<>(0, 3);
			News news = new News();
//			Column column = new Column();
//			Keywords keywords = new Keywords();
			//news.setNewsTitle("ss");
//			news.setNewsIntro("ss");
//			news.setNewsContent("ss");
//			news.setNewsAuthor("ss");
//			news.setNewsDate(new Date());
//			column.setColumnId(2);
//			news.setColumn(column);
//			news.setBrowseCount(55);
//			news.setNewsId(5);
			//page.setSearchObj(news);
			INewsDao dao = new NewsDaoImpl();
			PageUtil<News> pageList = dao.queryPage(page, conn);
			List<News> list = pageList.getList();
			for(News queryNews : list) {
				System.out.println(queryNews.toString());
			}
			C3p0Util.closeConn(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
