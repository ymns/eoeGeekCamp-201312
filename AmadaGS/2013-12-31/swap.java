package project01;

import java.util.Arrays;

public class swap {

	/**
	 * @param args
	 *            编写方法swap，交换两个变量值，测试该方法的交换结果
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * int[] a={50,40,30,20,10};
		 * System.out.println("输出swap()调用前，数组a的值"+Arrays.toString(a));
		 * swap(a,0,1);
		 * System.out.println("输出swap()调用后，数组a的值"+Arrays.toString(a)); }
		 * 
		 * static void swap(int b[],int i,int j){ //交换b[i]和b[j]的值 int c=b[i];
		 * b[i]=b[j]; b[j]=c;
		 * 
		 * }
		 */
		int[] a = { 10 };
		int[] b = { 3 };
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
		swap(a, b);
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));

	}

	static void swap(int[] a, int[] b) {
		int[] c = a;
		a = b;
		b = c;
	}
}
