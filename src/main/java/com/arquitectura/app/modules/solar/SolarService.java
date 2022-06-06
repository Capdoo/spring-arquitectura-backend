package com.arquitectura.app.modules.solar;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.arquitectura.app.dto.SolarDTO;
import com.arquitectura.app.excel.FormExcelGetData;
import com.arquitectura.app.excel.FormExcelImporter;
import com.arquitectura.app.modules.ubicaciones.UbicacionesService;

@Service
public class SolarService {
	@Autowired
	SolarRepository solarRepository;
	
	@Autowired
	FormExcelGetData formExcelGetData;
	
	@Autowired
	FormExcelImporter formExcelImporter;

	@Autowired
	UbicacionesService ubiService;
	
	
	@Value("${file.upload-dir}")
	String FILE_DIRECTORY;
	
	public SolarDTO generalSolar() {
		/*
		 * String excelFilePath = FILE_DIRECTORY+"Solar.xlsx";
		 * 
		 * FileInputStream fileInputStream; try { fileInputStream = new
		 * FileInputStream(excelFilePath); Workbook workbook = new
		 * XSSFWorkbook(fileInputStream); SolarDTO data =
		 * this.ObtenerDatosExcel(workbook); fileInputStream.close(); return data; }
		 * catch (Exception e) { e.printStackTrace(); return null; }
		 */
		return null;
	}
	
	public SolarDTO ObtenerDatosExcel(String FILE_URL, String FILE_NAME) throws IOException {
		Workbook worbookObtenido = formExcelImporter.obtenerWorkbookDeFileUrl(FILE_URL, FILE_NAME);
		FormExcelGetData excelGetData = new FormExcelGetData(worbookObtenido);
		excelGetData.setNroHoja(5);
		String orientacion = excelGetData.getDataStringColumnAndRow("C", "6");
		double num = excelGetData.getDataDecimalFromColumnAndRow("C", "7");
		
		
		return new SolarDTO("Falta tabla provincia",orientacion,buscarAngulo((int)num, orientacion));
	}
	public SolarDTO ObtenerDatosExcel(String FILE_URL, String FILE_NAME, String provincia) throws IOException {
		Workbook worbookObtenido = formExcelImporter.obtenerWorkbookDeFileUrl(FILE_URL, FILE_NAME);
		FormExcelGetData excelGetData = new FormExcelGetData(worbookObtenido);
		excelGetData.setNroHoja(5);
		String orientacion = excelGetData.getDataStringColumnAndRow("C", "6");
		int idUbi = ubiService.obtenerIdPorProvincia(provincia);
		return new SolarDTO("Falta tabla provincia",orientacion,buscarAngulo(idUbi, orientacion));
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
