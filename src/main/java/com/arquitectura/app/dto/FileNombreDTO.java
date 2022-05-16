package com.arquitectura.app.dto;

public class FileNombreDTO {

	
	private String encabezado;
	private String numDni;
	
	public FileNombreDTO() {
		super();
	}
	public FileNombreDTO(String encabezado, String numDni) {
		super();
		this.encabezado = encabezado;
		this.numDni = numDni;
	}
	public String getEncabezado() {
		return encabezado;
	}
	public void setEncabezado(String encabezado) {
		this.encabezado = encabezado;
	}
	public String getNumDni() {
		return numDni;
	}
	public void setNumDni(String numDni) {
		this.numDni = numDni;
	}

	public String returnName() {
		
		String prefijo = this.getEncabezado();
		String numDni = this.getNumDni();
		//String fecha = this.getFecha();
		
		//String res = prefijo+"_"+numDni+"_"+fecha+".pdf";
		String res2 = prefijo+"_"+numDni+".xlsx";
		
		return res2;
	}
	
}
