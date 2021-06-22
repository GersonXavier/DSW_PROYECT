package com.empresa.validator;

import org.springframework.stereotype.Service;

import com.empresa.entity.Usuario;
import com.empresa.util.exceptions.ApiUnProcessableEntity;

@Service
public interface UserValidator {

	void Validator ( Usuario user) throws ApiUnProcessableEntity;
}
