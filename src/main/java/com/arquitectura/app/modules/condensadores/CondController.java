package com.arquitectura.app.modules.condensadores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arquitectura.app.dto.CondDTO;
import com.arquitectura.app.dto.StringDTO;



@RestController
@RequestMapping("/condensadores")
public class CondController {
	@Autowired
	CondService condService;
	
	@GetMapping(" ")
	public ResponseEntity<Object> obtenerDatosCondensadores(@RequestBody StringDTO provincia){
		CondDTO cond = condService.generalCond();
		return new ResponseEntity<Object>(cond, HttpStatus.OK);
	}
}
