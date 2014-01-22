package com.eoe.day13_1;

import java.util.ArrayList;
import java.util.List;
import android.os.Bundle;
import android.app.Activity;
import android.content.res.Resources;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemLongClickListener;

public class MainActivity extends BaseActivity implements
		OnItemLongClickListener {

	List<GeneralInfo> mGeneral;
	GridView mgvGeneral;
	GeneralAdapter mAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initGeneral();// 初始化10个军事家的数据
		initView(); // 初始化View
	}

	private void initView() {
		mgvGeneral = findViewById_(R.id.gvGeneral);
		mgvGeneral.setOnItemLongClickListener(this);
		mAdapter = new GeneralAdapter();
		mgvGeneral.setAdapter(mAdapter);
	}

	private void initGeneral() {
		// 获取代表资源的对象
		Resources res = getResources();
		String[] names = res.getStringArray(R.array.general);// 调用String-array里的general
		int[] photoId = { R.drawable.baiqi, R.drawable.caocao,
				R.drawable.chengjisihan, R.drawable.hanxin,
				R.drawable.lishimin, R.drawable.nuerhachi, R.drawable.sunbin,
				R.drawable.sunwu, R.drawable.yuefei, R.drawable.zhuyuanzhang };
		mGeneral = new ArrayList<GeneralInfo>();
		GeneralInfo general;
		for (int i = 0; i < photoId.length; i++) {
			// 创建一个代表军事家的对象
			general = new GeneralInfo();
			// 设置该军事家的数据
			general.setPhotoId(photoId[i]);
			general.setName(names[i]);
			// 添加至集合中
			mGeneral.add(general);
		}

	}

	// 适配器的编写
	class GeneralAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			return mGeneral.size();
		}

		@Override
		public Object getItem(int position) {
			return null;
		}

		@Override
		public long getItemId(int position) {
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// 步骤1、获取代表某个列表项的布局对象
			View layout = View.inflate(MainActivity.this,
					R.layout.general_item, null);
			// 步骤2、从布局中获取显示军事家头像的控件
			ImageView ivGeneral = (ImageView) layout
					.findViewById(R.id.ivGeneral);
			// 步骤3、从布局中获取获取显示军事家姓名的控件
			TextView tvGeneral = (TextView) layout.findViewById(R.id.tvGeneral);
			// 从集合中获取当前军事家的对象
			GeneralInfo general = mGeneral.get(position);
			// 显示军事家的头像
			ivGeneral.setImageResource(general.getPhotoId());
			// 显示军事家的姓名
			tvGeneral.setText(general.getName());
			return layout;
		}

	}
    //需要继承OnItemLongClickListener
	@Override
	public boolean onItemLongClick(AdapterView<?> parent, View layout,
			int position, long id) {
		GeneralInfo general = mGeneral.get(position);
		Toast.makeText(this, general.getName() + "被选择", Toast.LENGTH_LONG)
				.show();
		return true;
	}

}
