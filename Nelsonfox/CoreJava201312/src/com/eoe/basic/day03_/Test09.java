package com.eoe.basic.day03_;

import java.util.Scanner;

public class Test09 {

	public Test09() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
   Scanner scanner=new Scanner(System.in);
   System.out.println("mouth:");
   int mouth=scanner.nextInt();
   switch(mouth){
   case 1:
   case 3:
   case 5:
   case 7:
   case 8:
   case 10:
   case 12:
	   System.out.println(31);
	   break;
   case 4:
   case 6:
   case 9:
   case 11:
	   System.out.println(30);
	   break;
   case 2:
	   System.out.println(28);
	   break;
	   default:
		   System.out.println("月份输入错误");
		   break;
   }
	}

}
