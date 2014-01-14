package com.eoe.learnjava.day04;

import java.util.Scanner;

public class Operator {

	/**
	 * 用三目运算判断奇偶数
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		String result = num % 2==0?"偶数":"奇数";
		System.out.println(result);		
	}

}
