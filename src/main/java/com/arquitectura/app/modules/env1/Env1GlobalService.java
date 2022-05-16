package com.arquitectura.app.modules.env1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Env1GlobalService {

	private static String tipo1 = "VENTANA";
	private static String tipo2 = "PUERTA";

	
	@Autowired
	Env1Service env1Service;
	
	public double ObtenerTransmitanciaPorArea() {
		
		String elementoNombre1 = "";
		String elementoNombre2 = "";
		String elementoNombre3 = "";
		
		double transElemento1 = 0.0;
		double transElemento2 = 0.0;
		double transElemento3 = 0.0;
		
		//1.
		String subtipo1 = "Tipo de vidrio/policarbonato";
		
			//1.1 Elemento 1
			elementoNombre1 = "Sel nombre";
			transElemento1 = env1Service.obtenerTransmitanciaPorTipoSubtipoYNombre(tipo1, subtipo1, elementoNombre1);
			
			//1.2 Elemento 2
			elementoNombre2 = "Sel nombre";
			transElemento2 = env1Service.obtenerTransmitanciaPorTipoSubtipoYNombre(tipo1, subtipo1, elementoNombre2);

		
		//2.
		String subtipo2 = "Tipo de carpintería del marco de ventana";
			//2.1 Elemento 1
			elementoNombre1 = " Sel nombre";
			transElemento1 = env1Service.obtenerTransmitanciaPorTipoSubtipoYNombre(tipo1, subtipo1, elementoNombre1);
			
			//2.2 Elemento 2
			elementoNombre2 = "Sel nombre";
			transElemento2 = env1Service.obtenerTransmitanciaPorTipoSubtipoYNombre(tipo1, subtipo1, elementoNombre2);

		//3.
		String subtipo3 = "Tipo de puerta";

			//2.1 Element A
			String s2_nombreElementA = "Sel nombre";
			double s2_transmitanciaElementA = env1Service.obtenerTransmitanciaPorTipoSubtipoYNombre(tipo1, subtipo1, nombreElementA);
			
			//2.2 Element B
			String s2_nombreElementB = "Sel nombre";
			double s2_transmitanciaElementB = env1Service.obtenerTransmitanciaPorTipoSubtipoYNombre(tipo1, subtipo1, nombreElementB);
	
			//2.1 Element A
			String s2_nombreElementA = "Sel nombre";
			double s2_transmitanciaElementA = env1Service.obtenerTransmitanciaPorTipoSubtipoYNombre(tipo1, subtipo1, nombreElementA);
			

		
		return 0.0;
	}
	
}
