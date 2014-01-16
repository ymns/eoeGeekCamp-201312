package com.eoe.se1.day03;

public class Score {

	/**
	 * 四门课的成绩
	 * @param args
	 */
	public int java;
	public int android;
	public int sql;
	public int oracle;

	public Score() {
		// TODO Auto-generated constructor stub
	}

	public Score(int java, int android, int sql, int oracle) {
		super();
		this.java = java;
		this.android = android;
		this.sql = sql;
		this.oracle = oracle;
	}

	@Override
	public String toString() {
		return "Score [java=" + java + ", android=" + android + ", sql=" + sql
				+ ", oracle=" + oracle + "]";
	}
	

}
