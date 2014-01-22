package com.eoe.se1.day05;

import java.util.Calendar;
import java.util.Date;

public class DateCalendar {

	/**
	 * date类型转换为Calendar类型
	 * @param args
	 */
	public static void main(String[] args) {
		long time =System.currentTimeMillis();
		Date date=new Date(time);
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(date);
		System.out.print(calendar.get(Calendar.YEAR)+"年");
		System.out.print(calendar.get(Calendar.MONTH)+1+"月");  //需要加1
		System.out.print(calendar.get(Calendar.DATE)+"日");
		System.out.print(calendar.get(Calendar.HOUR)+"时");
		System.out.print(calendar.get(Calendar.MINUTE)+"分");
		System.out.println(calendar.get(Calendar.SECOND)+"秒");
	}

}
