package com.arquitectura.app.modules.termico;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="materiales")
public class MaterialesModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="nombre")
	private String nombreMaterial;
	
	@Column(name="coeficiente")
	private String coeficienteTransmision;

	public MaterialesModel() {
		super();
	}

	public MaterialesModel(long id, String nombreMaterial, String coeficienteTransmision) {
		super();
		this.id = id;
		this.nombreMaterial = nombreMaterial;
		this.coeficienteTransmision = coeficienteTransmision;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombreMaterial() {
		return nombreMaterial;
	}

	public void setNombreMaterial(String nombreMaterial) {
		this.nombreMaterial = nombreMaterial;
	}

	public String getCoeficienteTransmision() {
		return coeficienteTransmision;
	}

	public void setCoeficienteTransmision(String coeficienteTransmision) {
		this.coeficienteTransmision = coeficienteTransmision;
	}
	
	
	
	
}
