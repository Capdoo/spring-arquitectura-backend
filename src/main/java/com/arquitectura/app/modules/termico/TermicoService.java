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
import com.arquitectura.app.modules.termico.env1.Env1ServiceGlobal;

@Service
public class TermicoService {

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
		Workbook worbookObtenido = this.obtenerWorkbookDeFileUrl(FILE_URL, FILE_NAME);
		TermicoDTO termicoDTO = new TermicoDTO();
			termicoDTO.setEnvolvente1(env1ServiceGlobal.ObtenerTransmitanciaPorArea(worbookObtenido)+"");
			termicoDTO.setEnvolvente2(null);
			termicoDTO.setEnvolvente3(null);
			termicoDTO.setEnvolvente4(null);
			termicoDTO.setCumple(this.isCumpleTermico());
		return termicoDTO;

	}
	
	public Workbook obtenerWorkbookDeFileUrl(String FILE_URL, String FILE_NAME) throws IOException {
		//Windows
		String PATH_FILE_SERVER = "save\\"+FILE_NAME;
		File primerRequi  = new File(PATH_FILE_SERVER);
	
			//Linux Server
			//String PATH_FILE_SERVER = "save/DAO.xlsx";
			//File primerRequi  = new File(PATH_FILE_SERVER);

		primerRequi.createNewFile();

		try (BufferedInputStream in = new BufferedInputStream(new URL(FILE_URL).openStream());
			  FileOutputStream fileOutputStream = new FileOutputStream(primerRequi)) {
			    byte dataBuffer[] = new byte[1024];
			    int bytesRead;
			    while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
			        fileOutputStream.write(dataBuffer, 0, bytesRead);
			    }
				fileOutputStream.close();
			} catch (IOException e) {
			    e.printStackTrace();
			}
			
		FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream(PATH_FILE_SERVER);
			Workbook workbook = new XSSFWorkbook(fileInputStream);
			fileInputStream.close();
			
			return workbook;
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	

	public boolean isCumpleTermico() {
		return false;
	}
}
