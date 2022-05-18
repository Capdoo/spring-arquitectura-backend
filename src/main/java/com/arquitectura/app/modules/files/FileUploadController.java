package com.arquitectura.app.modules.files;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.arquitectura.app.dto.MensajeDTO;
import com.arquitectura.app.dto.StringDTO;
import com.arquitectura.app.modules.termico.env1.Env1Model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/file")
public class FileUploadController {

	
	@Autowired
	FileUploadService fileUploadService;

	
	@Value("${file.upload-dir}")
	String FILE_DIRECTORY;

	private final static Logger logger = LoggerFactory.getLogger(FileUploadController.class);
	
	
	@PostMapping("/upload")
	public ResponseEntity<Object> fileUpload(@RequestParam("File") MultipartFile file) throws IOException{
		logger.info("Entrada a fileUpload-Controller");
		return fileUploadService.fileUpload(file);		
	}
	
	
	/*
	@PostMapping("/getFile")
	public ResponseEntity<byte[]> getFile(@RequestBody StringDTO stringDTO){
		//String fileGeted = procesoSolicitudService.obtenerDocumento(solicitudDTO);
		String nombreCertificadoFile = fileUploadService.obtenerNombreCertificadoDiscapacidad(stringDTO.getData());
		String file_res = FILE_DIRECTORY + nombreCertificadoFile;
		
		return fileUploadService.showPDFTotal(file_res);
	}
	*/
	
}
