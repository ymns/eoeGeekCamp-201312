package day_01;

public class NO_5 {

	/**
	 * 编写Exercise04类，计算以下公式，要求保留小数点后2位，对小数点后第三位四舍五入。
	 * (sqrt(20)+sqrt(10)/(sqrt(20)-sqrt(10))
	 */
	public static void main(String[] args) {
		double a = (Math.sqrt(20) + Math.sqrt(10))
				/ (Math.sqrt(20) - Math.sqrt(10));
		System.out.println("(sqrt(20)+sqrt(10)/(sqrt(20)-sqrt(10))="
				+ (double) Math.round(a * 100) / 100.0);
	}

}
