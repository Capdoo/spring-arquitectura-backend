package com.arquitectura.app.modules.env1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Env1Service {

	@Autowired
	Env1Repository env1Repository;
	
	public double obtenerTransmitanciaPorTipoSubtipoYNombre(String tipo, String subtipo, String nombre) {
		List<Env1Model> listaTipoYSubtipo = this.obtenerPorTipoYSubtipo(tipo, subtipo);
		Env1Model registroObtenido = this.obtenerPorNombre(nombre, listaTipoYSubtipo);
		return Double.parseDouble(registroObtenido.getTransmitancia());
	}
	
	public List<Env1Model> obtenerPorTipoYSubtipo(String tipo, String subtipo) {
		List<Env1Model> listaEnviar = env1Repository.findAllByTipoAndSubtipo(tipo, subtipo);
		return listaEnviar;
	}
	
	public Env1Model obtenerPorNombre(String nombre, List<Env1Model> listaSeleccionada) {
		Env1Model env1Enviar = new Env1Model();
		for(Env1Model p:listaSeleccionada) {
			if(p.getNombre().equals(nombre)) {
				env1Enviar = p;
			}
		}
		return env1Enviar;
	}
	
}
