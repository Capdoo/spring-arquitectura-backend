package com.arquitectura.app.modules.condensadores;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EdificacionTiRepository extends JpaRepository<EdificacionTiModel, String>{
	public EdificacionTiModel findByTipo(String tipo);
}
