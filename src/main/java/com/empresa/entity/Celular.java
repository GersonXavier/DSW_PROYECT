package com.empresa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="celular")
public class Celular {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id_celular;
@Column
private String nombre;
@Column  
private String precio;
@Column
private String marca;
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
public String getPrecio() {
	return precio;
}
public void setPrecio(String precio) {
	this.precio = precio;
}
public String getMarca() {
	return marca;
}
public void setMarca(String marca) {
	this.marca = marca;
}
public String getStock() {
	return stock;
}
public void setStock(String stock) {
	this.stock = stock;
}
}