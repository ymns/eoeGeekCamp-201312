package day_02;

public class Exercise03 {

	/**
	 * 编写程序，不用第三个变量，用减法实现两个变量值互换。 文件名：Exercise03.java
	 */
	public static void main(String[] args) {
		int a=30;
		int b=20;
		a=b-a;    //求a与b 的差赋予a
		b=b-a;    //b减去 差 即为a的值并赋予b
		a=a+b;    //转换后的b加上a与b的差 即为  b的值 并赋予a
		System.out.println("a=20,b=30转化后的结果为：a="+a+" b="+b);

	}

}
