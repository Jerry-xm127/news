package com.news.bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class News implements Serializable{
	
	private static final long serialVersionUID = -2726929297126310844L;
	
	private Integer newsId;					//新闻编号
	private String newsTitle;				//新闻名称
	private String newsIntro;				//新闻简介
	private String newsContent;				//新闻内容
	private String newsAuthor;				//新闻作者
	private Column column;					//栏目信息
	private Timestamp newsDate;				//发布时间
	private Integer browseCount;			//浏览次数
	private Keywords keywords;				//关键字信息
	
	public News() {
		super();
	}

	public News(Integer newsId, String newsTitle, String newsIntro, String newsContent, String newsAuthor,
			Column column, Timestamp newsDate, Integer browseCount, Keywords keywords) {
		super();
		this.newsId = newsId;
		this.newsTitle = newsTitle;
		this.newsIntro = newsIntro;
		this.newsContent = newsContent;
		this.newsAuthor = newsAuthor;
		this.column = column;
		this.newsDate = newsDate;
		this.browseCount = browseCount;
		this.keywords = keywords;
	}

	
	public News(String newsTitle, String newsIntro, String newsContent, String newsAuthor, Column column,
			Timestamp newsDate, Keywords keywords) {
		super();
		this.newsTitle = newsTitle;
		this.newsIntro = newsIntro;
		this.newsContent = newsContent;
		this.newsAuthor = newsAuthor;
		this.column = column;
		this.newsDate = newsDate;
		this.keywords = keywords;
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

	public Timestamp getNewsDate() {
		return newsDate;
	}

	public void setNewsDate(Timestamp newsTimestamp) {
		this.newsDate = newsTimestamp;
	}

	public Integer getBrowseCount() {
		return browseCount;
	}

	public void setBrowseCount(Integer browseCount) {
		this.browseCount = browseCount;
	}

	public Keywords getKeywords() {
		return keywords;
	}

	public void setKeywords(Keywords keywords) {
		this.keywords = keywords;
	}

	@Override
	public String toString() {
		return "News [newsId=" + newsId + ", newsTitle=" + newsTitle + ", newsIntro=" + newsIntro + ", newsContent="
				+ newsContent + ", newsAuthor=" + newsAuthor + ", column=" + column + ", newsTimestamp=" + newsDate
				+ ", browseCount=" + browseCount + ", keywords=" + keywords + "]";
	}
	
	
	
}
