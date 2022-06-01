package com.arquitectura.app.modules.termico.env3;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arquitectura.app.excel.FormExcelGetData;
import com.arquitectura.app.modules.termico.VidriosRepository;

@Service
public class Env3ServicePart1 {
	@Autowired
	VidriosRepository vidriosRepository;
	
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
		
		
		return 0.0;
	}
}
