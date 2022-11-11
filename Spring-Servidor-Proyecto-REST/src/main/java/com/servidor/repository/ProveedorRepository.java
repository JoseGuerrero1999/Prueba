package com.servidor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.servidor.entity.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {
 
	@Query("select p from Proveedor p where (p.razonsocial like ?1) and (?2 is '' or p.ruc = ?2) and (?3 is 1 or p.estado = ?3) and (?4 is -1 or p.pais.idPais = ?4)")
	public abstract List<Proveedor> consultaProveedor(String razonSocial, String ruc, int estado, int idPais);
	
}
