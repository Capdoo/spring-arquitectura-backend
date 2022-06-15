package com.arquitectura.app.modules.condensadores;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.arquitectura.app.dto.CondDTO;
import com.arquitectura.app.excel.FormExcelGetData;
import com.arquitectura.app.excel.FormExcelImporter;
import com.arquitectura.app.modules.ubicaciones.UbicacionesService;

@Service
public class CondService {
	@Autowired
	CondRepository condRepository;
	
	@Autowired
	EdificacionTiRepository edTiRepository;
	
	@Autowired
	UbicacionesService ubiService;
	
	@Autowired
	FormExcelGetData formExcelGetData;
	
	@Autowired
	FormExcelImporter formExcelImporter;

	@Value("${file.upload-dir}")
	String FILE_DIRECTORY;
	
	public CondDTO generalCond() {
		/*
		 * String excelFilePath = FILE_DIRECTORY+"Condensadores.xlsx";
		 * 
		 * FileInputStream fileInputStream; try { fileInputStream = new
		 * FileInputStream(excelFilePath); Workbook workbook = new
		 * XSSFWorkbook(fileInputStream); CondDTO data =
		 * this.ObtenerDatosExcel(workbook); fileInputStream.close(); return data; }
		 * catch (Exception e) { e.printStackTrace(); return null; }
		 */
		
		return null;
	}

	public CondDTO ObtenerDatosExcel(String FILE_URL, String FILE_NAME) throws IOException {
		Workbook worbookObtenido = formExcelImporter.obtenerWorkbookDeFileUrl(FILE_URL, FILE_NAME);
		FormExcelGetData excelGetData = new FormExcelGetData(worbookObtenido);

		
		excelGetData.setNroHoja(5);

		int zona = (int)excelGetData.getDataDecimalFromColumnAndRow("D", "6");
		String tipo_ed = excelGetData.getDataStringColumnAndRow("D", "7");
		
		return new CondDTO(obtenerTsiMuro(zona, tipo_ed), obtenerTsiTecho(zona, tipo_ed), obtenerTsiPiso(zona, tipo_ed), obtenerHR(zona));
	}
	
	public CondDTO ObtenerDatosExcel(String FILE_URL, String FILE_NAME, String provincia) throws IOException {
		Workbook worbookObtenido = formExcelImporter.obtenerWorkbookDeFileUrl(FILE_URL, FILE_NAME);
		FormExcelGetData excelGetData = new FormExcelGetData(worbookObtenido);

		excelGetData.setNroHoja(5);

		int idUbi = ubiService.obtenerIdPorProvincia(provincia);
		int zona = ubiService.obtenerNumeroZona(idUbi);
		String tipo_ed = excelGetData.getDataStringColumnAndRow("D", "7");
		
		return new CondDTO(obtenerTsiMuro(zona, tipo_ed), obtenerTsiTecho(zona, tipo_ed), obtenerTsiPiso(zona, tipo_ed), obtenerHR(zona));
	}
	
	public double obtenerTsiMuro(int zona, String tipo_ed) {
		double u = condRepository.findByZona(zona).getU_muro();
		double rsi = condRepository.findByZona(zona).getRsi_muro();
		int te = condRepository.findByZona(zona).getTe_muro();
		double ti = edTiRepository.findByTipo(tipo_ed).getTi();
		
		double tsi = ti-u*rsi*(ti-te);
		return Math.round(tsi*100)/100;
	}
	
	public double obtenerTsiTecho(int zona, String tipo_ed) {
		double u = condRepository.findByZona(zona).getU_techo();
		double rsi = condRepository.findByZona(zona).getRsi_techo();
		int te = condRepository.findByZona(zona).getTe_techo();
		double ti = edTiRepository.findByTipo(tipo_ed).getTi();
		
		double tsi = ti-u*rsi*(ti-te);
		return Math.round(tsi*100)/100;
	}
	
	public double obtenerTsiPiso(int zona, String tipo_ed) {
		double u = condRepository.findByZona(zona).getU_piso();
		double rsi = condRepository.findByZona(zona).getRsi_piso();
		int te = condRepository.findByZona(zona).getTe_piso();
		double ti = edTiRepository.findByTipo(tipo_ed).getTi();
		
		double tsi = ti-u*rsi*(ti-te);
		return Math.round(tsi*100)/100;
	}
	
	public int obtenerHR(int zona) {
		return condRepository.findByZona(zona).getHr();
	}
	
	public CondDTO obtenerDatos(int zona, String tipo_ed) {
		return new CondDTO(obtenerTsiMuro(zona, tipo_ed), obtenerTsiTecho(zona, tipo_ed), obtenerTsiPiso(zona, tipo_ed), obtenerHR(zona));
	}
}
