package Test;

public class Test10 {

	public Test10() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
int i=0x1000001;
System.out.println("int:"+Integer.toBinaryString(i)+" "+i);
float f=i;
System.out.println("float:"+Integer.toBinaryString((int)f)+"  "+f);
	}

}
