package com.eoe.basic.day03_;

public class test05 {

	public test05() {
		// TODO Auto-generated constructor stub
	}
     
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     System.out.println(pround(3.758,2));
	}
	static double pround(double value,int index){
		double pow10=Math.pow(10, index);
		double result=value*pow10;
		result=Math.round(result);
		result=result*1.0/pow10;
		return result;
	}

}
