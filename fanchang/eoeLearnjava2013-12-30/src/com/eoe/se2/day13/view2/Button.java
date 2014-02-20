package com.eoe.se2.day13.view2;

public class Button extends TextView {

	private String onClick;

	public String getOnClick() {
		return onClick;
	}

	public void setOnClick(String onClick) {
		this.onClick = onClick;
	}

	@Override
	public String toString() {
		return super.toString();
	}

	public static void main(String[] args) {
		Button button = new Button();
		button.setBackgorund("白色");
		button.setId("btnLogin");
		button.setLayout_height("200dp");
		button.setLayout_width("100dp");
		System.out.println(button);
	}
}
