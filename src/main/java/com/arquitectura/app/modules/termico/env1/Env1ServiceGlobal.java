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

@Service
public class Env1ServiceGlobal {

	private final static Logger logger = LoggerFactory.getLogger(Env1ServiceGlobal.class);
	
	@Autowired
	FormExcelGetData formExcelGetData;
	
	@Autowired
	Env1ServicePart1 env1Part1;
	
	@Autowired
	Env1ServicePart2 env1Part2;
	
	public double procesarEnvolvente1(Workbook workbook) {
		
		double U1 = env1Part1.executeEnv1Parte1(workbook);
		double U2 = env1Part2.executeEnv1Parte2(workbook);
		
		//double U1 = env1Part1.executeEnv1Parte1(workbook);
		//double U2 = env1Part2.executeEnv1Parte2(workbook);

		return U1+U2;
	}
	
	
	
}




