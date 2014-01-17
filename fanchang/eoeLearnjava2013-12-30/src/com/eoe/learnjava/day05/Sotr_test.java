package com.eoe.learnjava.day05;

import java.util.Arrays;
import java.util.Random;

public class Sotr_test {
	public static void main(String[] args) {
		Random random=new Random();
		int[] scores=new int[10];
		for (int i = 0; i < scores.length; i++) {
			scores[i]=random.nextInt(41)+60;
			System.out.print(scores[i]+" ");
		}
		//全部排序
		for (int j = 0; j < scores.length-1; j++) {
			for (int i = 1+j; i < scores.length; i++) {
				if(scores[j]<scores[i]){
					//交换scores[0]和scores[i]
					int temp=scores[j];
					scores[j]=scores[i];
					scores[i]=temp;
				}
			}
		}
//		//将最高分交换到scores[0]
//		for (int i = 1; i < scores.length; i++) {
//			if(scores[0]<scores[i]){
//				//交换scores[0]和scores[i]
//				int temp=scores[0];
//				scores[0]=scores[i];
//				scores[i]=temp;
//			}
//		}
//		//第二个最大数
//		for (int i = 2; i < scores.length; i++) {
//			if(scores[1]<scores[i]){
//				//交换scores[1]和scores[2]
//				int temp=scores[1];
//				scores[1]=scores[i];
//				scores[i]=temp;
//			}
//		}
//		//第三个最大数
//		for (int i = 3; i < scores.length; i++) {
//			if(scores[2]<scores[i]){
//				//交换scores[2]和scores[3]
//				int temp=scores[2];
//				scores[2]=scores[i];
//				scores[i]=temp;
//			}
//		}
		System.out.println();
		System.out.println(Arrays.toString(scores));
	}
}

