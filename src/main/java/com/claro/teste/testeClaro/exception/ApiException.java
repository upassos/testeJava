package com.claro.teste.testeClaro.exception;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

public class ApiException {
	
	private final String message;
	private final Throwable throwable;
	private final HttpStatus httpstatus;
	private final ZonedDateTime timestap;
	
	public ApiException(String message, Throwable throwable, HttpStatus httpstatus, ZonedDateTime timestap) {
		this.message = message;
		this.throwable = throwable;
		this.httpstatus = httpstatus;
		this.timestap = timestap;
	}

	public String getMessage() {
		return message;
	}

	public Throwable getThrowable() {
		return throwable;
	}

	public HttpStatus getHttpstatus() {
		return httpstatus;
	}

	public ZonedDateTime getTimestap() {
		return timestap;
	}
}
