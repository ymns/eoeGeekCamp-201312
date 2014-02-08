package com.eoe.se2.day05;

import java.io.IOException;
import java.net.InetAddress;

public class SocketAddress {

	/**
	 * InetAddress类的示例
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		//使用getByAddress
		InetAddress ip = InetAddress.getByAddress(new byte[] { 127, 0, 0, 1 });
		System.out.println("主机ip:" + ip.getCanonicalHostName());
		System.out.println("主机ip:" + ip.getHostAddress());
		System.out.println("是否到达:" + ip.isReachable(2000));
		//getByName
		ip=InetAddress.getByName("10.0.0.171");
		System.out.println("主机名称:" + ip.getCanonicalHostName());
		System.out.println("主机ip:" + ip.getHostAddress());
		System.out.println("是否到达:" + ip.isReachable(2000));
		//getLocalHost
		ip=InetAddress.getLocalHost();
		System.out.println("主机名称:" + ip.getHostName());
		System.out.println("是否到达:" + ip.isReachable(2000));
	}

}
