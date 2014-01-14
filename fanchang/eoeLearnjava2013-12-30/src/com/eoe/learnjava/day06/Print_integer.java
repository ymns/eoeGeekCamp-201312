package com.eoe.learnjava.day06;

public class Print_integer {

	/**
	 * 用三重循环打印0-999
	 * @param args
	 */
	public static void main(String[] args) {
		for (int i = 0; i <= 9; i++) {         //外层循环代表百位
			for (int j = 0; j <= 9; j++) {     //中层循环代表十位
				for (int g = 0; g <= 9; g++) { //内层循环代表个位
					System.out.print(i*100+j*10+g+"  ");
				}
			    System.out.println();
			}
			System.out.println();
		}
	}

}
