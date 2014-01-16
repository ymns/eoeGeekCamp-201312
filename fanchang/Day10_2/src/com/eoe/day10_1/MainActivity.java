package com.eoe.day10_1;

import com.eoe.day10_1.entity.User;
import com.ityw.day08_01.R;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;
import android.app.Activity;

/**
 * 实现注册功能,采用内部类的方式实现接口
 */
public class MainActivity extends Activity {
	// 声明用于输入姓名、密码、确认密码的编辑框的引用变量
	EditText metUserName, metPwd, metFirmPwd;
	Spinner mspinCity;// 所在城市 下拉框
	CheckBox mchkReadBook, mchkTour, mchkGame;// 用于爱好的控件用因变量
	RadioButton mrdMale, mrdFemale;// 用于选择性别的控件的引用变量
	Button mbtnRegister, mbtnExit;// 同于注册按钮和退出按钮

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();// 初始化控件
	}
	//创建内部类Mylistener,继承接口OnClickListener
	private class Mylistener implements OnClickListener{
		//按钮被点击,调用onClick()
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.btnExit://若是退出按钮的id
				finish();//关闭当前的Activity
				break;
			case R.id.btnRegister://若是注册按钮的id
				String userName = metUserName.getText().toString();
				if (userName.length() == 0) {
					metUserName.setError("用户名不能为空");
					return;
				}
				String pwd = metPwd.getText().toString();
				if (pwd.length() == 0) {
					metPwd.setError("密码不能为空");
					return;
				}
				String firmPwd = metFirmPwd.getText().toString();
				if (firmPwd.length() == 0) {
					metFirmPwd.setError("确认密码不能为空");
					return;
				}
				if (!pwd.equals(firmPwd)) {
					metFirmPwd.setError("密码不一致");
					return;
				}
				char sex;
				if (mrdFemale.isChecked()) {
					sex = mrdFemale.getText().toString().charAt(0);
				} else {
					sex = mrdMale.getText().toString().charAt(0);
				}
				StringBuilder hobby = new StringBuilder("爱好:");
				if (mchkGame.isChecked()) {
					hobby.append(mchkGame.getText().toString());
				}
				if (mchkReadBook.isChecked()) {
					hobby.append(",").append(mchkReadBook.getText().toString());
				}
				if (mchkTour.isChecked()) {
					hobby.append(",").append(mchkTour.getText().toString());
				}
				String city = mspinCity.getSelectedItem().toString();
				//创建注册用户对象
				User user= new User(userName, firmPwd, sex, city, hobby.toString());
				Log.i("main", user.toString());//在日志窗口显示注册用户信息
				//在窗口显示注册用户信息
				Toast.makeText(MainActivity.this, "注册成功，" + user.toString(), Toast.LENGTH_LONG).show();
				break;
			}
		}
		
	}

	// 初始化控件
	private void initView() {
		// 通过查找XML中定义的控件，创建用于输入姓名的编辑框对象
		metUserName = (EditText) findViewById(R.id.etUserName);
		metPwd = (EditText) findViewById(R.id.etPwd);
		metFirmPwd = (EditText) findViewById(R.id.etFirmPwd);
		mrdFemale = (RadioButton) findViewById(R.id.rdFemale);
		mrdMale = (RadioButton) findViewById(R.id.rdMale);
		mchkGame = (CheckBox) findViewById(R.id.chkGame);
		mchkReadBook = (CheckBox) findViewById(R.id.chkReadBook);
		mchkTour = (CheckBox) findViewById(R.id.chkTour);
		mspinCity = (Spinner) findViewById(R.id.spinCity);
		mbtnRegister = (Button) findViewById(R.id.btnRegister);
		mbtnExit = (Button) findViewById(R.id.btnExit);
		Mylistener listener=new Mylistener();      //创建监听对象listener
		mbtnExit.setOnClickListener(listener);     // 设置退出监听
		mbtnRegister.setOnClickListener(listener); //设置注册监听
	}

}
