package com.eoe.basic.day03_;

import java.util.Scanner;

public class Test11 {

	public Test11() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Scanner scanner=new Scanner(System.in);
     System.out.println("输入分数");
     int score=scanner.nextInt();
     boolean isPass=score>=60;
     System.out.println("及格"+isPass);
	}

}
