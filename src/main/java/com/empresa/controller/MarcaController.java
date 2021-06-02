package com.empresa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Marca;
import com.empresa.repository.MarcaRepository;

@RestController
@RequestMapping("marca")
public class MarcaController {

	@Autowired
	private MarcaRepository marcaRepositorio;
	
	@GetMapping
	public ResponseEntity<List<Marca>> ListaMarca(){
		
		List<Marca> ListarMarca = marcaRepositorio.findAll();
		
		return ResponseEntity.ok(ListarMarca);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Marca> BuscarPorId(@PathVariable("id") int id){
		Optional<Marca> optional = marcaRepositorio.findById(id);
		
		if(optional.isPresent()) {
			
			return ResponseEntity.ok(optional.get());
			
		}else
		
		return ResponseEntity.noContent().build();
	}
	
}
