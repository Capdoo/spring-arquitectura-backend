package com.arquitectura.app.modules.termico.env2;

import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arquitectura.app.excel.FormExcelGetData;
import com.arquitectura.app.modules.termico.ResultadoDTO;
import com.arquitectura.app.modules.termico.env1.Env1ServicePart2;
import com.arquitectura.app.modules.termico.repositories.MaterialesRepository;
import com.arquitectura.app.modules.termico.services.TermicoServiceToBD;


@Service
public class Env2ServicePart3 {

	@Autowired
	TermicoServiceToBD env1Service;
	
	@Autowired
	MaterialesRepository materialesRepository;
	
	
	private String EL1;
	private String EL2;
	private String EL3;
	
	private double AR1;

	private double ESP1;
	private double ESP2;
	private double ESP3;
	
	private double COEF1;
	private double COEF2;
	private double COEF3;
	
	private final static Logger logger = LoggerFactory.getLogger(Env1ServicePart2.class);
	


	public ResultadoDTO executeEnv2Parte3(Workbook workbook) {
		
		ResultadoDTO resultadoDTO = new ResultadoDTO();
		
		double[] resFinal = new double[2];
		
		FormExcelGetData excelGetData = new FormExcelGetData(workbook);
			excelGetData.setNroHoja(2);
			
		double[] pisosTipo1b = this.pisosTipo1b(excelGetData);
		
		resFinal[0] = pisosTipo1b[0];
		resFinal[1] = pisosTipo1b[1];
		
		resultadoDTO.setSumSxU(pisosTipo1b[0]);
		resultadoDTO.setSumS(pisosTipo1b[1]);

		
		return resultadoDTO;
	}
	
	
	
	
	public double[] pisosTipo1b(FormExcelGetData ex) {
		
		double rse = 0.11;
		double rsi = 0.06;
		
		int i = 152;
		
		double[] res = new double[2];
		
		this.EL1 = ex.getDataStringColumnAndRow("B",i+"");
		this.EL2 = ex.getDataStringColumnAndRow("B",(i+1)+"");	
		this.EL3 = ex.getDataStringColumnAndRow("B",(i+2)+"");	

		this.ESP1 = ex.getDataDecimalFromColumnAndRow("C",i+"");
		this.ESP2 = ex.getDataDecimalFromColumnAndRow("C",(i+1)+"");
		this.ESP3 = ex.getDataDecimalFromColumnAndRow("C",(i+2)+"");

		this.AR1 = ex.getDataDecimalFromColumnAndRow("D",i+"");

		this.COEF1 = env1Service.getCoefTransByName(this.EL1);
		this.COEF2 = env1Service.getCoefTransByName(this.EL2);
		this.COEF3 = env1Service.getCoefTransByName(this.EL3);

		double U = this.formulaUTransmitanciaBloque1(rse, rsi, 0.0);

		
		res[0] = this.AR1*U;
		res[1] = this.AR1;
				
		return res;
	}
	
	public double formulaUTransmitanciaBloque1(double rse, double rsi, double rst) {

		double U = 1/((this.ESP1/this.COEF1) + (this.ESP2/this.COEF2) + (this.ESP3/this.COEF3) + rse + rsi + rst);
		U = Math.round(U*1000.0)/1000.0;

		return U;
	}
}
