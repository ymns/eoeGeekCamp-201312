package com.eoe.day11_1;

import java.util.ArrayList;

import com.eoe.day11_1.entity.GeneralInfo;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
	// 创建一个集合
	ArrayList<GeneralInfo> mGeneral;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();// 初始化
		// 获得listview的id
		ListView lvGeneral = (ListView) findViewById(R.id.lvGeneral);
		// 创建适配器对象
		GeneralAdapter adapter = new GeneralAdapter();
		// 调用
		lvGeneral.setAdapter(adapter);
	}

	private void initView() {
		mGeneral = new ArrayList<GeneralInfo>();
		GeneralInfo general = new GeneralInfo("白起", R.drawable.baiqi);
		mGeneral.add(general);

		general = new GeneralInfo("曹操", R.drawable.caocao);
		mGeneral.add(general);

		general = new GeneralInfo("成吉思汗", R.drawable.chengjisihan);
		mGeneral.add(general);

		general = new GeneralInfo("韩信", R.drawable.hanxin);
		mGeneral.add(general);

		general = new GeneralInfo("李世民", R.drawable.lishimin);
		mGeneral.add(general);

		general = new GeneralInfo("努尔哈赤", R.drawable.nuerhachi);
		mGeneral.add(general);

		general = new GeneralInfo("孙膑", R.drawable.sunbin);
		mGeneral.add(general);

		general = new GeneralInfo("孙武", R.drawable.sunwu);
		mGeneral.add(general);

		general = new GeneralInfo("岳飞", R.drawable.yuefei);
		mGeneral.add(general);

		general = new GeneralInfo("朱元璋", R.drawable.zhuyuanzhang);
		mGeneral.add(general);

	}

	// 创建一个GeneralAdapter类
	class GeneralAdapter extends BaseAdapter {

		@Override
		public int getCount() { // 返回集合长度
			return mGeneral.size();
		}

		@Override
		public Object getItem(int position) { // 返回这个索引值的对象
			// TODO Auto-generated method stub
			return mGeneral.get(position);
		}

		@Override
		public long getItemId(int position) { // 返回索引值
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			View layout = View.inflate(MainActivity.this,
					R.layout.general_item, null);
			// 获取图片id
			ImageView ivGeneral = (ImageView) layout
					.findViewById(R.id.ivGeneral);
			// 获取文字id
			TextView tvGeneral = (TextView) layout.findViewById(R.id.tvGeneral);

			GeneralInfo general = mGeneral.get(position);
			ivGeneral.setImageResource(general.getPhotold());
			tvGeneral.setText(general.getName());

			return layout;
		}

	}

}
