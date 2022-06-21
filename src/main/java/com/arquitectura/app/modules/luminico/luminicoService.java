package com.arquitectura.app.modules.luminico;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arquitectura.app.dto.LuminicoDTO;
import com.arquitectura.app.excel.FormExcelGetData;
import com.arquitectura.app.excel.FormExcelImporter;
import com.arquitectura.app.modules.luminico.models.resVentanaModel;
import com.arquitectura.app.modules.termico.env1.Env1ServiceGlobal;

@Service
public class luminicoService {
	@Autowired
	FormExcelImporter formExcelImporter;
	private final static Logger logger = LoggerFactory.getLogger(Env1ServiceGlobal.class);
	
	public LuminicoDTO obtenerResultadosLuminico(String FILE_URL, String FILE_NAME) throws IOException{
		Workbook worbookObtenido = formExcelImporter.obtenerWorkbookDeFileUrl(FILE_URL, FILE_NAME);
		return resultadosLuminico(worbookObtenido);
	}
	public LuminicoDTO resultadosLuminico(Workbook workbook) {
		LuminicoDTO resultado = new LuminicoDTO();
		resultado.setResVentanas(resultadoVentanas(workbook));
		
		resultado.seteInt(resultadoEInt(workbook));
		resultado.setCumple(cumple(workbook, resultado.geteInt()));
		/* Pruebas
		 * resultado.setFldcPt1(getFLDcPt1(workbook));
		 * resultado.setFldcPt2(getFLDcPt2(workbook));
		 * resultado.setFldcPt3(getFLDcPt3(workbook));
		 */
		return resultado;
	}
	
	
	public String cumple(Workbook workbook, double eInt) {
		FormExcelGetData excelGetData = new FormExcelGetData(workbook);
		excelGetData.setNroHoja(6);
		
		double ilumAmbiente =  excelGetData.getDataDecimalFromColumnAndRow("F","24");
		
		if(eInt > ilumAmbiente) {
			return "Si cumple con la norma";
		}else {
			return "No cumple con la norma, porque es menor que "+ilumAmbiente;
		}
		
	}
	
	public double resultadoEInt(Workbook workbook) {
		FormExcelGetData excelGetData = new FormExcelGetData(workbook);
		excelGetData.setNroHoja(6);
		
		double eInt = 0.0;
		
		double eExt =  excelGetData.getDataDecimalFromColumnAndRow("I","4");
		
		double fldc = (getFLDcPt1(workbook)+getFLDcPt2(workbook))*getFLDcPt3(workbook);

		eInt = eExt * fldc / 100;
		return eInt;
	}
	
	public double getFLDcPt1(Workbook workbook) {
		FormExcelGetData excelGetData = new FormExcelGetData(workbook);
		excelGetData.setNroHoja(6);
		return calcVentA(workbook)+calcVentB(workbook);
	}
	
	public double getFLDcPt2(Workbook workbook) {
		FormExcelGetData excelGetData = new FormExcelGetData(workbook);
		excelGetData.setNroHoja(6);
		double reflejanciaPiso = excelGetData.getDataDecimalFromColumnAndRow("F","15");
		double areaPiso = excelGetData.getDataDecimalFromColumnAndRow("F","11") * excelGetData.getDataDecimalFromColumnAndRow("F","12");
		
		double l = excelGetData.getDataDecimalFromColumnAndRow("C","13");
		double h = excelGetData.getDataDecimalFromColumnAndRow("C","14");
		
		double l1 = excelGetData.getDataDecimalFromColumnAndRow("C","18");
		double h1 = excelGetData.getDataDecimalFromColumnAndRow("C","19");
		
		double areaVentana = (l*h)+(l1*h1);
		
		double avap = areaVentana/areaPiso;
		logger.info("Reflejancia Piso: "+reflejanciaPiso+"");
		double cri = 0.0;
		
		if(reflejanciaPiso == 0.1) {
			cri = (-0.0002 * Math.pow(avap * 100, 2) + 0.0419 * avap * 100 - 0.0905);
		}
		if(reflejanciaPiso == 0.2) {
			cri = (-0.0002 * Math.pow(avap * 100, 2) + 0.0478 * avap * 100 - 0.0019);
		}
		if(reflejanciaPiso == 0.4) {
			cri = (-0.0002 * Math.pow(avap * 100, 2) + 0.0621 * avap * 100 - 0.0367);
		}
		logger.info("CRI: "+cri+"");	
		return cri;
	}
	
	public double getFLDcPt3(Workbook workbook) {
		FormExcelGetData excelGetData = new FormExcelGetData(workbook);
		excelGetData.setNroHoja(6);
		double mantenimiento = excelGetData.getDataDecimalFromColumnAndRow("F","17");
		double transmitacia = excelGetData.getDataDecimalFromColumnAndRow("F","20");
		double obstucciones = excelGetData.getDataDecimalFromColumnAndRow("F","19");
		double carpinteria = excelGetData.getDataDecimalFromColumnAndRow("F","18");
		return mantenimiento*transmitacia*(1-obstucciones)*(1-carpinteria);
	}
	
	public double calcVentA(Workbook workbook) {
		FormExcelGetData excelGetData = new FormExcelGetData(workbook);
		excelGetData.setNroHoja(6);
		
		double l = excelGetData.getDataDecimalFromColumnAndRow("C","13");
		double d = excelGetData.getDataDecimalFromColumnAndRow("F","5");
		double h = 0.0;
		double alto =  excelGetData.getDataDecimalFromColumnAndRow("C","14");
		double alfeizar =  excelGetData.getDataDecimalFromColumnAndRow("C","15");
		double altPlano =  excelGetData.getDataDecimalFromColumnAndRow("F","7");
		if(alfeizar>altPlano) {
			h = alto + alfeizar - altPlano;
		}else {
			h = alto;
		}
		resVentanaModel resVenA = new resVentanaModel(l/d, h/d);
		
		double disenioE = excelGetData.getDataDecimalFromColumnAndRow("F","6");
		double disenioD = excelGetData.getDataDecimalFromColumnAndRow("F","5");
		double anguloBisectriz = (Math.atan(h/(disenioE+disenioD))*180/Math.PI)/2;
		logger.info("Angulo Bizectriz A: "+anguloBisectriz+"");
		
		if(alfeizar>altPlano) {
			h = alfeizar - altPlano;
		}else {
			h = 0;
			l = 0;
			d = 0;
		}
		resVentanaModel resVenB = new resVentanaModel(l/d, h/d);
		
		double tipoCielo = excelGetData.getDataDecimalFromColumnAndRow("C","6");
		double factor;
		
		if(h==0) {
			factor = resVenA.getFldd();
		}else {
			factor = resVenA.getFldd() - resVenB.getFldd();
		}
		logger.info("Factor Antes Bizectriz: "+factor+"");
		
		
		if(tipoCielo == 1) {
			return factor;
		}else {
			factor = 3*factor*(1+2*Math.sin(anguloBisectriz*Math.PI/180))/7;
			logger.info("Factor Luego Bizectriz: "+factor+"");
			return factor;
		}
	}
	
	public double calcVentB(Workbook workbook) {
		FormExcelGetData excelGetData = new FormExcelGetData(workbook);
		excelGetData.setNroHoja(6);

		double l = excelGetData.getDataDecimalFromColumnAndRow("C","18");
		double d = excelGetData.getDataDecimalFromColumnAndRow("F","5")/2;
		double h = 0.0;
		double alto =  excelGetData.getDataDecimalFromColumnAndRow("C","19");
		double alfeizar =  excelGetData.getDataDecimalFromColumnAndRow("C","20");
		double altPlano =  excelGetData.getDataDecimalFromColumnAndRow("F","7");
		if(alfeizar>altPlano) {
			h = alto + alfeizar - altPlano;
		}else {
			h = alto;
		}
		resVentanaModel resVenA = new resVentanaModel(l/d, h/d);
		
		double disenioE = excelGetData.getDataDecimalFromColumnAndRow("F","6");
		double disenioD = excelGetData.getDataDecimalFromColumnAndRow("F","5");
		double anguloBisectriz = (Math.atan(h/(disenioE+disenioD/2))*180/Math.PI)/2;
		logger.info("Angulo Bizectriz B: "+anguloBisectriz+"");
		
		if(alfeizar>altPlano) {
			h = alfeizar - altPlano;
		}else {
			h = 0;
			l = 0;
			d = 0;
		}
		resVentanaModel resVenB = new resVentanaModel(l/d, h/d);
		
		double tipoCielo = excelGetData.getDataDecimalFromColumnAndRow("C","6");
		double factor;
		
		if(h==0) {
			factor = resVenA.getFldd();
		}else {
			factor = resVenA.getFldd() - resVenB.getFldd();
		}
		logger.info("Factor Antes Bizectriz: "+factor+"");
		if(tipoCielo == 1) {
			return factor;
		}else {
			factor = 3*factor*(1+2*Math.sin(anguloBisectriz*Math.PI/180))/7;
			logger.info("Factor Luego Bizectriz: "+factor+"");
			return factor;
		}
	}
	
	public List<resVentanaModel> resultadoVentanas(Workbook workbook) {
		List<resVentanaModel> ventanas = new ArrayList<>();
		FormExcelGetData excelGetData = new FormExcelGetData(workbook);
		excelGetData.setNroHoja(6);
		
		//Ventana tipo A
		double l = excelGetData.getDataDecimalFromColumnAndRow("C","18");
		double d = excelGetData.getDataDecimalFromColumnAndRow("F","5")/2;
		double h = 0.0;
		double alto =  excelGetData.getDataDecimalFromColumnAndRow("C","19");
		double alfeizar =  excelGetData.getDataDecimalFromColumnAndRow("C","20");
		double altPlano =  excelGetData.getDataDecimalFromColumnAndRow("F","7");
		if(alfeizar>altPlano) {
			h = alto + alfeizar - altPlano;
		}else {
			h = alto;
		}
		resVentanaModel resVenA = new resVentanaModel(l/d, h/d);
		
		//Ventana tipo B
		if(alfeizar>altPlano) {
			h = alfeizar - altPlano;
		}else {
			h = 0;
			l = 0;
			d = 0;
		}
		resVentanaModel resVenB = new resVentanaModel(l/d, h/d);
		ventanas.add(resVenA);
		ventanas.add(resVenB);
		return ventanas;
	}
}
