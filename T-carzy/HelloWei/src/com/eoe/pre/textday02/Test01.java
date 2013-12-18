package com.eoe.pre.textday02;
/**
 * 计算以下公式，要求保留小数点后2位，
 * 对小数点后第三位四舍五入。
    (sqrt(20)+sqrt(10)/(sqrt(20)-sqrt(10))
 * @author yw
 */
public class Test01 {
	public static void main(String[] args){
		double sqrt10=Math.sqrt(10);
		double sqrt20=Math.sqrt(20);
		System.out.println(" (sqrt(20)+sqrt(10)/(sqrt(20)-sqrt(10))="+
		  Math.round((sqrt10+sqrt20)/(sqrt20-sqrt10)*100)/100.0
				);
	}

}
