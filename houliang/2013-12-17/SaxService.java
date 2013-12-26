package com.eoe.myjava.xml;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class SaxService {

	
	public static List<HashMap<String, String>>readXML(InputStream inputStream,String nodeName){
		List<HashMap<String, String>> list=null;
		
		try {
			//创建一个解析XML的工厂对象
			SAXParserFactory spf=SAXParserFactory.newInstance();
			SAXParser parser=spf.newSAXParser();//定义一个解析器
			MyHandler handler=new MyHandler(nodeName);
			parser.parse(inputStream, handler);
			inputStream.close();
			return handler.getList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
		
	}

}
