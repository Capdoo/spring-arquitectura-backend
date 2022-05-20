package com.arquitectura.app.evaluacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.arquitectura.app.dto.EvaluacionDTO;
import com.arquitectura.app.dto.LuminicoDTO;
import com.arquitectura.app.dto.MensajeDTO;
import com.arquitectura.app.dto.TermicoDTO;
import com.arquitectura.app.modules.files.FileUploadService;
import com.arquitectura.app.modules.termico.env1.Env1ServiceGlobal;

@RestController
@RequestMapping("/evaluacion")
public class EvaluacionController {

	@Autowired
	EvaluacionService evaluacionService;
	
	@Autowired
	Env1ServiceGlobal env1ServiceGlobal;
	
	@Autowired
	FileUploadService fileUploadService;
	
	@PostMapping("/iniciar")
	public ResponseEntity<Object> obtener(@RequestParam("File") MultipartFile file){

		try {

			//Obtener el archivo y guardarlo
			String nameFile = fileUploadService.processNameFile(file);
			
			TermicoDTO termico = evaluacionService.evaluarTermico(nameFile);
			LuminicoDTO luminico = new LuminicoDTO();
				luminico.setGeneric("Test");
			

			EvaluacionDTO evaluacionEnviar = new EvaluacionDTO(termico, luminico);
			
			return new ResponseEntity<Object>(evaluacionEnviar, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<Object>(new MensajeDTO("Hubo un problema"), HttpStatus.BAD_REQUEST);
		}
		
	}
	
}
