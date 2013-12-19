package com.study.se2_http;

import java.util.Scanner;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] day={31,28,31,30,31,30,31,31,30,31,30,31};
		System.out.println("请输入月份");
		int month=new Scanner(System.in).nextInt();
		System.out.println(day[month-1]);
	}

}
