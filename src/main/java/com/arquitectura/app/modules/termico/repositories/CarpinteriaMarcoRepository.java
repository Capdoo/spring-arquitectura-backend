package com.arquitectura.app.modules.termico.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arquitectura.app.modules.termico.models.CarpinteriaMarcoModel;

public interface CarpinteriaMarcoRepository extends JpaRepository<CarpinteriaMarcoModel, Long>{
	public List<CarpinteriaMarcoModel> findAll();
	public Optional<CarpinteriaMarcoModel> findByNombreCarpinteria(String nombreMaterial);
	
}
