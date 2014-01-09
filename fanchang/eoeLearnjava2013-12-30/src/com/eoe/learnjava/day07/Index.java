package com.eoe.learnjava.day07;

public class Index {

	/**获取字符或字符串第一次或最后一次出现的下表
	 * @param args
	 */
	public static void main(String[] args) {
		String url="http://www.eoe.com/logo.gif";
		int pos=url.indexOf("://");
		System.out.println(pos);
		String protocol=url.substring(0, pos); //获取协议名称
		System.out.println(protocol);
		pos=url.lastIndexOf("/");
		String filename=url.substring(pos+1); //获取图片文件名
		System.out.println(filename);
	}

}
