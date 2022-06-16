package com.arquitectura.app.modules.termico.env4;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arquitectura.app.excel.FormExcelGetData;
import com.arquitectura.app.modules.termico.repositories.MaterialesRepository;
import com.arquitectura.app.modules.termico.repositories.ResistenciaRepository;
import com.arquitectura.app.modules.termico.repositories.VidriosRepository;
import com.arquitectura.app.modules.termico.services.TermicoServiceToBD;

@Service
public class Env4Service {
	@Autowired
	VidriosRepository vidriosRepository;
	@Autowired
	MaterialesRepository materialRepository;
	@Autowired
	ResistenciaRepository resistenciaRepository;
	
	
	@Autowired
	TermicoServiceToBD termicoService;
	
	public double procesarEnv4(Workbook workbook) {
		
		double parte1 = getEnv4Pt1(workbook);
		double parte2 = getEnv4Pt2(workbook);
		double parte3 = getEnv4Pt3(workbook);
		
		return parte1 + parte2 + parte3;
		
		//return(getEnv3Pt1(workbook)+getEnv3Pt2(workbook)+getEnv3Pt3(workbook)+getEnv3Pt4(workbook));
	}
	
	public double getEnv4Pt1(Workbook workbook) {
		String materialNombre = "";
		double espesor;
		double transmision;
		double area;
		double u1 = 0.0;
		double u2 = 0.0;
		double sumS = 0.0;
		double sumSxU = 0.0;
		double resCamAire;
		FormExcelGetData excelGetData = new FormExcelGetData(workbook);
		excelGetData.setNroHoja(4);
		
		//ResistenciasSuperficiales
		double rse = excelGetData.getDataDecimalFromColumnAndRow("C","6");
		double rsi = excelGetData.getDataDecimalFromColumnAndRow("C","7");
		
		//PISO SIN CAMARA DE AIRE
		area = excelGetData.getDataDecimalFromColumnAndRow("D","11");
		sumS += area;
		//Elemento 1
		materialNombre = excelGetData.getDataStringColumnAndRow("B","11");
		espesor = excelGetData.getDataDecimalFromColumnAndRow("C","11");
		transmision = Double.parseDouble(materialRepository.findByNombreMaterial(materialNombre).get().getCoeficienteTransmision());
		u1 += espesor/transmision;
		//Elemento 2
		materialNombre = excelGetData.getDataStringColumnAndRow("B","12");
		espesor = excelGetData.getDataDecimalFromColumnAndRow("C","12");
		transmision = Double.parseDouble(materialRepository.findByNombreMaterial(materialNombre).get().getCoeficienteTransmision());
		u1 += espesor/transmision;
		//Elemento 3
		materialNombre = excelGetData.getDataStringColumnAndRow("B","13");
		espesor = excelGetData.getDataDecimalFromColumnAndRow("C","13");
		transmision = Double.parseDouble(materialRepository.findByNombreMaterial(materialNombre).get().getCoeficienteTransmision());
		u1 += espesor/transmision;
		//Calculo
		u1 += (rsi+rse);
		u1 = 1/u1;
		sumSxU += u1 * area;
		
		//PISO CON CAMARA DE AIRE
		area = excelGetData.getDataDecimalFromColumnAndRow("D","21");
		sumS += area;
		//Resistencia camara de aire segun espesor
		materialNombre = excelGetData.getDataStringColumnAndRow("B","18");
		resCamAire = Double.parseDouble(resistenciaRepository.findByNombreResistencia(materialNombre).get().getValorResistencia());
		//Elemento 1
		materialNombre = excelGetData.getDataStringColumnAndRow("B","21");
		espesor = excelGetData.getDataDecimalFromColumnAndRow("C","21");
		transmision = Double.parseDouble(materialRepository.findByNombreMaterial(materialNombre).get().getCoeficienteTransmision());
		u2 += espesor/transmision;
		//Elemento 2
		materialNombre = excelGetData.getDataStringColumnAndRow("B","22");
		espesor = excelGetData.getDataDecimalFromColumnAndRow("C","22");
		transmision = Double.parseDouble(materialRepository.findByNombreMaterial(materialNombre).get().getCoeficienteTransmision());
		u2 += espesor/transmision;
		//Elemento 3
		materialNombre = excelGetData.getDataStringColumnAndRow("B","23");
		espesor = excelGetData.getDataDecimalFromColumnAndRow("C","23");
		transmision = Double.parseDouble(materialRepository.findByNombreMaterial(materialNombre).get().getCoeficienteTransmision());
		u2 += espesor/transmision;
		//Calculo
		u2 += (rsi+rse+resCamAire);
		u2 = 1/u2;
		sumSxU += u2 * area;
		
		return sumSxU/sumS;
	}
	
	public double getEnv4Pt2(Workbook workbook) {
		String materialNombre = "";
		double espesor;
		double transmision;
		double area;
		double u = 0.0;
		double sumS = 0.0;
		double sumSxU = 0.0;
		double resCamAire;
		FormExcelGetData excelGetData = new FormExcelGetData(workbook);
		excelGetData.setNroHoja(4);
		
		//ResistenciasSuperficiales
		double rse = excelGetData.getDataDecimalFromColumnAndRow("C","30");
		double rsi = excelGetData.getDataDecimalFromColumnAndRow("C","31");
		
		//PISO CON CAMARA DE AIRE
		area = excelGetData.getDataDecimalFromColumnAndRow("D","39");
		sumS += area;
		//Resistencia camara de aire segun espesor
		materialNombre = excelGetData.getDataStringColumnAndRow("B","36");
		resCamAire = Double.parseDouble(resistenciaRepository.findByNombreResistencia(materialNombre).get().getValorResistencia());
		//Elemento 1
		materialNombre = excelGetData.getDataStringColumnAndRow("B","39");
		espesor = excelGetData.getDataDecimalFromColumnAndRow("C","39");
		transmision = Double.parseDouble(materialRepository.findByNombreMaterial(materialNombre).get().getCoeficienteTransmision());
		u += espesor/transmision;
		//Elemento 2
		materialNombre = excelGetData.getDataStringColumnAndRow("B","40");
		espesor = excelGetData.getDataDecimalFromColumnAndRow("C","40");
		transmision = Double.parseDouble(materialRepository.findByNombreMaterial(materialNombre).get().getCoeficienteTransmision());
		u += espesor/transmision;
		//Elemento 3
		materialNombre = excelGetData.getDataStringColumnAndRow("B","41");
		espesor = excelGetData.getDataDecimalFromColumnAndRow("C","41");
		transmision = Double.parseDouble(materialRepository.findByNombreMaterial(materialNombre).get().getCoeficienteTransmision());
		u += espesor/transmision;
		//Calculo
		u += (rsi+rse+resCamAire);
		u = 1/u;
		sumSxU += u * area;
		
		return sumSxU/sumS;
	}
	
	public double getEnv4Pt3(Workbook workbook) {
		String materialNombre = "";
		double espesor;
		double transmision;
		double area;
		double u = 0.0;
		double sumS = 0.0;
		double sumSxU = 0.0;
		double resCamAire;
		FormExcelGetData excelGetData = new FormExcelGetData(workbook);
		excelGetData.setNroHoja(4);

		area = excelGetData.getDataDecimalFromColumnAndRow("D","51");
		sumS += area;
		//Resistencia camara de aire segun espesor
		materialNombre = excelGetData.getDataStringColumnAndRow("B","48");
		resCamAire = Double.parseDouble(resistenciaRepository.findByNombreResistencia(materialNombre).get().getValorResistencia());
		//Elemento 1
		materialNombre = excelGetData.getDataStringColumnAndRow("B","51");
		espesor = excelGetData.getDataDecimalFromColumnAndRow("C","51");
		transmision = Double.parseDouble(materialRepository.findByNombreMaterial(materialNombre).get().getCoeficienteTransmision());
		u += espesor/transmision;
		//Elemento 2
		materialNombre = excelGetData.getDataStringColumnAndRow("B","52");
		espesor = excelGetData.getDataDecimalFromColumnAndRow("C","52");
		transmision = Double.parseDouble(materialRepository.findByNombreMaterial(materialNombre).get().getCoeficienteTransmision());
		u += espesor/transmision;
		//Elemento 3
		materialNombre = excelGetData.getDataStringColumnAndRow("B","53");
		espesor = excelGetData.getDataDecimalFromColumnAndRow("C","53");
		transmision = Double.parseDouble(materialRepository.findByNombreMaterial(materialNombre).get().getCoeficienteTransmision());
		u += espesor/transmision;
		//Calculo
		u += resCamAire;
		u = 1/u;
		sumSxU += u * area;
		
		return sumSxU/sumS;
	}
}
