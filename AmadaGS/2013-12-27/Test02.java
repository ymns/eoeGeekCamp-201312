package JavaDay05;

public class Test02 {

	/**
	 * @param args   获取协议名称
	 */
	public static void main(String[] args) {
		String url="http://www.eoe.com/logo.git";
		int pos=url.indexOf(":/");
		String pro=url.substring(0, pos);
		System.out.println("协议名字："+pro);
		int a=url.lastIndexOf("/");
		String n=url.substring(a+1);
		System.out.println("文件名字:"+n);
		

	}

}
