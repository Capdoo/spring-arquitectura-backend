package com.arquitectura.app.modules.termico;

public class ResultadoDTO {

	
	private double sumSxU;
	private double sumS;
	
	public ResultadoDTO() {
		super();
	}
	
	public ResultadoDTO(double sumSxU, double sumS) {
		super();
		this.sumSxU = sumSxU;
		this.sumS = sumS;
	}

	public double getSumSxU() {
		return sumSxU;
	}

	public void setSumSxU(double sumSxU) {
		this.sumSxU = sumSxU;
	}

	public double getSumS() {
		return sumS;
	}

	public void setSumS(double sumS) {
		this.sumS = sumS;
	}
	
}
