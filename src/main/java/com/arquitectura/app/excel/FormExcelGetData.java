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
	
	
	private final static Logger logger = LoggerFactory.getLogger(FormExcelGetData.class);

	
	public String getDataFromRowAndColumn(int fila, String columna) {
		
		int filaUsable = this.getRowFromNumber(fila);
		int columnaUsable = this.getColumnFromLetter(columna);

		
		String target = "";
	
		
		String excelFilePath=FILE_DIRECTORY+"Formulario2.xlsx";
		
		FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream(excelFilePath);
			Workbook workbook = new XSSFWorkbook(fileInputStream);
			
			Sheet firstSheet = workbook.getSheetAt(0); 
			Iterator<Row> rowIterator = firstSheet.iterator();
			//Para empezar en la segunda fila
			//rowIterator.next();
			
			System.out.print(firstSheet.getPhysicalNumberOfRows() +" ");
			//logger.info(firstSheet.getPhysicalNumberOfRows()+"");
			
			int i = 0;
			
			while(rowIterator.hasNext() && i<filaUsable) {
				Row nextRow = rowIterator.next();
				Iterator<Cell> cellIterator = nextRow.cellIterator();
				
				while(cellIterator.hasNext()) {
					
					Cell nextCell = cellIterator.next();
					int columnIndex = nextCell.getColumnIndex();
					
					if(columnIndex==columnaUsable) {
						target = nextCell.getStringCellValue();
						//logger.info(target);
					}
					
				}
				i+=1;
				//logger.info("Contador: "+i);

			}

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
