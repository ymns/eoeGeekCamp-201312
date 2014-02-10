package com.eoe.se2.day06.talk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerTalk {

	/**
	 * 用线程实现一对多聊天
	 * 
	 * @param args
	 */
	static int i = 1;

	public static void main(String[] args) {
		ServerSocket server = null;
		ExecutorService pools = Executors.newCachedThreadPool();
		try {
			server = new ServerSocket(6666);
			System.out.println("等待客户连接...");
			while (true) {
				Socket socket = server.accept();
				pools.execute(new ServerThread(socket, "卖家" + i));
				i++;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 卖家聊天线程
	static class ServerThread implements Runnable {
		Socket socket;
		String name;

		public ServerThread(Socket socket, String name) {
			this.socket = socket;
			this.name = name;
		}

		@Override
		public void run() {
			BufferedReader reader = null;
			PrintWriter writer = null;

			try {
				reader = new BufferedReader(new InputStreamReader(
						socket.getInputStream()));
				writer = new PrintWriter(socket.getOutputStream());
				System.out.println(reader.readLine());
				System.out.println("开始聊天");
				writer.println("卖家:亲,要点儿啥?");
				writer.flush();
				while (true) {
					// 接受一行消息
					String question = reader.readLine();
					System.out.println(question);
					if (question.indexOf("88") >= 0) {
						writer.println("卖家:886");
						writer.flush();
						i--;
						break;
					}
					System.out.print("卖家" + ":");
					String answer = new Scanner(System.in).next();
					writer.println("卖家" + ":" + answer);
					writer.flush();
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
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
}
