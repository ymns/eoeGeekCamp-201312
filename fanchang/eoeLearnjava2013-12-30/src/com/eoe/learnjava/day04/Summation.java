package com.eoe.learnjava.day04;

import java.util.Scanner;

public class Summation {

	/**
	 * 键盘输入n,计算1+2+3+....+n的和
	 * @param args
	 */
	public static void main(String[] args) {
		double result=0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("输入n,计算1+2+3+....+n的和:");
		int n = scanner.nextInt();
		for (int i = 1;i <=n;i++){
			result+=i;
		}
		System.out.println(result);

	}

}
