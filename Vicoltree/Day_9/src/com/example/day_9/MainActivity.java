package com.example.day_9;

import android.os.Bundle;
import android.app.Activity;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView textView;

	ImageView imageView = null;
	PopupWindow popupWindow = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		textView = (TextView) findViewById(R.id.tvId);
		textView.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {

				if (getPopupWindow().isShowing()) {
					popupWindow.dismiss();
				} else {

					getPopupWindow().showAtLocation(textView,
							Gravity.TOP | Gravity.LEFT, 30, 150);

				}
			}
		});
	}

	private PopupWindow getPopupWindow() {
		if (popupWindow == null) {
			popupWindow = new PopupWindow(getImageView(), 100, 100);
		}
		return popupWindow;

	}

	private ImageView getImageView() {
		if (imageView == null) {
			imageView = new ImageView(this);
			imageView.setImageResource(R.drawable.ic_launcher);
		}
		return imageView;
	}

}
