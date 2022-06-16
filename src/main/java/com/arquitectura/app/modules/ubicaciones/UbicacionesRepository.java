package com.arquitectura.app.modules.ubicaciones;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UbicacionesRepository extends JpaRepository<UbicacionesModel, Integer>{
	public UbicacionesModel findById(int id);
	public UbicacionesModel findByProvincia(String provincia);
	
	public List<UbicacionesModel> findAll();
}
