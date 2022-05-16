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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.arquitectura.app.modules.files.FileUploadService;

@Service
public class FormExcelImporter {
	
	@Value("${file.upload-dir}")
	String FILE_DIRECTORY;
	
	private final static Logger logger = LoggerFactory.getLogger(FormExcelImporter.class);

	
	
	public String excelImport() {
		String elemento = "";
		
		String excelFilePath=FILE_DIRECTORY+"Formulario2.xlsx";
		
		FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream(excelFilePath);
			Workbook workbook = new XSSFWorkbook(fileInputStream);
			
			Sheet firstSheet = workbook.getSheetAt(0); 
			Iterator<Row> rowIterator = firstSheet.iterator();
			rowIterator.next();
			
			System.out.print(firstSheet.getPhysicalNumberOfRows() +" ");
			logger.info(firstSheet.getPhysicalNumberOfRows()+"");
			
			while(rowIterator.hasNext()) {
				Row nextRow = rowIterator.next();
				Iterator<Cell> cellIterator = nextRow.cellIterator();
				while(cellIterator.hasNext()) {
					Cell nextCell = cellIterator.next();
					int columnIndex = nextCell.getColumnIndex();
					
					switch(columnIndex) {
						
					case 1:
						elemento = nextCell.getStringCellValue();
						logger.info(elemento);

					}
				}
			}

			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return elemento;
	}
	
}
