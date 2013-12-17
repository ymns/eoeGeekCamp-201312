package day_01;

public class Exercise03 {

	/**
	 * 编写程序，文件名：Exercise03.java，
	 * 计算两个字节，即16位的二进制数最大值： (1111111111111111)2=()10
	 */
	public static void main(String[] args) {
		System.out.println("16位的二进制数最大值(1111111111111111)2="
				+ (int) (Math.pow(2, 16) - 1));

	}

}
