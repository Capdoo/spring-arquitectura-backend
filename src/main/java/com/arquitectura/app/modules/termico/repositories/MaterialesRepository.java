package com.arquitectura.app.modules.termico.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arquitectura.app.modules.termico.env1.Env1ModelPart1;
import com.arquitectura.app.modules.termico.models.MaterialesModel;

public interface MaterialesRepository extends JpaRepository<MaterialesModel, Long>{
	public List<MaterialesModel> findAll();
	public Optional<MaterialesModel> findByNombreMaterial(String nombreMaterial);
}
