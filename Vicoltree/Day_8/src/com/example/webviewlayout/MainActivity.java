package com.example.webviewlayout;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	WebView webView;

	EditText editText;

	Button button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.action_layout);

		webView = (WebView) findViewById(R.id.webView);
		editText = (EditText) findViewById(R.id.addressInputEd);
		button = (Button) findViewById(R.id.sureBtn);
//		webView.loadUrl("http://www.baidu.com");
		button.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				getByInputToWeb();

			}
		});
	}

	protected void getByInputToWeb() {
		String str = editText.getText().toString();
		if (str != null) {
			webView.loadUrl(str);
		}
	}

}
