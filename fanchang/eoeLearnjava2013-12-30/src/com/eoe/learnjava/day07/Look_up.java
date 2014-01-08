package com.eoe.learnjava.day07;

import java.util.Scanner;

public class Look_up {

	/**通过数组元素找下标
	 * 输入姓名,查找在数组中对应的位置
	 * @param args
	 */
	public static void main(String[] args) {
		String[] name={"张飞","马飞","刘亦菲","王菲","阿飞"};
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入姓名:");
		String named=scanner.next();
		for (int i = 0; i < name.length; i++) {
			if (named.equals(name[i])) {
				System.out.println(i+1);
			}
		}

	}

}
