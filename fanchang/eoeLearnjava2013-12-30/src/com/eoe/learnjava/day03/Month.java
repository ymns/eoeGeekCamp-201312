package com.eoe.learnjava.day03;

import java.util.Scanner;

public class Month {

	/**输入月份，显示该月天数
	 * 要求：不考虑二月份闰年的情况
	 * @param args
	 */
	public static void main(String[] args) {	
		Scanner scanner = new Scanner(System.in);
		System.out.println("输入年份：");
		int year = scanner.nextInt();
		System.out.println("月份: ");
		int m = scanner.nextInt();
		switch (m){
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.println("该月是31天");
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println("该月是30天");
			break;
		case 2:
			if((year%400==0||year%4==0)&&year%100!=0){ /*判断是否是闰年*/
				System.out.println("该月28天");
			}else
			System.out.println("该月29天");
			break;
		default:
			System.out.println("月份输入错误");
			break;
		}

	}

}
