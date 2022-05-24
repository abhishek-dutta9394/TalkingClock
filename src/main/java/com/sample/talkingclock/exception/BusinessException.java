package com.sample.talkingclock.exception;

import org.springframework.http.HttpStatus;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class BusinessException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	private final HttpStatus errorCode;
	private final String reason;
	private final String description;
	private final boolean textPlainContent;

	
	public BusinessException(HttpStatus errorCode, String reason, String description) {
		super(reason, new Throwable(description));
		this.errorCode=errorCode;
		this.description=description;
		this.reason=reason;
		this.textPlainContent = false;
	}
}
