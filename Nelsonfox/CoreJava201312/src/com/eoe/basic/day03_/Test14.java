package com.eoe.basic.day03_;

import java.util.Scanner;

public class Test14 {

	public Test14() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner scanner=new Scanner(System.in);
System.out.println("输入5分制的分数");
int score=scanner.nextInt();
boolean isScore=!(score<0 || score>5);
System.out.println("是5分制的分数"+isScore);
	}

}
