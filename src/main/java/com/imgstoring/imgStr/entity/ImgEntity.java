package com.imgstoring.imgStr.entity;

public class ImgEntity {
	
	private String filename;
 	private String message;
	
	public ImgEntity(String filename, String message) {
		super();
		this.filename = filename;
		this.message = message;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	

}
