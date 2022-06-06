package com.arquitectura.app.modules.termico.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vidrios")
public class VidriosModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="nombre")
	private String nombreVidrio;
	
	@Column(name="transmitancia")
	private String transmitanciaVidrio;

	public VidriosModel() {
		super();
	}

	public VidriosModel(long id, String nombreVidrio, String transmitanciaVidrio) {
		super();
		this.id = id;
		this.nombreVidrio = nombreVidrio;
		this.transmitanciaVidrio = transmitanciaVidrio;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombreVidrio() {
		return nombreVidrio;
	}

	public void setNombreVidrio(String nombreVidrio) {
		this.nombreVidrio = nombreVidrio;
	}

	public String getTransmitanciaVidrio() {
		return transmitanciaVidrio;
	}

	public void setTransmitanciaVidrio(String transmitanciaVidrio) {
		this.transmitanciaVidrio = transmitanciaVidrio;
	}
	
	
	
	
}
