package com.servidor.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

/**
 * @author Sebastian
 */

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.servidor.entity.Proveedor;
import com.servidor.service.ProveedorService;
import com.servidor.util.AppSettings;

@RestController
@RequestMapping("/url/proveedor")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class ProveedorController {

	@Autowired
	private ProveedorService service;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Proveedor>> listaProveedor(){
		List<Proveedor> lista = service.listarProveedor();
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<?> registro(@Valid @RequestBody Proveedor obj, Errors errors){
		
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
		
		obj.setFechaRegistro(new Date());
		
		Proveedor objSalida = service.registroProveedor(obj);
		
		if (objSalida == null) {
			lisMensajes.add("Error en el registro");
		}else {
			lisMensajes.add("Se registro el proveedor --> " + objSalida.getIdProveedor());
		}
		
		return ResponseEntity.ok(salida);
		
	}
	
	@GetMapping("/consulta")
	@ResponseBody
	public ResponseEntity<List<Proveedor>> consuiltaProveedor(
			@RequestParam(name = "razonsocial", required = false, defaultValue = "") String razonSocial,
			@RequestParam(name = "ruc", required = false, defaultValue = "") String ruc,
			@RequestParam(name = "estado", required = false, defaultValue = "1") int estado,
			@RequestParam(name = "idPais", required = false, defaultValue = "-1") int idPais){
		List<Proveedor> consulta = service.consultarProveedor("%" + razonSocial + "%", ruc, estado, idPais);
		return ResponseEntity.ok(consulta);
	}
	
}
