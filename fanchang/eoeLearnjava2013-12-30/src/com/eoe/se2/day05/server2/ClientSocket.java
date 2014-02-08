package com.eoe.se2.day05.server2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientSocket {

	/**
	 * 客户端接受来自服务端
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedReader reader = null;
		Socket socket = null;
		try {
			socket = new Socket("127.0.0.1", 6666);
			reader = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			System.out.println(reader.readLine());
			System.out.println(reader.readLine());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (socket != null) {
					socket.close();
				}
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
