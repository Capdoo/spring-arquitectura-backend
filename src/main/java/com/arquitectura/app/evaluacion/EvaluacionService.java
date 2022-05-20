package com.arquitectura.app.evaluacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arquitectura.app.dto.TermicoDTO;
import com.arquitectura.app.modules.termico.env1.Env1ServiceGlobal;

@Service
public class EvaluacionService {
	
	@Autowired
	Env1ServiceGlobal env1GlobalService;
	
	public TermicoDTO evaluarTermico(String fileName) {
		TermicoDTO termicoEvaluacion = new TermicoDTO();
		termicoEvaluacion = env1GlobalService.generalEnv1(fileName);
		return termicoEvaluacion;
		
	}
	

}
