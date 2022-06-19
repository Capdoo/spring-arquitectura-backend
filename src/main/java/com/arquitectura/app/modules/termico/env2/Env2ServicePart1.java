package com.arquitectura.app.modules.termico.env2;

import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arquitectura.app.excel.FormExcelGetData;
import com.arquitectura.app.modules.termico.ResultadoDTO;
import com.arquitectura.app.modules.termico.env1.Env1ServicePart2;
import com.arquitectura.app.modules.termico.services.TermicoServiceToBD;

@Service
public class Env2ServicePart1 {
	
	
	@Autowired
	TermicoServiceToBD env1Service;
	
	
	private String EL1;
	private String EL2;
	private String EL3;
	
	private double AR1;
	private double AR2;
	private double AR3;

	private double ESP1;
	private double ESP2;
	private double ESP3;
	
	private double U1;
	private double U2;
	private double U3;
	
	private final static Logger logger = LoggerFactory.getLogger(Env2ServicePart1.class);

	
	public ResultadoDTO executeEnv2Parte1(Workbook workbook) {
		
		ResultadoDTO resultadoDTO = new ResultadoDTO();

		
		FormExcelGetData excelGetData = new FormExcelGetData(workbook);
			excelGetData.setNroHoja(2);
			
				
		double[] ventanas = this.ventanas(excelGetData);
		double[] tipoCarpinteriaMarco = this.tipoCarpinteriaMarco(excelGetData);
		double[] puertas = this.puertas(excelGetData);

	
		//----------------------------------------------
		
		double SU1 = ventanas[0];
		logger.info(SU1+"	--su1");
		double SU2 = tipoCarpinteriaMarco[0];
		logger.info(SU2+"	--su2");
		double SU3 = puertas[0];
		logger.info(SU3+"	--su3");

		
		double S1 = ventanas[1];
		logger.info(S1+"	--s1");

		double S2 = tipoCarpinteriaMarco[1];
		logger.info(S2+"	--s2");

		double S3 = puertas[1];
		logger.info(S3+"	--s3");
		

		double allSxU = SU1 + SU2 + SU3;
		double allS = S1 + S2 + S3;
			
		resultadoDTO.setSumSxU(allSxU);
		resultadoDTO.setSumS(allS);
		
		return resultadoDTO;
	}
	
	
	public double[] ventanas(FormExcelGetData ex) {
		int i = 8;
		
		double[] res = new double[2];
		
		this.EL1 = ex.getDataStringColumnAndRow("B",i+"");
		this.EL2 = ex.getDataStringColumnAndRow("B",(i+1)+"");	

		this.ESP1 = ex.getDataDecimalFromColumnAndRow("C",i+"");
		this.ESP2 = ex.getDataDecimalFromColumnAndRow("C",(i+1)+"");

		this.AR1 = ex.getDataDecimalFromColumnAndRow("D",i+"");
		this.AR2 = ex.getDataDecimalFromColumnAndRow("D",(i+1)+"");

		this.U1 = env1Service.getTransByName(this.EL1);
		this.U2 = env1Service.getTransByName(this.EL2);

		logger.info(U1+" : Esta es U1");
		logger.info(U2+" : Esta es U2");
		
		res[0] = this.AR1*U1 + this.AR2*U2;
		res[1] = this.AR1+this.AR2;
				
		return res;
	}
	
	public double[] tipoCarpinteriaMarco(FormExcelGetData ex) {
		int i = 13;
		
		double[] res = new double[2];
		
		this.EL1 = ex.getDataStringColumnAndRow("B",i+"");
		this.EL2 = ex.getDataStringColumnAndRow("B",(i+1)+"");	
		this.EL3 = ex.getDataStringColumnAndRow("B",(i+2)+"");	

		this.ESP1 = ex.getDataDecimalFromColumnAndRow("C",i+"");
		this.ESP2 = ex.getDataDecimalFromColumnAndRow("C",(i+1)+"");
		this.ESP3 = ex.getDataDecimalFromColumnAndRow("C",(i+2)+"");

		this.AR1 = ex.getDataDecimalFromColumnAndRow("E",i+"");
		this.AR2 = ex.getDataDecimalFromColumnAndRow("E",(i+1)+"");
		this.AR3 = ex.getDataDecimalFromColumnAndRow("E",(i+2)+"");

		this.U1 = env1Service.getTransByNameCarpMarco(this.EL1);
		this.U2 = env1Service.getTransByNameCarpMarco(this.EL2);
		this.U3 = env1Service.getTransByNameCarpMarco(this.EL3);


		logger.info(U1+" : Esta es U1");
		logger.info(U2+" : Esta es U2");
		logger.info(U3+" : Esta es U3");

		
		res[0] = this.AR1*U1 + this.AR2*U2 + this.AR3*U3;
		res[1] = this.AR1+this.AR2+this.AR3;
				
		return res;
	}
	
	public double[] puertas(FormExcelGetData ex) {
		int i = 21;
		
		double[] res = new double[2];
		
		this.EL1 = ex.getDataStringColumnAndRow("B",i+"");
		this.EL2 = ex.getDataStringColumnAndRow("B",(i+1)+"");	
		this.EL3 = ex.getDataStringColumnAndRow("B",(i+2)+"");	

		this.AR1 = ex.getDataDecimalFromColumnAndRow("C",i+"");
		this.AR2 = ex.getDataDecimalFromColumnAndRow("C",(i+1)+"");
		this.AR3 = ex.getDataDecimalFromColumnAndRow("C",(i+2)+"");

		this.U1 = env1Service.getTransByNameCarpMarcoPuerta(this.EL1);
		this.U2 = env1Service.getTransByNameCarpMarcoPuerta(this.EL2);
		this.U3 = env1Service.getTransByNameCarpMarcoPuerta(this.EL3);


		logger.info(U1+" : Esta es U1");
		logger.info(U2+" : Esta es U2");
		logger.info(U3+" : Esta es U3");

		
		res[0] = this.AR1*U1 + this.AR2*U2 + this.AR3*U3;
		res[1] = this.AR1+this.AR2+this.AR3;
				
		return res;
	}
	
	
	

}
