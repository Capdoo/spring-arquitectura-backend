package com.arquitectura.app.modules.solar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="angulo_fachada")
public class SolarModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="norte")
	private int norte;
	
	@Column(name="sur")
	private int sur;
	
	@Column(name="oeste")
	private int oeste;
	
	@Column(name="este")
	private int este;

	
	public SolarModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SolarModel(int id, int norte, int sur, int oeste, int este) {
		super();
		this.id = id;
		this.norte = norte;
		this.sur = sur;
		this.oeste = oeste;
		this.este = este;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNorte() {
		return norte;
	}

	public void setNorte(int norte) {
		this.norte = norte;
	}

	public int getSur() {
		return sur;
	}

	public void setSur(int sur) {
		this.sur = sur;
	}

	public int getOeste() {
		return oeste;
	}

	public void setOeste(int oeste) {
		this.oeste = oeste;
	}

	public int getEste() {
		return este;
	}

	public void setEste(int este) {
		this.este = este;
	}
	
	
}
