package com.eoe.se2.day05.serverTalk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerTalk {

	/**
	 * 服务端与客户端一对一聊天, 服务端
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedReader reader = null;
		PrintStream writer = null; // 不需要flush

		try {
			ServerSocket server = new ServerSocket(8888);
			System.out.println("服务端等待连接...");
			Socket socket = server.accept();
			reader = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			writer = new PrintStream(socket.getOutputStream());
			// 开始聊天
			System.out.println(reader.readLine());
			System.out.println("开始聊天");
			writer.println("卖家:亲!  欢迎光临");
			while (true) {
				// 获取客户端发送的聊天文本
				String question = reader.readLine();
				// 显示在控制台
				System.out.println("买家:" + question);
				if (question.indexOf("88") >= 0) {
					writer.println("886");
					break;
				}
				// 键盘输入服务端的聊天信息
				System.out.print("卖家:");
				String answer = new Scanner(System.in).next();
				writer.println(answer);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (writer != null) {
				writer.close();
			}
		}
	}

}
