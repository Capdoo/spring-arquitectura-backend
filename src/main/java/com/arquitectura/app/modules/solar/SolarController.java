package com.arquitectura.app.modules.solar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arquitectura.app.dto.SolarDTO;

@RestController
@RequestMapping("/solar")
public class SolarController {
	@Autowired
	SolarService solarService;
	
	@GetMapping(" ")
	public ResponseEntity<Object> obtenerDatosCondensadores(){
		SolarDTO solar = solarService.generalSolar();
		return new ResponseEntity<Object>(solar, HttpStatus.OK);
	}
}
