package com.eoe.learnjava.day03;

public class Exercise06 {

	/**
	 * 计算3712秒是几小时、几分、几秒
	 * @param args
	 */
	public static void main(String[] args) {
		int time = 3712;	
		System.out.println("计算3712是"+(3712/3600)+"时"
							+(3712%3600)/60+"分"+((3712%60)%60)+"秒");

	}

}
