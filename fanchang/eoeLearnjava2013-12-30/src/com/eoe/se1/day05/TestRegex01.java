package com.eoe.se1.day05;

public class TestRegex01 {

	/**
	 * 
	 * 编写程序验证4位16进制数，并将符合条件的打印出来 (解法1)
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String[] data = {"0x55ff","0X78ad","0x32ah","0x7ff1"};
		String regex="0[xX][\\da-fA-F]{4}";//正则表达式
		for (int i = 0; i < data.length; i++) {
			if (data[i].matches(regex)) {
				System.out.println(data[i]);
			}
		}
	}

}
