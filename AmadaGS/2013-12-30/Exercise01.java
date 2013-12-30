package day05_ex;

public class Exercise01 {

	/**
	 * @param args
	 *            查找100～999之间的所有回文数
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for (int j = 100; j < 1000; j++) {
			int a = j % 10;
			int b = j / 100;
			if (a == b) {
				System.out.print(j + " ");
			}
		}
	}
}
