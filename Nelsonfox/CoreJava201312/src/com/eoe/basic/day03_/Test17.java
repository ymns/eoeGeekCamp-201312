package com.eoe.basic.day03_;

import java.util.Scanner;

public class Test17 {

	public Test17() {
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
    if(score<0 || score>5){
    	System.out.println("输入错误");
    	return;
    }
    if(score==5){
    	System.out.println("优秀");
    }else if(score==4){
    	System.out.println("良好");
    }else if(score==3){
    	System.out.println("及格");    	
    }else{
    	System.out.println("不及格");
    }
	}

}
