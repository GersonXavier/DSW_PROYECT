package com.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.entity.Carrito;

public interface CarritoRepository extends JpaRepository<Carrito, Integer>{

	
}
