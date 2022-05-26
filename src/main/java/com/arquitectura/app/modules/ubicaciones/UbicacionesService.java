package com.arquitectura.app.modules.ubicaciones;

import org.springframework.beans.factory.annotation.Autowired;

public class UbicacionesService {
	@Autowired
	UbicacionesRepository ubiRepository;
	
	public int obtenerIdPorProvincia(String provincia) {
		UbicacionesModel ubi = ubiRepository.findByProvicia(provincia);
		return ubi.getId();
	}
	
	public int obtenerNumeroZona(int id) {
		return ubiRepository.findById(id).getN_zona();
	}
}
