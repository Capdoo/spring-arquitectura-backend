package com.arquitectura.app.modules.env1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="env1partA")
public class Env1Model {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="tipo")
	private String tipo;
	
	@Column(name="subtipo")
	private String subtipo;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="transmitancia")
	private String transmitancia;

	public Env1Model(long id, String tipo, String subtipo, String nombre, String transmitancia) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.subtipo = subtipo;
		this.nombre = nombre;
		this.transmitancia = transmitancia;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getSubtipo() {
		return subtipo;
	}

	public void setSubtipo(String subtipo) {
		this.subtipo = subtipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTransmitancia() {
		return transmitancia;
	}

	public void setTransmitancia(String transmitancia) {
		this.transmitancia = transmitancia;
	}
	
	
	
}
