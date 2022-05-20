package com.arquitectura.app.modules.solar;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.arquitectura.app.dto.SolarDTO;
import com.arquitectura.app.excel.FormExcelGetData;

@Service
public class SolarService {
	@Autowired
	SolarRepository solarRepository;
	
	@Autowired
	FormExcelGetData formExcelGetData;

	@Value("${file.upload-dir}")
	String FILE_DIRECTORY;
	
	public SolarDTO generalSolar() {
		String excelFilePath = FILE_DIRECTORY+"Solar.xlsx";
		
		FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream(excelFilePath);
			Workbook workbook = new XSSFWorkbook(fileInputStream);
			SolarDTO data = this.ObtenerDatosExcel(workbook);
			fileInputStream.close();
			return data;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}	
	}
	
	public SolarDTO ObtenerDatosExcel(Workbook workbook) {
		FormExcelGetData excelGetData = new FormExcelGetData(workbook);
		String orientacion = excelGetData.getDataStringColumnAndRow("C", "6");
		int num = (int)excelGetData.getDataDecimalFromColumnAndRow("C", "7");
		
		
		return new SolarDTO("Falta tabla provincia",orientacion,buscarAngulo(num, orientacion));
	}
	
	public int buscarAngulo(int id, String orientacion) {
		SolarModel an_fachada = solarRepository.findById(id);
		switch(orientacion) {
			case "Norte":
				return an_fachada.getNorte();
			case "Sur":
				return an_fachada.getSur();
			case "Este":
				return an_fachada.getEste();
			case "Oeste":
				return an_fachada.getOeste();
		}
		return 0;
	}
}
