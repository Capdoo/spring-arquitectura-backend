package com.arquitectura.app.modules.ubicaciones;

public class UbicacionDTO {

	private long id;
	private String departamento;
	private long numeroZona;
	private String zonaBioclimatica;
	private long estacionReferencial;
	
	public UbicacionDTO(long id, String departamento, long numeroZona, String zonaBioclimatica,
			long estacionReferencial) {
		super();
		this.id = id;
		this.departamento = departamento;
		this.numeroZona = numeroZona;
		this.zonaBioclimatica = zonaBioclimatica;
		this.estacionReferencial = estacionReferencial;
	}
	public UbicacionDTO() {
		super();
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public long getNumeroZona() {
		return numeroZona;
	}
	public void setNumeroZona(long numeroZona) {
		this.numeroZona = numeroZona;
	}
	public String getZonaBioclimatica() {
		return zonaBioclimatica;
	}
	public void setZonaBioclimatica(String zonaBioclimatica) {
		this.zonaBioclimatica = zonaBioclimatica;
	}
	public long getEstacionReferencial() {
		return estacionReferencial;
	}
	public void setEstacionReferencial(long estacionReferencial) {
		this.estacionReferencial = estacionReferencial;
	}

}
