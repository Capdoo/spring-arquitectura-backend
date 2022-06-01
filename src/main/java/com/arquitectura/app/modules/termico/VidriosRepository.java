package com.arquitectura.app.modules.termico;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VidriosRepository extends JpaRepository<VidriosModel, Long>{

	
	public Optional<VidriosModel> findByNombreVidrio(String nombreVidrio);

	
}
