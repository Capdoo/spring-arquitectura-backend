package com.arquitectura.app.modules.termico.env1;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arquitectura.app.modules.termico.MaterialesRepository;
import com.arquitectura.app.modules.termico.ResistenciaModel;
import com.arquitectura.app.modules.termico.ResistenciaRepository;
import com.arquitectura.app.modules.termico.VidriosModel;
import com.arquitectura.app.modules.termico.MaterialesModel;
import com.arquitectura.app.modules.termico.VidriosRepository;

@Service
public class Env1ServiceToBD {


	@Autowired
	VidriosRepository vidriosRepository;
	
	@Autowired
	MaterialesRepository materialesRepository;
	
	@Autowired
	ResistenciaRepository resistenciaRepository;
	
	//ENV1-PART1
	public double getTransByName(String nombre) {
		
		Optional<VidriosModel> registroObtenido = vidriosRepository.findByNombreVidrio(nombre);

		VidriosModel registro = registroObtenido.get();
		
		String transmitancia = registro.getTransmitanciaVidrio();
		
		double res = Double.parseDouble(transmitancia);
		
		return res;
	}
	
	//ENV1-PART2
	public double getCoefTransByName(String nombre) {
		Optional<MaterialesModel> registroObtenido = materialesRepository.findByNombreMaterial(nombre);
		MaterialesModel registro = registroObtenido.get();		
		String coef = registro.getCoeficienteTransmision();

		return Double.parseDouble(coef);
	}
	
	public double getResistCamByName(String nombre) {
		Optional<ResistenciaModel> registroObtenido = resistenciaRepository.findByNombreResistencia(nombre);
		ResistenciaModel registro = registroObtenido.get();		
		String resist = registro.getValorResistencia();

		return Double.parseDouble(resist);
	}
	
}
















