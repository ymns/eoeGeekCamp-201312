package com.eoe.elts.activity;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import com.eoe.elts.R;
import com.eoe.elts.biz.ExamBiz;
import com.eoe.elts.biz.IExamBiz;
import com.eoe.elts.entity.ExamInfo;
import com.eoe.elts.entity.Question;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class ExamActivity extends Activity {
	IExamBiz examBiz;
	TextView mtvExamInfo;//显示考卷头信息的控件
	EditText metQuestion;//显示当前考题的控件
	CheckBox[] mchkOptions;//四个复选框控件
	TextView mtvLeftTime;//显示剩余时间的控件
	int mqid;//当前考题的索引
	ExamInfo examInfo;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.exam);
		Intent intent=getIntent();
		examBiz=(ExamBiz) intent.getSerializableExtra("exambiz");
		initView();//初始化控件
		beginExam();//开始考试
		startTime();//开始倒计时
	}
	private void startTime() {
		final Timer timer=new Timer();
		//获取开始考试的时间
		long start=System.currentTimeMillis();
		//long limitTime=examInfo.getLimitTime()*60*1000; 
		long limitTime=60*1000;
		//结束的时间，单位：毫秒
		final long end=start+limitTime;
		timer.schedule(new TimerTask() {
			long minute,second;
			@Override
			public void run() {
				long leftTime=end-System.currentTimeMillis();
				minute=leftTime/1000/60;
				second=leftTime/1000%60;
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						mtvLeftTime.setText("剩余时间:"+minute+":"+second);
					}
				});
			}
		}, 0,1000);
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						commit_();//交卷
					}
				});
				timer.cancel();
			}
		}, limitTime);
	}
	//开始考试
	private void beginExam() {
		//开始考试
		examInfo=examBiz.beginExam();
		//显示考卷头信息
		mtvExamInfo.setText(examInfo.toString());
		// 显示第一道考题
		metQuestion.setText(examBiz.getQuestion(mqid).toString());
		
	}
	//初始化控件
	private void initView() {
		mtvExamInfo=(TextView) findViewById(R.id.tvExamInfo);
		mtvLeftTime=(TextView) findViewById(R.id.tvLeftTime);
		metQuestion=(EditText) findViewById(R.id.etQuestion);
		mchkOptions=new CheckBox[4];
		mchkOptions[0]=(CheckBox) findViewById(R.id.chkA);
		mchkOptions[1]=(CheckBox) findViewById(R.id.chkB);
		mchkOptions[2]=(CheckBox) findViewById(R.id.chkC);
		mchkOptions[3]=(CheckBox) findViewById(R.id.chkD);
		
	}
	//上一题按钮的点击事件响应
	public void previous(View v){
		//保存当前考题的选择答案
		examBiz.saveUserAnswers(mqid, getUserAnswers());
		if(mqid>0){
			mqid--;
		}
		//显示新的考题和该考题的选择答案
		refreshView();
	}
	//显示新的考题和该考题的选择答案
	private void refreshView() {
		Question question=examBiz.getQuestion(mqid);
		//显示新的考题
		metQuestion.setText(question.toString());
		//清空四个复选框
		for(CheckBox chk:mchkOptions){
			chk.setChecked(false);
		}
		//取出考生选择的答案
		ArrayList<String> userAnswers=question.getUserAnswers();
		//显示新考题中选择过的答案
		for(String answer:userAnswers){
			//answer:A,B,C,D
			//       0,1,2,3
			char c=answer.charAt(0);
			mchkOptions[c-65].setChecked(true);
		}
	}
	//从四个复选框中取出打钩的答案
	private ArrayList<String> getUserAnswers() {
		//存放用户选择的答案的集合
		ArrayList<String> userAnswers=new ArrayList<String>();
		for(CheckBox chk:mchkOptions){
			if(chk.isChecked()){
				String text=chk.getText().toString();
				userAnswers.add(text);
			}
		}
		return userAnswers;
	}
	//下一题按钮的点击事件响应
	public void next(View v){
		examBiz.saveUserAnswers(mqid, getUserAnswers());
		if(mqid<examInfo.getQuestionCount()-1){
			mqid++;
		}
		refreshView();
	}
	//交卷按钮点击事件响应
	public void commit(View v){
		examBiz.saveUserAnswers(mqid, getUserAnswers());
		commit_();
	}
	void commit_(){
		AlertDialog.Builder builder=new AlertDialog.Builder(this);
		//设置对话框的一些属性值
		builder.setTitle("交卷");
		builder.setIcon(R.drawable.exam_commit32x32);
		builder.setMessage("您的考试成绩："+examBiz.over()+"分");
		builder.setPositiveButton("返回", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				finish();//关闭考试窗口
			}
		});
		//创建对话框
		AlertDialog dialog=builder.create();
		dialog.show();//显示对话框
	}
}
