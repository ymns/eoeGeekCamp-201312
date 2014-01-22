package com.eoe.se1.day05;

import java.util.Calendar;

public class LongCalendar {

	/**long类型的日期转换为Calendar类型
	 * @param args
	 */
	public static void main(String[] args) {
		long time = System.currentTimeMillis();//系统时间毫秒
		Calendar calendar=Calendar.getInstance();   //创建一个calendar对象
		calendar.setTimeInMillis(time);   //按time设置日期,long类型的转换成Calendar类型
		System.out.print(calendar.get(Calendar.YEAR)+"年");
		System.out.print(calendar.get(Calendar.MONTH)+1+"月");  //需要加1
		System.out.print(calendar.get(Calendar.DATE)+"日");
		System.out.print(calendar.get(Calendar.HOUR)+"时");
		System.out.print(calendar.get(Calendar.MINUTE)+"分");
		System.out.println(calendar.get(Calendar.SECOND)+"秒");
		

	}

}
