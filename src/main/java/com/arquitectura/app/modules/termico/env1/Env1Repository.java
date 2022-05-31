package com.arquitectura.app.modules.termico.env1;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface Env1Repository extends JpaRepository<Env1ModelPart1, Long>{
	
	public List<Env1ModelPart1> findAll();
	public List<Env1ModelPart1> findAllByTipo(String tipo);
	public List<Env1ModelPart1> findAllByTipoAndSubtipo(String tipo, String subtipo);
}
