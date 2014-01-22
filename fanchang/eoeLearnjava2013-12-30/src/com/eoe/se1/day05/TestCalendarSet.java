package com.eoe.se1.day05;

import java.util.Calendar;


public class TestCalendarSet {

	/**Calendar.set()设置日期
	 * @param args
	 */
	public static void main(String[] args) {
		Calendar calendar=Calendar.getInstance();
		//设置指定日期
		calendar.set(2013,2,15,10,30,20);
		System.out.print(calendar.get(Calendar.YEAR)+"年");
		System.out.print(calendar.get(Calendar.MONTH)+1+"月");  //需要加1
		System.out.print(calendar.get(Calendar.DATE)+"日");
		System.out.print(calendar.get(Calendar.HOUR)+"时");
		System.out.print(calendar.get(Calendar.MINUTE)+"分");
		System.out.println(calendar.get(Calendar.SECOND)+"秒");
	}

}
