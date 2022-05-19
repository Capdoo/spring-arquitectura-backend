package com.arquitectura.app.modules.termico.env1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arquitectura.app.dto.MensajeDTO;
import com.arquitectura.app.dto.StringDTO;
import com.arquitectura.app.dto.TermicoDTO;


@RestController
@RequestMapping("/envolvente1")
public class Env1Controller {

	@Autowired
	Env1Service env1Service;
	
	@Autowired
	Env1ServiceGlobal env1ServiceGlobal;
	
//	@PostMapping("/obtenerTransmitancia")
//	public ResponseEntity<Object> obtener(@RequestBody StringDTO stringDTO){
	@GetMapping("/obtenerTransmitancia")
	public ResponseEntity<Object> obtener(){

		try {

			TermicoDTO termico = env1ServiceGlobal.generalEnv1();
			return new ResponseEntity<Object>(termico, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<Object>(new MensajeDTO("Hubo un problema"), HttpStatus.BAD_REQUEST);
		}
		
	}
}
