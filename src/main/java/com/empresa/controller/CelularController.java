package com.empresa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Celular;
import com.empresa.repository.CelularRepository;

@RestController
@RequestMapping("celular")
public class CelularController {
@Autowired
private CelularRepository celularRepositorio;

@GetMapping
public ResponseEntity<List<Celular>> ListaCelular(){
	List<Celular> ListarCelular = celularRepositorio.findAll();
	return ResponseEntity.ok(ListarCelular);
}

@GetMapping("{id}")
public ResponseEntity<Celular> BuscarPorID(@PathVariable("id") int id_celular)
{
Optional<Celular> optional = celularRepositorio.findById(id_celular);
if(optional.isPresent()) {
	return ResponseEntity.ok(optional.get());
}else
	return ResponseEntity.noContent().build();

}
}
