package day_01;

public class Exercise01 {
	/**
	 * 编写Exercise01类，
	 * 计算 1KB=?Byte 
	 * 1MB=?Byte 
	 * 1GB=?Byte 
	 * 1TB=?Byte
	 */
	public static void main(String[] args) {
		System.out.println("1KB=" + (int) Math.pow(2, 10) + " Byte");
		System.out.println("1MB=" + (long) Math.pow(2, 20) + " Byte");
		System.out.println("1GB=" + (long) Math.pow(2, 30) + " Byte");
		System.out.println("1TB=" + (long) Math.pow(2, 40) + " Byte");

	}

}
