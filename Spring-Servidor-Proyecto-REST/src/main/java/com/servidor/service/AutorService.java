package com.servidor.service;

import java.util.List;

import com.servidor.entity.Autor;

public interface AutorService {

	public abstract List<Autor> listarAutor(String nombre);
	public abstract Autor agregaactualiza(Autor autor);
	public void eliminaAutor(int cod);
	
}
