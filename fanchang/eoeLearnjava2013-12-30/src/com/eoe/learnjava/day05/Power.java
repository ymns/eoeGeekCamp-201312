package com.eoe.learnjava.day05;

import java.util.Scanner;

public class Power {

	/**
	 * 用循环语句计算2的n次方,n由键盘输入
	 * @param args
	 */
	
	//2的n次方
	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("请输入n:");
//		int n = scanner.nextInt();
//		int result=1;
//		for(int i=1;i<=n;i++){
//			result*=2;
//		}
//		System.out.println("2的n次方是:"+result);
//	}
	
	//m的n次方
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入m:");
		int m = scanner.nextInt();
		System.out.println("请输入n:");
		int n = scanner.nextInt();
		int result = 1;
		for(int i=1;i<=n;i++){
			result*=m;
		}
		System.out.println("m的n次方是:"+result);
	}
}
