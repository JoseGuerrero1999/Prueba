package com.servidor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servidor.entity.Proveedor;
import com.servidor.repository.ProveedorRepository;

@Service
public class ProveedorServicelmp implements ProveedorService{

	@Autowired
	private ProveedorRepository repository;
	
	@Override
	public Proveedor registroProveedor(Proveedor obj) {
		return repository.save(obj);
	}

	@Override
	public List<Proveedor> listarProveedor() {
		return repository.findAll();
	}

	@Override
	public List<Proveedor> consultarProveedor(String razonSocial, String ruc, int estado, int idPais) {
		return repository.consultaProveedor(razonSocial, ruc, estado, idPais);
	}

}
