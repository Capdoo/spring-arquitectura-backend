package com.arquitectura.app.excel;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.arquitectura.app.modules.files.FileUploadService;

@Service
public class FormExcelImporter {
	
	@Value("${file.upload-dir}")
	String FILE_DIRECTORY;
	
	private final static Logger logger = LoggerFactory.getLogger(FormExcelImporter.class);

	//Acordado
	public Workbook obtenerWorkbookDeFileUrl(String FILE_URL, String FILE_NAME) throws IOException {
		//Windows
		String PATH_FILE_SERVER = "save\\"+FILE_NAME;
		File primerRequi  = new File(PATH_FILE_SERVER);
	
			//Linux Server
			//String PATH_FILE_SERVER = "save/"+FILE_NAME;
			//File primerRequi  = new File(PATH_FILE_SERVER);

		primerRequi.createNewFile();

		try (BufferedInputStream in = new BufferedInputStream(new URL(FILE_URL).openStream());
			  FileOutputStream fileOutputStream = new FileOutputStream(primerRequi)) {
			    byte dataBuffer[] = new byte[1024];
			    int bytesRead;
			    while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
			        fileOutputStream.write(dataBuffer, 0, bytesRead);
			    }
				fileOutputStream.close();
			} catch (IOException e) {
			    e.printStackTrace();
			}
			
		FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream(PATH_FILE_SERVER);
			Workbook workbook = new XSSFWorkbook(fileInputStream);
			fileInputStream.close();
			
			return workbook;
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//Antiguo (solo de guia)
	public String excelImport() {
		
		String excelFilePath = FILE_DIRECTORY+"Formulario2.xlsx";
		
		FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream(excelFilePath);
			Workbook workbook = new XSSFWorkbook(fileInputStream);
			
			
			FormExcelGetData formExcelGetData = new FormExcelGetData(workbook);
			
			
			String esperado = formExcelGetData.getDataStringColumnAndRow("B","8");
			double esperado2 =  formExcelGetData.getDataDecimalFromColumnAndRow("C","13");
			
			logger.info(esperado);
			logger.info(esperado2+"");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "";
	}
	
}








