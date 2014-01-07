package com.eoe.learnjava.day06;

import java.util.Scanner;

public class Put_String2 {

	/**输入字符串1-9,例如12345,打印出下列字符图形:
	 * 12345
	 *  234
	 *   3
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入一个字符串:");
		String space="";
		String s;
		do {
			s=scanner.next();
		} while ((s.length()<0||s.length()>9)&&s.length()%2==0);
		for (int i = 0; i < s.length()/2+1; i++) {
			System.out.println(space+s.substring(i, s.length()-i));
			space+=" ";
		}
	}

}
