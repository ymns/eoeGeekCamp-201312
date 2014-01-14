package com.eoe.learnjava.day07;

import java.util.Scanner;

public class Grade {

	/**
	 * 不用判断语句给五分制的分数评定成绩等级
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
//		int score;
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("请输入一个五分制的数:");
//		do {
//			score = scanner.nextInt();
//		} while (score<0||score>5);
//		String[] grades={"不及格","不及格","不及格","及格","良好","优秀"};
//		System.out.println(grades[score]);
//	}

		
		//不用判断语句输入0-100的数,判断分数等级
		int score;
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入一个百分制的数:");
		do {
			score = scanner.nextInt();
		} while (score<0||score>100);
		String[] grades={"不及格","不及格","不及格","不及格","不及格","不及格",
				"及格","中等","良好","优秀"};
		System.out.println(grades[score/10]);
		}
}
