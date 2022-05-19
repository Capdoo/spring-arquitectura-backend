package com.arquitectura.app.modules.condensadores;

public class TestDTO {
	private int zona;
	private String tipo_ed;
	public int getZona() {
		return zona;
	}
	public void setZona(int zona) {
		this.zona = zona;
	}
	public String getTipo_ed() {
		return tipo_ed;
	}
	public void setTipo_ed(String tipo_ed) {
		this.tipo_ed = tipo_ed;
	}
	public TestDTO(int zona, String tipo_ed) {
		super();
		this.zona = zona;
		this.tipo_ed = tipo_ed;
	}
}
