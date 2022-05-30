package com.arquitectura.app.modules.solar;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SolarRepository extends JpaRepository<SolarModel, Integer>{
	public SolarModel findById(int id);
	
}
