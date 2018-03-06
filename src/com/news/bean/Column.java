package com.news.bean;

import java.io.Serializable;

public class Column implements Serializable {

	private static final long serialVersionUID = -3010067073074873383L;
	
	private Integer columnId;					//栏目编号
	private String columnName;					//栏目名称
	
	public Column() {
		super();
	}

	public Column(Integer columnId, String columnName) {
		super();
		this.columnId = columnId;
		this.columnName = columnName;
	}

	public Integer getColumnId() {
		return columnId;
	}

	public void setColumnId(Integer columnId) {
		this.columnId = columnId;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	@Override
	public String toString() {
		return "Column [columnId=" + columnId + ", columnName=" + columnName + "]";
	}

}
