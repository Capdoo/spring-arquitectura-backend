package com.arquitectura.app.dto;

import java.util.List;

import com.arquitectura.app.modules.luminico.models.resVentanaModel;

public class LuminicoDTO {

	private List<resVentanaModel> resVentanas;
	private double eInt;
	private String cumple;
	
	public LuminicoDTO() {
		super();
	}

	public List<resVentanaModel> getResVentanas() {
		return resVentanas;
	}

	public void setResVentanas(List<resVentanaModel> resVentanas) {
		this.resVentanas = resVentanas;
	}


	public double geteInt() {
		return eInt;
	}

	public void seteInt(double eInt) {
		this.eInt = eInt;
	}

	public String getCumple() {
		return cumple;
	}

	public void setCumple(String cumple) {
		this.cumple = cumple;
	}

}
