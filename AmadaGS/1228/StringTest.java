package project01;

public class StringTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 将以下代表网站资源的字符串分解为协议、主机地址、端口号和资源路径
		String url = "http://127.0.0.1:8080/elts/user.txt";
		if (url.startsWith("http")) {
			String protocal = url.substring(0, url.indexOf("://"));
			String host = url.substring(url.lastIndexOf("://") + 3,
					url.lastIndexOf(":"));
			String port = url.substring(url.indexOf("8"));
			port = port.substring(0, port.indexOf("/"));
			String path = url.substring(url.indexOf("e"));
			System.out.println("protocal:" + protocal);
			System.out.println("host:" + host);
			System.out.println("port:" + port);
			System.out.println("path:" + path);

		}

	}
}
