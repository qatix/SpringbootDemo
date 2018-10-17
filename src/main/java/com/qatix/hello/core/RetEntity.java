package com.qatix.hello.core;

public class RetEntity<T> {
	String code;
	String message;
	T data;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T object) {
		this.data = object;
	}
}
