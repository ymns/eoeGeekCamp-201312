package com.eoe.basic.day01.exercise;

public class Exercise04 {
	/**
	 *  编写程序，文件名：J08.java，计算并显示以下表达式的值
   		  (sqrt(20)+sqrt(10)/(sqrt(20)-sqrt(10))=
   		  要求：保留小数点后2位。
	 * 
	 */
	public static void main(String[] args) {
		System.out.print("(sqrt(20)+sqrt(10)/(sqrt(20)-sqrt(10))=");
		System.out.println((Math.round(100*(Math.sqrt(20)+Math.sqrt(10))/(Math.sqrt(20)-Math.sqrt(10))))/100.0);
	}
}
