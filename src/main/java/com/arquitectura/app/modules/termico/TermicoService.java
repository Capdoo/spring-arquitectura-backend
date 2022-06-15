package com.arquitectura.app.modules.termico;


import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arquitectura.app.dto.TermicoDTO;
import com.arquitectura.app.excel.FormExcelImporter;
import com.arquitectura.app.modules.termico.env1.Env1ServiceGlobal;
import com.arquitectura.app.modules.termico.env2.Env2ServiceGlobal;
import com.arquitectura.app.modules.termico.env3.Env3Service;
import com.arquitectura.app.modules.termico.env4.Env4Service;


@Service
public class TermicoService {

	@Autowired
	FormExcelImporter formExcelImporter;
	
	@Autowired
	Env1ServiceGlobal env1ServiceGlobal;
	
	@Autowired
	Env2ServiceGlobal env2ServiceGlobal;
	
	@Autowired
	Env3Service env3Service;

	@Autowired
	Env4Service env4Service;
	
	public TermicoDTO obtenerTermico(String FILE_URL, String FILE_NAME) throws IOException {
		Workbook worbookObtenido = formExcelImporter.obtenerWorkbookDeFileUrl(FILE_URL, FILE_NAME);
		
		TermicoDTO termicoDTO = new TermicoDTO(); 

			double env1 = env1ServiceGlobal.procesarEnvolvente1(worbookObtenido);
			double env1Round = Math.round(env1*100.0)/100.0;
			termicoDTO.setEnvolvente1(env1Round+"");
			
			double env2 = env2ServiceGlobal.procesarEnvolvente2(worbookObtenido);
			double env2Round = Math.round(env2*100.0)/100.0;
			termicoDTO.setEnvolvente2(env2Round+"");

			double env3 = env3Service.procesarEnv3(worbookObtenido);
			double env3Round = Math.round(env3*100.0)/100.0;
			termicoDTO.setEnvolvente3(env3Round+"");

			double env4 = env4Service.procesarEnv4(worbookObtenido);
			double env4Round = Math.round(env4*100.0)/100.0;
			termicoDTO.setEnvolvente4(env4Round+"");
			
		return termicoDTO;

	}
	
	public boolean isCumpleTermico() {
		return false;
	}
}
