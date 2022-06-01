package com.arquitectura.app.modules.termico.env3;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arquitectura.app.excel.FormExcelGetData;
import com.arquitectura.app.modules.termico.MaterialesRepository;
import com.arquitectura.app.modules.termico.ResistenciaRepository;
import com.arquitectura.app.modules.termico.VidriosRepository;

@Service
public class Env3ServicePart1 {
	@Autowired
	VidriosRepository vidriosRepository;
	@Autowired
	MaterialesRepository materialRepository;
	@Autowired
	ResistenciaRepository resistenciaRepository;
	//Vanos: Ventanas, lucernarios, claraboyas y otros vanos traslúcidos o transparentes sobre techo
	public double getEnv3Pt1(Workbook workbook) {
		
		String elementoNombre = "";
		double elementoArea = 0.0;
		double transElemento = 0.0;
		
		double sumSU = 0.0;
		double sumS = 0.0;
		
		FormExcelGetData excelGetData = new FormExcelGetData(workbook);
		excelGetData.setNroHoja(3);
		
		//Tipo de Vidrio/Policarbonato
		//Elemento 1
		elementoNombre = excelGetData.getDataStringColumnAndRow("B","6");
		elementoArea = excelGetData.getDataDecimalFromColumnAndRow("D","6");
		transElemento = Double.parseDouble(vidriosRepository.findByNombreVidrio(elementoNombre).get().getTransmitanciaVidrio());
		sumSU += elementoArea*transElemento; //SxU
		sumS += elementoArea;
		//Elemento 2
		elementoNombre = excelGetData.getDataStringColumnAndRow("B","7");
		elementoArea = excelGetData.getDataDecimalFromColumnAndRow("D","7");
		transElemento = Double.parseDouble(vidriosRepository.findByNombreVidrio(elementoNombre).get().getTransmitanciaVidrio());
		sumSU += elementoArea*transElemento; //SxU
		sumS += elementoArea;
		
		//Tipo de carpintería del marco de ventana
		//Elemento 1
		elementoNombre = excelGetData.getDataStringColumnAndRow("B","10");
		elementoArea = excelGetData.getDataDecimalFromColumnAndRow("E","10");
		transElemento = Double.parseDouble(vidriosRepository.findByNombreVidrio(elementoNombre).get().getTransmitanciaVidrio());
		sumSU += elementoArea*transElemento; //SxU
		sumS += elementoArea;
		//Elemento 2
		elementoNombre = excelGetData.getDataStringColumnAndRow("B","11");
		elementoArea = excelGetData.getDataDecimalFromColumnAndRow("E","11");
		transElemento = Double.parseDouble(vidriosRepository.findByNombreVidrio(elementoNombre).get().getTransmitanciaVidrio());
		sumSU += elementoArea*transElemento; //SxU
		sumS += elementoArea;
		//Elemento 3
		elementoNombre = excelGetData.getDataStringColumnAndRow("B","12");
		elementoArea = excelGetData.getDataDecimalFromColumnAndRow("E","12");
		transElemento = Double.parseDouble(vidriosRepository.findByNombreVidrio(elementoNombre).get().getTransmitanciaVidrio());
		sumSU += elementoArea*transElemento; //SxU
		sumS += elementoArea;
		
		return sumSU/sumS;
	}
	public double getEnv3Pt2(Workbook workbook) {
		String elementoNombre = "";
		double elementoArea = 0.0;
		double transElemento = 0.0;
		
		double sumSU = 0.0;
		double sumS = 0.0;
		
		FormExcelGetData excelGetData = new FormExcelGetData(workbook);
		excelGetData.setNroHoja(3);
		
		//Tipo de Compuerta
		//Elemento 1
		elementoNombre = excelGetData.getDataStringColumnAndRow("B","20");
		elementoArea = excelGetData.getDataDecimalFromColumnAndRow("D","20");
		transElemento = Double.parseDouble(vidriosRepository.findByNombreVidrio(elementoNombre).get().getTransmitanciaVidrio());
		sumSU += elementoArea*transElemento; //SxU
		sumS += elementoArea;
		//Elemento 2
		elementoNombre = excelGetData.getDataStringColumnAndRow("B","21");
		elementoArea = excelGetData.getDataDecimalFromColumnAndRow("D","21");
		transElemento = Double.parseDouble(vidriosRepository.findByNombreVidrio(elementoNombre).get().getTransmitanciaVidrio());
		sumSU += elementoArea*transElemento; //SxU
		sumS += elementoArea;
		//Elemento 3
		elementoNombre = excelGetData.getDataStringColumnAndRow("B","22");
		elementoArea = excelGetData.getDataDecimalFromColumnAndRow("D","22");
		transElemento = Double.parseDouble(vidriosRepository.findByNombreVidrio(elementoNombre).get().getTransmitanciaVidrio());
		sumSU += elementoArea*transElemento; //SxU
		sumS += elementoArea;
		
		return sumSU/sumS;
	}
	public double getEnv3Pt3(Workbook workbook) {
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
		excelGetData.setNroHoja(3);
		
		//ResistenciasSuperficiales
		double rse = excelGetData.getDataDecimalFromColumnAndRow("C","29");
		double rsi = excelGetData.getDataDecimalFromColumnAndRow("C","30");
		
		//TECHO SIN CAMARA DE AIRE
		area = excelGetData.getDataDecimalFromColumnAndRow("D","34");
		sumS += area;
		//Elemento 1
		materialNombre = excelGetData.getDataStringColumnAndRow("B", "34");
		espesor = excelGetData.getDataDecimalFromColumnAndRow("C", "34");
		transmision = Double.parseDouble(materialRepository.findByNombreMaterial(materialNombre).get().getCoeficienteTransmision());
		u1 += espesor/transmision;
		//Elemento 2
		materialNombre = excelGetData.getDataStringColumnAndRow("B", "35");
		espesor = excelGetData.getDataDecimalFromColumnAndRow("C", "35");
		transmision = Double.parseDouble(materialRepository.findByNombreMaterial(materialNombre).get().getCoeficienteTransmision());
		u1 += espesor/transmision;
		//Elemento 3
		materialNombre = excelGetData.getDataStringColumnAndRow("B", "36");
		espesor = excelGetData.getDataDecimalFromColumnAndRow("C", "36");
		transmision = Double.parseDouble(materialRepository.findByNombreMaterial(materialNombre).get().getCoeficienteTransmision());
		u1 += espesor/transmision;
		//Calculo
		u1 += (rsi+rse);
		u1 = 1/u1;
		sumSxU += u1 * area;
		
		//TECHO CON CAMARA DE AIRE
		area = excelGetData.getDataDecimalFromColumnAndRow("D","44");
		sumS += area;
		//Resistencia camara de aire segun espesor
		materialNombre = excelGetData.getDataStringColumnAndRow("B", "41");
		resCamAire = Double.parseDouble(resistenciaRepository.findByNombreResistencia(materialNombre).get().getValorResistencia());
		//Elemento 1
		materialNombre = excelGetData.getDataStringColumnAndRow("B", "44");
		espesor = excelGetData.getDataDecimalFromColumnAndRow("C", "44");
		transmision = Double.parseDouble(materialRepository.findByNombreMaterial(materialNombre).get().getCoeficienteTransmision());
		u2 += espesor/transmision;
		//Elemento 2
		materialNombre = excelGetData.getDataStringColumnAndRow("B", "45");
		espesor = excelGetData.getDataDecimalFromColumnAndRow("C", "45");
		transmision = Double.parseDouble(materialRepository.findByNombreMaterial(materialNombre).get().getCoeficienteTransmision());
		u2 += espesor/transmision;
		//Elemento 3
		materialNombre = excelGetData.getDataStringColumnAndRow("B", "46");
		espesor = excelGetData.getDataDecimalFromColumnAndRow("C", "46");
		transmision = Double.parseDouble(materialRepository.findByNombreMaterial(materialNombre).get().getCoeficienteTransmision());
		u2 += espesor/transmision;
		//Calculo
		u2 += (rsi+rse+resCamAire);
		u2 = 1/u2;
		sumSxU += u1 * area;
		
		return sumSxU/sumS;
	}
}
