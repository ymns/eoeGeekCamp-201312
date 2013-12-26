package day_02;

import java.util.Scanner;

public class Exercise07 {

	/**
	 * 键盘输入一个整数，要求只输入四位数。
	 * 然后将该数反向打印。 例如：输入5327,显示7235 提示：用％运算分离每一位数字。
	 * 文件名：Exercise07.java
	 */
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("请输入一个四位数：");
		int a=scan.nextInt();
		int thousand=a/1000;//获取千位
		int hunderd=(a%1000)/100;//获取百位
		int ten=(a-thousand*1000-hunderd*100)/10;//获取十位
		int bits=(a-thousand*1000-hunderd*100-ten*10);// 获取个位
		System.out.println("打印："+bits+ten+hunderd+thousand);

	}

}
