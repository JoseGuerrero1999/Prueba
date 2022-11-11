package com.servidor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servidor.entity.Categoria;
import com.servidor.repository.CategoriaRepository;

@Service
public class CategoriaServicelmp implements CategoriaService{

	@Autowired
	private CategoriaRepository repo;
	
	@Override
	public List<Categoria> listaCategoria() {
		return repo.findAll();
	}

}
