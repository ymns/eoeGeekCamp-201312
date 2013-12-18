package com.eoe.pre.textday01;

public class Test11 {
//	计算3712秒是几小时、几分、几秒
	public static void main(String[] args){
		int hours=3712/3600;
		int minutes=(3712%3600)/60;
		int seconds=(3712%3600)%60;
		System.out.println("3712秒是"+hours+"时"+minutes+"分"+seconds+"秒");


	} 

}
