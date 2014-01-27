package com.eoe.computer;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends BaseActivity {
	// 声明变量
	Button mbtnNum0, mbtnNum1, mbtnNum2, mbtnNum3, mbtnNum4, mbtnNum5,
			mbtnNum6, mbtnNum7, mbtnNum8, mbtnNum9;
	Button mbtnAdd, mbtnDiv, mbtnDot, mbtnSub, mbtnMult, mbtEqual, mbtnSquare,
			mbtnSqrt, mbtnFoct, mbtnSign, mbtnDel, mbtnClear,
			mbtnMOD, mbtnEqual;
	EditText metShow;
	double num1;
	double num2;
	double temp;
	double result;
	char c;
	static StringBuilder s = new StringBuilder();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init(); // 初始化

	}

	private void init() {
		// 找到控件的id
		mbtnNum0 = findViewById_(R.id.btnNum0);
		mbtnNum1 = findViewById_(R.id.btnNum1);
		mbtnNum2 = findViewById_(R.id.btnNum2);
		mbtnNum3 = findViewById_(R.id.btnNum3);
		mbtnNum4 = findViewById_(R.id.btnNum4);
		mbtnNum5 = findViewById_(R.id.btnNum5);
		mbtnNum6 = findViewById_(R.id.btnNum6);
		mbtnNum7 = findViewById_(R.id.btnNum7);
		mbtnNum8 = findViewById_(R.id.btnNum8);
		mbtnNum9 = findViewById_(R.id.btnNum9);
		mbtnAdd = findViewById_(R.id.btnAdd);
		mbtnSub = findViewById_(R.id.btnSub);
		mbtnMult = findViewById_(R.id.btnMult);
		mbtnMOD = findViewById_(R.id.btnMOD);
		mbtnEqual = findViewById_(R.id.btnEqual);
		mbtnDiv = findViewById_(R.id.btnDiv);
		metShow = findViewById_(R.id.etShow);
		mbtnDel = findViewById_(R.id.btnDel);
		mbtnClear = findViewById_(R.id.btnClear);
		mbtnDot = findViewById_(R.id.btnDot);
		mbtnSqrt = findViewById_(R.id.btnSqrt);
		mbtnSquare = findViewById_(R.id.btnSquare);
		mbtnFoct= findViewById_(R.id.btnFoct);
		mbtnSign= findViewById_(R.id.btnSign);

		mbtnNum0.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				s.append("0");
				metShow.setText(s.toString());

			}
		});
		mbtnNum1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				s.append("1");
				metShow.setText(s.toString());

			}
		});
		mbtnNum2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				s.append("2");
				metShow.setText(s.toString());

			}
		});
		mbtnNum3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				s.append("3");
				metShow.setText(s.toString());

			}
		});
		mbtnNum4.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				s.append("4");
				metShow.setText(s);

			}
		});
		mbtnNum5.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				s.append("5");
				metShow.setText(s);

			}
		});
		mbtnNum6.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				s.append("6");
				metShow.setText(s.toString());

			}
		});
		mbtnNum7.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				s.append("7");
				metShow.setText(s.toString());

			}
		});
		mbtnNum8.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				s.append("8");
				metShow.setText(s.toString());

			}
		});
		mbtnNum9.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				s.append("9");
				metShow.setText(s.toString());

			}
		});
		mbtnAdd.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				c = '+';
				s.delete(0, s.length()); // 清除
				s.append(metShow.getText().toString()); // 获取当前editText的文本,也就是加之前的数
				num1 = Double.parseDouble(s.toString()); // 存入数1
				metShow.setText(""); // 清除文本框
				s.delete(0, s.length());
			}
			
		});
		mbtnEqual.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				s.delete(0, s.length());
				s.append(metShow.getText().toString()); // 获取当前editText的文本,也就是符号之前等号之后
				num2 = Double.parseDouble(s.toString()); // 存入数2
				metShow.setText(""); // 清除文本框
				s.delete(0, s.length());
				operation();

			}

			private double pround(double n) {
				temp = Math.round(n * 100000000) / 100000000d;
				return temp;

			}

			private void operation() {
				switch (c) {
				case '+':
					result=num1+num2;
					metShow.setText(pround(result) + "");
					break;
				case '-':
					metShow.setText(pround(num1 - num2) + "");
					break;
				case '*':
					metShow.setText(pround(num1 * num2) + "");
					break;
				case '/':
					try {
						temp=num1/num2;
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					metShow.setText(pround(temp) + "");
					break;
				case '%':
					metShow.setText(num1 % num2 + "");
					break;

				}
			}
		});
		mbtnSub.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				c = '-';
				s.delete(0, s.length()); // 清除
				s.append(metShow.getText().toString()); // 获取当前editText的文本
				num1 = Double.parseDouble(s.toString()); // 存入数1
				metShow.setText(""); // 清除文本框
				s.delete(0, s.length());
			}
		});
		mbtnMOD.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				c = '%';
				s.delete(0, s.length()); // 清除
				s.append(metShow.getText().toString()); // 获取当前editText的文本
				num1 = Double.parseDouble(s.toString()); // 存入数1
				metShow.setText(""); // 清除文本框
				s.delete(0, s.length());
			}
		});
		mbtnMult.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				c = '*';
				s.delete(0, s.length()); // 清除
				s.append(metShow.getText().toString()); // 获取当前editText的文本
				num1 = Double.parseDouble(s.toString()); // 存入数1
				metShow.setText(""); // 清除文本框
				s.delete(0, s.length());

			}
		});
		mbtnDiv.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				c = '/';
				s.delete(0, s.length()); // 清除
				s.append(metShow.getText().toString()); // 获取当前editText的文本
				num1 = Double.parseDouble(s.toString()); // 存入数1
				metShow.setText(""); // 清除文本框
				s.delete(0, s.length());
			}
		});
		mbtnDel.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				s.delete(0, s.length());
				s.append(metShow.getText().toString()); // 获取当前editText的文本,也就是加之前的数
				if (s.length() > 0) {
					s.deleteCharAt(s.length() - 1);
				}
				metShow.setText(s.toString());
			}
		});
		mbtnClear.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				s.delete(0, s.length());
				metShow.setText(s.toString());
			}
		});
		mbtnSqrt.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				s.delete(0, s.length());
				s.append(metShow.getText().toString());
				temp = Double.parseDouble(s.toString());
				temp = (Math.round(Math.sqrt(temp) * 100000000)) / 100000000d;
				metShow.setText(temp + "");
				s.delete(0, s.length());
			}
			

		});
		mbtnSquare.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				s.delete(0, s.length());
				s.append(metShow.getText().toString());
				temp = Double.parseDouble(s.toString());
				temp*=temp;
				metShow.setText(temp + "");
				s.delete(0, s.length());
			}
		});
		mbtnDot.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				s.append(".");
				metShow.setText(s.toString());
			}
		});
		mbtnFoct.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				s.delete(0, s.length());
				s.append(metShow.getText().toString());
				temp = Double.parseDouble(s.toString());
				temp=fact(temp);
				metShow.setText(temp + "");
				s.delete(0, s.length());
				
			}

			private double fact(double  n) {
				if (n==1) {
					return 1;
				}
				return n*fact(n-1);
			}
		});
		mbtnSign.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				s.delete(0, s.length());
				s.append(metShow.getText().toString());
				temp = Double.parseDouble(s.toString());
				if (temp>0) {					
					metShow.setText("-"+temp);
				}else{
					metShow.setText(Math.abs(temp)+"");
				}
				s.delete(0, s.length());
			}
		});

	}

}
