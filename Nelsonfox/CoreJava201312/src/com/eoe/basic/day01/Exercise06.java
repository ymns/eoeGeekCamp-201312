package com.eoe.basic.day01;

public class Exercise06 {

	public Exercise06() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//System.out.println("3712秒是"+Math.round(3712/3600)+"小时"+Math.round(3712/60)+"分钟"+(3712%3600)+"秒");
        int s=Math.round(3712/3600);
        int d=3712-3600;
        int f=Math.round(d/60);
        int g=d%60;
        System.out.println("3712秒是"+s+"小时"+f+"分钟"+g+"秒");
	}

}
