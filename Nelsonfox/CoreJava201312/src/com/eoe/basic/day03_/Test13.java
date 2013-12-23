package com.eoe.basic.day03_;

import java.util.Scanner;

public class Test13 {

	public Test13() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    Scanner scanner=new Scanner(System.in);
    System.out.println("输入5分制的数");
    int score=scanner.nextInt();
    boolean isnotScore=score<0 || score>5;
    System.out.println("不是5分制的数"+isnotScore);
	}

}
