package com.arquitectura.app.modules.condensadores;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arquitectura.app.dto.StringDTO;

@RestController
@RequestMapping("/condensadores")
public class CondController {
	@GetMapping("/test")
	public ResponseEntity<Object> test(){
		return new ResponseEntity<Object>(new StringDTO("Hola"), HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Object> cond(){
		return null;
	}
}
