package com.claro.teste.testeClaro.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

	@ExceptionHandler(value= {MensagemErroGenerica.class})
	public ResponseEntity<Object> handleApiRequestException(MensagemErroGenerica e){
		ApiException apiException = new ApiException(
				e.getMessage(), 
				e, 
				HttpStatus.BAD_REQUEST, 
				ZonedDateTime.now(ZoneId.of("Z")));
		
		return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
	}
}
