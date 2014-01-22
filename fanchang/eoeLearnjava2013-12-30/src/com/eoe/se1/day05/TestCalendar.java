package com.eoe.se1.day05;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class TestCalendar {

	/**
	 * Calendar类创建时间
	 * @param args
	 * 
	 */
	public static void main(String[] args) {
		Calendar calendar=new GregorianCalendar();   //创建子类GregorianCalendar对象
		calendar=Calendar.getInstance(); //用Calendar类的getInstance方法创建对象
		System.out.print(calendar.get(Calendar.YEAR)+"年");
		System.out.print(calendar.get(Calendar.MONTH)+1+"月");  //需要加1
		System.out.print(calendar.get(Calendar.DATE)+"日");
		System.out.print(calendar.get(Calendar.HOUR)+"时");
		System.out.print(calendar.get(Calendar.MINUTE)+"分");
		System.out.println(calendar.get(Calendar.SECOND)+"秒");
		

	}

}
