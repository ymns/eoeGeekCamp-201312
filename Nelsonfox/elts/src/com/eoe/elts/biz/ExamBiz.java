package com.eoe.elts.biz;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import com.eoe.elts.dao.ExamDao;
import com.eoe.elts.dao.IExamDao;
import com.eoe.elts.entity.ExamInfo;
import com.eoe.elts.entity.Question;
import com.eoe.elts.entity.User;

public class ExamBiz implements IExamBiz,Serializable {
	ArrayList<Question> questions;//所有考题
	User loginUser;//当前登录的考生
	IExamDao examDao;//数据访问层的对象
	ExamInfo examInfo;
	//业务逻辑的构造器
	public ExamBiz() {
		//创建数据访问层的对象
		examDao=new ExamDao();
	}
	@Override
	public void login(int uid, String pwd) throws Exception {
		User user=examDao.findUser(uid);
		if(user==null){
			throw new Exception("请先注册");
		}
		if(!user.getPassword().equals(pwd)){
			throw new Exception("密码错误");
		}
		loginUser=user;
	}

	@Override
	public void loadQuestions() {
		//调用数据访问层的同名方法下载考题
		examDao.loadQuestions();
	}

	@Override
	public ExamInfo beginExam() {
		examDao.loadExamInfo();//下载考卷信息
		//从数据访问层取出下载的考题集合
		questions=examDao.getQuestions();
		Collections.shuffle(questions, new Random());
		for(int i=0;i<questions.size();i++){
			Question q=questions.get(i);
			String title=q.getTitle();
			int index=title.indexOf(".");
			title=(i+1)+title.substring(index);
			q.setTitle(title);
		}
		examInfo=examDao.getExamInfo();
		//设置examInfo.user的值为登陆成功者对象
		examInfo.setUser(loginUser);
		return examInfo;
	}

	@Override
	public Question getQuestion(int qid) {
		// TODO Auto-generated method stub
		return questions.get(qid);
	}

	@Override
	
	public void saveUserAnswers(int qid, ArrayList<String> userAnswers) {
		questions.get(qid).setUserAnswers(userAnswers);

	}

	@Override
	public int over() {
		int score=0;//保存总分
		for(int i=0;i<questions.size();i++){
			//取出一道考题
			Question question=questions.get(i);
			ArrayList<String> answers=question.getAnswers();
			Collections.sort(answers);
			ArrayList<String> userAnswers=question.getUserAnswers();
			Collections.sort(userAnswers);
			if(answers.equals(userAnswers)){
				score+=question.getScore();
			}
		}
		return score;
	}

	@Override
	public User getUser() {
		// TODO Auto-generated method stub
		return loginUser;
	}

}
