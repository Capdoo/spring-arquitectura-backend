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
