package com.arquitectura.app.dto;

public class TermicoDTO {

	private String envolvente1;
	private String envolvente2;
	private String envolvente3;
	private String envolvente4;
	
	public TermicoDTO() {
		super();
	}

	public TermicoDTO(String envolvente1, String envolvente2, String envolvente3, String envolvente4) {
		super();
		this.envolvente1 = envolvente1;
		this.envolvente2 = envolvente2;
		this.envolvente3 = envolvente3;
		this.envolvente4 = envolvente4;
	}

	public String getEnvolvente1() {
		return envolvente1;
	}
	public void setEnvolvente1(String envolvente1) {
		this.envolvente1 = envolvente1;
	}
	public String getEnvolvente2() {
		return envolvente2;
	}
	public void setEnvolvente2(String envolvente2) {
		this.envolvente2 = envolvente2;
	}
	public String getEnvolvente3() {
		return envolvente3;
	}
	public void setEnvolvente3(String envolvente3) {
		this.envolvente3 = envolvente3;
	}
	public String getEnvolvente4() {
		return envolvente4;
	}
	public void setEnvolvente4(String envolvente4) {
		this.envolvente4 = envolvente4;
	}

}
