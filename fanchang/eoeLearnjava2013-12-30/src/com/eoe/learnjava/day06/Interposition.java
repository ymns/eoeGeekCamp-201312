package com.eoe.learnjava.day06;


import java.util.Arrays;
import java.util.Scanner;

public class Interposition {

	/**
	 * 向数组插入元素
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
				
		String[] names={"赵飞","王菲","刘亦菲","吗啡"};
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入1-4的数:");
		int index;
		do {
			index=scanner.nextInt();			
		} while (index<1||index>5);
		//数组扩容
		names=Arrays.copyOf(names, names.length+1);
		for (int i = names.length-1; i > index-1; i--) {
			swap(names,i-1,i);
		}
		names[index-1]="咖啡";
		System.out.println(Arrays.toString(names));
	}
		

//    //删除数组元素
//	String[] names={"赵飞","王菲","刘亦菲","吗啡"};
//	Scanner scanner = new Scanner(System.in);
//	System.out.println("请输入1-4的数:");
//	int index;
//	do {
//		index=scanner.nextInt();			
//	} while (index<1||index>5);
//	for (int i = index-1; i < names.length-1; i++) {
//		swap(names,i,i+1);
//	}
//	//数组减容
//	names=Arrays.copyOf(names, names.length-1);
//	System.out.println(Arrays.toString(names));
//	}
	
	//交换数组值
	static void swap(String[] a,int i,int j){
		String c=a[i];
		a[i]=a[j];
		a[j]=c;
	}
}
