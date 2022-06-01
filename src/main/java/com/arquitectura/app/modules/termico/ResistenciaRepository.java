package com.arquitectura.app.modules.termico;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ResistenciaRepository extends JpaRepository<ResistenciaModel, Long>{
	public List<ResistenciaModel> findAll();
	public Optional<ResistenciaModel> findByNombreResistencia(String nombreResistencia);
	
	
}
