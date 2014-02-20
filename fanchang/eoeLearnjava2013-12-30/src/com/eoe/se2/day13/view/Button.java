package com.eoe.se2.day13.view;

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
		return "Button [onClick=" + onClick + "]";
	}

}
