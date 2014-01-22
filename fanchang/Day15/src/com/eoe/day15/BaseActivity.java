package com.eoe.day15;

import android.app.Activity;

public class BaseActivity extends Activity{

	public <T>T findViewById_(int id){
		return (T) findViewById(id);	
	}

}
