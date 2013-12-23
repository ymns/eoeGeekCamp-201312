package com.eoe.basic.day03_;

import java.util.Scanner;

public class Test18 {

	public Test18() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Scanner scanner=new Scanner(System.in);
      System.out.println("java android oracle:");
      int java=scanner.nextInt();
      int android=scanner.nextInt();
      int oracle=scanner.nextInt();
      if(java>=android && java>=oracle){
    	  System.out.println("最高分："+java);
    	  
      }else if(android>=oracle){
    	  System.out.println("最高分"+android);
      }else{
    	  System.out.println("最高分"+oracle);
      }
	}

}
