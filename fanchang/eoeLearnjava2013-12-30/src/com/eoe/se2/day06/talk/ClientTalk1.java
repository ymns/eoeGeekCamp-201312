package com.eoe.se2.day06.talk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientTalk1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedReader reader = null;
		PrintStream writer = null;

		try {
			Socket socket = new Socket("127.0.0.1", 6666);
			reader = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			writer = new PrintStream(socket.getOutputStream());
			System.out.println("已经连接");
			writer.println("已经连接");
			System.out.println("开始聊天");
			Scanner scanner = new Scanner(System.in);
			// 开始聊天
			while (true) {
				String answer = reader.readLine();
				System.out.println(answer);
				if (answer.indexOf("88") >= 0) {
					writer.println("买家1:886");
					break;
				}
				System.out.print("买家1:");
				String question = scanner.next();
				writer.println("买家1:" + question);

			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
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
