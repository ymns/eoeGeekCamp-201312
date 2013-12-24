package Test04;

public class Test10 {

	public Test10() {
		// TODO Auto-generated constructor stub
	}

	/**不用第三个变量，交换两个String类型的变量值
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
String s1="abcd";
String s2="efg";
System.out.println("s1="+s1+"s2="+s2);
s1+=s2;//将s1和s2相加，得到s1=abcdefg
s2=s1.substring(0,s1.length()-s2.length());//取出s2从s1中，相当于
//s2=s1.substring(0,4);
s1=s1.substring(s2.length());
System.out.println("s1="+s1+"s2="+s2);
	}

}
