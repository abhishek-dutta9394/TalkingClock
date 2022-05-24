package com.sample.talkingclock.model;

import lombok.Data;

@Data
public class ErrorMessage {
	private String message;
	
	public ErrorMessage(String message) {
		this.message = message;
	}
}
