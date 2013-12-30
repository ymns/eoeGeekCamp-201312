package day05_ex;

import java.util.Scanner;

public class Exercise03_ {

	/**
	 * @param args
	 * 不用判断语句，输入月份，显示天数，考虑闰年2月分的情况
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] a={28,29,30,31};
		Scanner y=new Scanner(System.in);
		System.out.println("请输入一个年份：");
		int year=y.nextInt();
		System.out.println("请输入一个月份：");
		int  month=y.nextInt();
		switch(month){
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.println(a[3]);
			break;
		case 4:
		case 6:
		case 9:
			System.out.println(a[2]);
			break;
		case 2:
			if(year%4==0&&year%100!=0||year%400==0){
				System.out.println(a[1]);
			}else{
				System.out.println(a[0]);
			}
			break;
		default:
			break;
		}
}
}
