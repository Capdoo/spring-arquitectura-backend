package com.arquitectura.app.modules.termico.env1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Env1ServiceToBD {

	@Autowired
	Env1Repository env1Repository;
	
	public double obtenerTransmitanciaPorTipoSubtipoYNombre(String tipo, String subtipo, String nombre) {
		List<Env1ModelPart1> listaTipoYSubtipo = this.obtenerPorTipoYSubtipo(tipo, subtipo);
		Env1ModelPart1 registroObtenido = this.obtenerPorNombre(nombre, listaTipoYSubtipo);
		return Double.parseDouble(registroObtenido.getTransmitancia());
	}
	
	public List<Env1ModelPart1> obtenerPorTipoYSubtipo(String tipo, String subtipo) {
		List<Env1ModelPart1> listaEnviar = env1Repository.findAllByTipoAndSubtipo(tipo, subtipo);
		return listaEnviar;
	}
	
	public Env1ModelPart1 obtenerPorNombre(String nombre, List<Env1ModelPart1> listaSeleccionada) {
		Env1ModelPart1 env1Enviar = new Env1ModelPart1();
		for(Env1ModelPart1 p:listaSeleccionada) {
			if(p.getNombre().equals(nombre)) {
				env1Enviar = p;
			}
		}
		return env1Enviar;
	}
	
}
