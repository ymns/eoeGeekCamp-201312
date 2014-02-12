package com.eoe.se2.day07.download1;

import java.io.Serializable;

public class RecordInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 
	 * 请求类型分两种: 1.fileSize表示从服务端获取文件长度的请求。 2.download表示下载本数据块的请求。
	 */
	private String requestType;// 请求的类型
	private long fileSize;// 文件的长度
	private Record record;// 记录当前块的位置信息和文件名

	public RecordInfo() {
		record = new Record();
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public Record getRecord() {
		return record;
	}

	public void setRecord(Record record) {
		this.record = record;
	}

}
