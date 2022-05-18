package com.arquitectura.app.excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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








