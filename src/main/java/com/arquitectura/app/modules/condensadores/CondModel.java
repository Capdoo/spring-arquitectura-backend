package com.arquitectura.app.modules.condensadores;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="condensadores")
public class CondModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int zona;
	
	@Column(name="u_muro", columnDefinition="Decimal(10,2)")
	private float u_muro;
	
	@Column(name="rsi_muro", columnDefinition="Decimal(10,2)")
	private float rsi_muro;
	
	@Column(name="te_muro")
	private int te_muro;
	
	@Column(name="u_techo", columnDefinition="Decimal(10,2)")
	private float u_techo;
	
	@Column(name="rsi_techo", columnDefinition="Decimal(10,2)")
	private float rsi_techo;
	
	@Column(name="te_techo")
	private int te_techo;
	
	@Column(name="u_piso", columnDefinition="Decimal(10,2)")
	private float u_piso;
	
	@Column(name="rsi_piso", columnDefinition="Decimal(10,2)")
	private float rsi_piso;
	
	@Column(name="te_piso")
	private int te_piso;
	
	@Column(name="hr")
	private int hr;
	
	public CondModel() {
		super();
	}
	
	public CondModel(int zona, float u_muro, float rsi_muro, int te_muro, float u_techo, float rsi_techo, int te_techo,
			float u_piso, float rsi_piso, int te_piso, int hr) {
		super();
		this.zona = zona;
		this.u_muro = u_muro;
		this.rsi_muro = rsi_muro;
		this.te_muro = te_muro;
		this.u_techo = u_techo;
		this.rsi_techo = rsi_techo;
		this.te_techo = te_techo;
		this.u_piso = u_piso;
		this.rsi_piso = rsi_piso;
		this.te_piso = te_piso;
		this.hr = hr;
	}

	public int getZona() {
		return zona;
	}

	public void setZona(int zona) {
		this.zona = zona;
	}

	public float getU_muro() {
		return u_muro;
	}

	public void setU_muro(float u_muro) {
		this.u_muro = u_muro;
	}

	public float getRsi_muro() {
		return rsi_muro;
	}

	public void setRsi_muro(float rsi_muro) {
		this.rsi_muro = rsi_muro;
	}

	public int getTe_muro() {
		return te_muro;
	}

	public void setTe_muro(int te_muro) {
		this.te_muro = te_muro;
	}

	public float getU_techo() {
		return u_techo;
	}

	public void setU_techo(float u_techo) {
		this.u_techo = u_techo;
	}

	public float getRsi_techo() {
		return rsi_techo;
	}

	public void setRsi_techo(float rsi_techo) {
		this.rsi_techo = rsi_techo;
	}

	public int getTe_techo() {
		return te_techo;
	}

	public void setTe_techo(int te_techo) {
		this.te_techo = te_techo;
	}

	public float getU_piso() {
		return u_piso;
	}

	public void setU_piso(float u_piso) {
		this.u_piso = u_piso;
	}

	public float getRsi_piso() {
		return rsi_piso;
	}

	public void setRsi_piso(float rsi_piso) {
		this.rsi_piso = rsi_piso;
	}

	public int getTe_piso() {
		return te_piso;
	}

	public void setTe_piso(int te_piso) {
		this.te_piso = te_piso;
	}

	public int getHr() {
		return hr;
	}

	public void setHr(int hr) {
		this.hr = hr;
	}


	
	
}
