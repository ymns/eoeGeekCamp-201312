package Test04;

public class Test03 {

	public Test03() {
		// TODO Auto-generated constructor stub
	}

	/**求100~999之间的水仙花数153=1*1*1+5*5*5+3*3*3
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 100; i < 1000; i++) {
			int g = i % 10;//取出个位数
			int s = i / 10 % 10;//取出十位数
			int b = i / 100;//取出百位数
			if (i == g * g * g + s * s * s + b * b * b) {
				System.out.println(i);
			}
		}
	}

}
