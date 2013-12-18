package com.eoe.pre.textday02;
import java.util.Scanner;
//编写程序，键盘输入一个int类型的负数，求出该数的补码。
//文件名：Exercise05.java
public class Exercise05 {
	public static void main(String[] args){
		Scanner scanner=new Scanner(System.in);
		System.out.println("n=");
		int n=scanner.nextInt();
		System.out.println("n的补码："+(~n+1));
	}

}
