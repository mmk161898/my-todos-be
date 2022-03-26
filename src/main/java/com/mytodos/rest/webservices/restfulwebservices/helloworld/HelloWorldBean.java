package com.mytodos.rest.webservices.restfulwebservices.helloworld;

public class HelloWorldBean {
	
	private String message;

	public HelloWorldBean(String string) {
		// TODO Auto-generated constructor stub
		this.message = string;
		
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
}
