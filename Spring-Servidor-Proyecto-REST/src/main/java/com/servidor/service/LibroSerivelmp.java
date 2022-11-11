package com.servidor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servidor.entity.Libro;
import com.servidor.repository.LibrosRepository;

@Service
public class LibroSerivelmp implements LibroService{

	@Autowired
	private LibrosRepository repo;
	
	@Override
	public List<Libro> listarLibro() {
		return repo.findAll();
	}

	@Override
	public Libro mergeLibro(Libro bean) {
		return repo.save(bean);
	}

	@Override
	public void eliminaLibro(int cod) {
		repo.deleteById(cod);	
	}
}
