package com.eoe.se2.day05.server1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

	/**
	 * 服务端
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// 声明字符缓冲输入流
		BufferedReader reader = null;
		// 声明输入流
		InputStream in = null;

		// 创建服务端套接子对象
		try {
			ServerSocket server = new ServerSocket(8888);
			System.out.println("等待客户端连接...");
			Socket socket = server.accept();// 监听客户端的连接
			// 与客户端建立联系后获取输入流
			in = socket.getInputStream();
			// 创建字符缓冲输入流,包装输入流
			reader = new BufferedReader(new InputStreamReader(in));
			String msg = reader.readLine();
			System.out.println(msg);
			// 关闭套接字
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
