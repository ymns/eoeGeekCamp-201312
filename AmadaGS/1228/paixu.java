package project01;

import java.util.Arrays;

public class paixu {

	/**
	 * @param args已知数组
	 *            ：int[] a={50,40,30,20,10}; 将数组元素由左至右地交换，最后结果：
	 *            a={10,20,30,40,50}; 要求显示中间的交换过程，如下所示： [50, 40, 30, 20, 10]
	 *            [40, 30, 20, 10, 50] [30, 20, 10, 40, 50] [20, 10, 30, 40, 50]
	 *            [10, 20, 30, 40, 50]
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 90, 70, 50, 49, 32, 10 };
		System.out.println(Arrays.toString(a));
		for (int i = 1; i < a.length; i++) {
			for (int j = 0; j < i; j++)
				if (a[j] > a[i]) {
					int t = a[i];
					a[i] = a[j];
					a[j] = t;
				}
			System.out.println(Arrays.toString(a));
		}
		System.out.println(Arrays.toString(a));
	}

}
