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

import com.empresa.entity.Celular;
import com.empresa.repository.CelularRepository;

@RestController
@RequestMapping("celular")
public class CelularController {
@Autowired
private CelularRepository celularRepositorio;

@GetMapping("/lista")
public ResponseEntity<List<Celular>> ListaCelular(){
	List<Celular> ListarCelular = celularRepositorio.findAll();
	return ResponseEntity.ok(ListarCelular);
}

@GetMapping("/buscarNom/{nom}")
public ResponseEntity<List<Celular>> ListarporNombre(@PathVariable("nom") String nom){
	List<Celular> ListarCelular = celularRepositorio.findByNombreLike(nom+"%");
	return ResponseEntity.ok(ListarCelular);
}


@GetMapping("/buscar/{id}")
public ResponseEntity<Celular> BuscarPorID(@PathVariable("id") int id_celular)
{
Optional<Celular> optional = celularRepositorio.findById(id_celular);
if(optional.isPresent()) {
	return ResponseEntity.ok(optional.get());
}else
	return ResponseEntity.noContent().build();

}

@PostMapping("/registrar")
public ResponseEntity<Celular> CrearCelular(@RequestBody Celular celular)
{
Celular newCelular = celularRepositorio.save(celular);
return ResponseEntity.ok(newCelular);
}

@DeleteMapping("/eliminar/{id}")
public ResponseEntity<Void> EliminarCelular(@PathVariable("id") int id_celular)
{
celularRepositorio.deleteById(id_celular);	
return ResponseEntity.ok(null);
}

@PutMapping("/actualizar")
public ResponseEntity<Celular> editarCelular(@RequestBody Celular celular)
{
Optional<Celular> optCelular = celularRepositorio.findById(celular.getId_celular());	
if(optCelular.isPresent()) {
   Celular updateCelular = optCelular.get();
   updateCelular.setId_celular(celular.getId_celular());
   updateCelular.setNombre(celular.getNombre());
   updateCelular.setPrecio(celular.getPrecio());
   updateCelular.setMarca(celular.getMarca());
   updateCelular.setStock(celular.getStock());
   celularRepositorio.save(updateCelular);
   return ResponseEntity.ok(updateCelular);
}else {
	return ResponseEntity.notFound().build();
}
}


}
