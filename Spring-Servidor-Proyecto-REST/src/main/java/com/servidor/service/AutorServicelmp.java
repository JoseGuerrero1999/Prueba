package com.servidor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servidor.entity.Autor;
import com.servidor.repository.AutorRepository;

@Service
public class AutorServicelmp implements AutorService{

	@Autowired
	private AutorRepository repo;
	

	@Override
	public void eliminaAutor(int cod) {
		repo.deleteById(cod);
	}

	@Override
	public List<Autor> listarAutor(String nombre) {
		return repo.listaporautor(nombre);
	}

	@Override
	public Autor agregaactualiza(Autor autor) {
		return repo.save(autor);
	}

}
