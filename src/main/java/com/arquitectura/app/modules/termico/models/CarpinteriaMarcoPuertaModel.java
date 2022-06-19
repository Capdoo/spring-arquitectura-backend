package com.arquitectura.app.modules.termico.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="carppuertas")
public class CarpinteriaMarcoPuertaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="nombre")
	private String nombreCarpinteria;
	
	@Column(name="transmitancia")
	private String transmitanciaCarpinteria;

	public CarpinteriaMarcoPuertaModel() {
		super();
	}

	public CarpinteriaMarcoPuertaModel(long id, String nombreCarpinteria, String transmitanciaCarpinteria) {
		super();
		this.id = id;
		this.nombreCarpinteria = nombreCarpinteria;
		this.transmitanciaCarpinteria = transmitanciaCarpinteria;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombreCarpinteria() {
		return nombreCarpinteria;
	}

	public void setNombreCarpinteria(String nombreCarpinteria) {
		this.nombreCarpinteria = nombreCarpinteria;
	}

	public String getTransmitanciaCarpinteria() {
		return transmitanciaCarpinteria;
	}

	public void setTransmitanciaCarpinteria(String transmitanciaCarpinteria) {
		this.transmitanciaCarpinteria = transmitanciaCarpinteria;
	}
	
	
}
