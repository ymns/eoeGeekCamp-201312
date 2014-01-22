package com.eoe.day14_1;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	//标准对话框按钮的点击事件响应
	public void standarDiaglog(View v){
		AlertDialog.Builder builder=new AlertDialog.Builder(this);
		builder.setIcon(R.drawable.ic_launcher);
		builder.setTitle("标准对话框");
		builder.setMessage("亲,俺是个标准对话框");
		builder.setPositiveButton("返回",new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
					finish();	
			}
		});
		AlertDialog dialog=builder.create();
		dialog.show();
	}
	//列表对话框
	public void listDialog(View v){
		AlertDialog.Builder builder =new AlertDialog.Builder(this);
		builder.setIcon(R.drawable.ic_launcher);
		builder.setTitle("列表对话框");
		final String [] item =new String[]{"星期一","星期二","星期三","星期四"
				,"星期五","星期六","星期日",};
		builder.setItems(item, new OnClickListener() {	
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(MainActivity.this, "被选中", 3000).show();		
			}
		});
		//builder.show();//可以直接创建并显示对话框
		AlertDialog dialog=builder.create();
		dialog.show();
	}
	//自定义对话框
	public void customDialog(View v){
		View layout =View.inflate(this, R.layout.result, null);
		Button btnOk=(Button) layout.findViewById(R.id.btnOk);
		btnOk.setOnClickListener(new android.view.View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();	
			}
		}); 
		AlertDialog.Builder builder =new AlertDialog.Builder(this);
		builder.setIcon(R.drawable.ic_launcher);
		builder.setTitle("自定义对话框");
		builder.setView(layout);
		final AlertDialog dialog=builder.create();
		dialog.show();
		Button btnCancel=(Button) layout.findViewById(R.id.btnCancel);
		btnCancel.setOnClickListener(new android.view.View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				dialog.dismiss();
			}
		}); 
	}

}
