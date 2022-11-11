package com.servidor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.servidor.entity.Categoria;

public interface CategoriaRepository  extends JpaRepository<Categoria, Integer>{

	//@Query("select c from Categoria c where (c.cod_categoria like ?1) and (?2 is '' or c.des_categoria = ?2)")
	//public abstract List<Categoria> consultaCategoria(int cod_categoria, String des_categoria);
}
