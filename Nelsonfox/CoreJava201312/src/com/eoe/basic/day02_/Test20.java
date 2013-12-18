package com.eoe.basic.day02_;

import java.util.Scanner;

public class Test20 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("a=");
		int a=scanner.nextInt();
		System.out.println("b=");
		int b=scanner.nextInt();
		System.out.println("c=");
		int c=scanner.nextInt();
		int d=Math.min(c,Math.min(a, b));
		//int e=Math.max(a, b);
		System.out.println(d);
	}
}
