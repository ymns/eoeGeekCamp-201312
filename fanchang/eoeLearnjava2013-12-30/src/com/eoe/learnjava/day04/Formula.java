package com.eoe.learnjava.day04;
public class Formula {

	/**
	 * 编程计算一下公式: (∑10+∑5)*(∑8+∑4)/(pow(2,8)-5!)+4!-pow(3,4)
	 * 要求:对以上结果保留小数点后三位
	 * @param args
	 */
	public static void main(String[] args) {
		double result = (addn(10)+addn(5))*(addn(8)+addn(4))/(pow(2,8)-
						fact(5))+fact(4)-pow(3,4);
		System.out.println("(∑10+∑5)*(∑8+∑4)/(pow(2,8)-5!)+4!-pow(3,4)=");
		System.out.println(pround(result, 3));
	}

	// 求和方法
	static int addn(int n){
		int a=0;
		for(int i=1;i<=n;i++){
			a+=i;
		}
		return a;
	}
	
	//求阶乘
	static double fact(int n){
		int a=1;
		for(int i=1;i<=n;i++){
			a*=i;
		}
		return a;
	}
	
	//求平方
	static int 	pow(int m,int n){
		int a=1;
		for(int i=1;i<=n;i++){
			a*=m;	
		}
		return a;
	}
	
	//保留小数点后三位
	static double pround(double x, int n){
		return Math.round(Math.pow(10, n)*x)*1.0/Math.pow(10, n);
	}
			
}
