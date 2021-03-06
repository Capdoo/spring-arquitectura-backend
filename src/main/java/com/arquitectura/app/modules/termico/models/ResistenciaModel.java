package com.arquitectura.app.modules.termico.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="resistencias")
public class ResistenciaModel {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="nombre")
	private String nombreResistencia;
	
	@Column(name="valor")
	private String valorResistencia;
	
	public ResistenciaModel() {
		super();
	}

	public ResistenciaModel(String nombreResistencia, String valorResistencia) {
		super();
		this.nombreResistencia = nombreResistencia;
		this.valorResistencia = valorResistencia;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombreResistencia() {
		return nombreResistencia;
	}

	public void setNombreResistencia(String nombreResistencia) {
		this.nombreResistencia = nombreResistencia;
	}

	public String getValorResistencia() {
		return valorResistencia;
	}

	public void setValorResistencia(String valorResistencia) {
		this.valorResistencia = valorResistencia;
	}
	
	
	
	
}
