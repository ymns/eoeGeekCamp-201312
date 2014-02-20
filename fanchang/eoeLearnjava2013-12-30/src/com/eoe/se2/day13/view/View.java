package com.eoe.se2.day13.view;

public class View {

	/**
	 * @param args
	 */
	private String id;
	private String layout_width;
	private String layout_height;
	private String backgorund;

	public View() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLayout_width() {
		return layout_width;
	}

	public void setLayout_width(String layout_width) {
		this.layout_width = layout_width;
	}

	public String getLayout_height() {
		return layout_height;
	}

	public void setLayout_height(String layout_height) {
		this.layout_height = layout_height;
	}

	public String getBackgorund() {
		return backgorund;
	}

	public void setBackgorund(String backgorund) {
		this.backgorund = backgorund;
	}

	public View(String id, String layout_width, String layout_height,
			String backgorund) {
		super();
		this.id = id;
		this.layout_width = layout_width;
		this.layout_height = layout_height;
		this.backgorund = backgorund;
	}

	protected View(String backgorund) {
		this.backgorund = backgorund;
	}

	static private int getCount() {
		return 4;
	}

	@Override
	public String toString() {
		return "View [id:" + this.id + ",高度" + this.layout_height + ",宽度"
				+ this.layout_width + ",背景" + backgorund + "]";
	}

}
