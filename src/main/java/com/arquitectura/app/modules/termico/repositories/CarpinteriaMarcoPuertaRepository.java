package com.arquitectura.app.modules.termico.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arquitectura.app.modules.termico.models.CarpinteriaMarcoPuertaModel;

public interface CarpinteriaMarcoPuertaRepository extends JpaRepository<CarpinteriaMarcoPuertaModel, Long>{
	public List<CarpinteriaMarcoPuertaModel> findAll();
	public Optional<CarpinteriaMarcoPuertaModel> findByNombreCarpinteria(String nombreMaterial);
	
}
