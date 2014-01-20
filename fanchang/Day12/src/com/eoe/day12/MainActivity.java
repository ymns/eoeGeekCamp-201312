package com.eoe.day12;

import java.util.ArrayList;
import java.util.HashMap;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class MainActivity extends BaseActivity implements OnItemClickListener,
		OnItemLongClickListener {

	// 声明变量
	static final String PHOTO_KEY = "photoid";
	static final String NAME_KEY = "name";
	ListView mlvGeneral;
	SimpleAdapter mAdapter;
	ArrayList<HashMap<String, Object>> mGeneral;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initGeneral();
		mlvGeneral = findViewById_(R.id.lvGeneral);
		// 配置适配器
		mAdapter = new SimpleAdapter(this, mGeneral, R.layout.general_item,
				new String[] { PHOTO_KEY, NAME_KEY }, new int[] {
						R.id.ivGeneral, R.id.tvGeneral });
		// 关联适配器
		mlvGeneral.setAdapter(mAdapter);
		mlvGeneral.setOnItemClickListener(this);
		mlvGeneral.setOnItemLongClickListener(this);
	}

	// 初始化人名的id和图片的id
	public void initGeneral() {
		mGeneral = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> general = new HashMap<String, Object>();
		general.put(PHOTO_KEY, R.drawable.baiqi);
		general.put(NAME_KEY, "白起");
		mGeneral.add(general);
		general = new HashMap<String, Object>();
		general.put(PHOTO_KEY, R.drawable.caocao);
		general.put(NAME_KEY, "曹操");
		mGeneral.add(general);
		general = new HashMap<String, Object>();
		general.put(PHOTO_KEY, R.drawable.chengjisihan);
		general.put(NAME_KEY, "成吉思汗");
		mGeneral.add(general);
		general = new HashMap<String, Object>();
		general.put(PHOTO_KEY, R.drawable.hanxin);
		general.put(NAME_KEY, "韩信");
		mGeneral.add(general);
		general = new HashMap<String, Object>();
		general.put(PHOTO_KEY, R.drawable.nuerhachi);
		general.put(NAME_KEY, "努尔哈赤");
		mGeneral.add(general);
		general = new HashMap<String, Object>();
		general.put(PHOTO_KEY, R.drawable.sunbin);
		general.put(NAME_KEY, "孙膑");
		mGeneral.add(general);
		general = new HashMap<String, Object>();
		general.put(PHOTO_KEY, R.drawable.sunwu);
		general.put(NAME_KEY, "孙武");
		mGeneral.add(general);
		general = new HashMap<String, Object>();
		general.put(PHOTO_KEY, R.drawable.yuefei);
		general.put(NAME_KEY, "岳飞");
		mGeneral.add(general);
		general = new HashMap<String, Object>();
		general.put(PHOTO_KEY, R.drawable.zhuyuanzhang);
		general.put(NAME_KEY, "朱元璋");
		mGeneral.add(general);

	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		HashMap<String, Object> general = mGeneral.get(position);
		String name = general.get(NAME_KEY).toString();
		Toast.makeText(this, name + "被点击", 3000).show();
	}

	@Override
	public boolean onItemLongClick(AdapterView<?> parent, View view,
			int position, long id) {
		HashMap<String, Object> general = mGeneral.get(position);
		String name = general.get(NAME_KEY).toString();
		Toast.makeText(this, name + "长按", 3000).show();
		return true;
	}

}
