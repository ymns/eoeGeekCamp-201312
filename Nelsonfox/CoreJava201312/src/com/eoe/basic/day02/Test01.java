package com.eoe.basic.day02;

public class Test01 {
	/*
	 * 计算(sqrt(20)+sqrt(10)/(sqrt(20)-sqrt(10))=
	 * 要求：显示结果保留小数点后1位，即对小数点后第2位四舍五入。
	 */
	public static void main(String[] args) {
		//将20的平方根保存在变量sqrt20
		double sqrt20=Math.sqrt(20);
		//将10的平方根保存在变量sqrt10
		double sqrt10=Math.sqrt(10);
		//用sqrt20和sqrt10进行计算
		double result=(sqrt20+sqrt10)/(sqrt20-sqrt10);
		System.out.println(result);
		System.out.println(Math.round(result*10)/10d) ;		
	}
}
