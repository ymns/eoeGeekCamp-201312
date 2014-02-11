package com.eoe.se2.day06.download2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class DownLoadCinent2 {

	/**
	 * @param args
	 */
	private static final String DEST_PATH = "d:/java_test/se2_day06/";
	private static final String FILE_NAME = "Office2003.rar";

	public static void main(String[] args) {
		Socket socket = null;
		ObjectOutputStream oos = null;
		FileOutputStream fos = null;
		InputStream in = null;

		try {
			socket = new Socket("127.0.0.1", 6666);
			oos = new ObjectOutputStream(socket.getOutputStream());
			FileInfo info = new FileInfo(FILE_NAME, 0);
			oos.writeObject(info);
			fos = new FileOutputStream(DEST_PATH + info.getFileName());
			byte[] buffer = new byte[1024];
			in = socket.getInputStream();
			int len;

			while ((len = in.read(buffer)) != -1) {
				fos.write(buffer, 0, len);
			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (oos != null) {
					oos.close();
				}
				if (fos != null) {
					fos.close();
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
