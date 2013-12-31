package day05_ex;

public class Exercise02 {

	/**
	 * @param args
	 *            用双重循环查找100～200之间的所有质数
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for (int n = 100; n < 200; n++) {
			int k = (int) Math.sqrt(n);
			boolean isPrime = true;
			for (int i = 2; i <= k && isPrime; i++) {
				if (n % i == 0)
					isPrime = false;
			}
			if (isPrime) {
				System.out.print(n + " ");
			}
		}
	}
}
