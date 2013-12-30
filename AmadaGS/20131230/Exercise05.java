package day05_ex;

import java.util.Arrays;
import java.util.Random;

public class Exercise05 {

	/**
	 * @param args
	 *            随机产生5个60～100之间的分数，降序排序。
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random ran = new Random();
		int[] score = new int[5];
		for (int i = 0; i < 5; i++) {
			score[i] = ran.nextInt(41) + 60;
			System.out.print(score[i] + " ");
		}
		System.out.println();
		int[] a = score;
		System.out.println(Arrays.toString(a));
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = 1; j <a.length; j++)
				if (a[i] < a[j]) {
					int t = a[i];
					a[i] = a[j];
					a[j] = t;
				}
			System.out.println(Arrays.toString(a));
		}
	}
}