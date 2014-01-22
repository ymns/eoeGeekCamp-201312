package com.eoe.se1.day05;

import java.util.Date;



public class TestDate {

	/**
	 * date类时间计算
	 * @param args
	 */
	public static void main(String[] args) {
		long time = System.currentTimeMillis();
		//计算年份
		System.out.println(time);
		long  year =time/1000/3600/24/365;
		System.out.println(year+1970);   //需要加1970
		Date now =new Date();
		System.out.print(now.getYear()+1900+"年");   //需要加1900
		System.out.print(now.getMonth()+1+"月");       //需要+1
		System.out.print(now.getDate()+"日");    //日期
		System.out.print(now.getHours()+"时");
		System.out.print(now.getMinutes()+"分");
		System.out.println(now.getSeconds()+"秒");
		System.out.println(now.getTime()+"获取的时间");
		System.out.println("星期"+now.getDay());//星期几? 
	}

}
