package com.servidor.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.servidor.entity.Autor;
import com.servidor.service.AutorService;
import com.servidor.util.AppSettings;

@RestController
@RequestMapping("/url/autor")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class AutorController {

	@Autowired
	private AutorService service;
	
	

	@GetMapping("/listaautor/{nom}")
	@ResponseBody
	public ResponseEntity<List<Autor>> listaDocentePorNombreLike(@PathVariable("nom") String nom) {
		List<Autor> lista  = null;
		try {
			if (nom.equals("todos")) {
				lista = service.listarAutor("%");
			}else {
				lista = service.listarAutor(nom + "%");	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(lista);
	}
	
	
	@PostMapping("/registraautor")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaautor(@RequestBody Autor obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			Autor objSalida =  service.agregaactualiza(obj);
			if (objSalida == null) {
				salida.put("mensaje", AppSettings.MENSAJE_REG_ERROR);
			} else {
				salida.put("mensaje", AppSettings.MENSAJE_REG_EXITOSO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", AppSettings.MENSAJE_REG_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
	
	@PutMapping("/editaautor")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> editaautor(@RequestBody Autor obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			Autor objSalida =  service.agregaactualiza(obj);
			if (objSalida == null) {
				salida.put("mensaje", AppSettings.MENSAJE_ACT_ERROR);
			} else {
				salida.put("mensaje", AppSettings.MENSAJE_ACT_EXITOSO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", AppSettings.MENSAJE_ACT_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
	
	@DeleteMapping("/eliminaautor/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> eliminaautor(@PathVariable ("id")int 	idautor) {
		Map<String, Object> salida = new HashMap<>();
		try {
			  service.eliminaAutor(idautor);
			  salida.put("mensaje", AppSettings.MENSAJE_ELI_EXITOSO);
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", AppSettings.MENSAJE_ELI_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
}
