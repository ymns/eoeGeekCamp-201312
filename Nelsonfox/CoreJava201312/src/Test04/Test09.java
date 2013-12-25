package Test04;

import java.util.Scanner;

public class Test09 {

	public Test09() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 【示例-26】打印字符图形(2) 输入1~9个字符串，例如12345,打印如下字符图形： 12345 234 3
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("輸入字符串：");
		String space = "";
		String text = scanner.next();
		for (int i = 0; i < text.length() / 2 + 1; i++) {
			System.out.println(space + text.substring(i, text.length() - i));
			space += " ";
		}
	}

}
