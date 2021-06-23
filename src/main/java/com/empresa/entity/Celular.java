package com.empresa.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="celular")
public class Celular implements Serializable{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id_celular;
@Column
private String nombre;
@Column  
private int precio;
@ManyToOne
@JoinColumn(name="cod_mar")
private Marca marca;
@Column
private String stock;

public int getId_celular() {
	return id_celular;
}
public void setId_celular(int id_celular) {
	this.id_celular = id_celular;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}

public int getPrecio() {
	return precio;
}
public void setPrecio(int precio) {
	this.precio = precio;
}
public Marca getMarca() {
	return marca;
}
public void setMarca(Marca marca) {
	this.marca = marca;
}
public String getStock() {
	return stock;
}
public void setStock(String stock) {
	this.stock = stock;
}
}