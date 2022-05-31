package com.arquitectura.app.modules.termico.env1;

import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arquitectura.app.excel.FormExcelGetData;
import com.arquitectura.app.modules.termico.Materiales;
import com.arquitectura.app.modules.termico.MaterialesRepository;

@Service
public class Env1ServicePart2 {
	
	@Autowired
	Env1ServiceToBD env1Service;
	
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
	
	public double executeEnv1Parte2(Workbook workbook) {
		
		
		//double[] res;
		// res[0] = SxU
		// res[1] = S
		
		FormExcelGetData excelGetData = new FormExcelGetData(workbook);
			excelGetData.setNroHoja(1);
			
		double[] muroSinCamaraAire1 = this.muroSinCamaraAire1(excelGetData);
		
		logger.info(muroSinCamaraAire1[0]+": Este es SXU");
		logger.info(muroSinCamaraAire1[1]+": Este es S");

		
		
		logger.info(muroSinCamaraAire1[0]/muroSinCamaraAire1[1]+"Este es U");
		
		double U = Math.round(muroSinCamaraAire1[0]/muroSinCamaraAire1[1]*100.0)/100.0;
		
		
		return U;
	}
	
	
	public double[] muroSinCamaraAire1(FormExcelGetData ex) {
		
		double rse = 0.11;
		double rsi = 0.06;
		
		double[] res = new double[2];
		
		this.ESP1 = ex.getDataDecimalFromColumnAndRow("C","37");
		this.ESP2 = ex.getDataDecimalFromColumnAndRow("C","38");
		this.ESP3 = ex.getDataDecimalFromColumnAndRow("C","39");

		logger.info(this.ESP1+" : Esta es el esp1");
		logger.info(this.ESP2+" : Esta es el esp2");
		logger.info(this.ESP3+" : Esta es el esp3");
		
		this.EL1 = ex.getDataStringColumnAndRow("B","37");
		this.EL2 = ex.getDataStringColumnAndRow("B","38");	
		this.EL3 = ex.getDataStringColumnAndRow("B","39");	
		
		this.AR1 = ex.getDataDecimalFromColumnAndRow("D","37");
		logger.info(this.AR1+" : Esta es el area");
		
		this.COEF1 =  Double.parseDouble(materialesRepository.findByNombreMaterial(this.EL1).get().getCoeficienteTransmision());
		this.COEF2 =  Double.parseDouble(materialesRepository.findByNombreMaterial(this.EL2).get().getCoeficienteTransmision());
		this.COEF3 =  Double.parseDouble(materialesRepository.findByNombreMaterial(this.EL3).get().getCoeficienteTransmision());
		logger.info(this.COEF1+" : Esta es el coef1");
		logger.info(this.COEF2+" : Esta es el coef2");
		logger.info(this.COEF3+" : Esta es el coef3");

		
		
		double U = this.formulaUTransmitanciaBloque1(rse,rsi);
		logger.info(U+" : Esta es U");

		
		
		res[0] = this.AR1*U;
		res[1] = this.AR1;
				
		return res;
	}
	
	public double formulaUTransmitanciaBloque1(double rse, double rsi) {

		double U = 1/((this.ESP1/this.COEF1) + (this.ESP2/this.COEF2) + (this.ESP3/this.COEF3) + rse + rsi);
		U = Math.round(U*100.0)/100.0;

		return U;
	}
	
}











