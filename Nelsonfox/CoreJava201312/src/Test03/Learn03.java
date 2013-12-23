package Test03;

public class Learn03 {

	public Learn03() {
		// TODO Auto-generated constructor stub
	}

	/**输出A到Z的Ascall码方法3
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char c = 'A';
		do {
			System.out.println(c + ":" + (int) c);
			c++;
		} while (c <= 'Z');
	}

}
