package com.arquitectura.app.modules.termico.env2;

import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arquitectura.app.excel.FormExcelGetData;
import com.arquitectura.app.modules.termico.ResultadoDTO;
import com.arquitectura.app.modules.termico.env1.Env1ServiceGlobal;
import com.arquitectura.app.modules.termico.env1.Env1ServicePart1;
import com.arquitectura.app.modules.termico.env1.Env1ServicePart2;
import com.arquitectura.app.modules.termico.env1.Env1ServicePart3;

@Service
public class Env2ServiceGlobal {
	
	
	private final static Logger logger = LoggerFactory.getLogger(Env1ServiceGlobal.class);
	
	@Autowired
	FormExcelGetData formExcelGetData;
	
	@Autowired
	Env2ServicePart1 env2Part1;
	
	@Autowired
	Env2ServicePart2 env2Part2;
	
	@Autowired
	Env2ServicePart3 env2Part3;
	
	public double procesarEnvolvente2(Workbook workbook) {
		
		ResultadoDTO part1 = env2Part1.executeEnv2Parte1(workbook);
		ResultadoDTO part2 = env2Part2.executeEnv2Parte2(workbook);
		ResultadoDTO part3 = env2Part3.executeEnv2Parte3(workbook);
		
		double sumaTotalSxU = part1.getSumSxU() + part2.getSumSxU() + part3.getSumSxU();
		double sumaTotalS = part1.getSumS() + part2.getSumS() + part3.getSumS();

		return sumaTotalSxU/sumaTotalS;
	}

}
