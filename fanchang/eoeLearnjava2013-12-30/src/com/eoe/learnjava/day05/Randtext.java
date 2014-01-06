package com.eoe.learnjava.day05;

import java.util.Random;

public class Randtext {

	/**创建random类的一个对象,用于产生随机数
	 * @param args
	 */
	public static void main(String[] args) {
		Random rand = new Random();
		for(int i=0;i<10;i++){
			System.out.println(rand.nextDouble());//产生0-1的小数
			System.out.println(rand.nextInt(100));//产生0-100的随机数
		}

	}

}
