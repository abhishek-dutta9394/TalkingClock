package com.sample.talkingclock.common;

import org.springframework.http.HttpStatus;

public enum ErrorCodes {

	INVALID_HOUR_RANGE (HttpStatus.BAD_REQUEST, "Hours should be between 00-23","Hour should be between 00-23"),
	INVALID_MINUTES_RANGE(HttpStatus.BAD_REQUEST, "Minutes should be between 00-59", "Minutes should be between 00-59");
	
	private final HttpStatus value;

	private final String reason;
	
	private final String description;

	ErrorCodes(HttpStatus value, String reason, String description) {

		this.value= value;
		this.reason=reason;
		this.description=description;
	}
	
	public HttpStatus value() {
		return this.value;
	}
	
	public String getReason() {
		return this.reason;
	}
	
	public String getDescription() {
		return this.description;
	}
}
