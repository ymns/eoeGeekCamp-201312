package com.eoe.learnjava.day05;
import java.util.Scanner;


public class Factorial {

	/**
	 * 计算n!,n由键盘输入
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入n=");
		int n = scanner.nextInt();
		long result = 1;
		for(int i=1;i<=n;i++){
			result*=i;
		}
		System.out.println(result);
	}

}
