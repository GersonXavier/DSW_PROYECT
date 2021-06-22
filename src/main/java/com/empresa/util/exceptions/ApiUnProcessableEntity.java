package com.empresa.util.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class ApiUnProcessableEntity extends Exception{
	
	public ApiUnProcessableEntity (String mensaje) {
		super(mensaje);
	}

}
