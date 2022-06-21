package com.arquitectura.app.dto;

import java.util.List;

import com.arquitectura.app.modules.luminico.models.resVentanaModel;

public class LuminicoDTO {

	private List<resVentanaModel> resVentanas;
	
	public LuminicoDTO() {
		super();
	}

	public List<resVentanaModel> getResVentanas() {
		return resVentanas;
	}

	public void setResVentanas(List<resVentanaModel> resVentanas) {
		this.resVentanas = resVentanas;
	}

}
