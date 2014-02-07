package com.eoe.se2.day02;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class IoString {

	/**
	 * @param args
	 * @throws UnsupportedEncodingException
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		String src = "Az中";
		System.out.println("源字符:" + src);
		// 将字符串按utf-16be编码转化为byte[]
		byte[] data = src.getBytes("utf-16be");
		// 反序列化解码将字节转换为字符
		String dest = new String(data, "utf-16be");
		// 打印编码后的byte数组
		System.out.println(Arrays.toString(data));
		System.out.println(dest);
		
		//将字符串按utf-8编码转换成byte[]
		data = src.getBytes("utf-8");
		System.out.println(Arrays.toString(data));
		dest=new String(data,"utf-8");
		System.out.println(dest);
		
		//将字符串按gbk编码转换为byte[]
		data=src.getBytes("gbk");
		System.out.println(Arrays.toString(data));
		dest=new String(data,"gbk");
		System.out.println(dest);
		dest=new String(data,"utf-8");
		System.out.println(dest);
		
	}
}
