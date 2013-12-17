package com.eoe.java.school;

public class Test01 {
	/*
	 * 计算(sqrt(20)+sqrt(10)/(sqrt(20)-sqrt(10))=
	 * 要求：显示结果保留小数点后1位，即对小数点后第2位四舍五入。
	 */
	public static void main(String[] args) {
       double sqrt20=Math.sqrt(20);
       double sqrt10=Math.sqrt(10);
       
       double result=(sqrt20+sqrt10)/(sqrt20-sqrt10);
       System.out.println(result);
       System.out.println(Math.round(result*10)/10d);
		
	}

}
