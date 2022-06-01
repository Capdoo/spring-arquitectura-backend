package com.arquitectura.app.modules.termico.env1;

import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arquitectura.app.excel.FormExcelGetData;
import com.arquitectura.app.modules.termico.MaterialesModel;
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
		
		FormExcelGetData excelGetData = new FormExcelGetData(workbook);
			excelGetData.setNroHoja(1);
			
		double[] muroSinCamaraAire1 = this.muroSinCamaraAire1(excelGetData);
		double[] muroSinCamaraAire2 = this.muroSinCamaraAire2(excelGetData);
		double[] muroConCamaraAire1 = this.muroConCamaraAire1(excelGetData);
		double[] muroConCamaraAire2 = this.muroConCamaraAire2(excelGetData);

		
		double U1 = Math.round(muroSinCamaraAire1[0]/muroSinCamaraAire1[1]*1000.0)/1000.0;
		double U2 = Math.round(muroSinCamaraAire2[0]/muroSinCamaraAire2[1]*1000.0)/1000.0;
		double U3 = Math.round(muroConCamaraAire1[0]/muroConCamaraAire1[1]*1000.0)/1000.0;
		double U4 = Math.round(muroConCamaraAire2[0]/muroConCamaraAire2[1]*1000.0)/1000.0;

		
		return U1+U2+U3+U4;
	}
	
	
	public double[] muroSinCamaraAire1(FormExcelGetData ex) {
		
		double rse = 0.11;
		double rsi = 0.06;
		
		double[] res = new double[2];
		
		this.EL1 = ex.getDataStringColumnAndRow("B","37");
		this.EL2 = ex.getDataStringColumnAndRow("B","38");	
		this.EL3 = ex.getDataStringColumnAndRow("B","39");	
		
		this.ESP1 = ex.getDataDecimalFromColumnAndRow("C","37");
		this.ESP2 = ex.getDataDecimalFromColumnAndRow("C","38");
		this.ESP3 = ex.getDataDecimalFromColumnAndRow("C","39");

		this.AR1 = ex.getDataDecimalFromColumnAndRow("D","37");
		
		this.COEF1 = env1Service.getCoefTransByName(this.EL1);
		this.COEF2 = env1Service.getCoefTransByName(this.EL2);
		this.COEF3 = env1Service.getCoefTransByName(this.EL3);


		
		
		double U = this.formulaUTransmitanciaBloque1(rse,rsi,0.0);
		logger.info(U+" : Esta es U1");

		
		
		res[0] = this.AR1*U;
		res[1] = this.AR1;
				
		return res;
	}
	
	public double[] muroSinCamaraAire2(FormExcelGetData ex) {
		
		double rse = 0.11;
		double rsi = 0.06;
		
		double[] res = new double[2];

		this.EL1 = ex.getDataStringColumnAndRow("B","45");
		this.EL2 = ex.getDataStringColumnAndRow("B","46");	
		this.EL3 = ex.getDataStringColumnAndRow("B","47");	
		
		this.ESP1 = ex.getDataDecimalFromColumnAndRow("C","45");
		this.ESP2 = ex.getDataDecimalFromColumnAndRow("C","46");
		this.ESP3 = ex.getDataDecimalFromColumnAndRow("C","47");
		
		this.AR1 = ex.getDataDecimalFromColumnAndRow("D","45");
		
		this.COEF1 = env1Service.getCoefTransByName(this.EL1);
		this.COEF2 = env1Service.getCoefTransByName(this.EL2);
		this.COEF3 = env1Service.getCoefTransByName(this.EL3);
		
		double U = this.formulaUTransmitanciaBloque1(rse,rsi,0.0);
		logger.info(U+" : Esta es U2");

		
		res[0] = this.AR1*U;
		res[1] = this.AR1;
				
		return res;
	}
	
	public double formulaUTransmitanciaBloque1(double rse, double rsi, double rst) {

		double U = 1/((this.ESP1/this.COEF1) + (this.ESP2/this.COEF2) + (this.ESP3/this.COEF3) + rse + rsi + rst);
		U = Math.round(U*100000.0)/100000.0;

		return U;
	}
	
	public double[] muroConCamaraAire1(FormExcelGetData ex) {
		
		double rst = env1Service.getResistCamByName(ex.getDataStringColumnAndRow("B","53"));
		logger.info(ex.getDataStringColumnAndRow("B","53")+" : Este es name");
	
		
		
		double rse = 0.11;
		double rsi = 0.06;
		
		double[] res = new double[2];
		
		this.EL1 = ex.getDataStringColumnAndRow("B","57");
		this.EL2 = ex.getDataStringColumnAndRow("B","58");	
		this.EL3 = ex.getDataStringColumnAndRow("B","59");	

		this.ESP1 = ex.getDataDecimalFromColumnAndRow("C","57");
		this.ESP2 = ex.getDataDecimalFromColumnAndRow("C","58");
		this.ESP3 = ex.getDataDecimalFromColumnAndRow("C","59");

		this.AR1 = ex.getDataDecimalFromColumnAndRow("D","57");

		this.COEF1 = env1Service.getCoefTransByName(this.EL1);
		this.COEF2 = env1Service.getCoefTransByName(this.EL2);
		this.COEF3 = env1Service.getCoefTransByName(this.EL3);

		double U = this.formulaUTransmitanciaBloque1(rse,rsi,rst);
		logger.info(U+" : Esta es U3");

		
		res[0] = this.AR1*U;
		res[1] = this.AR1;
				
		return res;
		
	}
	
	public double[] muroConCamaraAire2(FormExcelGetData ex) {
		
		double rst = env1Service.getResistCamByName(ex.getDataStringColumnAndRow("B","65"));
			
		double rse = 0.11;
		double rsi = 0.06;
		
		double[] res = new double[2];
		
		this.EL1 = ex.getDataStringColumnAndRow("B","69");
		this.EL2 = ex.getDataStringColumnAndRow("B","70");	
		this.EL3 = ex.getDataStringColumnAndRow("B","71");	

		this.ESP1 = ex.getDataDecimalFromColumnAndRow("C","69");
		this.ESP2 = ex.getDataDecimalFromColumnAndRow("C","70");
		this.ESP3 = ex.getDataDecimalFromColumnAndRow("C","71");

		this.AR1 = ex.getDataDecimalFromColumnAndRow("D","69");

		this.COEF1 = env1Service.getCoefTransByName(this.EL1);
		this.COEF2 = env1Service.getCoefTransByName(this.EL2);
		this.COEF3 = env1Service.getCoefTransByName(this.EL3);

		double U = this.formulaUTransmitanciaBloque1(rse,rsi,rst);
		logger.info(U+" : Esta es U4");

		
		res[0] = this.AR1*U;
		res[1] = this.AR1;
				
		return res;
		
	}
}











