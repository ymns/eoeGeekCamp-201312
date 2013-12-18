package Test;

public class Test11 {

	public Test11() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
long l=0x20000000000001L;
double d=l;
System.out.println("Long:"+Long.toBinaryString(l)+"  "+l);
System.out.println("double:"+Long.toBinaryString((long)d)+"  "+d);
	}

}
