package com.eoe.pre.textday01;
//计算以下公式，要求保留小数点后2位，对小数点后第三位四舍五入。
//(sqrt(20)+sqrt(10)/(sqrt(20)-sqrt(10))
public class Test09 {
	public static void main(String[] args){
		double a= (Math.sqrt(20)+Math.sqrt(10));
		double b= (Math.sqrt(20)-Math.sqrt(10));

		System.out.println(" (sqrt(20)+sqrt(10)/(sqrt(20)-sqrt(10))="+Math.round((a/b)*100)/100.0);
	}

}
