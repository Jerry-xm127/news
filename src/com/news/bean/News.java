package com.news.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class News implements Serializable{
	
	private static final long serialVersionUID = -2726929297126310844L;
	
	private Integer newsId;					//新闻编号
	private String newsTitle;				//新闻名称
	private String newsIntro;				//新闻简介
	private String newsContent;				//新闻内容
	private String newsAuthor;				//新闻作者
	private Column column;					//栏目信息
	private Date newsDate;					//发布时间
	private Integer browseCount;			//浏览次数
	private List<Keywords> keyList;			//关键字信息
	
	public News() {
		super();
	}

	public News(Integer newsId, String newsTitle, String newsIntro, String newsContent, String newsAuthor,
			Column column, Date newsDate, Integer browseCount, List<Keywords> keyList) {
		super();
		this.newsId = newsId;
		this.newsTitle = newsTitle;
		this.newsIntro = newsIntro;
		this.newsContent = newsContent;
		this.newsAuthor = newsAuthor;
		this.column = column;
		this.newsDate = newsDate;
		this.browseCount = browseCount;
		this.keyList = keyList;
	}

	public Integer getNewsId() {
		return newsId;
	}

	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}

	public String getNewsTitle() {
		return newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	public String getNewsIntro() {
		return newsIntro;
	}

	public void setNewsIntro(String newsIntro) {
		this.newsIntro = newsIntro;
	}

	public String getNewsContent() {
		return newsContent;
	}

	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}

	public String getNewsAuthor() {
		return newsAuthor;
	}

	public void setNewsAuthor(String newsAuthor) {
		this.newsAuthor = newsAuthor;
	}

	public Column getColumn() {
		return column;
	}

	public void setColumn(Column column) {
		this.column = column;
	}

	public Date getNewsDate() {
		return newsDate;
	}

	public void setNewsDate(Date newsDate) {
		this.newsDate = newsDate;
	}

	public Integer getBrowseCount() {
		return browseCount;
	}

	public void setBrowseCount(Integer browseCount) {
		this.browseCount = browseCount;
	}

	public List<Keywords> getKeyList() {
		return keyList;
	}

	public void setKeyList(List<Keywords> keyList) {
		this.keyList = keyList;
	}

	@Override
	public String toString() {
		return "News [newsId=" + newsId + ", newsTitle=" + newsTitle + ", newsIntro=" + newsIntro + ", newsContent="
				+ newsContent + ", newsAuthor=" + newsAuthor + ", column=" + column + ", newsDate=" + newsDate
				+ ", browseCount=" + browseCount + ", keyList=" + keyList + "]";
	}
	
	
	
}
