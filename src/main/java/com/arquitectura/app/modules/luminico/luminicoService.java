package com.arquitectura.app.modules.luminico;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arquitectura.app.dto.LuminicoDTO;
import com.arquitectura.app.excel.FormExcelGetData;
import com.arquitectura.app.excel.FormExcelImporter;
import com.arquitectura.app.modules.luminico.models.resVentanaModel;

@Service
public class luminicoService {
	@Autowired
	FormExcelImporter formExcelImporter;
	
	public LuminicoDTO resultadosLuminico(Workbook workbook) {
		LuminicoDTO resultado = new LuminicoDTO();
		resultado.setResVentanas(resultadoVentanas(workbook));
		return resultado;
	}
	
	public double resultadoEInt(Workbook workbook) {
		FormExcelGetData excelGetData = new FormExcelGetData(workbook);
		excelGetData.setNroHoja(6);
		
		double eInt = 0.0;
		
		double eExt =  excelGetData.getDataDecimalFromColumnAndRow("I","4");
		
		double fldc = (getFLDcPt1(workbook)+getFLDcPt2(workbook))*getFLDcPt3(workbook);
		
		
		
		eInt = eExt * fldc;
		return eInt;
	}
	
	public double getFLDcPt1(Workbook workbook) {
		FormExcelGetData excelGetData = new FormExcelGetData(workbook);
		excelGetData.setNroHoja(6);
		return calcVentA(workbook)+calcVentB(workbook);
	}
	
	public double getFLDcPt2(Workbook workbook) {
		return 0.0;
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
		double d = excelGetData.getDataDecimalFromColumnAndRow("F","5")/2;
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
		
		if(tipoCielo == 1) {
			return factor;
		}else {
			return (3/7)*factor*(1+2*Math.sin(anguloBisectriz*Math.PI/180));
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
		double anguloBisectriz = (Math.atan(h/(disenioE+disenioD))*180/Math.PI)/2;
		
		
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
		
		if(tipoCielo == 1) {
			return factor;
		}else {
			return (3/7)*factor*(1+2*Math.sin(anguloBisectriz*Math.PI/180));
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
