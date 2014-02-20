package com.eoe.se2.day13.activity;

import com.eoe.se2.day13.view.Button;
import com.eoe.se2.day13.view.EditText;
import com.eoe.se2.day13.view.LinearLayout;
import com.eoe.se2.day13.view.TextView;
import com.eoe.se2.day13.view.View;

public class Factory {

	public static <T extends View> T getInstance(String className) {
		T view = null;
		switch (className) {
		case "LinearLyout":
			view = (T) new LinearLayout();
			break;
		case "TextView":
			view = (T) new TextView();
			break;
		case "EditText":
			view = (T) new EditText();
			break;
		case "Button":
			view = (T) new Button();
			break;
		}
		return (T) view;

	}
}
