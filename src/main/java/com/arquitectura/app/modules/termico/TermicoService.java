package com.arquitectura.app.modules.termico;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arquitectura.app.dto.TermicoDTO;
import com.arquitectura.app.excel.FormExcelImporter;
import com.arquitectura.app.modules.termico.env1.Env1ServiceGlobal;

@Service
public class TermicoService {

	@Autowired
	FormExcelImporter formExcelImporter;
	
	@Autowired
	Env1ServiceGlobal env1ServiceGlobal;
	
	/*
	@Autowired
	Env1ServiceGlobal env1ServiceGlobal;
	
	@Autowired
	Env1ServiceGlobal env1ServiceGlobal;
	
	@Autowired
	Env1ServiceGlobal env1ServiceGlobal;
	*/
	
	public TermicoDTO obtenerTermico(String FILE_URL, String FILE_NAME) throws IOException {
		Workbook worbookObtenido = formExcelImporter.obtenerWorkbookDeFileUrl(FILE_URL, FILE_NAME);
		TermicoDTO termicoDTO = new TermicoDTO();
			termicoDTO.setEnvolvente1(env1ServiceGlobal.ObtenerTransmitanciaPorArea(worbookObtenido)+"");
			termicoDTO.setEnvolvente2(null);
			termicoDTO.setEnvolvente3(null);
			termicoDTO.setEnvolvente4(null);
			termicoDTO.setCumple(this.isCumpleTermico());
		return termicoDTO;

	}
	
	public boolean isCumpleTermico() {
		return false;
	}
}
