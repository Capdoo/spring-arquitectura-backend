package com.arquitectura.app.modules.condensadores;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="edificacion_ti")
public class EdificacionTiModel {
	@Id
	private String tipo;
	
	@Column(name="ti", columnDefinition="Decimal(10,2)")
	private float ti;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public float getTi() {
		return ti;
	}

	public void setTi(float ti) {
		this.ti = ti;
	}

	public EdificacionTiModel(String tipo, float ti) {
		super();
		this.tipo = tipo;
		this.ti = ti;
	}

	public EdificacionTiModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
