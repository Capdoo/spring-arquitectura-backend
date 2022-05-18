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
	
	@Autowired
	FormExcelGetData formExcelGetData;
	
	private final static Logger logger = LoggerFactory.getLogger(FormExcelImporter.class);

	
	
	public String excelImport() {
		
		String esperado = formExcelGetData.getDataFromRowAndColumn(8, "B");
		logger.info(esperado);
		return "";
	}
	
}
