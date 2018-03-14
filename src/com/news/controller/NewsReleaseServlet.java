package com.news.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.news.bean.Column;
import com.news.bean.Keywords;
import com.news.bean.News;
import com.news.service.IColumnService;
import com.news.service.IKeywordsService;
import com.news.service.INewsService;
import com.news.service.impl.ColumnServiceImpl;
import com.news.service.impl.KeyServiceImpl;
import com.news.service.impl.NewsServiceImpl;

/**
 * 发布新闻Servlet
 */
@WebServlet("/newsReleaseServlet")
public class NewsReleaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NewsReleaseServlet() {
        super();
    }

	/**
	 *	初始化添加新闻页面
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IColumnService columnService = new ColumnServiceImpl();
		IKeywordsService keywordsService = new KeyServiceImpl();
		try {
			List<Column> listColumn = columnService.queryAll();
			List<Keywords> listKeywords = keywordsService.queryAll();
			request.setAttribute("listColumn", listColumn);
			request.setAttribute("listKeywords", listKeywords);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("./WEB-INF/jsp/addnews.jsp").forward(request, response);
	}

	/**
	 * 发布新闻成功跳转
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String newsTitle = request.getParameter("newsTitle");
		String newsIntro = request.getParameter("newsIntro");
		String newsContent = request.getParameter("newsContent");
		String newsAuthor = request.getParameter("newsAuthor");
		Integer columnId = Integer.valueOf(request.getParameter("column"));
		Integer keyId = Integer.valueOf(request.getParameter("keywords"));
		Timestamp newsDate = new Timestamp(new Date().getTime());
		Keywords keywords = new Keywords();
		keywords.setKeyId(keyId);
		Column column = new Column();
		column.setColumnId(columnId);
		News news = new News(newsTitle, newsIntro, newsContent, newsAuthor, column, newsDate, keywords);
		INewsService newService = new NewsServiceImpl();
		try {
			newService.release(news);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
