package com.eoe.learnjava.day07;

import java.util.Scanner;

public class Di_gui {

	/**¼ÆËãnµÄ½×³Ë
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("nµÄ½×³Ë:");
		int n=scanner.nextInt();
		double result =fact(n);
		System.out.println(result);

	}
	static double fact(int n){
		if (n==1) {
			return 1;
		}
		double result=n*fact(n-1);
		return result;
	}

}
