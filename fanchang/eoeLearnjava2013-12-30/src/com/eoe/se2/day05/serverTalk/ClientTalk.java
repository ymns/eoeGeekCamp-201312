package com.eoe.se2.day05.serverTalk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientTalk {

	/**
	 * 服务端与客户端一对一聊天 客户端
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedReader reader = null;
		PrintStream writer = null;
		try {
			Socket socket = new Socket("127.0.0.1", 8888);
			reader = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			writer = new PrintStream(socket.getOutputStream());
			System.out.println("成功连接!");
			writer.println("成功连接!");
			System.out.println(reader.readLine());
			Scanner scanner = new Scanner(System.in);
			while (true) {
				// 接受客户端问题
				System.out.print("买家:");
				String question = scanner.next();
				writer.println(question);
				String answer = reader.readLine();
				System.out.println("卖家:" + answer);
				if (answer.indexOf("88") >= 0) {
					writer.println("886");
					break;
				}
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				writer.close();
			}
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
