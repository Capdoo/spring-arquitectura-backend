package com.arquitectura.app.modules.env1;

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
@RequestMapping("/envolvente1")
public class Env1Controller {

	@Autowired
	Env1Service env1Service;
	
	
	@PostMapping("/obtenerTransmitancia")
	public ResponseEntity<Object> obtener(@RequestBody StringDTO stringDTO){
		String tipo = "VENTANA";
		String subtipo = "Tipo de vidrio/policarbonato";
		try {
			List<Env1Model> listaBusqueda = env1Service.obtenerPorTipoYSubtipo(tipo, subtipo);
			Env1Model obtenido = env1Service.obtenerPorNombre(stringDTO.getData(), listaBusqueda);
			return new ResponseEntity<Object>(new StringDTO(obtenido.getTransmitancia()+""), HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<Object>(new MensajeDTO("Hubo un problema"), HttpStatus.BAD_REQUEST);
		}
		
	}
}
