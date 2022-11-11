package com.servidor.service;

import java.util.List;

import com.servidor.entity.Opcion;
import com.servidor.entity.Rol;
import com.servidor.entity.Usuario;

public interface UsuarioService {

	public abstract Usuario login(Usuario bean);

	public abstract List<Opcion> traerEnlacesDeUsuario(int idUsuario);

	public abstract List<Rol> traerRolesDeUsuario(int idUsuario);

	public abstract Usuario buscaPorLogin(String login);
}
