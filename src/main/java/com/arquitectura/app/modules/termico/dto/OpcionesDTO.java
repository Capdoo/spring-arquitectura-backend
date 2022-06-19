package com.arquitectura.app.modules.termico.dto;

public class OpcionesDTO {
	
	private long id;
	private String opcion;
	
	public OpcionesDTO() {
		super();
	}
	
	public OpcionesDTO(long id, String opcion) {
		super();
		this.id = id;
		this.opcion = opcion;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOpcion() {
		return opcion;
	}

	public void setOpcion(String opcion) {
		this.opcion = opcion;
	}

	
	
	
}
