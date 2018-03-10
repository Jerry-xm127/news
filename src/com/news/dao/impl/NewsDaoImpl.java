package com.news.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.news.bean.Column;
import com.news.bean.Keywords;
import com.news.bean.News;
import com.news.dao.INewsDao;
import com.news.util.PageUtil;

public class NewsDaoImpl implements INewsDao{

	@Override
	public void add(News news, Connection conn) throws Exception {
		if(news == null) {
			throw new Exception("添加的新闻信息为空");
		}
		if(conn == null) {
			throw new Exception("数据库连接加载失败");
		}
		String sql = "INSERT INTO news(news_title,news_intro,news_content,news_author,columns_id,news_date,key_id) "
				+ "VALUES(?,?,?,?,?,?,?);";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, news.getNewsTitle());
		pst.setString(2, news.getNewsIntro());
		pst.setString(3, news.getNewsContent());
		pst.setString(4, news.getNewsAuthor());
		pst.setInt(5, news.getColumn().getColumnId());
		pst.setTimestamp(6, news.getNewsDate());
		pst.setInt(7, news.getKeywords().getKeyId());
		pst.executeUpdate();
		pst.close();
		
	}

	@Override
	public void del(Integer id, Connection conn) throws Exception {
		if(conn == null) {
			throw new Exception("数据库连接加载失败");
		}
		if(id == null) {
			throw new Exception("id为空");
		}
		String sql = "DELETE FROM news  WHERE news_id=?;";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, id);
		pst.executeUpdate();
		pst.close();
	}

	@Override
	public void update(News news, Connection conn) throws Exception {
		if(conn == null) {
			throw new Exception("数据库连接加载失败");
		}
		PreparedStatement pst = null;
		StringBuilder sb = new StringBuilder("UPDATE news n SET ");
		int index = 0;
		int indexNewsTitle = 0;
		int indexNewsIntro = 0;
		int indexNewsContent = 0;
		int indexNewsAuthor = 0;
		int indexNewsColumn = 0;
		int indexNewsDate = 0;
		int indexBrowseCount = 0;
		int indexKeywords = 0;
		if(news != null) {
			if(news.getNewsTitle() != null) {
				sb.append("n.news_title=?");
				indexNewsTitle = ++index;
			}
			if(news.getNewsIntro() != null) {
				sb.append(",n.news_intro=?");
				indexNewsIntro = ++index;
			}
			if(news.getNewsContent() != null) {
				sb.append(",n.news_content=?");
				indexNewsContent = ++index;
			}
			if(news.getNewsIntro() != null) {
				sb.append(",n.news_author=?");
				indexNewsAuthor = ++index;
			}
			if(news.getColumn() != null) {
				if(news.getColumn().getColumnId() != null) {
					sb.append(",n.columns_id=?");
					indexNewsColumn = ++index;
				}
			}
			if(news.getNewsDate() != null) {
				sb.append(",n.news_date=?");
				indexNewsDate = ++index;
			}
			if(news.getBrowseCount() != null) {
				sb.append(",n.browse_count=?");
				indexBrowseCount = ++index;
			}
			if(news.getKeywords() != null) {
				if(news.getKeywords().getKeyId() != null) {
					sb.append(",n.key_id=? ");
					indexKeywords = ++index;
				}
			}
			sb.append(" WHERE n.news_id=?");
		}
		
		pst = conn.prepareStatement(sb.toString());
		
		if(news != null) {
			if(news.getNewsTitle() != null) {
				pst.setString(indexNewsTitle, news.getNewsTitle());
			}
			if(news.getNewsIntro() != null) {
				pst.setString(indexNewsIntro, news.getNewsIntro());
			}
			if(news.getNewsContent() != null) {
				pst.setString(indexNewsContent, news.getNewsContent());
			}
			if(news.getNewsIntro() != null) {
				pst.setString(indexNewsAuthor, news.getNewsAuthor());
			}
			if(news.getColumn() != null) {
				if(news.getColumn().getColumnId() != null) {
					pst.setInt(indexNewsColumn, news.getColumn().getColumnId());
				}
			}
			if(news.getNewsDate() != null) {
				pst.setTimestamp(indexNewsDate, news.getNewsDate());;
			}
			if(news.getBrowseCount() != null) {
				pst.setInt(indexBrowseCount, news.getBrowseCount());
			}
			if(news.getKeywords() != null) {
				if(news.getKeywords().getKeyId() != null) {
					pst.setInt(indexKeywords, news.getKeywords().getKeyId());
				}
			}
				pst.setInt(index + 1, news.getNewsId());
		}
		
		pst.executeUpdate();
		pst.close();
	}

	@Override
	public List<News> queryAll(Connection conn) throws Exception {
		if(conn == null) {
			throw new Exception("数据库连接加载失败");
		}
		List<News> listNews = new ArrayList<>();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "SELECT n.news_id,n.news_title,n.news_intro,n.news_content,n.news_author,n.columns_id,n.news_date,n.browse_count,n.key_id FROM news n;";
		pst = conn.prepareStatement(sql);
		rs = pst.executeQuery();
		while(rs.next()) {
			News news = new News();
			Column column = new Column();
			Keywords keywords = new Keywords();
			news.setNewsId(rs.getInt(1));
			news.setNewsTitle(rs.getString(2));
			news.setNewsIntro(rs.getString(3));
			news.setNewsContent(rs.getString(4));
			news.setNewsAuthor(rs.getString(5));
			column.setColumnId(rs.getInt(6));
			news.setColumn(column);
			news.setNewsDate(rs.getTimestamp(7));
			news.setBrowseCount(rs.getInt(8));
			keywords.setKeyId(rs.getInt(9));
			news.setKeywords(keywords);
			listNews.add(news);
		}
		pst.close();
		rs.close();
		return listNews;
	}

	@Override
	public News queryById(Integer id, Connection conn) throws Exception {
		if(id == null) {
			throw new Exception("id为空");
		}
		if(conn == null) {
			throw new Exception("数据库连接加载失败");
		}
		PreparedStatement pst = null;
		ResultSet rs = null;
		News news = null;
		Column column = null;
		Keywords keywords = null;
		String sql = "SELECT n.news_title,n.news_intro,n.news_content,n.news_author,n.columns_id,n.news_date,n.browse_count,n.key_id FROM news n WHERE n.news_id=5;";
		pst = conn.prepareStatement(sql);
		pst.setInt(1, id);
		rs = pst.executeQuery();
		if(rs.next()) {
			news = new News();
			column = new Column();
			keywords = new Keywords();
			news.setNewsTitle(rs.getString(1));
			news.setNewsIntro(rs.getString(2));
			news.setNewsContent(rs.getString(3));
			news.setNewsAuthor(rs.getString(4));
			column.setColumnId(rs.getInt(5));
			news.setColumn(column);
			news.setNewsDate(rs.getTimestamp(6));;
			news.setBrowseCount(rs.getInt(7));
			keywords.setKeyId(rs.getInt(8));
			news.setKeywords(keywords);
		}
		pst.close();
		rs.close();
		return news;
	}

	@Override
	public PageUtil<News> queryPage(PageUtil<News> page, Connection conn) throws Exception {
		if(conn == null) {
			throw new Exception("数据库连接加载失败");
		}
		//结果集
		List<News> list = new ArrayList<>();
		PreparedStatement pst = null;
		//动态查询sql语句与分页
		StringBuilder sb = new StringBuilder("SELECT n.news_id,n.news_title,n.news_intro,n.news_content,n.news_author,c.column_name,n.news_date,n.browse_count,k.key_name "
				+ "FROM news n, `column` c, keywords k "
				+ "WHERE n.columns_id=c.column_id AND n.key_id=k.key_id ");
		int index = 0;
		int indexNewsTitle = 0;
		int indexNewsColumn = 0;
		int indexKeywords = 0;
		if(page == null) {
			page = new PageUtil<>(0, 5);		//初始化分页
		}else {
			if(page.getSearchObj() == null) {
				throw new Exception("搜索条件为空");
			}else {
				if(page.getSearchObj().getNewsTitle() != null) {
					sb.append("AND n.news_title LIKE ? ");
					indexNewsTitle = ++index;
				}
				if(page.getSearchObj().getColumn() != null) {
					if(page.getSearchObj().getColumn().getColumnId() != null) {
						sb.append("AND c.column_id=? ");
						indexNewsColumn = ++index;
					}
				}
				if(page.getSearchObj().getKeywords() != null) {
					if(page.getSearchObj().getKeywords().getKeyName() != null) {
						sb.append("AND k.key_name=? ");
						indexKeywords = ++index;
					}
				}
				sb.append("limit ?,?");
			}
		}
		
		pst = conn.prepareStatement(sb.toString());
		if(page != null) {
			if(page.getSearchObj() != null) {
				//新闻标题查询
				if(page.getSearchObj().getNewsTitle() != null) {
					pst.setString(indexNewsTitle, page.getSearchObj().getNewsTitle());
				}
				//选择查询新闻的栏目
				if(page.getSearchObj().getColumn() != null) {
					if(page.getSearchObj().getColumn().getColumnId() != null) {
						pst.setInt(indexNewsColumn, page.getSearchObj().getColumn().getColumnId());
					}
				}
				//关键字的名称查询
				if(page.getSearchObj().getKeywords() != null) {
					if(page.getSearchObj().getKeywords().getKeyName() != null) {
						pst.setString(indexKeywords, page.getSearchObj().getKeywords().getKeyName());
					}
				}
			}
		}
		
		pst.setInt(index + 1, page.getPageNo() * page.getPageSize());
		pst.setInt(index + 2, page.getPageSize());
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			News news = new News();
			Column column = new Column();
			Keywords keywords = new Keywords();
			news.setNewsId(rs.getInt(1));
			news.setNewsTitle(rs.getString(2));
			news.setNewsIntro(rs.getString(3));
			news.setNewsContent(rs.getString(4));
			news.setNewsAuthor(rs.getString(5));
			column.setColumnName(rs.getString(6));
			news.setColumn(column);
			news.setNewsDate(rs.getTimestamp(7));
			news.setBrowseCount(rs.getInt(8));
			keywords.setKeyName(rs.getString(9));;
			news.setKeywords(keywords);
			list.add(news);
		}
		page.setList(list);
		pst.close();
		rs.close();
		return page;
	}


}
