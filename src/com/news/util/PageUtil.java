package com.news.util;

import java.util.List;

/**
 * 
 * @author Jerry
 *	分页工具类
 *
 */
public class PageUtil<E> {
	private List<E> list;		//结果集
	private E searchObj;		//搜索条件
	private int totalRecords;	//符合条件的查询记录数
	private int pageNo =  0;			//当前页的页码\第几页
	private int pageSize = 5;		//每页多少条记录
	private int totalPages;			//总页数
		
	public PageUtil() {
		super();
	}
	
	/**
	 * 初始化当前第几页和每页显示的记录数
	 * @param pageNo	第几页
	 * @param pageSize	每页显示几条数据
	 * 
	 */
	public PageUtil(int pageNo, int pageSize) {
		super();
		this.pageNo = pageNo;
		this.pageSize = pageSize;
	}
	
	//总页数
	public int getTotalPages() {
		return (totalRecords + pageSize - 1) / pageSize;
	}
	
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	
	//首页
	public int getTopPage() {
		return 0;
	}
	
	//尾页
	public int getBottomPage() {
		int bottomPage = 0;
		if(getTotalPages() > 0) {
			bottomPage = getTotalPages() - 1;
		}
		return bottomPage;
	}
	
	//上一页
	public int getPreviousPage() {
		if(pageNo <= 0) {
			return 0;
		}
		return pageNo - 1;
	}
	
	//下一页
	public int getNextPage() {
		if(pageNo >= getBottomPage()) {
			return getBottomPage();
		}
		return pageNo + 1;
	}

	public List<E> getList() {
		return list;
	}

	public void setList(List<E> list) {
		this.list = list;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public E getSearchObj() {
		return searchObj;
	}

	public void setSearchObj(E searchObj) {
		this.searchObj = searchObj;
	}

	@Override
	public String toString() {
		return "PageUtil [list=" + list + ", searchObj=" + searchObj + ", totalRecords=" + totalRecords + ", pageNo="
				+ pageNo + ", pageSize=" + pageSize + ", totalPages=" + totalPages + "]";
	}

	
	
}
