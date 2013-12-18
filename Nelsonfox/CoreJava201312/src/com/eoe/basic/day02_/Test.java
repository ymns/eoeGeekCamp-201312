package com.eoe.basic.day02_;
/**
 * 编写Exercise04类，计算以下公式，要求保留小数点后2位，
 * 对小数点后第三位四舍五入。
    (sqrt(20)+sqrt(10)/(sqrt(20)-sqrt(10))
 * @author yw
 */
public class Test {
	public static void main(String[] args) {
		/*学习的环节
		 * 预习、上课听讲、练习
		 * 见名知义
		 * double：双精度、浮点类型的变量
		 * sumScoreDouble Pascal
		 * main static for 
		 */
		double sqrt20=Math.sqrt(20);
		double sqrt10=Math.sqrt(10);
		double result=(sqrt20+sqrt10)/(sqrt20-sqrt10);
		result=Math.round(result*100)/100.0;
		System.out.println("(sqrt(20)+sqrt(10)/(sqrt(20)-sqrt(10))="+result);
		
	}
}
