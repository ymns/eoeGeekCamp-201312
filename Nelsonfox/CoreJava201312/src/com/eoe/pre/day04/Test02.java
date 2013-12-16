package com.eoe.pre.day04;

public class Test02 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a;
		a=1;
		try{
			a=5/0;
		}catch(ArithmeticException e){
			System.out.println(e.toString());
		}catch(Exception e){
			
		}finally{			
			//f.close();
		}
		System.out.println("俺能被执行到");
	}

}
