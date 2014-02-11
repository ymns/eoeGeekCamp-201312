package com.eoe.se2.day06.uploading;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import com.eoe.se2.day06.download2.FileInfo;

public class UploadingCinnet1 {

	/**
	 * 客户端上传文件
	 * 
	 * @param args
	 */
	private static final String SRC_PATH = "d:/java_test/";
	private static final String FILE_NAME = "eclipse.zip";

	public static void main(String[] args) {
		Socket socket = null;
		ObjectOutputStream ois = null;
		FileInputStream fos = null;

		try {
			socket = new Socket("127.0.0.1", 5555);
			ois = new ObjectOutputStream(socket.getOutputStream());
			FileInfo info = new FileInfo(FILE_NAME, 0);
			ois.writeObject(info);
			fos = new FileInputStream(SRC_PATH + info.getFileName());
			byte[] buffer = new byte[1024];
			OutputStream out = socket.getOutputStream();
			int len;
			while ((len = fos.read(buffer)) != -1) {
				out.write(buffer, 0, len);
			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ois != null) {
					ois.close();
				}
				if (fos != null) {
					fos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
