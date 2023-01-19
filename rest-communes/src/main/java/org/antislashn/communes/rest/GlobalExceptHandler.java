package org.antislashn.communes.rest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptHandler  {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> foo(Exception ex, WebRequest request){
		Map<String, Object> foo = new HashMap<>();
		foo.put("time-stamp", new Date());
		foo.put("status", 204);
		return new ResponseEntity<>(foo,HttpStatus.BAD_REQUEST);
	}
	
}
