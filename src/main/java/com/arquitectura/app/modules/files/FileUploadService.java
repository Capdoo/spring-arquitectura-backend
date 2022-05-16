package com.arquitectura.app.modules.files;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.arquitectura.app.dto.FileNombreDTO;
import com.arquitectura.app.dto.MensajeDTO;
import com.arquitectura.app.excel.FormExcelImporter;
import com.arquitectura.app.modules.env1.Env1Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class FileUploadService {
	
	
	@Value("${file.upload-dir}")
	String FILE_DIRECTORY;
	@Autowired
	Env1Service env1Service;
	
	@Autowired
	FormExcelImporter formExcelImporter;

	
	private final static Logger logger = LoggerFactory.getLogger(FileUploadService.class);
	
	
	public ResponseEntity<Object> fileUpload(MultipartFile file) throws IOException{
		
		formExcelImporter.excelImport();
		
		
		logger.info("Proceso de subida : documento XLSX");
		logger.info("Ruta establecida:" + FILE_DIRECTORY+file.getOriginalFilename());
		
		
		try {
			if(!isCorrectFileExt(file.getOriginalFilename()))
				return new ResponseEntity<Object>("El documento debe ser XLSX", HttpStatus.BAD_REQUEST);	
		
			String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(Calendar.getInstance().getTime());
		
			//Asignar nombre respectivo
			String newName = generateNameFileCertif("CERT","PRUEBA_DIA1",timeStamp);

			File primerRequi  = new File(FILE_DIRECTORY+newName); 
			primerRequi.createNewFile();
			FileOutputStream fos = new FileOutputStream(primerRequi);
			fos.write(file.getBytes());
			fos.close();
			
			return new ResponseEntity<Object>(new MensajeDTO("El archivo se envió satisfactoriamente"), HttpStatus.OK);	

		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity<Object>("Error al subir certificado", HttpStatus.BAD_REQUEST);	

		}

		
	}
	
	
	/*
	public ResponseEntity<Object> fileUpload(MultipartFile file, String ruc, String req) throws IOException{
		
		logger.info("Proceso de subida : documento PDF");
		logger.info("Ruta establecida:" + FILE_DIRECTORY+file.getOriginalFilename());
		
		
		
		if(!isCorrectFileExt(file.getOriginalFilename()))
			return new ResponseEntity<Object>("El documento debe ser PDF", HttpStatus.BAD_REQUEST);	
		
		int numVersion = logRepository.findAllByEmpresaAndRequerimientoAndEstadoAtencion(
				empRepository.findById(ruc).get(), 
				reqRepository.findById(req).get(), 
				estRepository.findById("2").get()).size() + 1 ;
		
		
		//Asignar nombre respectivo
		
		String newName = generateNameFile("REQ"+req,ruc,"VERSION_"+numVersion);
	
		File primerRequi  = new File(FILE_DIRECTORY+newName); 
		primerRequi.createNewFile();
		FileOutputStream fos = new FileOutputStream(primerRequi);
		fos.write(file.getBytes());
		fos.close();
		//solicitudService.guardarSolicitud(ruc, req, "2", "Requerimiento "+req+" enviado", newName);
		
		
		return new ResponseEntity<Object>("El requerimiento se envió satisfactoriamente", HttpStatus.OK);	
		
	}
	*/
	
	//Obtiene el sufijo del documento y respuesta
	public boolean isCorrectFileExt(String nombreFile) {
		String suffix = nombreFile.substring (nombreFile.lastIndexOf (".") + 1);
		
		if(isPdfFile(suffix)) {
			return true;
		}else {
			return false;
		}
	}
	
	//Verifica si el sufijo es .pdf
	public boolean isPdfFile(String suffixFile) {
		if(suffixFile.equals("xlsx")) {
			return true;
		}else {
			return false;
		}
	}
	
	//Genera nombre de FileCertificado
	public String generateNameFileCertif(String encabezado, String dni, String fecha) {
		
		FileNombreDTO fileNombre = new FileNombreDTO();
		
		fileNombre.setEncabezado(encabezado);
		fileNombre.setNumDni(dni);
		//fileNombre.setFecha(fecha);
	
		return fileNombre.returnName();
	}
	

	
	//Retorna la ruta completa del archivo
	public String fullRoute(String fileName) {
		return FILE_DIRECTORY+fileName;
	}
	
	
	
	/*
	// Para Mostrar pdf
	// Recibe una ruta completa
	public ResponseEntity<byte[]> showPDFTotal(String fullName){
		
		byte[] contents;
		try {
			contents = Files.readAllBytes(Paths.get(fullName));
			HttpHeaders headers = new HttpHeaders();
		    headers.setContentType(MediaType.APPLICATION_PDF);
		    
		    // Here you have to set the actual filename of your pdf
		    String filename = "output.pdf";
		    headers.setContentDispositionFormData(filename, filename);
		    headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
			
			ResponseEntity<byte[]> response = new ResponseEntity<>(contents, headers, HttpStatus.OK);
			return response;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ResponseEntity<byte[]> response = new ResponseEntity<>(null, null, HttpStatus.BAD_REQUEST);
			return response;
			
		}
	}
	

	
	
	public byte[] showPDFTotal2(String fullName){
		
		FileResponseDTO fileResponseDTO = new FileResponseDTO();
		
		byte[] contents;
		try {
			contents = Files.readAllBytes(Paths.get(fullName));
			HttpHeaders headers = new HttpHeaders();
		    headers.setContentType(MediaType.APPLICATION_PDF);
		    
		    // Here you have to set the actual filename of your pdf
		    String filename = "output.pdf";
		    headers.setContentDispositionFormData(filename, filename);
		    headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
						
			fileResponseDTO.setHttpHeaders(headers);
			fileResponseDTO.setFile(contents);
			
			return contents;
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
			
		}
		
	}
	
	
	*/
	
	public String obtenerNombreCertificadoDiscapacidad(String dni) {
		if(!(dni=="")) {
			return "CERT_"+dni+".pdf";
		}else {
			return null;
		}
	}
	
	
	
	

}