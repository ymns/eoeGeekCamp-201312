package day1225;

import java.util.Scanner;

public class Work01 {

	public Work01() {
		// TODO Auto-generated constructor stub
	}

	/**输入1~9个字符串，例如12345,打印如下字符图形：
	 * 12345
	 *  1234
	 *   123
	 *    12
	 *     1
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);//键盘输入一个
		//字符串
		System.out.println("请输入数据");
		String text = scanner.next();
		String space = "";//定义一个space，存储空格
		for (int i = 1; i <= text.length(); i++) {
			System.out
					.println(space + text.substring(0, text.length() - i + 1));
			space += "  ";
		}
	}

}
