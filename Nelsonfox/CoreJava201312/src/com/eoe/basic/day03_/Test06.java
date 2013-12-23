package com.eoe.basic.day03_;

import java.util.Scanner;

public class Test06 {

	public Test06() {
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
     switch(score){
     case 5:
    	 System.out.println("优秀");
    	 break;
     case 4:
    	 System.out.println("良好");
    	 break;
     case 3:
    	 System.out.println("及格");
    	 break;
     case 2:
     case 1:
     case 0:
    	 System.out.println("输入的不是5分制的分数");
    	 break;
     }
	}

}
