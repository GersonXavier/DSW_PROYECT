package com.empresa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Usuario;
import com.empresa.repository.UsuarioRepository;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepositorio;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> ListaUsuario(){
		List<Usuario> ListarUsuario = usuarioRepositorio.findAll();
		return ResponseEntity.ok(ListarUsuario);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Usuario> BuscarPorID(@PathVariable("id") int id_usuario)
	{
		Optional<Usuario> optional = usuarioRepositorio.findById(id_usuario);
        if(optional.isPresent()) {
			return ResponseEntity.ok(optional.get());
		}else
			return ResponseEntity.noContent().build();
		
	}
	
    @PostMapping
    public ResponseEntity<Usuario> CrearUsuario(@RequestBody Usuario usuario)
    {
    
    	Usuario newUsuario = usuarioRepositorio.save(usuario);
    	return ResponseEntity.ok(newUsuario);
    }
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> EliminarUsuario(@PathVariable("id") int id_usuario)
	{
	usuarioRepositorio.deleteById(id_usuario);	
	return ResponseEntity.ok(null);
	}

	@PutMapping
	public ResponseEntity<Usuario> editarUsuario(@RequestBody Usuario usuario)
	{
	Optional<Usuario> optUsuario = usuarioRepositorio.findById(usuario.getId_usuario());	
	
	if(optUsuario.isPresent()) {
		Usuario updateUsuario = optUsuario.get();
		updateUsuario.setNom_usuario(usuario.getNom_usuario());
		updateUsuario.setApe_usuario(usuario.getApe_usuario());
		updateUsuario.setDirec_usuario(usuario.getDirec_usuario());
		updateUsuario.setCorreo_usuario(usuario.getCorreo_usuario());
		updateUsuario.setNum_usuario(usuario.getNum_usuario());
		usuarioRepositorio.save(updateUsuario);
		return ResponseEntity.ok(updateUsuario);
	}else{
		
		return ResponseEntity.notFound().build();
	}
	
	}
}
