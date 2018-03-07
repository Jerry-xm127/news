package com.news.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	private static Date date;						//util下的Date
	private static java.sql.Date sqlDate;			//sql下的Date
	private static String datestr;					//string类型的Date

	public static Date getDate() {
		return date;
	}
	public static void setDate(Date date) {
		DateUtil.date = date;
	}
	public static java.sql.Date getSqlDate() {
		return sqlDate;
	}
	public static void setSqlDate(java.sql.Date sqlDate) {
		DateUtil.sqlDate = sqlDate;
	}
	public static String getDatestr() {
		return datestr;
	}
	public static void setDatestr(String datestr) {
		DateUtil.datestr = datestr;
	}
	
	//sql下的Date转化为util下的Date
	public static Date sqlChangeUtil(java.sql.Date sqlDate) {
		Long ldate = sqlDate.getTime();
		return date = new Date(ldate);
		}
	
	//util下的Date转化为sql下的Date
	public static java.sql.Date utilChangeSql(Date date){
		Long ldate = date.getTime();
		return sqlDate = new java.sql.Date(ldate);
	}
	
	//String类型的Date转化为Util下的Date
	public static Date stringChangeUtil(String datestr) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date = dateFormat.parse(datestr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return date;
		
	}
	
}
