package com.empresa.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.empresa.entity.Celular;



public interface CelularRepository extends JpaRepository<Celular, Integer>{


	public List<Celular> findByNombreLike( String filtro);
	
	
}
