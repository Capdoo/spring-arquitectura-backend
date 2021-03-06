package com.arquitectura.app.modules.ubicaciones;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arquitectura.app.dto.MensajeDTO;
import com.arquitectura.app.dto.StringDTO;

@RestController
@RequestMapping("/ubicaciones")
public class UbicacionesController {
	
	@Autowired
	UbicacionesService ubicacionesService;
	
	@GetMapping("/provincias")
	public ResponseEntity<Object> obtenerProvincias(){
		try {
			List<ProvinciasDTO> listaProvincias = ubicacionesService.obtenerTodasProvincias();
			return new ResponseEntity<Object>(listaProvincias,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(new MensajeDTO("Error:"+e.getMessage()),HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PostMapping("/obtener")
	public ResponseEntity<Object> obtenerUbicacionPorId(@RequestBody StringDTO stringDTO){
		try {
			UbicacionDTO ubicacionElegida = ubicacionesService.obtenerUbicacionPorId(
					Integer.parseInt(stringDTO.getData()));
			return new ResponseEntity<Object>(ubicacionElegida,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(new MensajeDTO("Error:"+e.getMessage()),HttpStatus.BAD_REQUEST);
		}
	}

}
