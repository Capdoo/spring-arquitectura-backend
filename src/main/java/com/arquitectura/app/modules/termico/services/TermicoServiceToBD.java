package com.arquitectura.app.modules.termico.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arquitectura.app.modules.termico.models.CarpinteriaMarcoModel;
import com.arquitectura.app.modules.termico.models.CarpinteriaMarcoPuertaModel;
import com.arquitectura.app.modules.termico.models.MaterialesModel;
import com.arquitectura.app.modules.termico.models.ResistenciaModel;
import com.arquitectura.app.modules.termico.models.VidriosModel;
import com.arquitectura.app.modules.termico.repositories.CarpinteriaMarcoPuertaRepository;
import com.arquitectura.app.modules.termico.repositories.CarpinteriaMarcoRepository;
import com.arquitectura.app.modules.termico.repositories.MaterialesRepository;
import com.arquitectura.app.modules.termico.repositories.ResistenciaRepository;
import com.arquitectura.app.modules.termico.repositories.VidriosRepository;

@Service
public class TermicoServiceToBD {


	@Autowired
	VidriosRepository vidriosRepository;
	
	//dos nuevos
		@Autowired
		CarpinteriaMarcoRepository carpinteriaMarcoRepository;
		
		@Autowired
		CarpinteriaMarcoPuertaRepository carpinteriaMarcoPuertaRepository;
		
		
	@Autowired
	MaterialesRepository materialesRepository;
	
	@Autowired
	ResistenciaRepository resistenciaRepository;
	
	//ENV1-PART1
	public double getTransByName(String nombre) {
		VidriosModel registroObtenido = vidriosRepository.findByNombreVidrio(nombre).get();	
		double res = Double.parseDouble(registroObtenido.getTransmitanciaVidrio());
		return res;
	}
	
		//ENV1-PART1-TAB2
		public double getTransByNameCarpMarco(String nombre) {
			CarpinteriaMarcoModel registroObtenido = carpinteriaMarcoRepository.findByNombreCarpinteria(nombre).get();	
			double res = Double.parseDouble(registroObtenido.getTransmitanciaCarpinteria());
			return res;
		}
		
		//ENV1-PART1-TAB3
		public double getTransByNameCarpMarcoPuerta(String nombre) {
			CarpinteriaMarcoPuertaModel registroObtenido = carpinteriaMarcoPuertaRepository.findByNombreCarpinteria(nombre).get();	
			double res = Double.parseDouble(registroObtenido.getTransmitanciaCarpinteria());
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
















