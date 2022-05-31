package com.arquitectura.app.modules.termico;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arquitectura.app.modules.termico.env1.Env1ModelPart1;

public interface MaterialesRepository extends JpaRepository<Materiales, Long>{
	public List<Materiales> findAll();
	public Optional<Materiales> findByNombreMaterial(String nombreMaterial);
}
