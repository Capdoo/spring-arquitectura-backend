package com.arquitectura.app.dto;

import java.util.List;

import com.arquitectura.app.modules.luminico.models.resVentanaModel;

public class LuminicoDTO {

	private List<resVentanaModel> resVentanas;
	private double eInt;
	private String cumple;
	
	//Prueba
	private double fldcPt1;
	private double fldcPt2;
	private double fldcPt3;
	public LuminicoDTO() {
		super();
	}

	public List<resVentanaModel> getResVentanas() {
		return resVentanas;
	}

	public void setResVentanas(List<resVentanaModel> resVentanas) {
		this.resVentanas = resVentanas;
	}

	public double getFldcPt1() {
		return fldcPt1;
	}

	public void setFldcPt1(double fldcPt1) {
		this.fldcPt1 = fldcPt1;
	}

	public double getFldcPt2() {
		return fldcPt2;
	}

	public void setFldcPt2(double fldcPt2) {
		this.fldcPt2 = fldcPt2;
	}

	public double getFldcPt3() {
		return fldcPt3;
	}

	public void setFldcPt3(double fldcPt3) {
		this.fldcPt3 = fldcPt3;
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
