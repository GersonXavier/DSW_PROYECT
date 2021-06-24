package com.empresa.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Usuario;
import com.empresa.repository.UsuarioRepository;
import com.empresa.util.hash.BCrypt;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	public UsuarioRepository usuariorepositorio;
	
	@GetMapping("/buscar/{nom}/{contr}")
	public ResponseEntity<Usuario> BuscarPorID(@PathVariable("nom") String user, @PathVariable("contr") String clave)
	{
		
		Usuario usuario = usuariorepositorio.findByUserOrClave(user,clave);
		
        if(BCrypt.checkpw(clave, usuario.getClave())) {
        	System.out.print(usuario.getClave());
			return ResponseEntity.ok(usuario);
		}else
			return ResponseEntity.noContent().build();
		
	}


}