package com.arquitectura.app.evaluacion;

import com.arquitectura.app.dto.LuminicoDTO;
import com.arquitectura.app.dto.TermicoDTO;

public class EvaluacionDTO {

	private TermicoDTO evaluacionTermico;
	
	private LuminicoDTO evaluacionLuminico;


	public EvaluacionDTO() {
		super();
	}

	public EvaluacionDTO(TermicoDTO evaluacionTermico, LuminicoDTO evaluacionLuminico) {
		super();
		this.evaluacionTermico = evaluacionTermico;
		this.evaluacionLuminico = evaluacionLuminico;
	}

	public TermicoDTO getEvaluacionTermico() {
		return evaluacionTermico;
	}

	public void setEvaluacionTermico(TermicoDTO evaluacionTermico) {
		this.evaluacionTermico = evaluacionTermico;
	}

	public LuminicoDTO getEvaluacionLuminico() {
		return evaluacionLuminico;
	}

	public void setEvaluacionLuminico(LuminicoDTO evaluacionLuminico) {
		this.evaluacionLuminico = evaluacionLuminico;
	}
	
	
	
	
}
