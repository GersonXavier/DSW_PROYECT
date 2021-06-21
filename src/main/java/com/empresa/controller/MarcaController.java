package com.empresa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Marca;
import com.empresa.repository.MarcaRepository;
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
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
	
	@PostMapping
	public ResponseEntity<Marca> CrearMarca(@RequestBody Marca marca){
		Marca newMarca = marcaRepositorio.save(marca);
		
		return ResponseEntity.ok(newMarca);
		
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> EliminarMarca(@PathVariable("id") int id){
		
		marcaRepositorio.deleteById(id);
		
		return ResponseEntity.ok(null);
	}
	
	@PutMapping
	public ResponseEntity<Marca> editarMarca(@RequestBody Marca marca){
		
		Optional<Marca> optMarca = marcaRepositorio.findById(marca.getId());
		
		if(optMarca.isPresent()) {
			
			Marca updateMarca = optMarca.get();
			updateMarca.setNombre(marca.getNombre());
			updateMarca.setFecha(marca.getFecha());
			marcaRepositorio.save(updateMarca);
			return ResponseEntity.ok(updateMarca);
		}else {
			
			return ResponseEntity.notFound().build();
		}
		
	}
}
