package com.app.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtils {
	
	public static ResponseEntity<Object> buildResponse(Object data){
		return new ResponseEntity<Object>(data, HttpStatus.OK);
	}

}
