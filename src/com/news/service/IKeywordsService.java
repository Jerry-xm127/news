package com.news.service;

import java.util.List;

import com.news.bean.Keywords;

public interface IKeywordsService {
	public List<Keywords> queryAll() throws Exception;
}
