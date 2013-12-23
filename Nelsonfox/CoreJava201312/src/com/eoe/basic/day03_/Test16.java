package com.eoe.basic.day03_;

import java.util.Scanner;

public class Test16 {

	public Test16() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    Scanner scanner=new Scanner(System.in);
    System.out.println("输入两个数");
    int a=scanner.nextInt();
    int b=scanner.nextInt();
    if(a>b){
    	System.out.println("最大数是"+a);
    	
    }else {
		System.out.println("最大数是"+b);
	}
	}

}
