package Test04;

public class Test07 {

	public Test07() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * substring
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text = "abcdefg";
		String text1 = text + "";
		if (text.equals(text1)) {// equals看字符串的内容；==看地址是否相同
			System.out.println("相同");
		} else {
			System.out.println("不同");
		}
	}

}
