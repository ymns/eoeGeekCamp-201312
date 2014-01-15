package com.eoe.se1.day01.button;

public class Button {

	/**
	 * 保存一个对象，该对象中的onClick()用于响应按 钮被点击的事件
	 * 
	 * @param args
	 */
	OnClickListener mOnClickListener;

	public void setOnClickListener(OnClickListener s) {
		mOnClickListener = s;
	}

	public void performClick() {
		mOnClickListener.onClick();
	}

}
