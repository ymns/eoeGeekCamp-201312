package day05_ex;

import java.util.Scanner;

public class Exercise03 {

	/**
	 * @param args  输入月份，显示天数，考虑闰年2月分的情况
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入一个年份：");
		int year=sc.nextInt();
		System.out.println("请输入一个月份：");
		 int month=sc.nextInt();
		 switch(month){
		 case 1:
		 case 3:
		 case 5:
		 case 7:
		 case 8:
		 case 10:
		 case 12:
			 System.out.println("31days");
			 break;
		 case 4:
		 case 6:
		 case 9:
		 case 11:
			 System.out.println("30days");
			 break;
		 case 2:
			 if(year%4==0&&year%100!=0 ||year%400==0){
				 System.out.println("29days");
			 }else{
				 System.out.println("28days");
			 }
		 }
		 
		
		
		
		

	}

}
