package day_02;

import java.util.Scanner;

import javax.script.ScriptContext;

public class Exercise02 {

	/**
	 * 编写计算华氏转换为摄氏温度的程序，
	 * 公式： 摄氏温度值=（华氏温度值-32）×5÷9 要求：
	 * (1)华氏设施温度由键盘输入。
	 * (2)保留小数点后1位。 文件名：Exercise02.java
	 */
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.print("请输入要转换的华氏温度：");
        float h=scanner.nextFloat(); //从键盘取到华氏温度
        float s=((h-32)*5/9);//摄氏温度    
        System.out.println("转换后的结果是："+Math.round(s)/10.0);
	}

}
