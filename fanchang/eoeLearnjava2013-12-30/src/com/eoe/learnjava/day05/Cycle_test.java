package com.eoe.learnjava.day05;

public class Cycle_test {

	/**100-999的水仙花个数
	 * 用三重循环做
	 * @param args
	 */
	public static void main(String[] args) {
		for (int i = 1; i <= 9; i++) {         //外层循环代表百位
			for (int j = 0; j <= 9; j++) {     //中层循环代表十位
				for (int g = 0; g <= 9; g++) { //内层循环代表个位
					int s=i*100+j*10+g;
					if (g*g*g+i*i*i+j*j*j==s) {						
						System.out.println(s);
					}
				}
			}
		}
	}

}
