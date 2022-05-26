package com.arquitectura.app.modules.ubicaciones;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UbicacionesRepository extends JpaRepository<UbicacionesModel, Integer>{
	public UbicacionesModel findById(int id);
	public UbicacionesModel findByProvicia(String provincia);
}
