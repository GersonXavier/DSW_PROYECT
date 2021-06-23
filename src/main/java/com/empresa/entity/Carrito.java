package com.empresa.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name="carrito")
public class Carrito {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	@Column
	private String producto;
	@Column
	private int cantidad;
	@Column
	private int preciototal;
	
	public void add(int precio) {
		
		this.preciototal+= precio;
		this.cantidad++;
	}
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public int getPreciototal() {
		return preciototal;
	}


	public void setPreciototal(int preciototal) {
		this.preciototal = preciototal;
	}
	
	
	
	
	
	
	
}
