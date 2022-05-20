package com.arquitectura.app.dto;

public class SolarDTO {
	private String provincia;
	private String orientacion_muro;
	private int angulo_recomendado;
	
	public SolarDTO(String provincia, String orientacion_muro, int angulo_recomendado) {
		super();
		this.provincia = provincia;
		this.orientacion_muro = orientacion_muro;
		this.angulo_recomendado = angulo_recomendado;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getOrientacion_muro() {
		return orientacion_muro;
	}
	public void setOrientacion_muro(String orientacion_muro) {
		this.orientacion_muro = orientacion_muro;
	}
	public int getAngulo_recomendado() {
		return angulo_recomendado;
	}
	public void setAngulo_recomendado(int angulo_recomendado) {
		this.angulo_recomendado = angulo_recomendado;
	}
	
	
}
