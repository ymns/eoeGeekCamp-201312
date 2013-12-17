package day_02;

public class Exercise04 {

	/**
	 * 编写程序，不用第三个变量，实现两个字符类型变量值互换。 文件名：Exercise04.java
	 */
	public static void main(String[] args) {
		char a='A';
		char b='B';    //将字符型转换成整型 运算 然后再强制转换成字符型
		a=(char)(a+b);
		b=(char)(a-b);
		a=(char)(a-b);
System.err.println("转换后的值为：a="+a+"  b="+b);
	}

}
