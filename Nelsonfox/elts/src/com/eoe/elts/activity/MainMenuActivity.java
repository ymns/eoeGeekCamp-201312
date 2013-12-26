package com.eoe.elts.activity;

import java.io.Serializable;

import com.eoe.elts.R;
import com.eoe.elts.biz.IExamBiz;
import com.eoe.elts.entity.User;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainMenuActivity extends Activity {
	IExamBiz examBiz;
	TextView mtvWelcome;
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		// 设置主菜单窗口的显示页面
		setContentView(R.layout.main_menu);
		//从上一个Activity中取出Intent对象
		Intent intent=getIntent();
		examBiz=(IExamBiz) intent.getSerializableExtra("exambiz");
		mtvWelcome=(TextView) findViewById(R.id.tvWelcome);
		//取出登陆成功者对象
		User user=examBiz.getUser();
		mtvWelcome.setText("欢迎"+user.getName()+"参加考试");
	}
	public void beginExam(View v){
		Thread t=new Thread(){
			@Override
			public void run() {
				examBiz.loadQuestions();//下载考题
			}
		};
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Intent intent=new Intent(this, ExamActivity.class);
		intent.putExtra("exambiz", (Serializable)examBiz);
		startActivity(intent);
	}
	public void exit(View v){
		finish();
	}
}
