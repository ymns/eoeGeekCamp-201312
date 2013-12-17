package com.http;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Test02 {

	
	public static void main(String[] args) {
		Map<String,String> map=new HashMap<String, String>();
		map.put("name", "ÕÅÈı");
		map.put("pwd", "123");
		map.put("sex", "ÄĞ");
		for (Map.Entry<String,String> entry:map.entrySet()) {
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
		for(String key:map.keySet()){
			System.out.println(key+":"+map.get(key));
		}
		for(String v:map.values()){
			System.out.println(v);
		}
		
	}

}
