package com.news.service.impl;

import java.sql.Connection;
import java.util.List;

import com.news.bean.Keywords;
import com.news.dao.IKeywordsDao;
import com.news.dao.impl.KeywordsDaoImpl;
import com.news.service.IKeywordsService;
import com.news.util.C3p0Util;

public class KeyServiceImpl implements IKeywordsService {
	
	private IKeywordsDao keywordsDao = new KeywordsDaoImpl();

	@Override
	public List<Keywords> queryAll() throws Exception {
		Connection conn = C3p0Util.getConn();
		List<Keywords> list = keywordsDao.queryAll(conn);
		C3p0Util.closeConn(conn);
		return list;
	}

}
