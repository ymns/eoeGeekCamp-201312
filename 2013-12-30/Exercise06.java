package day05_ex;

import java.util.Arrays;
import java.util.Random;

public class Exercise06 {

	/**
	 * @param args
	 * \随机产生5个分数，用以Test24为基础，用冒泡方式降序排序。
	要求：用双重循环完成排序。
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Random ran=new Random();
		int[] score=new int[5];
		System.out.println("请输入五个随机数：");
		for(int i=0;i<5;i++){
			score[i]=ran.nextInt(41)+100;
			System.out.print(score[i]+" ");
		}
		System.out.println();
		int[] a=score;
		for(int i=0;i<score.length-1;i++){
			for(int j=i+1;j<score.length;j++){
				if(a[i]<a[j]){
					int t=a[i];
					a[i]=a[j];
					a[j]=t;
				}
			}
			System.out.println(Arrays.toString(score));
		}
	}
}
