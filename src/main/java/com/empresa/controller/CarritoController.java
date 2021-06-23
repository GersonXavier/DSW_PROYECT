package com.empresa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Carrito;
import com.empresa.entity.Celular;
import com.empresa.repository.CarritoRepository;

@RestController
@RequestMapping("/carrito")
public class CarritoController {
	
	@Autowired
    public CarritoRepository carritoRepository;
	
	@PostMapping("/registrar")
	public ResponseEntity<Carrito> CrearCelular(@RequestBody Celular celular)
	{
		Carrito car = new Carrito();
		car.setProducto(celular.getNombre());
		car.setCantidad(1);
		car.setPreciototal(celular.getPrecio());
		
	Carrito newCelular = carritoRepository.save(car);
	return ResponseEntity.ok(newCelular);
	}
	
	@GetMapping("/lista")
	public ResponseEntity<List<Carrito>> ListaCarrito(){
		List<Carrito> ListarCarrito = carritoRepository.findAll();
		return ResponseEntity.ok(ListarCarrito);
	}

}
