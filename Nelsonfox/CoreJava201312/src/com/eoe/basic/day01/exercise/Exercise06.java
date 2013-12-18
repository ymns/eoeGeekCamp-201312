package com.eoe.basic.day01.exercise;

public class Exercise06 {

	/**
	 * 编写Test11类，计算3712秒是几小数、几分、几秒。
	 */
	public static void main(String[] args) {
		System.out.println("3712秒是"+3712/3600+"时"
					  				+3712%3600/60+"分"
					  				+3712%60+"秒");
	}

}
