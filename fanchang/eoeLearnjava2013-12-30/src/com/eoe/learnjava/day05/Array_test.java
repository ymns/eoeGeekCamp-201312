package com.eoe.learnjava.day05;

import java.util.Arrays;
import java.util.Scanner;

public class Array_test {

	/**
	 * 删除字符串中的一个元素,后面的元素填补空缺,数组减容
	 * @param args
	 */
	public static void main(String[] args) {
		String[] names={"张飞","王菲","刘亦飞","吗啡"};
		Scanner scanner=new Scanner(System.in);
		int index;//保存删除的位置
		do{
			System.out.println("输入删除的位置(1-4)");
			index=scanner.nextInt();
		}while(index<1 || index>4);
		//后一个元素向前复制
		for(int i=index;i<=names.length-1;i++){
			names[i-1]=names[i];
		}
		//步骤1、names数组减容
		names=Arrays.copyOf(names, names.length-1);
		System.out.println(Arrays.toString(names));
	}

}
