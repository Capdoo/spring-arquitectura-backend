package com.arquitectura.app.modules.ubicaciones;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ubicaciones")
public class UbicacionesModel {
	@Id
	@Column(name="N")
	private int id;
	
	@Column(name="CIUDAD")
	private String cuidad;
	
	@Column(name="DISTRITO")
	private String distrito;
	
	@Column(name="PROVINCIA")
	private String provincia;
	
	@Column(name="DEPARTAMENTO")
	private String departamento;
	
	@Column(name="N_ZONA")
	private int n_zona;
	
	@Column(name="ZONA_CLIMATICA")
	private String zona_clim;
	
	@Column(name="RANGO")
	private String rango;
	
	@Column(name="N_ESTACION")
	private int n_estacion;
	
	@Column(name="ALTITUD")
	private int altitud;
	
	@Column(name="LATITUD")
	private String latitud;
	
	@Column(name="LONGITUD")
	private String longitud;

	public UbicacionesModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UbicacionesModel(int id, String cuidad, String distrito, String provincia, String departamento, int n_zona,
			String zona_clim, String rango, int n_estacion, int altitud, String latitud, String longitud) {
		super();
		this.id = id;
		this.cuidad = cuidad;
		this.distrito = distrito;
		this.provincia = provincia;
		this.departamento = departamento;
		this.n_zona = n_zona;
		this.zona_clim = zona_clim;
		this.rango = rango;
		this.n_estacion = n_estacion;
		this.altitud = altitud;
		this.latitud = latitud;
		this.longitud = longitud;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCuidad() {
		return cuidad;
	}

	public void setCuidad(String cuidad) {
		this.cuidad = cuidad;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public int getN_zona() {
		return n_zona;
	}

	public void setN_zona(int n_zona) {
		this.n_zona = n_zona;
	}

	public String getZona_clim() {
		return zona_clim;
	}

	public void setZona_clim(String zona_clim) {
		this.zona_clim = zona_clim;
	}

	public String getRango() {
		return rango;
	}

	public void setRango(String rango) {
		this.rango = rango;
	}

	public int getN_estacion() {
		return n_estacion;
	}

	public void setN_estacion(int n_estacion) {
		this.n_estacion = n_estacion;
	}

	public int getAltitud() {
		return altitud;
	}

	public void setAltitud(int altitud) {
		this.altitud = altitud;
	}

	public String getLatitud() {
		return latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLongitud() {
		return longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}
	
	
	
}
