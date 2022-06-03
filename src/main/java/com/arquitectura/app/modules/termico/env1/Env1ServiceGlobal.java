package com.arquitectura.app.modules.termico.env1;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.arquitectura.app.dto.TermicoDTO;
import com.arquitectura.app.excel.FormExcelGetData;
import com.arquitectura.app.excel.FormExcelImporter;
import com.arquitectura.app.modules.termico.ResultadoDTO;

@Service
public class Env1ServiceGlobal {

	private final static Logger logger = LoggerFactory.getLogger(Env1ServiceGlobal.class);
	
	@Autowired
	FormExcelGetData formExcelGetData;
	
	@Autowired
	Env1ServicePart1 env1Part1;
	
	@Autowired
	Env1ServicePart2 env1Part2;
	
	@Autowired
	Env1ServicePart3 env1Part3;
	
	public double procesarEnvolvente1(Workbook workbook) {
		
		ResultadoDTO part1 = env1Part1.executeEnv1Parte1(workbook);
		ResultadoDTO part2 = env1Part2.executeEnv1Parte2(workbook);
		ResultadoDTO part3 = env1Part3.executeEnv1Parte3(workbook);

		double sumaTotalSxU = part1.getSumSxU() + part2.getSumSxU() + part3.getSumSxU();
		double sumaTotalS = part1.getSumS() + part2.getSumS() + part3.getSumS();

		return sumaTotalSxU/sumaTotalS;
	}
	
	
	
}




