package com.eoe.se2.day05.server2;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

	/**
	 * 服务端向客户端写
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ServerSocket server=new ServerSocket(6666);
			System.out.println("等待客户端连接...");
			Socket socket = server.accept();
			PrintWriter writer = new PrintWriter(socket.getOutputStream());
			writer.println("发送第一行文本\n发送第二行文本");
			writer.flush();
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
