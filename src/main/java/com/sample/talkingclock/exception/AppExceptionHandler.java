package com.sample.talkingclock.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.sample.talkingclock.model.ErrorMessage;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<?> handleAppException(BusinessException ex, WebRequest request) {
		if (ex.isTextPlainContent()) {
			HttpHeaders headers = new HttpHeaders();
			headers.add(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE);
			return new ResponseEntity<>(ex.getDescription(), headers, ex.getErrorCode());
		} else {
			ErrorMessage error = new ErrorMessage(ex.getDescription());
			return new ResponseEntity<>(error, ex.getErrorCode());
		}
	}
	
	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {

		StringBuilder errors = new StringBuilder();

		ex.getBindingResult().getFieldErrors().forEach((error) -> {
			String message = error.getDefaultMessage();
			errors.append(message);
			errors.append("\n");

		});
		ErrorMessage errorMessage = new ErrorMessage(errors.toString());
		return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
	}
}
