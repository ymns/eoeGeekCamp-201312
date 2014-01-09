package com.eoe.learnjava.day07;

import java.util.Arrays;

public class Bubblesort01 {

	/**
	 * ц╟ещеепР
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = { 50, 40, 30, 20, 10 };
		System.out.println(Arrays.toString(a));
		for (int j = 1; j < a.length; j++) {
			for (int i = 0; i < a.length - j; i++) {
				swap(a, i, i + 1);
			}
		}
		System.out.println(Arrays.toString(a));
	}

	static void swap(int[] a, int i, int j) {
		int c = a[i];
		a[i] = a[j];
		a[j] = c;
	}

}
