package com.eoe.se2.day05.server3;

import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Socket socket = null;
		OutputStream out = null;
		PrintStream writer = null;
		for (int i = 0; i <= 3; i++) {
			try {
				socket = new Socket("127.0.0.1", 8888);
				out = socket.getOutputStream();
				writer = new PrintStream(out);
				writer.println("已连接");
				System.out.println("访问次数i=" + i);
				Thread.sleep(1000);
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				if (socket != null) {
					try {
						socket.close();
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

}
