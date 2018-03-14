package com.news.controller;

import java.io.IOException;
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
import com.news.util.PageUtil;

/**
 * 新闻列表Servlet
 */
@WebServlet("/newsListServlet")
public class NewsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NewsListServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String newsAuthor = request.getParameter("newsAuthor");
		String column = request.getParameter("column");
		String pageNostr = (request.getParameter("pageNo") != null && !"".equals(request.getParameter("pageNo")) ? request.getParameter("pageNo") : null);
		int pageNo = pageNostr != null && !"".equals(pageNostr)? Integer.parseInt(pageNostr) : 0;
		News news = new News();
		System.out.println(newsAuthor+"****"+column+"****"+pageNo);
		INewsService newsService = new NewsServiceImpl();
		IColumnService columnService = new ColumnServiceImpl();
		IKeywordsService keywordsService = new KeyServiceImpl();
		PageUtil<News> page = new PageUtil<>();
		try {
			int num = newsService.queryCount(news);	
			page.setPageNo(pageNo);				//设置当前页
			page.setTotalRecords(num);			//设置过滤条件记录总数
			page.setSearchObj(news);        //设置条件查询的对象
			page = newsService.queryPage(page);
			List<Column> columnList = columnService.queryAll();
			List<Keywords> keyList = keywordsService.queryAll();
			request.setAttribute("page", page);
			request.setAttribute("columnList", columnList);
			request.setAttribute("keyList", keyList);
//			request.setAttribute("deptName", deptName);
//			request.setAttribute("empName", empName);
//			request.setAttribute("empNo", empNo);
//			request.setAttribute("empAddr", empAddr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("./WEB-INF/jsp/listnews.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
