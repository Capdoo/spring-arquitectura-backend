package com.arquitectura.app.modules.termico.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arquitectura.app.modules.termico.models.VidriosModel;

public interface VidriosRepository extends JpaRepository<VidriosModel, Long>{

	
	public Optional<VidriosModel> findByNombreVidrio(String nombreVidrio);

	
}
