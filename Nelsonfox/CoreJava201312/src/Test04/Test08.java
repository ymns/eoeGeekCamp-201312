package Test04;

import java.util.Scanner;

public class Test08 {

	public Test08() {
		// TODO Auto-generated constructor stub
	}

	/**打印字符图形(1)
	 输入1~9个字符串，例如12345,打印如下字符图形：
	 	12345
	 	2345
	 	345
	 	45
	 	5
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner scanner=new Scanner(System.in);
System.out.println("輸入字符串");
String text=scanner.next();
for(int i=0;i<text.length();i++){//Harbsion   substring(3)  "bison"
	System.out.println(text.substring(i));
}
	}

}
