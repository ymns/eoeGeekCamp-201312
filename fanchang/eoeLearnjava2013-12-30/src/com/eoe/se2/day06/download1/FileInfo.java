package com.eoe.se2.day06.download1;

import java.io.Serializable;

public class FileInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 *
	 * @param args
	 */
	private String fileName;// 文件名
	private long position;// 断点的位置

	public FileInfo(String fileName, long position) {
		this.fileName = fileName;
		this.position = position;
	}

	public FileInfo() {
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public long getPosition() {
		return position;
	}


	public void setPosition(long position) {
		this.position = position;
	}

}
