package com.eoe.se2.day08;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class HttpTest01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedReader reader = null;
		PrintStream writer = null;
		try {
			URL url = new URL("http://127.0.0.1:80/user.txt");
			URLConnection connection = url.openConnection();
			InputStream in = connection.getInputStream();
			reader = new BufferedReader(new InputStreamReader(in, "gbk"));
			File dir = new File("d:/java_test/se2_day08/");
			if (!dir.exists()) {
				dir.mkdirs();
			}
			File file = new File(dir, "user.txt");
			writer = new PrintStream(file);
			if (!file.exists()) {
				file.createNewFile();
			}
			String line;
			while ((line = reader.readLine()) != null) {
				writer.println(line);
			}
			System.out.println("下载完成");
		} catch (MalformedURLException e) {
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
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
