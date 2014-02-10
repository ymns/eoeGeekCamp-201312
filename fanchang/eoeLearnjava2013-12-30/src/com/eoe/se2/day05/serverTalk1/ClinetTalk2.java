package com.eoe.se2.day05.serverTalk1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClinetTalk2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedReader reader = null;
		PrintWriter writer = null;
		Socket socket = null;

		try {
			socket = new Socket("127.0.0.1", 7500);
			reader = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			writer = new PrintWriter(socket.getOutputStream());
			Scanner scanner = new Scanner(System.in);
			while (true) {
				String answer = reader.readLine();
				System.out.println(answer);
				if (answer.indexOf("88") >= 0) {
					writer.println("88");
					writer.flush();
					break;
				}
				System.out.println("买家2:");
				String question = scanner.next();
				writer.println("买家2:" + question);
				writer.flush();
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
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
				if (socket != null) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
