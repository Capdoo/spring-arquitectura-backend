package com.arquitectura.app.modules.termico.env1;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface Env1Repository extends JpaRepository<Env1Model, Long>{
	
	public List<Env1Model> findAll();
	public List<Env1Model> findAllByTipo(String tipo);
	public List<Env1Model> findAllByTipoAndSubtipo(String tipo, String subtipo);
}
