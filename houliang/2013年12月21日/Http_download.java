package com.study.download;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Http_download {
	public static void main(String[] args) {
		InputStream in = null;
		BufferedReader reader = null;
		File file = new File("d:/Http_download1.java");
		FileOutputStream fos = null;
		try {
			URL url = new URL("http://news.baidu.com/");
			GetHttpInputStream getHttpInputStream = new GetHttpInputStream(url);
			in = getHttpInputStream.getInputStream();
			reader = new BufferedReader(new InputStreamReader(in, "utf-8"));
			fos = new FileOutputStream(file);
			byte[] buf = new byte[1024];
			String read = "";
			int len;
//			while ((read = reader.readLine()) != null) {
//				System.out.println(read);
//			}
//			while ((len = in.read(buf)) != -1) {
//				read = new String(buf, 0, len);
//				System.out.println(read);
//			}
			while ((len = in.read(buf)) != -1) {
				fos.write(buf, 0, len);
			//	System.out.println(len);
			}
			System.out.println("下载成功!");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("读取文件失败");
		}

	}
}
