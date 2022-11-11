package com.servidor.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.servidor.entity.Libro;

public interface LibrosRepository extends JpaRepository<Libro, Integer> {

	//@Query("select L from Libros L where (L.cod_libro like ?1) and (?2 is '' or L.monbre_libro = ?2) and (?3 is 1 or L.precio_libro = ?3) and (?4 is 1 or L.stock_libro = ?4) and (?5 is 1 or L.fechapublicacion_libros = ?5) and (?6 is 1 or L.Categoria.cod_categoria = ?6) and (?7 is -1 or p.Autor.cod_autor = ?7)")
	//public abstract List<Libro> consultaLibros(int cod_libro, String monbre_libro, double precio_libro, int stock_libro, Date fechapublicacion_libros, int cod_categoria, int cod_autor );
}
