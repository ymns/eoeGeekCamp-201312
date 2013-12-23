package com.eoe.basic.day03_;

import java.util.Scanner;

public class Test15 {

	public Test15() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    Scanner scanner=new Scanner(System.in);
    System.out.println("输入考试成绩");
    int score=scanner.nextInt();
    if(score>=60){
    	System.out.println("成绩及格");
    }
    
	}

}
