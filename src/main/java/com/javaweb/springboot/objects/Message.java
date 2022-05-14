package com.javaweb.springboot.objects;

public class Message {
	private Status status = Status.SUCCESS;
	private String message;

	public enum Status {
		SUCCESS, FAILED
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
