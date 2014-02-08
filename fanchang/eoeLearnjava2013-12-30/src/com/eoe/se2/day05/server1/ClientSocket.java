package com.eoe.se2.day05.server1;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientSocket {

	/**
	 * 客户端
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Socket socket = null;
		PrintStream prints = null;
		OutputStream out = null;

		try {
			// 创建客户端套接字,指明连接的服务器地址和端口号
			socket = new Socket("127.0.0.1", 8888);
			// 获取输出流
			out = socket.getOutputStream();
			prints = new PrintStream(out);
			prints.println("嗨~  大家好 !");
			System.out.println("客户端");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (prints != null) {
				prints.close();
			}
		}

	}

}
