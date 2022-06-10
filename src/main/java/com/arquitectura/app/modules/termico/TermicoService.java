package com.arquitectura.app.modules.termico;


import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arquitectura.app.dto.TermicoDTO;
import com.arquitectura.app.excel.FormExcelImporter;
import com.arquitectura.app.modules.termico.env1.Env1ServiceGlobal;
<<<<<<< HEAD
import com.arquitectura.app.modules.termico.env2.Env2ServiceGlobal;
=======
import com.arquitectura.app.modules.termico.env3.Env3Service;
>>>>>>> env3

@Service
public class TermicoService {

	@Autowired
	FormExcelImporter formExcelImporter;
	
	@Autowired
	Env1ServiceGlobal env1ServiceGlobal;
<<<<<<< HEAD
	
	@Autowired
	Env2ServiceGlobal env2ServiceGlobal;
	
=======
	@Autowired
	Env3Service env3Service;
>>>>>>> env3
	
	public TermicoDTO obtenerTermico(String FILE_URL, String FILE_NAME) throws IOException {
		Workbook worbookObtenido = formExcelImporter.obtenerWorkbookDeFileUrl(FILE_URL, FILE_NAME);
		
		TermicoDTO termicoDTO = new TermicoDTO(); 
<<<<<<< HEAD
			double env1 = env1ServiceGlobal.procesarEnvolvente1(worbookObtenido);
			termicoDTO.setEnvolvente1(env1+"");
			
			double env2 = env2ServiceGlobal.procesarEnvolvente2(worbookObtenido);
			termicoDTO.setEnvolvente2(env2+"");
=======
		
		double env1 = env1ServiceGlobal.procesarEnvolvente1(worbookObtenido);
		termicoDTO.setEnvolvente1(env1+"");
		
		
		double env3 = env3Service.procesarEnv3(worbookObtenido);
		termicoDTO.setEnvolvente3(env3+"");

>>>>>>> env3
				
		return termicoDTO;

	}
	
	public boolean isCumpleTermico() {
		return false;
	}
}
