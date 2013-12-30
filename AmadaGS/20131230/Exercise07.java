package day05_ex;

public class Exercise07 {

	/**
	 * @param args
	 * 
	 * 将以下代表网站资源的字符串分解为协议、主机地址、端口号和资源路径
	String url="http://127.0.0.1:8080/elts/user.txt"
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String url="http://127.0.0.1:8080/elts/user.txt";
		String pro=url.substring(0, url.lastIndexOf("://"));
		String host=url.substring(url.lastIndexOf("://")+3,url.lastIndexOf(":"));
		String port=url.substring(url.indexOf("8"));
		port=port.substring(0, port.indexOf("/"));
		String path=url.substring(url.indexOf("e"));
		System.out.println("pro:"+pro );
		System.out.println("host:"+host);
		System.out.println("port:"+port);
		System.out.println("path:"+path);
	}

}
