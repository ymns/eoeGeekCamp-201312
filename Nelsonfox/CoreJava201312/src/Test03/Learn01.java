package Test03;

public class Learn01 {

	public Learn01() {
		// TODO Auto-generated constructor stub
	}

	/**输出A到Z的ASCALL码方法1
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char c = 'A';
		while (c <= 'Z') {
			System.out.println(c + ":" + (int) c);
			c++;
		}
	}

}
