package com.eoe.se1.day05;

import java.util.Scanner;

public class TestRegex04 {

	/**
	 * 键盘输入日期，验证日期的合法性。
	 * @param args
	 */
	public static void main(String[] args) {
		String regex="\\d{4}((-|/|.)\\d{1,2}){2}";
		Scanner scanner =new Scanner(System.in);
		System.out.println("输入日期");
		String date;
		boolean ok;
		do {
			date=scanner.next();
			ok=date.matches(regex);
			if(!ok){
				System.out.println("输入格式错误");
			}
		} while (!ok);
		date=date.replaceAll("-|/|\\.", " ");
		System.out.println(date);
		String[] data=date.split(" ");
		int year=Integer.parseInt(data[0]);
		if(year<1990||year>2020){
			System.out.println("输入的年份范围错误");
			return ;
		}
		int month=Integer.parseInt(data[1]);
		if(month<1 || month>12){
			System.out.println("输入的月份错误");
			return ;
		}
		int day=Integer.parseInt(data[2]);
		if(day<1 || day>31){
			System.out.println("输入的日子错误");
			return ;
		}
	}

}
