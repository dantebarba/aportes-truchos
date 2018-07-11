package com.github.dantebarba.aportestruchos.dto;

public class ErrorMessage {

	private int status = 500;
	private String message = "";

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int code) {
		this.status = code;
	}

}
