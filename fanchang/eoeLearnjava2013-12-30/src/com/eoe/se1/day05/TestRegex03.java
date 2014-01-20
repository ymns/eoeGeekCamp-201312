package com.eoe.se1.day05;


import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TestRegex03 {

	/**
	 * 检测用户输入答案，并将答案按设置的正则表达式规则
	 * 整理、 分割为数组，并按升序排序，最后显示整理过的结果。
	 * @param args
	 */
	public static void main(String[] args) {
		String regex = "([a-d](\\s*,\\s*|\\s+)+){1,4}";
		Scanner scanner = new Scanner(System.in);
		System.out.println("输入答案(a-d或A-D):");
		String answer = null;
		boolean ok;
		do {
			answer=scanner.nextLine().trim().toLowerCase();
			answer+=" ";
			ok=answer.matches(regex);
			if (!ok) {
				System.out.println("你输入答案错误");
			}
		} while (!ok);
		regex="\\s*.\\s*|\\s+";
		answer=answer.replace(regex, " ");
		String[] data=answer.split(" ");
		Arrays.sort(data);
		System.out.println(Arrays.toString(data));
		List<String> list=Arrays.asList(data);
		System.out.println(list);

	}

}
