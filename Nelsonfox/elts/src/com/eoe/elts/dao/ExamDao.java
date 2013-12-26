package com.eoe.elts.dao;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.eoe.elts.biz.IExamBiz;
import com.eoe.elts.entity.ExamInfo;
import com.eoe.elts.entity.Question;
import com.eoe.elts.entity.User;

public class ExamDao implements IExamDao, Serializable {
	ArrayList<Question> questions;
	ArrayList<User> users;
	ExamInfo examInfo;
	public ExamDao() {
		questions=new ArrayList<Question>();
		users=new ArrayList<User>();
		loadUsers();//从服务端下载注册用户文件-users.xml
	}
	//从服务端下载注册用户文件-users.xml
	private void loadUsers() {
		//步骤1、创建指向服务端users.xml文件的URL对象
		try {
			URL url=new URL(IExamDao.url+IExamDao.USER_FILE);
			//步骤2、创建URLConnection对象
			URLConnection connection=url.openConnection();
			//步骤3、获取输入流
			InputStream in=connection.getInputStream();
			byte[] buffer=new byte[1024];
			//步骤4、从输入流中读取数据，byte[]类型
			int len=in.read(buffer);
			String content=new String(buffer, "utf-8");
			JSONArray jsons=new JSONArray(content);
			for(int i=0;i<jsons.length();i++){
				User user=new User();
				JSONObject json=jsons.getJSONObject(i);
				user.setId(json.getInt("id"));
				user.setName(json.getString("name"));
				user.setPassword(json.getString("password"));
				user.setPhone(json.getString("phone"));
				user.setEmail(json.getString("email"));
				users.add(user);
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public ArrayList<Question> getQuestions() {

		return questions;
	}

	@Override
	public ExamInfo getExamInfo() {
		// TODO Auto-generated method stub
		return examInfo;
	}

	@Override
	public User findUser(int uid) {
		for(User user:users){
			if(user.getId()==uid){
				return user;
			}
		}
		return null;
	}

	@Override
	public void loadQuestions() {
		InputStream in=null;
		try {
			URL url=new URL(IExamDao.url+
				IExamDao.QUESTION_FILE);
			URLConnection connection=url.openConnection();
			in=connection.getInputStream();
			byte[] buffer=new byte[6*1024];
			int len=in.read(buffer);
			String content=new String(buffer, "utf-8");
			JSONArray jsons=new JSONArray(content);
			Question q;
			for(int i=0;i<jsons.length();i++){
				q=new Question();
				//从json数组中取出json对象
				JSONObject json=jsons.getJSONObject(i);
				//取出标准答案
				String answer=json.getString("answer");
				//存放到集合中
				ArrayList<String> answers=new ArrayList<String>();
				for(int j=0;j<answer.length();j++){
					answers.add(""+answer.charAt(j));
				}
				q.setAnswers(answers);
				q.setScore(json.getInt("score"));
				q.setLevel(json.getInt("level"));
				q.setTitle(json.getString("title"));
				String options=json.getString("optiona")+"\n";
				options+=json.getString("optionb")+"\n";
				options+=json.getString("optionc")+"\n";
				options+=json.getString("optiond");
				q.setOptions(options);
				questions.add(q);//添加至考题集合中
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(in!=null){
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
	}

	@Override
	public void loadExamInfo() {
		examInfo=new ExamInfo();
		examInfo.setLimitTime(10);
		examInfo.setQuestionCount(20);
		examInfo.setSubjectTitle("core java");
	}



}
