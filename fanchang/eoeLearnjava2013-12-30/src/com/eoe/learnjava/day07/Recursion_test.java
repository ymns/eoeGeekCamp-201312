package com.eoe.learnjava.day07;

import java.util.Scanner;

public class Recursion_test {

	/**1+2+3+....+n=?
	 * 1+3+5+...+n=?
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("n=");
		int n = scanner.nextInt();		
		System.out.println(summation(n));
	}
	static int summation(int n){
		if(n==1){
			return 1;
		}
		int result = summation(n-1)+n;//    n-2
		return result;
	}

}
