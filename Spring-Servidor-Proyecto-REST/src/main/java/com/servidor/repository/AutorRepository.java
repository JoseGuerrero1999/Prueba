package com.servidor.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.servidor.entity.Autor;
@Repository
public interface AutorRepository extends JpaRepository<Autor, Integer>{

	@Query("select x from Autor x where x.nombre_autor like ?1")
	public List<Autor> listaporautor(String nombre);
}
