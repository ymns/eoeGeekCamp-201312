package com.eoe.se2.day07.download;

import java.io.Serializable;

public class FileInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	private String fileName;
	private long position;

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

	public FileInfo(String fileName, long position) {
		this.fileName = fileName;
		this.position = position;
	}

	public FileInfo() {
	}
}
