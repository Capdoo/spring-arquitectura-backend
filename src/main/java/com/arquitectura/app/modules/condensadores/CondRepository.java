package com.arquitectura.app.modules.condensadores;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CondRepository extends JpaRepository<CondModel, Integer>{
	public CondModel findByZona(int zona);
}
