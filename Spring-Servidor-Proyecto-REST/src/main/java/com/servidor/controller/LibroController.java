package com.servidor.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
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
import com.servidor.entity.Categoria;
import com.servidor.entity.Libro;
import com.servidor.entity.Proveedor;
import com.servidor.service.AutorService;
import com.servidor.service.CategoriaService;
import com.servidor.service.LibroService;
import com.servidor.util.AppSettings;

@RestController
@RequestMapping("/url/libro")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class LibroController {

	@Autowired
	private LibroService service;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Libro>> listaLibros(){
		List<Libro> lista = service.listarLibro();
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping("/registro")
	@ResponseBody
	public ResponseEntity<?> registro(@Valid @RequestBody Libro obj, Errors errors){
		
		HashMap<String, Object> salida = new HashMap<>();
		
		List<String> lisMensajes = new ArrayList<String>();
		
		salida.put("errores", lisMensajes);
		
		List<ObjectError> listError = errors.getAllErrors();
		
		for(ObjectError objectError : listError) {
			objectError.getDefaultMessage();
			lisMensajes.add(objectError.getDefaultMessage());
		}
		
		if (!CollectionUtils.isEmpty(lisMensajes)) {
			return ResponseEntity.ok(salida);
		}
		
		Libro objSalida = service.mergeLibro(obj);
		
		if (objSalida == null) {
			lisMensajes.add("Error en el registro");
		}else {
			lisMensajes.add("Se registro el libro --> " + objSalida.getCod_libro());
		}
		
		return ResponseEntity.ok(salida);
		
	}
	
	@PutMapping("/actualiza")
	@ResponseBody
	public ResponseEntity<?> actualizar(@Valid @RequestBody Libro obj, Errors errors){
		
		HashMap<String, Object> salida = new HashMap<>();
		
		List<String> lisMensajes = new ArrayList<String>();
		
		salida.put("errores", lisMensajes);
		
		List<ObjectError> listError = errors.getAllErrors();
		
		for(ObjectError objectError : listError) {
			objectError.getDefaultMessage();
			lisMensajes.add(objectError.getDefaultMessage());
		}
		
		if (!CollectionUtils.isEmpty(lisMensajes)) {
			return ResponseEntity.ok(salida);
		}
		
		Libro objSalida = service.mergeLibro(obj);
		
		if (objSalida == null) {
			lisMensajes.add("Error en el registro");
		}else {
			lisMensajes.add("Se actualizo el libro --> " + objSalida.getCod_libro());
		}
		
		return ResponseEntity.ok(salida);
		
	}
	
	@DeleteMapping("/elimina/{cod}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> eliminaDocente(@PathVariable("cod") int cod) {
		Map<String, Object> salida = new HashMap<>();
		List<String> lisMensajes = new ArrayList<String>();
		salida.put("errores", lisMensajes);
		try {
			service.eliminaLibro(cod);
			lisMensajes.add("Se elimino el libro");
		} catch (Exception e) {
			e.printStackTrace();
			lisMensajes.add("Error al eliminar");
		}
		return ResponseEntity.ok(salida);
	}
	
}
