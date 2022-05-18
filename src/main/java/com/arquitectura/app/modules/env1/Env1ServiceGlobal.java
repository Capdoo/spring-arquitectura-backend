package com.arquitectura.app.modules.env1;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.arquitectura.app.excel.FormExcelGetData;
import com.arquitectura.app.excel.FormExcelImporter;

@Service
public class Env1ServiceGlobal {

	@Autowired
	Env1Service env1Service;
	
	@Value("${EV1_TIPO_1}")
	String EV1_TIPO_1;
	
	@Value("${EV1_TIPO_2}")
	String EV1_TIPO_2;
	
	
	@Value("${EV1_SUBTIPO_1}")
	String EV1_SUBTIPO_1;
	
	@Value("${EV1_SUBTIPO_2}")
	String EV1_SUBTIPO_2;
	
	@Value("${EV1_SUBTIPO_3}")
	String EV1_SUBTIPO_3;
	
	
	@Value("${file.upload-dir}")
	String FILE_DIRECTORY;
	
	private final static Logger logger = LoggerFactory.getLogger(Env1ServiceGlobal.class);
	
	
	@Autowired
	FormExcelGetData formExcelGetData;
	
	
	public void generalEnv1() {
		
		
		String excelFilePath = FILE_DIRECTORY+"Formulario3.xlsx";
		
		FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream(excelFilePath);
			Workbook workbook = new XSSFWorkbook(fileInputStream);
			
			this.ObtenerTransmitanciaPorArea(workbook);
			
			fileInputStream.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public double ObtenerTransmitanciaPorArea(Workbook workbook) {
		
		String elementoNombre1 = "";
		String elementoNombre2 = "";
		String elementoNombre3 = "";
		
		double elementoArea1 = 0.0;
		double elementoArea2 = 0.0;
		double elementoArea3 = 0.0;
		
		double transElemento1 = 0.0;
		double transElemento2 = 0.0;
		double transElemento3 = 0.0;
		
		double sumSU = 0.0;
		double sumS = 0.0;

		
		FormExcelGetData excelGetData = new FormExcelGetData(workbook);
		
		//1.
			//1.1 Elemento 1
			elementoNombre1 = excelGetData.getDataStringColumnAndRow("B","8");	//Viene de excel
			elementoArea1 = excelGetData.getDataDecimalFromColumnAndRow("D","8");	//Viene de excel
			transElemento1 = env1Service.obtenerTransmitanciaPorTipoSubtipoYNombre(EV1_TIPO_1, 
																				   EV1_SUBTIPO_1, 
																				   elementoNombre1);
			sumSU += elementoArea1*transElemento1; //SxU
			sumS += elementoArea1;
																			
			//1.2 Elemento 2
			elementoNombre2 = excelGetData.getDataStringColumnAndRow("B","9");
			elementoArea2 = excelGetData.getDataDecimalFromColumnAndRow("D","9");
			transElemento2 = env1Service.obtenerTransmitanciaPorTipoSubtipoYNombre(EV1_TIPO_1, 
																				   EV1_SUBTIPO_1, 
																				   elementoNombre2);
			sumSU += elementoArea2*transElemento2; //SxU
			sumS += elementoArea2;

			
		//2.
			//2.1 Elemento 1
			elementoNombre1 = excelGetData.getDataStringColumnAndRow("B","13");
			elementoArea1 = excelGetData.getDataDecimalFromColumnAndRow("E","13");
			transElemento1 = env1Service.obtenerTransmitanciaPorTipoSubtipoYNombre(EV1_TIPO_1, 
																				   EV1_SUBTIPO_2, 
																				   elementoNombre1);
			sumSU += elementoArea1*transElemento1; //SxU
			sumS += elementoArea1;

			//2.2 Elemento 2
			elementoNombre2 = excelGetData.getDataStringColumnAndRow("B","14");
			elementoArea2 = excelGetData.getDataDecimalFromColumnAndRow("E","14");
			transElemento2 = env1Service.obtenerTransmitanciaPorTipoSubtipoYNombre(EV1_TIPO_1, 
																				   EV1_SUBTIPO_2, 
																				   elementoNombre2);
			sumSU += elementoArea2*transElemento2; //SxU
			sumS += elementoArea2;

			elementoNombre3 = excelGetData.getDataStringColumnAndRow("B","15");
			elementoArea3 = excelGetData.getDataDecimalFromColumnAndRow("E","15");
			transElemento3 = env1Service.obtenerTransmitanciaPorTipoSubtipoYNombre(EV1_TIPO_1, 
																				   EV1_SUBTIPO_2, 
																				   elementoNombre3);
			sumSU += elementoArea3*transElemento3; //SxU
			sumS += elementoArea3;

		//3.
			//2.1 Element A
			elementoNombre1 = excelGetData.getDataStringColumnAndRow("B","21");
			elementoArea1 = excelGetData.getDataDecimalFromColumnAndRow("C","21");
			transElemento1 = env1Service.obtenerTransmitanciaPorTipoSubtipoYNombre(EV1_TIPO_2, 
																				   EV1_SUBTIPO_3, 
																				   elementoNombre1);	
			sumSU += elementoArea1*transElemento1; //SxU
			sumS += elementoArea1;

			//2.2 Element B
			elementoNombre2 = excelGetData.getDataStringColumnAndRow("B","22");
			elementoArea2 = excelGetData.getDataDecimalFromColumnAndRow("C","22");
			transElemento2 = env1Service.obtenerTransmitanciaPorTipoSubtipoYNombre(EV1_TIPO_2, 
																				   EV1_SUBTIPO_3, 
																				   elementoNombre2);
			sumSU += elementoArea2*transElemento2; //SxU
			sumS += elementoArea2;

			//2.1 Element A
			elementoNombre3 = excelGetData.getDataStringColumnAndRow("B","23");
			elementoArea3 = excelGetData.getDataDecimalFromColumnAndRow("C","23");
			transElemento3 = env1Service.obtenerTransmitanciaPorTipoSubtipoYNombre(EV1_TIPO_2, 
																				   EV1_SUBTIPO_3, 
																				   elementoNombre3);
			sumSU += elementoArea3*transElemento3; //SxU
			sumS += elementoArea3;

			sumSU = Math.round(sumSU*100.0)/100.0;
		
		//Cerrar file
		logger.info(sumSU+"");
		return 0.0;
	}
	
}




