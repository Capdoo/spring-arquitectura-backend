package com.arquitectura.app.modules.termico.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arquitectura.app.modules.termico.models.ResistenciaModel;

public interface ResistenciaRepository extends JpaRepository<ResistenciaModel, Long>{
	public List<ResistenciaModel> findAll();
	public Optional<ResistenciaModel> findByNombreResistencia(String nombreResistencia);
	
	
}
