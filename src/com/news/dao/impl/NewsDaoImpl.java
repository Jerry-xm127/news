package com.news.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.news.bean.News;
import com.news.dao.INewsDao;
import com.news.util.DateUtil;
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
		String sql = "INSERT INTO news(news_title,news_intro,news_content,news_author,columns_id,news_date,browse_count,key_id) "
				+ "VALUES(?,?,?,?,?,?,?,?);";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1, news.getNewsTitle());
		pst.setString(2, news.getNewsIntro());
		pst.setString(3, news.getNewsContent());
		pst.setString(4, news.getNewsAuthor());
		pst.setInt(5, news.getColumn().getColumnId());
		pst.setDate(6, DateUtil.utilChangeSql(news.getNewsDate()));
		pst.setInt(7, news.getBrowseCount());
		pst.setInt(8, news.getKeywords().getKeyId());
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
				pst.setDate(indexNewsDate, DateUtil.utilChangeSql(news.getNewsDate()));
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public News queryById(Integer id, Connection conn) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageUtil<News> queryPage(PageUtil<News> page, Connection conn) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
