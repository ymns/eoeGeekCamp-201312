package com.eoe.se2.day05.serverTalk1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerTalk {

	/**
	 * 一对多聊天 服务端
	 * 
	 * @param args
	 */
	static int i = 1;

	public static void main(String[] args) {

		try {
			ServerSocket server = new ServerSocket(7500);
			System.out.println("等待客户连接...");
			while (true) {
				Socket socket = server.accept();
				new ServerThread("卖家" + i, socket).start();
				i++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// 自定义线程类，完成与一个客户端的聊天
	static class ServerThread extends Thread {
		String name;
		Socket socket;

		public ServerThread() {
		}

		public ServerThread(String name, Socket socket) {
			this.name = name;
			this.socket = socket;
		}

		@Override
		public void run() {
			BufferedReader reader = null;
			PrintWriter writer = null;

			try {
				reader = new BufferedReader(new InputStreamReader(
						socket.getInputStream()));
				writer = new PrintWriter(socket.getOutputStream());
				System.out.println("聊天开始");
				writer.println("卖家: 亲    要点儿啥?");
				writer.flush();
				Scanner scanner = new Scanner(System.in);
				while (true) {
					String question = reader.readLine();
					System.out.println(question);
					if (question.indexOf("88") >= 0) {
						writer.println("88");
						writer.flush();
						i--;
						break;
					}
					System.out.println(name+":");
					String answer=scanner.next();
					writer.println(name+":"+answer);
					writer.flush();
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (reader != null) {
						reader.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				if (writer != null) {
					writer.close();
				}
			}
		}
	}

}
