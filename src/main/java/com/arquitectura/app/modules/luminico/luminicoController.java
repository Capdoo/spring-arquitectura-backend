package com.arquitectura.app.modules.luminico;

import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.arquitectura.app.dto.LuminicoDTO;
import com.arquitectura.app.dto.MensajeDTO;
import com.arquitectura.app.evaluacion.CloudinaryDTO;
import com.arquitectura.app.excel.FormExcelImporter;
import com.arquitectura.app.modules.files.FileUploadService;
import com.arquitectura.app.modules.luminico.models.resVentanaModel;

@RestController
@RequestMapping("/luminico")
public class luminicoController {
	@Autowired
	luminicoService luminicoService;
	@Autowired
	FileUploadService fileUploadService;
	@Autowired
	FormExcelImporter formExcelImporter;
	
	@PostMapping("/prueba")
	public ResponseEntity<Object> obtener(@RequestParam("File") MultipartFile file){
		try {
			CloudinaryDTO cloud = fileUploadService.fileUploadCloud(file);
			Workbook worbookObtenido = formExcelImporter.obtenerWorkbookDeFileUrl(cloud.getUrlFile(), cloud.getNameUniqueFile());
			LuminicoDTO result = luminicoService.resultadosLuminico(worbookObtenido);
			return new ResponseEntity<Object>(result, HttpStatus.OK);
		} catch (IOException e) {
			return new ResponseEntity<Object>(new MensajeDTO("Hubo un problema"), HttpStatus.BAD_REQUEST);
		}
	}
}
