package com.arquitectura.app.evaluacion;

import com.arquitectura.app.dto.CondDTO;
import com.arquitectura.app.dto.LuminicoDTO;
import com.arquitectura.app.dto.SolarDTO;
import com.arquitectura.app.dto.TermicoDTO;

public class EvaluacionDTO {

	private TermicoDTO evaluacionTermico;
	
	private CondDTO evaluacionCondensadores;
	
	private LuminicoDTO evaluacionLuminico;

	private SolarDTO evaluacionSolar;

	
	
	public EvaluacionDTO() {
		super();
	}
	
	public EvaluacionDTO(TermicoDTO evaluacionTermico, CondDTO evaluacionCondensadores, LuminicoDTO evaluacionLuminico,
			SolarDTO evaluacionSolar) {
		super();
		this.evaluacionTermico = evaluacionTermico;
		this.evaluacionCondensadores = evaluacionCondensadores;
		this.evaluacionLuminico = evaluacionLuminico;
		this.evaluacionSolar = evaluacionSolar;
	}

	public TermicoDTO getEvaluacionTermico() {
		return evaluacionTermico;
	}

	public void setEvaluacionTermico(TermicoDTO evaluacionTermico) {
		this.evaluacionTermico = evaluacionTermico;
	}
	
	public CondDTO getEvaluacionCondensadores() {
		return evaluacionCondensadores;
	}

	public void setEvaluacionCondensadores(CondDTO evaluacionCondensadores) {
		this.evaluacionCondensadores = evaluacionCondensadores;
	}

	public LuminicoDTO getEvaluacionLuminico() {
		return evaluacionLuminico;
	}

	public void setEvaluacionLuminico(LuminicoDTO evaluacionLuminico) {
		this.evaluacionLuminico = evaluacionLuminico;
	}

	public SolarDTO getEvaluacionSolar() {
		return evaluacionSolar;
	}

	public void setEvaluacionSolar(SolarDTO evaluacionSolar) {
		this.evaluacionSolar = evaluacionSolar;
	}
	
	
	
	
}
