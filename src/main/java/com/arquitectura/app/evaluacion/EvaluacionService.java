package com.arquitectura.app.evaluacion;

import java.io.IOException;
import java.net.MalformedURLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arquitectura.app.dto.LuminicoDTO;
import com.arquitectura.app.dto.SolarDTO;
import com.arquitectura.app.dto.TermicoDTO;
import com.arquitectura.app.dto.CondDTO;
import com.arquitectura.app.modules.condensadores.CondService;
import com.arquitectura.app.modules.solar.SolarService;
import com.arquitectura.app.modules.termico.TermicoService;
import com.arquitectura.app.modules.termico.env1.Env1ServiceGlobal;

@Service
public class EvaluacionService {
	
	@Autowired
	Env1ServiceGlobal env1GlobalService;
	
	@Autowired
	CondService condService;
	
	@Autowired
	TermicoService termicoService;
	
	@Autowired
	SolarService solarService;
	
	//Evaluacion Termico
	public TermicoDTO evaluarTermico(String fileUrl, String fileName) throws MalformedURLException, IOException {
		TermicoDTO termicoEvaluacion = new TermicoDTO();
		termicoEvaluacion = termicoService.obtenerTermico(fileUrl, fileName);
		return termicoEvaluacion;
		
	}
	
	//Evaluacion Condensadores
	public CondDTO evaluarCondensadores(String fileUrl, String fileName) throws MalformedURLException, IOException {
		CondDTO condensadoresEvaluacion = new CondDTO();
		condensadoresEvaluacion = condService.ObtenerDatosExcel(fileUrl, fileName);
		return condensadoresEvaluacion;
	}
	public CondDTO evaluarCondensadores(String fileUrl, String fileName, String provincia) throws MalformedURLException, IOException {
		CondDTO condensadoresEvaluacion = new CondDTO();
		condensadoresEvaluacion = condService.ObtenerDatosExcel(fileUrl, fileName, provincia);
		return condensadoresEvaluacion;
	} //Cuando se pase el nombre de la provincia
	
	//Evaluacion Luminico
	public LuminicoDTO evaluarLuminico(String fileName) {
		LuminicoDTO luminico = new LuminicoDTO();
			luminico.setGeneric("Test");
		return luminico;
	}
	
	//Evaluacion Solar
	public SolarDTO evaluarSolar(String fileUrl, String fileName) throws MalformedURLException, IOException {
		SolarDTO solarEvaluacion = new SolarDTO();
		solarEvaluacion = solarService.ObtenerDatosExcel(fileUrl, fileName);
		return solarEvaluacion;
	}
	public SolarDTO evaluarSolar(String fileUrl, String fileName, String provincia) throws MalformedURLException, IOException {
		SolarDTO solarEvaluacion = new SolarDTO();
		solarEvaluacion = solarService.ObtenerDatosExcel(fileUrl, fileName, provincia);
		return solarEvaluacion;
	} //Cuando se pase el nombre de la provincia
	

}
