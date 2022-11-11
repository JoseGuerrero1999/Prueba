package com.servidor.service;

import java.util.List;

import com.servidor.entity.Autor;
import com.servidor.entity.Libro;

public interface LibroService {

	public abstract List<Libro> listarLibro();
	public abstract Libro mergeLibro(Libro bean);
	public abstract void eliminaLibro(int cod);
	
}
