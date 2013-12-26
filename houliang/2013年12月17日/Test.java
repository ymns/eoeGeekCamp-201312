package com.eoe.myjava.xml;

import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		String path="http://10.0.0.60/NewFile.xml";
		InputStream inputStream=HttpUtil.getXML(path);
		try {
		List<HashMap<String, String>> list=SaxService.readXML(inputStream, "persons");
		for(HashMap<String, String> map:list){
			System.out.println(map);
		}
		System.out.println(list.size());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
