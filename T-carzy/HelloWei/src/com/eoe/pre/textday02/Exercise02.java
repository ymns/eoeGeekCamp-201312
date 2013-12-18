package com.eoe.pre.textday02;
import java.util.Scanner;
//编写计算华氏转换为摄氏温度的程序，公式： 摄氏温度值=（华氏温度值-32）×5÷9
//要求：
//摄氏度
//	 (1)华氏设施温度由键盘输入。
//  (2)保留小数点后1位。
public class Exercise02 {
	public static void main(String[] args){
		
		Scanner scanner=new Scanner(System.in);
		System.out.print("f=");
		double f=scanner.nextDouble();
		double degreeCelsius=(f-32)*5/9;
		System.out.println(f+"华氏度等于"+degreeCelsius+"摄氏度");
	}

	private static Object nextdouble() {
		// TODO Auto-generated method stub
		return null;
	}

}
