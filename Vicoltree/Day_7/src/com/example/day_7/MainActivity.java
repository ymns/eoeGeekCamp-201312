package com.example.day_7;

import android.os.Bundle;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends Activity {

	TextView dateTV, timeTV;
	private OnClickListener btnClickListener = new OnClickListener() {

		@Override
		public void onClick(View arg0) {

			switch (arg0.getId()) {
			case R.id.modificationDateBtn:
				showDateDialog();

				break;

			case R.id.modificationTimeBtn:
				showTimeDialog();
				break;
			}

		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		dateTV=(TextView) findViewById(R.id.dateTv);
		timeTV = (TextView) findViewById(R.id.timeTV);
		
		findViewById(R.id.modificationDateBtn).setOnClickListener(
				btnClickListener);
		findViewById(R.id.modificationTimeBtn).setOnClickListener(
				btnClickListener);

	}

	protected void showTimeDialog() {
		new TimePickerDialog(MainActivity.this, new OnTimeSetListener() {

			@Override
			public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

				timeTV.setText(hourOfDay + ":" + minute);

			}
		}, 20, 22, true).show();

	}

	protected void showDateDialog() {
		new DatePickerDialog(MainActivity.this, new OnDateSetListener() {

			@Override
			public void onDateSet(DatePicker view, int year, int monthOfYear,
					int dayOfMonth) {

				dateTV.setText(year + "-" + (monthOfYear + 1) + "-"
						+ dayOfMonth);

			}
		}, 2013, 0, 11).show();

	}

}
