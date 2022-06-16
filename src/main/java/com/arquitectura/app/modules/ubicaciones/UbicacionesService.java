package com.arquitectura.app.modules.ubicaciones;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UbicacionesService {
	@Autowired
	UbicacionesRepository ubiRepository;
	
	
	public UbicacionDTO obtenerUbicacionPorId(int id) {
		UbicacionesModel ubicacionSeleccionada = ubiRepository.findById(id);
		UbicacionDTO ubicacionDTO = new UbicacionDTO();
		
		ubicacionDTO.setId(id);
		ubicacionDTO.setDepartamento(ubicacionSeleccionada.getDepartamento());
		ubicacionDTO.setNumeroZona(ubicacionSeleccionada.getN_estacion());
		ubicacionDTO.setZonaBioclimatica(ubicacionSeleccionada.getZona_clim());
		ubicacionDTO.setEstacionReferencial(ubicacionSeleccionada.getN_estacion());
		
		return ubicacionDTO;
	}
	
	public List<ProvinciasDTO> obtenerTodasProvincias() {
		List<ProvinciasDTO> listaEnviar = new ArrayList<ProvinciasDTO>();
	
		List<UbicacionesModel> listaGeneral = ubiRepository.findAll();

		for(UbicacionesModel p: listaGeneral) {
			ProvinciasDTO provinciasDTO = new ProvinciasDTO();
				provinciasDTO.setId(p.getId());
				provinciasDTO.setNombreProvincia(p.getProvincia());
			listaEnviar.add(provinciasDTO);
		}
		return listaEnviar;
	}
	
	
	
	public int obtenerIdPorProvincia(String provincia) {
		UbicacionesModel ubi = ubiRepository.findByProvincia(provincia);
		return ubi.getId();
	}
	
	public int obtenerNumeroZona(int id) {
		return ubiRepository.findById(id).getN_zona();
	}
	
	
}
