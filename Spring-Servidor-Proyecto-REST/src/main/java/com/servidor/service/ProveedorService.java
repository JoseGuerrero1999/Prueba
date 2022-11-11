package com.servidor.service;

import java.util.List;

import com.servidor.entity.Proveedor;

public interface ProveedorService {

	public abstract List<Proveedor> listarProveedor();
	public abstract Proveedor registroProveedor(Proveedor obj);
	public abstract List<Proveedor> consultarProveedor(String razonSocial, String ruc, int estado, int idPais);
	
}
