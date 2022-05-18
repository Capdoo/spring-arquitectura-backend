package com.arquitectura.app.excel;

import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class FormExcelGetData {

	@Value("${file.upload-dir}")
	String FILE_DIRECTORY;

	private Workbook workbook;
	private String columna;
	private String fila;
	
	private final static Logger logger = LoggerFactory.getLogger(FormExcelGetData.class);

	
	public FormExcelGetData() {
		super();
	}

	public FormExcelGetData(Workbook workbook) {
		super();
		this.workbook = workbook;
	}


	public String getDataStringColumnAndRow(String columna, String fila) {
		
		int filaUsable = this.getRowFromNumber(Integer.parseInt(fila));
		int columnaUsable = this.getColumnFromLetter(columna);

		String target = "";


		try {
			//fileInputStream = new FileInputStream(excelFilePath);
			//Workbook workbook = new XSSFWorkbook(fileInputStream);
			
			Cell c = this.workbook.getSheetAt(0).getRow(filaUsable).getCell(columnaUsable);
			target = c.getStringCellValue();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return target;
	}
	
	
	
	

	public double getDataDecimalFromColumnAndRow(String columna, String fila) {
		
		int filaUsable = this.getRowFromNumber(Integer.parseInt(fila));
		int columnaUsable = this.getColumnFromLetter(columna);

		double target = 99.99;

		//String excelFilePath=FILE_DIRECTORY+"Formulario2.xlsx";
		
		//FileInputStream fileInputStream;
		try {
			//fileInputStream = new FileInputStream(excelFilePath);
			//Workbook workbook = new XSSFWorkbook(fileInputStream);
			
			Cell c = this.workbook.getSheetAt(0).getRow(filaUsable).getCell(columnaUsable);
			target = c.getNumericCellValue();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return target;
	}
	
	
	
	public int getRowFromNumber(int fila) {
		return fila-1;
	}
	
	public int getColumnFromLetter(String column) {
		int indice = 0;
		char[] abecedarioObtenido = this.createArray();
		
		for ( int i=0; i<abecedarioObtenido.length; i++) {
			if(column.equals(abecedarioObtenido[i]+"")) {
				indice = i;
			}
		}
		return indice;
	}
	
	public char[] createArray() {
		char[] s;
		s=new char[26];
		for ( int i=0; i<26; i++) {
			s[i] = (char) ('A' + i );
			//logger.info("LETRAS FORMADAS"+s[i]+"-"+i);
		}
		return s;
	}

}
