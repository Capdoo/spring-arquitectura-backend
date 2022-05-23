package com.arquitectura.app.dto;

public class CondDTO {
	private float tsi_muro;
	private float tsi_techo;
	private float tsi_piso;
	private int hr;
	public float getTsi_muro() {
		return tsi_muro;
	}
	public void setTsi_muro(float tsi_muro) {
		this.tsi_muro = tsi_muro;
	}
	public float getTsi_techo() {
		return tsi_techo;
	}
	public void setTsi_techo(float tsi_techo) {
		this.tsi_techo = tsi_techo;
	}
	public float getTsi_piso() {
		return tsi_piso;
	}
	public void setTsi_piso(float tsi_piso) {
		this.tsi_piso = tsi_piso;
	}
	public int getHr() {
		return hr;
	}
	public void setHr(int hr) {
		this.hr = hr;
	}
	
	public CondDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CondDTO(float tsi_muro, float tsi_techo, float tsi_piso, int hr) {
		super();
		this.tsi_muro = tsi_muro;
		this.tsi_techo = tsi_techo;
		this.tsi_piso = tsi_piso;
		this.hr = hr;
	}
}
