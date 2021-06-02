package com.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.entity.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Integer> {

}
