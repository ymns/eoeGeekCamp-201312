package com.eoe.se2.day06.uploading;

import java.io.Serializable;

public class FileInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * @param args
	 */
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
		super();
		this.fileName = fileName;
		this.position = position;
	}

	public FileInfo() {
	}

}
