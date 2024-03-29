package com.empresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.empresa.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	public Usuario findByUserAndClave (String user, String contr);

	public Usuario findByUserOrClave(String user, String contr);



	public List<Usuario> findByUserLike( String filtro);

	public Usuario findByUser (String user);


	
}
