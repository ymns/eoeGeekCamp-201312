package com.eoe.se2.day05.server3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server1 {

	/**
	 * 测试服务端的套接字最大能接收的连接请求，连接队列默认的最大值是50 当设置休眠1秒时，最多只能接收三个客户端的请求。
	 * 若将休眠语句注释掉，则能连接任意多次。
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		BufferedReader reader = null;
		PrintStream writer = null;
		Socket socket = null;
		ServerSocket server = null;
		try {
			// 创建服务端的套接字，设置响应客户端请求最大值为3
			server = new ServerSocket(8888, 3);
			System.out.println("等待客户端连接..");
			socket = server.accept();
			reader = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			writer = new PrintStream(socket.getOutputStream());

			String question = reader.readLine();
			System.out.println(question);
			scanner.next(); // 输入阻塞
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (server != null) {
					server.close();
				}
				if (reader != null) {
					reader.close();
				}
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
