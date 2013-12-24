package Test04;

import java.util.Random;
import java.util.Scanner;

public class Test04 {

	public Test04() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 电脑随机产生0到99之间的整数
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int guessed = new Random().nextInt(100);// 电脑随机产生0到99之间的整数
		int guess;
		int count = 0;
		do {
			count++;// 计数猜了几次
			System.out.println("猜吧：");
			guess = scanner.nextInt();// 键盘输入猜的数

			if (guess < guessed) {// 如果输入的数小于随机产生的数，输出猜小了
				System.out.println("猜小了");

			} else if (guess > guessed) {// 如果输入的数大于随机产生的数，输出猜大了
				System.out.println("猜大了");

			} else {// 输入的数等于随机产生的数，输出猜对了
				System.out.println("猜对了");
				break;
			}
		} while (true);
		if (count == 1) {
			System.out.println("偶像，签个字吧");
		} else if (count == 2) {
			System.out.println("蒙的吧");
		} else if (count <= 7) {
			System.out.println("你很懂的猜数策略");

		} else {
			System.out.println("脑积水吧");
		}
	}

}
