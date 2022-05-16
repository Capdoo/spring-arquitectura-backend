package com.arquitectura.app.modules.env1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

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
	
	public double ObtenerTransmitanciaPorArea() {
		
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
		
		//1.
			//1.1 Elemento 1
			elementoNombre1 = "Sel nombre";	//Viene de excel
			elementoArea1 = 0.0;	//Viene de excel
			transElemento1 = env1Service.obtenerTransmitanciaPorTipoSubtipoYNombre(EV1_TIPO_1, 
																				   EV1_SUBTIPO_1, 
																				   elementoNombre1);
			sumSU += elementoArea1*transElemento1; //SxU
			sumS += elementoArea1;
																			
			//1.2 Elemento 2
			elementoNombre2 = "Sel nombre";
			elementoArea2 = 0.0;	//Viene de excel
			transElemento2 = env1Service.obtenerTransmitanciaPorTipoSubtipoYNombre(EV1_TIPO_1, 
																				   EV1_SUBTIPO_1, 
																				   elementoNombre2);
			sumSU += elementoArea2*transElemento2; //SxU
			sumS += elementoArea2;

		//2.
			//2.1 Elemento 1
			elementoNombre1 = " Sel nombre";
			elementoArea1 = 0.0;	//Viene de excel
			transElemento1 = env1Service.obtenerTransmitanciaPorTipoSubtipoYNombre(EV1_TIPO_1, 
																				   EV1_SUBTIPO_2, 
																				   elementoNombre1);
			sumSU += elementoArea1*transElemento1; //SxU
			sumS += elementoArea1;

			//2.2 Elemento 2
			elementoNombre2 = "Sel nombre";
			elementoArea2 = 0.0;	//Viene de excel
			transElemento2 = env1Service.obtenerTransmitanciaPorTipoSubtipoYNombre(EV1_TIPO_1, 
																				   EV1_SUBTIPO_2, 
																				   elementoNombre2);
			sumSU += elementoArea2*transElemento2; //SxU
			sumS += elementoArea2;

			elementoNombre3 = "Sel nombre";
			elementoArea3 = 0.0;	//Viene de excel
			transElemento3 = env1Service.obtenerTransmitanciaPorTipoSubtipoYNombre(EV1_TIPO_1, 
																				   EV1_SUBTIPO_2, 
																				   elementoNombre3);
			sumSU += elementoArea3*transElemento3; //SxU
			sumS += elementoArea3;

		//3.
			//2.1 Element A
			elementoNombre1 = "Sel nombre";
			elementoArea1 = 0.0;	//Viene de excel
			transElemento1 = env1Service.obtenerTransmitanciaPorTipoSubtipoYNombre(EV1_TIPO_2, 
																				   EV1_SUBTIPO_3, 
																				   elementoNombre1);	
			sumSU += elementoArea1*transElemento1; //SxU
			sumS += elementoArea1;

			//2.2 Element B
			elementoNombre2 = "Sel nombre";
			elementoArea2 = 0.0;	//Viene de excel
			transElemento2 = env1Service.obtenerTransmitanciaPorTipoSubtipoYNombre(EV1_TIPO_2, 
																				   EV1_SUBTIPO_3, 
																				   elementoNombre2);
			sumSU += elementoArea2*transElemento2; //SxU
			sumS += elementoArea2;

			//2.1 Element A
			elementoNombre3 = "Sel nombre";
			elementoArea3 = 0.0;	//Viene de excel
			transElemento3 = env1Service.obtenerTransmitanciaPorTipoSubtipoYNombre(EV1_TIPO_2, 
																				   EV1_SUBTIPO_3, 
																				   elementoNombre3);
			sumSU += elementoArea3*transElemento3; //SxU
			sumS += elementoArea3;

		
		return 0.0;
	}
	
}
