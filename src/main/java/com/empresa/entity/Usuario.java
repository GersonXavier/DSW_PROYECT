package com.empresa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id_usuario;
@Column
private String user;
@Column
private String nom_usuario;
@Column
private String ape_usuario;
@Column
private String direc_usuario;
@Column
private String correo_usuario; 
@Column
private String num_usuario;
@Column
private String tipo_usuario;
@Column
private String clave;

public int getId_usuario() {
	return id_usuario;
}

public void setId_usuario(int id_usuario) {
	this.id_usuario = id_usuario;
}
public String getNom_usuario() {
	return nom_usuario;
}
public void setNom_usuario(String nom_usuario) {
	this.nom_usuario = nom_usuario;
}
public String getApe_usuario() {
	return ape_usuario;
}
public void setApe_usuario(String ape_usuario) {
	this.ape_usuario = ape_usuario;
}
public String getDirec_usuario() {
	return direc_usuario;
}
public void setDirec_usuario(String direc_usuario) {
	this.direc_usuario = direc_usuario;
}
public String getCorreo_usuario() {
	return correo_usuario;
}
public void setCorreo_usuario(String correo_usuario) {
	this.correo_usuario = correo_usuario;
}
public String getNum_usuario() {
	return num_usuario;
}
public void setNum_usuario(String num_usuario) {
	this.num_usuario = num_usuario;
}
public String getTipo_usuario() {
	return tipo_usuario;
}
public void setTipo_usuario(String tipo_usuario) {
	this.tipo_usuario = tipo_usuario;
}


public String getClave() {
	return clave;
}

public void setClave(String clave) {
	this.clave = clave;
}

public String getUser() {
	return user;
}

public void setUser(String user) {
	this.user = user;
}






}
