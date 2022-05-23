package com.arquitectura.app.evaluacion;

import java.io.IOException;
import java.net.MalformedURLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arquitectura.app.dto.LuminicoDTO;
import com.arquitectura.app.dto.TermicoDTO;
import com.arquitectura.app.modules.termico.TermicoService;
import com.arquitectura.app.modules.termico.env1.Env1ServiceGlobal;

@Service
public class EvaluacionService {
	
	@Autowired
	Env1ServiceGlobal env1GlobalService;
	
	@Autowired
	TermicoService termicoService;
	
	//Evaluacion Termico
	public TermicoDTO evaluarTermico(String fileUrl, String fileName) throws MalformedURLException, IOException {
		TermicoDTO termicoEvaluacion = new TermicoDTO();
		termicoEvaluacion = termicoService.obtenerTermico(fileUrl, fileName);
		return termicoEvaluacion;
		
	}
	
	//Evaluacion Luminico
	public LuminicoDTO evaluarLuminico(String fileName) {
		LuminicoDTO luminico = new LuminicoDTO();
			luminico.setGeneric("Test");
		return luminico;
	}
	

	

}
