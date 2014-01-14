package com.eoe.learnjava.day07;

import java.util.Arrays;
import java.util.Scanner;

public class Test_array02 {

	/**
	 * 输入一个字母,统计该字母在英文中出现的位置
	 * father mother we are family
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String text="father mother we are family";
		System.out.println("请输入一个字符:");
		char c=scanner.next().charAt(0);
		int[] position={};
		for (int i = 0; i < text.length(); i++) {
			if (c==text.charAt(i)) {
				//数组position容量加1
				position=Arrays.copyOf(position, position.length+1);
				//在数组的新增元素中记录字符c在字符串text中出现的位置
				position[position.length-1]=i;
			}
		}
		//显示数组position的所有元素值
		System.out.println(Arrays.toString(position));
	}

}
