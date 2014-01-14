package com.eoe.learnjava.day07;

import java.util.Arrays;

public class Rotate {

	/**
	 *  打印旋转方阵
	 *  1  2  3  4  5
	 *  16 17 18 19 6
	 *  15 24 25 20 7
	 *  14 23 22 21 8
	 *  13 12 11 10 9
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] a= {
			{ 1, 2, 3, 4, 5},
			{16,17,18,19, 6},
			{15,24,25,20, 7},
			{14,23,22,21, 8},
			{13,12,11,10, 9}
			};
		//按一维数组的方式打印方阵
		for (int i = 0; i < a.length; i++) {
			System.out.println(Arrays.toString(a[i]));
		}
		//创建二维数组对象
		int [][] b=new int[3][];
		b[0]=new int []{5,9,7,12};
		b[1]=new int []{10,18};
		b[2]=new int []{102,345,289};
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[i].length; j++) {
				if(b[i][j]<10){
					System.out.print("  ");
				}else if (b[i][j]<100) {
					System.out.print(" ");
				}
				System.out.print(b[i][j]+" ");
			}
			System.out.println();
		}
	}

}
