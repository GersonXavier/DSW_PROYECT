package com.empresa.validator;

import org.springframework.stereotype.Component;

import com.empresa.entity.Usuario;
import com.empresa.util.exceptions.ApiUnProcessableEntity;

@Component
public class UserValidatorImpl implements UserValidator{

	@Override
	public void Validator(Usuario user) throws ApiUnProcessableEntity {
		// TODO Auto-generated method stub
		if (user.getNom_usuario()==null || user.getNom_usuario().isEmpty()) {
			
			mensaje("El nombre es obligatorio");
		}
		
	}
	public void mensaje (String mensaje) throws ApiUnProcessableEntity{
		throw new ApiUnProcessableEntity(mensaje);
	}

}
