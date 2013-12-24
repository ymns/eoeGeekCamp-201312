package Exercise03;

import java.util.Scanner;

public class Exercise01 {

	public Exercise01() {
		// TODO Auto-generated constructor stub
	}

	/**输入1~9个字符串，例如12345,打印如下字符图形：
	 * 12345
	 *  1234
	 *   123
	 *    12
	 *     1
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner scanner=new Scanner(System.in);
String space="";
System.out.println("輸入字符串：");
String text=scanner.next();
for(int i=0;i<text.length();i++){
	System.out.println(space+text.substring(i));
	space+="  ";//加上空格，实现倒三角
}
	}

}
