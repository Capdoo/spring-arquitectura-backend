package com.arquitectura.app.modules.termico.controllers;

import java.util.List;

import org.apache.commons.compress.harmony.pack200.NewAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arquitectura.app.dto.MensajeDTO;
import com.arquitectura.app.modules.termico.dto.OpcionesDTO;
import com.arquitectura.app.modules.termico.services.TermicoServiceToBD;

@RestController
@RequestMapping("/opciones")
public class OpcionesTermicoController {

	@Autowired
	TermicoServiceToBD termicoService;
	
	@GetMapping("/vidrios")
	public ResponseEntity<Object> obtenerOpcionesVidrios(){
		try {
			List<OpcionesDTO> opciones = termicoService.getAllVidriosOpciones();
			return new ResponseEntity<Object>(opciones, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(new MensajeDTO("Algo salió mal"), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/carpmarcos")
	public ResponseEntity<Object> obtenerOpcionesCarpinteriaMarcos(){
		try {
			List<OpcionesDTO> opciones = termicoService.getAllCarpMarcoOpciones();
			return new ResponseEntity<Object>(opciones, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(new MensajeDTO("Algo salió mal"), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/carppuertas")
	public ResponseEntity<Object> obtenerOpcionesCarpinteriaPuertas(){
		try {
			List<OpcionesDTO> opciones = termicoService.getAllCarpMarcoPuertaOpciones();
			return new ResponseEntity<Object>(opciones, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(new MensajeDTO("Algo salió mal"), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/materiales")
	public ResponseEntity<Object> obtenerOpcionesMaterialesPuertas(){
		try {
			List<OpcionesDTO> opciones = termicoService.getAllMaterialesOpciones();
			return new ResponseEntity<Object>(opciones, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(new MensajeDTO("Algo salió mal"), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/resistencias")
	public ResponseEntity<Object> obtenerOpcionesResistenciasPuertas(){
		try {
			List<OpcionesDTO> opciones = termicoService.getAllResistenciasOpciones();
			return new ResponseEntity<Object>(opciones, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(new MensajeDTO("Algo salió mal"), HttpStatus.BAD_REQUEST);
		}
	}
	
}

















