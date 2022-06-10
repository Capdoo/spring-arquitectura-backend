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
	
	public float obtenerTsiMuro(int zona, String tipo_ed) {
		float u = condRepository.findByZona(zona).getU_muro();
		float rsi = condRepository.findByZona(zona).getRsi_muro();
		int te = condRepository.findByZona(zona).getTe_muro();
		float ti = edTiRepository.findByTipo(tipo_ed).getTi();
		
		float tsi = ti-u*rsi*(ti-te);
		return tsi;
	}
	
	public float obtenerTsiTecho(int zona, String tipo_ed) {
		float u = condRepository.findByZona(zona).getU_techo();
		float rsi = condRepository.findByZona(zona).getRsi_techo();
		int te = condRepository.findByZona(zona).getTe_techo();
		float ti = edTiRepository.findByTipo(tipo_ed).getTi();
		
		float tsi = ti-u*rsi*(ti-te);
		return tsi;
	}
	
	public float obtenerTsiPiso(int zona, String tipo_ed) {
		float u = condRepository.findByZona(zona).getU_piso();
		float rsi = condRepository.findByZona(zona).getRsi_piso();
		int te = condRepository.findByZona(zona).getTe_piso();
		float ti = edTiRepository.findByTipo(tipo_ed).getTi();
		
		float tsi = ti-u*rsi*(ti-te);
		return tsi;
	}
	
	public int obtenerHR(int zona) {
		return condRepository.findByZona(zona).getHr();
	}
	
	public CondDTO obtenerDatos(int zona, String tipo_ed) {
		return new CondDTO(obtenerTsiMuro(zona, tipo_ed), obtenerTsiTecho(zona, tipo_ed), obtenerTsiPiso(zona, tipo_ed), obtenerHR(zona));
	}
}
