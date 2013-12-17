package com.eoe.myjava.xml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyHandler extends DefaultHandler {
	private HashMap<String, String> map = null;// 存储单个解析的完整对象
	private List<HashMap<String, String>> list = null;// 存取所有解析对象
	private String currentTag = null;// 正在解析的元素的标签
	private String currentValues = null;// 正在解析的元素的值
	private String nodeName = null;// 当前节点的名称

	public List<HashMap<String, String>> getList() {
		return list;
	}

	public MyHandler(String nodeName) {
		super();
		this.nodeName = nodeName;
	}

	@Override
	public void startDocument() throws SAXException {
		// 当解析到第一个开始标签的时候会触发这个方法
		list = new ArrayList<HashMap<String, String>>();
	}

	@Override
	public void startElement(String uri, String localName, String qName,Attributes attributes) throws SAXException {
		// 当解析到开始元素的时候会触发这个方法
		if (qName.equals(nodeName)) {
			map = new HashMap<String, String>();
		}
		if (attributes != null && map != null) {
			for (int i = 0; i < attributes.getLength(); i++) {
				map.put(attributes.getQName(i), attributes.getValue(i));
			}
		}
		currentTag = qName;
	}

	// 当解析到文档内容的时候会触发这个方法
	@Override
	// 处理xml文件所读取到的内容
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		if (currentTag != null && map != null) {
			currentValues = new String(ch, start, length);
			if (currentValues != null && !currentValues.trim().equals("")
					&& !currentValues.trim().equals("\n")) {

			map.put(currentTag, currentValues);
			}

		}
		currentValues=null;
		currentTag=null;
	}

	// 整个文本解析完成时候会触发这个方法
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if(qName.equals(nodeName)){
			list.add(map);
		}
		map=null;
		super.endElement(uri, localName, qName);
	}

}
