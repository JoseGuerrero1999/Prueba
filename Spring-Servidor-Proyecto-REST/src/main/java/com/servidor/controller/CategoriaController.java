package com.servidor.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.servidor.entity.Categoria;
import com.servidor.service.CategoriaService;
import com.servidor.util.AppSettings;

@RestController
@RequestMapping("/url/categoria")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class CategoriaController {

	@Autowired
	private CategoriaService service;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Categoria>> listaCategorias(){
		List<Categoria> lista = service.listaCategoria();
		return ResponseEntity.ok(lista);
	}
	
}
