package com.http;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Test01 {

	public static void main(String[] args) {
		String URL_PATH="http://10.0.0.60/psb.jpg";
		String dest="d:/psb.jpg";
		File file=new File(dest);
		InputStream in=null;
		FileOutputStream fos=null;
		try {
			URL url=new URL(URL_PATH);
			if(url!=null){
				URLConnection connection=url.openConnection();
				 in=connection.getInputStream();
				 fos=new FileOutputStream(file);
				int len;
				byte[] buf=new byte[1024];
				while((len=in.read(buf))!=-1){
					fos.write(buf, 0, len);
				}
				System.out.println("œ¬‘ÿ≥…π¶£°");
			}
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(in!=null){
					in.close();
				}if(fos!=null){
					fos.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

}
