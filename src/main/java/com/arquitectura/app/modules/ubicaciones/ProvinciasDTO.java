package com.arquitectura.app.modules.ubicaciones;

public class ProvinciasDTO {

	private long id;
	private String nombreProvincia;
	
	public ProvinciasDTO() {
		super();
	}
		
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombreProvincia() {
		return nombreProvincia;
	}
	public void setNombreProvincia(String nombreProvincia) {
		this.nombreProvincia = nombreProvincia;
	}

}
